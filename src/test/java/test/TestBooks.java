package test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import entity.Book;
import pages.BookPage;
import pages.SearchPage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBooks {

    public static WebDriver driver;
    public static BookPage bookPage;
    public static SearchPage searchPage;

    @BeforeClass
    public static void setup() {

        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        bookPage = new BookPage(driver);
        searchPage = new SearchPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("https://www.amazon.com/s?k=Java&i=stripbooks-intl-ship&ref=nb_sb_noss");
        bookPage.convertData();

    }

    @Test
    public void checkBook() {
        List<Book> temp =bookPage.addBooks();
        String actual = String.valueOf(temp.get(0));
        String expectedTitle = "Effective Java";
        String expectedAuthor = "Joshua Bloch";
        String expectedBestseller = "true";

      Assert.assertTrue(actual.contains(expectedTitle));
       Assert.assertTrue(actual.contains(expectedAuthor));
        Assert.assertTrue(actual.contains(expectedBestseller));

    }


    @Test
    public void testBookDataExistence() {
        String books = bookPage.addBooks().toString();
        Assert.assertNotNull(books);

    }

    @Test
    public void findRequiredBookName() {
        List<Book> temp =bookPage.addBooks();
        String actual = String.valueOf(temp.get(0));
        String expected = "title='Effective Java'";
        org.testng.Assert.assertTrue(actual.contains(expected));

    }

    @Test
    public void findRequiredBookName1() {
        String name = "Java: The Complete Reference, Eleventh Edition";
        String names = bookPage.convertTitle().toString();
        Assert.assertTrue(names.contains(name));

    }

    @Test
    public void findRequiredBookName2() {
        String name = "Java: A Beginner's Guide, Eighth Edition";
        String names = bookPage.convertTitle().toString();
        Assert.assertTrue(names.contains(name));

    }

    @Test
    public void findRequiredAuthor() {
        String author = "Joshua Bloch";
        String authors = bookPage.convertAuthor().toString();
        Assert.assertTrue(authors.contains(author));

    }

    @Test
    public void findRequiredAuthor1() {
        String author = "Kathy Sierra";
        String authors = bookPage.convertAuthor().toString();
        Assert.assertTrue(authors.contains(author));

    }

    @Test
    public void findRequiredAuthor2() {
        String author = "Bert Bates";
        String authors = bookPage.convertAuthor().toString();
        Assert.assertTrue(authors.contains(author));

    }

    @Test
    public void testSearch() {
        driver.navigate().to("https://www.amazon.com/");
        searchPage.filter("Books");
        searchPage.searchFor("Java");
        String expectedURL ="https://www.amazon.com/s?k=Java&i=stripbooks-intl-ship&ref=nb_sb_noss";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL, actualURL);

    }


    @AfterClass
    public static void tearDown() {
        driver.close();
    }

}
