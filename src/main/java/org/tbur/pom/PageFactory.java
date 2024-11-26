package org.tbur.pom;

import com.microsoft.playwright.Page;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PageFactory {

    public static <T extends BasePage> T createInstance(final Page page, final Class<T> clazz) {
        try {
            BasePage instance = clazz.getDeclaredConstructor().newInstance();
            instance.initPage(page);
            instance.initElements();
            return clazz.cast(instance);
        } catch (Exception e) {
            throw new IllegalArgumentException("Page class instantiation failed.");
        }
    }
}
