//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.

//Note:
//The solution set must not contain duplicate triplets.

//Example:
//Given array nums = [-1, 0, 1, 2, -1, -4],
//A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]




class Solution {
    public List<List<Integer>> threeSum(int[] array) {
        Arrays.sort(array);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = array.length - 1;
            while (left < right) {
                int temp = array[left] + array[right];
                if (temp + array[i] == 0) {
                    result.add(Arrays.asList(array[i], array[left], array[right]));
                    left++;
                    while (left < right && array[left] == array[left - 1]) {
                        left++;
                    }
                }
                else if (temp + array[i] < 0) {
                    left++;
                }
                else {
                    right--;
                }
            }      
        }
        return result;
    }    
}



