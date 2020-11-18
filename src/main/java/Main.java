import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(2, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");
        // Выбрать в выпадающем списке “категория” значение оргтехника и расходники
        Select categorySelector = new Select(driver.findElement(By.xpath("//select[@id='category']")));
        categorySelector.selectByVisibleText("Оргтехника и расходники");
        // В поле поиск по объявлению ввести значение “Принтер”
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        //Нажать на поле город
        driver.findElement(By.xpath("//div[@class='main-select-2pf7p main-location-3j9by']")).click();
        //Заполнить значением “Владивосток” поле город  в открывшемся окне и кликнуть по первому предложенному варианту. Нажать на кнопку “Показать объявления”
        driver.findElement(By.xpath("//input[@class='suggest-input-3p8yi']")).sendKeys("Владивосток");
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
        driver.findElement(By.xpath("//button[@class='button-button-2Fo5k button-size-m-7jtw4 button-primary-1RhOG']")).click();
        //Проверить, активирован ли чекбокс, и если не активирован – активировать и нажать кнопку “Показать объявления”
        WebElement checkbox = driver.findElement(By.xpath("//label[@data-marker='delivery-filter']"));
        if (!checkbox.isSelected()) {
        checkbox.click();
        }
        driver.findElement(By.xpath("//button[@data-marker='search-filters/submit-button']")).click();
        //В выпадающем списке фильтрации выбрать фильтрацию по убыванию цены.
        Select priceSelector = new Select(driver.findElement(By.xpath("//div[@class='form-select-v2 sort-select-3QxXG']")));
        priceSelector.selectByVisibleText("Дороже");
        //Вывести в консоль название и стоимость 3х самых дорогих принтеров


    }
}
