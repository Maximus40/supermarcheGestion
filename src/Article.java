import java.util.List;

public class Article {
	long codeBarre;
	String reference;
	String libelle;
	int prixHT;
	int tauxTVA;
	
	public Article(long codeBarreArt, String referenceArt, String libelleArt, int prixHTArt, int tauxTVAArt) {
		this.codeBarre = codeBarreArt;
		this.reference = referenceArt;
		this.libelle = libelleArt;
		this.prixHT = prixHTArt;
		this.tauxTVA = tauxTVAArt;
	}
	
	public long getCodeBarre() {
		return this.codeBarre;
	}
	 
	public void setCodeBarre(long newCode) {
        this.codeBarre = newCode;	   
       }
	
	public String getReference() {
		return this.reference;
	}
	public void setReference(String newRef) {
		this.reference = newRef;
	}
	public String getLibelle() {
		return this.libelle;
	}
	public void setLibelle(String newLib) {
		this.libelle = newLib;
	}
	public int getPrixHT() {
		return this.prixHT;
	}
	public void setPrixHT(int newPrixHT) {
		this.prixHT = newPrixHT;
	}
	public int getTauxTVA() {
		return this.tauxTVA;
	}
	public void setTauxTVA(int newTauxTVA) {
		this.tauxTVA = newTauxTVA;
	}
	
	
	
}

