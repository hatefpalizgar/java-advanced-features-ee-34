package com.sda.p07_abstraction_oop_principle.p09_interfaces;

import java.io.Serializable;

// Interfaces can extend(inherit) each other
// Multiple inheritance is ONLY allowed for interfaces
public interface Playable extends Loveable, Cloneable, Serializable {
    void play();
}
