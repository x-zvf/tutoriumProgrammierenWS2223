import java.util.ArrayList;

import java.util.List;

/**
 * Implements a finite sequence of numerical integer values.
 * @author Gregor Lucka
 * @version 1.0
 */
public class NumericalSequence {
    private static final String REPRESENTATION_SEPERATOR = " ";
    
    private final List<Integer> numbers = new ArrayList<Integer>();
    
    /**
     * Calculates the sum of all numbers contained in the this {@link NumericalSequence}.
     * @return the sum
     */
    public int getSum() {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
    
    /**
     * Adds an non-negative number to the end of the sequence.
     * @param number which will be inserted to the sequence's end
     * @throws IllegalArgumentException if (number < 0)
     */
    public void insertNumber(int number) {
        // implement me
    }
    
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Integer number : numbers) {
            if (builder.length() > 0)
                builder.append(REPRESENTATION_SEPERATOR);
            builder.append(number);
        }
        return builder.toString();
    }
}
 
