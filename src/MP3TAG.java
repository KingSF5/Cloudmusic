import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.id3.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class MP3TAG {

    public void setInfo(List<String> info, String lyr, String filename) throws TagException, CannotWriteException, ReadOnlyFileException, CannotReadException, InvalidAudioFrameException, IOException {
        MP3File f = new MP3File(new File(filename));
        AbstractID3v2Tag tag = f.getID3v2Tag();
        tag.setField(FieldKey.TITLE,info.get(0));
        tag.setField(FieldKey.ARTIST,info.get(1));
        tag.setField(FieldKey.ALBUM,info.get(2));
        tag.setField(FieldKey.LYRICS,lyr);
        f.commit();
    }
}
