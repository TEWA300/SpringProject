package com.tejas.sm.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tejas.sm.learningspring.business.ReservationService;
import com.tejas.sm.learningspring.business.RoomReservation;
import com.tejas.sm.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservation")
public class RoomReservationController {
	private final DateUtils dateUtil;
	private final ReservationService reservationService;
	
	public RoomReservationController(DateUtils dateUtil, ReservationService reservationService) {
		super();
		this.dateUtil = dateUtil;
		this.reservationService = reservationService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String getReservations(@RequestParam(value = "date", required = false) String dateString, Model model) {
		Date date = this.dateUtil.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations", roomReservations);
		return "roomres"; //template name
		
	}
}

