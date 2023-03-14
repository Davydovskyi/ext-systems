package edu.jcourse.greet;

import edu.jcourse.net.Greetable;

public class DayGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good day, " + userName;
    }
}
