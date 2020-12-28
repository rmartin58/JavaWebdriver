package checkbox;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckBoxPage;

import java.util.Arrays;
import java.util.List;

public class CheckBoxTest extends BaseTests {

    @Test
    public void testCheckBoxByIndex() {
        CheckBoxPage checkBoxPage = homePage.clickCheckBox();

        Assert.assertEquals(checkBoxPage.getCheckBoxes().size(),2);

        Assert.assertFalse(checkBoxPage.getCheckBoxByIndex(1).isSelected());
        Assert.assertTrue(checkBoxPage.getCheckBoxByIndex(2).isSelected());

        checkBoxPage.checkCheckBoxByIndex(1);
        checkBoxPage.uncheckCheckBoxByIndex(2);

        Assert.assertFalse(checkBoxPage.getCheckBoxByIndex(2).isSelected());
        Assert.assertTrue(checkBoxPage.getCheckBoxByIndex(1).isSelected());
    }

    @Test
    public void testCheckBoxByLabel() {
        CheckBoxPage checkBoxPage = homePage.clickCheckBox();

        String checkBoxLabels = checkBoxPage.getCheckBoxByLabel("checkbox 1");
        String[] cbLabels = checkBoxLabels.split("<br>");

        System.out.println(Arrays.toString(cbLabels));
    }
}