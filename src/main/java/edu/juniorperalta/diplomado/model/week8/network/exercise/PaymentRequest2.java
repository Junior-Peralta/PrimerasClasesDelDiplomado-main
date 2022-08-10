package edu.juniorperalta.diplomado.model.week8.network.exercise;

import edu.juniorperalta.diplomado.model.week8.enums.PaymentProvider;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest2 {
    //USAR ENUMS
    private PaymentProvider provider; // Stripe or Paypal
    private BigDecimal amount;
}
