public class ArrayList {
    public int length;
    public int[] elements; //uses an underlying list

    public ArrayList() {
        length = 0;
        elements = new int[100];
    }

    public static int length(ArrayList list) { //wrapper method to find .length field that asserts non-nullity
        assert (list != null);

        return list.length;
    } //O(1)

    public static int get(ArrayList list, int position) {
        assert (list != null);
        assert (position < list.length);

        return list.elements[position];
    } //O(1)

    public static void insert(ArrayList list, int position, int element) {
        assert (list != null);
        assert (position < list.length);
        assert (list.length != list.elements.length);

        for (int i = list.length-1; i >= position; i--) { //shift all elements up
            list.elements[i+1] = list.elements[i];
        }

        list.length++;
        list.elements[position] = element;
    } // O(N)

    public static void add(ArrayList list, int element) {
        assert (list != null);
        assert (list.length !=  list.elements.length);

        list.elements[list.length] = element;
        list.length++;
    } //O(1)

    public static void remove(ArrayList list, int position) {
        assert (list != null);
        assert (position < list.length);

        for (int i = position; i < list.length; i--) { //shift all elements down
            list.elements[i] = list.elements[i+1];
        }

        list.length--;
    } //O(N)
}
