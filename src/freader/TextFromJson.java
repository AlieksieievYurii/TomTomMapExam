package freader;

import java.io.FileReader;
import java.util.Scanner;

public class TextFromJson
{
    public static String getTextFromFileReader(FileReader fileReader)
    {
        Scanner scanner = new Scanner(fileReader);

        StringBuilder textJson = new StringBuilder();

        while(scanner.hasNextLine())
        {
            textJson.append(scanner.nextLine());
        }
        return textJson.toString();
    }
}
