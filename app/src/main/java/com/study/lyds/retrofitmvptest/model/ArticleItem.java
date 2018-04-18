package com.study.lyds.retrofitmvptest.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/11.
 */

public class ArticleItem implements Serializable{
    private String typeId;
    private String title;
    private boolean isHref;
    private String contents;
    private String imageURL;
    private int sort;
    private boolean isShow;
    private String author;
    private String keyword;
    private String describe;
    private String creationTime;
    private int creatorUserId;
    private int id;

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isHref() {
        return isHref;
    }

    public void setHref(boolean href) {
        isHref = href;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isShow() {
        return isShow;
    }

    public void setShow(boolean show) {
        isShow = show;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getCreatorUserId() {
        return creatorUserId;
    }

    public void setCreatorUserId(int creatorUserId) {
        this.creatorUserId = creatorUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ArticleItem{" +
                "typeId='" + typeId + '\'' +
                ", title='" + title + '\'' +
                ", isHref=" + isHref +
                ", contents='" + contents + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", sort=" + sort +
                ", isShow=" + isShow +
                ", author='" + author + '\'' +
                ", keyword='" + keyword + '\'' +
                ", describe='" + describe + '\'' +
                ", creationTime='" + creationTime + '\'' +
                ", creatorUserId=" + creatorUserId +
                ", id=" + id +
                '}';
    }
}
