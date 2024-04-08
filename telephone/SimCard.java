package telephone;

public class SimCard {

	private int number;
	private int credit;
	
	//last 10 received calls
	private Call[] receivedCalls = new Call[10];
	
	//last 10 made calls
	private Call[] madeCalls = new Call[10];
	
	//get - set
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	//constructor
	public SimCard (int number, int credit)
	{
		this.number = number;
		this.credit = credit;
	}

	
	//adds an outgoing call to the list
	public void addMadeCall (Call madeCall)
	{
		for (int i = madeCalls.length - 1; i > 0; i--) 
		{
			madeCalls[i] = madeCalls[i-1];
		}
		
		madeCalls[0] = madeCall;
	}
	
	
	//adds a received call to the list
	public void addReceivedCall (Call receivedCall)
	{
		for (int i = receivedCalls.length - 1; i > 0; i--) 
		{
			receivedCalls[i] = receivedCalls[i-1];
		}
		
		receivedCalls[0] = receivedCall;
	}

	
	//prints all the made calls in the array
	public void printMadeCalls ()
	{
		for (int i = 0; i < madeCalls.length; i++) 
		{
			try 
			{
				System.out.println("Made Call #" + (i + 1) + " " + madeCalls[i].toString());
			} 
			catch (NullPointerException e) 
			{
				System.out.println("No other call registered");
				return;
			}
		}
	}
	
	public void printReceivedCalls ()
	{
		for (int i = 0; i < receivedCalls.length; i++) 
		{
			try 
			{
				System.out.println("Received Call #" + (i + 1) + " " + receivedCalls[i].toString());
			} 
			catch (NullPointerException e) 
			{
				System.out.println("No other call registered");
				return;
			}
		}
	}
	
	
	//costo totale ultime ultime chiamate
	public double totalCost()
	{
		double totalCost = 0;
		
		for (int i = 0; i < madeCalls.length; i++) 
		{
			try 
			{
				totalCost = totalCost + madeCalls[i].getCost();
			} 
			catch (NullPointerException e) 
			{
				break;
			}
		}
				
		
		for (int i = 0; i < receivedCalls.length; i++) 
		{
			try 
			{
				totalCost = totalCost + receivedCalls[i].getCost();
			} 
			catch (NullPointerException e) 
			{
				break;
			}
		}
		return totalCost;
	}
	
	//durata totale ultime chiamate
	public int totalDuration()
	{
		int totalDuration = 0;
		
		for (int i = 0; i < madeCalls.length; i++) 
		{
			try 
			{
				totalDuration = totalDuration + madeCalls[i].getDuration();
			} 
			catch (NullPointerException e) 
			{
				break;
			}
		}
		
		for (int i = 0; i < receivedCalls.length; i++) 
		{
			try 
			{
				totalDuration = totalDuration + receivedCalls[i].getDuration();
			} 
			catch (NullPointerException e) 
			{
				break;
			}
		}	
		return totalDuration;
	}
	
	
	public static void main(String[] args) {
		
		SimCard R = new SimCard (10, 100);
		
		Call one = new Call(12, 10 , 10.2);
		Call two = new Call(11, 9 , 9.2);
		Call three = new Call(8, 8 , 8.2);
		Call four = new Call(7, 8 , 6.8);
		Call five = new Call(6, 18 , 5.4);

		R.addMadeCall(one);
		R.addMadeCall(two);
		
		R.addReceivedCall(three);
		R.addReceivedCall(four);
		R.addReceivedCall(five);
		
		R.printMadeCalls();
		R.printReceivedCalls();
		
		System.out.println("Total cost: " + R.totalCost() + "€");
		System.out.println("Total duration: " + R.totalDuration() + " seconds");

	}
}
