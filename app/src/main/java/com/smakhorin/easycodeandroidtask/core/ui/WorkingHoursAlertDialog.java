package com.smakhorin.easycodeandroidtask.core.ui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.smakhorin.easycodeandroidtask.R;

public class WorkingHoursAlertDialog extends AlertDialog {

    private final Boolean isWithinWorkingHours;

    private final Context context;

    public WorkingHoursAlertDialog(Context context, Boolean isWithinWorkingHours) {
        super(context);
        this.isWithinWorkingHours = isWithinWorkingHours;
        this.context = context;
    }

    protected WorkingHoursAlertDialog(Context context, boolean cancelable, OnCancelListener cancelListener, Boolean isWithinWorkingHours) {
        super(context, cancelable, cancelListener);
        this.isWithinWorkingHours = isWithinWorkingHours;
        this.context = context;
    }

    protected WorkingHoursAlertDialog(Context context, int themeResId, Boolean isWithinWorkingHours) {
        super(context, themeResId);
        this.isWithinWorkingHours = isWithinWorkingHours;
        this.context = context;
    }

    public void display() {
        setTitle(context.getString(R.string.information));
        String message;
        if (isWithinWorkingHours) {
            message = context.getString(R.string.within_working_hours);
        } else {
            message = context.getString(R.string.outside_working_hours);
        }
        setMessage(message);
        setButton(BUTTON_NEUTRAL, context.getString(R.string.ok), (dialog, which) -> dismiss());
    }
}
