package Avito;

    public enum Price {
        По_умолчанию("//div[@class='form-select-v2 sort-select-3QxXG']//option[@value='101']"),
        Дешевле("//div[@class='form-select-v2 sort-select-3QxXG']//option[@value='1']"),
        Дороже("//div[@class='form-select-v2 sort-select-3QxXG']//option[@value='2']"),
        По_дате("//div[@class='form-select-v2 sort-select-3QxXG']//option[@value='101']");

        public String value;
        Price(String value) {
            this.value = value;
        }
    }

