import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        /*
        lav fodboldklub-objekt
         lav en liste af personer med random-valideret cprnummer.
         - ud fra en liste af navne læses fra fil
         for hvert navn:
            lav et person objekt
            lav et random-baseret men valideret cprnummer som er unikt!

         */

        Fodboldklub fodboldklub = new Fodboldklub();

        Person person = new Person();

        CPRNr cprNr = new CPRNr();
        System.out.println("CPR: " + cprNr.cprnummer);
        String x = cprNr.createCPR();
        int sum = cprNr.calc(x);
        String str = cprNr.getCprnummer(sum);
        System.out.println(str);


        ReadFile readFile = new ReadFile();
        readFile.readFirstNames();
        readFile.readLastNames();
        readFile.mergeArrays();
        System.out.println(readFile.fullName);

    }
}
