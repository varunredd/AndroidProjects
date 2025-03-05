import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class QueueCollectionFramework {

    public void LinkedListMethods ( ) {
        Queue<String> queue = new LinkedList<>( );

        queue.add( "apple" );
        queue.add( "banana" );
        queue.add( "cherry" );

        System.out.println( "Queue: " + queue );

        String front = queue.remove( );
        System.out.println( "Removed element: " + front );

        System.out.println( "Queue after removal: " + queue );

        queue.add( "date" );

        String peeked = queue.peek( );
        System.out.println( "Peeked element: " + peeked );

        System.out.println( "Queue after peek: " + queue + "\n \n" );
    }

    public void PriorityQueueMethods ( ) {

//        add(E e) – Adds an element to the queue.
//        offer(E e) – Adds an element to the queue (similar to add()).
//        peek() – Retrieves, but does not remove, the highest-priority element.
//                poll() – Retrieves and removes the highest-priority element.
//                remove(Object o) – Removes a specific element from the queue.
//                contains(Object o) – Checks if a specific element is in the queue.
//                size() – Returns the number of elements in the queue.
//        clear() – Removes all elements from the queue.
//        comparator() – Returns the comparator used to order the elements in the queue (if any).

        Queue<String> pq = new PriorityQueue<>( );

        // add() is a Non Thread Safe method
        // In a bounded queue (e.g., ArrayBlockingQueue) this would throw an exception if the queue is full.

        pq.add( "Geeks" );
        pq.add( "For" );
        pq.add( "Geeks" );


        // offer() is a Thread safe method
        pq.offer( "For" );

        //Priority Queue sorts the elements according to their priority
        pq.forEach( n -> System.out.println( n ) );

        System.out.println( "Initial Queue " + pq );

        pq.remove( "Geeks" );

        System.out.println( "After Remove " + pq );

        System.out.println( "Poll Method " + pq.poll( ) );

        System.out.println( "Final Queue " + pq + "\n \n" );
    }

    public void PriorityBlockingQueue ( ) {


//        add(E e) – Adds an element to the queue. Throws IllegalStateException if it cannot add the element due to capacity constraints.
//                offer(E e) – Adds an element to the queue, returns false if the element cannot be added immediately.
//        offer(E e, long timeout, TimeUnit unit) – Tries to add an element to the queue, waiting for the specified timeout if the queue is full.
//        peek() – Retrieves, but does not remove, the highest-priority element.
//                poll() – Retrieves and removes the highest-priority element.
//                poll(long timeout, TimeUnit unit) – Retrieves and removes the highest-priority element, waiting for the specified timeout if the queue is empty.
//        take() – Retrieves and removes the highest-priority element, blocking indefinitely if the queue is empty.
//        remove(Object o) – Removes a specific element from the queue.
//                size() – Returns the number of elements in the queue.
//        clear() – Removes all elements from the queue.
//        comparator() – Returns the comparator used to order the elements in the queue (if any).

        //PriorityQueue is not Thread safe while Priority Blocking Queue is thread safe
        PriorityBlockingQueue<String> queue = new PriorityBlockingQueue<String>( );
        queue.put( "Varun" );
        queue.put( "Tarun" );
        queue.put( "Hari" );
        queue.put( "Venu" );

        queue.forEach( n -> System.out.println( n ) );

        try {
            queue.take( ); // Blocks if the queue is empty
        } catch (InterruptedException exception) {
            System.out.println( "Exception : " + exception );
        }


        System.out.println( "After Remove " + queue + "\n \n" );


    }


}
