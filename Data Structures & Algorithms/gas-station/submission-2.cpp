class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost) {
        vector <int> diff;
        for (int i=0; i<gas.size(); i++) {
            diff.push_back(gas[i] - cost[i]);
        }
        for (int i=0; i<gas.size(); i++) {
            diff.push_back(gas[i] - cost[i]);
        }
        int start = 0;
        int total = 0;
        int len = gas.size();
        for (int i=0; i<diff.size(); i++) {
            total += diff[i];
            if (total < 0) {
                total = 0;
                start = i+1;
            }
            if ((i-start+1) == len) {
                return start%len;
            }
        }
        return -1;
    }
};
