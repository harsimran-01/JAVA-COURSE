public class circular_queue {
    

    static class queue_class {

        static int[] arr;
        static int size;
        static int rear;
        static int front = -1;

        public queue_class(int n) {
            arr = new int[n];
            this.size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front ==-1; 
        }

        public static boolean isFull(){
            return (rear+1)%size == front;
        }

        public static void add(int data) {
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }
            if (front == -1) {
                front = 0;
            }
            rear = (rear+1)%size;
            arr[rear] = data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }
            int result = arr[front];
            if(rear == front){
                rear = front =-1;
            }else{
                front = (front+1)%size;
            }
            return front;
        }

        public static int peek(){
            if(isEmpty()){
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = arr[front];
            return result;
        }

    }

    public static void main(String[] args) {
        queue_class q = new queue_class(5);
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        System.out.println("Removed element "+q.remove());
        q.add(6);
        System.out.println("Removed element "+q.remove());
        q.add(7);

        while(!q.isEmpty()){
            System.out.println(q.peek());
            q.remove();
        }


    }
}


