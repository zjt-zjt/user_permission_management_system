package com.lanou.upms.bean;

public class Purview {
    private Integer purviewId;

    private Integer parentId;

    private String purviewName;

    private String url;

    private String type;

    private Integer orderNum;

    public Integer getPurviewId() {
        return purviewId;
    }

    public void setPurviewId(Integer purviewId) {
        this.purviewId = purviewId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPurviewName() {
        return purviewName;
    }

    public void setPurviewName(String purviewName) {
        this.purviewName = purviewName == null ? null : purviewName.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}