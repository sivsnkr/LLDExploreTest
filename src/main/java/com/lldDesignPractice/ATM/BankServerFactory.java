package com.lldDesignPractice.ATM;

import java.util.HashMap;
import java.util.Map;

public class BankServerFactory {
    Map<Banks, BankServer> serverMap;

    public BankServerFactory() {
        this.serverMap = new HashMap<>();
        this.serverMap.put(Banks.PNB, new BankServer());
    }

    public BankServer getBankServer(Banks banks) {
        if(!serverMap.containsKey(banks)) throw new IllegalArgumentException("Bank not found");
        return serverMap.get(banks);
    }

}
