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

/* JADX INFO: compiled from: VipDialogSubscribeRulesBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class j extends i {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private long j;

    static {
        h.put(R.id.v_bg, 2);
        h.put(R.id.tv_title, 3);
        h.put(R.id.tv_content, 4);
        h.put(R.id.v_bottom, 5);
    }

    public j(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    @Override // com.sandboxol.vip.b.i
    public void a(com.sandboxol.vip.d.a.e eVar) {
        this.f18995f = eVar;
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
        com.sandboxol.vip.d.a.e eVar = this.f18995f;
        long j2 = j & 3;
        if (j2 != 0 && eVar != null) {
            replyCommand = eVar.f19067a;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f18990a, replyCommand, false, 0);
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
        a((com.sandboxol.vip.d.a.e) obj);
        return true;
    }

    private j(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[1], (TextView) objArr[4], (TextView) objArr[3], (View) objArr[2], (View) objArr[5]);
        this.j = -1L;
        this.f18990a.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
