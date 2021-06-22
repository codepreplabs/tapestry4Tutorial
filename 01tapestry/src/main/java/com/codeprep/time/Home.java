package com.codeprep.time;

import org.apache.tapestry.html.BasePage;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Home extends BasePage {

    private Format timeFormat;

    public Date getTime() {
        return new Date();
    }

    public Format getTimeFormat() {
        if (timeFormat == null) {
            timeFormat = new SimpleDateFormat("h:mm a");
        }
        return timeFormat;
    }
}