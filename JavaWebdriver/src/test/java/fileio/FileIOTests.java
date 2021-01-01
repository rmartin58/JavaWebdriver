package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUpLoadPage;
import pages.FileDownLoadPage;

import static org.testng.Assert.assertEquals;

public class FileIOTests extends BaseTests {

    private String filePath = "C:\\src\\Java\\JavaWebdriver\\JavaWebdriver\\resources\\";
    private String fileName = "sample.json";
    @Test
    public void shouldBeAbleToDoFileIO() {

        logger.debug(FileIOTests.class.getName() + ".testFileUpload");

        FileUpLoadPage fileUpLoadPage = homePage.clickFileUpload();

        fileUpLoadPage.uploadFile(filePath+fileName);

        assertEquals(fileUpLoadPage.getUploadedFiles(), fileName, "Uploaded files incorrect");

        goHome();
        FileDownLoadPage fileDownLoadPage = homePage.clickFileDownLoad();

        fileDownLoadPage.clickLink(fileName);

    }
}
