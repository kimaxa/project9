package Avito;

public enum  Category {
    Транспорт("//option[@data-marker='option(1)']"),
    Автомобили("//option[@data-marker='option(9)']"),
    Недвижимость("//option[@data-marker='option(4)']"),
    Квартиры("//option[@data-marker='option(24)']"),
    Комнаты("//option[@data-marker='option(23)']"),
    Работа("//option[@data-marker='option(110)']"),
    Вакансии("//option[@data-marker='option(111)']"),
    Ноутбуки("//option[@data-marker='option(98)']"),
    Оргтехника("//option[@data-marker='option(99)']"),
    Животные("//option[@data-marker='option(89)']");

    String value;
    Category(String value) {
        this.value = value;
    }
}
