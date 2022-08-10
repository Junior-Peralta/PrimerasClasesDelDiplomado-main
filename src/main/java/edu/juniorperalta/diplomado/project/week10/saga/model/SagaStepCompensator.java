package edu.juniorperalta.diplomado.project.week10.saga.model;

public interface SagaStepCompensator<T> {

    void handle(SagaPayload<T> sagaPayload);
}
