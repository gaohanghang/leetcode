package a0算法面试题.八大排序算法.笔试题;

/**
 * @Description:
 * @author: Gao Hang Hang
 * @date 2019/01/01 21:45
 */
public class Test2 {
    public static void main(String[] args) {
        int num = 158476551;
        System.out.println("begin: " + num);

        // 将自然数转为int数组
        String numStr = String.valueOf(num);
        int[] nums = new int[numStr.length()];
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            nums[i] = Integer.valueOf(String.valueOf(c));
        }

        // 获取下一个自然数
        int[] nextNaturalNumberArr = nextNatureNumber(nums);
        StringBuilder stringBuilder = new StringBuilder();
        for (int item : nextNaturalNumberArr) {
            stringBuilder.append(String.valueOf(item));
        }
        System.out.println("end: " + stringBuilder.toString());
    }

    public static int[] nextNatureNumber(int[] nums) {
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = nums.length -1; i > 0 ; i--) {
            if (nums[i] > nums[i -1]) {
                firstIndex = i - 1;
                secondIndex = i;
                break;
            }
        }

        int firstNum = nums[firstIndex];
        int remainMaxIndex = 0;
        for (int i = nums.length - 1; i > firstIndex ; i--) {
            if (nums[i] > firstNum) {
                remainMaxIndex = i;
                break;
            }
        }

        swap(nums, firstIndex, remainMaxIndex);

        reversion(nums, secondIndex);
        return nums;
    }

    public static int[] reversion(int[] nums, int startIndex) {
        int i = startIndex;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
        return nums;
    }

    public static int[] swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        return nums;
    }
}
