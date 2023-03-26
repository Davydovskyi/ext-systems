package edu.jcourse.register.view;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

public class MarriageResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = -5212517820009933468L;

    private boolean exists;
    private boolean active;
    private LocalDate endData;

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public LocalDate getEndData() {
        return endData;
    }

    public void setEndData(LocalDate endData) {
        this.endData = endData;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder(getClass().getSimpleName());
        sb.append("{exists=").append(exists);
        sb.append(", active=").append(active);
        sb.append(", endData=").append(endData);
        sb.append('}');
        return sb.toString();
    }
}
