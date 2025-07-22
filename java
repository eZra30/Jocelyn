import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimeAdder {

    public static void main(String[] args) {
        addTime();
    }

    public static void addTime() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");

        LocalTime localTime = LocalTime.now();
        System.out.println("Current Local Time: " + localTime.format(timeFormatter));

        while (true) {
            try {
                // Get numeric input
                System.out.print("Enter value to add (numeric only): ");
                String valueInput = scanner.nextLine().trim();

                // Validate numeric input
                if (!valueInput.matches("[0-9.]+")) {
                    System.out.println("Invalid input! Please enter numeric characters only.");
                    continue;
                }

                double value = Double.parseDouble(valueInput);

                // Get unit input
                System.out.print("Enter unit (Hours or Minutes): ");
                String unit = scanner.nextLine().trim();

                LocalTime updatedTime;

                switch (unit) {
                    case "Hours":
                        int hours = (int) value;
                        int minutesFromHours = (int) Math.round((value - hours) * 60);
                        updatedTime = localTime.plusHours(hours).plusMinutes(minutesFromHours);
                        break;
                    case "Minutes":
                        int totalMinutes = (int) Math.round(value);
                        updatedTime = localTime.plusMinutes(totalMinutes);
                        break;
                    default:
                        System.out.println("Unit not recognized, please key in either Hours or Minutes");
                        continue;
                }

                System.out.println("Updated Time: " + updatedTime.format(timeFormatter));
                break;

            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
