package serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InvalidClassException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Jógvan 30/12-2015 16:14.
 */
public class Read<T> {

    ArrayList<T> objects = new ArrayList<>();
    String fileLocation;

    public Read(String file) {
        this.fileLocation = file;
        load();
    }

    public void add(T object) {
        objects.add(object);
        save();
    }

    public ArrayList<T> getObjects() {
        return objects;
    }


    public boolean load() {
        try {
            FileInputStream fileIn = new FileInputStream(fileLocation); //opret fil læsnings stream
            ObjectInputStream in = new ObjectInputStream(fileIn); //opret stream til objekter fra fil stream

            try {
                // gemmer alle objecter fra filen i objects arraylisten
                this.objects = (ArrayList<T>) in.readObject();
                return true;
            } catch (InvalidClassException e) {
                System.out.println("Der er kommet en fejl i læsning af objecterne. Du har sikkert ændret i klassen: " + e);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException i) {
            System.out.println("Filen eksisterer ikke endnu. Den bliver autogeneret nu.");
            createFile();
        } catch (IOException c) {
            System.out.println("Der er kommet en fejl i læsning af objecterne. \n Enten er .dat filen tøm eller har du ændret noget i klassen | error: " + c);
        }

        return false;
    }

    public boolean save() {
        FileOutputStream fileOut = null;
        ObjectOutputStream out = null;
        try {
            File yourFile = new File(fileLocation); //lav et fil object
            yourFile.createNewFile(); //lav filen

            fileOut = new FileOutputStream(fileLocation, false); //opret output stream til filen
            out = new ObjectOutputStream(fileOut); //opret en objekt stream til den output stream der går til filen

            out.writeObject(objects); //skriv arraylisten til fil - husk at Vare skal være Serializable
        } catch (IOException i) {
            i.printStackTrace();
            return false; //noget gik galt - return false;
        } finally {
            try {
                out.close(); //luk stream
                fileOut.close(); //luk filen
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    private void createFile() {
        try {
            File file = new File(fileLocation);
            file.createNewFile();
            System.out.println("Ny fil oprettet på dit system! \""+file.getCanonicalPath()+"\"");
        } catch (IOException ex) {
            Logger.getLogger(Read.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


}
