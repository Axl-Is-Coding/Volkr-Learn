package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* JADX INFO: compiled from: MonthsPagerAdapter.java */
/* JADX INFO: loaded from: classes2.dex */
class x extends RecyclerView.a<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final C2230b f13350a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e<?> f13351b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MaterialCalendar.a f13352c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f13353d;

    /* JADX INFO: compiled from: MonthsPagerAdapter.java */
    public static class a extends RecyclerView.w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final TextView f13354a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final MaterialCalendarGridView f13355b;

        a(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.f13354a = (TextView) linearLayout.findViewById(R.id.month_title);
            ViewCompat.a((View) this.f13354a, true);
            this.f13355b = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            this.f13354a.setVisibility(8);
        }
    }

    x(Context context, e<?> eVar, C2230b c2230b, MaterialCalendar.a aVar) {
        u uVarF = c2230b.f();
        u uVarB = c2230b.b();
        u uVarE = c2230b.e();
        if (uVarF.compareTo(uVarE) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (uVarE.compareTo(uVarB) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.f13353d = (v.f13343a * MaterialCalendar.a(context)) + (p.a(context) ? MaterialCalendar.a(context) : 0);
        this.f13350a = c2230b;
        this.f13351b = eVar;
        this.f13352c = aVar;
        setHasStableIds(true);
    }

    CharSequence b(int i) {
        return a(i).b();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public int getItemCount() {
        return this.f13350a.c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public long getItemId(int i) {
        return this.f13350a.f().c(i).c();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i) {
        u uVarC = this.f13350a.f().c(i);
        aVar.f13354a.setText(uVarC.b());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) aVar.f13355b.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !uVarC.equals(materialCalendarGridView.getAdapter().f13344b)) {
            v vVar = new v(uVarC, this.f13351b, this.f13350a);
            materialCalendarGridView.setNumColumns(uVarC.f13341e);
            materialCalendarGridView.setAdapter((ListAdapter) vVar);
        } else {
            materialCalendarGridView.getAdapter().notifyDataSetChanged();
        }
        materialCalendarGridView.setOnItemClickListener(new w(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.a
    public a onCreateViewHolder(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!p.a(viewGroup.getContext())) {
            return new a(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f13353d));
        return new a(linearLayout, true);
    }

    u a(int i) {
        return this.f13350a.f().c(i);
    }

    int a(u uVar) {
        return this.f13350a.f().b(uVar);
    }
}
