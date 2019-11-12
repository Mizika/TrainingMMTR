package first.task;

import java.io.File;
import java.util.List;
import java.util.ArrayList;

import static first.task.ReadAllFromFile.filePath;

public class SearchDictionary {
    public static void searchFiles(){
        System.out.println("Найденные словари:");
        List<String> listDic = new ArrayList<>();
        File dic = new File(filePath);
        int i = 1;
        if(dic.isDirectory()){
            for(File item : dic.listFiles()){
                String result = i++ + ". " + item.getName();
                listDic.add(result);
            }
        }else {
            System.out.println("Не найдена папка со словарями!");
        }
        System.out.println(listDic);
    }
}
