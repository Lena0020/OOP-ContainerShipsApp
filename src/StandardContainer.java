public class StandardContainer extends Container{

    private String colour;

    public StandardContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour) {

        super(infoSender, infoSecurity, infoCertificate, tare, netWeight);
        this.colour = colour;
        this.setType(TypeOfContainer.STANDARD);

    }
    @Override
    public String toString2() {
        return super.toString2() +"\nColour - " +colour;
    }
}
