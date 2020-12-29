package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUpLoadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        logger.debug(FileUploadTests.class.getName() + ".testFileUpload");

        FileUpLoadPage fileUpLoadPage = homePage.clickFileUpload();

        fileUpLoadPage.uploadFile("C:\\src\\Java\\JavaWebdriver\\JavaWebdriver\\temp\\sample.json");

        assertEquals(fileUpLoadPage.getUploadedFiles(), "sample.json", "Uploaded files incorrect");
    }
}
