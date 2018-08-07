/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

import java.time.*;
import java.time.temporal.*;
import java.time.format.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{

        List<DateRange> ranges = new ArrayList<> ( 3 );
        ranges.add ( new DateRange ( LocalDate.of ( 2017 , Month.JANUARY , 17 ) , LocalDate.of ( 2017 , Month.MARCH , 7 ) ) );
        ranges.add ( new DateRange ( LocalDate.of ( 2017 , Month.FEBRUARY , 12 ) , LocalDate.of ( 2017 , Month.FEBRUARY , 16 ) ) );
        ranges.add ( new DateRange ( LocalDate.of ( 2017 , Month.FEBRUARY , 14 ) , LocalDate.of ( 2017 , Month.MARCH , 25 ) ) );

        System.out.println ( "ranges: " + ranges );

        // Intersect and combine to create a sequence of new DateRange objects.
        // Collect each start & stop as individual `LocalDate` objects.
        List<LocalDate> dates = new ArrayList<> ( ranges.size () * 2 );
        for ( DateRange range : ranges ) {
            dates.add ( range.start );
            dates.add ( range.stop );
        }

        // Sort the collection of dates.
        Collections.sort ( dates );

        // Loop the sorted dates, creating DateRange objects as we go.
        List<DateRange> rangesOutput = new ArrayList<> ( dates.size () ); // Not an exact initial capacity but good enough.
        for ( int i = 1 ; i < dates.size () ; i ++ ) {
            LocalDate start = dates.get ( i - 1 ); // Subtract one for silly index counting.
            LocalDate stop = dates.get ( i + 1 - 1 ); // Subtract one for silly index counting. Or use ( i ) instead.
            if (  ! start.equals ( stop ) ) {  // If not equal, proceed. (If equal, ignore and move on to next loop.)
                DateRange range = new DateRange ( start , stop );
                rangesOutput.add ( range );
            }
        }
        System.out.println ( "rangesOutput: " + rangesOutput );

	}
}

class DateRange {

    public LocalDate start, stop;

    public DateRange ( LocalDate start , LocalDate stop ) {
        if ( stop.isBefore ( start ) ) {
            throw new IllegalArgumentException ( "The stop date is before the start date." );
        }
        this.start = start;
        this.stop = stop;
    }

    @Override
    public String toString () {
        return "DateRange{ " + "start=" + start + ", stop=" + stop + " }";
    }

}
