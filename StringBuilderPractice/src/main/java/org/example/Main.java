package org.example;


import java.util.ArrayDeque;
import java.util.Deque;


public class Main{

    public Main(){
        stringBuilder = new StringBuilder();
        deque = new ArrayDeque<>();
    }
    private final Deque<StringBuilder> deque;
    private final StringBuilder stringBuilder;

    public void saveData(){
        deque.push(new StringBuilder(stringBuilder));
    }
    public Main append(String string){
        saveData();
        stringBuilder.append(string);
        return this;
    }
    public Main delete(int start, int end){
        saveData();
        stringBuilder.delete(start, end);
        return this;
    }
    public void undo(){
        if (!deque.isEmpty()){
            StringBuilder last = deque.pop();
            stringBuilder.setLength(0);
            stringBuilder.append(last);
        }
    }

    @Override
    public String toString() {
        return "Main{" +
                "deque=" + deque +
                ", stringBuilder=" + stringBuilder +
                '}';
    }

    public static void main(String[] args) {
        Main test = new Main();
        test.append("1");
        System.out.println("1. "+test); // Hello

        test.append("2");
        System.out.println("2. "+test); // Hello World

        test.append("3");
        System.out.println("3. "+test); // Hello World

        test.append("4");
        System.out.println("4. "+test); // Hello World

        test.undo();
        System.out.println("5. "+test); // Hello World
    }
}
