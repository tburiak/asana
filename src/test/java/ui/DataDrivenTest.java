package ui;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.tbur.pom.LoginPage;
import org.tbur.pom.MainPage;
import org.tbur.utils.TestDataLoader;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.DynamicTest.dynamicTest;

class DataDrivenTest extends BaseTest {

    private static final String TEST_DATA_FILEPATH = "src/test/resources/testdata.json";

    @TestFactory
    Stream<DynamicTest> testCases() {
        List<TestDataLoader.TestData> testData = TestDataLoader.loadTestData(TEST_DATA_FILEPATH);
        at(LoginPage.class).login();
        return testData.stream().map(data ->
                dynamicTest(data.getTestCaseName(), () ->
                        at(MainPage.class)
                        .navigateToProject(data.getProject())
                        .verifyTask(data.getColumn(), data.getTaskName(), data.getTags()))
        );
    }

}
