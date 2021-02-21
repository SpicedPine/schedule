package dto.enums;

public enum EventStatus {
    PLANNED("planned"),
    DONE("done"),
    CANCELED("canceled");

    private String status;

    EventStatus(String status){
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString(){
        return status;
    }
}
