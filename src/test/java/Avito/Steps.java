package Avito;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;

    @Before
    public void prepare() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
    }
    @Пусть("открыт ресурс авито")
    public void открытРесурсАвито() {
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.avito.ru/");
        driver.manage().window().maximize();
    }
    @ParameterType(".*")
    public Category category(String category) {
        return Category.valueOf(category);
    }

    @И("в выпадающем списке категорий выбрана {category}")
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника(Category category) throws InterruptedException {
        driver.findElement(By.id("category")).click();
        driver.findElement(By.xpath(category.value)).click();
        Thread.sleep(1000);
    }

    @И("в поле поиска введено значение (.*)")
    public void вПолеПоискаВведеноЗначениеПринтер() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
        Thread.sleep(1000);
    }

    @Тогда("кликнуть по выпадающемему списку региона")
    public void кликнутьПоВыпадающемемуСпискуРегиона() throws InterruptedException {
        driver.findElement(By.xpath("//div[@data-marker='search-form/region']")).click();
        Thread.sleep(1000);
    }

    @Тогда("в поле регион введено значение (.*)")
    public void вПолеРегионВведеноЗначениеВладивосток() throws InterruptedException {
        driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys("Владивосток");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[@data-marker='suggest(0)']")).click();
        Thread.sleep(1000);
    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() throws InterruptedException {
        driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
        Thread.sleep(1000);
    }

    @Тогда("открылась страница результаты по запросу (.*")
    public void открыласьСтраницаРезультатыПоЗапросуПринтер() throws InterruptedException {
        driver.findElement(By.xpath("//h1[@data-marker='page-title/text']")).getText();
        Thread.sleep(1000);
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() throws InterruptedException {
        WebElement checkBox = driver.findElement(By.xpath("//input[@data-marker='search-form/with-images']"));
        if (!checkBox.isSelected()) {
            checkBox.click();
            Thread.sleep(1000);
        }
    }
    @ParameterType(".*")
    public Price price(String price) {
        return Price.valueOf(price);
    }
    @И("в выпадающем списке сортировка выбрано значение {price}")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже(Price price) throws InterruptedException {
        driver.findElement(By.id("price")).click();
        driver.findElement(By.xpath(price.value)).click();
        Thread.sleep(1000);
    }

    @И("в консоль выведено значение названия и цены и {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныИПервыхТоваров(int arg0) {
        List<WebElement> printers = driver.findElements(By.xpath("//div[@class='item_table-wrapper']"));
        for (int i = 0; i < 3; i++) {
            System.out.println("Принтер №" + (i + 1));
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-title-row']/h3/a")).getText());
            System.out.println(printers.get(i).findElement(By.xpath("./div/div[@class='snippet-price-row']/span[@class='snippet-price']")).getText());
        }
    }
    @Тогда("закрыть браузер")
    public void закрытьБраузер() {
        driver.quit();
    }
}
