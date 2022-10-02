class Solution {
    //Solved using linked list cycle detection 
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        
        do{
            //One time it has to run because in starting slow = fast .
            slow = square(slow);
            fast = square(square(fast));
        }while (slow != fast);
        
        if (slow == 1){
            return true;
        }
        
        return false;
    }
    
    private int square(int n){
        int square = 0;
        while (n > 0){
            //This will run until no. becomes zero , no. is continuoulsy shortened . 
            int rem = n % 10;
            square += rem * rem;
            n = n / 10;
        }
        return square;
    }
}
