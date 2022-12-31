package com.tejas.sm.learningspring.webservice;

import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejas.sm.learningspring.business.ReservationService;
import com.tejas.sm.learningspring.business.RoomReservation;
import com.tejas.sm.learningspring.data.Guest;
import com.tejas.sm.learningspring.data.Room;
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
		Date date = this.dateUtil.createDateFromDateString(dateString);
		return this.reservationService.getRoomReservationsForDate(date);
		
	}
	
	@RequestMapping(path="/rooms", method = RequestMethod.GET)
	public List<Room> getRooms() {
		return this.reservationService.getRooms();
	}

	@RequestMapping(path="/guests", method = RequestMethod.GET)
	public List<Guest> getGuests() {
		return this.reservationService.getGuests();
	}
	
	@PostMapping(path="/guests")
	public void addGuest(@RequestBody Guest guest) {
		this.reservationService.addGuest(guest);
	}

}
