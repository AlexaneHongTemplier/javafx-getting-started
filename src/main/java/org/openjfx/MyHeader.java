package org.openjfx;

import javafx.fxml.FXMLLoader;

import java.io.IOException;

public class MyHeader {
    public MyHeader() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Myheader.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }

    }
}
