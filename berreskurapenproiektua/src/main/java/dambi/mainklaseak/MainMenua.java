package dambi.mainklaseak;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import dambi.atzipenekoak.Csva;
import dambi.atzipenekoak.Jsona;
import dambi.pojoak.Abestiak;
import dambi.atzipenekoak.Xmla;

public class MainMenua {
    
    public static void main(String[] args) {
        int aukera = 0;

        try {
            while (aukera != 3) {
                aukera = menuNagusiaErakutsi();
                switch (aukera) {
                    case 1:
                        Abestiak abestiak = new Abestiak();
                        String inportatzekoFitxategia1 = "data/Abestiak.csv";
                        String inportatzekoFitxategia2 = "data/Abestiak.xml";
                        String inportatzekoFitxategia3 = "data/Abestiak.json";
                        int inportatuAukera = inportatuMenua();
                        if (inportatuAukera == 1) {
                            Csva csva = new Csva(inportatzekoFitxategia1);
                            abestiak = csva.irakurri();
                            System.out.println(abestiak);
                        } else if (inportatuAukera == 2) {
                            Xmla xmla = new Xmla(inportatzekoFitxategia2);
                            abestiak = xmla.irakurri();
                            System.out.println(abestiak);
                        } else if (inportatuAukera == 3) {
                            Jsona jsona = new Jsona(inportatzekoFitxategia3);
                            abestiak = jsona.irakurri();
                            System.out.println(abestiak);
                        } else {
                            System.out.println("Bueltatzen...");
                        }
                        break;
                    case 2:
                        int exportatuAukera = exportatuMenua();
                        if (exportatuAukera == 1) {
                            Abestiak irakurritakoAbestiak = new Abestiak();
                            Csva csva2 = new Csva("data/Abestiak.csv", "data/Abestiak.csv");
                            irakurritakoAbestiak = csva2.irakurri();
                            int abestiakExportatuAukera = abestiakExportatu();
                            if (abestiakExportatuAukera == 1) {
                                Csva csva = new Csva("", "data/Abestiak.csv");
                                csva.idatzi(irakurritakoAbestiak);
                                System.out.println("Abestiak CSV-ra exportatu dira");
                            } else if (abestiakExportatuAukera == 2) {
                                Xmla xmla = new Xmla("", "data/Abestiak.xml");
                                xmla.idatzi(irakurritakoAbestiak);
                                System.out.println("Abestiak XML-ra exportatu dira");
                            } else if (abestiakExportatuAukera == 3) {
                                Jsona jsona = new Jsona("", "data/Abestiak.json");
                                jsona.idatzi(irakurritakoAbestiak);
                                System.out.println("Abestiak JSON-era exportatu dira");
                            } else {
                                System.out.println("Bueltatzen...");
                            }
                        } else if (exportatuAukera == 2) {

                            String rutaArchivo = "data/Abestiak.csv";

                            try (Scanner scanner = new Scanner(System.in);
                                    BufferedWriter bw = new BufferedWriter(new FileWriter(rutaArchivo, true))) {

                                System.out.print("Titulo: ");
                                String titulo = scanner.nextLine();
                                System.out.print("Artista: ");
                                String artista = scanner.nextLine();
                                System.out.print("Album: ");
                                String album = scanner.nextLine();
                                System.out.print("Duracion: ");
                                String duracion = scanner.nextLine();

                                bw.write('"' + titulo + '"' + ", " + '"' + artista + '"' + ", " + '"' + album + '"'
                                        + ", " + '"' + duracion + '"');
                                bw.newLine();

                                bw.flush();
                                bw.close();

                            } catch (IOException e) {
                                System.out.println("Error al insertar datos en el archivo CSV: " + e.getMessage());
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Agur");
                        break;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Errorea egon da: " + e);
        } catch (Exception e) {
            System.out.println("Errorea egon da: " + e);
        }
    }

    private static int menuNagusiaErakutsi() {
        Scanner in = new Scanner(System.in);
        
        System.out.println("MENU NAGUSIA");
        System.out.println("-------------------------");
        System.out.println("1.Erakutsi");
        System.out.println("2.Idatzi");
        System.out.println("3.Irten");
        System.out.println("---------------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int inportatuMenua() {
        Scanner in = new Scanner(System.in);

        System.out.println("INPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Abestiak erakutsi CSV-tik");
        System.out.println("2-Abestiak erakutsi XML-tik");
        System.out.println("3-Abestiak erakusti JSON-etik");
        System.out.println("4-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }

    private static int exportatuMenua() {
        Scanner in = new Scanner(System.in);

        System.out.println("EXPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Abestiak beste fitxategi batera exportatu");
        System.out.println("2-Abesti berria eskuz sartu");
        System.out.println("3-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");        
        int aukera = in.nextInt();
        return aukera;
    }

    private static int abestiakExportatu() {
        Scanner in = new Scanner(System.in);

        System.out.println("ABESTIAK EXPORTATZEKO MENUA");
        System.out.println("-------------------------");
        System.out.println("1-Abestiak CSV-ra exportatu");
        System.out.println("2-Abestiak XML-ra exportatu");
        System.out.println("3-Abestiak JSON-era exportatu");
        System.out.println("4-Irten");
        System.out.println("-----------------------");
        System.out.print("Sartu zenbaki bat: ");
        int aukera = in.nextInt();
        return aukera;
    }
}