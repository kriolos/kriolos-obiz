/*
 * Copyright (C) 2022 KriolOS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package io.github.kriolos.opos.basereport;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import javafx.fxml.JavaFXBuilderFactory;

/**
 * JavaFX App
 */
public class App extends Application {

    private static final String BASE = "/io/github/kriolos/opos/basereport";
    public static final String PR = BASE + "/primary.fxml";
    public static final String SEC = BASE + "/secondary.fxml";

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML(PR), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void setScene(Scene _scene) throws IOException {
        scene = _scene;
    }
    
    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        URL location = App.class.getResource(fxml);
        FXMLLoader fxmlLoader = new FXMLLoader(location);
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
