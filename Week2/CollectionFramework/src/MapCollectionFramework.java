import java.util.*;

public class MapCollectionFramework {

    public void hashMapMethods ( ) {
        Map<String, Integer> si = new HashMap<>( );
        si.put( "A", 223 );
        si.put( "B", 332 );
        si.put( "C", 837 );

        Set<String> e = si.keySet( );
        for (String s : e) {
            System.out.println( "\nKey: " + s + " Value " + si.get( s ) );
        }

        Map<Integer, String> si1 = new HashMap<>( );
        si1.put( 223, "A" );
        si1.put( 332, "B" );
        si1.put( 837, "C" );

        Set<String> e1 = si.keySet( );
        for (String s : e1) {
            System.out.println( "\nKey: " + s + " Value " + si.get( s ) );
        }


    }

    public void LinkedHashMapMethods ( ) {
        Map<String , Integer> si = new LinkedHashMap<>(  );
        si.put( "A", 223 );
        si.put( "B", 332 );
        si.put( "C", 837 );

        Set<String> e = si.keySet( );
        for (String s : e) {
            System.out.println( "\nKey: " + s + " Value " + si.get( s ) );
        }

        Map<Integer, String> si1 = new HashMap<>( );
        si1.put( 223, "A" );
        si1.put( 332, "B" );
        si1.put( 837, "C" );

        Set<String> e1 = si.keySet( );
        for (String s : e1) {
            System.out.println( "\nKey: " + s + " Value " + si.get( s ) );
        }
    }


    public void treeMapMethods ( ) {
        TreeMap<String, String> mapStringString = new TreeMap<>( );
        mapStringString.put( "Ford", "Car" );
        mapStringString.put( "BMW", "Car" );
        mapStringString.put( "Apple", "Fruit" );
        mapStringString.put( "Koenigsegg", "Car" );

        System.out.println( "\nTreeMap with String, String: " + mapStringString );
        System.out.println( "Contains key 'BMW': " + mapStringString.containsKey( "BMW" ) );
        System.out.println( "Contains value 'Car': " + mapStringString.containsValue( "Car" ) );
        System.out.println( "First key: " + mapStringString.firstKey( ) );
        System.out.println( "Last key: " + mapStringString.lastKey( ) );
        System.out.println( "Remove 'Koenigsegg': " + mapStringString.remove( "Koenigsegg" ) );
        System.out.println( "After removal: " + mapStringString );

        TreeMap<Integer, String> mapIntString = new TreeMap<>( );
        mapIntString.put( 1, "One" );
        mapIntString.put( 3, "Three" );
        mapIntString.put( 2, "Two" );
        mapIntString.put( 4, "Four" );

        System.out.println( "\nTreeMap with Integer, String: " + mapIntString );
        System.out.println( "First entry: " + mapIntString.firstEntry( ) );
        System.out.println( "Last entry: " + mapIntString.lastEntry( ) );
        System.out.println( "Remove key 2: " + mapIntString.remove( 2 ) );
        System.out.println( "After removal: " + mapIntString );

        TreeMap<String, Integer> mapStringInt = new TreeMap<>( );
        mapStringInt.put( "Ford", 10 );
        mapStringInt.put( "BMW", 20 );
        mapStringInt.put( "Koenigsegg", 5 );
        mapStringInt.put( "Ferrari", 15 );

        System.out.println( "\nTreeMap with String, Integer: " + mapStringInt );
        System.out.println( "Value for key 'BMW': " + mapStringInt.get( "BMW" ) );
        System.out.println( "Remove entry 'Koenigsegg': " + mapStringInt.remove( "Koenigsegg" ) );
        System.out.println( "After removal: " + mapStringInt );

        TreeMap<Float, Integer> mapFloatInt = new TreeMap<>( );
        mapFloatInt.put( 1.1f, 100 );
        mapFloatInt.put( 3.2f, 200 );
        mapFloatInt.put( 2.5f, 150 );

        System.out.println( "\nTreeMap with Float, Integer: " + mapFloatInt );
        System.out.println( "Contains key 2.5f: " + mapFloatInt.containsKey( 2.5f ) );
        System.out.println( "Value for key 1.1f: " + mapFloatInt.get( 1.1f ) );
        System.out.println( "Remove key 3.2f: " + mapFloatInt.remove( 3.2f ) );
        System.out.println( "After removal: " + mapFloatInt );

        TreeMap<Double, Integer> mapDoubleInt = new TreeMap<>( );
        mapDoubleInt.put( 1.11, 1000 );
        mapDoubleInt.put( 2.22, 2000 );
        mapDoubleInt.put( 3.33, 3000 );

        System.out.println( "\nTreeMap with Double, Integer: " + mapDoubleInt );
        System.out.println( "Contains key 2.22: " + mapDoubleInt.containsKey( 2.22 ) );
        System.out.println( "Value for key 3.33: " + mapDoubleInt.get( 3.33 ) );
        System.out.println( "After clear operation:" );
        mapDoubleInt.clear( );
        System.out.println( "Map after clear: " + mapDoubleInt );
    }


}
