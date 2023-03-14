package edu.jcourse.greet;

import edu.jcourse.net.Greetable;

public class EveningGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Good evening, " + userName;
    }
}
