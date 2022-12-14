public class Musterloesung {
	// SS22
	// A
    public static int doSomething(int i) {
        if(i % 2 == 0) {
            if(i > 3)
                i--;
            //else
                i++;
        }
        return i;
    }


    // B
    public boolean checkArray(int x, int[] xs) {
        for(int v : xs) {
            if(v != x) {
                return false;
            }
        }
        return true;
    }

	// C
    public int[][] fillMatrix(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = i*j;
            }
        }
        return matrix;
    }

    // D
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
    	if(item != null && !item.isEmpty())
        	this.item = item;
    }

	// E
    // A
    // A
    // B
    // B
    // A
    // B

    // WS2122
	// A
    public int countChars(String word, char character) {
        int count = 0;
        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) == character)
                count++;
        }
        return count;
    }

    // B
    public String operators(int i) {

        // oder (i % 7 == 0 && i % 5 == 0)
        if (i % (5 * 7) == 0) {
            return "FizzBuzz";
        } else if (i % 5 == 0) {
            return "Fizz";
        } else if (i % 7 == 0) {
            return "Buzz";
        }
        return Integer.toString(i);
    }

    // C
    public double[] copy(double[] original, int from, int to) {
        double[] copy = new double[to - from + 1];
        for (int i = 0; i <= (to - from); i++) {
            copy[i] = original[from + i];
        }
        return copy;
    }

    // D
    enum Punctuation {
        COLON,
        COMMA,
        PERIOD,
        SEMICOLON
    }

    // E
    boolean query() {return true;}
    void command() {}
    
    while(query()) {
    	command();
    }

    // F
    // 41
    // 41
}