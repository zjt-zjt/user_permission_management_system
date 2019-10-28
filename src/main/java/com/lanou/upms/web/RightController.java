package com.lanou.upms.web;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Purview;
import com.lanou.upms.service.PurviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/right")
public class RightController {

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

}
