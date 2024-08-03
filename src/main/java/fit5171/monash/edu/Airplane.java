package fit5171.monash.edu;

public class Airplane
{
    private int airplaneID;
    private String airplaneModel;
    private int businessSitsNumber;
    private int economySitsNumber;
    private int crewSitsNumber;

    public Airplane(int airplaneID, String airplaneModel, int businessSitsNumber, int economySitsNumber, int crewSitsNumber)
    {
        validateRequiredField(airplaneModel);
        validateSeat(businessSitsNumber+economySitsNumber+crewSitsNumber);
        this.airplaneID=airplaneID;
        this.airplaneModel = airplaneModel;
        this.businessSitsNumber = businessSitsNumber;
        this.economySitsNumber = economySitsNumber;
        this.crewSitsNumber = crewSitsNumber;
    }

    public Airplane()
    {

    }


    private void validateRequiredField(String value)
    {
        if(value==null || value.trim().isEmpty())
        {
            throw new IllegalArgumentException("Airplane Model is required and cannot be empty.");
        }
    }

    private void validateSeat(int value)
    {
        if(value<1 || value>300)
        {
            throw new IllegalArgumentException("Number of seats must be between 1 and 300");
        }

    }

    public int getAirplaneID() {
        return airplaneID;
    }

    public void setAirplaneID(int airplaneID) {
        this.airplaneID = airplaneID;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        validateRequiredField(airplaneModel);
        this.airplaneModel = airplaneModel;
    }

    public int getBusinessSitsNumber() {
        return businessSitsNumber;
    }

    public void setBusinessSitsNumber(int businessSitsNumber) {
        validateSeat(businessSitsNumber+economySitsNumber+crewSitsNumber);
        this.businessSitsNumber = businessSitsNumber;
    }

    public int getEconomySitsNumber() {
        return economySitsNumber;
    }

    public void setEconomySitsNumber(int economySitsNumber) {
        validateSeat(businessSitsNumber+economySitsNumber+crewSitsNumber);
        this.economySitsNumber = economySitsNumber;
    }

    public int getCrewSitsNumber() {
        return crewSitsNumber;
    }

    public void setCrewSitsNumber(int crewSitsNumber) {
        validateSeat(businessSitsNumber+economySitsNumber+crewSitsNumber);
        this.crewSitsNumber = crewSitsNumber;
    }

    @Override
    public String toString()
    {
        return "Airplane{" +
                "model=" + getAirplaneModel() + '\'' +
                ", business sits=" + getBusinessSitsNumber() + '\'' +
                ", economy sits=" + getEconomySitsNumber() + '\'' +
                ", crew sits=" + getCrewSitsNumber() + '\'' +
                '}';
    }


}