package model;

public enum Unite {

	g("gramme"),L("Litre"),Temp("°C"),cs(""),pincee("");
	
	private String lib;
	
	private Unite(String lib) 
	{
		this.lib=lib;
	}

	public String getLib() {
		return lib;
	}
	
	
}

