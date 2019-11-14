package com.rgk.domain;

import com.rgk.entity.MBuilding;
import com.rgk.entity.MFloor;
import com.rgk.entity.MRoom;
import com.rgk.entity.MVillage;

public class PositionView {
	MVillage village;
	MBuilding building;
	MFloor floor;
	MRoom room;
	
	public PositionView() {
	}
	
	public PositionView(MVillage village, MBuilding building, MFloor floor, MRoom room) {
		super();
		this.village = village;
		this.building = building;
		this.floor = floor;
		this.room = room;
	}
	public MVillage getVillage() {
		return village;
	}
	public void setVillage(MVillage village) {
		this.village = village;
	}
	public MBuilding getBuilding() {
		return building;
	}
	public void setBuilding(MBuilding building) {
		this.building = building;
	}
	public MFloor getFloor() {
		return floor;
	}
	public void setFloor(MFloor floor) {
		this.floor = floor;
	}
	public MRoom getRoom() {
		return room;
	}
	public void setRoom(MRoom room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "PositionView [village=" + village + ", building=" + building + ", floor=" + floor + ", room=" + room
				+ "]";
	}

}
