package view;

import java.util.List;

import model_class.Account;

import org.apache.commons.lang3.StringUtils;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class AccountView extends View {
	private TextIO textIO = TextIoFactory.getTextIO();
	TextTerminal<?> terminal = textIO.getTextTerminal();

	public void PrintMenuHeader() {
		terminal.println("Account Menu\n");
	}

	public void PrintMenuOptions() {
		terminal.println("1. Create Account");
		terminal.println("2. View all Accounts");
		terminal.println("3. Change Email of Account");
		terminal.println("4. Change Password of Account");
		terminal.println("5. Delete Account");
		terminal.println("9. Back");
		terminal.println("0. Logout & Exit");
	}

	public String RequestInputUsername() {
		String username = textIO.newStringInputReader().read(
				"Enter the email for this account");
		return username;
	}

	public String RequestInputSurname() {
		String lastname = textIO.newStringInputReader()
				.withDefaultValue("Graaf").read("Enter surname");
		return lastname;
	}

	public void PrintPersons(String personToString) {
		terminal.println(personToString);
	}

	public int ChoosePerson(int i) {
		int option = textIO.newIntInputReader().withMinVal(0).withMaxVal(i - 1)
				.read("Choose the person you want to select");
		return option;
	}

	public void NoPersonFound() {
		terminal.println("No person with that lastname found\nPlease create a person first");

	}

	public void NoAccountFound() {
		terminal.println("This person doesn't have an account yet");

	}

	public void PersonAlreadyHasAccount() {
		terminal.println("This person already has an account");
	}

	public void OnlyAdminHasPermission() {
		terminal.println("Only an admin has permission for this action");

	}

	public boolean confirmDeleteAccount() {
		Character option = textIO
				.newCharInputReader()
				.withInlinePossibleValues('y', 'n')
				.read("Are you sure you wish to delete your account? \nThis action will exit the application");
		if (option == 'y')
			return true;
		else
			return false;
	}

	public void accountCreated() {
		terminal.println("The account has been created");
	}

	public void PasswordChanged() {
		terminal.println("The password has been changed");

	}

	public void emailChanged() {
		terminal.println("The email has been changed");

	}

	public void accountDeleted() {
		terminal.println("The account has been deleted");

	}

	public int requestAccountType() {
		int option = textIO
				.newIntInputReader()
				.withInlinePossibleValues(1, 2, 3)
				.read("Which level of permissions do you want to give this account?\n1.Customer\n2.Worker\n3.Admin\n");
		return option;
	}

	public void printAccountList(List<Account> accountList) {
		ClearTerminal();
		terminal.println(StringUtils.center("Overview of all Accounts", 62));
		terminal.println("-----------------------------------------------------------------------------");
		terminal.print(StringUtils.center("Account ID", 11)
				+ StringUtils.center("Email", 40)
				+ StringUtils.center("AccountType", 11));
		terminal.println();
		terminal.println("-----------------------------------------------------------------------------");

		for (Account account : accountList) {

			terminal.print(StringUtils.center(Integer.toString(account.getId()), 11)
					+ StringUtils.center(account.getEmail(), 40)
					+ StringUtils.center(Integer.toString(account.getAccountTypeId()), 11));
			terminal.println();
		}
		terminal.println("-----------------------------------------------------------------------------");

	}
}
