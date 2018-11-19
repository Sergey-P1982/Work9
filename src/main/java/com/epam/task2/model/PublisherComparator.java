package com.epam.task2.model;

import com.epam.task2.entity.Book;

import java.util.Comparator;

public class PublisherComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        String publisher1 = ((Book)o1).getPublisher();
        String publisher2 = ((Book)o2).getPublisher();
        return publisher1.compareTo(publisher2);
    }
}
