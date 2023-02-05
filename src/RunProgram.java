import java.util.List;
import java.util.Scanner;

import controller.gameHelper;
import model.GameListItem;



/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 4, 2023
 */
public class RunProgram {

	static Scanner in = new Scanner(System.in);
	static gameHelper gh = new gameHelper();

	private static void addAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter a game: ");
		String gameName = in.nextLine();
		System.out.print("Enter number of players: ");
		int numOfPlayers = in.nextInt();
		GameListItem toAdd = new GameListItem(gameName,numOfPlayers);
		gh.insertItem(toAdd);
	}

	private static void deleteAnItem() {
		// TODO Auto-generated method stub
		System.out.print("Enter the game to delete: ");
		String gameName = in.nextLine();
		System.out.print("Enter the number to delete: ");
		int numOfPlayers = in.nextInt();
		GameListItem toDelete = new GameListItem(gameName,numOfPlayers);
		gh.deleteItem(toDelete);

	}

	private static void editAnItem() {
		// TODO Auto-generated method stub
		System.out.println("How would you like to search? ");
		System.out.println("1 : Search by game");
		System.out.println("2 : Search by max number of players");
		int searchBy = in.nextInt();
		in.nextLine();
		List<GameListItem> foundItems;
		if (searchBy == 1) {
			System.out.print("Enter the Game name: ");
			String gameName = in.nextLine();
			foundItems = gh.searchForGameByName(gameName);
		} else {
			System.out.print("Enter the max number of players: ");
			int numOfPlayers = in.nextInt();
			foundItems = gh.searchForGameByPlayerNum(numOfPlayers);

		}

		if (!foundItems.isEmpty()) {
			System.out.println("Found Results.");
			for (GameListItem l : foundItems) {
				System.out.println(l.getId() + " : " + l.toString());
			}
			System.out.print("Which ID to edit: ");
			int idToEdit = in.nextInt();

			GameListItem toEdit = gh.searchForItemById(idToEdit);
			System.out.println("Retrieved " + toEdit.getGameName() + " from " + toEdit.getGameName());
			System.out.println("1 : Update Name");
			System.out.println("2 : Update Player Number");
			int update = in.nextInt();
			in.nextLine();

			if (update == 1) {
				System.out.print("New game name: ");
				String newName = in.nextLine();
				toEdit.setGameName(newName);
			} else if (update == 2) {
				System.out.print("New number of players: ");
				int newPlayerNum = in.nextInt();
				toEdit.setNumOfPlayers(newPlayerNum);
			}

			gh.updateItem(toEdit);

		} else {
			System.out.println("---- No results found");
		}
	}

	public static void main(String[] args) {
		runMenu();
	}

	public static void runMenu() {
		boolean goAgain = true;
		System.out.println("Board Game Database");
		while (goAgain) {
			System.out.println("*  Select an Option:");
			System.out.println("*  1 -- Add a Game");
			System.out.println("*  2 -- Edit a Game Listing");
			System.out.println("*  3 -- Delete a Game");
			System.out.println("*  4 -- View the Database");
			System.out.println("*  5 -- Exit Program");
			System.out.print("*  Your selection: ");
			int selection = in.nextInt();
			in.nextLine();

			if (selection == 1) {
				addAnItem();
			} else if (selection == 2) {
				editAnItem();
			} else if (selection == 3) {
				deleteAnItem();
			} else if (selection == 4) {
				viewTheList();
			} else {
				gh.cleanUp();
				System.out.println("   Goodbye!   ");
				goAgain = false;
			}

		}

	}

	private static void viewTheList() {
		List<GameListItem>allItems = gh.showAllItems();
		for(GameListItem singleItem : allItems) {
			System.out.println(singleItem.returnItemDetails());
		}
		

	}

}
