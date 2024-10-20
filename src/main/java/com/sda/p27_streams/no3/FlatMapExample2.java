package com.sda.p27_streams.no3;

import java.util.*;
import java.util.stream.Collectors;

public class FlatMapExample2 {
    public static void main(String[] args) {
        Developer tom = new Developer();
        tom.setName("Tom");
        tom.setId(1);
        tom.addBook("Java in Action");
        tom.addBook("Spring Boot in Action");
        tom.addBook("Effective Java (3rd Edition)");

        Developer edward = new Developer();
        edward.setName("Edward");
        edward.setId(2);
        edward.addBook("Learning Python, 4th edition");
        edward.addBook("Effective Java (3rd Edition)");

        List<Developer> list = List.of(tom, edward);
        Set<String> javaBooks = list.stream() // Stream<Developer>
                .flatMap(developer -> developer.getBooks().stream()) // Stream<String>
                .filter(book -> book.toLowerCase().contains("java")) // filter java books
                .collect(Collectors.toSet());

        System.out.println(javaBooks); // [Java in Action, Effective Java (3rd Edition)]

    }


    static class Developer {
        private Integer id;
        private String name;
        private Set<String> books;

        public void addBook(String book) {
            if (this.books == null) {
                this.books = new HashSet<>();
            }
            this.books.add(book);
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Set<String> getBooks() {
            return books;
        }

        public void setBooks(Set<String> books) {
            this.books = books;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Developer.class.getSimpleName() + "[", "]")
                    .add("id=" + id)
                    .add("name='" + name + "'")
                    .add("books=" + books)
                    .toString();
        }
    }
}
