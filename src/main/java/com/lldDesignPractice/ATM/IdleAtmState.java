package com.lldDesignPractice.ATM;

public class IdleAtmState extends AtmStateBase {
    public IdleAtmState(AtmService atmService) {
        super(atmService);
    }

    private void showAtmError() {
        System.out.println("No ATM card found");
    }

    @Override
    public void insertCard() {
        atmService.setAtmCardConcrete(new Atm("1234455", Banks.PNB));
        super.setTransactionState(new ReadyAtmState(atmService));
    }

    @Override
    public void checkBalance() {
        showAtmError();
    }

    @Override
    public void withdrawCash(int amount) {
        showAtmError();
    }

    @Override
    public void ejectCard() {
        showAtmError();
    }
}
