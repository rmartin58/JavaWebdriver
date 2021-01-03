package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void shouldDisplayAlert() {
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.triggerHotSpot();
        assertEquals(contextMenuPage.alert_getText(), "You selected a context menu");
        contextMenuPage.alert_clickToAccept();
    }
}
