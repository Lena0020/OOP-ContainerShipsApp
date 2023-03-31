import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        Sender sender1 = new Sender("Marin", "Rells","0229260208", "Paris");
        Sender sender2 = new Sender("Adam", "Smith","00302906482", "Dublin");

        Ship s1 = new Ship("Titanic","Sydney","Tokyo","London",3,10,10,10, 15);
        Ship s2 = new Ship("Rolands","Sydney","Tokyo","London",3,10,10,10, 15);

        List<Ship> allShips = new LinkedList<>();
        allShips.add(s1);
        allShips.add(s2);

        Warehouse w1 = new Warehouse(10);
        RailwayCarriage r1 = new RailwayCarriage();

        Container c1 = new StandardContainer(sender1,"AAA","BBB",.5,1, "red");
        Container c2 = new HeavyContainer(sender2,"BBC","BBB",1,1, "blue",5);
        Container c3 = new LiquidToxContainer(sender2,"CCC","BBB",1,1, "yellow",5, 8, "poison");
        Container c4 = new LiquidContainer(sender2,"AAA","BBB",1,1, "green",5);
        Container c5 = new PowderyContainer(sender2,"AAA","BBB",1,1, "black",5, 3,"sandy");
        Container c6 = new RefrigeratedContainer(sender2,"AAA","BBB",1,1, "white",5,"DSL");
        Container c7 = new ExplosiveContainer(sender1,"AAA","BBB",1,1, "pink",3);
        Container c8 = new ExplosiveContainer(sender2,"A2","BBB",1,1, "green",3);

        w1.start(); //  - starting to calculate the date

        s1.load(c1);
        s1.load(c2);
        s1.load(c3);
        s1.load(c4);

        s2.load(c5);
        s2.load(c6);
        s2.load(c7);
        s2.load(c8);


        try{
            r1.load(c1,s1);
        }catch(IllegalThreadStateException e ){
            System.out.println("There's no train available at the moment. Please wait");
        }
        w1.load(c2,s1);


        //      LOADING
