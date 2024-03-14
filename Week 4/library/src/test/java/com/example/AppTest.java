package com.example;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.jupiter.api.*;


public class AppTest {
    private Book bookFICTION, bookHORROR, bookEPIC, book, bookNull, bookNull2;
    private Library library, libraryNull;


@BeforeEach
public void init(){
    book= new Book("Book", "Good");
    bookFICTION = new Book("FICTION", "Cool", Book.Genre.FICTION);
    bookHORROR = new Book("HORROR", "SCARY", Book.Genre.HORROR);
    bookEPIC = new Book("EPIC", "WOW", Book.Genre.EPIC);
    library = new Library("LUTLLibrary", "LPR");
    libraryNull = new Library(null, null);
    bookNull = null;
    bookNull2 = new Book(null, null);
    }

    @Test
    public void testgetTitle(){
        String expected = "HORROR";
        String expected2 = "EPIC";
        String actual = bookHORROR.getTitle();
        String actual2 = bookEPIC.getTitle();

        assertAll("Does title work?", 
        () -> assertEquals(expected, actual),
        () -> assertEquals(expected2, actual2)
        );
    }

    @Test
    public void testgetGenre(){
        String expected = Book.Genre.HORROR.toString();
        String expected2 = Book.Genre.FICTION.toString();
        String actual = bookHORROR.getGenre().toString();
        String actual2 = bookFICTION.getGenre().toString();

        assertAll("Does genre work?", 
        () -> assertEquals(expected, actual),
        () -> assertEquals(expected2, actual2)
        );
    }

    @Test
    public void testgetDescription(){
        String expected = "SCARY";
        String expected2 = "WOW";
        String actual = bookHORROR.getDescription();
        String actual2 = bookEPIC.getDescription();

        assertAll("Does description work?", 
        ()-> assertEquals(expected, actual),
        ()-> assertEquals(expected2, actual2)
        );
    }

    @Test
    public void testBookBorrowed(){
        //Boolean borrowed = true;
        //Boolean notBorrowed = false;

        bookHORROR.setBorrowed(true);

        assertAll("Testing if borrowed",
        ()-> assertTrue(bookHORROR.isBorrowed()),
        ()-> assertFalse(bookFICTION.isBorrowed())
        );
    }

    @Test
    public void testaddBook(){
        library.addBook(bookHORROR);
        library.addBook(bookNull);
        ArrayList<Book> LibraryBooksExpected = new ArrayList<>();
        ArrayList<Book> LibraryBooksActual = new ArrayList<>();
        LibraryBooksExpected.add(bookHORROR);
        LibraryBooksActual = library.getAllBooks();
        assertEquals(LibraryBooksActual, LibraryBooksExpected);
    }

    @Test
    public void testgetBookByIdx(){
        library.addBook(bookHORROR);
        Book expected = bookHORROR;
        Book actual = library.getBookByIdx(0);
        assertSame(expected, actual);
    }

    @Test
    public void testborrowBook(){
        library.addBook(bookHORROR);
        library.borrowBook(0);
        assertAll("Testing if borrowing works",
        () -> assertTrue(bookHORROR.isBorrowed()),
        () -> assertFalse(bookEPIC.isBorrowed())
        );
    }

    @Test
    public void testreturnBook(){
        library.addBook(bookHORROR);
        library.borrowBook(0);
        library.returnBook(bookHORROR);
        assertAll("Testing if returning works",
        () -> assertFalse(bookHORROR.isBorrowed()),
        () -> assertFalse(bookEPIC.isBorrowed())
        );
    }

    @Test
    public void testgetAllBooks(){
        library.addBook(bookHORROR);
        ArrayList<Book> LibraryBooksExpected = new ArrayList<>();
        ArrayList<Book> LibraryBooksActual = new ArrayList<>();
        LibraryBooksExpected.add(bookHORROR);
        LibraryBooksActual = library.getAllBooks();
        assertEquals(LibraryBooksActual, LibraryBooksExpected);
    }

    @Test
    public void testgetAvailableBooks(){
        library.addBook(bookHORROR);
        library.addBook(bookFICTION);
        library.addBook(bookEPIC);
        ArrayList<Book> LibraryBooksExpected = new ArrayList<>();
        ArrayList<Book> LibraryBooksActual = new ArrayList<>();
        library.borrowBook(0);
        library.borrowBook(1);
        LibraryBooksExpected.add(bookEPIC);
        LibraryBooksActual = library.getAvailableBooks();
        assertEquals(LibraryBooksActual, LibraryBooksExpected);
    }

    @Test
    public void testGetBooksByGenre(){
        library.addBook(bookHORROR);
        library.addBook(bookFICTION);
        library.addBook(bookEPIC);
        ArrayList<Book> LibraryBooksExpected = new ArrayList<>();
        ArrayList<Book> LibraryBooksActual = new ArrayList<>();
        LibraryBooksExpected.add(bookHORROR);
        LibraryBooksActual = library.getBooksByGenre(Book.Genre.HORROR);
        assertEquals(LibraryBooksActual, LibraryBooksExpected);
    }

    @Test
    public void testgetName(){
        String expected = "LUTLLibrary";
        String actual = library.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void testgetAddress(){
        String expected = "LPR";
        String actual = library.getAddress();
        assertEquals(expected, actual);
    }

    @Test
    public void testisOpen(){
        library.setOpen(true);
        assertTrue(library.isOpen());
    }

    @Test
    public void testisClosed(){
        library.setOpen(false);
        assertFalse(library.isOpen());
    }

}