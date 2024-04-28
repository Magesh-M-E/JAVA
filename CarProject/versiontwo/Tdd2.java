public class Tdd2
{
	public static void main(String[] carProject2)
	{
		Car2 car = new Car2();
		car.carName = "MERCEDES BENZ";
		//System.out.println(car.carName);
		
		car.printDetailes();
		car.doors[0] = new Door2();
		
		car.doors[0].doorName = "door1";
		System.out.println(car.doors[0].doorName);
		}
}