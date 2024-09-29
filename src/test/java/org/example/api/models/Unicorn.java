package org.example.api.models;

public class Unicorn {
    private String name;
    private String color;

    public Unicorn(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }


    @Override
    public String toString() {
        return "Unicorn{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String toJson() {
        return "{\"name\":\"" + name + "\",\"color\":\"" + color + "\"}";
    }
}
