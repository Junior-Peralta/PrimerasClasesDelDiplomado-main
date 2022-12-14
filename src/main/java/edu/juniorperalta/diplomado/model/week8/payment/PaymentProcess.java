package edu.juniorperalta.diplomado.model.week8.payment;

import java.math.BigDecimal;

/**
 * Ejemplo de interfaz de responsabilidad única
 *
 * @author aluis on 4/24/2022.
 */
public interface PaymentProcess {

    String pay(String id, BigDecimal amount);
}
