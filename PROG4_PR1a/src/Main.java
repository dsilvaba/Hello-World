import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		MyScene myScene = new MyScene();
		primaryStage.setScene(myScene);
		primaryStage.setResizable(false);
		primaryStage.show();
		
	}

}
