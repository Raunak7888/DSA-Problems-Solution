public class tOH{
    public static void towerOfHanoi(int n, char source,char end,char helper){
        if(n==1){
            System.out.println("Move Disk 1 from "+source+" to "+end);
            return;
        }
        towerOfHanoi(n-1, source, helper, end);
        System.out.println("Move Disk "+n+" from " + source+" to " +end);
        towerOfHanoi(n-1, helper, end, source);
    }
    public static void main(String[] args) {
        int n = 3;
        towerOfHanoi(n,'A','C','B');
    }
}