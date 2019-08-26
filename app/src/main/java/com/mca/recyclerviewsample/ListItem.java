package com.mca.recyclerviewsample;

public class ListItem {

    Integer cardNumber;
    public ListItem(Integer cardNumber) {
        this.cardNumber=cardNumber;
    }


    // create a contet value pack and return it to Adapter class
    public Integer getCardNumber() {
        return cardNumber;
    }

}