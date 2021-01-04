package fileio;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileDownLoadPage;
import pages.FileUpLoadPage;

import java.util.Map;
import java.util.SplittableRandom;

import static org.testng.Assert.assertEquals;

public class FileIOTests extends BaseTests {
    private final String fileName;
    private final String filePath;
    private final String fullPath;
    private final String fileSeparator = System.getProperty("file.separator");

    public FileIOTests() {
        filePath = System.getProperty("user.dir") + fileSeparator + "resources";
        fileName = "sample.json";
        fullPath = filePath + fileSeparator + fileName;
    }

    @Test
    public void shouldBeAbleToDoFileIO() {
        logger.debug(FileIOTests.class.getName() + ".testFileUpload:");
        logger.info("File to upload: " + fullPath);

        FileUpLoadPage fileUpLoadPage = homePage.clickFileUpload();

        fileUpLoadPage.uploadFile(fullPath);

        assertEquals(fileUpLoadPage.getUploadedFiles(), fileName, "Uploaded files incorrect");

        goHome();
        FileDownLoadPage fileDownLoadPage = homePage.clickFileDownLoad();

        fileDownLoadPage.clickLink(fileName);

    }
}
