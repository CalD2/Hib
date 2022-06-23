package hib.query;

import hib.entities.Client;
import hib.entities.Commande;
import hib.entities.Produit;
import hib.manager.ClientManager;
import hib.manager.ProduitManager;

public class QueryObjectDemo
{

	public static void main(String[] args)
	{
		try
		{

			Client client = new Client();
			client.setNom("test");
			client.setPrenom("test");
			client.setTel(607080910L);

			ClientManager clientManager = new ClientManager();
			clientManager.create(client);

			System.out.println("Nombre de client : " + clientManager.getAll().size());

			Produit produit = new Produit();
			produit.setNom("pomme");
			produit.setPrix(100f);

			ProduitManager produitManager = new ProduitManager();
			produitManager.create(produit);

			System.out.println("Nombre de produit : " + produitManager.getAll().size());

			Commande commande = new Commande();
			commande.setClient(client);
			commande.setArticle(produit);

		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}