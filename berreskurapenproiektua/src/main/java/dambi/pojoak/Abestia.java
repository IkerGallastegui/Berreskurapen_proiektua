package dambi.pojoak;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement( name = "Abestia" )

public class Abestia {
    String titulo;
    String artista;
    String album;
    String duracion;

    public String getTitulo() {
        return titulo;
    }
    public String getArtista() {
        return artista;
    }
    public String getAlbum() {
        return album;
    }
    public String getDuracion() {
        return duracion;
    }

    @XmlElement(name = "titulo")
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @XmlElement(name = "artista")
    public void setArtista(String artista) {
        this.artista = artista;
    }
    @XmlElement(name = "album")
    public void setAlbum(String album) {
        this.album = album;
    }
    @XmlElement(name = "duracion")
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Abestia [titulo=" + titulo + ", artista=" + artista + ", album=" + album + ", duracion=" + duracion + "]";
    }
}