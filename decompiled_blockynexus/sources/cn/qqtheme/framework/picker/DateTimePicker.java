package cn.qqtheme.framework.picker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.qqtheme.framework.util.DateUtils;
import cn.qqtheme.framework.util.LogUtils;
import cn.qqtheme.framework.widget.WheelView;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class DateTimePicker extends WheelPicker {

    @Deprecated
    public static final int HOUR = 4;
    public static final int HOUR_12 = 4;
    public static final int HOUR_24 = 3;

    @Deprecated
    public static final int HOUR_OF_DAY = 3;
    public static final int MONTH_DAY = 2;
    public static final int NONE = -1;
    public static final int YEAR_MONTH = 1;
    public static final int YEAR_MONTH_DAY = 0;
    private int dateMode;
    private String dayLabel;
    private ArrayList<String> days;
    private int endDay;
    private int endHour;
    private int endMinute;
    private int endMonth;
    private int endYear;
    private String hourLabel;
    private ArrayList<String> hours;
    private String minuteLabel;
    private ArrayList<String> minutes;
    private String monthLabel;
    private ArrayList<String> months;
    private OnDateTimePickListener onDateTimePickListener;
    private OnWheelListener onWheelListener;
    private boolean resetWhileWheel;
    private int selectedDayIndex;
    private String selectedHour;
    private String selectedMinute;
    private int selectedMonthIndex;
    private int selectedYearIndex;
    private int startDay;
    private int startHour;
    private int startMinute;
    private int startMonth;
    private int startYear;
    private int textSize;
    private int timeMode;
    private boolean useWeight;
    private String yearLabel;
    private ArrayList<String> years;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DateMode {
    }

    protected interface OnDateTimePickListener {
    }

    @Deprecated
    public interface OnMonthDayPickListener extends OnMonthDayTimePickListener {
    }

    public interface OnMonthDayTimePickListener extends OnDateTimePickListener {
        void onDateTimePicked(String str, String str2, String str3, String str4);
    }

    public interface OnTimePickListener extends OnDateTimePickListener {
        void onDateTimePicked(String str, String str2);
    }

    public interface OnWheelListener {
        void onDayWheeled(int i, String str);

        void onHourWheeled(int i, String str);

        void onMinuteWheeled(int i, String str);

        void onMonthWheeled(int i, String str);

        void onYearWheeled(int i, String str);
    }

    public interface OnYearMonthDayTimePickListener extends OnDateTimePickListener {
        void onDateTimePicked(String str, String str2, String str3, String str4, String str5);
    }

    @Deprecated
    public interface OnYearMonthPickListener extends OnYearMonthTimePickListener {
    }

    public interface OnYearMonthTimePickListener extends OnDateTimePickListener {
        void onDateTimePicked(String str, String str2, String str3, String str4);
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface TimeMode {
    }

    public DateTimePicker(Activity activity, int i) {
        this(activity, 0, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeDayData(int i, int i2) {
        String strFillZero;
        int iCalculateDaysInMonth = DateUtils.calculateDaysInMonth(i, i2);
        if (this.resetWhileWheel) {
            strFillZero = "";
        } else {
            if (this.selectedDayIndex >= iCalculateDaysInMonth) {
                this.selectedDayIndex = iCalculateDaysInMonth - 1;
            }
            int size = this.days.size();
            int i3 = this.selectedDayIndex;
            strFillZero = size > i3 ? this.days.get(i3) : DateUtils.fillZero(Calendar.getInstance().get(5));
            LogUtils.verbose(this, "maxDays=" + iCalculateDaysInMonth + ", preSelectDay=" + strFillZero);
        }
        this.days.clear();
        if (i == this.startYear && i2 == this.startMonth && i == this.endYear && i2 == this.endMonth) {
            for (int i4 = this.startDay; i4 <= this.endDay; i4++) {
                this.days.add(DateUtils.fillZero(i4));
            }
        } else if (i == this.startYear && i2 == this.startMonth) {
            for (int i5 = this.startDay; i5 <= iCalculateDaysInMonth; i5++) {
                this.days.add(DateUtils.fillZero(i5));
            }
        } else {
            int i6 = 1;
            if (i == this.endYear && i2 == this.endMonth) {
                while (i6 <= this.endDay) {
                    this.days.add(DateUtils.fillZero(i6));
                    i6++;
                }
            } else {
                while (i6 <= iCalculateDaysInMonth) {
                    this.days.add(DateUtils.fillZero(i6));
                    i6++;
                }
            }
        }
        if (this.resetWhileWheel) {
            return;
        }
        int iIndexOf = this.days.indexOf(strFillZero);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        this.selectedDayIndex = iIndexOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMinuteData(int i) {
        this.minutes.clear();
        int i2 = this.startHour;
        int i3 = this.endHour;
        if (i2 == i3) {
            int i4 = this.startMinute;
            int i5 = this.endMinute;
            if (i4 > i5) {
                this.startMinute = i5;
                this.endMinute = i4;
            }
            for (int i6 = this.startMinute; i6 <= this.endMinute; i6++) {
                this.minutes.add(DateUtils.fillZero(i6));
            }
        } else if (i == i2) {
            for (int i7 = this.startMinute; i7 <= 59; i7++) {
                this.minutes.add(DateUtils.fillZero(i7));
            }
        } else if (i == i3) {
            for (int i8 = 0; i8 <= this.endMinute; i8++) {
                this.minutes.add(DateUtils.fillZero(i8));
            }
        } else {
            for (int i9 = 0; i9 <= 59; i9++) {
                this.minutes.add(DateUtils.fillZero(i9));
            }
        }
        if (this.minutes.indexOf(this.selectedMinute) == -1) {
            this.selectedMinute = this.minutes.get(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void changeMonthData(int i) {
        String strFillZero;
        int i2;
        int i3 = 1;
        if (this.resetWhileWheel) {
            strFillZero = "";
        } else {
            int size = this.months.size();
            int i4 = this.selectedMonthIndex;
            strFillZero = size > i4 ? this.months.get(i4) : DateUtils.fillZero(Calendar.getInstance().get(2) + 1);
            LogUtils.verbose(this, "preSelectMonth=" + strFillZero);
        }
        this.months.clear();
        int i5 = this.startMonth;
        if (i5 < 1 || (i2 = this.endMonth) < 1 || i5 > 12 || i2 > 12) {
            throw new IllegalArgumentException("Month out of range [1-12]");
        }
        int i6 = this.startYear;
        int i7 = this.endYear;
        if (i6 == i7) {
            if (i5 > i2) {
                while (i2 >= this.startMonth) {
                    this.months.add(DateUtils.fillZero(i2));
                    i2--;
                }
            } else {
                while (i5 <= this.endMonth) {
                    this.months.add(DateUtils.fillZero(i5));
                    i5++;
                }
            }
        } else if (i == i6) {
            while (i5 <= 12) {
                this.months.add(DateUtils.fillZero(i5));
                i5++;
            }
        } else if (i == i7) {
            while (i3 <= this.endMonth) {
                this.months.add(DateUtils.fillZero(i3));
                i3++;
            }
        } else {
            while (i3 <= 12) {
                this.months.add(DateUtils.fillZero(i3));
                i3++;
            }
        }
        if (this.resetWhileWheel) {
            return;
        }
        int iIndexOf = this.months.indexOf(strFillZero);
        if (iIndexOf == -1) {
            iIndexOf = 0;
        }
        this.selectedMonthIndex = iIndexOf;
    }

    private int findItemIndex(ArrayList<String> arrayList, int i) {
        int iBinarySearch = Collections.binarySearch(arrayList, Integer.valueOf(i), new Comparator<Object>() { // from class: cn.qqtheme.framework.picker.DateTimePicker.6
            @Override // java.util.Comparator
            public int compare(Object obj, Object obj2) {
                String string = obj.toString();
                String string2 = obj2.toString();
                if (string.startsWith("0")) {
                    string = string.substring(1);
                }
                if (string2.startsWith("0")) {
                    string2 = string2.substring(1);
                }
                try {
                    return Integer.parseInt(string) - Integer.parseInt(string2);
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
        });
        if (iBinarySearch >= 0) {
            return iBinarySearch;
        }
        throw new IllegalArgumentException("Item[" + i + "] out of range");
    }

    private void initHourData() {
        this.hours.clear();
        int i = !this.resetWhileWheel ? this.timeMode == 3 ? Calendar.getInstance().get(11) : Calendar.getInstance().get(10) : 0;
        for (int i2 = this.startHour; i2 <= this.endHour; i2++) {
            String strFillZero = DateUtils.fillZero(i2);
            if (!this.resetWhileWheel && i2 == i) {
                this.selectedHour = strFillZero;
            }
            this.hours.add(strFillZero);
        }
        if (this.hours.indexOf(this.selectedHour) == -1) {
            this.selectedHour = this.hours.get(0);
        }
        if (this.resetWhileWheel) {
            return;
        }
        this.selectedMinute = DateUtils.fillZero(Calendar.getInstance().get(12));
    }

    private void initYearData() {
        this.years.clear();
        int i = this.startYear;
        int i2 = this.endYear;
        if (i == i2) {
            this.years.add(String.valueOf(i));
        } else if (i < i2) {
            while (i <= this.endYear) {
                this.years.add(String.valueOf(i));
                i++;
            }
        } else {
            while (i >= this.endYear) {
                this.years.add(String.valueOf(i));
                i--;
            }
        }
        if (this.resetWhileWheel) {
            return;
        }
        int i3 = this.dateMode;
        if (i3 == 0 || i3 == 1) {
            int iIndexOf = this.years.indexOf(DateUtils.fillZero(Calendar.getInstance().get(1)));
            if (iIndexOf == -1) {
                this.selectedYearIndex = 0;
            } else {
                this.selectedYearIndex = iIndexOf;
            }
        }
    }

    public String getSelectedDay() {
        int i = this.dateMode;
        if (i != 0 && i != 2) {
            return "";
        }
        if (this.days.size() <= this.selectedDayIndex) {
            this.selectedDayIndex = this.days.size() - 1;
        }
        return this.days.get(this.selectedDayIndex);
    }

    public String getSelectedHour() {
        return this.timeMode != -1 ? this.selectedHour : "";
    }

    public String getSelectedMinute() {
        return this.timeMode != -1 ? this.selectedMinute : "";
    }

    public String getSelectedMonth() {
        if (this.dateMode == -1) {
            return "";
        }
        if (this.months.size() <= this.selectedMonthIndex) {
            this.selectedMonthIndex = this.months.size() - 1;
        }
        return this.months.get(this.selectedMonthIndex);
    }

    public String getSelectedYear() {
        int i = this.dateMode;
        if (i != 0 && i != 1) {
            return "";
        }
        if (this.years.size() <= this.selectedYearIndex) {
            this.selectedYearIndex = this.years.size() - 1;
        }
        return this.years.get(this.selectedYearIndex);
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    protected View makeCenterView() {
        int i = this.dateMode;
        if ((i == 0 || i == 1) && this.years.size() == 0) {
            LogUtils.verbose(this, "init years before make view");
            initYearData();
        }
        if (this.dateMode != -1 && this.months.size() == 0) {
            LogUtils.verbose(this, "init months before make view");
            changeMonthData(DateUtils.trimZero(getSelectedYear()));
        }
        int i2 = this.dateMode;
        if ((i2 == 0 || i2 == 2) && this.days.size() == 0) {
            LogUtils.verbose(this, "init days before make view");
            changeDayData(this.dateMode == 0 ? DateUtils.trimZero(getSelectedYear()) : Calendar.getInstance(Locale.CHINA).get(1), DateUtils.trimZero(getSelectedMonth()));
        }
        if (this.timeMode != -1 && this.hours.size() == 0) {
            LogUtils.verbose(this, "init hours before make view");
            initHourData();
        }
        if (this.timeMode != -1 && this.minutes.size() == 0) {
            LogUtils.verbose(this, "init minutes before make view");
            changeMinuteData(DateUtils.trimZero(this.selectedHour));
        }
        LinearLayout linearLayout = new LinearLayout(this.activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(17);
        WheelView wheelViewCreateWheelView = createWheelView();
        final WheelView wheelViewCreateWheelView2 = createWheelView();
        final WheelView wheelViewCreateWheelView3 = createWheelView();
        WheelView wheelViewCreateWheelView4 = createWheelView();
        final WheelView wheelViewCreateWheelView5 = createWheelView();
        wheelViewCreateWheelView.setTextSize(this.textSize);
        wheelViewCreateWheelView2.setTextSize(this.textSize);
        wheelViewCreateWheelView3.setTextSize(this.textSize);
        wheelViewCreateWheelView4.setTextSize(this.textSize);
        wheelViewCreateWheelView5.setTextSize(this.textSize);
        wheelViewCreateWheelView.setUseWeight(this.useWeight);
        wheelViewCreateWheelView2.setUseWeight(this.useWeight);
        wheelViewCreateWheelView3.setUseWeight(this.useWeight);
        wheelViewCreateWheelView4.setUseWeight(this.useWeight);
        wheelViewCreateWheelView5.setUseWeight(this.useWeight);
        int i3 = this.dateMode;
        if (i3 == 0 || i3 == 1) {
            wheelViewCreateWheelView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewCreateWheelView.setItems(this.years, this.selectedYearIndex);
            wheelViewCreateWheelView.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DateTimePicker.1
                @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
                public void onSelected(int i4) {
                    DateTimePicker.this.selectedYearIndex = i4;
                    String str = (String) DateTimePicker.this.years.get(DateTimePicker.this.selectedYearIndex);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onYearWheeled(DateTimePicker.this.selectedYearIndex, str);
                    }
                    LogUtils.verbose(this, "change months after year wheeled");
                    if (DateTimePicker.this.resetWhileWheel) {
                        DateTimePicker.this.selectedMonthIndex = 0;
                        DateTimePicker.this.selectedDayIndex = 0;
                    }
                    int iTrimZero = DateUtils.trimZero(str);
                    DateTimePicker.this.changeMonthData(iTrimZero);
                    wheelViewCreateWheelView2.setItems(DateTimePicker.this.months, DateTimePicker.this.selectedMonthIndex);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onMonthWheeled(DateTimePicker.this.selectedMonthIndex, (String) DateTimePicker.this.months.get(DateTimePicker.this.selectedMonthIndex));
                    }
                    DateTimePicker dateTimePicker = DateTimePicker.this;
                    dateTimePicker.changeDayData(iTrimZero, DateUtils.trimZero((String) dateTimePicker.months.get(DateTimePicker.this.selectedMonthIndex)));
                    wheelViewCreateWheelView3.setItems(DateTimePicker.this.days, DateTimePicker.this.selectedDayIndex);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onDayWheeled(DateTimePicker.this.selectedDayIndex, (String) DateTimePicker.this.days.get(DateTimePicker.this.selectedDayIndex));
                    }
                }
            });
            linearLayout.addView(wheelViewCreateWheelView);
            if (!TextUtils.isEmpty(this.yearLabel)) {
                TextView textViewCreateLabelView = createLabelView();
                textViewCreateLabelView.setTextSize(this.textSize);
                textViewCreateLabelView.setText(this.yearLabel);
                linearLayout.addView(textViewCreateLabelView);
            }
        }
        if (this.dateMode != -1) {
            wheelViewCreateWheelView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewCreateWheelView2.setItems(this.months, this.selectedMonthIndex);
            wheelViewCreateWheelView2.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DateTimePicker.2
                @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
                public void onSelected(int i4) {
                    DateTimePicker.this.selectedMonthIndex = i4;
                    String str = (String) DateTimePicker.this.months.get(DateTimePicker.this.selectedMonthIndex);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onMonthWheeled(DateTimePicker.this.selectedMonthIndex, str);
                    }
                    if (DateTimePicker.this.dateMode == 0 || DateTimePicker.this.dateMode == 2) {
                        LogUtils.verbose(this, "change days after month wheeled");
                        if (DateTimePicker.this.resetWhileWheel) {
                            DateTimePicker.this.selectedDayIndex = 0;
                        }
                        DateTimePicker.this.changeDayData(DateTimePicker.this.dateMode == 0 ? DateUtils.trimZero(DateTimePicker.this.getSelectedYear()) : Calendar.getInstance(Locale.CHINA).get(1), DateUtils.trimZero(str));
                        wheelViewCreateWheelView3.setItems(DateTimePicker.this.days, DateTimePicker.this.selectedDayIndex);
                        if (DateTimePicker.this.onWheelListener != null) {
                            DateTimePicker.this.onWheelListener.onDayWheeled(DateTimePicker.this.selectedDayIndex, (String) DateTimePicker.this.days.get(DateTimePicker.this.selectedDayIndex));
                        }
                    }
                }
            });
            linearLayout.addView(wheelViewCreateWheelView2);
            if (!TextUtils.isEmpty(this.monthLabel)) {
                TextView textViewCreateLabelView2 = createLabelView();
                textViewCreateLabelView2.setTextSize(this.textSize);
                textViewCreateLabelView2.setText(this.monthLabel);
                linearLayout.addView(textViewCreateLabelView2);
            }
        }
        int i4 = this.dateMode;
        if (i4 == 0 || i4 == 2) {
            wheelViewCreateWheelView3.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewCreateWheelView3.setItems(this.days, this.selectedDayIndex);
            wheelViewCreateWheelView3.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DateTimePicker.3
                @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
                public void onSelected(int i5) {
                    DateTimePicker.this.selectedDayIndex = i5;
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onDayWheeled(DateTimePicker.this.selectedDayIndex, (String) DateTimePicker.this.days.get(DateTimePicker.this.selectedDayIndex));
                    }
                }
            });
            linearLayout.addView(wheelViewCreateWheelView3);
            if (!TextUtils.isEmpty(this.dayLabel)) {
                TextView textViewCreateLabelView3 = createLabelView();
                textViewCreateLabelView3.setTextSize(this.textSize);
                textViewCreateLabelView3.setText(this.dayLabel);
                linearLayout.addView(textViewCreateLabelView3);
            }
        }
        if (this.timeMode != -1) {
            wheelViewCreateWheelView4.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewCreateWheelView4.setItems(this.hours, this.selectedHour);
            wheelViewCreateWheelView4.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DateTimePicker.4
                @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
                public void onSelected(int i5) {
                    DateTimePicker dateTimePicker = DateTimePicker.this;
                    dateTimePicker.selectedHour = (String) dateTimePicker.hours.get(i5);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onHourWheeled(i5, DateTimePicker.this.selectedHour);
                    }
                    LogUtils.verbose(this, "change minutes after hour wheeled");
                    DateTimePicker dateTimePicker2 = DateTimePicker.this;
                    dateTimePicker2.changeMinuteData(DateUtils.trimZero(dateTimePicker2.selectedHour));
                    wheelViewCreateWheelView5.setItems(DateTimePicker.this.minutes, DateTimePicker.this.selectedMinute);
                }
            });
            linearLayout.addView(wheelViewCreateWheelView4);
            if (!TextUtils.isEmpty(this.hourLabel)) {
                TextView textViewCreateLabelView4 = createLabelView();
                textViewCreateLabelView4.setTextSize(this.textSize);
                textViewCreateLabelView4.setText(this.hourLabel);
                linearLayout.addView(textViewCreateLabelView4);
            }
            wheelViewCreateWheelView5.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 1.0f));
            wheelViewCreateWheelView5.setItems(this.minutes, this.selectedMinute);
            wheelViewCreateWheelView5.setOnItemSelectListener(new WheelView.OnItemSelectListener() { // from class: cn.qqtheme.framework.picker.DateTimePicker.5
                @Override // cn.qqtheme.framework.widget.WheelView.OnItemSelectListener
                public void onSelected(int i5) {
                    DateTimePicker dateTimePicker = DateTimePicker.this;
                    dateTimePicker.selectedMinute = (String) dateTimePicker.minutes.get(i5);
                    if (DateTimePicker.this.onWheelListener != null) {
                        DateTimePicker.this.onWheelListener.onMinuteWheeled(i5, DateTimePicker.this.selectedMinute);
                    }
                }
            });
            linearLayout.addView(wheelViewCreateWheelView5);
            if (!TextUtils.isEmpty(this.minuteLabel)) {
                TextView textViewCreateLabelView5 = createLabelView();
                textViewCreateLabelView5.setTextSize(this.textSize);
                textViewCreateLabelView5.setText(this.minuteLabel);
                linearLayout.addView(textViewCreateLabelView5);
            }
        }
        return linearLayout;
    }

    @Override // cn.qqtheme.framework.popup.ConfirmPopup
    protected void onSubmit() {
        if (this.onDateTimePickListener == null) {
            return;
        }
        String selectedYear = getSelectedYear();
        String selectedMonth = getSelectedMonth();
        String selectedDay = getSelectedDay();
        String selectedHour = getSelectedHour();
        String selectedMinute = getSelectedMinute();
        int i = this.dateMode;
        if (i == -1) {
            ((OnTimePickListener) this.onDateTimePickListener).onDateTimePicked(selectedHour, selectedMinute);
            return;
        }
        if (i == 0) {
            ((OnYearMonthDayTimePickListener) this.onDateTimePickListener).onDateTimePicked(selectedYear, selectedMonth, selectedDay, selectedHour, selectedMinute);
        } else if (i == 1) {
            ((OnYearMonthTimePickListener) this.onDateTimePickListener).onDateTimePicked(selectedYear, selectedMonth, selectedHour, selectedMinute);
        } else {
            if (i != 2) {
                return;
            }
            ((OnMonthDayTimePickListener) this.onDateTimePickListener).onDateTimePicked(selectedMonth, selectedDay, selectedHour, selectedMinute);
        }
    }

    public void setDateRangeEnd(int i, int i2, int i3) {
        if (this.dateMode == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.endYear = i;
        this.endMonth = i2;
        this.endDay = i3;
        initYearData();
    }

    public void setDateRangeStart(int i, int i2, int i3) {
        if (this.dateMode == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.startYear = i;
        this.startMonth = i2;
        this.startDay = i3;
        initYearData();
    }

    public void setLabel(String str, String str2, String str3, String str4, String str5) {
        this.yearLabel = str;
        this.monthLabel = str2;
        this.dayLabel = str3;
        this.hourLabel = str4;
        this.minuteLabel = str5;
    }

    public void setOnDateTimePickListener(OnDateTimePickListener onDateTimePickListener) {
        this.onDateTimePickListener = onDateTimePickListener;
    }

    public void setOnWheelListener(OnWheelListener onWheelListener) {
        this.onWheelListener = onWheelListener;
    }

    @Deprecated
    public void setRange(int i, int i2) {
        if (this.dateMode == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        this.startYear = i;
        this.endYear = i2;
        initYearData();
    }

    public void setResetWhileWheel(boolean z) {
        this.resetWhileWheel = z;
    }

    public void setSelectedItem(int i, int i2, int i3, int i4, int i5) {
        if (this.dateMode != 0) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        LogUtils.verbose(this, "change months and days while set selected");
        changeMonthData(i);
        changeDayData(i, i2);
        this.selectedYearIndex = findItemIndex(this.years, i);
        this.selectedMonthIndex = findItemIndex(this.months, i2);
        this.selectedDayIndex = findItemIndex(this.days, i3);
        if (this.timeMode != -1) {
            this.selectedHour = DateUtils.fillZero(i4);
            this.selectedMinute = DateUtils.fillZero(i5);
        }
    }

    public void setTimeRangeEnd(int i, int i2) {
        if (this.timeMode == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i < 0 || i2 < 0 || i2 > 59;
        if (this.timeMode == 4 && (i == 0 || i > 12)) {
            z = true;
        }
        if (this.timeMode == 3 && i >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.endHour = i;
        this.endMinute = i2;
        initHourData();
    }

    public void setTimeRangeStart(int i, int i2) {
        if (this.timeMode == -1) {
            throw new IllegalArgumentException("Time mode invalid");
        }
        boolean z = i < 0 || i2 < 0 || i2 > 59;
        if (this.timeMode == 4 && (i == 0 || i > 12)) {
            z = true;
        }
        if (this.timeMode == 3 && i >= 24) {
            z = true;
        }
        if (z) {
            throw new IllegalArgumentException("Time out of range");
        }
        this.startHour = i;
        this.startMinute = i2;
        initHourData();
    }

    public void setUseWeight(boolean z) {
        this.useWeight = z;
    }

    public DateTimePicker(Activity activity, int i, int i2) {
        super(activity);
        this.years = new ArrayList<>();
        this.months = new ArrayList<>();
        this.days = new ArrayList<>();
        this.hours = new ArrayList<>();
        this.minutes = new ArrayList<>();
        this.yearLabel = "年";
        this.monthLabel = "月";
        this.dayLabel = "日";
        this.hourLabel = "时";
        this.minuteLabel = "分";
        this.selectedYearIndex = 0;
        this.selectedMonthIndex = 0;
        this.selectedDayIndex = 0;
        this.selectedHour = "";
        this.selectedMinute = "";
        this.dateMode = 0;
        this.timeMode = 3;
        this.startYear = 2010;
        this.startMonth = 1;
        this.startDay = 1;
        this.endYear = 2020;
        this.endMonth = 12;
        this.endDay = 31;
        this.startMinute = 0;
        this.endMinute = 59;
        this.textSize = 16;
        this.useWeight = false;
        this.resetWhileWheel = true;
        if (i == -1 && i2 == -1) {
            throw new IllegalArgumentException("The modes are NONE at the same time");
        }
        if (i == 0 && i2 != -1) {
            int i3 = this.screenWidthPixels;
            if (i3 < 720) {
                this.textSize = 14;
            } else if (i3 < 480) {
                this.textSize = 12;
            }
        }
        this.dateMode = i;
        if (i2 == 4) {
            this.startHour = 1;
            this.endHour = 12;
        } else {
            this.startHour = 0;
            this.endHour = 23;
        }
        this.timeMode = i2;
    }

    public void setDateRangeEnd(int i, int i2) {
        int i3 = this.dateMode;
        if (i3 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i3 != 0) {
            if (i3 == 1) {
                this.endYear = i;
                this.endMonth = i2;
            } else if (i3 == 2) {
                this.endMonth = i;
                this.endDay = i2;
            }
            initYearData();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    public void setDateRangeStart(int i, int i2) {
        int i3 = this.dateMode;
        if (i3 == -1) {
            throw new IllegalArgumentException("Date mode invalid");
        }
        if (i3 != 0) {
            if (i3 == 1) {
                this.startYear = i;
                this.startMonth = i2;
            } else if (i3 == 2) {
                int i4 = Calendar.getInstance(Locale.CHINA).get(1);
                this.endYear = i4;
                this.startYear = i4;
                this.startMonth = i;
                this.startDay = i2;
            }
            initYearData();
            return;
        }
        throw new IllegalArgumentException("Not support year/month/day mode");
    }

    public void setSelectedItem(int i, int i2, int i3, int i4) {
        int i5 = this.dateMode;
        if (i5 != 0) {
            if (i5 == 2) {
                LogUtils.verbose(this, "change months and days while set selected");
                int i6 = Calendar.getInstance(Locale.CHINA).get(1);
                this.endYear = i6;
                this.startYear = i6;
                changeMonthData(i6);
                changeDayData(i6, i);
                this.selectedMonthIndex = findItemIndex(this.months, i);
                this.selectedDayIndex = findItemIndex(this.days, i2);
            } else if (i5 == 1) {
                LogUtils.verbose(this, "change months while set selected");
                changeMonthData(i);
                this.selectedYearIndex = findItemIndex(this.years, i);
                this.selectedMonthIndex = findItemIndex(this.months, i2);
            }
            if (this.timeMode != -1) {
                this.selectedHour = DateUtils.fillZero(i3);
                this.selectedMinute = DateUtils.fillZero(i4);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Date mode invalid");
    }
}
