package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemInviteMemberBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Xh extends Wh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8036b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8037c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8038d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8039e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8040f;

    public Xh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8036b, f8037c));
    }

    public void a(com.disabngo.blockynexus.e.b.D.w wVar) {
        updateRegistration(0, wVar);
        this.f8010a = wVar;
        synchronized (this) {
            this.f8040f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f8040f;
            this.f8040f = 0L;
        }
        ReplyCommand replyCommand = null;
        com.disabngo.blockynexus.e.b.D.w wVar = this.f8010a;
        long j2 = j & 3;
        if (j2 != 0 && wVar != null) {
            replyCommand = wVar.f9196a;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8039e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8040f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8040f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.D.w) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.D.w) obj);
        return true;
    }

    private Xh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8040f = -1L;
        this.f8038d = (LinearLayout) objArr[0];
        this.f8038d.setTag(null);
        this.f8039e = (ImageView) objArr[1];
        this.f8039e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.D.w wVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f8040f |= 1;
        }
        return true;
    }
}
