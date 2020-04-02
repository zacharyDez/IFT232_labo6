package labo6;

import labo6.Ressources.Country;
import labo6.Ressources.Gender;
import labo6.database.Picture;
import labo6.ui.UserPanel;

/*
 * Représente un utilisateur (humain ou robot).
 * L'utilisateur initialise un panneau d'interface, mais l'ajout de celui-ci à l'arrière-plan
 * est contrôlé ailleurs (Session).
 */

public class User {
	
	private UserPanel ui;
	private String name;
	private Country country=Country.Canada;
	private Picture picture;
	private Gender gender;
	
	public User(String n,Picture profilePic,Gender g){
			name=n;
			picture = profilePic;
			gender = g;
			ui = new UserPanel(name,profilePic.getPath(),Ressources.genderIcons[g.value]);
	}

	public Picture getPicture() {
		return picture;
	}

	public User(String n, Country c, Gender g){
		name=n;	
		country=c;
		gender = g;
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

	public Gender getGender() {
		return gender;
	}

	public Country getCountry(){
		return country;
	}

}
