package com.task_2_5_21;

import java.util.Arrays;

public class Vector implements Comparable<Vector> {
    private int[] components;

    public Vector(int... d) {
        this.components = d;
    }

    public int getComponent(int idx) {
        return components[idx];
    }

    @Override
    public int compareTo(Vector v) {
        for (int i = 0; i < this.components.length; i++) {
            if (this.components[i] != v.components[i]) {
                return Integer.compare(this.components[i], v.components[i]);
            }
        }
        return 0;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(components);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && getClass() == obj.getClass()
                && Arrays.equals(components, ((Vector) obj).components));
    }

    @Override
    public String toString() {
        return Arrays.toString(components);
    }

}
