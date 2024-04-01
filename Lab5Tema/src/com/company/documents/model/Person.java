package com.company.documents.model;

import java.util.Objects;

public record Person(String id, String name) {
    // Record automatically generates constructor, accessors, equals(), hashCode(), and toString() methods
}
