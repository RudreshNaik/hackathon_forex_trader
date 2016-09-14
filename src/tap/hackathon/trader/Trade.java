package tap.hackathon.trader;

import java.time.LocalDateTime;



/** Trade class.
 * 
 * @author 
 */
public class Trade{
    private final Order askOrder;
    private final Order bidOrder;
    private final int orderQty;
    private final double price;
    private final LocalDateTime strikeTime;
    
    public Trade(Order ask, Order bid, int tradeQty, double tradePrice){
        askOrder = ask;
        bidOrder = bid;
        orderQty = tradeQty;
        price    = tradePrice;
        strikeTime = LocalDateTime.now();
    }
    
}
