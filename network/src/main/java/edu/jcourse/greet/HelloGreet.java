package edu.jcourse.greet;

import edu.jcourse.net.Greetable;

public class HelloGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Hello, " + userName;
    }
}
