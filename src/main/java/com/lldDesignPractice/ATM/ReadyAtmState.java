package com.lldDesignPractice.ATM;

public class ReadyAtmState extends AtmStateBase {

    public ReadyAtmState(AtmService atmService) {
        super(atmService);
    }

    @Override
    public void insertCard() {
        System.out.println("Card is already inserted");
    }

    @Override
    public void withdrawCash(int amount) {
        super.setTransactionState(new ProcessingAtmState(atmService));
        atmService.withdrawCashConcrete(amount);
        atmService.dispenseCashConcrete(amount);
        super.setTransactionState(new ReadyAtmState(atmService));
    }

    @Override
    public void checkBalance() {
        super.setTransactionState(new ProcessingAtmState(atmService));
        atmService.checkBalanceConcrete();
        super.setTransactionState(new ReadyAtmState(atmService));
    }

    @Override
    public void ejectCard() {
        atmService.setAtmCardConcrete(null);
        super.setTransactionState(new IdleAtmState(atmService));
    }
}
