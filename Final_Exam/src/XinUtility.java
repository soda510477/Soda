
import java.io.*;
import java.util.*;

public class XinUtility {
    public final String path = "release/String.txt";
    private static XinUtility instance;
    private  final List<String> texts = new ArrayList<>();
    public static XinUtility instance()
    {
        if(instance == null)
        {
            instance = new XinUtility();
        }
        return instance;
    }
    private void XinUtility()
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
    public String getString(final int index) 
    {
        return texts.get(index);
    }
}