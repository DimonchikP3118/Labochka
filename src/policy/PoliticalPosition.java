package policy;

public enum PoliticalPosition {
    POSITIVE("Положительная"),
    NEGATIVE("Отрицательнвя"),
    NEUTRAL("Нейтральная");

    private String ru;

    PoliticalPosition(String ru){
        this.ru = ru;
    }
    public String getRu() {
        return ru;
    }
}
