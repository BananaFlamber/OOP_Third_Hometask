package org.example.lesson3;

import java.util.*;

public class Homework {

    public static void main(String[] args) {

        int[] source = {1, 2, 3, 4, 5, 6, 7};
        Iterator<Integer> intArrayIterator = new IntArrayIterator(source);
        while (intArrayIterator.hasNext()) {
            System.out.println(intArrayIterator.next());
        }

        List<Notebook> notebooks = new ArrayList<>();
        notebooks.add(new Notebook(8192, 14999.99));
        notebooks.add(new Notebook(8192, 15499.99));
        notebooks.add(new Notebook(16384, 20999.00));
        notebooks.add(new Notebook(16384, 21000.99));
        notebooks.add(new Notebook(32768, 25499.99));


        Comparator<Notebook> notebookComparator = new RamNotebookComparator().thenComparing(new PriceNotebookComparator());
        Collections.sort(notebooks, notebookComparator);
        System.out.println(notebooks.toString());
    }
    static class RamNotebookComparator implements Comparator<Notebook> {

        public int compare(Notebook a, Notebook b) {
            return a.getRam() - (b.getRam());
        }
    }

    static class PriceNotebookComparator implements Comparator<Notebook> {

        public int compare(Notebook a, Notebook b) {
            if (a.getPrice() > b.getPrice())
                return 1;
            else if (a.getPrice() < b.getPrice())
                return -1;
            else
                return 0;
        }
    }


    private static class Notebook {

        //        private final String name;
        private final int ram;
        private final double price;

        public Notebook(int ram, double price) {
//            this.name = name;
            this.ram = ram;
            this.price = price;

        }
        public int getRam() {
            return ram;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return  "ОЗУ:"+ ram + " Цена:" + price;
        }
    }

    private static class IntArrayIterator implements Iterator<Integer> {

        private final int[] source;

        private int cursor = 0;

        public IntArrayIterator(int[] source) {
            this.source = source;
        }

        @Override
        public boolean hasNext() {
            return cursor <= source.length - 1;
        }

        @Override
        public Integer next() {
            int nextInt = source[cursor];
            cursor++;
            return nextInt;
        }
    }

}
