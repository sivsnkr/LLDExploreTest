package com.lldDesignPractice.ATM;

public abstract class AtmStateBase implements IAtm {
    protected final AtmService atmService;

    public AtmStateBase(AtmService atmService) {
        this.atmService = atmService;
    }

    void setTransactionState(AtmStateBase state) {
        atmService.setTransactionState(state);
    }
}
