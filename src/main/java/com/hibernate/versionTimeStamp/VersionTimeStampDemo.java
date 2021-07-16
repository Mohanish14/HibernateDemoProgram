package com.hibernate.versionTimeStamp;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hibernate.mapping.HibernateConfiguration;

public class VersionTimeStampDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		Account ac1 = new Account(101,1122333,"Mr XXX",12892.23,"Pune","Mohaish",null);
		Account ac2 = new Account(102,2233311,"Mr YYY",4892.23,"Pune","Avinash",null);
		
		SessionFactory sfatory =HibernateConfiguration.getSessionfactory(Account.class);

		TimeUnit.SECONDS.sleep(10);

		
		Session session = sfatory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(ac1);
		session.save(ac2);
		session.flush();
		tr.commit();

		
		
		TimeUnit.SECONDS.sleep(10);
		
		ac1.setAccBalance(500001.0);
		ac1.setUpdatedBy("Akshay");
		tr = session.beginTransaction();
		session.update(ac1);
		session.flush();
		tr.commit();
		
		TimeUnit.SECONDS.sleep(10);
		
		ac1.setAccBalance(75000.0);
		ac1.setUpdatedBy("Mohanish");
		ac2.setAccBalance(88000.0);
		ac2.setUpdatedBy("Kunal");
		tr = session.beginTransaction();
		session.update(ac1);
		session.update(ac2);
		session.flush();
		tr.commit();
	}

}

@Entity
@Table(name = "BANK_INFO")
class Account {
	@Id
	@Column(name = "CUSTOMER_ID")
	private int customerId;

	@Column(name = "ACCOUNT_NO")
	private int accountNo;

	@Column(name = "CUST_NAME")
	private String customerName;

	@Column(name = "ACC_BALANCE")
	private double accBalance;

	@Column(name = "CUSTOMER_ADD")
	private String customerAddress;

	@Column(name = "CREATED_BY")
	private String createdBy;

	@CreationTimestamp
	@Column(name = "CREATED_ON")
	private LocalDateTime createdOn;

	@Column(name = "UPDATE_BY")
	private String updatedBy;

	@UpdateTimestamp
	@Column(name = "UPDATED_ON")
	private LocalDateTime updatedOn;

	@Version
	@Column(name = "VERSION")
	private int version;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int customerId, int accountNo, String customerName, double accBalance, String customerAddress,
			String createdBy, String updatedBy) {
		super();
		this.customerId = customerId;
		this.accountNo = accountNo;
		this.customerName = customerName;
		this.accBalance = accBalance;
		this.customerAddress = customerAddress;
		this.createdBy = createdBy;
		this.updatedBy = updatedBy;
	}

	@Override
	public String toString() {
		return "Account [customerId=" + customerId + ", accountNo=" + accountNo + ", customerName=" + customerName
				+ ", accBalance=" + accBalance + ", customerAddress=" + customerAddress + ", createdBy=" + createdBy
				+ ", createdOn=" + createdOn + ", updatedBy=" + updatedBy + ", updatedOn=" + updatedOn + ", version="
				+ version + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public int getVersion() {
		return version;
	}

}