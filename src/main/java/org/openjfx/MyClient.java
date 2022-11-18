package org.openjfx;

import javafx.scene.layout.VBox;

import java.io.DataOutputStream;
import java.net.Socket;


public class MyClient extends VBox {
    public static  void main(String[] args){
        try {
            Socket s = new Socket("10.10.26.241", 6666);
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            dout.writeUTF("1");
            dout.flush();
            s.close();
        } catch (Exception e){
            System.err.println(e);
        }
    }
}
