package com.trouble.catering.entity;

public class ShopperEntity {
	
	private String key;
	private String description;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ShopperEntity(String key, String description) {
		super();
		this.key = key;
		this.description = description;
	}
	public ShopperEntity() {
		super();
	}
	
	
}
