package com;

public class VilleFrance {
	String codeCommuneINSEE;
	String nomCommune;
	String codePostal;
	String libelleAcheminement;
	String ligne5;
	String latitude;
	String longitude;
	public String getCodeCommuneINSEE() {
		return codeCommuneINSEE;
	}
	public void setCodeCommuneINSEE(String codeCommuneINSEE) {
		this.codeCommuneINSEE = codeCommuneINSEE;
	}
	public String getNomCommune() {
		return nomCommune;
	}
	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}
	public void setLibelleAcheminement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}
	public String getLigne5() {
		return ligne5;
	}
	public void setLigne5(String ligne5) {
		this.ligne5 = ligne5;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public VilleFrance map(String codeCommuneINSEE,String nomCommune, String codePostal, String libelleAcheminement,
							String ligne5, String latitude, String longitude) {
		VilleFrance ville = new VilleFrance();
		ville.setCodeCommuneINSEE(codeCommuneINSEE);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne5(ligne5);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		
		return ville;
	}
	
	@Override
	public String toString() {
		return "VilleFrance [codeCommuneINSEE : "+this.codeCommuneINSEE+" | nomCommune : "+this.nomCommune+
				" | codePostal : "+this.codePostal+" | libelleAcheminement : "+this.libelleAcheminement+
				" | ligne5 : "+this.ligne5+" | latitude : "+this.latitude+" | longitude : "+this.longitude+"]";
	}

}
