import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetInfo {
    String url1;
    String url2;
    public GetInfo(String id){
        url1 = "http://music.163.com/api/song/detail/?ids=["+id+"]";
        url2 = "http://music.163.com/api/song/media?id="+id;
    }

    public List<String> getInfo() throws IOException {
        GetMethod con = new GetMethod();
        RegexMath re = new RegexMath();
        return re.reg(con.get(url1));
    }
    public String getlyric(){
        GetMethod g = new GetMethod();
        Pattern p = Pattern.compile("\"lyric\":\"(.*?)\",");
        Matcher m = p.matcher(g.get(url2));
        m.find();
        return m.group(1);
    }
    public byte[] getpic(String httpurl){
        byte[] data = null;
        GetMethod g = new GetMethod();
        try {
            URL url = new URL(httpurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                data = g.readInputStream(is);
                connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
