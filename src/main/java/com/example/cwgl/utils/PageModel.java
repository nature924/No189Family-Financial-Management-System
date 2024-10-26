package com.example.cwgl.utils;

public class PageModel<T> {

    private int beginIndex;
    private int currentPageNo;
    private int pageSize = 20;
    private T data;

    public PageModel(int currentPageNo, T data) {
        if (currentPageNo < 1) {
            throw new IllegalArgumentException("currentPageNo can not less than one");
        } else {
            this.currentPageNo = currentPageNo;
            this.data = data;
        }
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getBeginIndex() {
        return beginIndex = (currentPageNo - 1) * pageSize;
    }

    @Override
    public String toString() {
        return "PageModel{" +
                "beginIndex=" + beginIndex +
                ", currentPageNo=" + currentPageNo +
                ", pageSize=" + pageSize +
                ", data=" + data +
                '}';
    }
}
