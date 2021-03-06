package models;

public enum Genre {

    ARCADE("Arcade"),
    RPG("Role playing game"),
    FPS("First-person shooter"),
    ARTS("Action Real-time strategy");

    private final String description;

    Genre(String description) {
        this.description = description;
    }

}
