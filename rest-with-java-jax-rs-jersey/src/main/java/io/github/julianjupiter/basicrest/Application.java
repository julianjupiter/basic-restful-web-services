package io.github.julianjupiter.basicrest;

import io.github.julianjupiter.basicrest.server.GrizzlyServer;

public class Application extends javax.ws.rs.core.Application {
	
	private Application() {
		
	}
	
	public static void main(String[] args) throws Exception {
		GrizzlyServer.run(args);
	}
}
