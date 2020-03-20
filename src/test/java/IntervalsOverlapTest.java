import static org.junit.jupiter.api.Assertions.*;

import java.util.Stack;

import org.junit.jupiter.api.Test;


class IntervalsOverlapTest {

	@Test
	void mergeIntervalsOverlapTest() {
		Range arr[] = new Range[3]; 
		arr[0] = new Range(94133, 94133); 
		arr[1] = new Range(94200, 94299); 
		arr[2] = new Range(94226,94399);
		
		Stack<Range> expectedIntervals = new Stack<Range>();
		Range result[] = new Range[2]; 
		result[0] = new Range(94133, 94133); 
		result[1] = new Range(94200,94399); 
		expectedIntervals.push(result[0]);
		expectedIntervals.push(result[1]);
		
		
		IntervalsOverlap processor = new IntervalsOverlap();
		Stack<Range> actualIntervals = processor.mergeIntervals(arr);
		assertEquals(expectedIntervals.size(), actualIntervals.size());
	}
	
	@Test
	void mergeIntervalsNonOverlapTest() {
		Range arr[] = new Range[3]; 
		arr[0] = new Range(94133,94133); 
		arr[1] = new Range(94200,94299); 
		arr[2] = new Range(94600,94699);
		
		Stack<Range> expectedIntervals = new Stack<Range>();
		Range result[] = new Range[3]; 
		result[0] = new Range(94133,94133); 
		result[1] = new Range(94200,94299);
		result[2] = new Range(94600,94699);
		expectedIntervals.push(result[0]);
		expectedIntervals.push(result[1]);
		expectedIntervals.push(result[2]);		
		
		IntervalsOverlap processor = new IntervalsOverlap();
		Stack<Range> actualIntervals = processor.mergeIntervals(arr);
		assertEquals(expectedIntervals.size(), actualIntervals.size());
	}
}
