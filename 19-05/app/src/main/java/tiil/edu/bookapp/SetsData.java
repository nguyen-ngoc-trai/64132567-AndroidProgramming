package tiil.edu.bookapp;

import java.util.ArrayList;

public class SetsData {
    private static ArrayList<SetsMode> allBooks = new ArrayList<>();

    public static void setAllBooks(ArrayList<SetsMode> list) {
        allBooks = list;
    }

    public static ArrayList<SetsMode> getAllBooks() {
        return allBooks;
    }
}
