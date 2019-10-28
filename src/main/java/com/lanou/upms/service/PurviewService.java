package com.lanou.upms.service;

import com.lanou.upms.bean.LayUITableData;
import com.lanou.upms.bean.Purview;

import java.util.List;

public interface PurviewService {

    List<Purview> queryBooks(Purview condition);

    LayUITableData<Purview> queryRights(Object o, Integer pageSize, Integer currentPage);

}
