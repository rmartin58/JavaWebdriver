package checkbox;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

import java.util.List;

public class CheckBoxTest extends BaseTests {

    @Test
    public void shouldBeAbleToCheckBoxByIndex() {
        CheckBoxPage checkBoxPage = homePage.clickCheckBox();

        List<WebElement> checkBoxList = checkBoxPage.getCheckBoxes();
        Assert.assertEquals(checkBoxList.size(),2);

        Assert.assertFalse(checkBoxPage.getCheckBoxByIndex(1).isSelected());
        Assert.assertTrue(checkBoxPage.getCheckBoxByIndex(2).isSelected());

        checkBoxPage.checkCheckBoxByIndex(1);
        checkBoxPage.uncheckCheckBoxByIndex(2);

        Assert.assertFalse(checkBoxPage.getCheckBoxByIndex(2).isSelected());
        Assert.assertTrue(checkBoxPage.getCheckBoxByIndex(1).isSelected());
    }

    @Test
    public void shouldBeAbleToCheckBoxByLabel() {
        CheckBoxPage checkBoxPage = homePage.clickCheckBox();

        String checkBoxLabels = checkBoxPage.getCheckBoxByLabel("checkbox 1");
    }
}