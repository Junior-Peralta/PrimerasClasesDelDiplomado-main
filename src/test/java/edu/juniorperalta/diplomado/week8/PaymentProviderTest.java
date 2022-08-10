package edu.juniorperalta.diplomado.week8;

import edu.juniorperalta.diplomado.model.week8.enums.PaymentProvider;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PaymentProviderTest {

    @Test
    void mastercardShowWhoIAmTest(){
        String whoIAM = PaymentProvider.MASTERCARD.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAM);
        assertEquals("Yo soy Mastercard", whoIAM);
    }
    @Test
    void paypalShowWhoIAmTest(){
        String whoIAM = PaymentProvider.PAYPAL.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAM);
        assertEquals("Yo soy Paypal", whoIAM);
    }
    @Test
    void visaShowWhoIAmTest(){
        String whoIAM = PaymentProvider.VISA.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAM);
        assertEquals("Yo soy Visa", whoIAM);
    }
    @Test
    void stripeShowWhoIAmTest(){
        String whoIAM = PaymentProvider.STRIPE.getPaymentGateway().printWhoIAm();
        System.out.println(whoIAM);
        assertEquals("Yo soy Stripe", whoIAM);
    }
}
