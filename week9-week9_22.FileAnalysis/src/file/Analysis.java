/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Karma
 */
public class Analysis {
    
    private File file;
    private ArrayList<String> lines;

    public Analysis(File file) throws Exception{
        this.file = file;
        Scanner reader = new Scanner(file);
        lines = new ArrayList<String>();
        
        while(reader.hasNextLine()){
            lines.add(reader.nextLine());
        }
    }
    
    public int lines(){
        return lines.size();     
    }
    
    public int characters(){
        if(lines.isEmpty()){
            return 0;
        }
        int sum = lines.size();
        for(String string : lines){
            sum+= string.length();
        }
        return sum ;
    }
    
}
