import java.util.ArrayList;
import java.util.Arrays;

public class Array<T extends Number> {
    private final ArrayList<T> arrayList;

    public Array(ArrayList<T> arrayList) {
        this.arrayList = arrayList;
    }

    public double average() {
        if (arrayList.size() == 0) {
            return 0;
        }

        double total = 0;

        for (T element: arrayList) {
            total += element.doubleValue();
        }

        return total/arrayList.size();
    }

    public void displayAverage() {
        System.out.println("Average : " + average());
    }

    public static <T extends Number> void printArray (ArrayList<T> arrayList){
        for(T element : arrayList) {
            System.out.printf("%s ", element);
        }
        // print new line
        System.out.println();
    }

    public static void main(String []args) {
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));

        Array<Integer> integerArray = new Array<>(integerArrayList);

        System.out.println("Integer Array");
        printArray(integerArrayList);
        integerArray.displayAverage();


        ArrayList<Double> doubleArrayList = new ArrayList<Double>(Arrays.asList(1.1, 2.2, 3.3, 4.4));
        Array<Double> doubleArray = new Array<>(doubleArrayList);

        System.out.println("Double Array");
        printArray(doubleArrayList);
        doubleArray.displayAverage();
    }
}
