package ProjectMartyr;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;


public class TestMemory extends Application  {
    private ArrayList<Martyr> listOfMartyrs = new ArrayList<>();
    private Label[] labels;

    @Override
    public void start(Stage primaryStage) throws Exception {
        TheWarScene gaza = new TheWarScene();
        Scene scene = new Scene(gaza.getVbox(), 300, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("the war on gaza");
        primaryStage.show();

        gaza.getMemoryTest().setOnAction(e -> {
            System.out.println("2");

            readFile();
            int z = listOfMartyrs.size();
            labels = new Label[z]; // Initialize the labels array with size z
            System.out.println("3");

            FlowPane pane = new FlowPane();
            pane.setVgap(10);
            pane.setHgap(10);

            for (int i = 0; i < listOfMartyrs.size(); i++) {
                System.out.println("0");
                labels[i] = new Label();
                labels[i].setText(listOfMartyrs.get(i).getName());
                System.out.println("1");
                labels[i].setFont(Font.font(20));
                pane.getChildren().add(labels[i]);
            }
            pane.setAlignment(Pos.CENTER);
            VerticalBox vb = new VerticalBox();
            vb.getPane().setCenter(pane);
            Scene scene1 = new Scene(vb.getPane(), 800, 500);
            primaryStage.setScene(scene1);
            primaryStage.setTitle("Memory test");
            primaryStage.show();

            vb.getCombo().setOnAction(actionEvent -> {
                if (vb.getCombo().getSelectionModel().getSelectedItem().equals("Green")) {
                    vb.green();
                } else if (vb.getCombo().getSelectionModel().getSelectedItem().equals("Red")) {
                    vb.red();
                } else if (vb.getCombo().getSelectionModel().getSelectedItem().equals("yellow")) {
                    vb.yellow();
                } else if (vb.getCombo().getSelectionModel().getSelectedItem().equals("Blue")) {
                    vb.blue();
                }
            });

            vb.getClearButton().setOnAction(ev -> {
                vb.getTextField().clear();
                vb.getTextField1().clear();
            });
            vb.getSubmitButton().setOnAction(ev -> {
                String firstName = vb.getTextField().getText();
                String secondName = vb.getTextField1().getText();

                if (firstName.isEmpty() || secondName.isEmpty()) {
                    System.out.println("Enter names in both boxes. Then press Submit.");
                    return;
                }

                Martyr firstMartyr = null;
                Martyr secondMartyr = null;

                for (Martyr martyr : listOfMartyrs) {
                    if (martyr.getName().equalsIgnoreCase(firstName)) {
                        firstMartyr = martyr;
                    }
                    if (martyr.getName().equalsIgnoreCase(secondName)) {
                        secondMartyr = martyr;
                    }
                }

                if (firstMartyr == null && secondMartyr == null) {
                    vb.getLabelChange().setText("Neither entry is in the name list.");

                } else if (firstMartyr == null) {
                    vb.getLabelChange().setText("First entry not in name list – check spelling.");
                } else if (secondMartyr == null) {
                    vb.getLabelChange().setText("Second entry not in name list – check spelling.");
                } else if (firstMartyr.getName().equalsIgnoreCase(secondMartyr.getName())) {
                    vb.getLabelChange().setText("You entered the same names. Try again.");
                } else if (firstMartyr.getDateOfMartyrdom().compareTo(secondMartyr.getDateOfMartyrdom()) < 0) {
                    vb.getLabelChange().setText("Wrong. Try again.");
                } else {
                    vb.getLabelChange().setText("Correct order. Well done!");
                }
            });

        });

        gaza.getCreateMartyr().setOnAction(e -> {
            AddMartyr ad = new AddMartyr();
            Scene scene2 = new Scene(ad.gethBox(), 600, 150);
            primaryStage.setScene(scene2);
            primaryStage.setTitle("Add a martyr to the file");

            ad.getAddFile().setOnAction(ev -> {
                if (!ad.getTextField().getText().equals("")) {
                    String s = ad.getTextField().getText();
                    addToFile(s);
                    System.out.println("done adding");
                    ad.getTextField().clear();
                }
            });

            primaryStage.show();
        });
    }

    public void addToFile(String string) {
        try (DataOutputStream dout = new DataOutputStream(new FileOutputStream("C:\\Users\\HP\\IdeaProjects\\demoFX\\MartyrList.dat", true))) {
            dout.writeUTF(string);
            dout.writeUTF("\n");  // Read the newline character to move to the next line
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void readFile() {
        System.out.println("1");
        File file = new File("C:\\Users\\HP\\IdeaProjects\\demoFX\\MartyrList.dat");
        try (DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file))) {
            while (dataInputStream.available() > 0) {
                String line = dataInputStream.readUTF();
                String[] s = line.split(" ");
                if (s.length == 2) {
                    System.out.println("1");
                    String name = s[0];
                    String date = s[1];
                    listOfMartyrs.add(new Martyr(name, date));
                }
            }


        } catch (IOException e) {
            System.out.println("File Not Found... Creating File...");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                    readFile();
                } catch (IOException e2) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Label[] getLabels() {
        return labels;
    }

    public void setLabels(Label[] labels) {
        this.labels = labels;
    }

}