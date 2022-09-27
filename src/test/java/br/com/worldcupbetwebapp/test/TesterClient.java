package br.com.worldcupbetwebapp.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.worldcupbetwebapp.cliente.Bet;

public class TesterClient {
	@Test
	public void getAll() throws Exception {
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
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void getByName() throws Exception {
		try {
			Client client = Client.create();
			ObjectMapper mapper = new ObjectMapper();
			Bet bet = new Bet();

			WebResource webResource = client.resource("http://localhost:8080/WorldCupBetWebApp/BetSon/getByName?punterName=Pedro");

			ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
			}

			String output = response.getEntity(String.class);
						
			bet = mapper.readValue(output, Bet.class);

			Assert.assertTrue(bet.getPunterName().equals("Pedro"));
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void update() throws Exception {
		try {
			Client client = Client.create();
			
			String name = "Dickson";
			String team = "Espanha";
			String value = ""+550;			
			
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/updateBet?punterName=%s&teamOnWhichBet=%s&betValue=%s", name, team, value);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").put(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void delete() throws Exception {
		try {
			Client client = Client.create();
			
			String name = "Dickson";		
			
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/delete?punterName=%s", name);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").delete(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Test
	public void addBet() throws Exception {
		try {
			Client client = Client.create();
			
			String name = "Erica";
			String team = "Brasil";
			String value = ""+870;	
			
			String url = String.format("http://localhost:8080/WorldCupBetWebApp/BetSon/addBet?punterName=%s&teamOnWhichBet=%s&betValue=%s", name, team, value);
			
			WebResource webResource = client.resource(url);

			webResource.accept("application/json").post(ClientResponse.class);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
