package pages;

import entity.Book;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BookPage {

    public WebDriver driver;

    @FindBy(xpath = "//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//h2/a/span")
    private List<WebElement> name;
    @FindBy(xpath = "//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//a[@class='a-size-base a-link-normal']")
    private List<WebElement> author;
    @FindBy(xpath = "//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//a[@class='a-size-base a-link-normal a-text-normal'][2]//span[1]")
    private List<WebElement> price;
    @FindBy(xpath = "//div[contains(@class, 's-main-slot') and contains(@class, 's-result-list')]//div[contains(@data-component-type, 's-search-result')]//span[contains(@class, 'a-badge-text')]")
    private List<WebElement> bestSeller;


    public BookPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private LinkedList titles = new LinkedList();
    private LinkedList authors = new LinkedList<>();
    private LinkedList prices = new LinkedList<>();
    private LinkedList bestSellers = new LinkedList<>();

    List<Book> books = new ArrayList<>();


    public LinkedList convertTitle() {
        for (WebElement webElement : name) {
            titles.add(webElement.getText());
        }
        return titles;
    }

    public LinkedList convertAuthor() {

        for (WebElement webElement : author) {
            authors.add(webElement.getText());
        }

        return authors;
    }

    public LinkedList convertPrice() {
        for (WebElement webElement : price) {
            prices.add(webElement.getText());
        }
        return prices;
    }

    public LinkedList convertBestSeller() {
        for (WebElement webElement : bestSeller) {
            bestSellers.add(webElement.getText());
        }
        return bestSellers;
    }


    public void convertData() {
        convertTitle();
        convertAuthor();
        convertPrice();
        convertBestSeller();
    }


    public List<Book> addBooks() {
        for (int i = 0; i <= 15; i++) {
            String title = null;
            String author = null;
            String price = null;
            boolean bestSeller = false;
            if (i < titles.size()) {
                title = (String) titles.get(i);
            }
            if (i < authors.size()) {
                author = (String) authors.get(i);
            }
            if (i < prices.size()) {
                price = (String) prices.get(i);
            }
            if (i < bestSellers.size()) {
                bestSeller = true;
            }
            books.add(new Book(title, author, price, bestSeller));
        }
        books.forEach(System.out::println);

        return books;
    }


}
