package ru.s7.staff;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.Properties;

public class AppPropertySaver {
    static File file;

    public static void save(Properties prop){
        try {
            URL url = prop.getClass().getClassLoader().getResource("app.properties");
            file = new File( url.getPath() );
            FileOutputStream fr = new FileOutputStream(file);
            prop.store(fr, new Date().toGMTString());
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void save(Properties prop, String pathToProperty){
        try {
            file = new File( pathToProperty );
            FileOutputStream fr = new FileOutputStream(file);
            String comments = "";
            prop.store(fr, comments);
            fr.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
