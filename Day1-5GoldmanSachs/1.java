// https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/.

// Print Anagrams Together 

// Given an array of strings, return all groups of strings 
// that are anagrams. The groups must be created in order 
// of their appearance in the original array. Look at the 
// sample case for clarification.

// Input:
// N = 5
// words[] = {act,god,cat,dog,tac}
// Output: 
// god dog
// act cat tac

//User function Template for Java

class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        Map<String, List<String>> map = new HashMap<>();
        for(String s : string_list){
            char charArray[] = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            if(!map.containsKey(sorted)){
                map.put(sorted, new ArrayList<String>());
            }
            map.get(sorted).add(s);
        }
	   return new ArrayList<>(map.values());
    }
}
