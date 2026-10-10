package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import com.google.android.material.R;

/* JADX INFO: renamed from: com.google.android.material.datepicker.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: CalendarStyle.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2232d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final C2231c f13304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final C2231c f13305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final C2231c f13306c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final C2231c f13307d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final C2231c f13308e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final C2231c f13309f;
    final C2231c g;
    final Paint h;

    C2232d(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(com.google.android.material.i.b.a(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), R.styleable.MaterialCalendar);
        this.f13304a = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayStyle, 0));
        this.g = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayInvalidStyle, 0));
        this.f13305b = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_daySelectedStyle, 0));
        this.f13306c = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListA = com.google.android.material.i.c.a(context, typedArrayObtainStyledAttributes, R.styleable.MaterialCalendar_rangeFillColor);
        this.f13307d = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearStyle, 0));
        this.f13308e = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearSelectedStyle, 0));
        this.f13309f = C2231c.a(context, typedArrayObtainStyledAttributes.getResourceId(R.styleable.MaterialCalendar_yearTodayStyle, 0));
        this.h = new Paint();
        this.h.setColor(colorStateListA.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
