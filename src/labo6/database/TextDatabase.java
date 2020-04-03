package labo6.database;

import labo6.Ressources.Gender;
import labo6.database.TextMessage.Language;

public class TextDatabase {

	private static final TextList TEXT = new TextList();

	public static TextList getAllMessages() {
		return (TextList) TEXT.clone();
	}

	static {
		// Lang, quest, seduc, pass, greet, gend

		TEXT.add("Hey! Guess who's not wearing any underwear!", Language.english, false, true, true, false, true, Gender.unknown);
		TEXT.add("Hi! How are you doing?", Language.english, true, false, false, false, true, Gender.unknown);
		TEXT.add("Where are your wings? Cause I swear I thought you fell from heaven", Language.english, true, false,
				true, false, true, Gender.unknown);
		TEXT.add("Look what the cat dragged in...", Language.english, false, false, false, false, true, Gender.unknown);
		TEXT.add("What do you want? I'm busy!", Language.english, true, true, false, false, true, Gender.unknown);
		TEXT.add("Here we go, another nice person to chat with...", Language.english, false, false, false, true, true,
				Gender.unknown);
		TEXT.add("My cat's breath smells like cat food.", Language.english, false, false, false, false, false,
				Gender.unknown);
		TEXT.add("My tummy feels funny.", Language.english, false, false, false, false, false, Gender.unknown);
		TEXT.add("And I want a bike and a monkey and a friend for the monkey", Language.english, false, false, false,
				false, false, Gender.unknown);
		TEXT.add("My cat's name is Mittens", Language.english, false, false, false, false, false, Gender.unknown);
		TEXT.add("My parents won't let me use scissors. ", Language.english, false, false, false, false, false,
				Gender.unknown);
		TEXT.add("When I grow up I wanna be a Principal or a Caterpillar", Language.english, false, false, false, false,
				false, Gender.unknown);
		TEXT.add("I kissed a light socket once and I woke up in a helicopter", Language.english, false, false, false,
				false, false, Gender.unknown);
		TEXT.add("Will you cook my dinner for me? My parents aren't around and I'm not allowed to turn on the stove. ",
				Language.english, true, false, false, false, false, Gender.unknown);
		TEXT.add("I'm not a photographer, but I can picture me and you together", Language.english, false, false, true,
				false, false, Gender.unknown);
		TEXT.add("Are you an interior decorator? Because when I saw you, the entire room became beautiful.",
				Language.english, true, false, true, false, false, Gender.unknown);
		TEXT.add("Do you know what my shirt is made of? Boyfriend material.", Language.english, true, false, true,
				false, false, Gender.female);
		TEXT.add("I seem to have lost my phone number. Can I have yours?", Language.english, true, false, true, false,
				false, Gender.unknown);
		TEXT.add("Do you have a map? I'm getting lost in your eyes.", Language.english, true, false, true, false, false,
				Gender.unknown);
		TEXT.add("I don't have a library card, but do you mind if I check you out?", Language.english, true, true, true,
				false, false, Gender.unknown);
		TEXT.add("I was feeling a little off today, but you definitely turned me on.", Language.english, true, true,
				true, false, false, Gender.unknown);

		TEXT.add("Hey! Devine qui qui porte pas de bobettes en ce moment!", Language.french, false, true, true, false, true, Gender.unknown);
		TEXT.add("Salut! Comment �a va?", Language.french, true, false, false, false, true, Gender.unknown);
		TEXT.add("O� sont tes ailes? J'aurais pu jurer que t'�tais tomb�e du ciel...", Language.french, true, false,
				true, false, true, Gender.female);
		TEXT.add("Eh bien, regarde qui s'am�ne...", Language.french, false, false, false, false, true, Gender.unknown);
		TEXT.add("Kess tu veux? Chus occupp� l�...", Language.french, true, true, false, false, true, Gender.unknown);
		TEXT.add("Bon, encore une autre personne int�ressante avec qui parler...", Language.french, false, false, false, true, true,
				Gender.unknown);
		TEXT.add("L'haleine de mon chat sent le Meow Mix.", Language.french, false, false, false, false, false,
				Gender.unknown);
		TEXT.add("J'ai des papillons dans l'estomac.", Language.french, false, false, true, false, false, Gender.unknown);
		TEXT.add("Moi, j'aime les saucisses, pis les roches.", Language.french, false, false, false,
				false, false, Gender.unknown);
		TEXT.add("Mon chat s'appelle Mistigri.", Language.french, false, false, false, false, false, Gender.unknown);
		TEXT.add("Mes parent refusent que j'utilise les ciseaux.", Language.french, false, false, false, false, false,
				Gender.unknown);
		TEXT.add("Quand je vais �tre grand, je veux devenir beta-testeur de jeux vid�o.", Language.french, false, false, false, false,
				false, Gender.unknown);
		TEXT.add("J'ai coll� ma langue sur la cl�ture pis je suis rest� pris...", Language.french, false, false, false,
				false, false, Gender.unknown);
		TEXT.add("Peux-tu m'aider � faire le souper? La recette dit de faire bouillir de l'eau pis je sais pas comment...",
				Language.french, true, false, false, false, false, Gender.unknown);
		TEXT.add("Je ne suis pas photographe, mais je t'imagine dans toutes sortes de poses", Language.french, false, true, true,
				false, false, Gender.unknown);
		TEXT.add("Es-tu d�coratrice d'int�rieur? Parce que je sans que je le feng, shui s�duit par toi",
				Language.french, true, false, true, false, false, Gender.female);
		TEXT.add("T'as tu vu l'oeuvre d'art qu'est mon 6-pack?", Language.french, true, false, true, false,
				false, Gender.female);
		TEXT.add("J'ai perdu mon no de t�l�phone, tu peux me donner le tien?", Language.french, true, false, true, false,
				false, Gender.unknown);
		TEXT.add("As-tu une carte? Je crois que je viens de me perdre dans tes yeux...", Language.french, true, false, true, false, false,
				Gender.unknown);
		TEXT.add("Mon feu int�reieur s'�tait �teint jusqu'� ce que tu m'allumes.", Language.french, true, true,
				true, false, false, Gender.unknown);

	}

}
