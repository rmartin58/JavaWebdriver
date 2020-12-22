package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {

    @Test
    public void testSelectOption() {
        var dropDownPage =homePage.clickDropDown();
        String option1 = "Option 1";
        String option2 = "Option 2";

        dropDownPage.selectFromDropDown(option1);
        var selectedOptions= dropDownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), "Selected option is incorrect");
        assertFalse(selectedOptions.contains(option2), "Selected option contains extraneous selection");
    }
}
