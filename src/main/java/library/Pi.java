package library;

import java.util.Random;

/**
 * This program uses the unit circle to estimate the value of Pi. 
 * 
 * The area of the unit circle is equal to Pi. The process considers points
 * in the region |x| <=  1, |y| <= 1. The approximate ratio of points in the 
 * circle to total points in the square is PI/4. 
 * 
 * Resource: https://en.wikipedia.org/wiki/Approximations_of_%CF%80
 * 
 */

public class Pi {
	
	private static final double pi = compute();
	private static final double rangeMin = -1.0;
	private static final double rangeMax = 1.0;
	private static final int iter = 2000000;

	private static int pointsTotal;
	private static int pointsInCircle;

	public static void print(){
		System.out.println(pi);
	}
	
	public static double compute(){	

		Random random = new Random();
		double xValue;
		double yValue;
		
		for(int i=0; i < iter; i++){
			// generate (x,y) pair
			xValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
			yValue = rangeMin + (rangeMax - rangeMin) * random.nextDouble();

			double distanceFromOrigin = (Math.sqrt((xValue * xValue) + (yValue * yValue)));
			
			// ask if the point is in the circle
			if(distanceFromOrigin <= 1.0){
				pointsTotal++;
				pointsInCircle++;
			}else{
				pointsTotal++;
			}
		}

		// compute pi
		return (double) pointsInCircle  / (double) pointsTotal * 4.0;
		
	}
	
	
}
