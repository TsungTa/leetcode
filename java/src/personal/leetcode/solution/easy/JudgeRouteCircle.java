package personal.leetcode.solution.easy;

/*
 * link: https://leetcode.com/problems/judge-route-circle/description/
 * 
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 * 
 * Example 1:
 * 		Input: "UD"
 * 		Output: true
 * 
 * Example 2:
 * 		Input: "LL"
 * 		Output: false
 */
public class JudgeRouteCircle {
	public boolean judgeCircle(String moves) {
        int xAxis = 0, yAxis = 0;

        // To get each char in string, we can use moves.charAt() method here.
        // But we can get better runtime by converting string into char array.
        char[] charArray = moves.toCharArray();
        for(int i = 0; i < charArray.length; i++) {
            switch(charArray[i]) {
                case 'U':
                    xAxis++;
                    break;
                case 'D':
                    xAxis--;
                    break;
                case 'R':
                    yAxis--;
                    break;
                case 'L':
                    yAxis++;
                    break;
            }
        }
        
        return (xAxis==0 && yAxis==0);
    }
}
