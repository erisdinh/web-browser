/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quynh;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.web.WebView;

/**
 *
 * @author qinee
 */
public class MainBrowserController implements Initializable {

    @FXML
    private TextField textURL;
    @FXML
    private Button nextButton;
    @FXML
    private Button backButton;
    @FXML
    private WebView webView;

    WebBrowserModel model;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // disable back and next button
        nextButton.setDisable(true);
        backButton.setDisable(true);

        model = new WebBrowserModel();

        // set the webview background into Blend Mode Darken to hide the webview and show the background image
        webView.setBlendMode(BlendMode.DARKEN);
    }

    @FXML
    private void handleGo(ActionEvent event) {

        // get the url from the textfield
        String url = textURL.getText();

        // if there is no url in the textfield, not load the webview
        if (url.isEmpty()) {

        } else {

            // if the url is in the right form, then load that url
            if (url.startsWith("http://") || url.startsWith("https://")) {

                // if not, add "http://" at the beginning of the url
            } else {
                url = "http://" + url;
            }

            // try to open webpage here
            textURL.setText(url);
            webView.getEngine().load(url);
            
            // push the new url into the arraylist of web browser model
            model.push(url);

            // set the webview blend mode to show the webview
            webView.setBlendMode(BlendMode.SRC_OVER);

            // enable the back button and disable the next button
            backButton.setDisable(false);
            nextButton.setDisable(true);
        }
    }

    @FXML
    private void handleNext(ActionEvent event) {

        // get the return next url and assign it to the current url
        String currentUrl = model.next();

        // try to open the url
        textURL.setText(currentUrl);
        webView.getEngine().load(currentUrl);

        // get the next url
        String nextUrl = model.next();

        // if there is no next url, disable the the next button
        if (nextUrl == null) {
            nextButton.setDisable(true);

            // if there is a next url
            // currentIndex variable in WebBrowser will be increased by 1 and points to the next url
            // therefore back to the current url (currentIndex points the current url index)
        } else {
            model.prev();
        }

        // set the webview blend mode to show the webview
        webView.setBlendMode(BlendMode.SRC_OVER);

        // enable the back button
        backButton.setDisable(false);
    }

    @FXML
    private void handleBack(ActionEvent event) {

        // get the previous url and assign it to the current url
        String currentUrl = model.prev();

        // if there is no previous url, disable the back button
        if (currentUrl == null) {
            webView.setBlendMode(BlendMode.DARKEN);
            backButton.setDisable(true);
        } else {
            // set the webview blend mode to show the webview
            webView.setBlendMode(BlendMode.SRC_OVER);
        }

        // try to load the url
        textURL.setText(currentUrl);
        webView.getEngine().load(currentUrl);

        // enable the next button
        nextButton.setDisable(false);
    }
}
