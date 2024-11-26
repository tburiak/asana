package ui;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.tbur.pom.BasePage;
import org.tbur.pom.PageFactory;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public abstract class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected BrowserContext context;
    protected Page page;

    @BeforeAll
    public void createPlaywrightBrowserInstances() {
        playwright = Playwright.create();
        browser = playwright.chromium()
                .launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    protected void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterEach
    protected void closeContext() {
        context.close();
    }

    @AfterAll
    public void tearDown() {
        if (browser != null) browser.close();
        playwright.close();
    }

    protected <T extends BasePage> T at(Class<T> basePage) {
        return PageFactory.createInstance(page, basePage);
    }

}
