package com.example.zerohungerlogin;

public class money_spent {
    String amount;
    String reason;

    @Override
    public String toString() {
        return "money_spent{" +
                "amount='" + amount + '\'' +
                ", reason='" + reason + '\'' +
                '}';
    }

    public money_spent() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
