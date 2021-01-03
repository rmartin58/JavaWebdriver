package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HoversPage {

    private final WebDriver driver;
    private final By figureBox;
    private final By boxCaption;

    public HoversPage(WebDriver driver) {
        this.driver = driver;
        figureBox = By.className("figure");
        boxCaption = By.className("figcaption");
    }

    /**
     * @param index starts at 1
     * @return new FigureCaption object
     */
    public FigureCaption hoverOverFigure(int index) {
        WebElement figure = driver.findElements(figureBox).get(index - 1);

        Actions actions = new Actions(driver);
        actions.moveToElement(figure).perform();

        return new FigureCaption(figure.findElement(boxCaption));
    }

    public static class FigureCaption {
        private final WebElement caption;
        private final By header;
        private final By link;

        public FigureCaption(WebElement caption) {
            this.caption = caption;
            header = By.tagName("h5");
            link = By.tagName("a");
        }

        public boolean isCaptionDisplayed() {
            return caption.isDisplayed();
        }

        public String getLink() {
            return caption.findElement(link).getAttribute("href");
        }

        public String getLinkText() {
            return caption.findElement(link).getText();
        }


        public String getTitle() {
            return caption.findElement(header).getText();
        }
    }
}
