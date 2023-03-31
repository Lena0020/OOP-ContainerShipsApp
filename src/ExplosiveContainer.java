public class ExplosiveContainer extends StandardContainer{
    private int lvlOfDanger;
    public ExplosiveContainer(Sender infoSender, String infoSecurity, String infoCertificate, double tare, double netWeight, String colour, int lvlOfDanger) {
        super(infoSender, infoSecurity, infoCertificate, tare, netWeight, colour);

        this.lvlOfDanger = lvlOfDanger;
        this.setType(TypeOfContainer.EXPLOSIVE);
    }

    @Override
    public String toString2() {
        return super.toString2() +"\nDanger - " +lvlOfDanger;
    }
}
