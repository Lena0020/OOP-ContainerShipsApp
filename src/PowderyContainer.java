public class PowderyContainer extends ToxicContainer {
    private String typeOfPowder;

    public PowderyContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int size, double density, String typeOfPowder) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour, size, density);

        this.typeOfPowder = typeOfPowder;
        this.setType(TypeOfContainer.POWDERY);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nType of powder - " +typeOfPowder;
    }
}
