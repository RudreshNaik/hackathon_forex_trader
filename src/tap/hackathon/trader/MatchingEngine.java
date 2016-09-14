package tap.hackathon.trader;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;




/** Matching Engine class.
 * 
 * @author <name>
 */
public class MatchingEngine implements Runnable {
	

        private final BlockingQueue<Order> inQ;
        private final BlockingQueue<Trade> outQ;

        
        public MatchingEngine() {
            this.inQ    = new LinkedBlockingQueue<>();
            this.outQ   = new LinkedBlockingQueue<>();
        }
        
        
        
	/** Implemented Runnable interface method.
	*/
	@Override
	public void run(){
	
	}
        
        
        
        
        
        

	/** Getter for input queue.
         * 
         * @return 
         */
	public BlockingQueue<Order> getInputQueue(){
		return inQ;
	}
	
	/** Getter for output queue.
         * 
         * @return 
         */
	public BlockingQueue<Trade> getOutputQueue(){
		return outQ;
	}
        
        
}
