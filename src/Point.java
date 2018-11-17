/**
 * Class represents a point in two dimensional space and defines method that
 * determine the spacial relation between two points in space
 * @author Assaf Cohen
 *
 */

public class Point {

    private double _radius;

    /**In Radians*/
    private double _alpha;

    //constructors:
    /**
     * creates a new Point object
     * @param x vertical position of the point on a cartesian grid
     * @param y horizontal position of the point on a cartesian grid
     */

    public Point(double x, double y){
        if(x >= 0 && y >= 0){
           this._radius = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
           this._alpha = Math.atan(y/x);
        }
        else {
            this._radius = 0;
            this._alpha = 0;
        }

    }

    /**
     * Copy constructor
     * @param other point to be copied
     *
     */
    public Point(Point other){
        this._radius = other._radius;
        this._alpha = other._alpha;
    }

    private double toDegrees(double radians){
        return radians * (180/Math.PI);
    }

    private double toRadians(double degrees){
        return degrees * (Math.PI/180);
    }

    /** gets x value of point  */
    public double getX(){
        return _radius * Math.cos(_alpha);
    }

    /** gets y value of point  */
    public double getY(){
        return _radius * (Math.sin(_alpha));
    }

    /** sets x value
     * @param num the value to be set
     */
    public void setX(double num){

        if(num>= 0){
          this._radius = Math.sqrt(Math.pow(num,2) + Math.pow(this.getY(),2));
          this._alpha = Math.acos(num/this._radius) ;
        }
    }

    /** sets y value
     * @param num the value to be set
     */
    public void setY(double num){
        if(num>= 0){
            this._radius = Math.sqrt(Math.pow(num,2) + Math.pow(this.getX(),2));
            this._alpha = Math.asin(num/this._radius);
        }
    }

    /**
     * @return String that represents the point
     * in the following format:
     * (x-value, y-value)
     */
    public String toString(){
        return "(" + this.getX() + "," + this.getY() + ")";
    }

    /**
     * checks if the point's properties are the same as that of the point given as parameter
     * @param other point to be equated against
     * @retun true iff the point and the parameter have the same property values
     */
    public boolean equals(Point other){
        return this._radius == other._radius && this._alpha == other._alpha;
    }

    /**
     * checks if the point is above the parameter point on a cartesian grid
     * @param other point to be evaluated against
     * @retun true iff the point is above the parameter point
     */
    public boolean isAbove(Point other){
        return this.getY() > other.getY();
    }

    /**
     * checks if the point is under the parameter point on a cartesian grid
     * @param other point to be evaluated against
     * @retun true iff the point is under the parameter point
     */
    public boolean isUnder(Point other){
        return !this.isAbove(other) && this.getY() != other.getY() ;
    }

    /**
     * checks if the point is to the left of the parameter point on a cartesian grid
     * @param other point to be evaluated against
     * @retun true iff the point is to the left of the parameter point
     */
    public boolean isLeft(Point other){
        return this.getX() < other.getX();
    }

    /**
     * checks if the point is to the right of the parameter point on a cartesian grid
     * @param other point to be evaluated against
     * @retun true iff the point is to the right of the parameter point
     */
    public boolean isRight(Point other){
        return !isLeft(other) && this.getX() != other.getX();
    }

    /**
     * checks the distance between two points
     * @param p point to be evaluated against
     * @retun the distance between the two points
     */
    public double distance(Point p){
        return Math.sqrt(Math.pow(p.getY() - this.getY(),2)+ Math.pow((p.getX() - this.getX()),2));
    }

    /**
     * checks the distance between two points
     * @param dx distance by which the point would move on the x axis
     * @param dy distance by which the point would move on the y axis
     */
    public void move(double dx, double dy){
        if(!(this.getX() + dx < 0 || this.getY()+ dy < 0)) {
            this.setX(this.getX() + dx);
            this.setY(this.getY() + dy);
        }
    }
}
