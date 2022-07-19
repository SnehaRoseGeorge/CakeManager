package com.waracle.cakemanager.entity;

import javax.persistence.*;

@Entity
@Table(name = "Cake", uniqueConstraints = {@UniqueConstraint(columnNames = "ID"), @UniqueConstraint(columnNames = "NAME")})
public class CakeEntity{

	public CakeEntity() {
		
	}
    public CakeEntity(Integer cakeId, String cakeName, String cakeDescription) {
		super();
		this.cakeId = cakeId;
		this.cakeName = cakeName;
		this.cakeDescription = cakeDescription;
	}
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private int cakeId;

    @Column(name = "NAME", unique = true, nullable = false, length = 100)
    private String cakeName;

    @Column(name = "DESCRIPTION", unique = false, nullable = false, length = 100)
    private String cakeDescription;

	public int getCakeId() {
		return cakeId;
	}

	public void setCakeId(int cakeId) {
		this.cakeId = cakeId;
	}

	public String getCakeName() {
		return cakeName;
	}

	public void setCakeName(String cakeName) {
		this.cakeName = cakeName;
	}

	public String getCakeDescription() {
		return cakeDescription;
	}

	public void setCakeDescription(String cakeDescription) {
		this.cakeDescription = cakeDescription;
	}

	@Override
	public String toString() {
		return "CakeEntity [cakeId=" + cakeId + ", cakeName=" + cakeName + ", cakeDescription=" + cakeDescription + "]";
	}


   

}