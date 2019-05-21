package com.namimono.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Animal {

    private Cat cat;

    @Override
    public String toString() {
        return "Animal{" +
                "cat=" + cat +
                '}';
    }

    public Cat getCat() {
        return cat;
    }
    @Autowired
    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Animal() {
    }

    public Animal(Cat cat) {
        this.cat = cat;
    }
}
