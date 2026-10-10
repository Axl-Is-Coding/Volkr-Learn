package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.e.b.x.C0934B;
import com.sandboxol.greendao.entity.Friend;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0647lh extends AbstractC0636kh {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final ConstraintLayout k;
    private final ImageView l;
    private final ImageView m;
    private final TextView n;
    private long o;

    static {
        j.put(R.id.bg_info, 9);
        j.put(R.id.guideline, 10);
    }

    public C0647lh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 11, i, j));
    }

    private boolean onChangeViewModelItem(Friend friend, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 2;
            }
            return true;
        }
        if (i2 == 12) {
            synchronized (this) {
                this.o |= 4;
            }
            return true;
        }
        if (i2 != 18) {
            return false;
        }
        synchronized (this) {
            this.o |= 8;
        }
        return true;
    }

    public void a(C0934B c0934b) {
        updateRegistration(0, c0934b);
        this.h = c0934b;
        synchronized (this) {
            this.o |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01b1  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 566
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.C0647lh.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.o != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.o = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((C0934B) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return onChangeViewModelItem((Friend) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (2 != i2) {
            return false;
        }
        a((C0934B) obj);
        return true;
    }

    private C0647lh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[9], (Button) objArr[8], (Guideline) objArr[10], (ImageView) objArr[1], (TextView) objArr[6], (TextView) objArr[2], (TextView) objArr[5]);
        this.o = -1L;
        this.f8528b.setTag(null);
        this.f8530d.setTag(null);
        this.k = (ConstraintLayout) objArr[0];
        this.k.setTag(null);
        this.l = (ImageView) objArr[3];
        this.l.setTag(null);
        this.m = (ImageView) objArr[4];
        this.m.setTag(null);
        this.n = (TextView) objArr[7];
        this.n.setTag(null);
        this.f8531e.setTag(null);
        this.f8532f.setTag(null);
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(C0934B c0934b, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.o |= 1;
            }
            return true;
        }
        if (i2 != 244) {
            return false;
        }
        synchronized (this) {
            this.o |= 2;
        }
        return true;
    }
}
