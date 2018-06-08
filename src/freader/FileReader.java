package freader;

import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/*This clas is for get File and get FileReader
* In this situation it's for my project MapTomTom*/
public class FileReader
{
    private Stage stage;

    public FileReader(Stage stage)
    {
        this.stage = stage;
    }

    public java.io.FileReader getFileReader()//Functions returns FileReader from java.io.FileReader
    {
        java.io.FileReader fileReader = null;
        File file = getFile();//get file

        try
        {
             fileReader = new java.io.FileReader(file);//get FileReader for parse json
        } catch (Exception e) {e.printStackTrace();}

        return fileReader;
    }

    public File getFile()//Function returns File
    {
        FileChooser fileChooser = new FileChooser();

        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("JSON files (*.json)","*.json");//This is filters of files

        fileChooser.getExtensionFilters().add(extensionFilter);//Set filters

        return fileChooser.showOpenDialog(stage);

    }
}
