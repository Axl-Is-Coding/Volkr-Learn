package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: FragmentReportBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class _e extends Ze {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final ConstraintLayout i;
    private long j;

    static {
        h.put(R.id.textView2, 5);
    }

    public _e(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    @Override // com.disabngo.blockynexus.databinding.Ze
    public void a(com.disabngo.blockynexus.e.b.Z.f fVar) {
        updateRegistration(0, fVar);
        this.f8096f = fVar;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(440);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.e.b.Z.f fVar = this.f8096f;
        long j2 = j & 3;
        ReplyCommand replyCommand4 = null;
        if (j2 == 0 || fVar == null) {
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
        } else {
            replyCommand4 = fVar.f9610c;
            replyCommand2 = fVar.f9611d;
            replyCommand3 = fVar.f9612e;
            replyCommand = fVar.f9613f;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8091a, replyCommand4, false, 0);
            ViewBindingAdapters.clickCommand(this.f8092b, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.f8093c, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.f8094d, replyCommand, false, 0);
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
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.Z.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (440 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.Z.f) obj);
        return true;
    }

    private _e(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ConstraintLayout) objArr[1], (ConstraintLayout) objArr[2], (ConstraintLayout) objArr[3], (ConstraintLayout) objArr[4], (TextView) objArr[5]);
        this.j = -1L;
        this.f8091a.setTag(null);
        this.f8092b.setTag(null);
        this.f8093c.setTag(null);
        this.f8094d.setTag(null);
        this.i = (ConstraintLayout) objArr[0];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.Z.f fVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.j |= 1;
        }
        return true;
    }
}
