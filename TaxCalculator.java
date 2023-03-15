import java.util.Scanner;

import javax.lang.model.util.ElementScanner14;

public class TaxCalculator {


	  public static double calculateTax(int status, int income){
		  double taxAmount = 0.0;

		  switch (status) {
		  case 0:
			  if (income > 10_275)
				  taxAmount += 1_027.5;
			  else
				  return income * 0.1;

			  if (income > 41_775)
				  taxAmount += (41_775-10_275) * 0.12;
			  else
				  return taxAmount + (income - 10_275) * 0.12;

			  if (income > 89_075)
				  taxAmount += (89_075-41_775) * 0.22;
			  else
				  return taxAmount + (income - 41_775) * 0.22;

			  if (income > 170_050)
				  taxAmount += (170_050 - 89_075) * 0.24;
			  else
				  return taxAmount + (income - 89_075) * 0.24;

			  if (income > 215_950)
				  taxAmount += (215_950 - 170_050) * 0.32;
			  else
				  return taxAmount + (income - 170_050) * 0.32;

			  if (income > 539_900)
				 return taxAmount + ((539_900 - 215_950) * 0.35) + ((income - 539_900) * 0.37);
			  else
				  return taxAmount + (income - 215_950) * 0.35;

		case 1:
			if (income > 20_550)
				taxAmount += 22_050 * 0.1;
			else
				return income * 0.1;

			if (income > 83_550)
				taxAmount += (83_550-22_050) * 0.12;
			else
				return taxAmount + (income - 22_050) * 0.12;

			if (income > 178_150)
				taxAmount += (178_150-83_550) * 0.22;
			else
				return taxAmount + (income - 83_550) * 0.22;

			if (income > 340_100)
				taxAmount += (340_100-178_150) * 0.24;
			else
				return taxAmount + (income - 178_150) * 0.24;

			if (income > 431_900)
				taxAmount += (431_900 - 340_100) * 0.32;
			else
				return taxAmount + (income - 340_100) * 0.32;

			if (income > 647_850)
				return taxAmount + ((647_850 - 431_900) * 0.35) + ((income - 647_850) * 0.37);
			else
				return taxAmount + (income - 431_900) * 0.35;

		case 2:
			if (income > 10_275)
				taxAmount += 1_027.5;
			else
				return income * 0.1;

			if (income > 41_775)
				taxAmount += (41_775-10_275) * 0.12;
			else
				return taxAmount + (income - 10_275) * 0.12;

			if (income > 89_075)
				taxAmount += (89_075-41_775) * 0.22;
			else
				return taxAmount + (income - 41_775) * 0.22;

			if (income > 170_050)
				taxAmount += (170_050 - 89_075) * 0.24;
			else
				return taxAmount + (income - 89_075) * 0.24;

			if (income > 215_950)
				taxAmount += (215_950 - 170_050) * 0.32;
			else
				return taxAmount + (income - 170_050) * 0.32;

			if (income > 323_925)
				return taxAmount + ((323_925 - 215_950) * 0.35) + ((income - 323_925) * 0.37);
			else
				return taxAmount + (income - 215_950) * 0.35;
		
		case 3:
			if (income > 14_650)
				taxAmount += 1_465.0;
			else
				return income * 0.1;

			if (income > 55_900)
				taxAmount += (55_900-14_650) * 0.12;
			else
				return taxAmount + (income - 14_650) * 0.12;

			if (income > 89_050)
				taxAmount += (89_050-55_900) * 0.22;
			else
				return taxAmount + (income - 55_900) * 0.22;

			if (income > 170_050)
				taxAmount += (170_050 - 89_050) * 0.24;
			else
				return taxAmount + (income - 89_050) * 0.24;

			if (income > 215_950)
				taxAmount += (215_950 - 170_050) * 0.32;
			else
				return taxAmount + (income - 170_050) * 0.32;

			if (income > 539_900)
				return taxAmount + ((539_900 - 215_950) * 0.35) + ((income - 539_900) * 0.37);
			else
				return taxAmount + (income - 215_950) * 0.35;
		 }
     return -1;
	  }

	  public static int getIntegerValue(String input){
		 int value;
	    try {
		  value = Integer.parseInt(input);
	    }catch (NumberFormatException e){
	    	value = -1;
	    }
	    return value;
	  }

	  public static void main(String[] args){
	    Scanner input = new Scanner(System.in);
	    int status, income;

	    do{
	      System.out.println("Enter the filing status:");
		  System.out.println("0. Single");
		  System.out.println("1. Married, filing jointly");
		  System.out.println("2. Married, filing separately");
		  System.out.println("3. Head of household");
	      status = getIntegerValue(input.nextLine());
	    } while (status<0 || status>3);

	    do{
	      System.out.print("Enter the income for 2022 : ");
	      income = getIntegerValue(input.nextLine());
	    } while (income<0);

	    double incomeTax = calculateTax(status, income);
	    System.out.printf("Your tax for year 2022 is %.2f for an income of %d using %d status.",
	                      incomeTax, income, status);
	  }

}
