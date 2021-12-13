package com.example.springtemplate.models;

public enum Rating {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);
    int rate;

    Rating(int r) {
        this.rate = r;
    }
}
