import java.util.ArrayList;

public class human {
    private int weight;
    private String name;
    private int height;
    private Boolean hasNose;
    private static int numberOfHumans;

    public human(String name, int height, int weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.hasNose = true;
        numberOfHumans++;
    }

    public int getWeight() {
        return this.weight;
    }

    public void goToWar() {
        this.hasNose = false;
    }

    public static int getNumberOfHumans() {
        return human.numberOfHumans;
    }

    public void changeWeight(int newWeight) {
        this.weight = newWeight;
    }
    public static void main(String[] args) {
        human jovian = new human("jovian", 180, 78);
        System.out.format("jovian's weight is %d\n", jovian.getWeight());
        System.out.format("total number of humans are at %d\n", human.getNumberOfHumans());
        human jiayi = new human("jiayi", 173, 55);
        System.out.format("number of humans: %d\n", human.getNumberOfHumans());
        jiayi.changeWeight(54);
        System.out.println("jiayi lost weight");
        System.out.format("jia yi successfuly created\n\total number of humans are now at %d\n", human.getNumberOfHumans());
    }
}
