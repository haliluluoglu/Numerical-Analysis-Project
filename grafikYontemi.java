package defaultSay;
import java.util.*;
public class grafikYontemi {
	static Scanner input = new Scanner(System.in);
	static double[] gettingArray(double bestDegree,double firstValue,double deltaX,double epsilon)
	{
		double equationArray[] = new double[((int) bestDegree)+1];
		
		for(int i = 0; i < equationArray.length; i++)
		{
			System.out.printf("Enter %d. degree of coefficient,please." , i);
			double coefficient = input.nextDouble();
			equationArray[i] = coefficient;
		}
		input.close();
		equationFunction(equationArray,firstValue,deltaX,epsilon);
		return equationArray;
	}
	static void equationFunction(double[] equationArray,double firstValue,double deltaX,double epsilon)
	{
		double fx = -1,oldValue = 0;
		
		while(Math.abs(firstValue - oldValue) >= epsilon)
		{
			while (fx <= 0)
			{
				fx = 0;
				for(int i = 0; i < equationArray.length;i++)
				{
					fx += equationArray[i] * Math.pow(firstValue,i);
				}
				oldValue = firstValue;
				firstValue += deltaX;
				System.out.println("This is number of steps: " + firstValue);
			}
			firstValue = oldValue;
			firstValue -= deltaX;
			deltaX /= 2.0;
			fx = 0;
		}
	}
	public static void main (String[] args)
	{
		System.out.println("Enter first value,please.");
		double firstValue = input.nextDouble();
		System.out.println("Enter deltaX value,please.");
		double deltaX = input.nextDouble();
		System.out.println("Enter epsilon value,please.");
		double epsilon = input.nextDouble();
		System.out.println("Enter the greatest degree in the equation,please.");
		int bestDegree = input.nextInt();
		gettingArray(bestDegree,firstValue,deltaX,epsilon);		
	}
}