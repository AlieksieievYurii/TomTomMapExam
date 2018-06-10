package url;

import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class GetFileFromURL
{
    private String url;

    public GetFileFromURL(String url)
    {
        this.url = url;
    }

    private Scanner getScanner(String urlPath)
    {
        Scanner scanner = null;
        try
        {
            URL url = new URL(urlPath);
            scanner = new Scanner(url.openStream());

        }catch (IOException ex)
        {
            System.out.println("Error of opening url!");
            return null;
        }
        return scanner;
    }

    public String getJsonText()
    {
        Scanner scn = getScanner(url);

        if(scn == null) return null;

        StringBuilder textJson = new StringBuilder();

        while(scn.hasNextLine())
        {
            textJson.append(scn.nextLine());
        }
        return textJson.toString();
    }
}
