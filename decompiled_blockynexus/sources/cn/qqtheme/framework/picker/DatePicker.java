package cn.qqtheme.framework.picker;

import android.app.Activity;
import cn.qqtheme.framework.picker.DateTimePicker;

/* JADX INFO: loaded from: classes.dex */
public class DatePicker extends DateTimePicker {

    /* JADX INFO: Access modifiers changed from: protected */
    public interface OnDatePickListener {
    }

    public interface OnMonthDayPickListener extends OnDatePickListener {
        void onDatePicked(String str, String str2);
    }

    public interface OnWheelListener {
        void onDayWheeled(int i, String str);

        void onMonthWheeled(int i, String str);

        void onYearWheeled(int i, String str);
    }

    public interface OnYearMonthDayPickListener extends OnDatePickListener {
        void onDatePicked(String str, String str2, String str3);
    }

    public interface OnYearMonthPickListener extends OnDatePickListener {
        void onDatePicked(String str, String str2);
    }

    public DatePicker(Activity activity) {
        this(activity, 0);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeEnd(int i, int i2, int i3) {
        super.setDateRangeEnd(i, i2, i3);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeStart(int i, int i2, int i3) {
        super.setDateRangeStart(i, i2, i3);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setLabel(String str, String str2, String str3, String str4, String str5) {
        super.setLabel(str, str2, str3, str4, str5);
    }

    public void setOnDatePickListener(final OnDatePickListener onDatePickListener) {
        if (onDatePickListener == null) {
            return;
        }
        if (onDatePickListener instanceof OnYearMonthDayPickListener) {
            super.setOnDateTimePickListener(new DateTimePicker.OnYearMonthDayTimePickListener() { // from class: cn.qqtheme.framework.picker.DatePicker.2
                @Override // cn.qqtheme.framework.picker.DateTimePicker.OnYearMonthDayTimePickListener
                public void onDateTimePicked(String str, String str2, String str3, String str4, String str5) {
                    ((OnYearMonthDayPickListener) onDatePickListener).onDatePicked(str, str2, str3);
                }
            });
        } else if (onDatePickListener instanceof OnYearMonthPickListener) {
            super.setOnDateTimePickListener(new DateTimePicker.OnYearMonthTimePickListener() { // from class: cn.qqtheme.framework.picker.DatePicker.3
                @Override // cn.qqtheme.framework.picker.DateTimePicker.OnYearMonthTimePickListener
                public void onDateTimePicked(String str, String str2, String str3, String str4) {
                    ((OnYearMonthPickListener) onDatePickListener).onDatePicked(str, str2);
                }
            });
        } else if (onDatePickListener instanceof OnMonthDayPickListener) {
            super.setOnDateTimePickListener(new DateTimePicker.OnMonthDayTimePickListener() { // from class: cn.qqtheme.framework.picker.DatePicker.4
                @Override // cn.qqtheme.framework.picker.DateTimePicker.OnMonthDayTimePickListener
                public void onDateTimePicked(String str, String str2, String str3, String str4) {
                    ((OnMonthDayPickListener) onDatePickListener).onDatePicked(str, str2);
                }
            });
        }
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setOnDateTimePickListener(DateTimePicker.OnDateTimePickListener onDateTimePickListener) {
        super.setOnDateTimePickListener(onDateTimePickListener);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setOnWheelListener(DateTimePicker.OnWheelListener onWheelListener) {
        super.setOnWheelListener(onWheelListener);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setRange(int i, int i2) {
        super.setRange(i, i2);
    }

    public void setRangeEnd(int i, int i2, int i3) {
        super.setDateRangeEnd(i, i2, i3);
    }

    public void setRangeStart(int i, int i2, int i3) {
        super.setDateRangeStart(i, i2, i3);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setSelectedItem(int i, int i2, int i3, int i4, int i5) {
        super.setSelectedItem(i, i2, i3, i4, i5);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setTimeRangeEnd(int i, int i2) {
        throw new UnsupportedOperationException("Time range nonsupport");
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public void setTimeRangeStart(int i, int i2) {
        throw new UnsupportedOperationException("Time range nonsupport");
    }

    public DatePicker(Activity activity, int i) {
        super(activity, i, -1);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeEnd(int i, int i2) {
        super.setDateRangeEnd(i, i2);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setDateRangeStart(int i, int i2) {
        super.setDateRangeStart(i, i2);
    }

    public void setLabel(String str, String str2, String str3) {
        super.setLabel(str, str2, str3, "", "");
    }

    public void setOnWheelListener(final OnWheelListener onWheelListener) {
        if (onWheelListener == null) {
            return;
        }
        super.setOnWheelListener(new DateTimePicker.OnWheelListener() { // from class: cn.qqtheme.framework.picker.DatePicker.1
            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onDayWheeled(int i, String str) {
                onWheelListener.onDayWheeled(i, str);
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onHourWheeled(int i, String str) {
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onMinuteWheeled(int i, String str) {
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onMonthWheeled(int i, String str) {
                onWheelListener.onMonthWheeled(i, str);
            }

            @Override // cn.qqtheme.framework.picker.DateTimePicker.OnWheelListener
            public void onYearWheeled(int i, String str) {
                onWheelListener.onYearWheeled(i, str);
            }
        });
    }

    public void setRangeEnd(int i, int i2) {
        super.setDateRangeEnd(i, i2);
    }

    public void setRangeStart(int i, int i2) {
        super.setDateRangeStart(i, i2);
    }

    @Override // cn.qqtheme.framework.picker.DateTimePicker
    @Deprecated
    public final void setSelectedItem(int i, int i2, int i3, int i4) {
        super.setSelectedItem(i, i2, i3, i4);
    }

    public void setSelectedItem(int i, int i2, int i3) {
        super.setSelectedItem(i, i2, i3, 0, 0);
    }

    public void setSelectedItem(int i, int i2) {
        super.setSelectedItem(i, i2, 0, 0);
    }
}
