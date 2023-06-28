public class VgSales implements Comparable<VgSales>{
    private int rank;
    private String name;
    private String year;

    public VgSales(int rank, String name, String year) {
        this.rank = rank;
        this.name = name;
        this.year = year;
    }

    protected int getRank() {
        return rank;
    }

    protected void setRank(int rank) {
        this.rank = rank;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected String getYear() {
        return year;
    }

    protected void setYear(String year) {
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
