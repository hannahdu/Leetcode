//Given n non-negative integers representing an elevation map where the width of each bar is 1, 
//compute how much water it is able to trap after raining.

//http://www.leetcode.com/static/images/problemset/rainwatertrap.png
//The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
//In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

//Example:
//
//Input: [0,1,0,2,1,0,1,3,2,1,2,1]
//Output: 6




class Solution {
    public int trap(int[] height) {    
        if (height == null || height.length == 0) {
            return 0;
        }
        
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        
        int water = 0;
        int sum = 0;
        
        for (int i = 0; i < height.length; i++) {
            water = Math.min(leftMax[i], rightMax[i]) - height[i];
            sum += water;
        }
        return sum;
    }    
}



