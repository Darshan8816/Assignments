package PersonAadharDao;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import PersonAadharDto.Aadhar;
import PersonAadharDto.Person;

public class PersonAadharDao {

	static EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	static EntityTransaction t = manager.getTransaction();
	static Scanner sc = new Scanner(System.in);

	public void savePerson() {
		Person person = saveP();
		manager.persist(person);
		t.begin();
		t.commit();
		System.out.println("Person saved by id : " + person.getId());
	}

	private Person saveP() {
		System.out.println("enter the name, email, phone_no");
		Person ps = new Person();
		ps.setName(sc.next());
		ps.setEmail(sc.next());
		ps.setPhone(sc.nextLong());
		return ps;
	}

	public void updatePerson() {
		System.out.println("enter the person_id to update : ");
		int id = sc.nextInt();
		Person ps = manager.find(Person.class, id);
		if (ps != null) {
			System.out.println("Enter the name, email, phone");
			ps.setName(sc.next());
			ps.setEmail(sc.next());
			ps.setPhone(sc.nextLong());
			manager.merge(ps);
			t.begin();
			t.commit();
			System.out.println("Person updated with the id : " + ps.getId() + " successfully...!!!");
			return;
		}
		System.err.println("enter the valid person Id...!!!");
	}

	public void deletePerson() {
		System.out.println("enter the person_id to delete : ");
		int id = sc.nextInt();
		Person ps = manager.find(Person.class, id);
		if (ps != null) {
			System.out.println("Person with id : " + ps.getId() + " is deleted successfully...!!!");
			manager.remove(ps);
			t.begin();
			t.commit();
			return;
		}
		System.err.println("Invalid person id , please enter the valid person id");
	}

	public void findById() {
		System.out.println("Enter the Person id you want to fetch the details...");
		int id = sc.nextInt();
		Person ps = manager.find(Person.class, id);
		if (ps != null) {
			System.out.println("\n");
			System.out.println("Person id : " + ps.getId());
			System.out.println("Person name : " + ps.getName());
			System.out.println("Person email : " + ps.getEmail());
			System.out.println("Person phone number : " + ps.getPhone());
			System.out.println("\n\n");
			return;
		}
		System.err.println("Invalid Person id , Please enter the valid id...!!!");
	}

	public void saveAadhar() {
		System.out.println("Please enter the Person Id ");
		int id = sc.nextInt();
		Person p = manager.find(Person.class, id);
		if (p != null) {
			Aadhar s = saveA();
			s.setPerson(p);
			p.setAadhar(s);
			manager.persist(s);
			t.begin();
			t.commit();
			System.out.println("Aadhar is saved successfully...!!!");
		}

	}

	private Aadhar saveA() {
		System.out.println("Enter the Aadhar Number, village, district, state, phone number... ");
		Aadhar a = new Aadhar();
		a.setAadhar_No(sc.next());
		a.setVillage(sc.next());
		a.setDistrict(sc.next());
		a.setState(sc.next());
		a.setPhone(sc.next());
		return a;
	}

	public void updateAadhar() {
		System.out.println("Enter the Aadhar_id to update... ");
		int id = sc.nextInt();
		Aadhar ad = manager.find(Aadhar.class, id);
		if (ad != null) {
			System.out.println("Enter the Aadhar Number, village, district, state, phone number... ");
			ad.setAadhar_No(sc.next());
			ad.setVillage(sc.next());
			ad.setDistrict(sc.next());
			ad.setState(sc.next());
			ad.setPhone(sc.next());
			manager.merge(ad);
			t.begin();
			t.commit();
			System.out.println("Aadhar updated with id :" + ad.getId() + " successfully...!!!");
			return;
		}
		System.err.println("Invalid Aadhar id , please enter the valid aadhar id...!!!");
	}

	public void findAadharById() {
		System.out.println("Enter the Aadhar id you want to fetch the details...");
		int id = sc.nextInt();
		Aadhar ps = manager.find(Aadhar.class, id);
		if (ps != null) {
			System.out.println("\n");
			System.out.println("Aadhar number : " + ps.getAadhar_No());
			System.out.println("Person details : " + ps.getVillage() + ", " + ps.getDistrict() + ", " + ps.getState()
					+ ", " + ps.getPhone());
			System.out.println("\n\n");
			return;
		}
		System.err.println("Invalid Aadhar id , Please enter the valid id...!!!");
	}

	public void deleteAadharById() {
		System.out.println("enter the Aadhar_id to delete : ");
		int id = sc.nextInt();
		Aadhar ps = manager.find(Aadhar.class, id);
		if (ps != null) {
			System.out.println("Aadhar with id : " + ps.getId() + " is deleted successfully...!!!");
			manager.remove(ps);
			t.begin();
			t.commit();
			return;
		}
		System.err.println("Invalid Aadhar id , please enter the valid Aadhar id...!!!");
	}

	public void find_Aadhar_By_Person_Id() {
		System.out.println("enter the Person id ");
		int id = sc.nextInt();
		Query q = manager.createQuery("select a from Aadhar a where a.person.id=?1");
		q.setParameter(1, id);
		Aadhar ad = (Aadhar) q.getSingleResult();
		if (ad != null) {
			System.out.println("\n\n");
			System.out.println("Aadhar number : " + ad.getAadhar_No());
			System.out.println("Person details : " + ad.getVillage() + ", " + ad.getDistrict() + ", " + ad.getState()
					+ ", " + ad.getPhone());
			System.out.println("\n\n");
		} else {
			System.out.println("No students present in trainer id " + id);
		}
	}

}
