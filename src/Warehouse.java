import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.util.LinkedList;
import java.util.List;

public class Warehouse extends Thread {
    private int maxNumCont;
    private List<Container> allContainers = new LinkedList<>();

    public Warehouse(int maxNumCont) {
        this.maxNumCont = maxNumCont;
    }

    // explosive        -> 5 days
    // toxic liquid     -> 10 days
    // toxic powdery    -> 14 days.

    public void load(Container container, Ship s) {
        if(container.getInfoSender().getWarnings().size() < 2) {
            if (allContainers.size() < maxNumCont) {
                if (s.getAllContainers().contains(container)) {
                    allContainers.add(container);
                    s.unload(container);
                    container.setStored(today);
                } else System.out.println("Container not found on the ship");
            } else System.out.println("No space available in the warehouse (You can try to load it on the train)");
        }else System.out.println("Irresponsible sender - the sender has already received 2 warnings");
    }

    public void showAllContainers() {
        System.out.println(" All containers in the warehouse - ");
        for (Container c : allContainers) {
            System.out.println(c);
        }
    }

    public void ifItExpired() throws IrresponsibleSenderWithDangerousGoods {
        for (int i = 0; i < allContainers.size(); i++) {

            Container c = allContainers.get(i);

            if (c.getType() == TypeOfContainer.EXPLOSIVE) {
                if (!today.isBefore(c.getStored().plusDays(5))) {
                    System.out.println(c + " - The storage-time has expired");
                    allContainers.remove(c);
                    throw new IrresponsibleSenderWithDangerousGoods(c);
                }
            } else if (c.getType() == TypeOfContainer.LIQUIDTOX) {
                if (!today.isBefore(c.getStored().plusDays(10))) {
                    System.out.println(c + " - The storage-time has expired");
                    allContainers.remove(c);
                    throw new IrresponsibleSenderWithDangerousGoods(c);
                }
            }
            else if (c.getType() == TypeOfContainer.POWDERY) {
                if (!today.isBefore(c.getStored().plusDays(14))) {
                    System.out.println(c + " - The storage-time has expired");
                    allContainers.remove(c);
                    throw new IrresponsibleSenderWithDangerousGoods(c);
                }
            }
//            int howManyDays = -1;
//
//            if (c.getType() == TypeOfContainer.EXPLOSIVE)
//                howManyDays = 5;
//            else if (c.getType() == TypeOfContainer.LIQUIDTOX)
//                howManyDays = 10;
//            else if (c.getType() == TypeOfContainer.POWDERY)
//                howManyDays = 14;
//
//              OR
//
//            switch (c.getType()){
//                case EXPLOSIVE -> howManyDays = 5;
//                case LIQUIDTOX -> howManyDays = 10;
//                case POWDERY -> howManyDays = 14;
//            }
//            if (howManyDays != -1 && !WarehouseThread.getToday().isBefore(c.getStored().plusDays(howManyDays))) {
//                System.out.println(c + " - The storage-time has expired");
//                allContainers.remove(c);
//            }
        }
    }
    private static LocalDate today = LocalDate.now();

    @Override
    public void run() {
        while(!Thread.interrupted()){
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
            today = today.plusDays(1);
            try {
                ifItExpired();
            } catch (IrresponsibleSenderWithDangerousGoods e) {
                e.printStackTrace();
                e.getSender().getWarnings().add(e);
            }
        }
    }

    public static LocalDate getToday() {
        return today;
    }

    public List<Container> getAllContainers() {
        return allContainers;
    }
}
class IrresponsibleSenderWithDangerousGoods extends Exception{
    private Sender sender;

    public IrresponsibleSenderWithDangerousGoods(Container c){
        super(c.getInfoSender().getName() + " - irresponsible sender");
        sender = c.getInfoSender();
    }

    public Sender getSender() {
        return sender;
    }
}
