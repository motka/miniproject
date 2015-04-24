

import java.util.Scanner;


public class BMICalculator { 
	    public static final String METERS = "M";
	    public static final String CENTIMETERS = "CM";
	    public static final String KILOGRAMS = "KG";
	    public static final String FEET = "FT";
	    public static final String INCHES = "IN";
	    public static final String POUNDS = "LBS";
	    
	    
	    public static final double CM_TO_INCHES=0.393700787d;
	    public static final double KG_TO_LBS = 2.20462262d;
	    
	    static String bmi_message_under_weitht = "A BMI below 18.5 is considered underweight";
	    static String bmi_message_healthy = "A BMI of 18.5 to 24.9 is considered healthy";
	    static String bmi_message_over_weight = "A BMI of 25 to 29.9 is considered overweight";
	    static String bmi_message_obese = "A BMI of 30 or higher is considered obese"; 

	public static void main(String[] args) {
		 //(int feet, int inches, int cm, double wgtlbs, double wgtkg) {
		 Scanner in = new Scanner(System.in); 
	     System.out.printf("Enter Height (Feet):  ");
	     int heightFt = in.nextInt();  
	   
	     System.out.printf("Enter Height (Inch):  ");
	     int heightIn = in.nextInt(); 
	     System.out.printf("Enter Weight:  "); 
	     int weight = in.nextInt(); 
	     
	     BMICalculator calculator = new BMICalculator();
	     double bmi = calculator.prepareBMI(heightFt,heightIn,0,weight,0);
	     System.out.println("Your BMI :"+bmi);
	     printBMI(bmi);
		

	}
	
	public static void printBMI(double bmi) {
		double underWeight = 18.5;
		double healthyWeight = 24.9;
		double overWeight = 29.9;
		
		if(bmi<underWeight)
			System.out.println(bmi_message_under_weitht);
		else if(bmi>=underWeight && bmi<healthyWeight)
			System.out.println(bmi_message_healthy);
		else if(bmi>=healthyWeight && bmi<overWeight)
			System.out.println(bmi_message_over_weight);
		else
			System.out.println(bmi_message_obese);
			
		
	}
	
	double prepareBMI(int feet, int inches, int cm, double wgtlbs, double wgtkg) {
        double bmival = 0.0;
        
        if (feet > 0  && inches > 0 && cm == 0) { 
            if (wgtlbs > 0 && wgtkg == 0)
            {
                int height = feet * 12;
                height += inches;
                bmival = computeBMI(height, INCHES, wgtlbs, POUNDS);
                 
            }
            else if (wgtkg>0 && wgtlbs == 0)
            {
                int height = feet * 12;
                height += inches;
                bmival = computeBMI(height, INCHES, wgtkg, KILOGRAMS); 
            }
            else if (wgtlbs == 0 && wgtkg == 0)
            {
                return bmival = 0;
                
            }
        }
        else if (feet == 0 &&   inches == 0 &&   cm > 0) { 
            if (wgtlbs == 0 && wgtkg > 0) { 
                bmival = computeBMI(cm, CENTIMETERS, wgtkg, KILOGRAMS);
                
            }
            if (wgtkg == 0 && wgtlbs > 0) { 
                bmival = computeBMI(cm, CENTIMETERS, wgtlbs, POUNDS);
                
            }
             
        } 
        return bmival; 
    }

     static double computeBMI( int height, String heightUnits, double weight, String weightUnits) {
        double results=0d;
        double heightinches = 0d;
        double weightlbs = 0d;

        // 1 cm = 0.393700787 inches.
        if (heightUnits.equalsIgnoreCase(CENTIMETERS))
            heightinches = height * CM_TO_INCHES;
        else
            heightinches = height;

        // 1 kg = 2.20462262 lbs.
        if (weightUnits.equalsIgnoreCase(KILOGRAMS))
            weightlbs = weight * KG_TO_LBS;
        else
            weightlbs = weight;
        results = (weightlbs*703)/(Math.pow(heightinches, 2));
        return results;
    }
}