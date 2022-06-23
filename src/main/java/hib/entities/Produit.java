package hib.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "PRODUIT", uniqueConstraints =
{ @UniqueConstraint(columnNames =
{ "NOM" }) })
public class Produit
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM", length = 30, nullable = false)
	private String nom;

	@Column(name = "PRIX")
	private float prix;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom(String nom)
	{
		this.nom = nom;
	}

	public float getPrix()
	{
		return prix;
	}

	public void setPrix(float prix)
	{
		this.prix = prix;
	}

}
