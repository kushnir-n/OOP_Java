package common;

public class Position {
    
    private int x, y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float calculateDistance(Position position){
        return (float)Math.sqrt(Math.pow((position.x - this.x), 2) + Math.pow((position.y - this.y), 2));
    }
}
