package serialization;

import adt.collections.GenericList;

import java.io.*;

/**
 * Created by Jógvan.
 */
public class ReadData<T> {

    GenericList<T> objects = new GenericList<>();
    String fileLocation;

    public ReadData(String file) {
        this.fileLocation = file;
        load();
    }

    public void add(T object) {
        objects.add(object);
        save();
    }

    public GenericList<T> getObjects() {
        load();
        return objects;
    }


    public boolean load() {
        try {
            FileInputStream fileIn = new FileInputStream(fileLocation); //opret fil læsnings stream
            ObjectInputStream in = new ObjectInputStream(fileIn); //opret stream til objekter fra fil stream

            try {
                // gemmer alle objecter fra filen i objects arraylisten
                this.objects = (GenericList<T>) in.readObject();
                return true;
            }catch (InvalidClassException e) {
                System.out.println("Der er kommet en fejl i læsning af objecterne. Du har sikkert ændret i klassen: " + e);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            System.out.println("Filen eksisterer ikke endnu. Den bliver autogeneret nu.");
            createFile();
        }catch(NotSerializableException e){
            System.out.println("Objekterne må implemtere interfacet Serializable");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Der er kommet en fejl i læsning af objecterne. \n Enten er .dat filen tøm eller har du ændret noget i klassen");
            e.printStackTrace();
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


            out.close(); //luk stream
            fileOut.close(); //luk filen
        }catch(NotSerializableException e){
            System.out.println("Objekterne må implemtere interfacet Serializable");
            e.printStackTrace();
        }catch (IOException i) {
            i.printStackTrace();
        }
        return true;
    }

    private void createFile() {
        try {
            File file = new File(fileLocation);
            file.createNewFile();
            System.out.println("Ny fil oprettet på dit system! \""+file.getCanonicalPath()+"\"");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
