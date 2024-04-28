public class Tdd{

	public static void main(String[] args){
	
	
	Movie movie = new Movie();
	movie.movieName = "DRISYAM   (2013)";
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<MOVIE DETAILS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	System.out.println(movie.movieName );
	
	Hero hero = new Hero();
	hero.heroName = "MOHANLAL";
	hero.charactorName = "Georgekutty";
	
	hero.heroDialogue[0] = new Dialogue();
	hero.heroDialogue[0].dialogue = "ഞാന്‍ ചോദിച്ചാല്‍ അങ്ങേയ്ക്ക് എങ്ങനെ പറയാം  1";
	//hero.heroDialogue[0].printDialogue();
	hero.heroDialogue[1] = new Dialogue();
	hero.heroDialogue[1].dialogue = "നീയും എനിക്കും ഒരുപോലെ ആണെങ്കില്‍ ഞാന്‍ നിന്റെ സ്നേഹം മറക്കാത്തതാകും  2";
	//hero.heroDialogue[1].printDialogue();
	hero.heroDialogue[2] = new Dialogue();
	hero.heroDialogue[2].dialogue = "വെറുതെ നിന്റെ മേടിച്ച പേടിയൊക്കെയും എനിക്ക് തരാം. 3";
	//hero.heroDialogue[2].printDialogue();
	hero.heroDialogue[3] = new Dialogue();
	hero.heroDialogue[3].dialogue = "ഞാന്‍ നിന്നെ എത്തിച്ചേര്‍ന്നപ്പോള്‍ നിനക്ക് നല്ല പേര് കിട്ടും.  4";
	//hero.heroDialogue[3].printDialogue();
	hero.heroDialogue[4] = new Dialogue();
	hero.heroDialogue[4].dialogue = "നീയും എനിക്കും ഒന്നുപോലെ ആണെങ്കില്‍ അതെന്നെ വിട  5";
	//hero.heroDialogue[4].printDialogue();
	System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< HERO DETAILS >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	hero.PrintHeroDetails();
	
	Heroine heroine = new Heroine();
	heroine.heroineName = "Meena";
	heroine.heroineCharactorName = "Rani George";
	
	heroine.heroineDialogue[0] = new Dialogue();
	heroine.heroineDialogue[0].dialogue = "ഞാൻ നിന്നെ കണ്ടെത്തിയാലും നിനക്ക് പിന്നെയുള്ള പടിയെന്ന് പറയും.  1";
	//heroine.heroineDialogue[0].printDialogue();
	heroine.heroineDialogue[1] = new Dialogue();
	heroine.heroineDialogue[1].dialogue = "എന്റെ അഭിമാനം നിന്നെ ഉയർത്താൻ പറ്റിയ ഒരു പൂവാണ്.  2";
	//heroine.heroineDialogue[1].printDialogue();
	heroine.heroineDialogue[2] = new Dialogue();
	heroine.heroineDialogue[2].dialogue = "നിന്നെ തന്നെ കൈവരുത്തുന്ന സ്വപ്നമാണ് ഞാൻ  3";
	//heroine.heroineDialogue[2].printDialogue();
	heroine.heroineDialogue[3] = new Dialogue();
	heroine.heroineDialogue[3].dialogue = "ഞാന്‍ ചോദിച്ചാല്‍ അങ്ങേയ്ക്ക് എങ്ങനെ പറയാം?  4";
	//heroine.heroineDialogue[3].printDialogue();
	heroine.heroineDialogue[4] = new Dialogue();
	heroine.heroineDialogue[4].dialogue = "ഞാൻ ഒരു പട്ടിക്കടിയെന്നും നീ എന്നെ അതിക്രമിക്കരുത്.  5";
	//heroine.heroineDialogue[1].printDialogue();

	heroine.printHeroineDetails();
	
	Comedian comedian = new Comedian();
	comedian.comedianName = "Neeraj Madhav";
	comedian.comedianCharactorName= "Monichan";
	
	comedian.comedianDialougue[0] = new Dialogue();
	comedian.comedianDialougue[0].dialogue = "ഒരു പൊട്ടനെ വെച്ചാല്‍ ഇവിടെ പ്രമാദിച്ചുവരും.  1";
//	comedian.comedianDialougue[0].printDialogue();
	comedian.comedianDialougue[1] = new Dialogue();
	comedian.comedianDialougue[1].dialogue = "ഒരു പൊട്ടനെ വെച്ചാല്‍ ഇവിടെ പ്രമാദിച്ചുവരും.  2";
//	comedian.comedianDialougue[1].printDialogue();
	comedian.comedianDialougue[2] = new Dialogue();
	comedian.comedianDialougue[2].dialogue = "ഒരു പൊട്ടനെ വെച്ചാല്‍ ഇവിടെ പ്രമാദിച്ചുവരും.  3";
//	comedian.comedianDialougue[2].printDialogue();
	comedian.comedianDialougue[3] = new Dialogue();
	comedian.comedianDialougue[3].dialogue = "ഒരു പൊട്ടനെ വെച്ചാല്‍ ഇവിടെ പ്രമാദിച്ചുവരും.  4";
	//comedian.comedianDialougue[3].printDialogue();
	comedian.comedianDialougue[4] = new Dialogue();
	comedian.comedianDialougue[4].dialogue = "ഒരു പൊട്ടനെ വെച്ചാല്‍ ഇവിടെ പ്രമാദിച്ചുവരും.  5";
	comedian.comedianDialougue[4].printDialogue();

	comedian.printComedianDetails();
	
	Villain villain = new Villain();
	villain.villainName = "Kalabhavan Shajon";
	villain.villainCharactorName ="Sahadevan";
	
	villain.villainDialouge[0] = new Dialogue();
	villain.villainDialouge[0].dialogue = "നിനക്ക് ഒരു അടിക്കുറ്റ മരണം തരും, എനിക്ക് ആരും തരികിട്ടില   1";
	villain.villainDialouge[1] = new Dialogue();
	villain.villainDialouge[1].dialogue = "നിനക്ക് ഒരു അടിക്കുറ്റ മരണം തരും, എനിക്ക് ആരും തരികിട്ടില    2";
	villain.villainDialouge[2] = new Dialogue();
	villain.villainDialouge[2].dialogue = "നിനക്ക് ഒരു അടിക്കുറ്റ മരണം തരും, എനിക്ക് ആരും തരികിട്ടില    3";
	villain.villainDialouge[3] = new Dialogue();
	villain.villainDialouge[3].dialogue = "നിനക്ക് ഒരു അടിക്കുറ്റ മരണം തരും, എനിക്ക് ആരും തരികിട്ടില    4";
	villain.villainDialouge[4] = new Dialogue();
	villain.villainDialouge[4].dialogue = "നിനക്ക് ഒരു അടിക്കുറ്റ മരണം തരും, എനിക്ക് ആരും തരികിട്ടില    5";
	//villain.villainDialouge[0].printDialogue();

villain.printVillainDetails();

	}
}