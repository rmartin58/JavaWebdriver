package hover;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTests {

    @Test
    public void testHover() {
        HoversPage hoversPage = homePage.clickHovers();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
