package word;

public enum TownsandCountries {
    Rome("Рим",'Р'),
    Africa("Африка",'а'),
    Deportivo("Депортиво",'д'),
    Orenburg("Оренбург",'о'),
    Seishely("Сейшелы",'с'),
    Tenerife("Тенерифы",'т'),
    Gzenev("Гженев",'Г'),
    Romi("Рим",'р'),
    Uzdal("Уздаль",'у'),
    Zimbabve("Зимбабве",'З'),
    Usuriisk("Уссурийск",'У'),
    Donetsk("Донецк",'д'),
    Vladimir("Владимир",'в'),
    Ekaterinburg("Екатеринбург",'е'),
    Tver("Тверь",'т'),
    Novgorod("Новгород",'н'),
    Vladimiri("Владимир",'В'),
    Hamburg("Гамбург",'г'),
    Pakestan("Пакестан",'П'),
    Chili("Чили",'ч'),
    Australia("Австралия",'а'),
    Irtysh("Иртыш",'и'),
    Leningrad("Ленинград",'л');

    private String ru;
    private char bukva;

    TownsandCountries(String ru, char bukva){
        this.ru = ru;
        this.bukva = bukva;
    }
    public String getRu() {
        return ru;
    }

    public char getbukva() {
        return bukva;
    }
}


