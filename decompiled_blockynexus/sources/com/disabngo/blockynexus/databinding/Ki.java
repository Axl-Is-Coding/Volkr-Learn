package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: compiled from: ItemRecommandFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ki extends Ji {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7623b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7624c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7625d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7626e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f7627f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final Button k;
    private long l;

    public Ki(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f7623b, f7624c));
    }

    private boolean b(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.view.activity.searchfriend.r rVar) {
        updateRegistration(0, rVar);
        this.f7591a = rVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0063 A[PHI: r2
      0x0063: PHI (r2v3 long) = (r2v0 long), (r2v8 long) binds: [B:18:0x0038, B:32:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00dc  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.Ki.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 16L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.searchfriend.r) obj, i2);
        }
        if (i == 1) {
            return b((ObservableField) obj, i2);
        }
        if (i != 2) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.searchfriend.r) obj);
        return true;
    }

    private Ki(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 3);
        this.l = -1L;
        this.f7625d = (LinearLayout) objArr[0];
        this.f7625d.setTag(null);
        this.f7626e = (RelativeLayout) objArr[1];
        this.f7626e.setTag(null);
        this.f7627f = (ImageView) objArr[2];
        this.f7627f.setTag(null);
        this.g = (ImageView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (TextView) objArr[6];
        this.j.setTag(null);
        this.k = (Button) objArr[7];
        this.k.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.searchfriend.r rVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 8;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.l |= 4;
        }
        return true;
    }
}
