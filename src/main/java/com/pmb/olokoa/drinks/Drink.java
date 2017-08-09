package com.pmb.olokoa.drinks;

import java.net.URL;


public class Drink {
	private String name;
	private String ownerId;
	private String id;
	private URL thumbnail;
	private String description;
	private Integer cost;
	private Boolean posted;

	private Drink(){
		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(String ownerId) {
		this.ownerId = ownerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public URL getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(URL thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public boolean isPosted() {
		return posted;
	}
	public void setPosted(boolean posted) {
		this.posted = posted;
	}
	
	public Drink(Builder b){
		this.name = b.name;
		this.ownerId = b.ownerId;
		this.id = b.id;
		this.description = b.description;
		this.thumbnail = b.thumbnail;
		this.cost = b.cost;
		this.posted = b.posted;
	}
	
	
	@Override
	public String toString(){
		return id + ", " + name + ", " + thumbnail.toString() + ", " + description + ", " + cost
				+ ", " + ownerId + ", " + posted;
		
		//id, name, thumbnail, description, unit cost, ownerid, posted

	}
	
	public static class Builder{
		private String name;
		private String ownerId;
		private String id;
		private URL thumbnail;
		private String description;
		private Integer cost;
		private Boolean posted;
		
		public Builder name(String name){
			this.name = name;
			return this;
		}
		public Builder ownerId(String ownerId){
			this.ownerId = ownerId;
			return this;
		}
		public Builder id(String id){
			this.id = id;
			return this;
		}
		public Builder thumbnail(URL thumbnail){
			this.thumbnail = thumbnail;
			return this;
		}
		public Builder description(String description){
			this.description = description;
			return this;
		}
		public Builder cost(int cost){
			this.cost = cost;
			return this;
		}
		public Builder posted(boolean posted){
			this.posted = posted;
			return this;
		}
		
		public Drink build() {
			return new Drink(this);
		}
	}	
}
