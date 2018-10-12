package fr.cmm.controller.form;

public class SearchForm {
    private String tag;

    // 1 based page index
    private int pageIndex = 1;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getPageIndex() {
            return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex > 0)
            this.pageIndex = pageIndex;
        else
            this.pageIndex = 1;
    }
}
