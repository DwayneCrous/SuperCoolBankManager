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
        int result = sumEvenDigits(cardNumber) + sumOddDigits(cardNumber);
        
        if (result % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
    
    int getDigit(int number) {
        return (number < 10) ? number : (number / 10) + (number % 10);
    }
    
    int sumOddDigits(String cardNumber) {
        int sum = 0;
        
        for (int i = cardNumber.length() - 1; i >= 0; i-=2) {
            sum += getDigit(cardNumber.charAt(i) - '0');
        }
        
        return sum;
    }
    
    int sumEvenDigits(String cardNumber) {
        int sum = 0;
        
        for (int i = cardNumber.length() - 2; i >= 0; i-=2) {
            sum += getDigit((cardNumber.charAt(i) - '0') * 2);
        }
        
        return sum;
    }
}
