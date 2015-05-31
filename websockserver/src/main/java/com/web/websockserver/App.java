package com.web.websockserver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
 
import org.glassfish.tyrus.server.Server;


public class App 
{
    public static void main( String[] args )
    {
       runServer();
    	//System.out.println("Hello");
    }


	public static void runServer()
	{
	    Server server = new Server("localhost", 9000, "/websockets", Webserver.class);
	
	    try {
	        server.start();
	        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	        System.out.print("Please press a key to stop the server.");
	        reader.readLine();
	    } catch (Exception e) {
	        throw new RuntimeException(e);
	    } finally {
	        server.stop();
	    }
	}

}
