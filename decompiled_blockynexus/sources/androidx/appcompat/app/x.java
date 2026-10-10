package androidx.appcompat.app;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.d.b;
import androidx.core.view.C0317e;

/* JADX INFO: compiled from: AppCompatDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class x extends Dialog implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l f325a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final C0317e.a f326b;

    public x(Context context, int i) {
        super(context, a(context, i));
        this.f326b = new w(this);
        l lVarA = a();
        lVarA.d(a(context, i));
        lVarA.a((Bundle) null);
    }

    public boolean a(int i) {
        return a().b(i);
    }

    @Override // android.app.Dialog
    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().a(view, layoutParams);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return C0317e.a(this.f326b, getWindow().getDecorView(), this, keyEvent);
    }

    @Override // android.app.Dialog
    public <T extends View> T findViewById(int i) {
        return (T) a().a(i);
    }

    @Override // android.app.Dialog
    public void invalidateOptionsMenu() {
        a().g();
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        a().f();
        super.onCreate(bundle);
        a().a(bundle);
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        a().k();
    }

    @Override // androidx.appcompat.app.k
    public void onSupportActionModeFinished(androidx.appcompat.d.b bVar) {
    }

    @Override // androidx.appcompat.app.k
    public void onSupportActionModeStarted(androidx.appcompat.d.b bVar) {
    }

    @Override // androidx.appcompat.app.k
    public androidx.appcompat.d.b onWindowStartingSupportActionMode(b.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        a().c(i);
    }

    @Override // android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        a().a(charSequence);
    }

    public l a() {
        if (this.f325a == null) {
            this.f325a = l.a(this, this);
        }
        return this.f325a;
    }

    @Override // android.app.Dialog
    public void setContentView(View view) {
        a().a(view);
    }

    @Override // android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        a().b(view, layoutParams);
    }

    @Override // android.app.Dialog
    public void setTitle(int i) {
        super.setTitle(i);
        a().a(getContext().getString(i));
    }

    private static int a(Context context, int i) {
        if (i != 0) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    boolean a(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
