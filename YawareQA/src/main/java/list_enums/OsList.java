package list_enums;

public enum OsList {
    Windows("windows-download-link"),
    Linux("linux-download-link"),
    MacOS("macos-download-link");

    private String link;

    OsList(String link) {
        this.link = link;
    }

    public String getLinkForDownload() {
        return link;
    }
}
