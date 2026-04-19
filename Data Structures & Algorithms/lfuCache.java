class LFUCache {
    int limit = 0;
    int minFreq = 0;
    Map<Integer, int[]> cache; // key -> [value, frequency]
    Map<Integer, LinkedHashSet<Integer>> freqMap; // frequency -> keys

    public LFUCache(int capacity) {
        limit = capacity;
        cache = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        increaseFreq(key);
        return cache.get(key)[0];
    }

    public void put(int key, int value) {
        if(limit == 0) return;

        if(cache.containsKey(key)){
            cache.put(key, new int[]{value, cache.get(key)[1]});
            increaseFreq(key);
        } else {
            if(cache.size() == limit){
                evictLFU();
            }
            cache.put(key, new int[]{value, 1});
            addToFreqGroup(key, 1);
            minFreq = 1;
        }
    }

    private void increaseFreq(int key){
        int oldFreq = cache.get(key)[1];
        int newFreq = oldFreq + 1;

        removeFromFreqGroup(key, oldFreq);
        cache.put(key, new int[]{cache.get(key)[0], newFreq});
        addToFreqGroup(key, newFreq);

        if(minFreq == oldFreq && !freqMap.containsKey(oldFreq)){
            minFreq = newFreq;
        }
    }

    private void addToFreqGroup(int key, int freq){
        LinkedHashSet<Integer> set = freqMap.getOrDefault(freq, new LinkedHashSet<>());
        set.add(key);
        freqMap.put(freq, set);
    }

    private void removeFromFreqGroup(int key, int freq){
        LinkedHashSet<Integer> set = freqMap.get(freq);
        set.remove(key);
        if(set.isEmpty()){
            freqMap.remove(freq);
        }
    }

    private void evictLFU(){
        LinkedHashSet<Integer> set = freqMap.get(minFreq);
        int keyToRemove = set.iterator().next();
        cache.remove(keyToRemove);
        removeFromFreqGroup(keyToRemove, minFreq);
    }
}
