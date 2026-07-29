class Entry {
    private String value;
    private int timestamp;

    public Entry(String value, int timestamp) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public String getValue() {
        return value;
    }

    public int getTimestamp() {
        return timestamp;
    }
}

class TimeMap {
    private HashMap<String, List<Entry>> data;

    public TimeMap() {
        this.data = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Entry entry = new Entry(value, timestamp);

        if (data.containsKey(key)) {
            data.get(key).add(entry);
        } else {
            data.put(key, new ArrayList<>(List.of(entry)));
        }
    }
    
    public String get(String key, int timestamp) {
        Entry best = null;

        if (data.containsKey(key)) {
            List<Entry> entries = data.get(key);

            int left = 0;
            int right = entries.size() - 1;


            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (entries.get(mid).getTimestamp() == timestamp) {
                    return entries.get(mid).getValue();
                }

                if (entries.get(mid).getTimestamp() < timestamp) {
                    best = entries.get(mid);
                    left = mid + 1;
                }

                if (entries.get(mid).getTimestamp() > timestamp) {
                    right = mid - 1;
                }
            }
        }
        return best != null ? best.getValue() : "";
    }
}
