package PersonAadharController;

import java.util.Scanner;

import PersonAadharDao.PersonAadharDao;

public class Controller {

	static PersonAadharDao dao = new PersonAadharDao();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
					"1.Save_Person \n2.Update_Person \n3.Find_By_Id \n4.Delete_Person \n5.Save_Aadhar \n6.Update_Aadhar \n7.Find_Aadhar_by_Id \n8.Delete_Aadhar_By_Id \n9.Find_Aadhar_by_Person_Id \n10.exit");
			System.out.println("Select the option above");
			int opt = sc.nextInt();

			switch (opt) {
			case 1: {
				dao.savePerson();
				break;
			}
			case 2: {
				dao.updatePerson();
				break;
			}
			case 3: {
				dao.findById();
				break;
			}
			case 4: {
				dao.deletePerson();
				break;
			}
			case 5: {
				dao.saveAadhar();
				break;
			}
			case 6: {
				dao.updateAadhar();
				break;
			}
			case 7: {
				dao.findAadharById();
				break;
			}
			case 8: {
				dao.deleteAadharById();
				break;
			}
			case 9: {
				dao.find_Aadhar_By_Person_Id();
				break;
			}
			case 10: {
				System.exit(0);
			}

			}
		}
	}
}