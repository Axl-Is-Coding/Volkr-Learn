package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.core.view.C0316d;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes.dex */
public class MenuPopupHelper implements MenuHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final MenuBuilder f438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f439c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f440d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f441e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private View f442f;
    private int g;
    private boolean h;
    private MenuPresenter.a i;
    private i j;
    private PopupWindow.OnDismissListener k;
    private final PopupWindow.OnDismissListener l;

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i) {
        this(context, menuBuilder, view, z, i, 0);
    }

    private i g() {
        Display defaultDisplay = ((WindowManager) this.f437a.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            defaultDisplay.getRealSize(point);
        } else {
            defaultDisplay.getSize(point);
        }
        i cascadingMenuPopup = Math.min(point.x, point.y) >= this.f437a.getResources().getDimensionPixelSize(R.dimen.abc_cascading_menus_min_smallest_width) ? new CascadingMenuPopup(this.f437a, this.f442f, this.f440d, this.f441e, this.f439c) : new StandardMenuPopup(this.f437a, this.f438b, this.f442f, this.f440d, this.f441e, this.f439c);
        cascadingMenuPopup.a(this.f438b);
        cascadingMenuPopup.a(this.l);
        cascadingMenuPopup.a(this.f442f);
        cascadingMenuPopup.setCallback(this.i);
        cascadingMenuPopup.b(this.h);
        cascadingMenuPopup.a(this.g);
        return cascadingMenuPopup;
    }

    public void a(PopupWindow.OnDismissListener onDismissListener) {
        this.k = onDismissListener;
    }

    public i b() {
        if (this.j == null) {
            this.j = g();
        }
        return this.j;
    }

    public boolean c() {
        i iVar = this.j;
        return iVar != null && iVar.c();
    }

    protected void d() {
        this.j = null;
        PopupWindow.OnDismissListener onDismissListener = this.k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    public void e() {
        if (!f()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public boolean f() {
        if (c()) {
            return true;
        }
        if (this.f442f == null) {
            return false;
        }
        a(0, 0, false, false);
        return true;
    }

    @Override // androidx.appcompat.view.menu.MenuHelper
    public void setPresenterCallback(MenuPresenter.a aVar) {
        this.i = aVar;
        i iVar = this.j;
        if (iVar != null) {
            iVar.setCallback(aVar);
        }
    }

    public MenuPopupHelper(Context context, MenuBuilder menuBuilder, View view, boolean z, int i, int i2) {
        this.g = 8388611;
        this.l = new j(this);
        this.f437a = context;
        this.f438b = menuBuilder;
        this.f442f = view;
        this.f439c = z;
        this.f440d = i;
        this.f441e = i2;
    }

    public void a(View view) {
        this.f442f = view;
    }

    public void a(boolean z) {
        this.h = z;
        i iVar = this.j;
        if (iVar != null) {
            iVar.b(z);
        }
    }

    public void a(int i) {
        this.g = i;
    }

    public boolean a(int i, int i2) {
        if (c()) {
            return true;
        }
        if (this.f442f == null) {
            return false;
        }
        a(i, i2, true, true);
        return true;
    }

    private void a(int i, int i2, boolean z, boolean z2) {
        i iVarB = b();
        iVarB.c(z2);
        if (z) {
            if ((C0316d.a(this.g, ViewCompat.m(this.f442f)) & 7) == 5) {
                i -= this.f442f.getWidth();
            }
            iVarB.b(i);
            iVarB.c(i2);
            int i3 = (int) ((this.f437a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            iVarB.a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        iVarB.show();
    }

    public void a() {
        if (c()) {
            this.j.dismiss();
        }
    }
}
