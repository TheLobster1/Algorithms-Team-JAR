public class VgSales implements Comparable<VgSales>{
    private String rank;
    private String name;
    private String year;

    public VgSales(String rank, String name, String year) {
        this.rank = rank;
        this.name = name;
        this.year = year;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public int compareTo(VgSales o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Rank: " + rank + ", Name: " + name + ", Year: " + year;
    }
}
