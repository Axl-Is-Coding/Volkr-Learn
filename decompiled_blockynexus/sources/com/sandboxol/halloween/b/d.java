package com.sandboxol.halloween.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.halloween.R;

/* JADX INFO: compiled from: HalloweenDialogRewardBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class d extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f18593e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f18594f = new SparseIntArray();
    private final ConstraintLayout g;
    private long h;

    static {
        f18594f.put(R.id.ivFlash, 3);
    }

    public d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f18593e, f18594f));
    }

    @Override // com.sandboxol.halloween.b.c
    public void a(com.sandboxol.halloween.view.dialog.a.b bVar) {
        this.f18592d = bVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(com.sandboxol.halloween.a.f18578b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.sandboxol.halloween.view.dialog.a.d dVar;
        com.sandboxol.halloween.view.dialog.a.e eVar;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.sandboxol.halloween.view.dialog.a.b bVar = this.f18592d;
        long j2 = j & 3;
        if (j2 == 0 || bVar == null) {
            replyCommand = null;
            dVar = null;
            eVar = null;
        } else {
            com.sandboxol.halloween.view.dialog.a.d dVar2 = bVar.f18677b;
            com.sandboxol.halloween.view.dialog.a.e eVar2 = bVar.f18676a;
            replyCommand = bVar.f18681f;
            eVar = eVar2;
            dVar = dVar2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f18589a, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f18591c, dVar, eVar, me.tatarka.bindingcollectionadapter2.k.a(0, false), false, null, false, 0, false);
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
        if (com.sandboxol.halloween.a.f18578b != i) {
            return false;
        }
        a((com.sandboxol.halloween.view.dialog.a.b) obj);
        return true;
    }

    private d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (View) objArr[2], (ImageView) objArr[3], (DataRecyclerView) objArr[1]);
        this.h = -1L;
        this.f18589a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.f18591c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
