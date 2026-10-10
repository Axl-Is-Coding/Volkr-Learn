package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.vip.R;

/* JADX INFO: compiled from: VipDialogSubscribeHelpBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class h extends g {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private long j;

    static {
        h.put(R.id.v_bg, 3);
        h.put(R.id.tv_title, 4);
        h.put(R.id.v_bottom, 5);
    }

    public h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    @Override // com.sandboxol.vip.b.g
    public void a(com.sandboxol.vip.d.a.d dVar) {
        this.f18989f = dVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.f18952b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        ReplyCommand replyCommand = null;
        com.sandboxol.vip.d.a.d dVar = this.f18989f;
        long j2 = 3 & j;
        if (j2 != 0 && dVar != null) {
            replyCommand = dVar.f19066a;
        }
        long j3 = j & 2;
        int i = j3 != 0 ? R.string.vip_subscribe_help_dialog_content : 0;
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f18984a, replyCommand, false, 0);
        }
        if (j3 != 0) {
            com.sandboxol.vip.a.c.a(this.f18985b, i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.f18952b != i) {
            return false;
        }
        a((com.sandboxol.vip.d.a.d) obj);
        return true;
    }

    private h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[2], (TextView) objArr[1], (TextView) objArr[4], (View) objArr[3], (View) objArr[5]);
        this.j = -1L;
        this.f18984a.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        this.f18985b.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
