/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.numberaddition;
import java.io.Serializable;

public class RecIntegral implements Serializable {
    // Константы для валидации диапазона
    private static final double MIN_VALUE = 0.000001;
    private static final double MAX_VALUE = 1000000;
    
    private double upper;   
    private double lower;   
    private double step;    
    private double result;

    // Конструктор 1
    public RecIntegral(double upper, double lower, double step) 
            throws InvalidException {
        validateParameter(upper, "Верхний предел");
        validateParameter(lower, "Нижний предел");
        validateParameter(step, "Шаг");
        
        this.upper = upper;
        this.lower = lower;
        this.step = step;
        this.result = 0.0;
    }
 
    // Конструктор 2
    public RecIntegral(double upper, double lower, double step, double result) 
            throws InvalidException {
        validateParameter(upper, "Верхний предел");
        validateParameter(lower, "Нижний предел");
        validateParameter(step, "Шаг");
        
        this.upper = upper;
        this.lower = lower;
        this.step = step;
        this.result = result;
    }
    
    /**
     * Метод валидации параметра
     * @param value проверяемое значение
     * @param paramName название параметра для сообщения об ошибке
     * @throws InvalidRecIntegralParametersException если значение вне диапазона
     */
    private void validateParameter(double value, String paramName) 
            throws InvalidException {
        if (value < MIN_VALUE || value > MAX_VALUE) {
            throw new InvalidException(
                String.format("%s = %.10f вне допустимого диапазона [%.6f; %.0f]", 
                    paramName, value, MIN_VALUE, MAX_VALUE)
            );
        }
    }
    
    // Метод вычисления интеграла (без изменений, но можно добавить свои исключения)
    double Calcint(double upper, double lower, double step){
        double integral = 0;
        boolean hasDiscontinuity = false;
        
        for (double x = lower; x < upper; x += step) {
            double x_next = Math.min(x + step, upper);
            
            // Проверка на разрывы функции tan(x)
            double cos1 = Math.cos(x);
            double cos2 = Math.cos(x_next);
            
            if (Math.abs(cos1) < 1e-10 || Math.abs(cos2) < 1e-10) {
                hasDiscontinuity = true;
                break;
            }
            
            // Метод трапеций
            double y1 = Math.tan(x);
            double y2 = Math.tan(x_next);
            double area = (y1 + y2) * (x_next - x) / 2;
            
            integral += area;
        }
        return integral;
    }
    
    // Геттеры и сеттеры (без изменений)
    double getUpper(){ return this.upper;}
    double getLower(){ return this.lower;}
    double getStep(){ return this.step;}
    double getResult(){ return this.result;}
    void setResult(double result){ this.result = result; }
}
