public class Tdd
{
	public static void main(String[] carProject)
	{
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Welcome To CarShowRoom>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		System.out.println("-----------------------------Here's Your's Car Details------------------------------");
		Car car = new Car();
		car.name="car1";
		car.showCarDetails();

		System.out.println("------------------------------------Tyre Details--------------------------------------");
		   //Tyre tyre = new Tyre();
		  car.tyres[0] = new Tyre();
		  car.tyres[0].tyreName="tyre1";
		  car.tyres[0].printTyreDetails();
		  
		  car.tyres[1]= new Tyre();
		  car.tyres[1].tyreName="tyre2";
		  car.tyres[1].printTyreDetails();
		  
		  car.tyres[2]=new Tyre();
		  car.tyres[2].tyreName="tyre3";
		  car.tyres[2].printTyreDetails();
		  
		  car.tyres[3]= new Tyre();
		  car.tyres[3].tyreName="tyre4";
		  car.tyres[3].printTyreDetails();
		    
			
		
			
			
		System.out.println("----------------------------------------Door Details-----------------------------------");
		//Door door = new Door();
		car.doors[0] = new Door();
		car.doors[0].doorName = "door1";
		car.doors[0].printDoorDetails();
		
		car.doors[1] = new Door();
		car.doors[1].doorName = "door2";
		car.doors[1].printDoorDetails();	
		
		car.doors[2] = new Door();
		car.doors[2].doorName = "door3";
		car.doors[2].printDoorDetails();	
		
		car.doors[3] = new Door();
		car.doors[3].doorName ="door 4";	
		car.doors[3].printDoorDetails();	
		
		
		
		
		System.out.println("-------------------------------------------Steering Details--------------------------------------");
		 //Steering str = new Steering();
		car.steering= new Steering();
		car.steering.steeringName="bugatti logo";
		car.steering.printSteeringDetails();
		
		System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<Hope To See You Again>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
			}
}
	
/*public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	*/