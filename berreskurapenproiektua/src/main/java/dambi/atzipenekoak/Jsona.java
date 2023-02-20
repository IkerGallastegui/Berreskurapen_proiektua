package dambi.atzipenekoak;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonStructure;
import javax.json.JsonWriter;

import dambi.pojoak.Abestia;
import dambi.pojoak.Abestiak;

public class Jsona {
    String strFileIn;
    String strFileOut;

    public Jsona(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Jsona(String strFileIn, String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Abestiak irakurri() throws FileNotFoundException {
        Abestiak abestiak = new Abestiak();
        try {
            JsonReader reader = Json.createReader(new FileReader(strFileIn));
            JsonStructure jsonst = reader.read();
            JsonArray jsonarray = jsonst.asJsonArray();

            for (int i = 0 ; i < jsonarray.size() ; i++) {
                JsonObject jsonobj = jsonarray.getJsonObject(i);

                Abestia abestia = new Abestia();
                abestia.setTitulo(jsonobj.getString("titulo"));
                abestia.setArtista(jsonobj.getString("artista"));
                abestia.setAlbum(jsonobj.getString("album"));
                abestia.setDuracion(jsonobj.getString("duracion"));
                abestiak.add(abestia);
            }
        } catch (Exception e) {
            System.out.println("Arazoak " + strFileIn + " fitxategia irakurtzerakoan.");
        }
        return abestiak;
    }

    public int idatzi(Abestiak abestiak) {
        int abestiKopurua = 0;
        JsonArray model = null;
        JsonArrayBuilder jab = Json.createArrayBuilder();
        for (Abestia m : abestiak.getAbestiak()) {
            jab.add(Json.createObjectBuilder()
                    .add("titulo", m.getTitulo())
                    .add("artista", m.getArtista())
                    .add("album", m.getAlbum())
                    .add("duracion", m.getDuracion())
                    .build());
            abestiKopurua++;
        }
        model=jab.build();

        try (JsonWriter jsonWriter = Json.createWriter(new FileOutputStream(strFileOut))) {
            jsonWriter.writeArray(model);
        } catch (FileNotFoundException fnfe) {
            System.out.println("Fitxategia sortzerakoan arazoak.");
        }
        return abestiKopurua;
    }
}