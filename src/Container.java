import java.time.LocalDate;

public class Container {

    private int id;
    private static int counter = 0;
    private Sender infoSender;
    private String infoSecurity;
    private double tare;
    private double netWeight;
    private double grossWeight;
    private String infoCertificate;
    private TypeOfContainer type = TypeOfContainer.STANDARD;
    private LocalDate stored;


    public Container(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight){
    id = counter;
    counter++;
    this.infoSender = infoSender;
    this.infoSecurity = infoSecurity;
    this.infoCertificate = infoCertificate;
    this.tare = tare;
    this.netWeight = netWeight;
    this.grossWeight = tare + netWeight;

}

    @Override
    public String toString() {
        return "Container's id - " +id;
    }
    public String toString2(){
        return "Information about the sender - " +infoSender+
                "\nInformation about the security - "+infoSecurity+
                "\nTare - "+tare+
                "\nNet Weight - " +netWeight+
                "\nGross Weight - " +grossWeight+
                "\nInformation about the certificate - " +infoCertificate+
                "\nType - " +type;
    }
    public String toString3(){
        return infoSender.getPesel()+
                "\n"+infoSecurity+
                "\n"+tare+
                "\n"+netWeight+
                "\n"+grossWeight+
                "\n"+infoCertificate+
                "\n"+type;
    }


    public TypeOfContainer getType(){
        return type;
    }
    public void setType(TypeOfContainer type){
        this.type = type;
    }
    public void setStored(LocalDate stored){
        this.stored = stored;
    }
    public LocalDate getStored() {
        return stored;
    }
    public double getGrossWeight() {
        return grossWeight;
    }
    public Sender getInfoSender() {
        return infoSender;
    }
    public int getId() {
        return id;
    }
}
enum TypeOfContainer {
    STANDARD,
    HEAVY,
    REFRIGERATED,
    LIQUID,
    EXPLOSIVE,
    TOXIC,
    POWDERY,
    LIQUIDTOX
}