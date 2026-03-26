import java.io.*;
import java.util.*;

public class Priklad2 {
    public static void main(String[] args) {
    String soubor = "slova_opravene.txt";
        List<String> slova = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(soubor))) {
            String radek;
            while ((radek = br.readLine()) != null) {
                if(!radek.isEmpty()){
                    slova.add(radek.trim());
                }
            }
        } catch (IOException e){
            System.out.println("Chyba při čtení souboru.");
            return;
        }


        int pocet = slova.size();
        int soucetDelky = 0;
        String nejdelsi = "";
        String nejkratsi = slova.get(0);

        for (String slovo : slova) {
            soucetDelky += slovo.length();

            if (slovo.length() > nejdelsi.length()) {
                nejdelsi = slovo;
            }

            if (slovo.length() < nejkratsi.length()) {
                nejkratsi = slovo;
            }
        }

        double prumer = (double) soucetDelky / pocet;


        try(BufferedWriter bw = new BufferedWriter(new FileWriter("statistika.txt"))){
            bw.write("Počet slov: " + pocet + "\n");
            bw.write("Průměrná délka: " + prumer + "\n");
            bw.write("Nejdelší slovo: " + nejdelsi + "\n");
            bw.write("Nejkratší slovo: " + nejkratsi + "\n");
        } catch (IOException e) {
            System.out.println("Chyba při zápisu");
        }


        Scanner sc = new Scanner(System.in);

        System.out.print("Zadej část slova: ");
        String hledane =  sc.nextLine();
        System.out.println("Nalezená slova:");

        for (String slovo : slova) {
            if (slovo.contains(hledane)) {
                System.out.println(slovo);
            }
        }



    }
}