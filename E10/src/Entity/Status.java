package Entity;

public enum Status {
    P("Pending"), CO("Complete"), CA("Cancel"), PA("Paid");

    private String statusLabel;

    Status(String statusLabel) {
        this.statusLabel = statusLabel;
    }

    public String getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(String statusLabel) {
        this.statusLabel = statusLabel;
    }

}
