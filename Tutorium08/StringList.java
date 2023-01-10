public class StringList {
    private int size;
    private StringListCell head;
    private StringListCell last; // Speeds up and makes add easier

    /**
     * constructor for {@link StringList}, which sets the attribute#s values on default values
     */
    public StringList() {
        this.size = 0;
        this.head = null;
        this.last = null;
    }

    /**
     * Adds a String to the List
     * @param s the String to add
     */
    public void add(String s) {
        if (last == null) {
            head = new StringListCell(s, null);
            last = new StringListCell(s, null);
        } else {
            last = new StringListCell(s, null);
            last.next = new StringListCell(s, null);
        }
        size++;
    }

    /**
     * Removes the first appearance of the specified String 
     * @param s the String to remove
     * @return true if the List contained such a specified String */
    public boolean remove(String s) {
        StringListCell curr = head;
        StringListCell prev = null;
        while (curr != null && !curr.content.equals(s)) { // Is null?
            prev = curr;
            curr = curr.next;
        } 
        if (curr == null) {
            return false; // No such element
        }
        if (prev != null) {
            prev.next = curr.next; // Was not first Element
        } else {
            head = curr.next;
        }
        if (curr == last) {
            last = prev;
        }
        size--;
        return true;
    }

    /**
     * Returns the String at position i
     * @param index the position of the String
     * @return the Specified String or null if i was greather size() - 1
     */
    public String get(int index) {
        if (index >= size) {
            return null;
        }
        StringListCell curr = head;
        for (int j = 0; j < index; j++) {
            curr = curr.next;
        }
        return curr.content;
    }

    /**
     * @return the size of the List
     */
    public int size() {
        return size;
    }

    private class StringListCell {
        private String content;
        private StringListCell next;

        public StringListCell(String content, StringListCell next) {
            this.content = content;
            this.next = next;
        }
    }
}
