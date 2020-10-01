package http;

public class SlipResponse {
    private SlipDTo slip;

    public SlipResponse(SlipDTo slip) {
        this.slip = slip;
    }

    public SlipDTo getSlip() {
        return slip;
    }

    public void setSlip(SlipDTo slip) {
        this.slip = slip;
    }
}
