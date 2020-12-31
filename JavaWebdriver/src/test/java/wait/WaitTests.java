package wait;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    private String expected = "Hello World!";
    private String errorMsg = "Loaded text incorrect";
    @Test
    public void shouldWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartWaitForInvisible();
        assertEquals(loadingPage.getLoadedText(), expected, errorMsg);
    }

    @Test
    public void shouldWaitUntilVisible(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStartWaitForVisible();
        assertEquals(loadingPage.getLoadedText(), expected, errorMsg);
    }
    @Test
    public void shouldWaitUntilPresent() {
        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStartWaitForPresence();
        assertEquals(loadingPage.getLoadedText(), expected, errorMsg);
    }
}