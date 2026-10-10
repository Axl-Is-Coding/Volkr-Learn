package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemRemoveMemberBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Mi extends Li {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7689b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7690c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7691d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7692e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7693f;

    public Mi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7689b, f7690c));
    }

    public void a(com.disabngo.blockynexus.e.b.D.E e2) {
        updateRegistration(0, e2);
        this.f7658a = e2;
        synchronized (this) {
            this.f7693f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f7693f;
            this.f7693f = 0L;
        }
        ReplyCommand replyCommand = null;
        com.disabngo.blockynexus.e.b.D.E e2 = this.f7658a;
        long j2 = j & 3;
        if (j2 != 0 && e2 != null) {
            replyCommand = e2.f9161a;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f7692e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7693f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7693f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.D.E) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.D.E) obj);
        return true;
    }

    private Mi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f7693f = -1L;
        this.f7691d = (LinearLayout) objArr[0];
        this.f7691d.setTag(null);
        this.f7692e = (ImageView) objArr[1];
        this.f7692e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.D.E e2, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7693f |= 1;
        }
        return true;
    }
}
