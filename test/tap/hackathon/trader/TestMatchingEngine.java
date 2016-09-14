/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tap.hackathon.trader;

import java.util.concurrent.BlockingQueue;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author
 */
public class TestMatchingEngine {

    private MatchingEngine m;
    private BlockingQueue<Order> inQ;
    private BlockingQueue<Trade> outQ;
    
    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        m = new MatchingEngine();
        inQ = m.getInputQueue();
        outQ = m.getOutputQueue();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void test_simple_opposites_fill() throws InterruptedException {
        Order ask = new Order(OrderSide.ASK, 1.35, 100, CurrencyPair.GBP_USD);
        Order bid = new Order(OrderSide.BID, 1.35, 100, CurrencyPair.GBP_USD);
        inQ.put(bid);
        inQ.put(ask);
        Trade result = outQ.take();
        assertNotNull(result);
        // assertEquals(1.35, <price of trade represented by result>)
        // assertEquals(100, <quantity of trade represented by result>)
        // Show size of remaining order ASK book (& BID) is zero
    }

    @Test
    public void test_simple_opposites_partial_fill() throws InterruptedException {
        Order ask = new Order(OrderSide.ASK, 1.35, 200, CurrencyPair.GBP_USD);
        Order bid = new Order(OrderSide.BID, 1.35, 100, CurrencyPair.GBP_USD);
        inQ.put(bid);
        inQ.put(ask);
        Trade result = outQ.take();
        assertNotNull(result);
        // assertEquals(1.35, <price of trade represented by result>)
        // assertEquals(100, <quantity of trade represented by result>)
        // Show size of remaining order ASK book is 100 & BID is zero
    }

    @Test
    public void test_simple_book_with_spread_cross() throws InterruptedException {
        Order ask = new Order(OrderSide.ASK, 1.36, 200, CurrencyPair.GBP_USD);
        Order bid = new Order(OrderSide.BID, 1.34, 100, CurrencyPair.GBP_USD);
        inQ.put(bid);
        inQ.put(ask);
        
        Order crossBid = new Order(OrderSide.BID, 1.38, 100, CurrencyPair.GBP_USD);
        inQ.put(crossBid);
        
        Trade result = outQ.take();
        assertNotNull(result);
        // assertEquals(1.36, <price of trade represented by result>)
        // assertEquals(100, <quantity of trade represented by result>)
        // Show size of remaining order ASK book is 100 & BID is 100
    }
    
}
