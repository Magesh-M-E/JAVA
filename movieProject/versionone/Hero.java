public class Hero
{
	String heroName;
	String charactorName;
	Dialogue[] heroDialogue = new Dialogue[5];
	
	public void PrintHeroDetails(){
		
	System.out.println(heroName+charactorName);
	int i=(int)(Math.random()*5);

	System.out.println(heroDialogue[i].dialogue);
	}
}


