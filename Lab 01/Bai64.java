import java.util.Scanner;
public class Bai64 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String monthInput;
		int year;
		while(true) {
			System.out.print("Enter a year: ");
			if(scanner.hasNextInt()) {
				year = scanner.nextInt();
				if(year >= 0) {
					scanner.nextLine();
					break;
				}
			}
			else {
				scanner.next();
			}
			System.out.println("Invalid year. Please enter again.");
		}
		while(true) {
			System.out.print("Enter a month: ");
			monthInput = scanner.nextLine().trim();
			int days = getDaysInMonth(monthInput, year);
            if (days > 0) {
                System.out.println("The number of days is: " + days);
                break;
            } else {
                System.out.println("Invalid month. Please enter again.");
            }
        }
        scanner.close();
	}
	public static int getDaysInMonth(String month, int year) {
        month = month.toLowerCase();

        switch (month) {
            case "january": case "jan": case "1": return 31;
            case "february": case "feb": case "2": return isLeapYear(year) ? 29 : 28;
            case "march": case "mar": case "3": return 31;
            case "april": case "apr": case "4": return 30;
            case "may": case "5": return 31;
            case "june": case "jun": case "6": return 30;
            case "july": case "jul": case "7": return 31;
            case "august": case "aug": case "8": return 31;
            case "september": case "sept": case "sep": case "9": return 30;
            case "october": case "oct": case "10": return 31;
            case "november": case "nov": case "11": return 30;
            case "december": case "dec": case "12": return 31;
            default: return -1;
        }
    }
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
