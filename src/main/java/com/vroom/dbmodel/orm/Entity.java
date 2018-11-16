package com.vroom.dbmodel.orm;

import java.io.Serializable;

public interface Entity<I> extends Serializable {

    /**
     * @return entity identity
     */
    I getId();

    /**
     * @return HashCode of entity identity
     */
    int identityHashCode();

    /**
     * @param other
     *            Other entity
     * @return true if identities of entities are equal
     */
    boolean identityEquals(Entity<?> other);
}