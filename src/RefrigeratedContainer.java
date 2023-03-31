public class RefrigeratedContainer extends HeavyContainer{

    private String electricalNetworkConnection;

    public RefrigeratedContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int size, String electricalNetworkConnection) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour, size);
        this.electricalNetworkConnection = electricalNetworkConnection;
        this.setType(TypeOfContainer.REFRIGERATED);
    }
    @Override
    public String toString2() {
        return super.toString2() +"\nType of electrical network connection - " +electricalNetworkConnection;
    }
}
