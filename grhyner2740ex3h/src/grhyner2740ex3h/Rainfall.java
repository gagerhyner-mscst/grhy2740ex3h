package grhyner2740ex3h;

public class Rainfall {
	private double [] rainfallArray;
	
	public Rainfall(double[] rainfall) {
		this.rainfallArray = new double[rainfall.length];
		
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = rainfall[i];
		}
	}
	
	public Rainfall (String[] rainfall) {
		this.rainfallArray = new double[rainfall.length];
		
		for (int i = 0; i < rainfall.length; i++){
            this.rainfallArray[i] = Double.parseDouble(rainfall[i]);
		}
	}
	
	public double getTotal() {
		double total = 0;
		for (int i = 0; i < 12; i++) {
			total += rainfallArray[i];
		}
		return total;
	}
	
	public double getAverage() {
		return getTotal() / this.rainfallArray.length;
	}
	
	public double getHighest() {
		double highest = 0;
		highest = this.rainfallArray[0];
		
		for(int i = 0; i < 12; i++){
			if(highest < rainfallArray[i]){
			highest = rainfallArray[i];
			}
		}
		return highest;	 
}
	public double getLowest() {
		 double lowest = 0;
		 lowest = this.rainfallArray[0];
		 
		 for(int i = 0; i < 12; i++) {
			 if(rainfallArray[i] < lowest){
			 lowest = rainfallArray[i];
			 }
		 }
		 return lowest;
}
}
