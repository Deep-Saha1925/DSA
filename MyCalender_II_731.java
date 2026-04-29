import java.util.List;
import java.util.ArrayList;

class MyCalendarTwo {

    List<int[]> bookings;
    List<int[]> overlaps;

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlaps = new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
        // Step 1: Check overlapping bookings
        for(int[] o : overlaps){
            if(startTime < o[1] && endTime > o[0]){
                return false;
            }
        }

        // Step 2: Add overlaps
        for(int[] b : bookings){
            if(startTime < b[1] && endTime > b[0]){
                overlaps.add(new int[]{
                    Math.max(b[0], startTime),
                    Math.min(b[1], endTime)
                });
            }
        }

        // Step 3: Add booking
        bookings.add(new int[]{startTime, endTime});
        return true;
    }
}