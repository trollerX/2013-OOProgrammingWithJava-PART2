
public class Main {

    public static void main(String[] args) {
        Container container = new Container(1000);
        addSuitcasesFullOfBricks(container);
        System.out.println(container);
    }

    public static void addSuitcasesFullOfBricks(Container container) {
        for(int weight=1;weight<=100;weight++){
            Suitcase suitcase = new Suitcase(weight);
            Thing thing = new Thing("Brick", weight);
            suitcase.addThing(thing);
            container.addSuitcase(suitcase);
        }
    }

}
