

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');

        for(Character c:s.toCharArray()){
            if(map.containsKey(c)){
                stack.push(c);
            }
            else{
                if(stack.empty() || !c.equals(map.get(stack.pop()))){
                    return false;
                }
            }
        }
        return stack.empty();
    }       
}
