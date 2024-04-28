public class Heroine
{
	String heroineName;
	String heroineCharactorName;
	Dialogue[] heroineDialogue = new Dialogue[5];
	
	public void printHeroineDetails(){
		
		System.out.println(heroineName+"   "+heroineCharactorName);
		 int i = (int)(Math.random()*5);
		 System.out.println(heroineDialogue[i].dialogue);
	}
}