//P 4.16 book 12.3 14.1
package ss.week4;

import java.util.*;

public class MergeSort 
{
    public static <Elem extends Comparable<Elem>> void mergesort(List<Elem> list) 
    {
    	if (list.size()<=1) //if there is only a single element in a sub array
		{
			return; //return this sub array
		}
		
		int midpoint=list.size()/2;//length of left array can be calculated directly
		List<Elem> left = new ArrayList<Elem>(midpoint);//create a left array. its length is known: midpoint
		//question: what does "generic type" mean?
		//why this is not correct? List left = new ArrayList ();
		List<Elem> right = new ArrayList<Elem>();//create a right array. its length is unknown
		
		if (list.size()%2==0)//if list has in total even number of elements
		{
			right = new ArrayList<Elem>(midpoint);//then we know how many elements are in the right array
		}
		else //if list has in total odd number of elements
		{
			right = new ArrayList<Elem>(midpoint+1);//then we know how many elements are in the right array
		}
		
		//-----------------------------------------------------------------------
		List<Elem> mergedList = new ArrayList<Elem>(list.size()); // create an array to store merged list
		for(int i=0;i<midpoint;i++)//for (Elem object : list)
		{
			//if (object.indexOf(object)<midpoint && object.indexOf(object)>=0)
			left.add(list.get(i));//copy elements from list to the left list
		}
		
		for (int j=midpoint;j<list.size();j++)
		{
				right.add(list.get(j));//copy elements from list to the right list
		}
		
		mergesort(left);//want to do recursion, but mergesort is void. how to solve? 
		mergesort(right);//recursion
		//List<Elem>result=new ArrayList<Elem>
		List<Elem>result=merge (left,right); //can not call a non-static method in a static method
		return;
    }
    
	public static <Elem extends Comparable<Elem>> List<Elem> merge(List<Elem>left, List<Elem>right)
	{
		int lengthResult=left.size()+right.size();
		List<Elem> result=new ArrayList<Elem>(lengthResult);
		int indexL=0; //index of left list
		int indexR=0; //index of right list
		//int indexRes=0; //index of result list
		
		while (indexL<left.size()||indexR<right.size())
			// if there are elements left in the left array. or in the right array. means merging is not finished.
		{
			if (indexL<left.size() && indexR<right.size())
			{
				if ((int)(left.get(indexL))<=(int)(right.get(indexR)))
					//if the element in the left array<= the element in the right array
				{
					result.add(left.get(indexL));//put this element in the left list into the result list
					indexL++;
					//indexRes++;
				}
				else 
				{
					result.add(right.get(indexR));//result[indexRes]=right[indexR];
					indexR++;
					//indexRes++;
				}
			}
			else if (indexL<left.size())// if left array has elements left, but right array is empty
			{
				result.add(left.get(indexL));//result[indexRes]=left[indexL];
				indexL++;
				//indexRes++;
			}
			else if (indexR<left.size())// if right array has elements left, but left array is empty
			{
				result.add(right.get(indexR));//result[indexRes]=right[indexL];
				indexR++;
				//indexRes++;
			}
		}
		return result;
	}
	/**
	 * step 1: divide an array into half, half, half
	 * step 2: merge sub arrays to a complete ordered array
	 * */
/*	public int []mergesort(int []B)
	*//** List<Integer> sequence = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        MergeSort.mergesort(sequence);
	 * *//*
	{
		if (B.length<=1) //if there is only a single element in a sub array
		{
			return B; //return this sub array
		}
		
		int midpoint=B.length/2;//length of left array can be calculated directly
		int []left=new int [midpoint];//create a left array. its length is known
		int []right;//create a right array. its length is unknown
		
		if (B.length%2==0)//if array B has in total even number of elements
		{
			right=new int [midpoint];//then we know how many elements are in the right array
		}
		else //if array B has in total odd number of elements
		{
			right=new int[midpoint+1];//then we know how many elements are in the right array
		}
		
		int []result=new int [B.length];// create an array to store merged array
		for (int i=0;i<midpoint;i++)
		{
			left[i]=B[i];//copy elements from array B to the left array
		}
		
		int x=0;//x: index in the newly created right array
		for (int j=midpoint;j<B.length;j++)
		{
			if (x<right.length)
			{
				right[x]=B[j];//copy elements from array B to the right array
				x++;
			}
		}
		
		left=mergesort(left);//recursion
		right=mergesort(right);//recursion
		result=merge (left,right);
		return result;
	}*/
	
	public int [] merge(int[]left, int[]right)
	{
		int lengthResult=left.length+right.length;
		int[] result=new int [lengthResult];
		int indexL=0;
		int indexR=0;
		int indexRes=0;
		
		while (indexL<left.length||indexR<right.length)
			// if there are elements left in the left array. or in the right array. means merging is not finished.
		{
			if (indexL<left.length && indexR<right.length)
			{
				if (left[indexL]<=right[indexR])
					//if the element in the left array<= the element in the right array
				{
					result[indexRes]=left[indexL];//put this element in the left array into the result array
					indexL++;
					indexRes++;
				}
				else 
				{
					result[indexRes]=right[indexR];
					indexR++;
					indexRes++;
				}
			}
			else if (indexL<left.length)// if left array has elements left, but right array is empty
			{
				result[indexRes]=left[indexL];
				indexL++;
				indexRes++;
			}
			else if (indexR<left.length)// if right array has elements left, but left array is empty
			{
				result[indexRes]=right[indexL];
				indexR++;
				indexRes++;
			}
		}
		return result;
	}

}
