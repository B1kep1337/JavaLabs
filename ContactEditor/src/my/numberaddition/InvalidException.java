/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package my.numberaddition;


//Исключение
public class InvalidException extends Exception {
    
    public InvalidException(String message) {
        super(message);
    }
    
    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }
}



