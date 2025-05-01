package ProjectMartyr;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AddMartyr {
    private HBox hBox;
    private TextField textField;
    private Button addFile;
    public AddMartyr() {
        hBox = new HBox(10);
        Label l = new Label("Add Martyr :(Name of martyrdom)");

        textField = new TextField();
        addFile =new Button("Add to Files");
        hBox.getChildren().addAll(l,textField,addFile);
        hBox.setAlignment(Pos.CENTER);


    }

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public Button getAddFile() {
        return addFile;
    }

    public void setAddFile(Button addFile) {
        this.addFile = addFile;
    }
}
