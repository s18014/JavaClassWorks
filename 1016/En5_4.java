import java.math.*;

public class En5_4 {
    public static void main(String[] args) {
        BigDecimal one = BigDecimal.valueOf(1);
        BigDecimal nine = BigDecimal.valueOf(9);
        BigDecimal divided = one.divide(nine, 4, RoundingMode.HALF_UP);
        System.out.println(divided.multiply(nine));
    }
}
