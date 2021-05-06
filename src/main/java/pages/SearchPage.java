package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

    WebElement searchDropdownBox;
    WebElement twotabsearchtextbox;

    public WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void filter(String text) {
        searchDropdownBox.sendKeys(text);
    }

    public void searchFor(String text) {
        twotabsearchtextbox.sendKeys(text);
        twotabsearchtextbox.submit();
    }



    public WebElement getTwotabsearchtextbox() {
        return twotabsearchtextbox;
    }

    public WebElement getSearchDropdownBox() {
        return searchDropdownBox;
    }
}
