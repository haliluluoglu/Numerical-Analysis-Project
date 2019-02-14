package defaultSay;
import java.util.Scanner;
public class gaussJordanEliminasyon {
	static Scanner input = new Scanner(System.in);
	static double[][] gettingEquations(int number)
	{
		int n = number+1;
		double equationMatrix[][] = new double[number][n],element;
		
		for(int i = 1; i<=number; i++)
		{
			for(int j = 1; j<=n; j++)
			{		
				if(j > number)
				{
					System.out.printf("Enter %d. equation of equality,please." , i);
					element = input.nextDouble();
					equationMatrix[i-1][j-1] = element;
				}
				else
				{
					System.out.printf("Enter %d. unknown of %d. equation,please." ,i,j);
					element = input.nextDouble();
					while((i == j) && (element == 0))
					{
						System.out.printf("%d. unknown of %d. equation can't be zero this method.Change it,please." ,i,j);
						element = input.nextDouble();
					}
					equationMatrix[i-1][j-1] = element;
				}
			}
		}
		return equationMatrix;	
	}
	static double[][] gaussJordan(double matrix[][])
	{
		int row = matrix.length,col = matrix[1].length,p = 0;
		double divise,multiplication;
		
		for(int i = 0; i<row; i++)
		{
			divise = matrix[i][i];
			for(int j = 0; j<col; j++)
			{
				matrix[i][j] /= divise;
			}	
				for(int k = 0; k<row; k++)
				{	
					if(i != k)
					{
						multiplication = matrix[k][p];
						for(int m = 0; m<col; m++)
						{
							matrix[k][m] -= (multiplication * matrix[p][m]);
						}	
					}
				}
			p++;
		}
		return matrix;
	}
	static void print(double matrix[][],int number)
	{
		int col = matrix[1].length;
		
		for(int i = 1; i<=number; i++)
		{
			System.out.printf("%d.unknown is: %f\n" , i,matrix[i-1][col-1]);
		}
	}
	public static void main(String[] args)
	{
		int number = 0;
		double equation[][];
		
		System.out.println("Enter equation number or unknown number,please.");
		number = input.nextInt();
		equation = gettingEquations(number);
		equation = gaussJordan(equation);
		print(equation,number);
		input.close();
	}
}
