package fr.syzonia.moderationtool.sanctions;

public class Reason {
    private int mode;
    private String reason;

    public Reason() {
        this.mode = 0;
        this.reason = "";
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
