package com.lanou.upms.web;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Purview;
import com.lanou.upms.bean.ResponseInfo;
import com.lanou.upms.service.PurviewService;
import org.apache.ibatis.javassist.compiler.Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/right")
public class RightController {

    private static ResponseInfo ret = new ResponseInfo();
    @Autowired
    private PurviewService purviewService;

    @RequestMapping("/list")
    public LayUITableData<Purview> queryRights(Model model,
                                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer currentPage,
                                               @RequestParam(value = "limit", required = false, defaultValue = "10") Integer pageSize,
                                               @RequestParam(required = false) Purview condition) {

        // TODO 返回图书信息JSON数据，给前端的LayUI表格组件使用
        System.out.println((purviewService.queryRights(null, pageSize, currentPage)).toString());
        return purviewService.queryRights(null, pageSize, currentPage);
    }
    @RequestMapping("/jsp/add")
    public ResponseInfo addPurview(HttpServletRequest req, HttpServletResponse resp) {
        String parentIdStr = req.getParameter("parentId");
        int parentId = Integer.parseInt(parentIdStr);
        String purviewName = req.getParameter("purviewName");
        String url = req.getParameter("purviewURL");

        System.out.println("=======++++++++========");
        System.out.println("parentId：" + parentId + ", purviewName：" + purviewName + ", url：" + url);

        int i = purviewService.addPurview(purviewName, url, parentId);

        if (i != 1) {
            ret.setCode(909);
            ret.setMessage("添加权限失败!");
            return ret;
        }

        ret.setCode(200);
        ret.setMessage("添加权限成功!");
        return ret;

    }


    @RequestMapping("/jsp/delpurview")
    public ResponseInfo delPurview(HttpServletRequest req, HttpServletResponse resp) {
        Integer purviewId = Integer.parseInt(req.getParameter("id"));
        int i = purviewService.delPurview(purviewId);
        if (i != 1) {
            ret.setCode(969);
            ret.setMessage("删除权限失败!");
            return ret;
        }

        ret.setCode(200);
        ret.setMessage("删除权限成功!");
        return ret;
    }

    @RequestMapping("/jsp/editpurview")
    public ResponseInfo editPurview(HttpServletRequest req, HttpServletResponse resp) {
        Integer parentId = Integer.parseInt(req.getParameter("parentId"));
        Integer purviewId = Integer.parseInt(req.getParameter("purviewId"));
        String purviewName = req.getParameter("purviewName");
        String url = req.getParameter("purviewURL");

        System.out.println("=======++++++++========");
        System.out.println("parentId：" + parentId + ", purviewId" + purviewId + ", purviewName：" + purviewName + ", url：" + url);

        int i = purviewService.editPurview(purviewId, purviewName, url, parentId);

        if (i != 1) {
            ret.setCode(909);
            ret.setMessage("修改权限失败!");
            return ret;
        }

        ret.setCode(200);
        ret.setMessage("修改权限成功!");
        return ret;

    }

    @RequestMapping("/jsp/showPurviewList")
    public Map<Object, Object> showPurviewList(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("开始查询下拉列表权限.....");
        List<Purview> purviews = purviewService.queryBooks(null);
        Map<Object, Object> map = new HashMap<>();
        map.put("data", purviews);
        return map;
    }

}
