import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class MyScene extends Scene {
	private ControlPane controlPane;

	public MyScene() {
		super(new Pane());
		// TODO Auto-generated constructor stub
		controlPane = new ControlPane();
		this.setRoot(controlPane);
	}

}
