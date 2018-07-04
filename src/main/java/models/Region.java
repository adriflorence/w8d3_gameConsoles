package models;

public enum Region {

    NTSC_U ("North America and South America"),
    NTSC_J ("Japan and Asia"),
    PAL ("Europe, New Zealand and Australia"),
    NTSC_C ("China");

    private final String name;

    Region(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
