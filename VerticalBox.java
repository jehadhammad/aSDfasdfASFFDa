package ProjectMartyr;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class VerticalBox {
    private BorderPane pane;
    private ComboBox<String> combo;
    private Button submitButton;
    private Button clearButton;
    private TextField textField;
    private TextField textField1;
    private Label labelChange;

    public VerticalBox() {
        labelChange = new Label("");
       VBox vbox = new VBox(10);
        Label label = new Label("Test your memory");
        label.setFont(Font.font(25));
        Label label1 = new Label("hey.my frind! Test your memory to see if you remember who was martyerd before.");
        label1.setFont(Font.font(13));
        Label label2 = new Label(" pick two Martyr from the following list ,enter the them in the boxes in the correct order (date of death), and than press the submit button");
        label2.setFont(Font.font(10));
        pane =new BorderPane();

        vbox.getChildren().addAll(label, label1, label2);
        vbox.setAlignment(Pos.CENTER);
        pane.setTop(vbox);

        VBox vbox1 = new VBox(10);
        textField = new TextField();
        Label label3 = new Label("martyred beford:");
        label3.setFont(Font.font(13));
        textField1 = new TextField();
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        hBox.getChildren().addAll(textField, label3, textField1);


        VBox vbox2 = new VBox(10);
        submitButton = new Button("Submit");
        clearButton = new Button("Clear");
        String[] colors = {"Red", "Green", "Blue", "yellow"};
        ObservableList<String> list = FXCollections.observableArrayList(colors);
        combo = new ComboBox<String>();
        combo.getItems().addAll(list);
        vbox.setPadding(new Insets(10));
        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.BOTTOM_CENTER);
        hbox.getChildren().addAll(submitButton, clearButton, combo);
        vbox1.getChildren().addAll(hBox,hbox,labelChange);
        vbox1.setAlignment(Pos.CENTER);

        vbox1.setPadding(new Insets(10));
        pane.setBottom(vbox1);

    }

    public Label getLabelChange() {
        return labelChange;
    }

    public void green() {
        pane.setStyle("-fx-background-color: green");
    }
    public void red() {
        pane.setStyle("-fx-background-color: red");
    }
    public void yellow() {
        pane.setStyle("-fx-background-color: yellow");
    }
    public void blue() {
        pane.setStyle("-fx-background-color: blue");
    }

    public BorderPane getPane() {
        return pane;
    }

    public void setPane(BorderPane pane) {
        this.pane = pane;
    }

    public ComboBox<String> getCombo() {
        return combo;
    }

    public void setCombo(ComboBox<String> combo) {
        this.combo = combo;
    }

    public Button getSubmitButton() {
        return submitButton;
    }

    public void setSubmitButton(Button submitButton) {
        this.submitButton = submitButton;
    }

    public Button getClearButton() {
        return clearButton;
    }

    public void setClearButton(Button clearButton) {
        this.clearButton = clearButton;
    }

    public TextField getTextField() {
        return textField;
    }

    public void setTextField(TextField textField) {
        this.textField = textField;
    }

    public TextField getTextField1() {
        return textField1;
    }

    public void setTextField1(TextField textField1) {
        this.textField1 = textField1;
    }
}
