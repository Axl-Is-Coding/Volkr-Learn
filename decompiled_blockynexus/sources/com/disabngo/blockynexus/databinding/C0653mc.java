package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.mc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogSafeSettingGuideBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0653mc extends AbstractC0642lc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8576d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8577e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final RelativeLayout f8578f;
    private final ImageView g;
    private long h;

    static {
        f8577e.put(R.id.tv_title, 3);
    }

    public C0653mc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8576d, f8577e));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0642lc
    public void a(com.disabngo.blockynexus.view.dialog.Ea ea) {
        this.f8548c = ea;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(527);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        ReplyCommand replyCommand = null;
        com.disabngo.blockynexus.view.dialog.Ea ea = this.f8548c;
        long j2 = 3 & j;
        if (j2 != 0 && ea != null) {
            replyCommand = ea.f11282a;
        }
        if ((j & 2) != 0) {
            ImageViewBindingAdapters.isStartAnim(this.g, true);
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8546a, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.h != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.h = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (527 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Ea) obj);
        return true;
    }

    private C0653mc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (RelativeLayout) objArr[1], (TextView) objArr[3]);
        this.h = -1L;
        this.f8578f = (RelativeLayout) objArr[0];
        this.f8578f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        this.f8546a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
