package com.company.documentmanagement.model;
import java.lang.String;

public record Person(String name, String id) {
    // Record automatically generates constructor, accessors,
    // equals(), hashCode(), and toString() methods

}

