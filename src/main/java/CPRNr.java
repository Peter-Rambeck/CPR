import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Random;

public class CPRNr {
    String cprnummer;
    int calcNr[] = {4, 3, 2, 7, 6, 5, 4, 3, 2, 1};


    public String createCPR() {
        String cprString = "";
        // lav et nummer
        Random random = new Random();
        int n = random.nextInt(100) + 1;
        // lav en dato (LocalDate, minus random tal)
        //1940-08-12
        //081240
        LocalDate date = LocalDate.now();
        LocalDate datoX = date.minusDays(n);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyMMdd");
        cprString = datoX.format(formatter);
        System.out.println("Auto generated yyMMdd: " + cprString);
        // kig på pdf .. 543

        // Random, De sidste 3
        int last4 = random.nextInt(899) +99;
        String temp = "4"+last4;
        cprString = cprString + temp;

        return cprString;
    }


    public int calc(String str) {
        int sum = 0;

        String[] split = str.split("");
        int size = split.length;
        //
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        System.out.println("String: yyMMdd + Last 4 parsed to int Array:" + Arrays.toString(arr));


        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i] * calcNr[i];
        }
        System.out.println("sum" + sum);
        return sum;
    }



    public String getCprnummer(int calc) {
        // 060876-1536
       String cprnummer = "";
        if (calc % 11 == 0) {
            cprnummer = "controlNumber = Modulus 11. Kontrolberegning er ok!";
        } else {
            cprnummer = "controlNumber = Modulus 11. Kontrolberegning er ikke ok! - Personnummer uden kontrolciffer";
        }
        // kontrolnummer 270
        return cprnummer;
    }
}



