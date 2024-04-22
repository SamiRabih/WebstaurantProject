package com.webstaurantStore.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    //I created the properties object
    //make it private so we are limiting access to the object
    // static is to make sure its created and loaded before everything else and belong to class
    private static Properties properties = new Properties();// we creat properties object

    static {

        try {
            //I Open file using FileInputStream(open file)
            FileInputStream file = new FileInputStream("configuration.properties");
            //3-Load the properties object with file(load properties)
            properties.load(file);

            //I close the file in memory
            file.close();

            // I close the file in the memory
        } catch (IOException e) {
            System.out.println("FILE NOT FOUND WITH GIVEN PATH!!!");
            e.printStackTrace();
        }
    }
    //I create a utility method to use the object to read
    //I Use "properties" object to read from the file(read properties)
    public static String getProperty(String keyword) {
        return properties.getProperty(keyword);
    }
}
