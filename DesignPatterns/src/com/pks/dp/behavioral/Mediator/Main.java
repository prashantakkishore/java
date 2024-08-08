package com.pks.dp.behavioral.Mediator;

public class Main {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new Auction();
        Colleague colleague1 = new Bidder("A", auctionMediator);
        Colleague colleague2 = new Bidder("B", auctionMediator);
        Colleague colleague3 = new Bidder("C", auctionMediator);
        auctionMediator.placeBid(colleague1, 12);
    }
}
