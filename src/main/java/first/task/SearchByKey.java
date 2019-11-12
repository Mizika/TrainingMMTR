package first.task;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SearchByKey {
    private static String filePath = "C:\\Training\\dictionaries\\";
    private static BufferedReader readFromConsole = new BufferedReader(new InputStreamReader(System.in));

    public static void readFromFileByKey(String fileName){

        File file=new File(filePath + fileName);
        Map<String, String> hashMap = new HashMap<>();
        hashMap.clear();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String result = sc.nextLine();
                String[] ar = result.split(" ");
                String num = ar[0];
                String word = ar[1];
                hashMap.put(num, word);
            }
            System.out.println("Введите ключ для поиска: ");
            String line = readFromConsole.readLine();
            for ( String key : hashMap.keySet() ) {
                if (key.equals(line)){
                    System.out.println(hashMap.get(line));
                    break;
                }
                else {
                    System.out.println("Значение по данному ключу не найдено!");
                    break;
                }
            }
            sc.close();
        }catch (Exception err){
            System.out.println(err.getMessage());
        }
    }
}
