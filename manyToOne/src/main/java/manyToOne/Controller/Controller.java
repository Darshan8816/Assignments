package manyToOne.Controller;

import java.util.Scanner;

import manyToOne.Dao.User_Book_Dao;

public class Controller {
	static User_Book_Dao dao=new User_Book_Dao();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println(
					"1.Save_User \n2.Update_User \n3.Find_By_Id \n4.Delete_User \n5.Save_Books \n6.Update_Books \n7.Find_Book_by_Id \n8.Delete_Book_By_Id \n9.Find_Book_by_User_Id \n10.exit");
			System.out.println("Select the option above");
			int opt = sc.nextInt();

			switch (opt) {
			case 1: {
				dao.saveUser();
				break;
			}
			case 2: {
				dao.updateUser();
				break;
			}
			case 3: {
				dao.findById();
				break;
			}
			case 4: {
				dao.deleteUser();
				break;
			}
			case 5: {
				dao.saveBooks();
				break;
			}
			case 6: {
				dao.updateBook();
				break;
			}
			case 7: {
				dao.findBooksById();
				break;
			}
			case 8: {
				dao.deleteBooksById();
				break;
			}
			case 9: {
				dao.find_Books_By_User_Id();
				break;
			}
			case 10: {
				System.exit(0);
			}

			}
		}

	}
}
