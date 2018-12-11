package ba.unsa.etf.rpr.tutorijal8;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.File;

public class Controller {
    public TextField tekst;
    public ListView<String> lista;
    private ObservableList<String> observableList = FXCollections.synchronizedObservableList(FXCollections.observableArrayList());
    @FXML
    private Button btnZaustavi;
    @FXML
    private Button btnTrazi;
    public boolean isPressed = false;
    public Thread root;
    public void fileSearch(String pocetak, String rijec) {
        File root = new File(pocetak);
        File[] list = root.listFiles();
        if (list == null) {
            return;
        }
        for (File f : list) {
            if (f.isDirectory()) {
                fileSearch(f.getAbsolutePath(), rijec);
            } else {
                if (f.getAbsoluteFile().toString().contains(rijec)) {
                    Platform.runLater(() -> observableList.add(f.getAbsoluteFile().toString()));
                    lista.getItems().add(""+f.getAbsoluteFile());

                }
            }
        }
    }
    public void trazi(ActionEvent actionEvent) {
        isPressed=true;
        btnTrazi.setDisable(true);
        btnZaustavi.setDisable(false);
            root =  new Thread(() -> {
                if (!lista.getItems().isEmpty()) {
                    Platform.runLater(() -> lista.getItems().clear());
                }
                fileSearch("C:\\Users", tekst.getText());
                Platform.runLater(() -> lista.setItems(observableList));
            });
            root.start();

    }
    public void zaustavi(ActionEvent actionEvent) {
        root.stop();
    }
}
