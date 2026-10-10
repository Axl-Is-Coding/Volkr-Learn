package com.sandboxol.decorate.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.decorate.R;

/* JADX INFO: compiled from: DialogDressExpiredBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends AbstractC2592q {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17110e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17111f = new SparseIntArray();
    private final ConstraintLayout g;
    private final Button h;
    private long i;

    static {
        f17111f.put(R.id.textView25, 4);
    }

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f17110e, f17111f));
    }

    @Override // com.sandboxol.decorate.c.AbstractC2592q
    public void a(com.sandboxol.decorate.view.dialog.b.c cVar) {
        this.f17109d = cVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(com.sandboxol.decorate.c.s);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.sandboxol.decorate.view.dialog.b.e eVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.sandboxol.decorate.view.dialog.b.c cVar = this.f17109d;
        long j2 = j & 3;
        ReplyCommand replyCommand2 = null;
        if (j2 == 0 || cVar == null) {
            replyCommand = null;
            eVar = null;
        } else {
            replyCommand2 = cVar.f17363b;
            com.sandboxol.decorate.view.dialog.b.e eVar2 = cVar.f17365d;
            replyCommand = cVar.f17364c;
            eVar = eVar2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f17106a, replyCommand2, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17107b, null, eVar, me.tatarka.bindingcollectionadapter2.k.a(3), false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.decorate.c.s != i) {
            return false;
        }
        a((com.sandboxol.decorate.view.dialog.b.c) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[1], (DataRecyclerView) objArr[2], (TextView) objArr[4]);
        this.i = -1L;
        this.f17106a.setTag(null);
        this.f17107b.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (Button) objArr[3];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
