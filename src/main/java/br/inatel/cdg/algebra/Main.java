package br.inatel.cdg.algebra;

import br.inatel.cdg.algebra.scene.ScenePrincipal;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        new ScenePrincipal().criaScenePrincipal(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
