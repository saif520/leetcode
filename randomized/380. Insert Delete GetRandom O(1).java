import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// RandomizedSet design allows for O(1) time complexity for insertion, deletion and getting a random element.
class RandomizedSet {
    private Map<Integer, Integer> valueToIndexMap = new HashMap<>(); // Maps value to its index in 'valuesList'.
    private List<Integer> valuesList = new ArrayList<>(); // Stores the values.
    private Random randomGenerator = new Random(); // Random generator for getRandom() method.

    // Constructor of the RandomizedSet.
    public RandomizedSet() {
    }

    // Inserts a value to the set. Returns true if the set did not already contain the specified element.
    public boolean insert(int val) {
        if (valueToIndexMap.containsKey(val)) {
            // If the value is already present, return false.
            return false;
        }
        // Map the value to the size of the list which is the future index of this value.
        valueToIndexMap.put(val, valuesList.size()); 
        // Add the value to the end of the values list.
        valuesList.add(val); 
        return true;
    }

    // Removes a value from the set. Returns true if the set contained the specified element.
    public boolean remove(int val) {
        if (!valueToIndexMap.containsKey(val)) {
            // If the value is not present, return false.
            return false;
        }
        // Get index of the element to remove.
        int indexToRemove = valueToIndexMap.get(val); 
        // Get last element in the list.
        int lastElement = valuesList.get(valuesList.size() - 1); 
        // Move the last element to the place of the element to remove.
        valuesList.set(indexToRemove, lastElement);
        // Update the map with the new index of lastElement.
        valueToIndexMap.put(lastElement, indexToRemove); 
        // Remove the last element from the list.
        valuesList.remove(valuesList.size() - 1); 
        // Remove the entry for the removed element from the map.
        valueToIndexMap.remove(val);
        return true;
    }

    // Get a random element from the set.
    public int getRandom() {
        // Returns a random element using the random generator.
        return valuesList.get(randomGenerator.nextInt(valuesList.size())); 
    }

    // The below comments describe how your RandomizedSet class could be used:
    // RandomizedSet obj = new RandomizedSet();
    // boolean param_1 = obj.insert(val);
    // boolean param_2 = obj.remove(val);
    // int param_3 = obj.getRandom();
}
