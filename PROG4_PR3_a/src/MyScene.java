import java.util.Random;

import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class MyScene extends Scene {
	final private int size = 20;
	private Pane root;
	private double orgSceneX, orgSceneY;
	private double orgTranslateX, orgTranslateY;


	public MyScene() {
		super(new Pane());
		// TODO Auto-generated constructor stub
		root = new Pane();
		root.setOnMousePressed(new MousePressedEventHandler());
		root.setBackground(new Background(new BackgroundFill(Color.GREY, null, null)));
		setRoot(root);
	}

	class MousePressedEventHandler implements EventHandler<MouseEvent> {
		// de methode handle wordt aangeroepen als de mouse-button wordt ingedrukt
		Random rand = new Random();

		
		public void handle(MouseEvent e) {
			// voeg een nieuwe cirkel toe
			
			if (e.getSource() instanceof Circle) {
				System.out.println("why");
				orgSceneX = e.getSceneX();
				orgSceneY = e.getSceneY();
				Circle circle = (Circle) e.getSource();
				orgTranslateX = circle.getTranslateX();
				orgTranslateY = circle.getTranslateY();
				e.consume();

			} else {
				Circle circle = new Circle(size, Color.LIME);
				circle.relocate((e.getX() - size), (e.getY() - size));
				circle.setFill(Color.rgb(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
				circle.setCursor(Cursor.MOVE);
				circle.setOnMouseDragged(new MouseDraggedEventHandler());
				root.getChildren().add(circle);
			}
		}
	}

	class MouseDraggedEventHandler implements EventHandler<MouseEvent> {

		public void handle(MouseEvent t) {
			// wijzig de locatie van bestaande cirkel
			// TODO add implementation...
			
			Circle circle = (Circle) t.getSource();
			circle.relocate(t.getX()-size, t.getY()-size);
			double offsetX = t.getSceneX() - orgSceneX;
			double offsetY = t.getSceneY() - orgSceneY;
			double newTranslateX = orgTranslateX + offsetX;
			double newTranslateY = orgTranslateY + offsetY;
			circle.setTranslateX(newTranslateX);
			circle.setTranslateY(newTranslateY);

		}
	}

}
