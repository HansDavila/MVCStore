package mx.com.cursodia.jse18.mod2.semana1.tarea;

public class Juguete {
	// Propiedades de Clase
	Integer id_jug;
	String nom_jug;
	Float pre_jug;
	String marc_jug;
	String catg_jug;
	Integer stock;

	// CONSTRUCTOR
	public Juguete(int id_jug, String nom_jug, float pre_jug, String marc_jug, String catg_jug, int stock) {
		super();
		this.id_jug = id_jug;
		this.nom_jug = nom_jug;
		this.pre_jug = pre_jug;
		this.marc_jug = marc_jug;
		this.catg_jug = catg_jug;
		this.stock = stock;
	}

	// GETTERS Y SETTERS
	public int getId_jug() {
		return id_jug;
	}

	public void setId_jug(int id_jug) {
		this.id_jug = id_jug;
	}

	public String getNom_jug() {
		return nom_jug;
	}

	public void setNom_jug(String nom_jug) {
		this.nom_jug = nom_jug;
	}

	public float getPre_jug() {
		return pre_jug;
	}

	public void setPre_jug(float pre_jug) {
		this.pre_jug = pre_jug;
	}

	public String getMarc_jug() {
		return marc_jug;
	}

	public void setMarc_jug(String marc_jug) {
		this.marc_jug = marc_jug;
	}

	public String getCatg_jug() {
		return catg_jug;
	}

	public void setCatg_jug(String catg_jug) {
		this.catg_jug = catg_jug;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	// Sobreescribiendo Metodo
		public String toString() {
			return  "ID: "+ id_jug + "\nNOMBRE:" + nom_jug+ "\nPRECIO:" + pre_jug + "\nMARCA:" + marc_jug + "\nSTOCK" + stock;
		}

}
