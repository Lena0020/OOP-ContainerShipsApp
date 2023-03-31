public class ToxicContainer extends HeavyContainer{
    private double density;

    public ToxicContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int size, double density) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour, size);
        this.density = density;
        this.setType(TypeOfContainer.TOXIC);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nDensity - " +density;
    }
}
