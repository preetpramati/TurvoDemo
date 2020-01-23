package com.techshard.graphql.dao.entity;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;

public class Showroom {

	 @Id
	 @GeneratedValue
	 private long showRoomID;
	 private String name;

	 private String company;

	 private String location;

	    
		public long getShowRoomID() {
			return showRoomID;
		}

		public void setShowRoomID(long showRoomID) {
			this.showRoomID = showRoomID;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getCompany() {
			return company;
		}

		public void setCompany(String company) {
			this.company = company;
		}

		public String getLocation() {
			return location;
		}

		public void setLocation(String location) {
			this.location = location;
		}
	    
}
