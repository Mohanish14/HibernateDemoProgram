package om.hibernate.datafetchways;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.mapping.HibernateConfiguration;
import com.hibernate.orm.demo.HibernateConfig;

public class DataFetchWays {

	public static void main(String[] args) {
		SessionFactory sfactory = HibernateConfiguration.getSessionfactory(Emp.class);
		Session session = sfactory.openSession();

		Emp emp1 = session.get(Emp.class, 101);
		System.out.println("Using Get " + emp1);
		System.out.println("--------------------------------------------------------------");

		Emp emp2 = session.load(Emp.class, 101);
		System.out.println("Using load " + emp2);
		System.out.println("--------------------------------------------------------------");

		Query hsqlQuery = session.createQuery("from Emp where empAge>=30");
		List<Emp> emps = hsqlQuery.list();
		System.out.println("Using HQL" + emps);
		System.out.println("--------------------------------------------------------------");

		SQLQuery sqlQuery = session.createSQLQuery("select * from EMP_MASTER where empAge>=30");
		sqlQuery.addEntity(Emp.class); // addEntity --> resultSetMadhe --- map it to Entity class
		emps = sqlQuery.list();
		System.out.println("Using SQL " + emps);

		System.exit(0);
		Emp e1 = new Emp(101, "WERETRY", ThreadLocalRandom.current().nextInt(23, 50), "Lead",
				ThreadLocalRandom.current().nextInt(10000, 50000), "Pune");
		Emp e2 = new Emp(1031, "ASDFDSG", ThreadLocalRandom.current().nextInt(23, 50), "SSE",
				ThreadLocalRandom.current().nextInt(10000, 50000), "Pune");
		Emp e3 = new Emp(1501, "ZXVZXBX", ThreadLocalRandom.current().nextInt(23, 50), "SE",
				ThreadLocalRandom.current().nextInt(10000, 50000), "Pune");
		Emp e4 = new Emp(1061, "LJHKGG", ThreadLocalRandom.current().nextInt(23, 50), "Manager",
				ThreadLocalRandom.current().nextInt(10000, 50000), "Pune");
		Emp e5 = new Emp(1301, "PIOIUYI", ThreadLocalRandom.current().nextInt(23, 50), "Lead",
				ThreadLocalRandom.current().nextInt(10000, 50000), "Pune");

		session = sfactory.openSession();
		Transaction tr = session.beginTransaction();
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
class Emp {
	@Id
	private int empId;
	private String empName;
	private int empAge;
	private String empRole;
	private double empSalary;
	private String empAddress;

	public Emp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Emp(int empId, String empName, int empAge, String empRole, double empSalary, String empAddress) {
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
		return "Emp [empId=" + empId + ", empName=" + empName + ", empAge=" + empAge + ", empRole=" + empRole
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
