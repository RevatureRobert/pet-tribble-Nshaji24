package model;

public class Tribble {
    private int id;
    private int weight;
    private int height;
    private String name;

    public Tribble(int id, int weight, int height, String name) {
        this.id = id;
        this.weight = weight;
        this.height = height;
        this.name = name;
    }

    public Tribble() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Tribble{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", name='" + name + '\'' +
                '}';
    }
}
