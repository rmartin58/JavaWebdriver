package hover;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HoversPage;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        logger.debug(HoverTests.class.getName() + ".testHoverUser1");

        HoversPage hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        Assert.assertTrue(caption.isCaptionDisplayed());
        Assert.assertTrue(caption.getLink().endsWith("/users/1"));
        Assert.assertEquals(caption.getTitle(), "name: user1");
        Assert.assertEquals(caption.getLinkText(), "View profile");
    }
}
