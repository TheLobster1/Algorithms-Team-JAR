public class StopWatch {
    private long startTime;
    private long endTime;
    private boolean isRunning;

    public StopWatch() {
        this.startTime = 0;
        this.endTime = 0;
        this.isRunning = false;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
        this.endTime = 0;
        this.isRunning = true;
    }

    public long stop() {
        this.endTime = System.currentTimeMillis();
        this.isRunning = false;
        return getElapsedTimeMillis()/1000;
    }

    public long getElapsedTimeMillis() {
        long elapsed;
        if(isRunning) {
            elapsed = (System.currentTimeMillis() - startTime);
        }
        else {
            elapsed = (endTime - startTime);
        }
        return elapsed;
    }
}
