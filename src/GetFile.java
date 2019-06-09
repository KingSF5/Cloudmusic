import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class GetFile {
    public ArrayList<String> getFile(String path) {
        File file = new File(path);
        ArrayList<String> list = new ArrayList<String>();
        File[] array = file.listFiles();
        Pattern p = Pattern.compile(".idx|.uc|.info");
        Matcher m1;
        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile()) {
                m1 = p.matcher(array[i].getName());
                m1.find();
                if(m1.group(0).equals(".idx")||m1.group(0).equals(".uc")){
                    list.add(array[i].getName());
                }
            }
        }
        return list;
    }
}


