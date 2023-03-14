package edu.jcourse.greet;

import edu.jcourse.net.Greetable;

public class MorningGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good morning, " + userName;
    }
}
