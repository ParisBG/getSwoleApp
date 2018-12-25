package com.figurativefootball.howtogetswole;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Vaginal Tightener",
                    "100 Pull-Ups\n100 Push-Ups\n100 Sit-Ups\n100 Squats"),
            new Workout("Ass, Ass, Ass",
                    "500 meter run\n21 x 1.5 Squat Jumps\n21 x pull-ups"),
            new Workout("Iron Lips","5 Pull-Ups\n10 Push-Ups\n15 Squats"),
            new Workout("Titanium Titties",
                    "5 Handstand Pus-Ups\n10-1Legged Push-Ups\n15 Pull-Ups")};

    private Workout(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getDescription() { return description; }
    public String getName() {return name; }
    public String toString() { return name; }

}
