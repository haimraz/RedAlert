package main;
import java.io.IOException;
import com.sun.jersey.api.container.httpserver.HttpServerFactory;
import com.sun.net.httpserver.HttpServer;

/**
 *  Created by Haim Raitsev on 20/05/2015.
 */
public class MainServer {
    public static void main(String[] args) throws IOException {
    	
        HttpServer server = HttpServerFactory.create("http://0.0.0.0:9999/");
        server.start();
    	
        System.out.println("Server running");
        System.out.println("Hit return to stop...");
        System.in.read();
        System.out.println("Stopping server");
        server.stop(0);
        System.out.println("Server stopped");

    }
}