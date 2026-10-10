package androidx.appcompat.widget;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.R;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f497b;

    static {
        f496a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet, i, 0);
    }

    private void a(Context context, AttributeSet attributeSet, int i, int i2) {
        ia iaVarA = ia.a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (iaVarA.g(R.styleable.PopupWindow_overlapAnchor)) {
            a(iaVarA.a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(iaVarA.b(R.styleable.PopupWindow_android_popupBackground));
        iaVarA.a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f496a && this.f497b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f496a && this.f497b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        a(context, attributeSet, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f496a && this.f497b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    private void a(boolean z) {
        if (f496a) {
            this.f497b = z;
        } else {
            androidx.core.widget.k.a(this, z);
        }
    }
}
