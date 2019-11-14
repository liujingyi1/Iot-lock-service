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
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * 成员
 *
 */
@Entity
@Table(name = "m_member")
@EntityListeners(AuditingEntityListener.class)
public class MMember implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GenericGenerator(name="uuidGenerator",strategy="uuid")
    @GeneratedValue(generator="uuidGenerator")
    @Column(length = 100)
    private String id;
    
    // 姓名
    @Column(name = "name", nullable = true, length = 100)
    private String name;
    
    //性别
    @Column(name = "sex")
    private Integer sex;
    
    private String villageId;
    
    private String buildingId;
    
    private String floorId;
    
    private String roomId;
    
    //住户类别
    @Column(name = "type")
    private Integer type;
    
    //是否发放钥匙
    @Column(name = "granted_key")
    private Boolean grantedKey;
    
    //钥匙有效期
    @Column(name = "key_type")
    private Integer keyType;
    
    //钥匙有效期开始
    @Column(name = "key_start")
    private Date keyStart;
    
    //钥匙有效期结束
    @Column(name = "key_end")
    private Date keyEnd;
    
    //是否注册
    @Column(name = "registed", length = 1)
    private Boolean registed;
    
    //电话
    @Column(name = "phone", length = 25, unique = true)
    private String phone;
    
    //证件类型
    @Column(name = "certificates_type")
    private Date certificatesType;
    
    //证件号码
    @Column(name = "certificates_number")
    private Date certificatesNumber;
    
    //是否审核
    @Column(name = "verify")
    private Boolean verify;
    
    //上次登录时间
    @Column(name = "last_login")
    private Date lastLogin;
    
    //年龄
    @Column(name = "age", length = 3)
    private Integer age;

    //有效期
    @Column(name = "term_of_validity")
    private String termOfValidity;
    
    //备注
    @Column(name = "note")
    private String note;
    
    //照片
    @Column(name = "picUrl")
    private String picUrl;
    
    //人脸库memberId
    @Column(name = "face_member_id")
    private String faceMemberId;
    
    @CreatedDate
	public Date createdDate;
    
    @CreatedBy
    public String createdBy;

	@LastModifiedDate
	public Date modifiedDate;
	
	@LastModifiedBy
	public String modifiedBy;
	
	public String getVillageId() {
		return villageId;
	}

	public void setVillageId(String villageId) {
		this.villageId = villageId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Boolean getGrantedKey() {
		return grantedKey;
	}

	public void setGrantedKey(Boolean grantedKey) {
		this.grantedKey = grantedKey;
	}

	public Integer getKeyType() {
		return keyType;
	}

	public void setKeyType(Integer keyType) {
		this.keyType = keyType;
	}

	public Date getKeyStart() {
		return keyStart;
	}

	public void setKeyStart(Date keyStart) {
		this.keyStart = keyStart;
	}

	public Date getKeyEnd() {
		return keyEnd;
	}

	public void setKeyEnd(Date keyEnd) {
		this.keyEnd = keyEnd;
	}

	public Boolean getRegisted() {
		return registed;
	}

	public void setRegisted(Boolean registed) {
		this.registed = registed;
	}

	public Boolean getVerify() {
		return verify;
	}

	public void setVerify(Boolean verify) {
		this.verify = verify;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getFaceMemberId() {
		return faceMemberId;
	}

	public void setFaceMemberId(String faceMemberId) {
		this.faceMemberId = faceMemberId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public Date getCertificatesType() {
		return certificatesType;
	}

	public void setCertificatesType(Date certificatesType) {
		this.certificatesType = certificatesType;
	}

	public Date getCertificatesNumber() {
		return certificatesNumber;
	}

	public void setCertificatesNumber(Date certificatesNumber) {
		this.certificatesNumber = certificatesNumber;
	}

	public String getTermOfValidity() {
		return termOfValidity;
	}

	public void setTermOfValidity(String termOfValidity) {
		this.termOfValidity = termOfValidity;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


	public String getPhone() {
        return phone;
    }

	public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
