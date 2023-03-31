import java.util.LinkedList;
import java.util.List;

public class Ship {
    private int id;
    private static int counter = 0;
    private String name;
    private String homePort;
    private String origin;
    private String destination;
    private int maxToxicOrExplosive;
    private int maxHeavy;
    private int maxElectric;
    private int maxNumCont;
    private double maxWeightLoad;
    private double currentWeight = 0;
    private int currentToxicOrExplosive = 0;
    private int currentHeavy = 0;
    private int currentElectric = 0;

    private List<Container> allContainers = new LinkedList<>();

    public Ship(String name,String homePort, String origin,String destination, int maxToxicOrExplosive,int maxHeavy,int maxElectric, int maxNumCont,double maxWeightLoad){

        id = counter;
        counter++;
        this.name = name;
        this.homePort = homePort;
        this.origin = origin;
        this.destination = destination;
        this.maxToxicOrExplosive = maxToxicOrExplosive;
        this.maxHeavy = maxHeavy;
        this.maxElectric = maxElectric;
        this.maxNumCont = maxNumCont;
        this.maxWeightLoad = maxWeightLoad;
    }

    public List<Container> getAllContainers(){
        return allContainers;
    }

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }

    public void load(Container container){
        if(allContainers.size() < maxNumCont)
            if(currentWeight + container.getGrossWeight() < maxWeightLoad) {
                if(container.getType() == TypeOfContainer.HEAVY && currentHeavy < maxHeavy) {
                    currentHeavy++;
                    currentWeight = currentWeight + container.getGrossWeight();
                    allContainers.add(container);
                }
                else if((container.getType() == TypeOfContainer.TOXIC || container.getType() == TypeOfContainer.EXPLOSIVE || container.getType() == TypeOfContainer.LIQUIDTOX || container.getType() == TypeOfContainer.POWDERY)&& currentToxicOrExplosive < maxToxicOrExplosive) {
                    currentToxicOrExplosive++;
                    currentHeavy++;
                    currentWeight = currentWeight + container.getGrossWeight();
                    allContainers.add(container);
                }
                else if(container.getType() == TypeOfContainer.REFRIGERATED && currentElectric < maxElectric) {
                    currentElectric++;
                    currentHeavy++;
                    currentWeight = currentWeight + container.getGrossWeight();
                    allContainers.add(container);
                }
                else if(container.getType() == TypeOfContainer.STANDARD || container.getType() == TypeOfContainer.LIQUID) {
                        currentWeight = currentWeight + container.getGrossWeight();
                        allContainers.add(container);
                }
                else System.out.println("Could not add a container");
            }
            else System.out.println("The container is too heavy to load");
        else System.out.println("The is no space on the ship");
    }
    public void unload(Container container){
        allContainers.remove(container);
    }

    @Override
    public String toString() {
        return "Ship's id - " + id +
                "\nName - " +name+
                "\nHome port - " +homePort+
                "\nOrigin - " +origin+
                "\nDestination - " +destination+
                "\nMaximum number of Toxic and Explosive containers - " +maxToxicOrExplosive+
                "\nMaximum number of Heavy Containers - " +maxHeavy+
                "\nMaximum number of containers requiring connection to the electricity network - " +maxElectric+
                "\nMaximum number of all containers - " +maxNumCont+
                "\nMaximum weight load - " +maxWeightLoad;
    }
    public String toStringShipShort(){
        return "Ship ID - " + id;
    }
    public void showAllContainers(){
        System.out.println("--All containers on the ship-- " +id+" " + name);
        for(Container c : allContainers){
            System.out.println(c);
        }
    }
}
































