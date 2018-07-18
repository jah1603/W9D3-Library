package models;

public enum Genre {

    HISTORY("History"),
    POLITICS("Politics"),
    SPORT("Sport"),
    ROMANCE("Romance"),
    TEEN("Teen");

    private final String title;

    Genre(String title) {
        this.title = title;
    }

    public String getTitleGenre() {
        return this.title;
    }



}
