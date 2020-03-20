
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class IntervalsOverlap {

	public static void main(String[] args) {

		Range arr[] = new Range[3]; 
		arr[0] = new Range(94133, 94133); 
		arr[1] = new Range(94200, 94299); 
		arr[2] = new Range(94226,94399); 

		//merge overlapping intervals if any
		IntervalsOverlap processor = new IntervalsOverlap();
		Stack<Range> mergedIntervals = processor.mergeIntervals(arr); 
		
		//Print the intervals if there are any
		System.out.println("Merged intervals: ");
		while(!mergedIntervals.isEmpty()) {
			Range interval = mergedIntervals.pop();
			System.out.println("[" +interval.start+"," +interval.end+"]");
		}
	}
	
	public Stack<Range> mergeIntervals(Range[] arr) {
		
		//sort the start of intervals
		Arrays.sort(arr, new Comparator<Range>() {

			public int compare(Range i1, Range i2) {
				return i1.start - i2.start;//sorting start of intervals
			}
		});
		
		System.out.println("Sorted intervals:");
		for(int k=0; k<arr.length; k++) {	
			System.out.println("[" +arr[k].start + ","+arr[k].end + "]");
		}
		
		//create a stack to hold the merged intervals
		Stack<Range> mergedIntervals = new Stack<Range>();
		
		//push first item to stack, as intervals are sorted based on start
		mergedIntervals.push(arr[0]);
		
		//loop through Interval array to check overlapping of intervals
		for(int i=1; i<arr.length; i++) {
			Range top = mergedIntervals.peek();
			Range next = arr[i];
			if(top.end < next.start) {//the interval is correct, no need to update i.e. they are not overlapping
				mergedIntervals.push(arr[i]);
			}else if(top.end < arr[i].end) {//update the end of first interval with the end of next interval
				top.end = arr[i].end;
				mergedIntervals.pop();
				mergedIntervals.push(top);				
			}			
		}
		return mergedIntervals;
	}
}
