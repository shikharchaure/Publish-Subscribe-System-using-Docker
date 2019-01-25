/*This class maps this application with Database and creates table 
 * as descibed below in the Database*/
package com.entity;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//Create WayPointTable to store response from google api
@Entity
@Table(name="PublisherTable")
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="Id")
	int Id;
	
	@Column(name="PublisherId")
	int publisherId;
	@Column(name="Topic")
	String topic;
	@Lob
	@Column(name="Message")
	byte[] message;
	
	@Column(name="created_at", nullable=false)
	public long createdAt;
	
	
	
	public long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}
	public int getPublisherId() {
		return publisherId;
	}
	public void setPublisherId(int publisherId) {
		this.publisherId = publisherId;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public byte[] getMessage() {
		return message;
	}
	public void setMessage(byte[] message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Publisher [Id=" + Id + ", publisherId=" + publisherId + ", topic=" + topic + ", message="
				+ Arrays.toString(message) + "]";
	}
	
	
}
