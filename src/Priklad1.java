import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Priklad1 {
    public static void main(String[] args) {

        Scanner sc =  new Scanner(System.in);

        System.out.println("Zadej titulek stránky: ");
        String titulek =  sc.nextLine();

        System.out.println("Zadej nadpis stránky: ");
        String nadpis =  sc.nextLine();

        System.out.println("Zadej název souboru s textem: ");
        String soubor =  sc.nextLine();

        List<String> odstavce = new ArrayList<>();

try(BufferedReader br = new BufferedReader(new FileReader(soubor))){
    String radek;
    while((radek = br.readLine()) != null){
        if (!radek.trim().isEmpty()){
            odstavce.add(radek.trim());
        }
    }
} catch (IOException e) {
    System.out.println("Chyba při čtení souboru.");
    return;
}

if (odstavce.size() < 3){
    System.out.println("Soubor musí obsahovat alespoň 3 odstavce.");
    return;
}

try(BufferedWriter bw = new BufferedWriter(new FileWriter("index.html"))){
    bw.write("<!DOCTYPE html>\n");
    bw.write("<html>\n");
    bw.write("<head>\n");
    bw.write("<title>" + titulek + "</title>\n");
    bw.write("</head>\n");
    bw.write("<body>\n");
    bw.write("<h1>" + nadpis + "</h1>\n");

    for(String odstavec : odstavce){
        bw.write("<p>" + odstavec + "</p>\n");
    }

    bw.write("</body>\n");
    bw.write("</html>\n");
} catch (IOException e) {
    System.out.println("Chyba při zápisu.");
}

System.out.println("HTML soubor vytvořen (index.html)");













    }
}
