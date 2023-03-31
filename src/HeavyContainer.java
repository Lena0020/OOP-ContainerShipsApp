public class HeavyContainer extends StandardContainer{

    private int size;

    public HeavyContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight,String colour, int size) {

        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour);
        this.size = size;
        this.setType(TypeOfContainer.HEAVY);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nSize - " +size;
    }
}
