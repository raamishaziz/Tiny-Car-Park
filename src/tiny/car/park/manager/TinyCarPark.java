package tiny.car.park.manager;

import tiny.car.park.queue.QueueADT;
import tiny.car.park.stack.StackADT;
import tiny.car.park.stack.impl.NodeStack;
import tiny.car.park.queue.impl.Queue;
import tiny.car.park.utils.Utilities;
/**
 * A class to manage card parking space
 */
public class TinyCarPark {
	StackADT<String> parkingSpace = null;
	QueueADT<String> road = new Queue<String>();

	/**
	 * @param carOwner to be added
	 * Will add cardOwner in Parking.
	 */
	public int arrive(String carOwner) {
		if (null != parkingSpace) {
			if (ifExists(parkingSpace, carOwner)) {
				System.out.println(carOwner + " already eixists.");
				return parkingSpace.size();
			}
			System.out.println(carOwner + " is Parking.");
			parkingSpace.push(carOwner);
		} else {
			System.out.println(carOwner + " is Parking.");
			parkingSpace = new NodeStack<String>();
			parkingSpace.push(carOwner);
		}
		return parkingSpace.size();
	}
	
	/**
	 * @param carOwner to be removed
	 * Will remove cardOwner from Parking.
	 */
	public String leave(String carOwner) {
		if (null == parkingSpace || parkingSpace.isEmpty()) {
			System.out.println("No Owner Found");
			// No car found in parking space.
			return null;
		}
		boolean ownerFound = false;
		StringBuffer listedOutOwner = new StringBuffer();
		
		while(!parkingSpace.isEmpty()) {
			String owner = parkingSpace.pop();
			if (null != carOwner && null != owner && Utilities.isEquals(owner.toLowerCase(), carOwner.toLowerCase())) {
				// Request owner found for leaving.
				System.out.println(owner + " is leaving.");
				ownerFound = true;
				break;
			} else {
				// This is road where cars are being taken outside.
				road.enqueue(owner);
				listedOutOwner.append(owner);
				listedOutOwner.append("~");
			}
		}
		while(!road.isEmpty()) {
			// Putting back owners in parking space.
			parkingSpace.push(road.rear());
			road.dequeue();
		}
		if (!ownerFound) {
			// Owner doesn't found in parking space.
			return "-1";
		}
		return listedOutOwner.toString();
	}
	
	/**
	 * Will show owners in parking space.
	 */
	public void displayOwners() {
		int index = 0;
		StackADT<String> tempParkingSpace = parkingSpace;
		if (null != tempParkingSpace) {
			StackADT<String> ownersToDisplay = new NodeStack<>();
			System.out.println("Parking Owners:");
			while (!tempParkingSpace.isEmpty()) {
				ownersToDisplay.push(tempParkingSpace.pop());
			}
			while (!ownersToDisplay.isEmpty()) {
				String ownerToDisplay = ownersToDisplay.pop();
				System.out.println(++index + ". " + ownerToDisplay);
				parkingSpace.push(ownerToDisplay);
			}
		} else {
			System.out.println("Parking space is empty.");
		}
	}
	
	/**
	 * @param parkingSpace to be reviewed for owner existence
	 * @param owner to be checked in parkingSpace
     * Return true if the owner is already parked, false otherwise.
	 */
	private boolean ifExists(StackADT<String> parkingSpace, String owner) {
		StackADT<String> tempParkingSpace = new NodeStack<>();
		if (null != parkingSpace && null != owner) {
			boolean alreadExists = false;
			while (!parkingSpace.isEmpty()) {
				String currentOwner = parkingSpace.pop();
				if (null != currentOwner && Utilities.isEquals(owner.toLowerCase(), currentOwner.toLowerCase())) {
					alreadExists = true;
				}
				tempParkingSpace.push(currentOwner);
			}
			while (!tempParkingSpace.isEmpty()) {
				parkingSpace.push(tempParkingSpace.pop());
			}
			return alreadExists;
		} else {
			return false;
		}
	}
}
