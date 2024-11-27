package petStore.utils;

import com.google.gson.Gson;

import java.io.*;
import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
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

    public static String getCurrentDateTimeInFormat() {
        return DateTimeFormatter
                .ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
                .withZone(ZoneOffset.UTC)
                .format(Instant.now());
    }

    public static String convertObjectToJson(Object object) {
        Gson gson = new Gson();
        return gson.toJson(object);
    }

    public static <T> T convertJsonToObject(String json, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(json, clazz);
    }
}
