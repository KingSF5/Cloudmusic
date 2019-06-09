import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class RegexMath {
    public List<String> reg(String src) {
        List<String> INFO = new ArrayList<>();
        Pattern p = Pattern.compile("\\\"name\\\":\\\"(.*?)\\\",");
        Matcher m = p.matcher(src);
        for(int i =0;i<3;i++){
            m.find();
            INFO.add(m.group(1));       //get the info
        }
        Pattern p1 = Pattern.compile("\\\"album\\\":\\{.*?\\\"picUrl\\\":\\\"(.*?)\\\",");
        Matcher m1 = p1.matcher(src);
        m1.find();
        INFO.add(m1.group(1));          //get the pic url
        Pattern p2 = Pattern.compile("\\\"playTime\\\":(.*?),");
        Matcher m2 = p2.matcher(src);
        m2.find();
        INFO.add(m2.group(1));
        return INFO;
    }
}
