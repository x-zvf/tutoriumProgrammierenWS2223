package edu.kit.programming.modernjava;

import java.util.Objects;

public class FooBar {
    private String foo;
    private String bar;
    private int baz;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        // NOTE: This allows subclasses, which is not correct
        if (!(o instanceof FooBar fooBar))
            return false;

        return (baz == fooBar.baz) && Objects.equals(foo, fooBar.foo) && Objects.equals(bar, fooBar.bar);
    }

}
