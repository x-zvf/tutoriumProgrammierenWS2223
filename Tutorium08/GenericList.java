public class GenericList<E> {
    private int size;
    private GenericListCell head;
    private GenericListCell last; // Speeds up and makes add easier

    /**
     * constructor for {@link GenericList}, which sets the attribute#s values on default values
     */
    public GenericList() {
        this.size = 0;
        this.head = null;
        this.last = null;
    }

    /**
     * Adds an object to the List
     * @param element the object to add
     */
    public void add(E element) {
        if (last == null) {
            head = last = new GenericListCell(element, null);
        } else {
            last = last.next = new GenericListCell(element, null);
        }
        size++;
    }

    /**
     * Removes the first appearance of the specified object 
     * @param element the object to remove
     * @return true if the List contained such a specified object */
    public boolean remove(E element) {
        GenericListCell curr = head;
        GenericListCell prev = null;
        while (curr != null && !curr.content.equals(element)) { // Is null?
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
     * Returns the object at position i
     * @param index the position of the object
     * @return the specified object or null if i was greater size() - 1
     */
    public E get(int index) {
        if (index >= size) {
            return null;
        }
        GenericListCell curr = head;
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

    private class GenericListCell {
        private E content;
        private GenericListCell next;

        public GenericListCell(E content, GenericListCell next) {
            this.content = content;
            this.next = next;
        }
    }
}