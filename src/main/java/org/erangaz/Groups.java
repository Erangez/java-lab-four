package org.erangaz;

public enum Groups {
    Creatures("Существа"),
    Guardians("Стражники"),
    Enemies("Враги");

    private final String group;

    Groups(String group){
        this.group = group;
    }

    public String getGroup(){
        return group;
    }
}
