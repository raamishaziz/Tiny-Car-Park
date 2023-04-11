package tiny.car.park.simulator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import tiny.car.park.manager.TinyCarPark;
import tiny.car.park.utils.Utilities;

public class Simulator {
	public static void main(String[] args) throws Throwable {
		
		System.out.println("----------------- ----------------- -----------------");
		System.out.println("----------     Welcome to Tiny Car Park      --------");
		System.out.println("----------------- ----------------- -----------------\n");
		
		System.out.println("1. Press 1 for arrival of owner.");
		System.out.println("2. Press 2 for departure of owner.");
		System.out.println("3. Press 3 to display owners.");
		System.out.println("4. Press 0 to exit.\n");
		
		TinyCarPark carParkingSystem = new TinyCarPark();
		Integer option = -1;
		while (option != 0) {
			// Enter data using BufferReader
			System.out.print("Please select possible option: ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			System.out.println();
	        // Reading data using readLine
	        String name = reader.readLine();
	        try {
	        	option = Integer.parseInt(name);
	        	if (option == 1) {
	        		// Arrival
	        		int parkedOwnersCount = 0;
	        		System.out.print("Add Owner to the car park: ");
	        		reader = new BufferedReader(new InputStreamReader(System.in));
	        		System.out.println();
	        		parkedOwnersCount = carParkingSystem.arrive(reader.readLine());
	        		System.out.println("Parked Owners Count: " + parkedOwnersCount + "\n");
	        	} else if (option == 2) {
	        		// Departure
	        		String personsOnRoadForParkingClearance = null;
	        		System.out.print("Please enter the name of owner to leave: ");
	        		reader = new BufferedReader(new InputStreamReader(System.in));
	        		System.out.println();
	        		personsOnRoadForParkingClearance = carParkingSystem.leave(reader.readLine());
	        		if (null == personsOnRoadForParkingClearance || personsOnRoadForParkingClearance.isEmpty()) {
	        			System.out.println("No Owner has go on road for requested owner departure.\n");
	        		} else if ("-1".equalsIgnoreCase(personsOnRoadForParkingClearance)) {
	        			System.out.println("Owner does not found in Parking Space.\n");
	        		} else {
	        			System.out.println("Owners have to go on road for requested owner departure: " + personsOnRoadForParkingClearance + "\n");
	        		}
	        	} else if (option == 3) {
	        		// Display Owners
	        		carParkingSystem.displayOwners();
	        	}
	        	else if (option == 0) {
	        		// Exit
	        		System.out.print("Good Bye!");
	        	}
	        	Utilities.clearScreen();
	        } catch (NumberFormatException ex) {
	        	// Other than 1, 2 or 0 options are being selected
	        	System.out.println("Please enter correct option.");
	        }
		}
	}
}
