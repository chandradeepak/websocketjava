package com.web.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.concurrent.CountDownLatch;
import java.util.logging.Logger;
 
import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.DeploymentException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.glassfish.tyrus.client.ClientManager;
public class App 
{
	 private static CountDownLatch latch;
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );      
       
            latch = new CountDownLatch(1);
     
            ClientManager client = ClientManager.createClient();
            try {
                client.connectToServer(WebSocketClient.class, new URI("ws://localhost:9000/websockets/webserver"));
                latch.await();
     
            } catch (DeploymentException | URISyntaxException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        
        
    }
}
