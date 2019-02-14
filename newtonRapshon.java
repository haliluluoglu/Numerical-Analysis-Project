package defaultSay;
import java.util.*;
public class newtonRapshon {
	static Scanner input = new Scanner(System.in);
	static double[] gettingArray(double bestDegree,double firstValue,double epsilon)
	{
		double equationArray[] = new double[((int) bestDegree)+1];
		
		for(int i = 0; i < equationArray.length; i++)
		{
			System.out.printf("Enter %d. degree of coefficient,please." , i);
			double coefficient = input.nextDouble();
			equationArray[i] = coefficient;
		}
		input.close();
		equationFunction(equationArray,firstValue,epsilon);
		return equationArray;
	}
	static void equationFunction(double[] equationArray,double firstValue,double epsilon)
	{
		double fx = 0,newValue = 10000,temp;
		
		while(Math.abs(newValue-firstValue) >= epsilon)
		{	
			for(int i = 0; i<equationArray.length;i++)
			{
				fx += equationArray[i] * Math.pow(firstValue,i);
			}
			newValue = firstValue-(fx/derivativeFunction(equationArray,firstValue,newValue));
			fx = 0;
			temp = firstValue;
			firstValue = newValue;
			newValue = temp;
			System.out.println("This is number of steps: " + firstValue);
		}
	}
	static double derivativeFunction(double[] equationArray,double firstValue,double newValue)
	{
		double derivative = 0;
		
		for(int i = 1; i < equationArray.length; i++)
		{
			derivative += equationArray[i] * i * Math.pow(firstValue,i-1);
		}
		return derivative;
	}
	public static void main (String[] args)
	{
		System.out.println("Enter first value,please.");
		double firstValue = input.nextDouble();
		System.out.println("Enter epsilon value,please.");
		double epsilon = input.nextDouble();
		System.out.println("Enter the greatest degree in the equation,please.");
		int bestDegree = input.nextInt();
		gettingArray(bestDegree,firstValue,epsilon);		
	}
}