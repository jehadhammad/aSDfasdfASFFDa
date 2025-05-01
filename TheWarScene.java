package ProjectMartyr;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class TheWarScene {
    private Button createMartyr;
    private Button memoryTest;
    private VBox vbox;
    public TheWarScene(){
        vbox =new VBox(10);
        vbox.setAlignment(Pos.CENTER);
        createMartyr = new Button("Create Martyr list window");
        memoryTest = new Button("Memory Test window");
        vbox.getChildren().addAll(createMartyr,memoryTest);

    }

    public Button getCreateMartyr() {
        return createMartyr;
    }

    public void setCreateMartyr(Button createMartyr) {
        this.createMartyr = createMartyr;
    }

    public Button getMemoryTest() {
        return memoryTest;
    }

    public void setMemoryTest(Button memoryTest) {
        this.memoryTest = memoryTest;
    }

    public VBox getVbox() {
        return vbox;
    }

    public void setVbox(VBox vbox) {
        this.vbox = vbox;
    }
}
