package fit5171.monash.edu;


import java.text.SimpleDateFormat;


public class Flight {
    private int flightID;
    private String departTo;
    private String departFrom;
    private String code;
    private String company;
    private String dateFrom;
    private String dateTo;
    Airplane airplane;

    public Flight(){}

    public Flight(int flight_id, String departTo, String departFrom, String code, String company, String dateFrom,String dateTo, Airplane airplane)
    {

        validateRequiredField(departTo,"Depart To");
        validateRequiredField(departFrom,"Depart From");
        validateRequiredField(code,"Code");
        validateRequiredField(company,"Company");
        validateRequiredField(dateFrom,"From Date");
        validateRequiredField(dateTo,"To Date");
        validateRequiredField(airplane);
        validateDate(dateFrom);
        validateDate(dateTo);
        this.flightID=flight_id;
        this.departTo = departTo;
        this.departFrom = departFrom;
        this.code = code;
        this.company = company;
        this.airplane = airplane;
        this.dateTo = dateTo;
        this.dateFrom = dateFrom;
    }

    public void validateRequiredField(String value,String fieldName)
    {
        if(value==null || value.trim().isEmpty())
        {
            throw new IllegalArgumentException(fieldName+" must not be empty");
        }
    }


    public void validateRequiredField(Airplane value)
    {
        if(value==null)
        {
            throw  new IllegalArgumentException("Airplane must not be empty");
        }
    }

    public void validateDate(String value)
    {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        dateFormat.setLenient(false); // This ensures strict parsing

        if(!( dateFormat.parse(value, new java.text.ParsePosition(0)) != null
                && value.length() == dateFormat.toPattern().length()))
            throw new IllegalArgumentException("Invalid date-time format");
    }

    public int getFlightID() {
        return flightID;
    }

    public void setFlightID(int flightid) {
        this.flightID = flightid;
    }

    public String getDepartTo() {
        return departTo;
    }

    public void setDepartTo(String departTo) {
        validateRequiredField(departTo,"Depart To");
        this.departTo = departTo;
    }

    public String getDepartFrom() {
        return departFrom;
    }

    public void setDepartFrom(String departFrom) {
        validateRequiredField(departFrom,"Depart From");
        this.departFrom = departFrom;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        validateRequiredField(code,"Code");
        this.code = code;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        validateRequiredField(company,"Company");
        this.company = company;
    }

    public String getDateFrom() {

        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        validateRequiredField(dateFrom,"From Date");

        validateDate(dateFrom);

        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {

        validateRequiredField(dateTo,"To Date");

        validateDate(dateTo);

        this.dateTo = dateTo;
    }

    public void setAirplane(Airplane airplane) {
        validateRequiredField(airplane);
        this.airplane = airplane;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public String toString()
    {
        return "Flight{" + airplane.toString() +
                ", date to=" +  getDateTo() + ", " + '\'' +
                ", date from='" + getDateFrom() + '\'' +
                ", depart from='" + getDepartFrom() + '\'' +
                ", depart to='" + getDepartTo() + '\'' +
                ", code=" + getCode() + '\'' +
                ", company=" + getCompany() + '\'' +
                ", code=" + getCode() + '\'' +
                '}';
    }
}
