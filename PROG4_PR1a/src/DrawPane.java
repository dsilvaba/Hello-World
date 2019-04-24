import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DrawPane extends BorderPane {
	private int size = 180;
	private Rectangle rectangle;

	public DrawPane() {
		this.setPrefHeight(350);
		this.setPrefWidth(380);
		rectangle = new Rectangle();
		rectangle.setFill(Color.RED);
		rectangle.setHeight(size);
		rectangle.setWidth(size);
		rectangle.setStroke(Color.BLACK);
		rectangle.setStrokeWidth(2);
		this.setCenter(rectangle);
	}

	public void setColor(Color color) {
		rectangle.setFill(color);
	}

	public void setSize(double scale) {
		rectangle.setWidth(size * scale);
		 rectangle.setHeight(size * scale);

	}

}
