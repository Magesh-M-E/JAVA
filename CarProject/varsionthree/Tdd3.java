public class Tdd3
{
	public static void main (String[] args){
	Car3 car = new Car3();
	car.brandName = "SUZUKI";
	car.printCarDetails();
	
	
	car.door[0]= new Door3();
	car.door[0].doorName="door1";
	car.door[0].doorBrand = "zusuki door1";
	car.door[0].doorColour ="white";
	car.door[0].printDoorDetails();
	
	car.door[1]= new Door3();
	car.door[1].doorName="door2";
	car.door[1].doorBrand = "zusuki door2";
	car.door[1].doorColour="white";
	car.door[1].printDoorDetails();
	
	car.door[2] = new Door3();
	car.door[2].doorName="door1";
	car.door[2].doorBrand = "zusuki door3";
	car.door[2].doorColour="white";
	car.door[2].printDoorDetails();
	
	car.door[3] = new Door3();
	car.door[3].doorName="door4";
	car.door[3].doorBrand = "zusuki door4";
	car.door[3].doorColour="white";
	car.door[3].printDoorDetails();
	

	
	car.tyre[0] = new Tyre3();
	car.tyre[0].tyreName = "tyre1";
	car.tyre[0].tyreSize = 12;
	car.tyre[0].tyrePosition ="front left";
	car.tyre[0].printTyreDetails();
	
	car.tyre[1] = new Tyre3();
	car.tyre[1].tyreName = "tyre2";
	car.tyre[1].tyreSize = 12;
	car.tyre[1].tyrePosition ="front right";
	car.tyre[1].printTyreDetails();
	
	car.tyre[2]= new Tyre3();
	car.tyre[2].tyreName = "tyre3";
	car.tyre[2].tyreSize = 12;
	car.tyre[2].tyrePosition ="rear left";
	car.tyre[2].printTyreDetails();
	
	car.tyre[3] = new Tyre3();
	car.tyre[3].tyreName = "tyre4";
	car.tyre[3].tyreSize = 12;
	car.tyre[3].tyrePosition ="rear right";
	car.tyre[3].printTyreDetails();
	
	car.steering = new Steering3();
	car.steering.steeringBrand ="suzuki steering";
	car.steering.steeringColour = "black";
	car.steering.printSteeringDetails();
	
	car.steerio = new Steerio3();
	car.steerio.steerioBrand = "sony";
	car.steerio.steerioPlaylist = "malayalam songs";
	car.steerio.printSteerioDetails();
	}
}	