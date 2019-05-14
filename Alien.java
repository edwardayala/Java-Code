// Edward Ayala - P6 BigDecimal | Alien
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Alien {
    public static void main(String [] args){
        BigDecimal step = BigDecimal.ONE;
        BigDecimal sum = BigDecimal.ZERO;
        MathContext mc = new MathContext(60, RoundingMode.DOWN);
        for (int i = 0; i < 150; i++) {
            sum = sum.add(step,mc);
            step = (step).divide(new BigDecimal(2),mc);
            System.out.println("Step " + (i+1) + ": " + sum);
        }System.out.println("The Alien Giant cannot travel more than 2 miles...");
    }
}