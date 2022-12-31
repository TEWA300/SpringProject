package com.tejas.sm.learningspring.business;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejas.sm.learningspring.data.Guest;
import com.tejas.sm.learningspring.data.GuestRepository;
import com.tejas.sm.learningspring.data.Reservation;
import com.tejas.sm.learningspring.data.ReservationRepository;
import com.tejas.sm.learningspring.data.Room;
import com.tejas.sm.learningspring.data.RoomRepository;

@Service
public class ReservationService {
	
    private final RoomRepository roomRepository;
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;

    
    
    public ReservationService(RoomRepository roomRepository, GuestRepository guestRepository,
			ReservationRepository reservationRepository) {
		super();
		this.roomRepository = roomRepository;
		this.guestRepository = guestRepository;
		this.reservationRepository = reservationRepository;
	}



	public List<RoomReservation> getRoomReservationsForDate(Date date) {
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap();
        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();
            roomReservation.setRoomId(room.getId());
            roomReservation.setRoomName(room.getName());
            roomReservation.setRoomNumber(room.getRoomNumber());
            roomReservationMap.put(room.getId(), roomReservation);
        });
        Iterable<Reservation> reservations = this.reservationRepository.findReservationByReservationDate(new java.sql.Date(date.getTime()));
        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());
            roomReservation.setDate(date);
            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();
            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });
        List<RoomReservation> roomReservations = new ArrayList<>();
        for (Long id : roomReservationMap.keySet()) {
            roomReservations.add(roomReservationMap.get(id));
        }
        roomReservations.sort(new Comparator<RoomReservation>() {
            @Override
            public int compare(RoomReservation o1, RoomReservation o2) {
                if (o1.getRoomName().equals(o2.getRoomName())) {
                    return o1.getRoomNumber().compareTo(o2.getRoomNumber());
                }
                return o1.getRoomName().compareTo(o2.getRoomName());
            }
        });
        return roomReservations;
    }
	
	public List<Guest> getGuestList() {
		List<Guest> guestList = this.guestRepository.findAll();
		List<Guest> guests = new ArrayList<>();
		
		guestList.forEach(guest -> {
			Guest g = new Guest();
			g.setFirstName(guest.getFirstName());
			g.setLastName(guest.getLastName());
			g.setEmailAddress(guest.getEmailAddress());
			g.setPhoneNumber(guest.getPhoneNumber());
			guests.add(g);
		});
		return guests;
	}
	
	public List<Room> getRooms(){
		return (List<Room>) this.roomRepository.findAll();
	}
	
	public List<Guest> getGuests() {
		return this.guestRepository.findAll();
	}
	
	public void addGuest(Guest guest) {
		if (guest != null) {
			System.out.println(guest);
			this.guestRepository.save(guest);
		} else {
			throw new RuntimeException("Guest can not be NULL");
		}
		
	}
}

