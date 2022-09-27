package br.com.worldcupbetwebapp.cliente;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class WorldCupBetClient {

	public List<Bet> getAll() throws Exception {
		try {
			Client client = Client.create();
			ObjectMapper mapper = new ObjectMapper();
			List<Bet> listBet = new ArrayList<Bet>();

			WebResource webResource = client.resource("http://localhost:8080/WorldCupBetWebApp/BetSon/getAll");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
						
			listBet = mapper.readValue(output, ArrayList.class);
			
			return listBet;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Bet getByName(String name) throws Exception {
		try {
			Client client = Client.create();
			ObjectMapper mapper = new ObjectMapper();
			Bet bet = new Bet();

			WebResource webResource = client.resource(String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/getByName?punterName=%s", name));

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
						
			bet = mapper.readValue(output, Bet.class);

			return bet;
		} 
		catch (Exception e) {
			e.printStackTrace();
			return null;			
		}		
	}
	
	public void update(String name, String team, String value) throws Exception {
		try {
			Client client = Client.create();
						
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/updateBet?punterName=%s&teamOnWhichBet=%s&betValue=%s", name, team, value);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").put(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void delete(String name) throws Exception {
		try {
			Client client = Client.create();
						
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/delete?punterName=%s", name);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").delete(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public void addBet(String name, String team, String value) throws Exception {
		try {
			Client client = Client.create();
			
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/addBet?punterName=%s&teamOnWhichBet=%s&betValue=%s", name, team, value);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").post(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
