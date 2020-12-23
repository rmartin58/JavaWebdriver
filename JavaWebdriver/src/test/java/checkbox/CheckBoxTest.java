package checkbox;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

public class CheckBoxTest extends BaseTests {

    @Test
    public void testCheckBox1() {
        CheckBoxPage checkBoxPage = homePage.clickCheckBox();

        Assert.assertEquals(checkBoxPage.getCheckBoxes().size(),2);
    }
}