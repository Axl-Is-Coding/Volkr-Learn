package cn.qqtheme.framework.picker;

import android.app.Activity;
import cn.qqtheme.framework.picker.DateTimePicker;

/* JADX INFO: loaded from: classes.dex */
public class TimePicker extends DateTimePicker {

    public interface OnTimePickListener {
        void onTimePicked(String str, String str2);
    }

    public interface OnWheelListener {
        void onHourWheeled(int i, String str);

        void onMinuteWheeled(int i, String str);
    }

    public TimePicker(Activity activity) {
        this(activity, 3);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeEnd(int i, int i2, int i3) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeStart(int i, int i2, int i3) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setLabel(String str, String str2, String str3, String str4, String str5) {
        super.setLabel(str, str2, str3, str4, str5);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setOnDateTimePickListener(DateTimePicker.OnDateTimePickListener onDateTimePickListener) {
        super.setOnDateTimePickListener(onDateTimePickListener);
    }

    public void setOnTimePickListener(final OnTimePickListener onTimePickListener) {
        if (onTimePickListener == null) {
            return;
        }
        super.setOnDateTimePickListener(new DateTimePicker.OnTimePickListener() { // from class: cn.qqtheme.framework.picker.TimePicker.2
            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnTimePickListener
            public void onDateTimePicked(String str, String str2) {
                onTimePickListener.onTimePicked(str, str2);
            }
        });
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setOnWheelListener(DateTimePicker.OnWheelListener onWheelListener) {
        super.setOnWheelListener(onWheelListener);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setRange(int i, int i2) {
        super.setTimeRangeStart(i, 0);
        super.setTimeRangeEnd(i2, 59);
    }

    public void setRangeEnd(int i, int i2) {
        super.setTimeRangeEnd(i, i2);
    }

    public void setRangeStart(int i, int i2) {
        super.setTimeRangeStart(i, i2);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setSelectedItem(int i, int i2, int i3, int i4, int i5) {
        super.setSelectedItem(i, i2, i3, i4, i5);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setTimeRangeEnd(int i, int i2) {
        super.setTimeRangeEnd(i, i2);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setTimeRangeStart(int i, int i2) {
        super.setTimeRangeStart(i, i2);
    }

    public TimePicker(Activity activity, int i) {
        super(activity, -1, i);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeEnd(int i, int i2) {
        throw new UnsupportedOperationException("Data range nonsupport");
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeStart(int i, int i2) {
        throw new UnsupportedOperationException("Date range nonsupport");
    }

    public void setLabel(String str, String str2) {
        super.setLabel("", "", "", str, str2);
    }

    public void setOnWheelListener(final OnWheelListener onWheelListener) {
        if (onWheelListener == null) {
            return;
        }
        super.setOnWheelListener(new DateTimePicker.OnWheelListener() { // from class: cn.qqtheme.framework.picker.TimePicker.1
            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onDayWheeled(int i, String str) {
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onHourWheeled(int i, String str) {
                onWheelListener.onHourWheeled(i, str);
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onMinuteWheeled(int i, String str) {
                onWheelListener.onMinuteWheeled(i, str);
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onMonthWheeled(int i, String str) {
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onYearWheeled(int i, String str) {
            }
        });
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setSelectedItem(int i, int i2, int i3, int i4) {
        super.setSelectedItem(i, i2, i3, i4);
    }

    public void setSelectedItem(int i, int i2) {
        super.setSelectedItem(0, 0, i, i2);
    }
}
