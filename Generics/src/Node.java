/**
 * Created by zemoso on 5/7/17.
 */
public class Node<P> {
    private P data;
    private Node<P> next;
    private Node<P> start = null,curr;
    private int count = 0;

    /**
     * Method to convert Slist to string.
     * @return returns the converted string.
     */
    public String toString() {
         curr = start;
        String s = "The Slist is: \n";
        while (curr != null) {
            s += curr.data + ",";
            curr = curr.next;
            //System.out.println("the string is \n"+s);
        }
        return s;
    }

    /**
     * Function to generate objects of Iterator class and upcast it to the SListIterator.
     * @return returns the Iterator object.
     */
     SListIterator<P> iterator()
    {
            return new Iterator();
    }

    /**
     * Class Iterator which contains all the method implementations for different functions to be done in Slist.
     */
    private class Iterator implements SListIterator<P>{
        /**
         * * Method overriding the method in interface
         * and works to add an element at the specified index position in a NON-EMPTY Slist.
         * @param  data gives the data to be inserted in the node
         * @param  index gives the index value where we want to insert the node.
         * @throws  IndexOutOfBoundsException gives this exception if we try to access an out of index value.
         */
        @Override
        public void add(P data, int index) throws IndexOutOfBoundsException {
            Node<P> temp = new Node<>();
                if (start==null||index >= count)
                    throw new IndexOutOfBoundsException();
                 else if (index == 0) {
                      temp.data = data;
                     temp.next = start;
                     start = temp;}
               else {
                    curr = start;
                    for (int i = 0; i <index - 1; i++)
                        curr = curr.next;
                    Node<P> temp2 = curr.next;
                    //Node<P> temp3 = new Node<>();
                    curr.next=temp;
                    temp.data = data;
                    temp.next = temp2;
                    //temp.next = temp3;
                    count++;
                }
            }

        /**
         * *This method works to add an element at the end of the linked list.
         * @param data Gives the data to be inserted in the node.
         */
        @Override
        public void add(P data) {
            Node<P> temp = new Node<>();
            if (start == null) {
                start = temp;
                temp.data = data;
                temp.next = null;
            } else {
                curr = start;
                while (curr.next != null)
                    curr = curr.next;
               // Node<P> temp2 = new Node<>();
                temp.data = data;
                temp.next = null;
                curr.next = temp;
            }
            count++;
        }

        /**
         * This method removes the node at the specified index
         * @param index Specifies the index from where to remove the element.
         * @throws IndexOutOfBoundsException gives an exception if we try to access an index which is still not generated.
         */
        @Override
        public void remove(int index) throws IndexOutOfBoundsException {
            if (index >= count)
                throw new IndexOutOfBoundsException();
            else if (index == 0) {
                start = start.next;
            } else {
                 curr = start;
                for (int i = 0; i < index - 1; i++)
                    curr = curr.next;
                Node<P> temp2 = curr.next;
                curr.next = temp2.next;
            }
            count--;
        }
    }
}

