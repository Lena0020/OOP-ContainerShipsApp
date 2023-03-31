import java.util.LinkedList;
import java.util.List;

public class RailwayCarriage extends Thread{
    private int maxNumCont = 10;
    private List<Container> allContainers = new LinkedList<>();

    public void load(Container container,Ship s) {
        if (allContainers.size() < maxNumCont) {
            if(s.getAllContainers().contains(container)) {
                allContainers.add(container);
                s.unload(container);
            }else System.out.println("Container not found on the ship");
        }
        else System.out.println("No space available on the train (You can try to load it to the warehouse)");
        if(allContainers.size() >= maxNumCont){
            start();
        }
    }

    public void showAllContainers(){
        System.out.println(" All containers on the train - ");
        for(Container c : allContainers){
            System.out.println(c);
        }
    }

    public List<Container> getAllContainers() {
        return allContainers;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            System.out.println("Waiting interrupted");
        }
        System.out.println("The new train has arrived");
        allContainers.clear();
    }
}
