package first.task;

import java.io.File;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class ReadAllFromFile {
    public static String filePath = "C:\\Training\\dictionaries\\";

    public static List<String> readAllFromFile(String fileName) {
        File file = new File(filePath + fileName);
        List<String> listResult = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                listResult.add(sc.nextLine());
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        return listResult;
    }
}
