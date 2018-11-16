package com.vroom.dbmodel.orm;

import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public abstract class AbstractEntity<I> implements Entity<I> {

    @Override
    public final boolean identityEquals(Entity<?> other) {
        if (getId() == null) {
            return false;
        }
        return getId().equals(other.getId());
    }

    @Override
    public final int identityHashCode() {
        return new HashCodeBuilder().append(this.getId()).toHashCode();
    }

    @Override
    public final int hashCode() {
        return identityHashCode();
    }

    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (getClass() != o.getClass())) {
            return false;
        }

        return identityEquals((Entity<?>) o);
    }

    @Override
    public String toString() {
        // return getClass().getSimpleName() + ": " + identity();
        // OR
        return ReflectionToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}