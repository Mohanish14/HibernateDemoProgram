package com.hibernate.inheritence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.mapping.HibernateConfiguration;

public class Demo {
public static void main(String[] args) {
	
	Grand gp = new Grand("G1", "G2");
	Parent1 p1 = new Parent1("PG1", "PG2", "P1", "P2"); 
	Child1 c1 = new Child1("C1G1", "C1G2", "C1P1", "C1G2", "X1", "X2");
	Child2 c2 = new Child2("C2G1", "C2G2", "C2G1", "C2P2", "Y1", "Y2"); 
	Child1 c11 = new Child1("C1G1", "C1G2", "C1P1", "C1G2", "X1", "X2"); // 5
	Child2 c22 = new Child2("C2G1", "C2G2", "C2G1", "C2P2", "Y1", "Y2");// 6
	Parent1 p2 = new Parent1("PG1", "PG2", "P1", "P2");// 7
	SessionFactory sf =HibernateConfiguration.getSessionfactory(Grand.class,Parent1.class,Child1.class,Child2.class);
	
	Session session = sf.openSession();
	Transaction tr = session.beginTransaction();
	session.save(gp);
	session.save(p1);
	session.save(p2);
	session.save(c1);
	session.save(c2);
	session.save(c11);
	session.save(c22);
	
	session.flush();
	tr.commit();
	
/*	
	ChildOne c11 = new ChildOne("C1G1", "C1G2", "C1P1", "C1G2", "X1", "X2"); // 5
	ChildTwo c22 = new ChildTwo("C2G1", "C2G2", "C2G1", "C2P2", "Y1", "Y2");// 6
	Parent p2 = new Parent("PG1", "PG2", "P1", "P2");// 7
*/
}
}
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
class Grand {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int value;
	private String g1;
	private String g2;

	public Grand() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Grand(String g1, String g2) {
		super();
		this.g1 = g1;
		this.g2 = g2;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getG1() {
		return g1;
	}

	public void setG1(String g1) {
		this.g1 = g1;
	}

	public String getG2() {
		return g2;
	}

	public void setG2(String g2) {
		this.g2 = g2;
	}

}
@Entity
class Parent1 extends Grand {
	private String p1;
	private String p2;

	public Parent1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Parent1(String g1, String g2) {
		super(g1, g2);
		// TODO Auto-generated constructor stub
	}

	public Parent1(String g1, String g2, String p1, String p2) {
		super(g1, g2);
		this.p1 = p1;
		this.p2 = p2;
	}

	public String getP1() {
		return p1;
	}

	public void setP1(String p1) {
		this.p1 = p1;
	}

	public String getP2() {
		return p2;
	}

	public void setP2(String p2) {
		this.p2 = p2;
	}

}
@Entity
class Child1 extends Parent1 {
	private String x1;
	private String x2;

	public Child1() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child1(String g1, String g2, String p1, String p2) {
		super(g1, g2, p1, p2);
		// TODO Auto-generated constructor stub
	}

	public Child1(String g1, String g2) {
		super(g1, g2);
		// TODO Auto-generated constructor stub
	}

	public Child1(String g1, String g2, String p1, String p2, String x1, String x2) {
		super(g1, g2, p1, p2);
		this.x1 = x1;
		this.x2 = x2;
	}

	public String getX1() {
		return x1;
	}

	public void setX1(String x1) {
		this.x1 = x1;
	}

	public String getX2() {
		return x2;
	}

	public void setX2(String x2) {
		this.x2 = x2;
	}

}
@Entity
class Child2 extends Parent1 {
	private String y1;
	private String y2;

	public Child2() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Child2(String g1, String g2, String p1, String p2) {
		super(g1, g2, p1, p2);
		// TODO Auto-generated constructor stub
	}

	public Child2(String g1, String g2) {
		super(g1, g2);
		// TODO Auto-generated constructor stub
	}

	public Child2(String g1, String g2, String p1, String p2, String y1, String y2) {
		super(g1, g2, p1, p2);
		this.y1 = y1;
		this.y2 = y2;
	}

	public String getY1() {
		return y1;
	}

	public void setY1(String y1) {
		this.y1 = y1;
	}

	public String getY2() {
		return y2;
	}

	public void setY2(String y2) {
		this.y2 = y2;
	}

}