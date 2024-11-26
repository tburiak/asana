package org.tbur.pom;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected Page page;

    public void initPage(final Page page) {
        this.page = page;
    }

    public abstract void initElements();

}