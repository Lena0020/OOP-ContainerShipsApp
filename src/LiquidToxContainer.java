public class LiquidToxContainer extends ToxicContainer implements HeavyLiquidCont{
    private String typeOfTox;

    public LiquidToxContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int size, double density, String typeOfTox) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour, size, density);

        this.typeOfTox = typeOfTox;
        this.setType(TypeOfContainer.LIQUIDTOX);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nType of the toxin - " +typeOfTox;
    }
}
