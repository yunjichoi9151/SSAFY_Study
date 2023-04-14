package day0413;

import java.util.Arrays;

public class bubbleSort {
	public static void main(String[] args) {
		int [] nums = {23,17,1997,13,7,17,77};
		
		int N = nums.length;
		
		// 오름차순으로 정렬
		// i는 실제로 정렬된 값의 위치
//		for(int i=N-1;i>=0;i--) {
//			for(int j=0;j<i;j++) {
//				if(nums[j]>=nums[j+1]) {
//					int tmp = nums[j];
//					nums[j] = nums[j+1];
//					nums[j+1] = tmp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(nums));
		
		for(int i=0;i<N;i++) {
			for(int j=1;j<N-i;j++) {
				if(nums[j-1]>nums[j]) {
					int tmp = nums[j-1];
					nums[j-1] = nums[j];
					nums[j] =tmp;
				}
			}
		}
		System.out.println(Arrays.toString(nums));
	}
}
