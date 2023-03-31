public class LiquidContainer extends StandardContainer implements HeavyLiquidCont{
    private int volume;
    public LiquidContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int volume) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour);
        this.volume = volume;
        this.setType(TypeOfContainer.LIQUID);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nVolume - " +volume;
    }
}
