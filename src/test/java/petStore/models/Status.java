package petStore.models;

public enum Status {
    PLACED("placed"),
    APPROVED("approved"),
    DELIVERED("delivered");

    private final String status;
    Status(String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
