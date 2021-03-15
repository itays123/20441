import java.util.Scanner;

/*
 * The program gets a number input and an option input from the user,
 * and performs calculations on the number depending on the picked option.
 */
class Number {

    public static void main(String[] args) {
        final int OPTION_REVERSE_SIGN = 1;
        final int OPTION_REVERSE_NUMBER = 2;
        final int OPTION_REVERSE_BOTH = 3;

        /*
         * holds the value entered by the user, and modified depending on the option
         * picked.
         */
        int number;

        // holds the integer code of the option picked.
        int option;

        Scanner scan = new Scanner(System.in);

        // get the number as an integer from the program user
        System.out.print("Plase enter a 4 digit number: ");
        number = scan.nextInt();

        /*
         * for a number to be valid, it has to have 4 digits and be either positive or
         * negative
         */
        boolean numberIsValid = Math.abs(number) >= 1000 && Math.abs(number) <= 9999;
        if (numberIsValid) {

            // get the option from the user
            System.out.println("1. Reverse sign." + "\n" + "2. Reverse number." + "\n" + "3. Reverse sign and number."
                    + "\n" + "Please choose an option:");
            option = scan.nextInt();

            // for an option to be valid, it has to be either 1, 2 or 3.
            boolean optionIsValid = option == OPTION_REVERSE_SIGN || option == OPTION_REVERSE_NUMBER
                    || option == OPTION_REVERSE_BOTH;
            if (optionIsValid) {

                // reverse result sign if needed
                if (option == OPTION_REVERSE_SIGN || option == OPTION_REVERSE_BOTH)
                    number *= -1;

                // reverse number if needed
                if (option == OPTION_REVERSE_NUMBER || option == OPTION_REVERSE_BOTH) {
                    // get the digits of the number
                    int digitOf1000s = number / 1000;
                    int digitOf100s = (number / 100) % 10;
                    int digitOf10s = (number / 10) % 10;
                    int digitOf1s = number % 10;

                    /*
                     * reverse the number with this algorithm:
                     * 
                     * 1. the 1s digit is multiplied by 1000 and becomes the 1000s digit. The 1000s
                     * digit becomes the 1s digit.
                     * 
                     * 2. the 10s digit is multiplied by 100 and becomed the 100s digit. The 100s
                     * digit becomes the 10s digit by multipliying it by 10.
                     *
                     */
                    number = 1000 * digitOf1s + 100 * digitOf10s + 10 * digitOf100s + digitOf1000s;

                }
                System.out.println("The result is");
                System.out.println(number);

            } else { // option not valid
                System.out.println("Illegal option – you must choose 1, 2 or 3");
            }

        } else { // number is not valid
            System.out.println("Illegal number – you must enter a 4 digit number");
        }
    }

}