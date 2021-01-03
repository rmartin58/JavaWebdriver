package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileDownLoadPage;
import pages.FileUpLoadPage;

import static org.testng.Assert.assertEquals;

public class FileIOTests extends BaseTests {
    private final String fileName;
    private final String filePath;

    public FileIOTests() {
        filePath = "/Users/rickmartin/src/Java/JavaWebdriver/JavaWebdriver/resources/";
        fileName = "sample.json";
    }

    @Test
    public void shouldBeAbleToDoFileIO() {
        logger.info(System.getProperty("user.dir"));

        logger.debug(FileIOTests.class.getName() + ".testFileUpload");

        FileUpLoadPage fileUpLoadPage = homePage.clickFileUpload();

        fileUpLoadPage.uploadFile(filePath + fileName);

        assertEquals(fileUpLoadPage.getUploadedFiles(), fileName, "Uploaded files incorrect");

        goHome();
        FileDownLoadPage fileDownLoadPage = homePage.clickFileDownLoad();

        fileDownLoadPage.clickLink(fileName);

    }
}
