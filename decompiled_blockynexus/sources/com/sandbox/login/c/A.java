package com.sandbox.login.c;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sandbox.login.R;

/* JADX INFO: compiled from: LoginFragmentMakeRoleBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class A extends z {
    private static final ViewDataBinding.b K = null;
    private static final SparseIntArray L = new SparseIntArray();
    private final ConstraintLayout M;
    private final View N;
    private final Group O;
    private final TextView P;
    private long Q;

    static {
        L.put(R.id.bg_top, 27);
        L.put(R.id.bg_down, 28);
        L.put(R.id.flParent, 29);
        L.put(R.id.tab_sex, 30);
        L.put(R.id.bg_info, 31);
        L.put(R.id.iv_head, 32);
        L.put(R.id.iv_random_pic, 33);
        L.put(R.id.til_name, 34);
        L.put(R.id.bg_protocol, 35);
        L.put(R.id.cb_pro, 36);
        L.put(R.id.bg_picker, 37);
        L.put(R.id.pic_4, 38);
    }

    public A(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 39, K, L));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 128;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 16;
        }
        return true;
    }

    private boolean d(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 64;
        }
        return true;
    }

    private boolean e(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 256;
        }
        return true;
    }

    private boolean f(ObservableField<Boolean> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 4;
        }
        return true;
    }

    private boolean g(ObservableField<Integer> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 512;
        }
        return true;
    }

    private boolean h(ObservableField<Integer> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 32;
        }
        return true;
    }

    private boolean i(ObservableField<Integer> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 1;
        }
        return true;
    }

    private boolean j(ObservableField<Integer> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 1024;
        }
        return true;
    }

    @Override // com.sandbox.login.c.z
    public void a(com.sandbox.login.f.a.d.E e2) {
        updateRegistration(1, e2);
        this.J = e2;
        synchronized (this) {
            this.Q |= 2;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:116:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00d1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 1331
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandbox.login.c.A.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.Q != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.Q = PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        switch (i) {
            case 0:
                return i((ObservableField) obj, i2);
            case 1:
                return a((com.sandbox.login.f.a.d.E) obj, i2);
            case 2:
                return f((ObservableField) obj, i2);
            case 3:
                return a((ObservableField<Integer>) obj, i2);
            case 4:
                return c((ObservableField) obj, i2);
            case 5:
                return h((ObservableField) obj, i2);
            case 6:
                return d((ObservableField) obj, i2);
            case 7:
                return b((ObservableField) obj, i2);
            case 8:
                return e((ObservableField) obj, i2);
            case 9:
                return g((ObservableField) obj, i2);
            case 10:
                return j((ObservableField) obj, i2);
            default:
                return false;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.d.E) obj);
        return true;
    }

    private A(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 11, (View) objArr[10], (View) objArr[28], (View) objArr[31], (View) objArr[2], (View) objArr[37], (View) objArr[35], (View) objArr[4], (View) objArr[27], (Button) objArr[7], (MaterialCardView) objArr[11], (MaterialCardView) objArr[14], (MaterialCardView) objArr[17], (MaterialCardView) objArr[20], (MaterialCardView) objArr[23], (CheckBox) objArr[36], (MaterialCardView) objArr[3], (FrameLayout) objArr[29], (ImageView) objArr[25], (ImageView) objArr[32], (ImageView) objArr[6], (ImageView) objArr[33], (View) objArr[13], (View) objArr[16], (View) objArr[19], (View) objArr[22], (View) objArr[24], (ImageView) objArr[12], (ImageView) objArr[15], (ImageView) objArr[18], (ImageView) objArr[21], (ImageView) objArr[38], (TabLayout) objArr[30], (TextInputLayout) objArr[34], (TextView) objArr[9], (TextInputEditText) objArr[5]);
        this.Q = -1L;
        this.f15697a.setTag(null);
        this.f15700d.setTag(null);
        this.g.setTag(null);
        this.i.setTag(null);
        this.j.setTag(null);
        this.k.setTag(null);
        this.l.setTag(null);
        this.m.setTag(null);
        this.n.setTag(null);
        this.p.setTag(null);
        this.r.setTag(null);
        this.t.setTag(null);
        this.M = (ConstraintLayout) objArr[0];
        this.M.setTag(null);
        this.N = (View) objArr[1];
        this.N.setTag(null);
        this.O = (Group) objArr[26];
        this.O.setTag(null);
        this.P = (TextView) objArr[8];
        this.P.setTag(null);
        this.v.setTag(null);
        this.w.setTag(null);
        this.x.setTag(null);
        this.y.setTag(null);
        this.z.setTag(null);
        this.A.setTag(null);
        this.B.setTag(null);
        this.C.setTag(null);
        this.D.setTag(null);
        this.H.setTag(null);
        this.I.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.f.a.d.E e2, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 2;
        }
        return true;
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.Q |= 8;
        }
        return true;
    }
}
