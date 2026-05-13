class TimeMap {
    Map<String, TreeMap<Integer, String>> keyMap;
    public TimeMap() {
        keyMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        TreeMap<Integer, String> timeMap = keyMap.getOrDefault(key, new TreeMap<>());
        timeMap.put(timestamp, value);
        keyMap.put(key, timeMap);
    }
    
    public String get(String key, int timestamp) {
        TreeMap<Integer, String> timeMap = keyMap.get(key);
        if(!keyMap.containsKey(key)) 
            return "";
        Map.Entry<Integer, String> entry = timeMap.floorEntry(timestamp);
        return entry == null ? "" : entry.getValue();
    }
}
