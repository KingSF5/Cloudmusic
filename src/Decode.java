import java.io.*;

public class Decode {
    public byte[] de(String filename) throws IOException {
        byte[] insong = new GetMethod().readInputStream(new FileInputStream(new File(filename)));
        byte[] outsong = new byte[insong.length];
        for(int i = 0;i< insong.length;i++){
            outsong[i] = (byte) (insong[i] ^ (byte)0xa3);
        }
        return outsong;
    }

    public String decode(String source,String target) throws IOException {
        File file = new File(target);
        if(!file.exists()){
            file.createNewFile();
        }
        FileOutputStream out = new FileOutputStream(file);
        out.write(this.de(source));
        out.flush();
        out.close();
        return target;
    }
}
