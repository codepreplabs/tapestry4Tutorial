package com.codeprep.time;

import org.apache.tapestry.IRequestCycle;
import org.apache.tapestry.event.PageBeginRenderListener;
import org.apache.tapestry.event.PageEvent;
import org.apache.tapestry.form.IPropertySelectionModel;
import org.apache.tapestry.form.StringPropertySelectionModel;
import org.apache.tapestry.html.BasePage;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Home extends BasePage implements PageBeginRenderListener {

    private static String[] FORMAT_STRINGS =
            new String[]{
                    "h:mm a",
                    "EEE, MMM d, ''yy",
                    "hh 'o''clock' a, zzzz",
                    "K:mm a, z"};

    public static final IPropertySelectionModel FORMAT_MODEL = new StringPropertySelectionModel(FORMAT_STRINGS);

    private Format timeFormat;

    public void pageBeginRender(PageEvent event) {
        if (getFormatString() == null) {
            setFormatString(FORMAT_STRINGS[0]);
        }
    }

    public Format getTimeFormat() {
        timeFormat = new SimpleDateFormat(getFormatString());
        return timeFormat;
    }

    public Date getTime() {
        return new Date();
    }

    public abstract String getFormatString();

    public abstract void setFormatString(String formatString);

    public void formSubmit(IRequestCycle cycle) {
        System.out.println("The form has been submitted!");
    }
}