

class Solution {
    public boolean isValid(String s) {
        Stack<Character> openBrackets = new Stack<>();
        Map<Character, Character> mp = new HashMap<>();
        mp.put('(', ')');
        mp.put('{', '}');
        mp.put('[', ']');

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If it's an opening bracket, push to the stack
            if (mp.containsKey(c)) {
                openBrackets.push(c);
            } else {
                // If it's a closing bracket, check if it matches the top of the stack
                if (openBrackets.isEmpty() || mp.get(openBrackets.pop()) != c) {
                    return false;
                }
            }
        }
        // In the end, stack should be empty for a valid string
        return openBrackets.isEmpty();
    }
}
