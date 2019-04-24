
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ButtonsPane extends VBox {
	private ControlPane controlPane;

	public ButtonsPane(ControlPane controlPane) {
		ToggleGroup tg = new ToggleGroup();
		MyMouseListener mouselistener = new MyMouseListener();
		this.controlPane = controlPane;

		RadioButton rbRed = new RadioButton("Red");
		rbRed.setSelected(true);
		rbRed.setOnMouseClicked(mouselistener);

		RadioButton rbBlue = new RadioButton("Blue");
		rbBlue.setSelected(false);
		rbBlue.setOnMouseClicked(mouselistener);

		RadioButton rbYellow = new RadioButton("Yellow");
		rbYellow.setSelected(false);
		rbYellow.setOnMouseClicked(mouselistener);

		tg.getToggles().addAll(rbRed, rbBlue, rbYellow);

		this.getChildren().addAll(rbRed, rbBlue, rbYellow);
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, null, null)));
	}

	private class MyMouseListener implements EventHandler<MouseEvent> {

		@Override
		public void handle(MouseEvent e) {
			String sender = ((RadioButton) e.getSource()).getText();
			controlPane.setColor(sender);

		}
	}

}
