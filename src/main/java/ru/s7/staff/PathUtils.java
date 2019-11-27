package ru.s7.staff;

import java.io.File;
import java.io.FilenameFilter;

public class PathUtils {

    private String[] getFilesArray(File folder, String fileExtencion){
        String[] files =  folder.list(new FilenameFilter() {
            @Override public boolean accept(File folder, String name){
                return name.endsWith(fileExtencion);
            }
        });
        return files==null? null : files;
    }

    public String[] getFiles(String jarPath, String fileExtencion ){
        return getFilesArray(new File(jarPath), fileExtencion);
    }

}
