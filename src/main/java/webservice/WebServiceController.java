package webservice;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
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
		super();
		this.reservationService = reservationService;
		this.dateUtil = dateUtil;
	}
	
	@RequestMapping("/reservations", method = RequestMethod.GET)
	public List<RoomReservation> getRoomReservations(Param) {
		
	}

}
