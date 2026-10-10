package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.dialog.DialogC1130za;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.zb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogFriendAddGuideBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0794zb extends AbstractC0783yb {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f9031b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f9032c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f9033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f9034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f9035f;

    public C0794zb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f9031b, f9032c));
    }

    public void a(DialogC1130za dialogC1130za) {
        this.f9007a = dialogC1130za;
        synchronized (this) {
            this.f9035f |= 1;
        }
        notifyPropertyChanged(451);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.f9035f;
            this.f9035f = 0L;
        }
        ReplyCommand replyCommand = null;
        DialogC1130za dialogC1130za = this.f9007a;
        long j2 = j & 3;
        if (j2 != 0 && dialogC1130za != null) {
            replyCommand = dialogC1130za.f11717a;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f9034e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f9035f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f9035f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (451 != i) {
            return false;
        }
        a((DialogC1130za) obj);
        return true;
    }

    private C0794zb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0);
        this.f9035f = -1L;
        this.f9033d = (RelativeLayout) objArr[0];
        this.f9033d.setTag(null);
        this.f9034e = (ImageView) objArr[1];
        this.f9034e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
