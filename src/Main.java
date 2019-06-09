
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, TagException, CannotWriteException, ReadOnlyFileException, InvalidAudioFrameException, CannotReadException {
        Scanner sc = null;
        sc = new Scanner(System.in);
        System.out.println("请输入缓存文件路径：");
        String pathOne  = sc.nextLine();
        System.out.println("请输入输出文件夹路径：");
        String pathTwo = sc.nextLine();
        GetFile file = new GetFile();
        int len = file.getFile(pathOne).size();
        ArrayList<String> list = file.getFile(pathOne);
        for(int i = 0;i < len;i = i+2) {
            GetInfo info = new GetInfo(new Id().getIdTwo(pathOne + "\\" + list.get(i)));
            List<String> INFO = info.getInfo();
            System.out.println(INFO);
            String lyr = info.getlyric();
            /**
             * 0--Song Name
             * 1--Aritist
             * 2--Album
             * 3--Album Picture URL
             * 4--Song playTime
             */
            /**
             * THIS IS JUST FOR TEST FUNCTIONS
             */
            MP3TAG mp = new MP3TAG();
            mp.setInfo(INFO, lyr, new Decode().decode(pathOne + "\\" + list.get(i + 1), pathTwo + "\\" + INFO.get(0) + "-" + INFO.get(1) + ".mp3"));
        }
    }
}
