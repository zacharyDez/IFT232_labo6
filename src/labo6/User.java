package labo6;

import labo6.Ressources.Country;
import labo6.Ressources.Gender;
import labo6.database.Picture;
import labo6.ui.UserPanel;

/*
 * Repr�sente un utilisateur (humain ou robot).
 * L'utilisateur initialise un panneau d'interface, mais l'ajout de celui-ci � l'arri�re-plan
 * est contr�l� ailleurs (Session).
 */

public class User {
	
	private UserPanel ui;
	private String name;
	private Country country=Country.Canada;
	
	
	public User(String n,Picture profilePic,Gender gender){	
			name=n;			
			ui = new UserPanel(name,profilePic.getPath(),Ressources.genderIcons[gender.value]);		
	}
	
	public User(String n,Country c,Gender gender){	
		name=n;	
		country=c;
		ui = new UserPanel(name,Ressources.flagImages[c.value],Ressources.genderIcons[gender.value]);		
}
	
	public UserPanel getUI(){
		return ui;
	}
	
	public String getText(){
		return getUI().getText();
	}
	
	public String getLastLine(){
		String text = getUI().getText();
		String[]lines = text.split("\n");
		
		String line = lines[lines.length-1];
		if(line.length()==0 && lines.length>1){
			line = lines[lines.length-2];
		}
				
		return line;
	}
	
	public Country getCountry(){
		return country;
	}

}
