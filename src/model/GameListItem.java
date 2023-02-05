package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 3, 2023
 */

@Entity
@Table(name = "gamesList")
public class GameListItem {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="GAME")
	private String gameName;
	@Column(name="MAXNUMOfPLAYERS")
	private int numOfPlayers;
	/**
	 * 
	 */
	public GameListItem() {
		super();
	}
	/**
	 * @param gameName
	 * @param numOfPlayers
	 */
	public GameListItem(String gameName, int numOfPlayers) {
		super();
		this.gameName = gameName;
		this.numOfPlayers = numOfPlayers;
	}
	/**
	 * @param id
	 * @param gameName
	 * @param numOfPlayers
	 */
	public GameListItem(int id, String gameName, int numOfPlayers) {
		super();
		this.id = id;
		this.gameName = gameName;
		this.numOfPlayers = numOfPlayers;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the gameName
	 */
	public String getGameName() {
		return gameName;
	}
	/**
	 * @param gameName the gameName to set
	 */
	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	/**
	 * @return the numOfPlayers
	 */
	public int getNumOfPlayers() {
		return numOfPlayers;
	}
	/**
	 * @param numOfPlayers the numOfPlayers to set
	 */
	public void setNumOfPlayers(int numOfPlayers) {
		this.numOfPlayers = numOfPlayers;
	}
	
	@Override
	public String toString() {
		return "GameListItem [id=" + id + ", gameName=" + gameName + ", numOfPlayers=" + numOfPlayers + "]";
	}
	/**
	 * @return
	 */
	public String returnItemDetails() {
		
		return "Game Name: " + gameName + ", Num Of Players: " + numOfPlayers;
	
	}
}
