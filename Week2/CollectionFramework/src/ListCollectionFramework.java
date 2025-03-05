import java.util.*;

public class ListCollectionFramework {

    public void ArrayListMethods ( ) {
        List<String> list = new ArrayList<>( );
        list.add( "Varun" );
        list.add( "Tarun" );
        list.add( "Venu" );
        list.add( "Hari" );
        list.add( "Venu" );


        //To iterate and print a list
        for (String ele : list) {
            System.out.println( ele );
        }

        //Print the element at first index
        System.out.println( "Element at index 1: " + list.get( 1 ) );

        //Set index 1 to another value
        list.set( 1, "Kamal" );
        System.out.println( "Element at index 1: " + list.get( 1 ) );

        list.remove( "Hari" );
        System.out.println( "List after removing Hari: " + list );

        list.remove( 1 );
        System.out.println( "List after removing index 1:" + list );

        int index = list.indexOf( "Hari" );
        System.out.println( "Index of Hari : " + index );

        int lastIndex = list.lastIndexOf( "Venu" );
        System.out.println( "Index of Venu : " + lastIndex );

        boolean result = list.contains( "Varun" );
        System.out.println( "Check if the list contains Varun " + result + "\n \n" );

    }

    public void LinkedListMethods ( ) {
        LinkedList<String> list = new LinkedList<>( );
        list.add( "Toyota" );
        list.add( "Suzuki" );
        list.add( "Ford" );
        list.add( "Nissan" );
        list.add( "Ford" );
        list.add( "Kia" );
        list.add( "Mazda" );


        //To iterate and print a list
        System.out.println( "List : " );

        for (String ele : list) {
            System.out.println( ele );
        }

        //Print the element at first index
        System.out.println( "Element at index 1: " + list.get( 1 ) );

        //Set index 1 to another value
        list.set( 1, "Tata" );
        System.out.println( "Element at index 1: " + list.get( 1 ) );

        list.remove( "Nissan" );
        System.out.println( "List after removing Nissan: " + list );

        list.remove( 1 );
        System.out.println( "List after removing index 1:" + list );

        int index = list.indexOf( "Suzuki" );
        System.out.println( "Index of Suzuki : " + index );

        int lastIndex = list.lastIndexOf( "Ford" );
        System.out.println( "Index of Ford : " + lastIndex );

        boolean result = list.contains( "Toyota" );
        System.out.println( "Check if the list contains Toyota " + result );

        System.out.println( "The  remove first element is: " + list.removeFirst( ) );

        list.removeFirstOccurrence( "Ford" );
        System.out.println( "List after removing the first Occurrence of Ford " + list );

        System.out.println( "List : " );

        // ListIterator<String> it = list.descendingIterator( ); // this is used to print the list in descending order
        ListIterator<String> it = list.listIterator( );
        while (it.hasNext( )) {
            System.out.println( it.next( ) );
        }

        List<String> list1 = new LinkedList<>( );
        //list1 = (LinkedList) list.clone() // You can clone list and make a copy of that
        list1.addAll( list ); // You can either add a list it will by default append the list to your current list
        //list1.addAll(0,list); // This will add all the elements of the linked list at a particular position
        System.out.println( "Created a new Linked list and add all elements of previous linked list " + list1 );

        Object[] arr = list.toArray( );
        System.out.println( Arrays.toString( arr ) + "\n \n" );


    }

    public void VectorMethods ( ) {

        Vector<Integer> vector = new Vector<Integer>( 5, 2 );
        vector.addElement( 1 );
        vector.addElement( 2 );
        vector.addElement( 3 );
        vector.addElement( 4 );
        vector.addElement( 5 );

        Object object = vector.clone( );
        System.out.println( "Vector :" );
        System.out.println( object.toString( ) );

        /*
        TODO - Why we use String Builder
                Figure out an issue in String Builder line 126 to 129
         */
        Vector<StringBuilder> vec = new Vector<>( );
        vec.add( new StringBuilder( "Varun" ) );
        vec.add( new StringBuilder( "Tarun" ) );
        vec.add( new StringBuilder( "Venu" ) );
        vec.add( new StringBuilder( "Kamal" ) );
        System.out.println( "Vector 1 : " );
        vec.forEach( ( n ) -> System.out.println( n.toString( ) ) );

        //Copying mutable Objects
        Vector<StringBuilder> copyVector = (Vector<StringBuilder>) vec.clone( );
        System.out.println( "Copied Vector of Vector 1: " + copyVector.toString( ) );

        Vector<Integer> check = new Vector<>( );
        check.add( 1 );
        check.add( 2 );
        System.out.println( "Check if 1 and 2 exist in Vector  " + vector.containsAll( check ) );

        System.out.println( "Applying List Iterator to the Vector check" );
        ListIterator<Integer> listIterator = check.listIterator( );
        System.out.println( "Adding a element after applying list Iterator" );
        check.add( 3 );
        try {
            System.out.println( listIterator.next( ) );
        } catch (ConcurrentModificationException exception) {
            System.out.println( "Exception : " + exception );
        }

        System.out.println( "Using Multi Threading to print the values" );
        Spliterator<Integer> s1 = vector.spliterator( );
        Spliterator<Integer> s2 = s1.trySplit( );

        s2.forEachRemaining( num -> System.out.println( "Thread 1: " + num ) );
        s1.forEachRemaining( num -> System.out.println( "Thread 2: " + num ) );

        System.out.println( "Dynamic allocation of arraySize using toArray method: " );
        Integer[] arr = new Integer[1];
        arr = vector.toArray( arr );
        System.out.println( arr.length + "\n \n" );

    }


    public void StackMethod ( ) {

        Stack<String> stack = new Stack<>( );

        // Push elements onto the stack
        stack.push( "A" );
        stack.push( "B" );
        stack.push( "C" );

        stack.forEach( (n)->System.out.println( n ) );

        // Peek the top element without removing it
        System.out.println( "Top element: " + stack.peek( ) ); // C

        // Pop the top element from the stack
        System.out.println( "Popped element: " + stack.pop( ) ); // C

        // Peek again after pop
        System.out.println( "Top element after pop: " + stack.peek( ) ); // B

        System.out.println( "Is stack empty? " + stack.empty( ) ); // false

        // Search for an element in the stack
        System.out.println( "Position of element 'A' from top: " + stack.search( "A" ) ); // 2

        // Pop remaining elements
        System.out.println( "Popped element: " + stack.pop( ) ); // B
        System.out.println( "Popped element: " + stack.pop( ) ); // A

        System.out.println( "Is stack empty now? " + stack.empty( ) ); // true


    }

    public void DequeMethods ( ) {

//        peekFirst(): Returns the first element, or null if the deque is empty.
//        peekLast(): Returns the last element, or null if the deque is empty.
//        pollFirst(): Retrieves and removes the first element, or returns null if the deque is empty.
//        pollLast(): Retrieves and removes the last element, or returns null if the deque is empty.
//        addFirst(E e): Inserts the element at the front.
//        addLast(E e): Inserts the element at the end.
//        removeFirst(): Removes the first element.
//        removeLast(): Removes the last element

        System.out.println( "Deque : (LIFO Implementation)" );
        //Deque can be used as both FIFO and LIFO
        //As Stack inherits Vector Class it is thread safe in a single threaded application it is better to use Deque
        Deque<String> deque = new ArrayDeque<>( );
        deque.push( "A" );
        deque.push( "B" );
        deque.push( "C" );
        deque.push( "D" );// Push Method is used to add at first Offer Method is used to add at last

        deque.forEach( n -> System.out.println( n ) );


    }


}
