package com.hibernate.mapping;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class Mapping{
	
	public static void main(String[] args) {
		
		SessionFactory sFactory =HibernateConfiguration.getSessionfactory(Employee.class,Company.class);
		Session session = sFactory.openSession();
		Transaction tran = session.beginTransaction();
		
		Employee emp1 = new Employee(101, "Mohansih", "Engg",null);
		Employee emp2 = new Employee(102, "Pramod", "Sup",null);
		Employee emp3 = new Employee(103, "Paresh", "Tech",null);
		Employee emp4 = new Employee(104, "Ankush", "Tech",null);
		Employee emp5 = new Employee(105, "Vivek", "FE",null);
		Employee emp6 = new Employee(106, "Sagar", "AFM",null);
		
		Company comp1 = new Company(501, "IBM 1.3", "PASHE II",emp1);
		Company comp2 = new Company(502, "CG", "PASHE II",emp2);
		Company comp3 = new Company(503, "IBM 1.1", "PASHE II",emp3);
		Company comp4 = new Company(504, "WIPRO", "PASHE II",emp4);
		Company comp5 = new Company(505, "IBM", "KHRADI",emp5);
		Company comp6 = new Company(506, "IBM", "TPO",emp6);
		
		emp1.setCompRef(comp1);
		emp2.setCompRef(comp2);
		emp3.setCompRef(comp3);
		emp4.setCompRef(comp4);
		emp5.setCompRef(comp5);
		emp6.setCompRef(comp6);
		
		session.save(comp1);
		session.save(comp2);
		session.save(comp3);
		session.save(comp4);
		session.save(comp5);
		session.save(comp6);
		session.save(emp1);
		session.save(emp2);
		session.save(emp3);
		session.save(emp4);
		session.save(emp5);
		session.save(emp6);
		session.flush();
		tran.commit();
	}
	
}



@Entity
@Table(name = "EMP_INFO")
class Employee{
	@Id
	private int empId;
	private String empName;
	private String empRole;
	@OneToOne
	private Company compRef;
	
	public Employee() {
		super();
	}

	public Employee(int empId, String empName, String empRole, Company compRef) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empRole = empRole;
		this.compRef = compRef;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empRole=" + empRole + ", compRef=" + compRef
				+ "]";
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

	public String getEmpRole() {
		return empRole;
	}

	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}

	public Company getCompRef() {
		return compRef;
	}

	public void setCompRef(Company compRef) {
		this.compRef = compRef;
	}
	
		
	
	
	
}


@Entity
@Table(name = "COMP_INFO")
class Company{
	@Id
	private int compId;
	private String compName;
	private String compLoc;
	@OneToOne
	@JoinTable(
	        name = "EMP_INFORMATION",
	        joinColumns = @JoinColumn(
	                name = "EMPLOYEE_ID",
	                referencedColumnName = "empId"
	        ),
	        inverseJoinColumns = @JoinColumn(
	                name = "COMP_ID",
	                referencedColumnName = "compId"
	        )
	)
	private Employee empRef;
	
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Company(int compId, String compName, String compLoc, Employee empRef) {
		super();
		this.compId = compId;
		this.compName = compName;
		this.compLoc = compLoc;
		this.empRef = empRef;
	}

	@Override
	public String toString() {
		return "Company [compId=" + compId + ", compName=" + compName + ", compLoc=" + compLoc + ", empRef=" + empRef
				+ "]";
	}

	public int getCompId() {
		return compId;
	}

	public void setCompId(int compId) {
		this.compId = compId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public String getCompLoc() {
		return compLoc;
	}

	public void setCompLoc(String compLoc) {
		this.compLoc = compLoc;
	}

	public Employee getEmpRef() {
		return empRef;
	}

	public void setEmpRef(Employee empRef) {
		this.empRef = empRef;
	}
	
	
	
}