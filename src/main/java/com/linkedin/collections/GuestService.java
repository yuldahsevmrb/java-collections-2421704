package com.linkedin.collections;

import java.util.ArrayList;
import java.util.List;

public class GuestService {

	private List<Guest> checkinList = new ArrayList<>(100);

	public static List<Guest> filterByFavoriteRoom(List<Guest> guests, Room room) {

		/*
		 *  1. Returns a new collection that contains guests from the provided collection
		 *  who have indicated the provided room as the first preference in their preferred
		 *  room list. 
		 */

		List<Guest> guestsList = new ArrayList<>();
		for (Guest guest : guests){
			if(guest.getPreferredRooms().get(0).equals(room)){
				guestsList.add(guest);
			}
		}
		return guestsList;

	}

	public void checkIn(Guest guest) {
		
		/*
		 *  2. Adds a guest to the checkinList, placing members of the loyalty program
		 *  ahead of those guests not in the program. Otherwise, guests are arranged in the
		 *  order they were inserted.
		 */
		if (guest.isLoyaltyProgramMember()){
			for (int i = 0; i < checkinList.size() ; i++) {
				if(!checkinList.get(i).isLoyaltyProgramMember()) {
					checkinList.add(i, guest);
					break;
				}
			}
		} else {
			checkinList.add(guest);
		}
	}
	
	public void swapPosition(Guest guest1, Guest guest2) {
		
		/*
		 *  3.  Swaps the position of the two provided guests within the checkinList.
		 *  If guests are not currently in the list no action is required.
		 */
		int indexOfGuest = 0;
		if(checkinList.containsAll(List.of(guest1, guest2))){
			indexOfGuest = checkinList.indexOf(guest1);
			checkinList.set(checkinList.indexOf(guest2), guest1);
			checkinList.set(indexOfGuest, guest2);
		}
	}

	public List<Guest> getCheckInList() {
		return List.copyOf(this.checkinList);
	}
}
