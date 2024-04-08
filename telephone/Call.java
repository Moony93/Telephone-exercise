package telephone;

public class Call {

	private int number;
	private int duration;
	private double cost;
	
	//get - set
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	//constructor
	public Call (int number, int duration, double cost)
	{
		this.number = number;
		this.duration = duration;
		this.cost = cost;
	}
	
	@Override
	public String toString ()
	{
			return  "Number: " + this.getNumber()  + ", Duration: " + this.getDuration() + ", Cost: " + this.getCost();
	}
}
