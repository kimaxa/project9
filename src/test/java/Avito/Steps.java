package Avito;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
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
    public void вВыпадающемСпискеКатегорийВыбранаОргтехника() {
    }

    @И("в поле поиска введено значение принтер")
    public void вПолеПоискаВведеноЗначениеПринтер() {
    }

    @Тогда("кликнуть по выпадающемему списку региона")
    public void кликнутьПоВыпадающемемуСпискуРегиона() {
    }

    @Тогда("в поле регион введено значение Владивосток")
    public void вПолеРегионВведеноЗначениеВладивосток() {
    }

    @И("нажата кнопка показать объявления")
    public void нажатаКнопкаПоказатьОбъявления() {
    }

    @Тогда("открылась страница результаты по запросу принтер")
    public void открласьСтраницаРезультатыПоЗапросуПринтер() {
    }

    @И("активирован чекбокс только с фотографией")
    public void активированЧекбоксТолькоСФотографией() {
    }

    @И("в выпадающем списке сортировка выбрано значение Дороже")
    public void вВыпадающемСпискеСортировкаВыбраноЗначениеДороже() {
    }

    @И("в консоль выведено значение названия и цены и {int} первых товаров")
    public void вКонсольВыведеноЗначениеНазванияИЦеныИПервыхТоваров(int arg0) {
    }
}
