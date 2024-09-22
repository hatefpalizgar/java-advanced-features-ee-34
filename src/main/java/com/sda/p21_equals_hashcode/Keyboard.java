package com.sda.p21_equals_hashcode;

import java.util.Objects;

public class Keyboard {
    private String model;

    public Keyboard(String model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Keyboard keyboard = (Keyboard) o;
        return Objects.equals(model, keyboard.model);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(model);
    }
}
