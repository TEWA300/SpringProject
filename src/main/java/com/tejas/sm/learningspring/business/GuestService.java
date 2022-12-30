package com.tejas.sm.learningspring.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tejas.sm.learningspring.data.Guest;
import com.tejas.sm.learningspring.data.GuestRepository;


@Service
public class GuestService {
	private final GuestRepository guestRepository;

	public GuestService(GuestRepository guestRepository) {
		super();
		this.guestRepository = guestRepository;
	}
	
	public List<Guests> getGuestList() {
		List<Guest> guestList = this.guestRepository.findAll();
		List<Guests> guests = new ArrayList<>();
		for (Guest g : guestList) {
			
		}
		guestList.forEach(guest -> {
			Guests g = new Guests();
			g.setFirstName(guest.getFirstName());
			g.setLastName(guest.getLastName());
			g.setEmailAddress(guest.getEmailAddress());
			g.setPhoneNumber(guest.getPhoneNumber());
			guests.add(g);
		});
		return guests;
	}
	
}
