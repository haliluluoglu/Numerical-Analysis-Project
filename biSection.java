package defaultSay;
import java.util.*;
public class biSection {
	static Scanner input = new Scanner(System.in);
	static double[] gettingArray(double bestDegree,double lowerLimit,double upperLimit,double epsilon)
	{
		double equationArray[] = new double[((int) bestDegree)+1];
		
		for(int i = 0; i < equationArray.length; i++)
		{
			System.out.printf("Enter %d. degree of coefficient,please." , i);
			double coefficient = input.nextDouble();
			equationArray[i] = coefficient;
		}
		input.close();
		equationFunction(equationArray,lowerLimit,upperLimit,epsilon);
		return equationArray;
	}
	static void equationFunction(double[] equationArray,double lowerLimit,double upperLimit,double epsilon)
	{
		while(Math.abs(lowerLimit-upperLimit) >= epsilon)
		{	
			double xOrt = (lowerLimit + upperLimit) / 2;
			if(function(equationArray,lowerLimit)*function(equationArray,xOrt) < 0)
			{
				upperLimit = xOrt;
			}
			else
			{
				lowerLimit = xOrt;
			}
			System.out.println("This is number of steps: " + xOrt);
		}		
	}
	static double function(double[] equationArray,double xValue)
	{
		double fx = 0;
		
		for(int i = 0; i<equationArray.length; i++)
		{
			fx = equationArray[i] * Math.pow(xValue,i);
		}
		return fx;
	}
	public static void main(String[] args) 
	{
		System.out.println("Enter lower limit of range,please.");
		double lowerLimit = input.nextDouble();
		System.out.println("Enter upper limit of range,please.");
		double upperLimit = input.nextDouble();
		System.out.println("Enter epsilon value,please.");
		double epsilon = input.nextDouble();
		System.out.println("Enter the greatest degree in the equation,please.");
		int bestDegree = input.nextInt();		
		gettingArray(bestDegree,lowerLimit,upperLimit,epsilon);		
	}
}