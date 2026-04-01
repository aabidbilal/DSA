class MyCalendar {

    ArrayList<int[]> bookings;

    // ArrayList<int[]> overlapBookings;
    public MyCalendar() {
        bookings = new ArrayList<int[]>();
        // overlapBookings = new ArrayList<int[]>();
    }

    public boolean book(int startTime, int endTime) {
        if (bookings.size() == 0) {
            bookings.add(new int[] {
                    startTime, endTime - 1
            });
            return true;
        }
        for (int i = 0; i < bookings.size(); i = i + 1) {
            if (overLaps(bookings.get(i), startTime, endTime - 1)) {
                return false;
            }

        }
        bookings.add(new int[] {
                startTime, endTime - 1

        });
        return true;
    }

    public boolean overLaps(int[] a1, int s2, int e2) {
        int s1 = a1[0],
                e1 = a1[1];
        return e1 >= s2 && e2 >= s1;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */