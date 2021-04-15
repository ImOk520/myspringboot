package jdk;

import lombok.Data;

@Data
class Age {
    private int age;

    public Age(int age) {
        this.age = age;
    }
}