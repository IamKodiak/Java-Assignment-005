import java.util.Scanner;

public class TempConversion {
    static final Scanner input = new Scanner(System.in);

    static final Scanner doubInput = new Scanner(System.in);

    public static double convertC2F(double celsius) {
        return (celsius * (9.0/5)) + 32.0;
    }

    public static double convertC2K(double celsius) {
        return celsius + 273.15;
    }

    public static double convertF2C(double fahrenheit) {
        return 5.0 * (fahrenheit - 32) / 9.0;
    }

    public static double convertF2K(double fahrenheit) {
        return convertC2K(convertF2C(fahrenheit));
    }

    public static double convertK2C(double kelvin) {
        return kelvin - 273.15;
    }

    public static double convertK2F(double kelvin) {return convertC2F(convertK2C(kelvin));}

    public static double getTemp(String unit) {
        System.out.printf("%-40s : ", String.format("Please enter °%s temperature to convert", unit));
        return doubInput.nextDouble();
    }

    public static String getUnitChoice() {
        System.out.printf("%-4s : %40s%n", "C).", "To convert a °C temperature");
        System.out.printf("%-4s : %40s%n", "F).", "To convert a °F temperature");
        System.out.printf("%-4s : %40s%n", "K).", "To convert a °K temperature");
        System.out.printf("%-4s : %40s%n", "Q).", "To quit");
        return input.next();
    }

    public static void main(String[] args) {

        String userInput1 = "cheese";
        String userInput2 = "cheese";
        double userInput3 = 0.0;

        while(true) {
            userInput1 = getUnitChoice();
            if (userInput1.equals("Q")) {
                break;
            }

            userInput2 = getUnitChoice();
            if (userInput2.equals("Q")) {
                break;
            }

            userInput3 = getTemp(userInput1);

            switch (userInput1) {
                case "F":
                    switch (userInput2) {
                        case "C":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertF2C(userInput3)+"°"+userInput2);
                            break;
                        case "K":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertF2K(userInput3)+"°"+userInput2);
                            break;
                    }
                case "K":
                    switch (userInput2) {
                        case "F":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertK2F(userInput3)+"°"+userInput2);
                            break;
                        case "C":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertK2C(userInput3)+"°"+userInput2);
                            break;
                    }
                case "C":
                    switch (userInput2) {
                        case "K":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertC2K(userInput3)+"°"+userInput2);
                            break;
                        case "F":
                            System.out.println("Result "+userInput3+"°"+userInput1+" is "+convertC2F(userInput3)+"°"+userInput2);
                            break;
                    }
                    break;
            }
        }
    }
}