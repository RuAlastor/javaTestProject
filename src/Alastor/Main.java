package Alastor;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class CommonElementSearcher {
    private List<Integer>   _l1;
    private List<Integer>   _l2;

    public CommonElementSearcher( List<Integer> l1, List<Integer> l2 ) {
        _l1 = new ArrayList<Integer>( l1 );
        _l2 = new ArrayList<Integer>( l2 );
    }

    public void fillElements() {
        /*
        for ( int i = 0; i < 10; ++i ) { _l1.add( i + 10 ); }
        for ( int i = 0; i < 5; ++i ) {
            _l1.add( i );
            _l2.add( i );
        }
        */

        _l1.add( 11 );
        _l1.add( 13 );
        _l1.add( 14 );
        _l1.add( 15 );
        _l1.add( 6 );
        _l1.add( 7 );
        _l1.add( 8 );
        _l1.add( 9 );

        _l2.add( 21 );
        _l2.add( 121 );
        _l2.add( 221 );
        _l2.add( 63 );
        _l2.add( 7 );
        _l2.add( 8 );
        _l2.add( 9 );
    }

    public int searchElements() {
        int size1 = _l1.size(), size2 = _l2.size();
        int size_diff = size1 > size2 ? size1 - size2 : size2 - size1;

        if ( size1 > size2 ) return _searchElements( _l2.listIterator(), _l1.listIterator( size_diff ) );
        else                 return _searchElements( _l1.listIterator(), _l2.listIterator( size_diff ) );
    }

    private int  _searchElements( ListIterator< Integer > iter1, ListIterator< Integer > iter2) {
        int answer = -1;
        int i = -1;
        while ( iter1.hasNext() && iter2.hasNext() ) {
            ++i;
            if ( iter1.next() == iter2.next() ) {
                answer = i;
                break;
            }
        }

        return answer;
    }

}

public class Main {

    public static void main( String[] args ) {
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();

        CommonElementSearcher worker = new CommonElementSearcher( list1, list2 );

        worker.fillElements();
        System.out.print( worker.searchElements() );
    }

}
