import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Sender {
    private String name;
    private String surname;
    private String pesel;
    private String adress;
    private LocalDate birthDate;

    public Sender(String name, String surname, String pesel, String adress){
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.adress = adress;
        birthDate = getBirthDate();
    }
    private List<IrresponsibleSenderWithDangerousGoods> warnings= new LinkedList();
    public List<IrresponsibleSenderWithDangerousGoods> getWarnings() {
        return warnings;
    }
    public LocalDate getBirthDateOutOfPesel(){
        int year;
        int month;
        int day;

        day = Integer.parseInt(pesel.substring(4,6));
        month = Integer.parseInt(pesel.substring(2,4));
        year = Integer.parseInt(pesel.substring(0,2));

        if(month > 12 && month <=32){
            month = month - 20;
            year = year + 2000;
        }
        else if(month > 32) {
            month = month - 40;
            year = year + 2100;
        }
        else {
            year = year + 1900;
        }

        LocalDate date = LocalDate.of(year,month,day);
        return date;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public String getName() {
        return name;
    }
    public String getPesel() {
        return pesel;
    }

    @Override
    public String toString() {
        return name +" " + surname;
    }
}
