package edu.juniorperalta.diplomado.week8;

import edu.juniorperalta.diplomado.model.week8.network.exercise.*;
import edu.juniorperalta.diplomado.model.week8.payment.PaymentGateway;

import java.util.UUID;

/**
 * Hacer que el sistema de pago no se valide con un String, sino con un ENUM y el ENUM entregue el objeto de pago
 * <p>
 * Abstraer el sistema de pago en clases aisladas con sus propios procesos.
 *
 * @author aluis on 5/8/2022.
 */
public class Exercise1Week8 {

    // TODO tomar el sistema simple de pago y hacer que funcione con un modelo de objetos
    // Es decir, que los procesos de pago se llamen independientemente en sus objetos y no haciendo el proceso por un SWITCH

    public PaymentResponse2 pay(PaymentRequest2 paymentRequest) {
        PaymentGateway provider = paymentRequest.getProvider().getPaymentGateway();
        String id = UUID.randomUUID().toString();
        return PaymentResponse2.builder()
                .id(id)
                .status(provider.pay(id, paymentRequest.getAmount()))
                .build();
    }

    public CancelPaymentResponse2 cancel(CancelPaymentRequest2 cancelPaymentRequest) {
        PaymentGateway provider = cancelPaymentRequest.getProvider().getPaymentGateway();
        return CancelPaymentResponse2.builder()
                .status(provider.cancel(cancelPaymentRequest.getId()))
                .build();
    }

    public RefundPaymentResponse2 refund(RefundPaymentRequest2 refundPaymentRequest) {
        PaymentGateway provider = refundPaymentRequest.getProvider().getPaymentGateway();
        return RefundPaymentResponse2.builder()
                .status(provider.refund(refundPaymentRequest.getId(), refundPaymentRequest.getAmount()))
                .build();
    }
}
