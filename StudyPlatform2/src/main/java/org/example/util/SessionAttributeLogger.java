package org.example.util;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class SessionAttributeLogger implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        logAttributeEvent("Added", event);
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        logAttributeEvent("Removed", event);
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        logAttributeEvent("Replaced", event);
    }

    private void logAttributeEvent(String action, HttpSessionBindingEvent event) {
        String attributeName = event.getName();
        Object attributeValue = event.getValue();

        System.out.println(action + " attribute - Name: " + attributeName + ", Value: " + attributeValue);
    }
}
