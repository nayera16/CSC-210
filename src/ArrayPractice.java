
public class ArrayPractice {
	public static int maxConsecSum(int[] nums, int k) {
		int sum = 0;
		for (int i = 0; i < k; i++ ) {
			sum += nums[i];
		}
		
		int maxSum = sum;
		
		for (int i = k; i < nums.length; i++) {
			sum += nums[i] - nums[i-k];
			
			if  (maxSum < sum) maxSum = sum;
		}
		
		return maxSum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [] numbers = {5, 2, 4, 3, 1};
		System.out.println(maxConsecSum(numbers, 3));
	}

}
