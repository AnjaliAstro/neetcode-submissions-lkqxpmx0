class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Map<Integer, Integer> posSpeed = new HashMap<>();
        for(int i=0; i<position.length; i++){
            posSpeed.put(position[i], speed[i]);
        }

        Arrays.sort(position);
        Stack<Double> stack = new Stack<>();

        stack.push((double)(target-position[position.length-1])/posSpeed.get(position[position.length-1]));
        for(int i=position.length-2; i>=0; i--){
            double time = (double)(target-position[i]) / posSpeed.get(position[i]);
            if(time > stack.peek()){
                stack.push(time);
            }
        }
        return stack.size();
    }
}
