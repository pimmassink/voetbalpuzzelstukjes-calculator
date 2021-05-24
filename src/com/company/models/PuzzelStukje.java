package com.company.models;

import java.util.Objects;

/**
 * We representeren een stukje als een getal. Een puzzel met 30 stukjes heeft dus: Stukje 1, stukje 2, stukje 3, etc.
 */
public class PuzzelStukje {

    private int id;

    public PuzzelStukje(int id) {
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

        if (!(obj instanceof PuzzelStukje)) {
            return false;
        }

        PuzzelStukje other = (PuzzelStukje) obj;
        return other.id == this.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
