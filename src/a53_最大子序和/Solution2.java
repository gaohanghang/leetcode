package a53_最大子序和;

/**
 * @Description: 分治法
 * @author: Gao Hang Hang
 * @date 2019/01/11 21:38
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        return divide(nums,0,nums.length-1);
    }
    public int divide(int[] nums,int start,int end){
        if(start>=end) return nums[start];//大于的情况就当是中间情况了
        int mid=(start+end)/2;
        int maxleft=divide(nums,start,mid-1);//左边最大和
        int maxright=divide(nums,mid+1,end);
        //计算包含中间的连续最大和
        int midl=nums[mid];
        for(int temp=mid-1,sum=nums[mid];temp>=start;temp--){//计算左边
            sum+=nums[temp];
            midl=midl>sum?midl:sum;
        }
        int midr=midl;
        for(int temp=mid+1,sum=midr;temp<=end;temp++){//计算右边
            sum+=nums[temp];
            midr=midr>sum?midr:sum;
        }
        return Math.max(maxleft,Math.max(maxright,midr));//最大子串在左边，最大子串在右边，或者包含中间那个数
    }
}
