public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        char[] array = num.toCharArray();
        dfs(result, sb, array, 0, target, 0, 0);
        return result;
    }
    
    private void dfs(List<String> result, StringBuilder sb, char[] array, int pos, int target, long prev, long multi) {
        if (pos == array.length) {
            if (target == prev) {
                result.add(sb.toString());
                return;
            }
        }
        
        long curr = 0;
        for (int  i = pos; i < array.length; i++) {
            //0 is in the middle
            if (array[pos] == '0' && i != pos) {
                break;
            }
            curr = 10 * curr + array[i] - '0';
            int len = sb.length();
            if (pos == 0) {
                dfs(result, sb.append(curr), array, i + 1, target, curr, curr);
                sb.setLength(len);
            } else {
                dfs(result, sb.append("+").append(curr), array, i + 1, target, prev + curr, curr);
                sb.setLength(len);
                dfs(result, sb.append("-").append(curr), array, i + 1, target, prev - curr, -curr);
                sb.setLength(len);
                dfs(result, sb.append("*").append(curr), array, i + 1, target, prev - multi + multi * curr, multi * curr);
                sb.setLength(len);
            }
        }
    }
}