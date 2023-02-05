package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.GameListItem;

/**
 * @author Scott Grigsby-sdgrigsby
 *CIS175-Spring 2023
 * Feb 4, 2023
 */
public class gameHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Week 3 Assessment");

	/**
	 * @param toAdd
	 */
	public void insertItem(GameListItem toAdd) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(toAdd);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param toDelete
	 */
	public void deleteItem(GameListItem toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameListItem> typedQuery = em.createQuery("select li from GameListItem li where li.gameName = :selectedGameName and li.numOfPlayers = :selectedNumOfPlayers",GameListItem.class);
		
		typedQuery.setParameter("selectedGameName", toDelete.getGameName());
		typedQuery.setParameter("selectedNumOfPlayers", toDelete.getNumOfPlayers());
		
		typedQuery.setMaxResults(1);
		
		GameListItem result = typedQuery.getSingleResult();
		
		em.remove(result);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<GameListItem> searchForGameByName(String gameName) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameListItem>typedQuery = em.createQuery("select li from GameListItem li where li.gameName = :selectedName",GameListItem.class);
		typedQuery.setParameter("selectedName",gameName);
		
		List<GameListItem>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}

	/**
	 * @param numOfPlayers
	 * @return
	 */
	public List<GameListItem> searchForGameByPlayerNum(int numOfPlayers) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<GameListItem>typedQuery = em.createQuery("select li from GameListItem li where li.numOfPlayers = :selectedNum",GameListItem.class);
		typedQuery.setParameter("selectedNum",numOfPlayers);
		
		List<GameListItem>foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public GameListItem searchForItemById(int idToEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		GameListItem found = em.find(GameListItem.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(GameListItem toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}


	/**
	 * 
	 */
	public void cleanUp() {
		emfactory.close();
		
	}

	/**
	 * @return
	 */
	public List<GameListItem> showAllItems() {
		EntityManager em = emfactory.createEntityManager();
		List<GameListItem> allGames = em.createQuery("Select i from GameListItem i").getResultList();
		return allGames;
	}

}
