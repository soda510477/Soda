
import java.io.*;
import java.util.*;

public class XinUtility {
    private static final List<String> texts = new ArrayList<>();

    public static void ReadNewTxt(final String path)
    {
        final FileInputStream  file;
        final BufferedReader  bufferFile;
        try
		{
        texts.clear();
        file = new FileInputStream(path);
        bufferFile = new BufferedReader(new InputStreamReader(file,"Big5"));
        while (bufferFile.ready()) {
            texts.add(bufferFile.readLine());
        }
        file.close();
        } catch (final FileNotFoundException e) {
            e.printStackTrace();
        } catch (final IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String getString(final int index) 
    {
        return texts.get(index);
    }
}