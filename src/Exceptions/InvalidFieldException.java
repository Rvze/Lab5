package Exceptions;

/**
 * Класс исключения, которая создается при неккоректном вводе поля элемента
 */
public class InvalidFieldException extends Exception {
    /**
     * Конструктор
     *
     * @param message
     */
    public InvalidFieldException(String message){
         super(message);
     }

}
