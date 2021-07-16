package com.hibernate.inheritence;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.hibernate.mapping.HibernateConfiguration;

public class HibernateInheritenceDemo {
	public static void main(String[] args) {
		 
		GrandFather gf = new GrandFather("GF1","GF2");
		Father f = new Father("fGF1", "fGF2", "F1", "F2");
		Son s = new Son("sGF1", "sGF2", "sF3", "sF4", "S1", "S2");
		Daughter D = new Daughter("dGF1", "dGF2", "dF1", "dF2", "D1", "D2");
		Son s1 = new Son("sGF1", "sGF2", "sF3", "sF4", "S1", "S2");
		Daughter D1 = new Daughter("dGF1", "dGF2", "dF1", "dF2", "D1", "D2");
		SessionFactory factory = HibernateConfiguration.getSessionfactory(GrandFather.class,Father.class,Son.class,Daughter.class);
		
		Session sess = factory.openSession();
		Transaction tr = sess.beginTransaction();
		sess.save(gf);
		sess.save(f);
		sess.save(s);
		sess.save(D);
		sess.save(s1);
		sess.save(D1);
		sess.flush();
		tr.commit();
	}

}

@Entity
@Table(name = "GRAND_MASTER")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)  //--> for entire hierarchy single table, nullable False is not possible 
//@Inheritance(strategy = InheritanceType.JOINED)  // --> Every Class has Separate Table and Relationship maintained by foreign key1
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)  --> Foreign key Same for entire Hierarchy but data in separate table 

class GrandFather{
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id;
	private String gf1;
	private String gf2;

	public GrandFather() {
		super();
		// TODO Auto-generated constructor stub
	}
	public GrandFather(String gf1, String gf2) {
		super();
		this.gf1 = gf1;
		this.gf2 = gf2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGf1() {
		return gf1;
	}
	public void setGf1(String gf1) {
		this.gf1 = gf1;
	}
	public String getGf2() {
		return gf2;
	}
	public void setGf2(String gf2) {
		this.gf2 = gf2;
	}
	
	
	
}
@Entity(name = "FATHER")
class Father extends GrandFather{
	
	private String f1;
	private String f2;
	
	
	public Father() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Father(String gf1, String gf2) {
		super(gf1, gf2);
		// TODO Auto-generated constructor stub
	}
	public Father(String gf1, String gf2, String f1, String f2) {
		super(gf1, gf2);
		this.f1 = f1;
		this.f2 = f2;
	}
	public String getF1() {
		return f1;
	}
	public void setF1(String f1) {
		this.f1 = f1;
	}
	public String getF2() {
		return f2;
	}
	public void setF2(String f2) {
		this.f2 = f2;
	}
	
	
}

@Entity(name = "SON")
class Son extends Father{
	private String s1;
	private String s2;
	public Son() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Son(String gf1, String gf2, String f1, String f2) {
		super(gf1, gf2, f1, f2);
		// TODO Auto-generated constructor stub
	}
	public Son(String gf1, String gf2) {
		super(gf1, gf2);
		// TODO Auto-generated constructor stub
	}
	public Son(String gf1, String gf2, String f1, String f2, String s1, String s2) {
		super(gf1, gf2, f1, f2);
		this.s1 = s1;
		this.s2 = s2;
	}
	public String getS1() {
		return s1;
	}
	public void setS1(String s1) {
		this.s1 = s1;
	}
	public String getS2() {
		return s2;
	}
	public void setS2(String s2) {
		this.s2 = s2;
	}
		
}
@Entity(name = "DAUGHTER")
class Daughter extends Father{
	
	
	private String s1;
	private String s2;
	public Daughter() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Daughter(String gf1, String gf2, String f1, String f2) {
		super(gf1, gf2, f1, f2);
		// TODO Auto-generated constructor stub
	}
	public Daughter(String gf1, String gf2) {
		super(gf1, gf2);
		// TODO Auto-generated constructor stub
	}
	public Daughter(String gf1, String gf2, String f1, String f2, String s1, String s2) {
		super(gf1, gf2, f1, f2);
		this.s1 = s1;
		this.s2 = s2;
	}
	
	
}