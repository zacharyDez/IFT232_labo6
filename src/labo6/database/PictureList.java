package labo6.database;

import java.util.ArrayList;
import java.util.Random;

import labo6.Ressources;
import labo6.Ressources.Gender;
import labo6.database.Picture.PictureKey;

public class PictureList implements Cloneable {

	private ArrayList<Picture> pics = new ArrayList<Picture>();

	public PictureList() {

	}

	public PictureList(ArrayList<Picture> src) {
		pics = src;
	}

	public void keep(PictureKey key,Object value) {
		
		ArrayList<Picture> res = new ArrayList<Picture>();
		
		for(Picture pic:pics){
			if(pic.match(key,value)){
				res.add(pic);
			}
		}

		pics = res;
	}

	public void keep(Gender g, boolean b) {

		ArrayList<Picture> res = new ArrayList<Picture>();

		for(Picture pic:pics){

			// for unknown
			if(g.value == Gender.unknown.value && Gender.unknown.value == pic.getGender().value && b ){
				res.add(pic);
			}

			// included pics with b=true
			if (b && g.value == pic.getGender().value && g.value!=Gender.unknown.value){
				res.add(pic);
			}

			// excluded pics with b=false
			if(!b && g.value != pic.getGender().value && g.value!=Gender.unknown.value){
				res.add(pic);
			}
		}

		pics = res;
	}

	public void remove(PictureKey key,Object value) {
		
		ArrayList<Picture> res = new ArrayList<Picture>();
		
		for(Picture pic:pics){
			if(!pic.match(key,value)){
				res.add(pic);
			}
		}

		pics = res;
	}	
	
	public void merge(PictureList l2){
		
		for(Picture pic: l2.pics){
			if(!pics.contains(pic)){
				pics.add(pic);
			}
		}
	
	}

	public void add(String path, Gender g, boolean b, boolean c) {
		pics.add(new Picture(path, g, b, c));
	}

	public int size() {
		return pics.size();
	}

	public Picture get(int index) {
		return pics.get(index);
	}

	@SuppressWarnings("unchecked")
	public PictureList clone() {

		return new PictureList((ArrayList<Picture>) pics.clone());
	}
	
	public Picture random(){
		Random generator = new Random();
		try {
			return pics.get(generator.nextInt(pics.size()));
		} catch (IllegalArgumentException e){
			System.out.println("No photos for given characteristics. Showing you troll.");
			pics.add(new Picture("Troll.png", Gender.unknown, true, true));
			return pics.get(pics.size()-1);
		}
	}

}
