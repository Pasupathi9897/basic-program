package com.dxc.beans;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {
int id;
String name;
String email;
String mobile;
public Student() {
	super();
	// TODO Auto-generated constructor stub
}
public Student(int id, String name, String email, String mobile) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.mobile = mobile;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", email=" + email + ", mobile=" + mobile + "]";
}

}
