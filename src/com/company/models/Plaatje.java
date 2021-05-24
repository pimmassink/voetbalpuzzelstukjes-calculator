package com.company.models;

import java.util.Objects;

/**
 * We representeren een plaatje als een getal. Een puzzel met 30 stukjes heeft dus: Plaatje 1, plaatje 2, plaatje 3, etc.
 */
public class Plaatje {

    private int id;

    public Plaatje(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Plaatje)) {
            return false;
        }

        Plaatje other = (Plaatje) obj;
        return other.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
