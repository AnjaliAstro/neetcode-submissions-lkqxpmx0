class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for(char ch:tasks){
            freq[ch-'A']++;
            maxFreq = Math.max(maxFreq, freq[ch-'A']);
        }

        int countOfMaxFreq = 0;
        for(int i=0; i<26; i++){
            if(freq[i] == maxFreq){
                countOfMaxFreq++;
            }
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1) + countOfMaxFreq);
    }
}

// Step 1 — Most frequent task forms the skeleton
// A appears 3 times and must have n=3 gap between each:
// A _ _ _ A _ _ _ A
// This creates (maxFreq - 1) blocks of size (n+1):
// (3-1) × (3+1) = 2 × 4 = 8 slots

// Step 2 — Fill remaining tasks into blocks
// A B C _ A _ _ _ A
// Add 1 for the last A at the end:
// (maxFreq-1) × (n+1) + countOfMaxFreq
// = 2 × 4 + 1 = 9 ✅

// Step 3 — What if we have too many tasks?
// tasks = ["A","A","B","B","C","C","D","D"], n = 2
// So many tasks that idle time = 0:
// A B C D A B C D
// Answer is just tasks.length = 8!

// That's why we take the max of both:

// answer = Math.max(tasks.length, (maxFreq-1) × (n+1) + countOfMaxFreq)



// Why (maxFreq-1) blocks?
// When you arrange A which appears 3 times:
// Block 1    Block 2    Last
// [A _ _ _] [A _ _ _]  [A]

// The last A doesn't need a cooldown block after it — it's the final occurrence! So only maxFreq-1 full blocks exist.


// Why + countOfMaxFreq?
// What if multiple tasks share maxFreq?
// tasks = ["A","A","A","B","B","B"], n = 2
// maxFreq = 3, countOfMaxFreq = 2
// Block 1    Block 2    Last
// [A B _ ] [A B _ ]  [A B]
//                     ↑↑
//                 both A and B
//                 sit at the end!
// (3-1) × (2+1) + 2
// = 2 × 3 + 2
// = 8 

//One liner intuition

// countOfMaxFreq is simply how many tasks sit at the very end after the last full cooldown block — one slot per task that has maximum frequency!
