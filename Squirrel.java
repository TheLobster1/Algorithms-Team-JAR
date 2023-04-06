public class Squirrel {
    private int age;
    private String primary_fur_color;
    private String location;

    public Squirrel(int age, String primary_fur_color, String location) {
        this.age = age;
        this.primary_fur_color = primary_fur_color;
        this.location = location;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPrimary_fur_color() {
        return primary_fur_color;
    }

    public void setPrimary_fur_color(String primary_fur_color) {
        this.primary_fur_color = primary_fur_color;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
