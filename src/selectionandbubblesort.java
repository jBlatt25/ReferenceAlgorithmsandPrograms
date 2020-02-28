
public class selectionandbubblesort {
	 public void sort(int arr[]) 
	    { 
	        int n = arr.length; 
	  
	        // One by one move boundary of unsorted subarray 
	        for (int i = 0; i < n-1; i++)  { 
	            // Find the minimum element in unsorted array 
	            int min_idx = i; 
	            for (int j = i+1; j < n; j++) { 
	                if (arr[j] < arr[min_idx]) { 
	                    min_idx = j; 
	            }
	        }
	            // Swap the found minimum element with the first 
	            // element 
	            int temp = arr[min_idx]; 
	            arr[min_idx] = arr[i]; 
	            arr[i] = temp; 
	        } 
	    } 
	 public void bubbleSort(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i = 0; i < n-1; i++) 
	            for (int j = 0; j < n-i-1; j++) 
	                if (arr[j] > arr[j+1]) 
	                { 
	                    // swap arr[j+1] and arr[i] 
	                    int temp = arr[j]; 
	                    arr[j] = arr[j+1]; 
	                    arr[j+1] = temp; 
	                } 
	    }
	    // Prints the array 
	    public void printArray(int arr[]) 
	    { 
	        int n = arr.length; 
	        for (int i=0; i<n; ++i) 
	            System.out.print(arr[i]+" "); 
	        System.out.println(); 
	    } 
	  
	    // Driver code to test above 
	    public static void main(String args[]) 
	    { 
	    	//test for the selection sort
	        selectionandbubblesort ob = new selectionandbubblesort(); 
	        int arr[] = {64,25,12,22,11}; 
	        ob.sort(arr); 
	        System.out.println("Sorted array using selection sort"); 
	        ob.printArray(arr);
	        
	        //test for the bubble sort
	        ob.bubbleSort(arr); 
	        System.out.println("Sorted array using bubble sort"); 
	        ob.printArray(arr); 
	    } 
}
