package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: YearGridAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class D extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MaterialCalendar<?> f13274a;

    /* JADX INFO: compiled from: YearGridAdapter.java */
    public static class a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TextView f13275a;

        a(TextView textView) {
            super(textView);
            this.f13275a = textView;
        }
    }

    D(MaterialCalendar<?> materialCalendar) {
        this.f13274a = materialCalendar;
    }

    private View.OnClickListener c(final int i) {
        return new View.OnClickListener() { // from class: com.google.android.material.datepicker.YearGridAdapter$1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                this.f13291b.f13274a.a(u.a(i, this.f13291b.f13274a.i().f13339c));
                this.f13291b.f13274a.a(MaterialCalendar.CalendarSelector.DAY);
            }
        };
    }

    int b(int i) {
        return this.f13274a.g().f().f13340d + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f13274a.g().h();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        int iB = b(i);
        String string = aVar.f13275a.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        aVar.f13275a.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iB)));
        aVar.f13275a.setContentDescription(String.format(string, Integer.valueOf(iB)));
        C2232d c2232dH = this.f13274a.h();
        Calendar calendarA = C.a();
        C2231c c2231c = calendarA.get(1) == iB ? c2232dH.f13309f : c2232dH.f13307d;
        Iterator<Long> it = this.f13274a.j().B().iterator();
        while (it.hasNext()) {
            calendarA.setTimeInMillis(it.next().longValue());
            if (calendarA.get(1) == iB) {
                c2231c = c2232dH.f13308e;
            }
        }
        c2231c.a(aVar.f13275a);
        aVar.f13275a.setOnClickListener(c(iB));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new a((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }

    int a(int i) {
        return i - this.f13274a.g().f().f13340d;
    }
}
