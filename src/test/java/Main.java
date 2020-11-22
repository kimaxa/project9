import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    private WebDriver driver;

    @BeforeMethod
    public void start() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
    }
    @Test
    public void test() throws InterruptedException {

        // Выбрать в выпадающем списке “категория” значение оргтехника и расходники
        Select categorySelector = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        categorySelector.selectByVisibleText("Оргтехника и расходники");
        Thread.sleep(1000);

        // В поле поиск по объявлению ввести значение “Принтер”
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        Thread.sleep(1000);

        //Нажать на поле город
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        Thread.sleep(1000);

        //Заполнить значением “Владивосток” поле город  в открывшемся окне и кликнуть по первому предложенному варианту.
        //Нажать на кнопку “Показать объявления”
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        Thread.sleep(1000);

        //Проверить, активирован ли чекбокс, и если не активирован – активировать и нажать кнопку “Показать объявления”
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']"));
        if (!checkBox.isSelected()) {
            checkBox.click(); }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        Thread.sleep(1000);

        //В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.
        driver.findElement(By.xpath("//div[@class='form-select-v2 sort-select-3QxXG']//option[@value='101']")).click();
        driver.findElement(By.xpath("/div[@class='form-select-v2 sort-select-3QxXG']//option[@value='2']")).click();
        Thread.sleep(1000);

        //Вывести в консоль название и стоимость 3х самых дорогих принтеров
        List<WebElement> printers = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
        for (int i = 0; i < 3; i++) {
            System.out.println("Принтер №" + (i + 1));
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price']")).getText());
        }


    }
    @AfterMethod
    public void close() {
        driver.quit();
    }
}
