package com.tejas.sm.learningspring.data;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RESERVATION")
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="RESERVATION_ID")
	private long reservationId;
	@Column(name="ROOM_ID")
	private long roomId;
	@Column(name="GUEST_ID")
	private long guestId;
	@Column(name="RES_DATE")
	private Date reservationDate;
	
	public long getReservationId() {
		return reservationId;
	}
	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}
	public long getRoomId() {
		return roomId;
	}
	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Reservation{ Reservation ID: " +reservationId+" Room ID: "+roomId+ " Guest ID:" +guestId+ " Reservation Date:" +reservationDate+" }";
	}
}
