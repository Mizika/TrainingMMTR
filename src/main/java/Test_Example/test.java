package Test_Example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class test {
    public static void main(String[] args) throws IOException {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("11", "Value1");
        hashMap.put("22", "Value2");
        hashMap.put("33", "Value3");
        hashMap.put("44", "Value4");
        hashMap.put("55", "Value5");

        FileWriter fstream;
        BufferedWriter out;

        fstream = new FileWriter("C:\\Training\\dictionaries\\values1.txt");
        out = new BufferedWriter(fstream);

       for (Map.Entry entry : hashMap.entrySet()){
           out.write(entry.getKey() + " "+ entry.getValue() + "\n");
       }
        out.close();
        }
    }
