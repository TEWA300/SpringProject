package com.tejas.sm.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.tejas.sm.learningspring.business.ReservationService;
import com.tejas.sm.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestController {
	private final ReservationService reservationService;

	public GuestController(ReservationService reservationService) {
		super();
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		List<Guest> guests = this.reservationService.getGuestList();
		model.addAttribute("guestList", guests);
		return "guestlist";
	}
}
