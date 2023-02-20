package dambi.atzipenekoak;

import java.io.File;

import dambi.pojoak.Abestiak;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

public class Xmla {
    String strFileIn;
    String strFileOut;

    public Xmla(String strFileIn){
        this.strFileIn = strFileIn;
    }

    public Xmla(String strFileIn,String strFileOut){
        this.strFileIn = strFileIn;
        this.strFileOut = strFileOut;
    }

    public Abestiak irakurri(){
        
        Abestiak abestiak = null;
        try{
           File file = new File( strFileIn);
           JAXBContext jaxbContext = JAXBContext.newInstance( Abestiak.class);

           Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
           abestiak = (Abestiak)jaxbUnmarshaller.unmarshal(file);
       
        }catch(JAXBException e){
           e.printStackTrace();
        }
       return abestiak;
   }

   public int idatzi(Abestiak abestiak){
    try{
        JAXBContext jaxbContext = JAXBContext.newInstance( Abestiak.class );
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );

        jaxbMarshaller.marshal( abestiak, new File( strFileOut ) );
        jaxbMarshaller.marshal( abestiak, System.out );
    }catch(JAXBException e){
        e.printStackTrace();
    }
    return abestiak.getAbestiak().size();
    }
}