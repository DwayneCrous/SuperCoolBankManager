/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package supercoolbankmanager;

/**
 *
 * @author dwayn
 */
public class ValidateCardManager {
    public ValidateCardManager () {
        
    }
    
    public boolean validateCard(String cardNumber) {
        //sum of digits at even and odd positions
        int result = sumEvenDigits(cardNumber) + sumOddDigits(cardNumber);
        
        //if the total sum is divisible by 10 then the card number is valid
        if (result % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    //if the number is less than 10 return that number.
    //if it is a 2 digit number then return the sum of its digits
    int getDigit(int number) {
        return (number < 10) ? number : (number / 10) + (number % 10);
    }
    
    //this method adds together the digits in the odd positions of the card number
    int sumOddDigits(String cardNumber) {
        int sum = 0;
        
         //loop through the number starting from the last digit and then skipping every other digit
        for (int i = cardNumber.length() - 1; i >= 0; i-=2) {
            //convert the character to its number value and add it to the sum
            sum += getDigit(cardNumber.charAt(i) - '0');
        }
        
        return sum;
    }
    
    //this method doubles the digits in the even positions of the card number
    //then adds the individual digits of the result using getDigit
    int sumEvenDigits(String cardNumber) {
        int sum = 0;
        
        //this time starting at the second last digit and skipping every other digit
        for (int i = cardNumber.length() - 2; i >= 0; i-=2) {
             //double the digit and add the sum of its digits to the total
            sum += getDigit((cardNumber.charAt(i) - '0') * 2);
        }
        
        return sum;
    }
}
