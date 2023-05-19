/*
 * Tegan Jetton
 * CIS 244 IK
 * 05/10/23
 * This program simulates a Queue using an ArrayList.
 * The dequeue, enqueue, peek, isEmpty, and size methods
 * are all written for quick demonstration purposes. The
 * program prompts the user for customer names and asks
 * for the next customer in the queue to step up to the 
 * window for processing. It then prints the number of 
 * customers served, how many are left in the queue, and
 * who the next person to be served will be.
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ArrayListQueue 
{
	// declare an array list and global counter
	static ArrayList<String> list = new ArrayList<String>();
	static int servedCount = 0;
	
	public static void main(String args[])
	{
		// declare a Scanner object for input
		Scanner sc = new Scanner(System.in);
		
		// fun little loop for choosing when to dequeue
		for(int i=0; i<6; i++) {
			if(i==3) {
				dequeue();
			}
			if(i==4) {
				dequeue();
				dequeue();
				dequeue();
			}
			System.out.print("Enter the next customer to be added to the queue:\n");
			// add next name typed to end of queue
			enqueue(sc.next());
		}
		// always close your Scanner :)
		sc.close();
		
		// print out # of customers served, # left in queue, who wil be served next
		System.out.println("Number of customers served so far: " + servedCount);
		System.out.println("The queue is populated with "+list.size() + " customers");
		System.out.println("The next customer to be served will be: " + peek());
		
	}

	//define the dequeue() method
	public static void dequeue()
	{
		// declare an object to manipulate the list
		Object obj = new Object();

		if (list.size() > 0)
		{
			obj = list.remove(0);
			System.out.println("Customer "+ obj + " please step up to the window for processing");
			custCount();
		}
		else
			System.out.println("empty list");
	}

	// define the enqueue() method
	public static void enqueue(String obj) {
		list.add(list.size(), obj);
	}
	// define the peek() method
	public static String peek() {
		return list.get(0);
	}

	// define the isEmpty() method
	public static boolean isEmpty() {
		return(list.size() < 1);
	}

	// define the size() method
	public Integer size() {
		// declare an Iterator object to cycle through the list elements
		Iterator<String> itr = list.iterator();
		int i = 0;
		// use a looping structure to determine size
		while(itr.hasNext())
		{
			i++;
		}
		return i;
	}
	
	// define the custCounot() method
	public static void custCount() {
		servedCount++;
	}
}