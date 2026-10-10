package com.google.android.material.datepicker;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class g extends BaseAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f13310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Calendar f13311b = C.b();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f13312c = this.f13311b.getMaximum(7);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13313d = this.f13311b.getFirstDayOfWeek();

    static {
        f13310a = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    private int a(int i) {
        int i2 = i + this.f13313d;
        int i3 = this.f13312c;
        return i2 > i3 ? i2 - i3 : i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f13312c;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"WrongConstant"})
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        this.f13311b.set(7, a(i));
        textView.setText(this.f13311b.getDisplayName(7, f13310a, Locale.getDefault()));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R.string.mtrl_picker_day_of_week_column_header), this.f13311b.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    @Override // android.widget.Adapter
    public Integer getItem(int i) {
        if (i >= this.f13312c) {
            return null;
        }
        return Integer.valueOf(a(i));
    }
}
