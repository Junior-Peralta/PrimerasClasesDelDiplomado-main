package edu.juniorperalta.diplomado.project.week10.saga.model;

public interface SagaStepHandler<T> {

    void handle(SagaPayload<T> sagaPayload);
}
