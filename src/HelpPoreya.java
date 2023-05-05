import java.util.*;

class MyNode{
    public MyNode next;
    public MyNode perv;
    public long data;
    public MyNode(long d){
        this.data = d;
    }
}

class MyQueue{
    private MyNode head = null;
    private MyNode iter = null;
    public long size = 0;

    public void add(long data){
        size++;
        MyNode temp = new MyNode(data);
        if(head == null){
            head = temp;
            iter = head;
        }else{
            iter.next = temp;
            temp.perv = iter;
            iter = temp;
        }
    }
    public long remove(){
        if(head == null)
            return -1;
        size--;
        long temp = head.data;
        head = head.next;
        return temp;
    }

    public MyNode getHead() {
        return head;
    }
}

public class HelpPoreya {

    public static void main (String[] args) {

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        MyQueue listF = new MyQueue();
        MyQueue listTemp = new MyQueue();
        Set<String> list = new HashSet<>();


        for (int i = 0; i < n; i++)
            listF.add(in.nextInt());

        MyNode head = listF.getHead();

        for (int i = 0; i < n; i++) {
            int itr = in.nextInt();
            String str = head.data+","+itr;
            int sizeBefore = list.size();
            list.add(str);
            int sizeAfter = list.size();
            if(sizeAfter > sizeBefore){
                head = head.next;
            }
            else{
                listTemp.add(itr);
            }
        }
//        while (head != null) {
//            long size = listTemp.size;
//            for (int i = 0; i < size; i++) {
//                long temp = listTemp.remove();
//                int sizeBefore = list.size();
//                String str = head.data+","+temp;
//                list.add(str);
//                int sizeAfter = list.size();
//                if(sizeAfter > sizeBefore){
//                    break;
//                } else {
//                    listTemp.add(temp);
//                }
//            }
//            head = head.next;
//        }
        System.out.println(list.size());
    }
}
