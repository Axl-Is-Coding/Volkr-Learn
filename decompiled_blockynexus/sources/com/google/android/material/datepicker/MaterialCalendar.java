package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.F;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes2.dex */
public final class MaterialCalendar<S> extends z<S> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Object f13276b = "MONTHS_VIEW_GROUP_TAG";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Object f13277c = "NAVIGATION_PREV_TAG";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Object f13278d = "NAVIGATION_NEXT_TAG";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final Object f13279e = "SELECTOR_TOGGLE_TAG";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f13280f;
    private e<S> g;
    private C2230b h;
    private u i;
    private CalendarSelector j;
    private C2232d k;
    private RecyclerView l;
    private RecyclerView m;
    private View n;
    private View o;

    enum CalendarSelector {
        DAY,
        YEAR
    }

    interface a {
        void a(long j);
    }

    private RecyclerView.h m() {
        return new l(this);
    }

    C2230b g() {
        return this.h;
    }

    C2232d h() {
        return this.k;
    }

    u i() {
        return this.i;
    }

    public e<S> j() {
        return this.g;
    }

    LinearLayoutManager k() {
        return (LinearLayoutManager) this.m.getLayoutManager();
    }

    void l() {
        CalendarSelector calendarSelector = this.j;
        if (calendarSelector == CalendarSelector.YEAR) {
            a(CalendarSelector.DAY);
        } else if (calendarSelector == CalendarSelector.DAY) {
            a(CalendarSelector.YEAR);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f13280f = bundle.getInt("THEME_RES_ID_KEY");
        this.g = (e) bundle.getParcelable("GRID_SELECTOR_KEY");
        this.h = (C2230b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.i = (u) bundle.getParcelable("CURRENT_MONTH_KEY");
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getContext(), this.f13280f);
        this.k = new C2232d(contextThemeWrapper);
        LayoutInflater layoutInflaterCloneInContext = layoutInflater.cloneInContext(contextThemeWrapper);
        u uVarF = this.h.f();
        if (p.a(contextThemeWrapper)) {
            i = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View viewInflate = layoutInflaterCloneInContext.inflate(i, viewGroup, false);
        GridView gridView = (GridView) viewInflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.a(gridView, new i(this));
        gridView.setAdapter((ListAdapter) new g());
        gridView.setNumColumns(uVarF.f13341e);
        gridView.setEnabled(false);
        this.m = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_months);
        this.m.setLayoutManager(new j(this, getContext(), i2, false, i2));
        this.m.setTag(f13276b);
        x xVar = new x(contextThemeWrapper, this.g, this.h, new k(this));
        this.m.setAdapter(xVar);
        int integer = contextThemeWrapper.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        this.l = (RecyclerView) viewInflate.findViewById(R.id.mtrl_calendar_year_selector_frame);
        RecyclerView recyclerView = this.l;
        if (recyclerView != null) {
            recyclerView.setHasFixedSize(true);
            this.l.setLayoutManager(new GridLayoutManager((Context) contextThemeWrapper, integer, 1, false));
            this.l.setAdapter(new D(this));
            this.l.addItemDecoration(m());
        }
        if (viewInflate.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            a(viewInflate, xVar);
        }
        if (!p.a(contextThemeWrapper)) {
            new F().a(this.m);
        }
        this.m.scrollToPosition(xVar.a(this.i));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f13280f);
        bundle.putParcelable("GRID_SELECTOR_KEY", this.g);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.h);
        bundle.putParcelable("CURRENT_MONTH_KEY", this.i);
    }

    static <T> MaterialCalendar<T> a(e<T> eVar, int i, C2230b c2230b) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("GRID_SELECTOR_KEY", eVar);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c2230b);
        bundle.putParcelable("CURRENT_MONTH_KEY", c2230b.e());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    void a(u uVar) {
        x xVar = (x) this.m.getAdapter();
        int iA = xVar.a(uVar);
        int iA2 = iA - xVar.a(this.i);
        boolean z = Math.abs(iA2) > 3;
        boolean z2 = iA2 > 0;
        this.i = uVar;
        if (z && z2) {
            this.m.scrollToPosition(iA - 3);
            a(iA);
        } else if (z) {
            this.m.scrollToPosition(iA + 3);
            a(iA);
        } else {
            a(iA);
        }
    }

    static int a(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    void a(CalendarSelector calendarSelector) {
        this.j = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.l.getLayoutManager().scrollToPosition(((D) this.l.getAdapter()).a(this.i.f13340d));
            this.n.setVisibility(0);
            this.o.setVisibility(8);
        } else if (calendarSelector == CalendarSelector.DAY) {
            this.n.setVisibility(8);
            this.o.setVisibility(0);
            a(this.i);
        }
    }

    private void a(View view, final x xVar) {
        MaterialButton materialButton = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        materialButton.setTag(f13279e);
        ViewCompat.a(materialButton, new m(this));
        MaterialButton materialButton2 = (MaterialButton) view.findViewById(R.id.month_navigation_previous);
        materialButton2.setTag(f13277c);
        MaterialButton materialButton3 = (MaterialButton) view.findViewById(R.id.month_navigation_next);
        materialButton3.setTag(f13278d);
        this.n = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.o = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        a(CalendarSelector.DAY);
        materialButton.setText(this.i.b());
        this.m.addOnScrollListener(new n(this, xVar, materialButton));
        materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                MaterialCalendar.this.l();
            }
        });
        materialButton3.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iFindFirstVisibleItemPosition = MaterialCalendar.this.k().findFirstVisibleItemPosition() + 1;
                if (iFindFirstVisibleItemPosition < MaterialCalendar.this.m.getAdapter().getItemCount()) {
                    MaterialCalendar.this.a(xVar.a(iFindFirstVisibleItemPosition));
                }
            }
        });
        materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.google.android.material.datepicker.MaterialCalendar.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                int iFindLastVisibleItemPosition = MaterialCalendar.this.k().findLastVisibleItemPosition() - 1;
                if (iFindLastVisibleItemPosition >= 0) {
                    MaterialCalendar.this.a(xVar.a(iFindLastVisibleItemPosition));
                }
            }
        });
    }

    private void a(int i) {
        this.m.post(new h(this, i));
    }
}
