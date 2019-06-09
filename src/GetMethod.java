import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetMethod {
    public String get(String httpurl) {
        String res = null;
        try {
            URL url = new URL(httpurl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            if (connection.getResponseCode() == 200) {
                InputStream is = connection.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                StringBuffer sbf = new StringBuffer();
                String tmp = null;
                while ((tmp = br.readLine()) != null) {
                    sbf.append(tmp);
                    sbf.append("\r\n");
                }
                res = sbf.toString();
                connection.disconnect();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public byte[] readInputStream(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len =0;
        while((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        in.close();
        out.close();
        return out.toByteArray();
    }
}