//
//        List<String> allLines = loadFromTheFile();
//
//        String line = allLines.get(1);
//        System.out.println(line);
//
//        int index = line.indexOf(" - ");
//        System.out.println(index);
//
//        String substring = line.substring(index+3);
//        System.out.println(substring);


        //   MENU

        Scanner scan = new Scanner(System.in);
        System.out.println(
                "1 - Create a container and load it on the ship\n" +
                "2 - Create a ship\n" +
                "3 - Unload a container\n" +
                "4 - Show all information about the Ship\n" +
                "5 - Show all information about the Warehouse\n" +
                "6 - Show all information about the Train\n" +
                "7 - Save\n"+
                "8 - Exit");

        int num = 0;
        while(num != 8){
            System.out.print("Choose option from the menu : ");
            String string = scan.nextLine();
            try{
                num = Integer.parseInt(string);
            }catch(NumberFormatException e){
                System.out.println("This must be a number");
                continue;
            }
            switch(num){
                case 1 -> {
                    Scanner scan2 = new Scanner(System.in);

                    System.out.println("Choose the sender : ");
                    System.out.println(" 1. "+sender1);
                    System.out.println(" 2. "+sender2);

                    try {
                        String temp = scan2.nextLine();
                        int sendersNum = Integer.parseInt(temp);
                        Sender sender = null;
                        if (sendersNum == 1) {
                            sender = sender1;
                        } else if (sendersNum == 2) {
                            sender = sender2;
                        }

                        System.out.print("Information about the security : ");
                        String infoSecurity = scan2.nextLine();

                        System.out.print("Information about the certificate : ");
                        String infoCertificate = scan2.nextLine();

                        double tare;
                        double netWeight;

                        System.out.print("Tare : ");
                        temp = scan2.nextLine();
                        tare = Double.parseDouble(temp);

                        System.out.print("Net Weight : ");
                        temp = scan2.nextLine();
                        netWeight = Double.parseDouble(temp);

                        System.out.println("Choose the type of a container\n" +
                                "1. STANDARD\n" +
                                "2. HEAVY\n" +
                                "3. REFRIGERATED,\n" +
                                "4. LIQUID,\n" +
                                "5. EXPLOSIVE,\n" +
                                "6. POWDERY,\n" +
                                "7. LIQUIDTOX");

                        temp = scan2.nextLine();
                        int yourChoice = Integer.parseInt(temp);

                        Container container;
                        switch (yourChoice) {
                            case 1 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                container = new StandardContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour);
                                System.out.println("Standard container has been created");
                            }
                            case 2 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Size : ");
                                temp = scan2.nextLine();
                                int size = Integer.parseInt(temp);
                                container = new HeavyContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, size);
                                System.out.println("Heavy container has been created");
                            }
                            case 3 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Size : ");
                                temp = scan2.nextLine();
                                int size = Integer.parseInt(temp);
                                System.out.print("Electrical Network Connection : ");
                                String electricalNetworkConnection = scan2.nextLine();
                                container = new RefrigeratedContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, size, electricalNetworkConnection);
                                System.out.println("Refrigerated container has been created");
                            }
                            case 4 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Volume : ");
                                temp = scan2.nextLine();
                                int volume = Integer.parseInt(temp);
                                container = new LiquidContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, volume);
                                System.out.println("Liquid container has been created");
                            }
                            case 5 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Level of danger : ");
                                temp = scan2.nextLine();
                                int lvlOfDanger = Integer.parseInt(temp);
                                container = new ExplosiveContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, lvlOfDanger);
                                System.out.println("Explosive container has been created");
                            }
                            case 6 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Size : ");
                                temp = scan2.nextLine();
                                int size = Integer.parseInt(temp);
                                System.out.print("Density : ");
                                temp = scan2.nextLine();
                                double density = Double.parseDouble(temp);
                                System.out.print("Type of Powder : ");
                                String typeOfPowder = scan2.nextLine();
                                container = new PowderyContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, size, density, typeOfPowder);
                                System.out.println("Powdery container has been created");
                            }
                            case 7 -> {
                                System.out.print("Colour : ");
                                String colour = scan2.nextLine();
                                System.out.print("Size : ");
                                temp = scan2.nextLine();
                                int size = Integer.parseInt(temp);
                                System.out.print("Density : ");
                                temp = scan2.nextLine();
                                double density = Double.parseDouble(temp);
                                System.out.print("Type of Toxic : ");
                                String typeOfToxic = scan2.nextLine();
                                container = new LiquidToxContainer(sender, infoSecurity, infoCertificate, tare, netWeight, colour, size, density, typeOfToxic);
                                System.out.println("LiquidToxic container has been created");

                            }
                            default -> {
                                System.out.println("Your choice was not on the list");
                                continue;
                            }
                        }
                        System.out.println("Choose a ship to load this container");
                        boolean loaded1 = false;
                        for (Ship s : allShips) {
                            System.out.println(s.toStringShipShort());
                        }
                        temp = scan2.nextLine();
                        int shipsId = Integer.parseInt(temp);

                        for (Ship s : allShips) {
                            if (s.getId() == shipsId) {
                                s.load(container);
                                loaded1 = true;
                                System.out.println("Container was loaded on the chosen ship");
                                break;
                            }
                        }if(loaded1) break;
                    }
                    catch (NumberFormatException e){
                        System.out.println("Container was not created / not loaded. This must be a number.");
                    }
                    System.out.println("Ship not on the list");

                }
                case 2 -> {
                    Scanner scan2 = new Scanner(System.in);
                    System.out.print("Name : ");
                    String name = scan2.nextLine();

                    System.out.print("Home port : ");
                    String homePort = scan2.nextLine();

                    System.out.print("Origin : ");
                    String origin = scan2.nextLine();

                    System.out.print("Destination : ");
                    String destination = scan2.nextLine();

                    int maxToxOrEx;
                    int maxHeavy;
                    int maxElectric;
                    int maxNumCont;
                    double maxWeight;
                    try {
                        System.out.print("Maximum number of Toxic and Explosive : ");
                        maxToxOrEx = scan2.nextInt();

                        System.out.print("Maximum number of Heavy : ");
                        maxHeavy = scan2.nextInt();

                        System.out.print("Maximum number of containers requiring electrical connection : ");
                        maxElectric = scan2.nextInt();

                        System.out.print("Maximum numbers of Containers : ");
                        maxNumCont = scan2.nextInt();

                        System.out.print("Maximum weight : ");
                        maxWeight = scan2.nextDouble();
                    }catch(InputMismatchException e){
                        System.out.println("The ship was not created");
                        continue;
                    }
                    if( maxToxOrEx >= 0 && maxHeavy >= 0 && maxElectric >= 0 && maxNumCont > 0 && maxWeight > 0){
                        Ship temporaryShip = new Ship(name, homePort, origin, destination, maxToxOrEx, maxHeavy,maxElectric,maxNumCont, maxWeight);
                        allShips.add(temporaryShip);
                        System.out.println("The ship has been created");
                    }else System.out.println("Ship was not created");
                }
                case 3 -> {
                    System.out.println("Choose a ship from which to unload a container");
                    for(Ship s : allShips){
                        System.out.println(s.toStringShipShort());
                    }
                    while(true){
                        String a = scan.nextLine();
                        boolean loaded = false;
                        try{
                            int shipsId = Integer.parseInt(a);
                            for(Ship s : allShips){
                                if(s.getId() == shipsId){
                                    System.out.println("Choose the container that you want to unload");
                                    s.showAllContainers();
                                    a = scan.nextLine();
                                    int containersId = Integer.parseInt(a);
                                    for(Container c : s.getAllContainers()){
                                        if(c.getId() == containersId){
                                            System.out.println("Choose where you want to unload the container\n 1. Train\n 2. Warehouse");
                                            a = scan.nextLine();
                                            int yourChoice = Integer.parseInt(a);
                                            if(yourChoice == 1){
                                                r1.load(c,s);
                                                System.out.println("Loaded on the Train");
                                                loaded = true;
                                                break;
                                            }else if (yourChoice == 2){
                                                w1.load(c,s);
                                                System.out.println("Loaded to the Warehouse");
                                                loaded = true;
                                                break;
                                            }else System.out.println("Your choice was not on the list");
                                        }
                                    }
                                }
                            }if(loaded) break;
                            System.out.println("Something went wrong, choose one of the ships again");
                        }catch(NumberFormatException e){
                            System.out.println("This must be a number, choose one of the ships again");
                            continue;
                        }
                     }
                }
                case 4 -> {
                    for(Ship s : allShips){
                        System.out.println(s + "\n");
                        s.showAllContainers();
                        System.out.println();
                    }
                }
                case 5 -> w1.showAllContainers();
                case 6 -> r1.showAllContainers();
                case 7 -> {
                    String tmp = "";
                    for(Container c : r1.getAllContainers()){
                        tmp += "----------CONTAINER------------\n" + c.toString2() + "\n";
                    }
                    saveToTheFile(tmp,"Train.txt");

                    tmp = "";
                    for(Container c : w1.getAllContainers()){
                        tmp += "----------CONTAINER------------\n" + c.toString2() + "\n";
                    }
                    saveToTheFile(tmp,"Warehouse.txt");

                    tmp = "";
                    for(Ship s : allShips){
                        tmp += "----------------------------SHIP----------------------------\n";
                        tmp += s.toString() +  "\n";
                        for(Container c : s.getAllContainers()){
                            tmp += "----------CONTAINER------------\n" + c.toString2() + "\n";
                        }
                    }
                    saveToTheFile(tmp,"Ships.txt");


                    System.out.println("Saved");
                }
                case 8 -> {
                    w1.interrupt();
                    System.out.println("Exit");
                }
                default -> System.out.println("No such option available");
            }
        }

    }
    public static void saveToTheFile(String s, String file){
        try {
            BufferedWriter save = new BufferedWriter(new FileWriter(file));
            save.write(s);
            save.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static List<String> loadFromTheFile(){
        List<String> allLines = new LinkedList<>();
        try {
            BufferedReader read = new BufferedReader(new FileReader("Train.txt"));

            String s;
            while((s = read.readLine()) != null){
                allLines.add(s);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLines;
    }

}
