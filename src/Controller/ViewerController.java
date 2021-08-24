package Controller;
import Model.Encrypter_Decrypter;
import Security.Generator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.controlsfx.control.Notifications;

public class ViewerController implements Initializable {

    @FXML
    private Label eleb;
    @FXML
    private Label dleb;
    @FXML
    private JFXButton ebtn;
    @FXML
    private JFXTextField etxt;
    @FXML
    private JFXButton dbtn;
    @FXML
    private JFXTextField dtxt;
    @FXML
    private JFXButton rbtn;
    @FXML
    private JFXButton cbtn;
    static Image image ;
    static ImageView view;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        imageButton("copy.png", cbtn);
        imageButton("refresh.png", rbtn);
        rbtn.setDisable(true);
        cbtn.setDisable(true);
    }    

    @FXML
    private void encryptText(ActionEvent event) {
        if(etxt.getText().equals(""))
            Notification("Enter Text");
        else{
            rbtn.setDisable(false);
            cbtn.setDisable(false);
            eleb.setText(Generator.encryptor(etxt.getText()));
        }
    }

    @FXML
    private void decryptText(ActionEvent event) {
        if(dtxt.getText().equals(""))
            Notification("Enter Text");
        else
            dleb.setText(Generator.decryptor(dtxt.getText()));
    }

    @FXML
    private void refresh(ActionEvent event) {
        if(etxt.getText().equals(""))
            Notification("Enter Text");
        else
            eleb.setText(Generator.encryptor(etxt.getText()));
    }

    @FXML
    private void close(ActionEvent event) {
        Encrypter_Decrypter.stg.close();
    }

    @FXML
    private void copy(ActionEvent event) {
        if(etxt.getText().equals(""))
            Notification("Enter Text");
        else{
            StringSelection stringSelection = new StringSelection(eleb.getText());
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            Notification("Text Copied");
        }
    }
    

    public static void Notification(String Messages){
        Notifications noti = Notifications.create()
            .title("Notification")
            .text(Messages)
            .hideAfter(javafx.util.Duration.seconds(5))
            .position(Pos.BOTTOM_RIGHT);
        noti.show();
    }

    public static void imageButton(String imageName, JFXButton button){
        image = new Image(new File("images/"+imageName).toURI().toString());
        view = new ImageView(image);
        view.setFitWidth(30);
        view.setFitHeight(30);
        view.setPreserveRatio(true);
        button.setGraphic(view);
    }
}
