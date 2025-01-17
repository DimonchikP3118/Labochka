package policy;

public enum TypeofAction {
    FOOLOWGOVERNOR("Проследить за правительством",15,PoliticalPosition.NEUTRAL),
    MURDERPOLICY("Убить правительство",100,PoliticalPosition.NEGATIVE),
    PROTEST("Устроить протест",45,PoliticalPosition.NEGATIVE),
    SUPPORTGOVERNMENT("Поддержать правительство",30,PoliticalPosition.POSITIVE),
    CARRYORDER("Выполнить поручение правительства",25,PoliticalPosition.POSITIVE),
    IMPROVEPOLICIES("Укрепить экономику",60,PoliticalPosition.POSITIVE),
    WORSEPOLICIES("Ухудшить экономику",60,PoliticalPosition.NEGATIVE),
    STARTRUMORSABOUTGOVERNMENT("Пустить слухи о правительстве",15,PoliticalPosition.NEGATIVE),
    ABSTAINFROMELECTIONS("Воздержаться от выборов",35,PoliticalPosition.NEUTRAL);

    private String ru;
    private int power;
    private PoliticalPosition position;

    TypeofAction(String ru,int power, PoliticalPosition position){
        this.ru = ru;
        this.position = position;
        this.power = power;
    }

    public String getRu() {
        return ru;
    }

    public PoliticalPosition getPosition() {
        return position;
    }

    public int getPower() {
        return power;
    }

}
