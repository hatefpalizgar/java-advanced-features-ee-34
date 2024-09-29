package com.sda.p23_io;

import java.io.*;

public class Main {
    public static void main(String[] args) {

        // create a pointer/reference to the target file
        File myFile = new File("/Users/hatefpalizgar/Desktop/java-advanced-features-ee-34/src/main/java/com/sda/p23_io/input.txt");

        // read from a file
        readFromFile(myFile);

        // write to a file
        writeToFile(myFile);

        // write an object to a file
//        Car car = new Car("Ford", 5000);
//        writeObjectToFile(car);

        // read an object from a file
        File objFile = new File("/Users/hatefpalizgar/Desktop/java-advanced-features-ee-34/src/main/java/com/sda/p23_io/ford");
        readObjectFromFile(objFile);

    }

    private static void readFromFile(File myFile) {
    /* First solution using regular try-catch

    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader(myFile));
        String line;
        while((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     */

        /* Second solution using try-with-resources */
        // try-with-resources takes care of closing all resources automatically
        try (BufferedReader reader = new BufferedReader(new FileReader(myFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(File myFile) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(myFile, true))) {
            // write() replaces/overwrites the file
            // writer.write("heeeeeeeey");
            writer.append("\nline added by writer");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeObjectToFile(Car car) {
        File file = new File("/Users/hatefpalizgar/Desktop/java-advanced-features-ee-34/src/main/java/com/sda/p23_io/ford");
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(file))) {
            stream.writeObject(car); // this will store car object in a file 'ford'
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readObjectFromFile(File objFile) {
        try (ObjectInputStream stream = new ObjectInputStream(new FileInputStream(objFile))) {
            Car readObject = (Car) stream.readObject();
            System.out.println(readObject);
            System.out.println(readObject.getPrice()); // 5000
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
