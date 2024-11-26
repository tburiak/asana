package org.tbur.pom;

import com.microsoft.playwright.Locator;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.tbur.utils.StringUtils.toNonBreakingSpace;

public class MainPage extends BasePage{

    private Function<String, Locator> boardColumn;
    private BiFunction<String, String, Locator> columnTask;

    @Override
    public void initElements() {
        boardColumn = column ->
                page.locator(format("//div[div/h3[contains(.,'%s')]]", toNonBreakingSpace(column)));
        columnTask = (taskName, tag) ->
                page.locator(format("//div[*[normalize-space(.)='%s']]//span[normalize-space(.)='%s']", taskName, tag));
    }

    public MainPage navigateToProject(String projectName) {
        page.click("text=" + projectName);
        return this;
    }

    public MainPage verifyTask(String column, String taskName, List<String> tags) {
        boardColumn.apply(column).waitFor();
        tags.forEach(tag -> assertTrue(boardColumn.apply(column)
                .locator(columnTask.apply(taskName, tag)).isVisible(),
                format("Task '%s' with tag '%s' not found in column '%s'", taskName, tag, column)));
       return this;
    }
}
