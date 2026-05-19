class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        List<int[]> validTriplets = new ArrayList<>();
        for(int[] triplet: triplets){
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                validTriplets.add(triplet);
            }
        }
        int[] result = new int[3];
        for(int[] triplet: validTriplets){
            result[0] = Math.max(result[0], triplet[0]);
            result[1] = Math.max(result[1], triplet[1]);
            result[2] = Math.max(result[2], triplet[2]);
        }
        return result[0]==target[0] && result[1]==target[1] && result[2]==target[2];
    }
}

// 1st pos - all target[0] containing indexes at 0 
// take one by one and for them try to combine with any all 2nd pos containing elements including itself
// 2nd pos - all target[1] containing indexes at 1
// take one by one and for them try to combine with any all 3rd pos containing elements including itself
// 3rd pos - all target[2] containing indexes at 2
// check in the middle if it has been made or not

//on right track but reverse it
// method of elimination - remove all faulty one and then combine the rests and check 