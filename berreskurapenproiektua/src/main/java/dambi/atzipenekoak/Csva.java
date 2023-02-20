package dambi.atzipenekoak;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import dambi.pojoak.Abestia;
import dambi.pojoak.Abestiak;

public class Csva {
    String strFileIn;
    String strFileOut;

    public Csva(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Csva(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Abestiak irakurri() throws IOException {
        Abestiak abestiak = new Abestiak();
        try (BufferedReader inputStream = new BufferedReader(new FileReader(strFileIn))){
            String banatzailea = ",";
            String l;
            int abestiaZenb = 0;
            while ((l = inputStream.readLine()) != null) {
                String [] zutabeak = l.split(banatzailea);
                if(abestiaZenb != 0) {
                    Abestia abestia = new Abestia();
                    abestia.setTitulo(zutabeak[0]);
                    abestia.setArtista(zutabeak[1]);
                    abestia.setAlbum(zutabeak[2]);
                    abestia.setDuracion(zutabeak[3]);
                    abestiak.add(abestia);
                }
                abestiaZenb++;
            }
            inputStream.close();
        } catch(FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        }
        return abestiak;
    }

    public int idatzi(Abestiak abestiak) throws IOException {
        int guztira = 0;
        try {
            PrintWriter outputStream = new PrintWriter(new FileWriter(strFileOut));
            outputStream.printf("%s;%s;%s;%s;", "Titulo", "Artista", "Album", "Duracion");

            for(int i = 0 ; i < abestiak.getAbestiak().size() ; i++) {
                outputStream.printf(Locale.US, "\n %d;%d;%d;%d;", abestiak.getAbestiak().get(i).getTitulo(), abestiak.getAbestiak().get(i).getArtista(), abestiak.getAbestiak().get(i).getAlbum(), abestiak.getAbestiak().get(i).getDuracion());
                guztira++;
            }
            outputStream.close();
        } catch(FileNotFoundException e) {
            System.out.println("Ez da fitxategia aurkitu");
        }
        return guztira;
    }
}