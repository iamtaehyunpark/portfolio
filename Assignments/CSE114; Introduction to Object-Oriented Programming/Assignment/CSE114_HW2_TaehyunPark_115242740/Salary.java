// Taehyun Park taehyun.park.1@stonybrook.edu
import java.util.Scanner;
public class Salary {

    public static double tax(double pay) {
        double taxes = pay*0.145;
                return taxes;
    }

    public static void main (String args[]) {

        Scanner scanType = new Scanner(System.in);
        System.out.print("Select employee type: (c) coporate (h) hourly (s) sales: ");
                char type = scanType.next().charAt(0);

                double grossPay;

                if (type == 'c') {
            Scanner scanSalary = new Scanner(System.in);
            System.out.print("Enter weekly salary: ");
                    grossPay = scanSalary.nextDouble();
        } else if (type == 'h') {
            Scanner scanWage = new Scanner(System.in);
            System.out.print("Enter hourly wage: ");
            double wage = scanWage.nextDouble();
            System.out.print("Enter hours worked: ");
            double hour = scanWage.nextDouble();
            if (hour < 40) {
                grossPay = 0;
            } else {
                double overtime = hour - 40;
                grossPay = 40*wage + overtime*wage*2;
            }

                } else if (type == 's') {
            Scanner scanSales = new Scanner(System.in);
            System.out.print("Enter weekly sales: ");
            double sales = scanSales.nextDouble();
            grossPay = 500 + sales*0.06;
        } else {
                    grossPay = 0;
                }

        double taxes = tax(grossPay);

        System.out.printf("Gross pay: $%.2f", grossPay);
        System.out.printf("\nTaxes: $%.2f", taxes);
        System.out.printf("\nnetpay: $%.2f", grossPay - taxes);
    }

}