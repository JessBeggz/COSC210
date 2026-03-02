package model;

public abstract class Exercise {
    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract String getDescription();

}
