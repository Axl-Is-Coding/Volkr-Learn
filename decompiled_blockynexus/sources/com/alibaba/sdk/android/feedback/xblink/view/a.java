package com.alibaba.sdk.android.feedback.xblink.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import cn.qqtheme.framework.widget.WheelView;
import com.alibaba.sdk.android.feedback.R;

/* JADX INFO: loaded from: classes.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f3898a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private View f3899b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private PopupWindow f3900c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private FrameLayout f3901d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private LinearLayout f3902e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Animation f3903f;
    private c g;

    public a(Context context, View view, String str, String[] strArr, View.OnClickListener onClickListener) {
        this.f3898a = context;
        this.f3899b = view;
        a(str, strArr, onClickListener);
        c();
        this.f3903f = new TranslateAnimation(2, WheelView.DividerConfig.FILL, 2, WheelView.DividerConfig.FILL, 1, 1.0f, 1, WheelView.DividerConfig.FILL);
        this.f3903f.setDuration(250L);
    }

    public a(Context context, View view, String[] strArr, View.OnClickListener onClickListener) {
        this(context, view, null, strArr, onClickListener);
    }

    private void a(String str, String[] strArr, View.OnClickListener onClickListener) {
        this.f3901d = new FrameLayout(this.f3898a);
        this.f3901d.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        this.f3902e = new LinearLayout(this.f3898a);
        this.f3902e.setOrientation(1);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 80;
        this.f3902e.setLayoutParams(layoutParams);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
        if (!TextUtils.isEmpty(str)) {
            Button button = new Button(this.f3898a);
            button.setText(str);
            button.setBackgroundColor(-657931);
            button.setTextColor(-7829368);
            button.setLayoutParams(layoutParams2);
            this.f3902e.addView(button);
            TextView textView = new TextView(this.f3898a);
            textView.setHeight(2);
            this.f3902e.addView(textView);
        }
        if (strArr != null) {
            for (String str2 : strArr) {
                Button button2 = new Button(this.f3898a);
                button2.setText(str2);
                button2.setTag(str2);
                button2.setBackgroundColor(-657931);
                button2.setTextColor(Color.rgb(28, 128, 255));
                button2.setLayoutParams(layoutParams2);
                button2.setOnClickListener(onClickListener);
                button2.setPadding(0, 30, 0, 30);
                button2.setBackgroundResource(R.drawable.ali_feedback_popup_bg);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams3.bottomMargin = 20;
                layoutParams3.leftMargin = 20;
                layoutParams3.rightMargin = 20;
                this.f3902e.addView(button2, layoutParams3);
                TextView textView2 = new TextView(this.f3898a);
                textView2.setHeight(2);
                this.f3902e.addView(textView2);
            }
        }
        this.f3901d.addView(this.f3902e);
        this.f3901d.setOnTouchListener(new b(this));
    }

    private void c() {
        this.f3900c = new PopupWindow(this.f3898a);
        this.f3900c.setContentView(this.f3901d);
        this.f3900c.setWidth(-1);
        this.f3900c.setHeight(-1);
        this.f3900c.setFocusable(true);
        this.f3900c.setOutsideTouchable(true);
        this.f3900c.setBackgroundDrawable(new ColorDrawable(2130706432));
    }

    public void a() {
        this.f3900c.showAtLocation(this.f3899b, 81, 0, 0);
        this.f3902e.startAnimation(this.f3903f);
        this.f3900c.update();
    }

    public void a(c cVar) {
        this.g = cVar;
    }

    public void b() {
        this.f3900c.dismiss();
    }
}
