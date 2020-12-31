package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileDownLoadPage;

public class FileDownloadTests extends BaseTests {

    @Test
    public void testFileDownLoad() {
        logger.debug(FileDownloadTests.class.getName() + ".testFileDownLoad");
        FileDownLoadPage fileDownLoadPage = homePage.clickFileDownLoad();

        fileDownLoadPage.clickLink("text.txt");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
