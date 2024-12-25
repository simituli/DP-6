
class Solution {
    int start;
    int end;
  //first is using 2 pointers - Time complexity: O(n^2)
  //Space Complexity: O(1)
    public String longestPalindrome(String s) {
        int n = s.length();
        
        for(int i=0;i<n;i++)
        {
            extendLength(s,i,i);//odd length
            if(i<n-1&&s.charAt(i)==s.charAt(i+1))
            {
                extendLength(s,i,i+1);//odd length
            }
        }
        return s.substring(start, end+1);
    }
    private void extendLength(String s, int low, int high)
    {
        while(low >= 0 && high < s.length() && s.charAt(low)==s.charAt(high))
        {
            low--;
            high++;
        }
        low++;
        high--;
        if(high-low>end-start)
        {
            start = low;
            end = high;
        }
    }

    //DP
  ////first is using DP - Time complexity: O(n^2)
  //Space Complexity: O(n*n)
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    if(i-j<=1||dp[i-1][j+1])
                    {
                        dp[i][j] = true;
                        if(i-j>end-start)
                        {
                            start = j;
                            end =i;
                        }
                    }
                    else
                    {
                        dp[i][j]=false;
                    }
                }
                else
                {
                    dp[i][j]=false;
                }
            }
        }
        return s.substring(start, end+1);
    }
    //DP with 1-d array
    // Time complexity: O(n^2)
    //Space Complexity: O(n)
     public String longestPalindrome(String s) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        for (int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(s.charAt(i)==s.charAt(j))
                {
                    if(i-j<=1||dp[j+1])
                    {
                        dp[j] = true;
                        if(i-j>end-start)
                        {
                            start = j;
                            end =i;
                        }
                    }
                    else
                    {
                        dp[j]=false;
                    }
                }
                else
                {
                    dp[j]=false;
                }
            }
        }
        return s.substring(start, end+1);
    }
}
