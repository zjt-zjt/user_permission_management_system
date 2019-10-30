package com.lanou.upms.service.impl;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Purview;
import com.lanou.upms.bean.PurviewExample;
import com.lanou.upms.mapper.PurviewMapper;
import com.lanou.upms.service.PurviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurviewServiceImpl implements PurviewService {

    private List<Purview> rightCache = null;

    @Autowired
    private PurviewMapper purviewMapper;

    @Override
    public List<Purview> queryBooks(Purview condition) {
        PurviewExample purviewExample = new PurviewExample();
        PurviewExample.Criteria criteria = purviewExample.createCriteria();
        /*if (condition != null) {
            if (condition.getRightId() != null) {
                criteria.andRightIdIsNotNull();
            }
            if (condition.getRightName() != null) {
                criteria.andRightNameLike(condition.getRightName());
            }
            if (condition.getUrl() != null) {
                criteria.andUrlLike(condition.getUrl());
            }
        }*/
        return purviewMapper.selectByExample(purviewExample);
    }

    @Override
    public LayUITableData<Purview> queryRights(Object o, Integer pageSize, Integer currentPage) {
        if (rightCache == null) {
            rightCache = queryBooks(null);
        }

        int startIdx = (currentPage - 1) * pageSize;
        int endIdx = currentPage * pageSize;
        if(endIdx > rightCache.size()) {
            endIdx = rightCache.size();
        }

        List<Purview> currentPageData = rightCache.subList(startIdx, endIdx);

        LayUITableData<Purview> retData = new LayUITableData<>();
        retData.setCode(0);
        retData.setCount((long)(rightCache.size()));
        retData.setMsg("查询成功");
        retData.setData(currentPageData);
        return retData;
    }

    @Override
    public int addPurview(String purviewName, String url, Integer parentId) {
        /*PurviewExample purviewExample = new PurviewExample();
        PurviewExample.Criteria criteria = purviewExample.createCriteria();
        if (purviewName != null) {
            criteria.andPurviewNameEqualTo(purviewName);
        }
        if (url != null) {
            criteria.andUrlEqualTo(url);
        }
        if (parentId != null) {
            criteria.andTypeEqualTo(parentId);
        }*/

        Purview purview = new Purview();
        purview.setPurviewName(purviewName);
        purview.setUrl(url);
        purview.setParentId(parentId);
        purviewMapper.insert(purview);
        System.out.println("=========== parentId：" + parentId + ", purviewName：" + purviewName + ", url：" + url);
        rightCache = null;
        return 1;
    }

    @Override
    public int delPurview(Integer purviewId) {
        purviewMapper.deleteByPrimaryKey(purviewId);
        return 1;

    }

    @Override
    public int editPurview(Integer purviewId, String purviewName, String url, Integer parentId) {
        Purview purview = new Purview();
        purview.setPurviewId(purviewId);
        purview.setPurviewName(purviewName);
        purview.setUrl(url);
        purview.setParentId(parentId);

        PurviewExample purviewExample = new PurviewExample();
        PurviewExample.Criteria criteria = purviewExample.createCriteria();
        /*if (purviewName != null) {
            criteria.andPurviewNameEqualTo(purviewName);
        }*/
        criteria.andPurviewIdEqualTo(purviewId);

        purviewMapper.updateByExample(purview, purviewExample);
        rightCache = null;
        return 1;
    }
}
