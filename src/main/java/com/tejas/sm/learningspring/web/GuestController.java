package com.tejas.sm.learningspring.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.tejas.sm.learningspring.business.GuestService;
import com.tejas.sm.learningspring.business.Guests;

@Controller
@RequestMapping("/guests")
public class GuestController {
	private final GuestService guestService;

	public GuestController(GuestService guestService) {
		super();
		this.guestService = guestService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getGuests(Model model) {
		List<Guests> guests = this.guestService.getGuestList();
		model.addAttribute("guestList", guests);
		return "guestlist";
	}
}
