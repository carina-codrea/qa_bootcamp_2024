package petStore.utils;

import java.io.*;
import java.util.Random;

public class Utils {
    public static int generateRandomNumber(int maxNumber) {
        Random rand = new Random();
        return rand.nextInt(maxNumber) ;
    }
    public static void serializeToFile(Object classObject, String fileName) {
        try {
            FileOutputStream fileStream = new FileOutputStream(fileName);
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);
            objectStream.writeObject(classObject);
            objectStream.close();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object deserializeFromFile(String fileName) {
        Object deserializeObject =null;
        try {
            FileInputStream fileStream = new FileInputStream(new File(fileName));
            ObjectInputStream objectStream = new ObjectInputStream(fileStream);
            deserializeObject = objectStream.readObject();
            objectStream.close();
            fileStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return deserializeObject;
    }
}
