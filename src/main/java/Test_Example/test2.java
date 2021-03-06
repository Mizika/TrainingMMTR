package Test_Example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class test2 {

    private  Map<String, String> hashMap;
    private  String filePath;
    private  String fileName;

    public  Map<String, String> readerFromFile() {
        hashMap = new HashMap<>();
        File file=new File(filePath + fileName);
        try (BufferedReader readFromFile = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = readFromFile.readLine())!= null){
                String[] tmp = line.split(" ");
                hashMap.put(tmp[0], tmp[1]);
            }
            return hashMap;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public test2(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}