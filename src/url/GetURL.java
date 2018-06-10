package url;

import javafx.scene.control.TextInputDialog;

import java.util.Optional;

public class GetURL
{
   public static String getURL()
   {
       TextInputDialog textInputDialog = new TextInputDialog();
       textInputDialog.setTitle("URL");
       textInputDialog.setHeaderText("Enter URL for parsing JSON");

       Optional<String> optionalS = textInputDialog.showAndWait();

       return optionalS.orElse(null);
   }

}
