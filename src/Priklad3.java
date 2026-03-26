import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Priklad3 {
    public static void main(String[] args) {
    List<String> zakazana = new ArrayList<>();
    List<String> text = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("zakazana_slova.txt"))) {
            String radek;

            while ((radek = br.readLine()) != null){
                zakazana.add(radek.trim().toLowerCase());
            }



        } catch (IOException e) {
            System.out.println("Chyba při čtení zakázaných slov.");
            return;
        }

        try(BufferedReader br = new BufferedReader(new FileReader("text_ke_kontrole.txt"))){
            String radek;
            while ((radek = br.readLine()) != null){
                text.add(radek);
            }
        } catch (IOException e) {
            System.out.println("Chyba při čtení textu.");
            return;
        }

        List<String> vysledek = new ArrayList<>();

        for (String veta : text){
            String upravena = veta;

            for (String zakazaneSlovo : zakazana){
                String hvezdy = "*".repeat(zakazaneSlovo.length());

                upravena = upravena.replaceAll("(?i)" + zakazaneSlovo, hvezdy);
            }
            vysledek.add(upravena);
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("text_cenzura.txt"))){
            for (String radek : vysledek){
                bw.write(radek);
                bw.newLine();
            }

        } catch (IOException e) {
            System.out.println("Chyba při zápisu.");
        }

        System.out.println("Cenzura dokončena");

    }
}
