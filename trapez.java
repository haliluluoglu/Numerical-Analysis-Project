package defaultSay;
import java.util.Scanner;
public class trapez {
	static Scanner input = new Scanner(System.in);
	static double[] gettingEquation(int best)
	{
		double coefficient,equationArray[] = new double[best+1];
		
		for(int i = 0; i<=best; i++)
		{
			System.out.printf("Enter %d. degree of coefficient,please." , i);
			coefficient = input.nextDouble();
			equationArray[i] = coefficient;
		}
		return equationArray;
	}
	static double f(double equation[],double x)
	{
		double result = 0,len = equation.length;
		
		for(int i = 0; i<len;i++)
		{
			result += equation[i] * Math.pow(x,i);
		}
		return result;
	}
	static double trapezFunction(double equation[],double under,double top,double n)
	{
		double sum = 0,x =under,deltaX = (top-under)/n,result;
		
		for(int i = 0; i<=n; i++)
		{
			if((i == 0) || (i == n))
			{
				sum += f(equation,x);
			}
			else
			{
				sum += (2*f(equation,x));
			}
			x += deltaX;
		}
		result = sum*(deltaX/2);
		return result;
	}
	public static void main(String[] args)
	{
		double underLimit,topLimit,equation[],n,result;
		int bestDegree;
		char answerContinue = 'y';
		
		while(answerContinue == 'y')
		{
			System.out.println("Enter under boundaries of integration,please.");
			underLimit = input.nextDouble();
			System.out.println("Enter top boundaries of integration,please.");
			topLimit = input.nextDouble();
			System.out.println("Enter range number,please.");
			n = input.nextDouble();
			System.out.println("Enter the greatest degree in the equation,please.");
			bestDegree = input.nextInt();
			equation = gettingEquation(bestDegree);
			result = trapezFunction(equation,underLimit,topLimit,n);	
			System.out.println("Result of Trapez Method is: " + result);
			System.out.println("Do you want to repeat again? Enter 'y' or 'n' , please.");
			answerContinue = input.next().charAt(0);
		}
	}
}