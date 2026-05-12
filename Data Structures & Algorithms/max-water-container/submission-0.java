class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;

        int left = 0;
        int right = n-1;
        int maxStorage = 0;
        while(left <= right){
            int area = Math.min(heights[left], heights[right])*(right-left);
            maxStorage = Math.max(maxStorage, area);

            if(heights[left] <= heights[right]){
                left++;
            }
            else{
                right--;
            }
        }
        return maxStorage;
    }
}
