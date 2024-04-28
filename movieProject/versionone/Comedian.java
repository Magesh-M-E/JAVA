public class Comedian
{
	String comedianName;
	String comedianCharactorName;
	Dialogue[] comedianDialougue = new Dialogue[5];
	
	public void printComedianDetails(){
		
		System.out.println(comedianName+comedianCharactorName);
		int i =(int)(Math.random()*5);
		System.out.println(comedianDialougue[i].dialogue);
	}
}