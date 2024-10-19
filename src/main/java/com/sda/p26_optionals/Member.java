package com.sda.p26_optionals;

import java.util.Optional;
import java.util.StringJoiner;

// It's a BAD PRACTICE to have your fields, method parameters or constructor parameters as Optional.
// Reasons:
// 1. It complicates the code structure and usage
// 2. Optional was designed to be used as the return type of methods to warn the clients of those methods on the nullability
// of the method response/return
public class Member {
    private String name;
    private Optional<String> email;

    public Member(String name, Optional<String> email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Member.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("email=" + email)
                .toString();
    }
}
