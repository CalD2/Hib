package hib.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CLIENT", uniqueConstraints =
{ @UniqueConstraint(columnNames =
{ "NOM" }) })
public class Client
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NOM", length = 30, nullable = false)
	private String nom;

	@Column(name = "PRENOM", length = 30, nullable = false)
	private String prenom;

	@Column(name = "TEL")
	private long tel;

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

	public String getPrenom()
	{
		return prenom;
	}

	public void setPrenom(String prenom)
	{
		this.prenom = prenom;
	}

	public long getTel()
	{
		return tel;
	}

	public void setTel(long tel)
	{
		this.tel = tel;
	}

}
