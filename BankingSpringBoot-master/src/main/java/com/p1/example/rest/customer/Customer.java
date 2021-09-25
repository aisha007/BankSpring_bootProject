package com.p1.example.rest.customer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
		Integer custid; 
		String name; 
		String dob; 
		String mail_id;
		public Customer(){
			
		}
		public Customer(int custid, String name, String dob, String mail_id) {
			super();
			this.custid = custid;
			this.name = name;
			this.dob = dob;
			this.mail_id = mail_id;
		}
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer getCustid() {
			return custid;
		}
		public void setCustid(int custid) {
			this.custid = custid;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDob() {
			return dob;
		}
		public void setDob(String dob) {
			this.dob = dob;
		}
		public String getMail_id() {
			return mail_id;
		}
		public void setMail_id(String mail_id) {
			this.mail_id = mail_id;
		}
		@Override
		public String toString() {
			return "Product [custid=" + custid + ", name=" + name + ", dob=" + dob + ", mail_id=" + mail_id + "]";
		}
	    
}
