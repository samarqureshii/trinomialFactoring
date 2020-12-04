
/*
 * Name: Samar Qureshi
 * Date: December 4th, 2020
 * Decription of program:
 */

package test;

import java.util.Scanner;

import java.lang.Math;
import java.text.NumberFormat;

public class ICS3U_FullCode_SamarQureshi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		NumberFormat decimal = NumberFormat.getNumberInstance();
		
		boolean keepGoing = true;
		
		System.out.println("Howdy there! I'm an AI robot developed to help you cheat on your toughest math homework! "
				+ "\nMy specialty, you ask? "
				+ "\nI'm an expert at solving and factoring quadratics."
				+ "\n\nLet's get started by having you enter your trinomial in the form ax^2+bx+c."
				+ "\n'x' can be replaced with any lowercase letter, just make sure you stay consistent!");
		
		while(keepGoing) { 
		String trinomial = input.nextLine();
		
		int index = 0, digit = 1;
		boolean neg = false;
		 //starts pulling a, b, c from the trinomial entered
		
		//check sign of a
		if(trinomial.charAt(0)==45) { //45 is ASCII for '-'
			index = 1;
			neg = true;
		}
		
		//to pull a
		int a = 0;
		while(trinomial.charAt(index)>=48 && trinomial.charAt(index)<=57) {
			digit = trinomial.charAt(index) - 48; //removing the digit to give ASCII decimal
			a*=10;
			a+= digit;
			index +=1;
		}
		// if a is negative
		if(neg) {
			a *= -1;
		}
		
		//determines what letter variable is used at the first index
		char letter = (trinomial.charAt(index));
		
		if(trinomial.charAt(index+2)!=50) { //checks if the polynomial is quadratic, and not cubic, quartic, etc
			System.out.println("Oops! This trinomial is not quadratic. "
					+ "No worries though, we will fix that for you. ");
		}
		
		//so the number index will skip over x^2 and prepare if b is negative	
		index+=3;
		neg = trinomial.charAt(index) == 45; //45 is ascii for '-'
		index+=1;
		
		//to pull 'b'
		int b = 0;
		while(trinomial.charAt(index) >= 48 && trinomial.charAt(index) <= 57) { 
			digit = trinomial.charAt(index)-48;
			b*=10;
			b+=digit;
			index +=1;
		}
		 //if b is negative
		if(neg) {
			b*=-1;
		}
		
		if(trinomial.charAt(index)!=(int)letter) {
			do{ System.out.println("I'm not sure if the variables you used match. "
					+ "\nPlease enter the lower case letter you would like to use as a variable:");
			letter = input.next().charAt(0);
			}while((int)letter<=97 || (int)letter>=122);
		}
		
		
		//number index "skips" over 'x' and prepare if c is negative
		index +=1;
		neg = trinomial.charAt(index) == 45;
		index+=1;
		
		//to pull 'c'
		int c = 0;
		while(index < trinomial.length()) {
			digit = trinomial.charAt(index)-48; //ascii conversion
			c*=10;
			c+=digit;
			index +=1;
		}
		//if c is negative
		if(neg) {
			c *= -1;
		}
			
		
		System.out.println("a:"+a);
		System.out.println("b:"+b);
		System.out.println("c:"+c);
		
		//trinomial in the form ax^2+bx+c
		
	
			 //takes care of both simple and complex trinomials
				int n,m,f,g; //where (n*f)+(m*g) must be equal to 'b', n & m are factors of a and f & g are factors of c
				for(int i = 1; i<=Math.abs(a); i++) { //finds factors of a
					for(int ii = -Math.abs(c); ii<=Math.abs(c); ii++) { //finds factors of c
						if(ii!=0) { //to avoid the Arithmetic error due to the range of ii !=0
							if (a%i==0 && c%ii==0) { //checks if both are factors
							n=i; 
							f=ii;	
							m = a/n;
							g = c/f; //the 'for loop' variables are transferred to variables in the factored format
								if((n*f)+(m*g)==b) { //if trinomial is factorable
									//following lines will 'slow build' the factored form based on certain conditions such as the sign of f and g
									if(n==m && f==g) { //double root case
										System.out.print("The factored form of your trinomial is: (");
										if(n!=1) {
											System.out.print(n);
										}	
										if(g>0) {
											System.out.print(letter+"+");
										}
										System.out.print(g+")^2");
										//final product is factored form in (nx+g)^2								
									}
									
									
									else {
										System.out.print("The factored form of your trinomial is: (");
										if(n!=1) {
											System.out.print(n);
										}	
										if(g>0) {
											System.out.print(letter+"+");
										}
										System.out.print(g+")(");
										
										if(m!=1) {
											System.out.print(m);
										}
										
										if (f>0) {
											System.out.print(letter+"+");
										}
										System.out.println(f+")");
										//final product is factored form in (nx+g)(mx+f)
									}
				
							}

						
						}
	
							
						}
					}
				
				}
			
		
				//gives the root solutions as well, if trinomial is not factorable, will also print roots
				
				double x1 = (-b+(Math.sqrt(Math.pow(b, 2)-4*a*c)))/(2*a);
				double x2 = (-b-(Math.sqrt(Math.pow(b, 2)-4*a*c)))/(2*a);
				
				if((Math.pow(b, 2)-4*a*c)<0) {
					System.out.println("\nOh no! The solutions to this are imaginary numbers. "
							+ "\nI don't think I can do this...");
				}
				else if(x1==x2 || (Math.pow(b, 2)-4*a*c)==0) {
					System.out.println("\nAssuming that your trinomial is equal to 0, there seems to only be 1 solution to this. "
							+ "\nAccording to my calculations, if we were to graph this,"
							+ "there would be a 'double root' at "+decimal.format(x1)+".");
					}
				else {
					System.out.println("\nAssuming that your trinomial is equal to 0, there appears to be 2 solutions to this. "
							+ "\nIf I'm correct, there are roots at "+decimal.format(x1)+" and at "+decimal.format(x2)+
							", if we were to graph this.");
				}
				
				System.out.println("\nWould you like to enter another trinomial? If so, type yes."
						+ "\nIf you are done, please type no.");
				String yesOrNo = input.nextLine();
				
				
				if(yesOrNo.equalsIgnoreCase("yes")) {
					System.out.println("I would be more than happy to factor another trinomial for you! "
							+ "\nPlease enter the next trinomial:");
				}
				else if (yesOrNo.equalsIgnoreCase("no")){
					keepGoing = false;
				}
				
				else {
					do {
						System.out.println("That is not a valid answer! Please enter yes or no.");
						yesOrNo = input.next();
					}while(!yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no"));
					
					if(yesOrNo.equalsIgnoreCase("no")) {
						keepGoing = false;
					}
				
				}
				
			
			}
		
		System.out.println("Well, it's been fun, partner. "
				+ "\nI hope I was able to solve all your questions!"
				+ "\nIf you ever need to solve some trinomials again, come back to me anytime!"
				+ "\n\nNot that I would ever condone cheating or anything like that...");
			

		
		
		//if trinomial is factorable
		/*
		 * if(n==1 && m>1) { //coefficient of x is only 1 for n
			System.out.println("The factored form of your trinomial is: "
					+ "(x+"+f+")("+m+"x+"+g+")");
		}
		else if(n>1 && m==1) { //coefficient of x is 1 only for m
			System.out.println("The factored form of your trinomial is: "
					+ "("+n+"x+"+f+")(x+"+g+")");
		}
		else if(n==1 && m==1) { //coefficient of x if 1 for both 
			System.out.println("The factored form of your trinomial is: "
					+ "(x+"+f+")(x+"+g+")");
		}
		else if(n==m && f==g) { //double root case
			System.out.println("The factored form of your trinomial is: "
					+ "("+n+"x+"+f+")^2");
		}
		else { // n and m are more than 1
			System.out.println("The factored form of your trinomial is: "
					+ "("+n+"x+"+f+")("+m+"x+"+g+")");
		}
		 */
		
		
		
		/*
		 * System.out.println("(x-"+x1+")");
			System.out.println("(x-"+x2+")");
		 */
			
		//display output of factored trinomial in the form (nx-f)(mx-g)
			/*
			 * trinomial.charAt(0)>58 &&

trinomial.charAt(0)<49 && //checks to make sure a is a number between 1 and 9

trinomial.charAt(5)>58 &&

trinomial.charAt(5)<49 && //checks to make sure b is a number between 1 and 9

trinomial.charAt(8)>58 &&

trinomial.charAt(8)<49 && //checks to make sure c is a number between 1 and 9

trinomial.charAt(2)!=94 &&

trinomial.charAt(1)<97 &&

trinomial.charAt(6)>122 &&

trinomial.charAt(1)!=trinomial.charAt(6) &&

trinomial.charAt(6)!=trinomial.charAt(9)&&

trinomial.charAt(1)!=trinomial.charAt(9) //checks to make sure all the same letter variables are used
			 int a = (trinomial.charAt(0)-48);

System.out.println(a);

int b = (trinomial.charAt(5)-48);

System.out.println(b);

int c = (trinomial.charAt(8)-48);

System.out.println(c);
			 */
		
	}
}
