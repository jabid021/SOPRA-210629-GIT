package eshop.model;

public enum Civilite {
	M("monsieur"), MME("madame"), MLLE("mademoiseille");

	String titre;

	private Civilite(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}
}
