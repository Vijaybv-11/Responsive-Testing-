package layout;

public enum LayoutOptions {
    ABOVE("above"),
    RIGHT("right"),
    LEFT("left"),
    BELOW("below"),
    INSIDE("inside"),
    BOTTOM_INSIDE("bottom inside"),
    LEFT_INSIDE("left inside"),
    RIGHT_INSIDE("right inside"),
    HEIGHT("height"),
    WIDTH("width"),
    ALIGNED_HORIZONTALLY_TOP("aligned horizontally top"),
    ALIGNED_HORIZONTALLY_BOTTOM("aligned horizontally bottom"),
    ALIGNED_HORIZONTALLY_CENTERED("aligned horizontally centered"),
    ALIGNED_HORIZONTALLY_ALL("aligned horizontally all"),
    ALIGNED_VERTICALLY_LEFT("aligned vertically left"),
    ALIGNED_VERTICALLY_RIGHT("aligned vertically right"),
    ALIGNED_VERTICALLY_CENTERED("aligned vertically centered"),
    ALIGNED_VERTICALLY_ALL("aligned vertically all"),
    TOP_INSIDE("top inside");

    private final String name;

    LayoutOptions(String s) {
        name = s;
    }

    public String toString() {
        return this.name;
    }
}
