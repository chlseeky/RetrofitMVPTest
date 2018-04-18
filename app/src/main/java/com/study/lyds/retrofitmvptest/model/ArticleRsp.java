package com.study.lyds.retrofitmvptest.model;

import java.util.List;

/**
 * Created by Administrator on 2017/10/11.
 */

public class ArticleRsp {
    private Result result;
    private String targetUrl;
    private boolean success;
    private boolean unAuthorizedRequest;
    private boolean __xj;
    private Error error;

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__xj() {
        return __xj;
    }

    public void set__xj(boolean __xj) {
        this.__xj = __xj;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public class Result{
        private int  totalCount;
        private List<ArticleItem> items;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public List<ArticleItem> getItems() {
            return items;
        }

        public void setItems(List<ArticleItem> items) {
            this.items = items;
        }

        @Override
        public String toString() {
            return "Result{" +
                    "totalCount=" + totalCount +
                    ", items=" + items +
                    '}';
        }
    }

    public class Error{
        private int code;
        private String message;
        private String details;
//        private String validationErrors;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }

        @Override
        public String toString() {
            return "Error{" +
                    "code=" + code +
                    ", message='" + message + '\'' +
                    ", details='" + details + '\'' +
//                    ", validationErrors='" + validationErrors + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "CommonRsp{" +
                "result=" + result +
                ", targetUrl='" + targetUrl + '\'' +
                ", success=" + success +
                ", unAuthorizedRequest=" + unAuthorizedRequest +
                ", __xj=" + __xj +
                ", error=" + error +
                '}';
    }
}
