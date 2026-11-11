public class Sliding {

    public static void main(String[] args) {

        int[] requests = {
            120, 150, 180, 200, 250, 300,
            350, 400, 450, 500, 550, 600,
            650, 700, 750, 800, 850, 900,
            950, 1000, 900, 800, 700, 600
        };

        int windowSize = 3;
        int currentSum = 0;

        // Calculate the first 3-hour window
        for (int i = 0; i < windowSize; i++) {
            currentSum += requests[i];
        }

        int maxSum = currentSum;
        int startHour = 0;

        // Slide the window by one hour
        for (int i = windowSize; i < requests.length; i++) {

            currentSum = currentSum
                    - requests[i - windowSize]
                    + requests[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                startHour = i - windowSize + 1;
            }
        }

        System.out.println("Busiest 3-hour window:");
        System.out.println("Starts at hour: " + startHour);
        System.out.println("Total requests: " + maxSum);
    }
}