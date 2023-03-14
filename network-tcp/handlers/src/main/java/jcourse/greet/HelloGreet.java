package jcourse.greet;

import jcourse.net.Greetable;

public class HelloGreet implements Greetable {
    @Override
    public String buildResponse(String userName) {
        return "Hello, " + userName;
    }
}
