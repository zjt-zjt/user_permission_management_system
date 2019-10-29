package com.lanou.upms.service;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Purview;

import java.util.List;

public interface PurviewService {

    List<Purview> queryBooks(Purview condition);

    LayUITableData<Purview> queryRights(Object o, Integer pageSize, Integer currentPage);

    int addPurview(String purviewName, String url, Integer parentId);

    int delPurview(Integer purviewId);

    int editPurview( Integer purviewId, String purviewName, String url, Integer parentId);
}
