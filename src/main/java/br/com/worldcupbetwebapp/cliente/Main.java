package br.com.worldcupbetwebapp.cliente;

public class Main {
	public static void main(String args[]) throws Exception {
		WorldCupBetClient cliente = new WorldCupBetClient ();
		
		System.out.print(cliente.getByName("Pedro").getTeamOnWhichBet());
	}
	
}
