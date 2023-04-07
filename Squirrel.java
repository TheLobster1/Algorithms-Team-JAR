public class Squirrel implements Comparable<Squirrel> {
    private String squirrelID;
    private String dateFound;
    private String color;

    public Squirrel(String squirrelID, String dateFound, String color) {
        this.squirrelID = squirrelID;
        this.dateFound = dateFound;
        this.color = color;
    }

    public String getSquirrelID() {
        return squirrelID;
    }

    public void setSquirrelID(String squirrelID) {
        this.squirrelID = squirrelID;
    }

    public String getDateFound() {
        return dateFound;
    }

    public void setDateFound(String  dateFound) {
        this.dateFound = dateFound;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public int compareTo(Squirrel o) {
        return 0;
    }
}
