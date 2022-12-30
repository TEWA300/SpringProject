package com.tejas.sm.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.sm.learningspring.business.ReservationService;
import com.tejas.sm.learningspring.business.RoomReservation;
import com.tejas.sm.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebServiceController {
	private final ReservationService reservationService;
	private final DateUtils dateUtil;
	
	public WebServiceController(ReservationService reservationService, DateUtils dateUtil) {
		this.reservationService = reservationService;
		this.dateUtil = dateUtil;
	}
	
	@RequestMapping(path="/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getRoomReservations(@RequestParam(value = "date", required = false) String dateString) {
		System.out.println("*****************INSIDE API*****************");
		Date date = this.dateUtil.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
		
	}

}
