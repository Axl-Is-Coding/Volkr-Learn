package com.tencent.tp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: classes5.dex */
public class n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f19710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f19711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f19712d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f19713e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a f19714f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    AlertDialog f19709a = null;
    private DialogInterface.OnDismissListener g = new o(this);

    public interface a {
        void a(int i);
    }

    public n(Context context, String str, String str2, String str3, a aVar) {
        this.f19710b = context;
        this.f19712d = str;
        this.f19711c = str2;
        this.f19713e = str3;
        this.f19714f = aVar;
    }

    private int a(Context context, int i) {
        return (int) ((i * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private Drawable a(Context context, String str, boolean z) {
        PackageManager packageManager = context.getPackageManager();
        try {
            Drawable drawableLoadIcon = packageManager.getPackageInfo(str, 0).applicationInfo.loadIcon(packageManager);
            if (z) {
                a(context, drawableLoadIcon);
            }
            return drawableLoadIcon;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    private void a(Context context, Drawable drawable) {
        if (drawable != null) {
            int iA = a(context, 36);
            drawable.setBounds(0, 0, iA, iA);
        }
    }

    private void a(TextView textView) {
        int iA = a(this.f19710b, 10);
        int iA2 = a(this.f19710b, 6);
        int iA3 = a(this.f19710b, 10);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setTextSize(2, 18.0f);
        textView.setBackgroundColor(Color.parseColor("#000000"));
        textView.setPadding(iA, iA2, iA, iA3);
    }

    private View d() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        int iA = a(this.f19710b, 10);
        int i = iA / 2;
        layoutParams.setMargins(iA, i, iA, i);
        LinearLayout linearLayout = new LinearLayout(this.f19710b);
        linearLayout.setLayoutParams(layoutParams);
        linearLayout.setOrientation(1);
        linearLayout.addView(e());
        linearLayout.addView(f());
        return linearLayout;
    }

    private TextView e() {
        String str;
        ViewGroup.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.f19710b);
        textView.setLayoutParams(layoutParams);
        textView.setText(this.f19712d);
        textView.setGravity(17);
        a(textView);
        String[] strArrSplit = this.f19712d.split(":");
        if (strArrSplit != null && strArrSplit.length == 3) {
            Drawable drawableA = a(this.f19710b, strArrSplit[1], true);
            if (drawableA != null) {
                textView.setCompoundDrawables(drawableA, null, null, null);
                str = "  " + strArrSplit[2];
            } else {
                str = strArrSplit[2];
            }
            textView.setText(str);
        }
        return textView;
    }

    private TextView f() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        TextView textView = new TextView(this.f19710b);
        textView.setLayoutParams(layoutParams);
        textView.setText(this.f19711c);
        a(textView);
        return textView;
    }

    public void a() {
        View viewD;
        AlertDialog.Builder builder = Build.VERSION.SDK_INT >= 11 ? new AlertDialog.Builder(this.f19710b, 1) : new AlertDialog.Builder(this.f19710b);
        builder.setCancelable(false);
        String str = this.f19712d;
        if (str == null || !str.startsWith("ICON:")) {
            TextView textView = new TextView(this.f19710b);
            textView.setText(this.f19711c);
            a(textView);
            viewD = textView;
        } else {
            viewD = d();
        }
        builder.setView(viewD);
        builder.setNeutralButton(this.f19713e, (DialogInterface.OnClickListener) null);
        this.f19709a = builder.create();
        this.f19709a.setOnDismissListener(this.g);
        this.f19709a.setOnShowListener(new p(this));
        this.f19709a.show();
        b();
    }

    protected void b() {
        AlertDialog alertDialog;
        float f2;
        float f3;
        if (this.f19710b == null || (alertDialog = this.f19709a) == null) {
            return;
        }
        WindowManager.LayoutParams attributes = alertDialog.getWindow().getAttributes();
        Display defaultDisplay = ((WindowManager) this.f19710b.getSystemService(q.a("rdiyjr"))).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        int i = point.y;
        int i2 = point.x;
        if (i > i2) {
            f2 = i2;
            f3 = 0.9f;
        } else {
            f2 = i2;
            f3 = 0.6f;
        }
        attributes.width = (int) (f2 * f3);
        this.f19709a.getWindow().setAttributes(attributes);
        this.f19709a.getWindow().setGravity(17);
        this.f19709a.setCanceledOnTouchOutside(false);
    }

    public void c() {
        AlertDialog alertDialog = this.f19709a;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.f19709a = null;
        }
    }
}
