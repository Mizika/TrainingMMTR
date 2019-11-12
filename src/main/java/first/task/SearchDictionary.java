package first.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SearchDictionary {
    private static String filePath = "C:\\Training\\dictionaries\\";

    public static void searchFiles(){
        System.out.println("Найденные словари:");
        List<String> listDic = new ArrayList<>();
        File dic = new File(filePath);
        int i = 1;
        if(dic.isDirectory()){
            for(File item : dic.listFiles()){
                String result = i++ +". " +item.getName();
                listDic.add(result);
            }
        }
        System.out.println(listDic);
    }
}
