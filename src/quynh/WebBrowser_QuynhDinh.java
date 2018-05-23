/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quynh;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class WebBrowser_QuynhDinh extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("MainBrowser.fxml"));

        Scene scene = new Scene(root);
        stage.setScene(scene);
        
        // set web browser's icon
        stage.getIcons().add(new Image(WebBrowser_QuynhDinh.class.getResourceAsStream("icon.png")));
        
        // set web browser's icon
        stage.setTitle("Power Rangers");
        
        // add a style sheet to the web browser
        scene.getStylesheets().add(WebBrowser_QuynhDinh.class.getResource("style.css").toExternalForm());
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
