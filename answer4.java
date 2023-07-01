import java.util.PriorityQueue;

public class LastStoneWeight {
    public static int lastStoneWeight(int[] stones) {
        // Create a max-heap to store the weights of the stones
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add the stone weights to the max-heap
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        
        // Smash the stones until there is at most one stone left
        while (maxHeap.size() > 1) {
            // Extract the two heaviest stones from the max-heap
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();
            
            // Calculate the new weight after smashing the stones
            int newWeight = stone1 - stone2;
            
            // Add the new weight to the max-heap
            maxHeap.offer(newWeight);
        }
        
        // Return the weight of the last remaining stone, or 0 if there are no stones left
        return maxHeap.isEmpty() ? 0 : maxHeap.peek();
    }
    
    public static void main(String[] args) {
        int[] stones1 = {2, 7, 4, 1, 8, 1};
        System.out.println("Input 1: stones = [2, 7, 4, 1, 8, 1]");
        System.out.println("Output 1: " + lastStoneWeight(stones1));
        
        int[] stones2 = {1, 3};
        System.out.println("Input 2: stones = [1, 3]");
        System.out.println("Output 2: " + lastStoneWeight(stones2));
    }
}
