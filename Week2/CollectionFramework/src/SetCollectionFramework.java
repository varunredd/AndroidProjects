import java.util.*;

public class SetCollectionFramework {
//Set doesn't maintain specific order of inserting elements So insertion order is not preserved

    public void hashSetMethods ( ) {
        Set<String> set = new HashSet<>( );
        set.add( "Ford" );
        set.add( "BMW" );
        set.add( "Koensigg" );
        set.add( "BMW" );
        set.add( "Ferrari" );
        set.add( "Chevrolet" );

        System.out.println( "Set : " + set );

        Set<String> set1 = new HashSet<>( );
        set1.add( "Ford" );
        set1.add( "BMW" );
        set1.add( "Porshe" );
        set1.add( "Tata" );
        set1.add( "Ford" );
        Set<String> intersection = new HashSet<>( set1 );
        intersection.retainAll( set );
        System.out.println( "All elements of set1 in set are " + intersection + "\n \n" );

    }

    public void linkedHashSetMethods ( ) {
        Set<String> set = new LinkedHashSet<>( );
        set.add( "Ford" );
        set.add( "BMW" );
        set.add( "Koensigg" );
        set.add( "BMW" );
        set.add( "Ferrari" );
        set.add( "Chevrolet" );

        //Order is preserved
        Iterator<String> iterator = set.iterator( );
        while (iterator.hasNext( )) {
            System.out.println( iterator.next( ) );
        }


    }

    public void treeSetMethods ( ) {
        TreeSet<Integer> set = new TreeSet<>( );
        set.add( 23 );
        set.add( 11 );
        set.add( 2332 );
        set.add( 2274888 );
        set.add( 222 );
        set.add( 222 );
        set.add( 12 );
        set.add( 15 );
        set.add( 18 );
        set.add( 21 );

        set.forEach( ( n ) -> System.out.println( n ) );

        System.out.println( "\nFind the greatest element which is greater than or equal to 13 in set : " + set.ceiling( 13 ) );
        System.out.println( "\nFind the greatest element which is less than or equal to 13 in set : " + set.floor( 13 ) );
        // To get elements which are strictly less than or greater than value use higher() and lower() methods

        NavigableSet<Integer> set1 = set.descendingSet( );
        System.out.println( "\nPrint set in decending order : " );
        set.forEach( ( n ) -> System.out.println( n ) );
        set.pollFirst( );
        System.out.println( "\nRemove the first element and return it " + set );

        TreeSet<Integer> subset = new TreeSet<>( );
        subset = (TreeSet<Integer>) set.subSet( 10, 20 );
        System.out.println( "\nFind a set of elements between 10 and 20 " + subset );

    }


}
