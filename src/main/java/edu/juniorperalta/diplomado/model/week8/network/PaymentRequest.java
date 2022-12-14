package edu.juniorperalta.diplomado.model.week8.network;

import lombok.*;

import java.math.BigDecimal;

/**
 * @author aluis on 4/24/2022.
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PaymentRequest {

    private String provider; // Stripe or Paypal
    private BigDecimal amount;
}
