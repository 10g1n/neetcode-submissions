class Task {
    char taskName;
    int frequency;
    int availableAt;

    public Task(char taskName, int frequency) {
        this.taskName = taskName;
        this.frequency = frequency;
        this.availableAt = 0;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> tasksFreqs = countFreq(tasks);
        PriorityQueue<Task> freqs = new PriorityQueue<>((a, b) -> b.frequency - a.frequency);

        for (Map.Entry<Character, Integer> entry : tasksFreqs.entrySet()) {
            freqs.add(new Task(entry.getKey(), entry.getValue()));
        }

        Queue<Task> cooldown = new LinkedList<>();

        int cycleCount = 0;

       while (!freqs.isEmpty() || !cooldown.isEmpty()) {
           cycleCount++;

           if (!cooldown.isEmpty() && cooldown.peek().availableAt <= cycleCount) {

               Task task = cooldown.poll();

               freqs.add(task);
           }

           if (!freqs.isEmpty()) {

               Task task = freqs.poll();

               task.frequency--;

               if (task.frequency > 0) {
                   task.availableAt = cycleCount + n + 1;
                   cooldown.add(task);
               }
           }
       }

        return cycleCount;
    }

    private HashMap<Character, Integer> countFreq(char[] tasks) {
        HashMap<Character, Integer> freqs = new HashMap<>();

        for (char task : tasks) {
            if (freqs.containsKey(task)) {
                freqs.put(task, freqs.get(task)+1);
            } else {
                freqs.put(task, 1);
            }
        }

        return freqs;
    }
}
