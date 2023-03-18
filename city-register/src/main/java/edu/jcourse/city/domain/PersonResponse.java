package edu.jcourse.city.domain;

public class PersonResponse {

    private boolean registered;
    private boolean temporal;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{registered=").append(registered);
        sb.append(", temporal=").append(temporal);
        sb.append('}');
        return sb.toString();
    }
}
