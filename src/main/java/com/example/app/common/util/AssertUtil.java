package com.example.app.common.util;

import com.example.app.common.exception.AssertException;
import com.example.app.common.exception.AssertException.Type;
import java.util.Collection;
import java.util.Objects;
import java.util.function.Supplier;

public class AssertUtil {
    public static final void isTrue(boolean expression, CharSequence message) {
        if (!expression) {
            throw new AssertException(Type.IS_TRUE, Objects.toString(message, (String)null));
        }
    }

    public static final void isTrue(boolean expression, Supplier<CharSequence> message) {
        if (!expression) {
            throw new AssertException(Type.IS_TRUE, ((CharSequence)message.get()).toString());
        }
    }

    public static final void isFalse(boolean expression, CharSequence message) {
        if (expression) {
            throw new AssertException(Type.IS_FALSE, Objects.toString(message, (String)null));
        }
    }

    public static final void isFalse(boolean expression, Supplier<CharSequence> message) {
        if (expression) {
            throw new AssertException(Type.IS_FALSE, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void isNull(Object object, CharSequence message) {
        if (Objects.nonNull(object)) {
            throw new AssertException(Type.IS_NULL, Objects.toString(message, (String)null));
        }
    }

    public static final void isNull(Object object, Supplier<CharSequence> message) {
        if (Objects.nonNull(object)) {
            throw new AssertException(Type.IS_NULL, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void notNull(Object object, CharSequence message) {
        if (Objects.isNull(object)) {
            throw new AssertException(Type.NOT_NULL, Objects.toString(message, (String)null));
        }
    }

    public static final void notNull(Object object, Supplier<CharSequence> message) {
        if (Objects.isNull(object)) {
            throw new AssertException(Type.NOT_NULL, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void notEmpty(Collection collection, CharSequence message) {
        if (isEmptyCollection(collection)) {
            throw new AssertException(Type.NOT_EMPTY, Objects.toString(message, (String)null));
        }
    }

    public static final void notEmpty(Collection collection, Supplier<CharSequence> message) {
        if (isEmptyCollection(collection)) {
            throw new AssertException(Type.NOT_EMPTY, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void notBlank(CharSequence value, CharSequence message) {
        if (isBlankCharSequence(value)) {
            throw new AssertException(Type.NOT_BLANK, Objects.toString(message, (String)null));
        }
    }

    public static final void notBlank(CharSequence value, Supplier<CharSequence> message) {
        if (isBlankCharSequence(value)) {
            throw new AssertException(Type.NOT_BLANK, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void status(boolean expression, CharSequence message) {
        if (!expression) {
            throw new AssertException(Type.STATUS, Objects.toString(message, (String)null));
        }
    }

    public static final void status(boolean expression, Supplier<CharSequence> message) {
        if (!expression) {
            throw new AssertException(Type.STATUS, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void isMatch(boolean expression, CharSequence message) {
        if (!expression) {
            throw new AssertException(Type.IS_MATCH, Objects.toString(message, (String)null));
        }
    }

    public static final void isMatch(boolean expression, Supplier<CharSequence> message) {
        if (!expression) {
            throw new AssertException(Type.IS_MATCH, Objects.toString(message.get(), (String)null));
        }
    }

    public static final void force(CharSequence message) {
        throw new AssertException(Type.FORCE, Objects.toString(message, (String)null));
    }

    public static final void notSupport(boolean expression, CharSequence message) {
        if (!expression) {
            throw new AssertException(Type.NOT_SUPPORT, Objects.toString(message, (String)null));
        }
    }

    public static final void notSupport(boolean expression, Supplier<CharSequence> message) {
        if (!expression) {
            throw new AssertException(Type.NOT_SUPPORT, Objects.toString(message.get(), (String)null));
        }
    }

    private static final boolean isEmptyCollection(Collection collection) {
        return Objects.isNull(collection) || collection.isEmpty();
    }

    private static final boolean isBlankCharSequence(CharSequence value) {
        return Objects.isNull(value) || value.length() == 0 || value.chars().allMatch(Character::isWhitespace);
    }

    private AssertUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
}
