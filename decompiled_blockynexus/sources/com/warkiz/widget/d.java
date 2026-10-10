package com.warkiz.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

/* JADX INFO: compiled from: Indicator.java */
/* JADX INFO: loaded from: classes5.dex */
public class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrowView f21382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private TextView f21383d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private PopupWindow f21384e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private LinearLayout f21385f;
    private int g;
    private int h;
    private Context i;
    private int j;
    private IndicatorSeekBar k;
    private View l;
    private View m;
    private View n;
    private float o;
    private int p;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f21381b = new int[2];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f21380a = h();

    public d(Context context, IndicatorSeekBar indicatorSeekBar, int i, int i2, int i3, int i4, View view, View view2) {
        this.i = context;
        this.k = indicatorSeekBar;
        this.h = i;
        this.j = i2;
        this.m = view;
        this.n = view2;
        this.o = i3;
        this.p = i4;
        this.g = j.a(this.i, 2.0f);
        i();
    }

    private void a(View view, int i, int i2, int i3, int i4) {
        if (view != null && (view.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            if (i == -1) {
                i = marginLayoutParams.leftMargin;
            }
            if (i2 == -1) {
                i2 = marginLayoutParams.topMargin;
            }
            if (i3 == -1) {
                i3 = marginLayoutParams.rightMargin;
            }
            if (i4 == -1) {
                i4 = marginLayoutParams.bottomMargin;
            }
            marginLayoutParams.setMargins(i, i2, i3, i4);
            view.requestLayout();
        }
    }

    private void c(float f2) {
        int i = this.j;
        if (i == 4 || i == 1) {
            return;
        }
        if (g() + f2 < this.f21384e.getContentView().getMeasuredWidth() / 2) {
            a(this.f21382c, -((int) (((this.f21384e.getContentView().getMeasuredWidth() / 2) - r0) - f2)), -1, -1, -1);
        } else if ((this.f21380a - r0) - f2 < this.f21384e.getContentView().getMeasuredWidth() / 2) {
            a(this.f21382c, (int) ((this.f21384e.getContentView().getMeasuredWidth() / 2) - ((this.f21380a - r0) - f2)), -1, -1, -1);
        } else {
            a(this.f21382c, 0, 0, 0, 0);
        }
    }

    private GradientDrawable f() {
        GradientDrawable gradientDrawable = this.j == 2 ? (GradientDrawable) this.i.getResources().getDrawable(R.drawable.isb_indicator_rounded_corners) : (GradientDrawable) this.i.getResources().getDrawable(R.drawable.isb_indicator_square_corners);
        gradientDrawable.setColor(this.h);
        return gradientDrawable;
    }

    private int g() {
        this.k.getLocationOnScreen(this.f21381b);
        return this.f21381b[0];
    }

    private int h() {
        WindowManager windowManager = (WindowManager) this.i.getSystemService("window");
        if (windowManager != null) {
            return windowManager.getDefaultDisplay().getWidth();
        }
        return 0;
    }

    private void i() {
        View viewFindViewById;
        int i = this.j;
        if (i == 4) {
            View view = this.m;
            if (view == null) {
                throw new IllegalArgumentException("the attr：indicator_custom_layout must be set while you set the indicator type to CUSTOM.");
            }
            this.l = view;
            int identifier = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
            if (identifier <= 0 || (viewFindViewById = this.l.findViewById(identifier)) == null) {
                return;
            }
            if (!(viewFindViewById instanceof TextView)) {
                throw new ClassCastException("the view identified by isb_progress in indicator custom layout can not be cast to TextView");
            }
            this.f21383d = (TextView) viewFindViewById;
            this.f21383d.setText(this.k.getIndicatorTextString());
            this.f21383d.setTextSize(j.b(this.i, this.o));
            this.f21383d.setTextColor(this.p);
            return;
        }
        if (i == 1) {
            this.l = new CircleBubbleView(this.i, this.o, this.p, this.h, "1000");
            ((CircleBubbleView) this.l).setProgress(this.k.getIndicatorTextString());
            return;
        }
        this.l = View.inflate(this.i, R.layout.isb_indicator, null);
        this.f21385f = (LinearLayout) this.l.findViewById(R.id.indicator_container);
        this.f21382c = (ArrowView) this.l.findViewById(R.id.indicator_arrow);
        this.f21382c.setColor(this.h);
        this.f21383d = (TextView) this.l.findViewById(R.id.isb_progress);
        this.f21383d.setText(this.k.getIndicatorTextString());
        this.f21383d.setTextSize(j.b(this.i, this.o));
        this.f21383d.setTextColor(this.p);
        if (Build.VERSION.SDK_INT >= 16) {
            this.f21385f.setBackground(f());
        } else {
            this.f21385f.setBackgroundDrawable(f());
        }
        if (this.n != null) {
            int identifier2 = this.i.getResources().getIdentifier("isb_progress", "id", this.i.getApplicationContext().getPackageName());
            View view2 = this.n;
            if (identifier2 <= 0) {
                a(view2);
                return;
            }
            View viewFindViewById2 = view2.findViewById(identifier2);
            if (viewFindViewById2 == null || !(viewFindViewById2 instanceof TextView)) {
                a(view2);
            } else {
                a(view2, (TextView) viewFindViewById2);
            }
        }
    }

    void b(int i) {
        a(this.l, i, -1, -1, -1);
    }

    boolean d() {
        PopupWindow popupWindow = this.f21384e;
        return popupWindow != null && popupWindow.isShowing();
    }

    void e() {
        String indicatorTextString = this.k.getIndicatorTextString();
        View view = this.l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(indicatorTextString);
            return;
        }
        TextView textView = this.f21383d;
        if (textView != null) {
            textView.setText(indicatorTextString);
        }
    }

    void b(float f2) {
        if (this.k.isEnabled() && this.k.getVisibility() == 0) {
            e();
            PopupWindow popupWindow = this.f21384e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.f21384e.update(this.k, (int) (f2 - (r2.getContentView().getMeasuredWidth() / 2)), -(((this.k.getMeasuredHeight() + this.f21384e.getContentView().getMeasuredHeight()) - this.k.getPaddingTop()) + this.g), -1, -1);
                c(f2);
            }
        }
    }

    View a() {
        return this.l;
    }

    void a(String str) {
        View view = this.l;
        if (view instanceof CircleBubbleView) {
            ((CircleBubbleView) view).setProgress(str);
            return;
        }
        TextView textView = this.f21383d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    void c() {
        View view;
        if (this.f21384e != null || this.j == 0 || (view = this.l) == null) {
            return;
        }
        view.measure(0, 0);
        this.f21384e = new PopupWindow(this.l, -2, -2, false);
    }

    void a(int i) {
        a(this.f21382c, i, -1, -1, -1);
    }

    void b() {
        PopupWindow popupWindow = this.f21384e;
        if (popupWindow == null) {
            return;
        }
        popupWindow.dismiss();
    }

    void a(float f2) {
        if (this.k.isEnabled() && this.k.getVisibility() == 0) {
            e();
            PopupWindow popupWindow = this.f21384e;
            if (popupWindow != null) {
                popupWindow.getContentView().measure(0, 0);
                this.f21384e.showAsDropDown(this.k, (int) (f2 - (r0.getContentView().getMeasuredWidth() / 2.0f)), -(((this.k.getMeasuredHeight() + this.f21384e.getContentView().getMeasuredHeight()) - this.k.getPaddingTop()) + this.g));
                c(f2);
            }
        }
    }

    public void a(View view) {
        a(view, null);
    }

    public void a(View view, TextView textView) {
        this.f21383d = textView;
        this.f21385f.removeAllViews();
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(f());
        } else {
            view.setBackgroundDrawable(f());
        }
        this.f21385f.addView(view);
    }
}
