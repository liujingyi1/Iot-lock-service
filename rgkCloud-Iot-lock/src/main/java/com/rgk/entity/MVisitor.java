package com.rgk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
/**
 * 访客管理
 *
 */
@Entity
@Table(name = "m_vistor")
@EntityListeners(AuditingEntityListener.class)
public class MVisitor implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
    @GenericGenerator(name="uuidGenerator",strategy="uuid")
    @GeneratedValue(generator="uuidGenerator")
	@Column(length = 100)
    private String id;
	
	//到访楼栋
	@Column(name = "build_no")
	private String buildNo;
	
	//到访楼层
	@Column(name = "floor_no")
	private String floorNo;
	
	//到访房号
	@Column(name = "room_no")
	private String roomNo;
	
	//邀请人
	@Column(name = "invite_name")
	private String invite;
	
	//邀请人电话
	@Column(name = "invite_phone")
	private String invitePhone;
	
	//来访人
    @Column(name = "vistor_name")
	private String vistorName;
	
	//来访人电话
    @Column(name = "vistor_phone")
	private String vistorPhone;
	
	//来访类型
    @Column(name = "vistor_type")
	private String type;
	
    @Column(name = "start_time")
	public Date startTime;
	
    @Column(name = "end_time")
	public Date endTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildNo() {
		return buildNo;
	}

	public void setBuildNo(String buildNo) {
		this.buildNo = buildNo;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public String getInvite() {
		return invite;
	}

	public void setInvite(String invite) {
		this.invite = invite;
	}

	public String getInvitePhone() {
		return invitePhone;
	}

	public void setInvitePhone(String invitePhone) {
		this.invitePhone = invitePhone;
	}

	public String getVistorName() {
		return vistorName;
	}

	public void setVistorName(String vistorName) {
		this.vistorName = vistorName;
	}

	public String getVistorPhone() {
		return vistorPhone;
	}

	public void setVistorPhone(String vistorPhone) {
		this.vistorPhone = vistorPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
