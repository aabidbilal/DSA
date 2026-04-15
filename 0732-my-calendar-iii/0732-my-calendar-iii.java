import java.util.*;

class MyCalendarThree {

    Map<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {

   
        map.put(startTime, map.getOrDefault(startTime, 0) + 1);
        map.put(endTime, map.getOrDefault(endTime, 0) - 1);

        int currBooking = 0;
        int maxBooking = 0;

       
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            currBooking += entry.getValue();
            maxBooking = Math.max(maxBooking, currBooking);
        }

        return maxBooking;
    }
}