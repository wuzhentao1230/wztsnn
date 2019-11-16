package leetcode.只出现一次的数字;

public class main {
    public int singleNumber(int[] nums) {
        if (nums.length == 1){
            return nums[0];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i==j) {
                    continue;
                }else if (nums[i] == nums[j]){
                    break;
                }
                if (i==nums.length - 1 || j == nums.length - 1){
                    return nums[i];
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println(new main().singleNumber(new int[]{2,2,1}));
    }
}
