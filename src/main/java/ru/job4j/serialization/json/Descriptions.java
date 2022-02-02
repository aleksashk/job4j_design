package ru.job4j.serialization.json;

public class Descriptions {
    private String name;
    private long serialID;
    private String setComposition;

    public Descriptions(String name, long serialID, String setComposition) {
        this.name = name;
        this.serialID = serialID;
        this.setComposition = setComposition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSerialID() {
        return serialID;
    }

    public void setSerialID(long serialID) {
        this.serialID = serialID;
    }

    public String getSetComposition() {
        return setComposition;
    }

    public void setSetComposition(String setComposition) {
        this.setComposition = setComposition;
    }

    @Override
    public String toString() {
        return "Descriptions{"
                + "name='" + name + '\''
                + ", serialID=" + serialID
                + ", setComposition='" + setComposition + '\''
                + '}';
    }
}
