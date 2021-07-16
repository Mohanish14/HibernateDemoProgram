package com.hibernate.criteriaApi;

import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import com.hibernate.mapping.HibernateConfiguration;

public class CriteriaApi {
	public static void main(String[] args) {
		
		SessionFactory sfactory =HibernateConfiguration.getSessionfactory(Employee.class);
		Session session =sfactory.openSession();
		Transaction tr= session.beginTransaction();
		
		
		
		Criteria cr=session.createCriteria(Employee.class);
		//cr.add(Restrictions.like("empName", "Akshay"));
		//cr.add(Restrictions.ge("empAge", 30));
		//cr.add(Restrictions.le("empAge", 30));
		
		
		
		ProjectionList proList =Projections.projectionList();
		//proList.add(Projections.min("empSalary"));
		proList.add(Projections.max("empSalary"));

		
		cr.setProjection(proList);
		System.out.println(cr.list());
	
		System.exit(0);
		Employee e1 = new Employee(101,"MOHANISH",ThreadLocalRandom.current().nextInt(23,50), 
				"Lead",ThreadLocalRandom.current().nextInt(10000,50000),"CHANDRAPUR");
		Employee e2 = new Employee(1031,"AKSHAY",ThreadLocalRandom.current().nextInt(23,50), 
				"SSE",ThreadLocalRandom.current().nextInt(10000,50000),"LATUR");
		Employee e3 = new Employee(1501,"KUNAL",ThreadLocalRandom.current().nextInt(23,50), 
				"SE",ThreadLocalRandom.current().nextInt(10000,50000),"NAGBHID");
		Employee e4 = new Employee(1061,"SHRIANSH",ThreadLocalRandom.current().nextInt(23,50), 
				"Manager",ThreadLocalRandom.current().nextInt(10000,50000),"BRAMHAPURI");
		Employee e5 = new Employee(1301,"SUSHANT",ThreadLocalRandom.current().nextInt(23,50), 
				"Lead",ThreadLocalRandom.current().nextInt(10000,50000),"Pune");
		
		session.save(e1);
		session.save(e2);
		session.save(e3);
		session.save(e4);
		session.save(e5);
		session.flush();
		tr.commit();

}
}
	
	
@Entity
@Table(name = "EMP_MASTER")
class Employee{
	@Id
	private int empId;
	private String empName;
	private int empAge;
	private String empRole;
	private double empSalary;
	private String empAddress;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int empId, String empName, int empAge, String empRole, double empSalary, String empAddress) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empAge = empAge;
		this.empRole = empRole;
		this.empSalary = empSalary;
		this.empAddress = empAddress;
	}
	@Override
	public String toString() {
		return "\n Employee [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empRole=" + empRole
				+ ", empSalary=" + empSalary + ", empAddress=" + empAddress + "]";
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpRole() {
		return empRole;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	
	
}