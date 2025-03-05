//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main ( String[] args ) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println( "List Framework \n \n" );
        ListCollectionFramework listCollectionFramework = new ListCollectionFramework( );

        System.out.println( "Array List :: \n" );
        listCollectionFramework.ArrayListMethods( );

        System.out.println( "Linked List :: \n" );
        listCollectionFramework.LinkedListMethods( );

        System.out.println( "Vector :: \n" );
        listCollectionFramework.VectorMethods( );

        System.out.println( "Stack :: \n" );
        listCollectionFramework.StackMethod( );

        System.out.println( "Deque :: \n" );
        listCollectionFramework.DequeMethods();

        System.out.println( "Queue Framework \n \n" );
        QueueCollectionFramework queueCollectionFramework = new QueueCollectionFramework( );

        System.out.println( "Linked List :: \n" );
        queueCollectionFramework.LinkedListMethods( );

        System.out.println( "Priority Queue List :: \n" );
        queueCollectionFramework.PriorityQueueMethods( );

        System.out.println( "Priority Blocking Queue List :: \n" );
        queueCollectionFramework.PriorityBlockingQueue( );

        System.out.println( "Queue Framework \n \n" );
        SetCollectionFramework setCollectionFramework = new SetCollectionFramework( );

        System.out.println( "Hash Set  :: \n" );
        setCollectionFramework.hashSetMethods( );

        System.out.println( "Linked Hash Set  :: \n" );
        setCollectionFramework.linkedHashSetMethods( );

        System.out.println( "Tree Set  :: \n" );
        setCollectionFramework.treeSetMethods( );

        System.out.println( "Map Framework \n \n" );
        MapCollectionFramework mapCollectionFramework = new MapCollectionFramework( );

        System.out.println( "Hash Map  :: \n" );
        mapCollectionFramework.hashMapMethods( );

        System.out.println( "Linked Hash Map  :: \n" );
        mapCollectionFramework.LinkedHashMapMethods( );

        System.out.println( "Tree Set  :: \n" );
        mapCollectionFramework.treeMapMethods( );
    }
}