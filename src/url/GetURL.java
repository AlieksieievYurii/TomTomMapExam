package url;

import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.Optional;

public class GetURL
{
   public static String getURL()
   {
       TextInputDialog textInputDialog = new TextInputDialog();
       textInputDialog.setTitle("URL");
       textInputDialog.setHeaderText("Enter URL for parsing JSON");
       ImageView imageView = new ImageView("sample/logo.png");
       imageView.setFitHeight(50);
       imageView.setFitWidth(50);
       textInputDialog.setGraphic(imageView);

       Stage stage = (Stage) textInputDialog.getDialogPane().getScene().getWindow();

        // Add a custom icon.
       stage.getIcons().add(new Image("sample/logo.png"));

       Optional<String> optionalS = textInputDialog.showAndWait();

       return optionalS.orElse(null);
   }

}
