package br.com.worldcupbetwebapp.cliente;

import java.io.Serializable;

public class Bet implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String punterName;
	private String teamOnWhichBet;	
	private double betValue;
	
	public String getPunterName() {
		return punterName;
	}
	public void setPunterName(String punterName) {
		this.punterName = punterName;
	}
	public String getTeamOnWhichBet() {
		return teamOnWhichBet;
	}
	public void setTeamOnWhichBet(String teamOnWhichBet) {
		this.teamOnWhichBet = teamOnWhichBet;
	}
	public double getBetValue() {
		return betValue;
	}
	public void setBetValue(double betValue) {
		this.betValue = betValue;
	}	
}
