class Solution {
    public void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix.length-1;

        while(left<right){
            int top = left;
            int bottom = right;
            for(int i=0; i<(right-left); i++){
                
                // store the top left
                int topLeft = matrix[top][left+i];

                //swap the bottom left to top left
                matrix[top][left+i] = matrix[bottom-i][left];

                //swap the bottom right to bottom left
                matrix[bottom-i][left] = matrix[bottom][right-i];

                //swap the top right to bottom right
                matrix[bottom][right-i] = matrix[top+i][right];

                //swap the temp to top right
                matrix[top+i][right] = topLeft;

            }
            left++;
            right--;
        }

    }
}
