public enum Day {

    MONDAY("MON", 0.8, "Fruits"),
    TUESDAY("TUE", 0.75, "Drinks"),
    WEDNESDAY("WED", 0.71, "GYM CARD"),
    THURSDAY("THU", 0.68, "Fruits"),
    FRIDAY("FRI", 1, "GYM CARD"),
    SATURDAY("SAT", 1, "HOT SPRINGS"),
    SUNDAY("SUN", 0.95, "SWIMMING");
    private String name;
    private double rate;
    private String gift;

    Day(String name, double rate, String gift){
        this.name = name;
        this.rate = rate;
        this.gift = gift;
    }

    public String getName(){
        return name;
    }

    public double getRate(){
        return rate;
    }

    public String getGift(){
        return gift;
    }

    public String toString() {
       return String.format("Day{name='%s', rate=%s, gift='%s'}", name, rate, gift);
    }
}
