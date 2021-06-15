package application;

import java.security.SignatureException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entites.Department;
import entites.HourContract;
import entites.Worker;
import entites.enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter department's name: ");
		String departmantName =sc.nextLine();
		System.out.println("ENTER WORKER DATA >> ");
		System.out.print("Name: ");
		String workerName = sc.nextLine();
		System.out.print("Level: ");
		String workerLevel = sc.nextLine();
		System.out.print("Base salary: ");
		double baseSalary = sc.nextDouble();
		//instanciei novo objeto do tipo worker
		// uma instancia de workerLevel
		// instaciei Departament
		Worker worker = new Worker(workerName, WorkerLevel.valueOf(workerLevel), baseSalary, new Department(departmantName));
		
				System.out.print("how many contracts to this worker? ");
				int n = sc.nextInt();
				
				for (int i=1; i<=n; i++) {
					System.out.println("ENTER CONTRACT # " + i + " DATA>> ");
					System.out.print("Date (DD/MM/YYYY): ");
					Date contractDate = sdf.parse(sc.next());
					System.out.print("Value per hour: ");
					double valuePerHour = sc.nextDouble();
					System.out.print("Duration (hours): ");
					int hours =sc.nextInt();
					HourContract contract = new HourContract(contractDate, valuePerHour, hours);
					worker.addContract(contract);
					
				}
				
				System.out.println();
				System.out.println("Enter month and year to calculate income (MM/YYYY): ");
				String monthandYear = sc.next();
				int month = Integer.parseInt( monthandYear.substring(0,2));
				int year = Integer.parseInt(monthandYear.substring(3));
				System.out.println("Name: " + worker.getName());
				System.out.println("Department : " + worker.getDepartment().getName());
				System.out.println("Income for " + monthandYear + ": " + String.format("%.2f", worker.income(year, month)));
				
				
		
		
		
		sc.close();
	}

}
