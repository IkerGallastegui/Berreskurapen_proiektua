package dambi.pojoak;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Abestiak" )
public class Abestiak {
    private List<Abestia> abestiak;

    public List<Abestia> getAbestiak() {
        return (List<Abestia>) (abestiak == null ? new ArrayList<>() : abestiak);
    }

    @XmlElement( name = "Abestia" )
    public void setAbestiak(List<Abestia> abestiak) {
        this.abestiak = abestiak;
    }

    public void add(Abestia abestia) {
        if (abestiak == null) {
            abestiak = new ArrayList<>();
        }
        abestiak.add(abestia);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Abestia museum : getAbestiak()) {
            str.append(museum.toString());
        }
        return str.toString();
    }
}