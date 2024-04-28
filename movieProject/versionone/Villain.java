public class Villain
{
	String villainName;
	String villainCharactorName;
	Dialogue[] villainDialouge= new Dialogue[5];

	public void printVillainDetails(){

		System.out.println(villainName+villainCharactorName);
		int i =(int)(Math.random()*5);
		System.out.println(villainDialouge[i].dialogue);
	}
}