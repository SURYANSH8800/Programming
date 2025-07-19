package C3;
// Basic stack implementation
public class stacks{
    int[] arr;
    int top;
    int capa;
    stacks(int size) {
        arr = new int[size];
        capa = size;
        top = -1;
    }
    public void push(int val){
        if(top==capa-1){
            System.out.println("overflow");
            return;
        }
        arr[++top] = val;
    }
    public int pop(){
        if(top == -1){
            System.out.println("underflow");
            return -1;
        }
        return arr[top--];
    }
    public int peek(){
        if(top==-1){
            System.out.println("Already  empty");
            return -1;
        }
        return arr[top];
    }
    public void print(){
        for(int i = 0;i<=top;i++ ){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args){
        stacks stack = new stacks(9);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.print();
        stack.pop();
        int top = stack.peek();
        System.out.println("Top : " + top);
        System.out.println("-----");
        stack.print();
    }
}
