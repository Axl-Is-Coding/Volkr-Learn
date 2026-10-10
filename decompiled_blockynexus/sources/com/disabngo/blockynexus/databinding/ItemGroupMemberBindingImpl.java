package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;

/* JADX INFO: loaded from: classes.dex */
public class ItemGroupMemberBindingImpl extends Bh {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7564e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7565f = null;
    private final RelativeLayout g;
    private final ImageView h;
    private final CheckBox i;
    private OnClickListenerImpl j;
    private long k;

    public static class OnClickListenerImpl implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private com.disabngo.blockynexus.e.b.F.h f7566a;

        public OnClickListenerImpl a(com.disabngo.blockynexus.e.b.F.h hVar) {
            this.f7566a = hVar;
            if (hVar == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            this.f7566a.a(view);
        }
    }

    public ItemGroupMemberBindingImpl(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7564e, f7565f));
    }

    private boolean b(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean c(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 8;
        }
        return true;
    }

    public void a(com.disabngo.blockynexus.e.b.F.h hVar) {
        updateRegistration(2, hVar);
        this.f7321d = hVar;
        synchronized (this) {
            this.k |= 4;
        }
        notifyPropertyChanged(508);
        super.requestRebind();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0116  */
    @Override // androidx.databinding.ViewDataBinding
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected void executeBindings() {
        /*
            Method dump skipped, instruction units count: 410
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.disabngo.blockynexus.databinding.ItemGroupMemberBindingImpl.executeBindings():void");
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 32L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return b((ObservableField) obj, i2);
        }
        if (i == 1) {
            return a((ObservableField<Drawable>) obj, i2);
        }
        if (i == 2) {
            return a((com.disabngo.blockynexus.e.b.F.h) obj, i2);
        }
        if (i != 3) {
            return false;
        }
        return c((ObservableField) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (508 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.F.h) obj);
        return true;
    }

    private ItemGroupMemberBindingImpl(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 4, (ImageView) objArr[1], (TextView) objArr[3], (TextView) objArr[2]);
        this.k = -1L;
        this.f7318a.setTag(null);
        this.g = (RelativeLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[4];
        this.h.setTag(null);
        this.i = (CheckBox) objArr[5];
        this.i.setTag(null);
        this.f7319b.setTag(null);
        this.f7320c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Drawable> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.F.h hVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 4;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 16;
        }
        return true;
    }
}
