package com.dxc.beans;

public class Employee {
int eid;
String ename;
String emobile;
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
public Employee(int eid, String ename, String emobile) {
	super();
	this.eid = eid;
	this.ename = ename;
	this.emobile = emobile;
}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEmobile() {
	return emobile;
}
public void setEmobile(String emobile) {
	this.emobile = emobile;
}
@Override
public String toString() {
	return "Employee [eid=" + eid + ", ename=" + ename + ", emobile=" + emobile + "]";
}

}
