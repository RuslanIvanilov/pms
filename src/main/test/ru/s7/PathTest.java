package ru.s7;

import org.junit.Test;

import java.io.*;
import java.lang.reflect.Field;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class PathTest {

    @Test
    public void shouldCheckPath(){
        Properties properties = getPropertyFromFile("app.properties");

        System.out.println("Read from property : " +  properties.getProperty("main-frame-title") );

        properties.forEach((key, val) -> System.out.println("[" + key + "] " + val));

    }


    public Properties getPropertyFromFile(String fillPathFile){
        InputStream input = getClass().getClassLoader().getResourceAsStream( fillPathFile);  //"app.properties"
        Properties properties = new Properties();
        try {
            properties.load(input);
        }catch(IOException e){
            e.printStackTrace();
        }

        return properties;
    }

    @Test
    public void shouldGetFilesByPath(){
        Properties properties = getPropertyFromFile("app.properties");
        String path  = properties.getProperty("main-frame-template-path");
        // /Users/ruaiar2/prj/pms/target/test-classes/app.properties
        String directoryPath = getPathByProperty();
        File folder = new File(directoryPath+path);

        File[] files = folder.listFiles();

        /*
        String[] files =  folder.list(new FilenameFilter() {
            @Override public boolean accept(File folder, String name){
                return name.endsWith(".jrxml");
            }
        });
        */

        for(File file : files){
            System.out.println("File: " + file.getName());
        }
    }

    public String getPathByProperty() {
        URL resource = getClass().getClassLoader().getResource("app.properties");
        String path = resource.getPath();
        Path folderPath = Paths.get(path);
        String directory = folderPath.getParent().toString();
        return directory;
    }



}
