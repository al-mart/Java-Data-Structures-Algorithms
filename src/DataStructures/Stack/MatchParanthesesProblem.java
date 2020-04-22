package DataStructures.Stack;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatchParanthesesProblem {
    private static Map<Character, Character> MATCHINGPARANTHESISMAP = new HashMap<>();
    private static Set<Character> OPENINGPARANTHESIS = new HashSet<>();

    static {
        MATCHINGPARANTHESISMAP.put(')', '(');
        MATCHINGPARANTHESISMAP.put(']', '[');
        MATCHINGPARANTHESISMAP.put('}', '{');
        OPENINGPARANTHESIS.addAll(MATCHINGPARANTHESISMAP.values());
    }

    public static boolean hasMatchingParenthesis(String input) {
        try {
            Stack<Character> parenthesisStack = new Stack<>();
            for(int i = 0; i <= input.length(); i++){
                Character ch = input.charAt(i);
                if(OPENINGPARANTHESIS.contains(ch)){
                    parenthesisStack.push(ch);
                }
                if(MATCHINGPARANTHESISMAP.containsKey(ch)){
                    Character lastInStack = parenthesisStack.pop();
                    if(MATCHINGPARANTHESISMAP.get(ch) != lastInStack){
                        return false;
                    }
                }
            }
            return parenthesisStack.isEmpty();
        }catch (Exception exc){
            System.out.println(exc.getMessage());
        }
        return false;
    }
}
