package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUpLoadPage;
import pages.FileDownLoadPage;

import static org.testng.Assert.assertEquals;

public class FileIOTests extends BaseTests {

    private String filePath = "/Users/rickmartin/src/Java/JavaWebdriver/JavaWebdriver/resources/";
    private String fileName = "sample.json";
    @Test
    public void shouldBeAbleToDoFileIO() {
        logger.info(System.getProperty("user.dir"));

        logger.debug(FileIOTests.class.getName() + ".testFileUpload");

        FileUpLoadPage fileUpLoadPage = homePage.clickFileUpload();

        fileUpLoadPage.uploadFile(filePath+fileName);

        assertEquals(fileUpLoadPage.getUploadedFiles(), fileName, "Uploaded files incorrect");

        goHome();
        FileDownLoadPage fileDownLoadPage = homePage.clickFileDownLoad();

        fileDownLoadPage.clickLink(fileName);

    }
}
