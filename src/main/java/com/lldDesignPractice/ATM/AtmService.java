package com.lldDesignPractice.ATM;

public class AtmService implements IAtm {
    private IAtm atmState;
    private final Dispenser dispenser;
    private final BankServerFactory bankServerFactory;
    private Atm atmCard;

    public AtmService() {
        this.dispenser = new Dispenser();
        this.atmState = new IdleAtmState(this);
        this.bankServerFactory = new BankServerFactory();
    }

    @Override
    public void insertCard() {
        atmState.insertCard();
    }

    @Override
    public void checkBalance() {
        atmState.checkBalance();
    }

    @Override
    public void withdrawCash(int amount) {
        atmState.withdrawCash(amount);
    }

    @Override
    public void ejectCard() {
        atmState.ejectCard();
    }

    void setAtmCardConcrete(Atm card) {
        this.atmCard = card;
    }

    void setTransactionState(IAtm atmState) {
        this.atmState = atmState;
    }

    void withdrawCashConcrete(int amount) {
        BankServer bankServer = bankServerFactory.getBankServer(atmCard.getBank());
        bankServer.transact(atmCard, amount);
    }

    void checkBalanceConcrete() {
        BankServer bankServer = bankServerFactory.getBankServer(atmCard.getBank());
        bankServer.checkBalance(atmCard);
    }

    void dispenseCashConcrete(int amount) {
        dispenser.dispenseMoney(amount);
    }
}
