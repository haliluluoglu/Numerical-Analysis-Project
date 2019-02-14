package defaultSay;
import java.util.Scanner;
public class inversOfMatrix {
	static Scanner input = new Scanner(System.in);
	static double[][] gettingMatrix(int number)
	{
		double matrix[][],element,newElement;
		int i,j,row,column;
		char answerChange = 'n';
		
		matrix = new double[number][number];
		for(i=0; i<number; i++)
		{
			for(j=0; j<number; j++)
			{
				System.out.printf("Enter %d.row and %d.column of matrix,please." , i , j);
				element = input.nextDouble();
				while((i == j) && (element == 0))
				{
					System.out.printf("%d.row %d.column can't be zero this method.Change it,please." ,i,j);
					element = input.nextDouble();
				}
				matrix[i][j] = element;
			}
		}
		System.out.println("Do you want to change any elements of matrix? Enter 'y' or 'n' , please.");
		answerChange = input.next().charAt(0);
		while(answerChange == 'y')
		{
			System.out.println("Enter row to change it,please");
			row = input.nextInt();
			System.out.println("Enter column to change it,please");
			column = input.nextInt();
			System.out.println("Enter new element,please.");
			newElement = input.nextDouble();
			matrix[row][column] = newElement;
			System.out.println("Do you want to change any elements of matrix? Enter 'y' or 'n' , please.");
			answerChange = input.next().charAt(0);
		}
		return matrix;
	}
	static void printMatrix(double matrix[][])
	{
		int number = matrix.length,j;
		
		for(int i=0; i<number; i++)
		{
			for(j=0; j<number; j++)
			{
				System.out.printf("%10f " , matrix[i][j]);
			}
			System.out.println();
		}
	}
	static char askContinue(char answerContinue)
	{
		System.out.println("Do you want to change matrix to continue? Enter 'y' or 'n' , please.");
		answerContinue = input.next().charAt(0);
		return answerContinue;
	}
	static double determinant(double matrix[][])
	{
		int number = matrix.length,number0 = matrix[0].length;
		double temporary[][];
		double result = 0;
		
		if(number == 1)
		{
			result = matrix[0][0];
			return result;
		}
		else if(number == 2)
		{
			result = (matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]);
			return result;
		}
		else if(number >= 3)
		{
			for(int i = 0; i<number0; i++)
			{
				temporary = new double[number-1][number-1];
				for(int j = 1; j<number; j++)
				{
					for(int k = 0; k<number0; k++)
					{
						if(k<i)
						{
							temporary[j-1][k] = matrix[j][k];
						}
						else if(k>i)
						{
							temporary[j-1][k-1] = matrix[j][k];
						}
					}
				}
				result += matrix[0][i] * Math.pow(-1,i) * determinant(temporary);
			}
			return result;
		}
		else
		{
			return 0;
		}
	}
	static double[][] inverse(double matrix[][])
	{
		int length = matrix.length,t = (2*length),k = 0,m = length,p = 0;
		double tempMatrix[][] = new double[length][t];
		double matrixInverse[][] = new double[length][length];
		double divise,multiplication;
	
		for(int i = 0; i<length; i++)
		{
			for(int y = 0; y<length; y++)
			{
				tempMatrix[i][y] = matrix[i][y];
				for(int j = length; j<t; j++)
				{
					tempMatrix[i][j] = 0;
				}
			}
		}
		while((k<length) && (m<t))
		{
				tempMatrix[k][m] = 1;
				k++;
				m++;
		}
		for(int x = 0; x<length; x++)
		{
			divise = tempMatrix[x][x];
			for(int c = 0; c<t; c++)
			{
				tempMatrix[x][c] /= divise;
			}	
				for(int v = 0; v<length; v++)
				{	
					if(x != v)
					{
						multiplication = tempMatrix[v][p];
						for(int b = 0; b<t; b++)
						{
							tempMatrix[v][b] -= (multiplication * tempMatrix[p][b]);
						}	
					}	
				}
			p++;
		}
		for(int i = 0; i<length; i++)
		{
			for(int f = 0; f<length; f++)
			{
				matrixInverse[i][f] =tempMatrix[i][f+length];
			}				
		}
		return matrixInverse;
	}
	public static void main(String[] args)
	{
		double matrix[][],result,matrixInverse[][];
		int numberMatrix;
		char answerContinue = 'y';

		while(answerContinue == 'y')
		{
			System.out.println("Enter rows and columns of matrix,please.");
			numberMatrix = input.nextInt();
			matrix = gettingMatrix(numberMatrix);
			result = determinant(matrix);
			if(result != 0)
			{
				matrixInverse = inverse(matrix);
				System.out.println("Here is the inverse of matrix.");
				printMatrix(matrixInverse);
				askContinue(answerContinue);
			}
			else
			{
				System.out.println("Determinant: " + result);
				System.out.println("There is no inverse to this matrix.Enter another matrix,please.");
				askContinue(answerContinue);
			}
		}	
		input.close();
	}
}