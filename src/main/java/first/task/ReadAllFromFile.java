package first.task;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReadAllFromFile {
    private static String filePath = "C:\\Training\\dictionaries\\";

    public static List<String> readAllFromFile(String fileName) {
        File file=new File(filePath + fileName);
        List<String> listResult = new ArrayList<>();
        try{
            Scanner sc = new Scanner(file);
            while(sc.hasNextLine()) {
                String result = sc.nextLine();
                listResult.add(result);
            }
            return listResult;
        }catch (Exception err){
            return Collections.singletonList(err.getMessage());
        }
    }
}
