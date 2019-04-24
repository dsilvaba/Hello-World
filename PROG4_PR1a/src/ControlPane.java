
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.control.Slider;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.util.StringConverter;

public class ControlPane extends BorderPane {
	private ButtonsPane buttonPane;
	private ListViewPane listViewPane;
	private DrawPane drawPane;
	private boolean useButtons = true;

	public ControlPane() {
		buttonPane = new ButtonsPane(this);
		listViewPane = new ListViewPane();
		drawPane = new DrawPane();
		BorderPane bPane = new BorderPane();
		bPane.setPrefSize(120, 350);
		bPane.setTop(buttonPane);
		bPane.setCenter(createSliderPane());
		this.setCenter(drawPane);
		this.setRight(bPane);

	}

	public void setColor(String value) {
		try {
			drawPane.setColor(Color.valueOf(value));
		} catch (Exception e) {
			drawPane.setColor(Color.WHITE);
		}
	}

	private VBox createSliderPane() {
		VBox sliderPane = new VBox();
		Slider slider = new Slider(0.5, 1.5, 1);
		slider.setRotate(90);

		slider.setLabelFormatter(new StringConverter<Double>() {
			@Override
			public String toString(Double object) {
				if (object <= 0.5)
					return "- 50%";
				if (object <= 1.0)
					return "0%";
				if (object <= 1.5)
					return "+ 50%";

				return "0%";
			}

			@Override
			public Double fromString(String string) {
				switch (string) {
				case "- 50%":
					return 0.5;
				case "0%":
					return 1.0;
				case "+ 50%":
					return 1.5;
				}

				return 1.0;
			}
		});

		slider.valueProperty().addListener(new MySliderListener());
		sliderPane.getChildren().add(slider);
		sliderPane.setPrefSize(120, 200);
		sliderPane.setAlignment(Pos.CENTER);
		sliderPane.setBackground(new Background(new BackgroundFill(Color.BEIGE, null, null)));
		return sliderPane;

	}

	private class MySliderListener implements ChangeListener<Number> {
		@Override
		public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
			drawPane.setSize(newValue.doubleValue());
		}
	}

}
