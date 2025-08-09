public class SeatManager {

    // PriorityQueue to store available seat numbers in ascending order
    private PriorityQueue<Integer> availableSeats;

    // Constructor initializes the PriorityQueue with all seat numbers
    public SeatManager(int n) {
        availableSeats = new PriorityQueue<>();
        // Add all seats to the queue, seat numbers start from 1 to n
        for (int seatNumber = 1; seatNumber <= n; seatNumber++) {
            availableSeats.offer(seatNumber);
        }
    }

    // reserve() method to reserve the seat with the lowest number
    public int reserve() {
        // Polling gets and removes the smallest available seat number
        return availableSeats.poll();
    }

    // unreserve() method to put a seat number back into the queue
    public void unreserve(int seatNumber) {
        // Offering adds the seat number back to the available seats
        availableSeats.offer(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */