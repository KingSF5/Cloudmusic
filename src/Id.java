import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Id {

    public String getIdOne(String filename){
        File file = new File(filename);
        BufferedReader reader = null;
        String tempString = null;
        try{
            reader = new BufferedReader(new FileReader(file));

            tempString = reader.readLine();
            reader.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        String regex = "\"musicId\":(.*?),";
        Pattern r = Pattern.compile(regex);
        Matcher ma = r.matcher(tempString);
        ma.find();
        tempString = ma.group(1);
        return tempString;
    }

    public String getIdTwo(String filename){
        Pattern p1 = Pattern.compile("\\\\(.*?-)\\d");
        Matcher m1 = p1.matcher(filename);
        m1.find();
        Pattern p2 = Pattern.compile("\\\\(.*?)-");
        Matcher m2 = p2.matcher(m1.group(1));
        m2.find();
        return m2.group(1);
    }
}