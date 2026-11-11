public class Twopointer {

    public static void main(String[] args) {

        int[] orders = {100, 150, 200, 250, 300, 350, 400};
        int target = 500;

        int left = 0;
        int right = orders.length - 1;

        System.out.println("Pairs with sum " + target + ":");

        while (left < right) {

            int sum = orders[left] + orders[right];

            if (sum == target) {
                System.out.println(
                        orders[left] + " + " + orders[right]);

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
