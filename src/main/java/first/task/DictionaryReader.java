package first.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DictionaryReader {

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

    public DictionaryReader(String filePath, String fileName) {
        this.filePath = filePath;
        this.fileName = fileName;
    }
}
