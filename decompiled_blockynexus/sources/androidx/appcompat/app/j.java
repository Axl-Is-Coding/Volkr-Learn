package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.R;
import androidx.appcompat.app.AlertController;

/* JADX INFO: compiled from: AlertDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class j extends x implements DialogInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AlertController f308c;

    /* JADX INFO: compiled from: AlertDialog.java */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AlertController.a f309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f310b;

        public a(Context context) {
            this(context, j.a(context, 0));
        }

        public a a(int i) {
            AlertController.a aVar = this.f309a;
            aVar.f210f = aVar.f205a.getText(i);
            return this;
        }

        public Context b() {
            return this.f309a.f205a;
        }

        public j c() {
            j jVarA = a();
            jVarA.show();
            return jVarA;
        }

        public a(Context context, int i) {
            this.f309a = new AlertController.a(new ContextThemeWrapper(context, j.a(context, i)));
            this.f310b = i;
        }

        public a a(View view) {
            this.f309a.g = view;
            return this;
        }

        public a b(CharSequence charSequence) {
            this.f309a.f210f = charSequence;
            return this;
        }

        public a a(CharSequence charSequence) {
            this.f309a.h = charSequence;
            return this;
        }

        public a b(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.i = aVar.f205a.getText(i);
            this.f309a.k = onClickListener;
            return this;
        }

        public a a(Drawable drawable) {
            this.f309a.f208d = drawable;
            return this;
        }

        public a a(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.l = aVar.f205a.getText(i);
            this.f309a.n = onClickListener;
            return this;
        }

        public a b(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.i = charSequence;
            aVar.k = onClickListener;
            return this;
        }

        public a a(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.l = charSequence;
            aVar.n = onClickListener;
            return this;
        }

        public a b(int i) {
            AlertController.a aVar = this.f309a;
            aVar.z = null;
            aVar.y = i;
            aVar.E = false;
            return this;
        }

        public a a(boolean z) {
            this.f309a.r = z;
            return this;
        }

        public a a(DialogInterface.OnCancelListener onCancelListener) {
            this.f309a.s = onCancelListener;
            return this;
        }

        public a b(View view) {
            AlertController.a aVar = this.f309a;
            aVar.z = view;
            aVar.y = 0;
            aVar.E = false;
            return this;
        }

        public a a(DialogInterface.OnKeyListener onKeyListener) {
            this.f309a.u = onKeyListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            return this;
        }

        public a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            return this;
        }

        public a a(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.v = charSequenceArr;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public a a(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.a aVar = this.f309a;
            aVar.w = listAdapter;
            aVar.x = onClickListener;
            aVar.I = i;
            aVar.H = true;
            return this;
        }

        public j a() {
            j jVar = new j(this.f309a.f205a, this.f310b);
            this.f309a.a(jVar.f308c);
            jVar.setCancelable(this.f309a.r);
            if (this.f309a.r) {
                jVar.setCanceledOnTouchOutside(true);
            }
            jVar.setOnCancelListener(this.f309a.s);
            jVar.setOnDismissListener(this.f309a.t);
            DialogInterface.OnKeyListener onKeyListener = this.f309a.u;
            if (onKeyListener != null) {
                jVar.setOnKeyListener(onKeyListener);
            }
            return jVar;
        }
    }

    protected j(Context context, int i) {
        super(context, a(context, i));
        this.f308c = new AlertController(getContext(), this, getWindow());
    }

    static int a(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    public Button b(int i) {
        return this.f308c.a(i);
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f308c.b();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.f308c.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.f308c.b(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // androidx.appcompat.app.x, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.f308c.b(charSequence);
    }

    public ListView b() {
        return this.f308c.a();
    }

    public void a(CharSequence charSequence) {
        this.f308c.a(charSequence);
    }
}
