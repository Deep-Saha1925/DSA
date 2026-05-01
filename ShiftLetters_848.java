public class ShiftLetters_848{
    
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        char[] arr = s.toCharArray();
        
        int totalShift = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26;
            
            int newChar = ((arr[i] - 'a') + totalShift) % 26;
            arr[i] = (char)(newChar + 'a');
        }
        
        return new String(arr);
    }


    public static void main(String a[]){
        ShiftLetters_848 s = new ShiftLetters_848();
        System.out.println(s.shiftingLetters("aaa", new int[]{1, 2, 3}));
    }
}