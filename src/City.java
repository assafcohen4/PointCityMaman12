public class City {
    private String _cityName;
    private Point _cityCenter;
    private Point _centralStation;
    private long _numOfResidents;
    private int _noOfNeighborhoods;

    /**
     * creates a new City object
     * @param cityName name of the city
     * @param cityCenter a Point that represents the center of the city
     * @param centralStation a Point that represents the central station of the city
     * @param numOfResidents number of residents of the city
     * @param noOfNeighborhoods number of neighborhoods in the city
     */
    public City(String cityName, Point cityCenter, Point centralStation, long numOfResidents, int noOfNeighborhoods){
        this._cityName = cityName;
        this._cityCenter = cityCenter;
        this._centralStation = centralStation;
        if (numOfResidents >= 0) {
            this._numOfResidents = numOfResidents;
        } else {
            this._numOfResidents = 0;
        }
        if(noOfNeighborhoods >= 1)
        this._noOfNeighborhoods = noOfNeighborhoods;
        else{
            this._noOfNeighborhoods = 0;
        }
    }

    /**
     * Copy constructor
     * @param city city to be copied
     *
     */
    public City(City city){
        this._cityName = city._cityName;
        this._cityCenter = city._cityCenter;
        this._centralStation = city._centralStation;
        this._numOfResidents = city._numOfResidents;
        this._noOfNeighborhoods = city._noOfNeighborhoods;
    }

    /** gets the city name*/
    public String getCityName(){
        return this._cityName;
    }
    /** gets the city centre*/
    public Point getCityCenter(){
        return this._cityCenter;
    }
    /** gets the central station*/
    public Point getCentralStation(){
        return this._centralStation;
    }
    /** gets the number of residents*/
    long getNumOfResidents(){
        return this._numOfResidents;
    }
    /** gets the number of neighborhoods*/
    int getNoOfNeighborhoods(){
        return this._noOfNeighborhoods;
    }

    /** sets the city value
     * @param cityName name to be given
     */
    void setCityName(String cityName){
        this._cityName = cityName;
    }

    /** sets the city value
     * @param cityCenter value to be set
     */
    void setCityCenter(Point cityCenter){
        this._cityCenter = cityCenter;
    }

    /** sets the central station
     * @param centralStation value to be set
     */
    void setCentralStation(Point centralStation){
        this._centralStation = centralStation;
    }

    /** sets the city value
     * @param numOfResidents value to be set
     */
    void setNumOfResidents(long numOfResidents){
        this._numOfResidents = numOfResidents;
    }
    /** sets the number of neigborhoods
     * @param noOfNeighborhoods value to be set
     */
    void setNoOfNeighborhoods(int noOfNeighborhoods){
        this._noOfNeighborhoods = noOfNeighborhoods;
    }

    /**
     * @return String that represents the city in the
     * following format City Name, City Center,
     * Central Station, Number of Residents, Number of Neighborhoods
     */
    public String toString() {
       String format = "City Name: " + this.getCityName() + "\n"
               + "City Center: " + this.getCityCenter() + "\n"
               + "Central Station: " + this.getCentralStation() + "\n"
               + "Number of Residents: " + this.getNumOfResidents() + "\n"
               + "Number of Neighborhoods" + this.getNoOfNeighborhoods();

       return format;
    }

    /**
     * @param residentsUpdate  adds or removes residents from the city
     * @return true if number of residents was updated, else false
     */
    public boolean addResidents(long residentsUpdate){
        long newNumberOfresidents = this.getNumOfResidents() + residentsUpdate;
        if(newNumberOfresidents >= 0){
            this.setNumOfResidents(newNumberOfresidents);
            return true;
        }
        this.setNumOfResidents(0);
        return false;
    }

    public void moveCentralStation(double deltaX, double deltaY){
        Point newStationLocation = new Point(this.getCentralStation().getX() + deltaX, this.getCentralStation().getY() + deltaY);

        if(!(newStationLocation.getX() < 0 || newStationLocation.getY() < 0)) {
            this.setCentralStation(newStationLocation);
        }
    }

    public double distanceBetweenCenterAndStation(){
         return this.getCityCenter().distance(this.getCentralStation());
    }

    public City newCity(String name, double dX, double dY){

        Point newCityCenter = new Point(dX,dY);
        if(dX < 0 || dY < 0){
            newCityCenter = new Point(this.getCityCenter());
        }

        double newXCetralStation = this.getCentralStation().getX() + dX;
        double newYCetralStation = this.getCentralStation().getX() + dY;
        Point newCentralStation = new Point(newXCetralStation, newYCetralStation);

        if(newXCetralStation < 0 || newYCetralStation < 0){
            newCentralStation = new Point(this.getCentralStation());
        }

        City newCity = new City(name, newCityCenter, newCentralStation,0,1);
        return newCity;
    }
}
