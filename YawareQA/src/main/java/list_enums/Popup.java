package list_enums;

public enum Popup {
    SuccessInvitation("//div[@class='toast toast-success']"),
    Error(""),
    Ready("//div[@class='toast toast-success']"),
    Copied("");

    private String popup;

    Popup(String popup) {
        this.popup = popup;
    }

    public String getPopup() {
        return popup;
    }
}
