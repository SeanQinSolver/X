public class Solution {
    /**
     * @param source: A string
     * @param target: A string
     * @return: A string denote the minimum window
     *          Return "" if there is no such a string
     */
    public String minWindow(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) return "";
        if (source.length() < target.length()) return "";
        
        final int ASCII_COUNT = 256;
        int[] targetCount = new int[ASCII_COUNT];
        int[] sourceCount = new int[ASCII_COUNT];
        
        for (int i = 0; i < target.length(); i++) {
            int ch2i = (int)target.charAt(i);
            targetCount[ch2i]++;
        }
        
        int winStart = 0, winMinStart = 0, winMin = Integer.MAX_VALUE;
        int count = 0;
        
        for (int winEnd = 0; winEnd < source.length(); winEnd++) {
            
            int ch2i = (int)source.charAt(winEnd);
            sourceCount[ch2i]++;
            if (targetCount[ch2i] > 0 && targetCount[ch2i] >= sourceCount[ch2i]) {
                count++;
            }
            System.out.println("count: " + count);
            if (count == target.length()) {
                int ch2i2 = (int)source.charAt(winStart);
                //System.out.println(winStart + "**");
                //如果sourceCount的大于targetCount，则表示target里面没有这个。则winstart向前缩进
                while (sourceCount[ch2i2] > targetCount[ch2i2]) {
                    sourceCount[ch2i2]--;
                    winStart++;
                    ch2i2 = (int)source.charAt(winStart);
                }
                
                if (winMin > winEnd - winStart + 1) {
                    winMin = winEnd - winStart + 1;
                    winMinStart = winStart;
                }
                System.out.println("winMinStart " + winMinStart + " winStart " + winStart + " winEnd " + winEnd);
                
                System.out.println();
            }
        }
        
        if (winMin == Integer.MAX_VALUE) {
            return "";
        } else {
            return source.substring(winMinStart, winMinStart + winMin);
        }
    }
}
//此题的意思是end向前拉伸，同时start缩进