package com.study.lyds.retrofitmvptest.model;

/**
 * Created by Administrator on 2017/10/11.
 */

public class ArticleReq {
    private int id;
    private int typeId;
    private int categoryId;
    private String searchName;
    private int page;
    private int rows;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "ArticleReq{" +
                "id=" + id +
                ", typeId=" + typeId +
                ", categoryId=" + categoryId +
                ", searchName='" + searchName + '\'' +
                ", page=" + page +
                ", rows=" + rows +
                '}';
    }
}
