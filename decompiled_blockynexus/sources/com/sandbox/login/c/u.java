package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.sandbox.login.R;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: LoginFragmentAccountRecordBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class u extends t {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f15682d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f15683e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f15684f;
    private final DataRecyclerView g;
    private long h;

    static {
        f15683e.put(R.id.txtTitle, 3);
    }

    public u(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f15682d, f15683e));
    }

    @Override // com.sandbox.login.c.t
    public void a(com.sandbox.login.f.a.e.r rVar) {
        updateRegistration(0, rVar);
        this.f15681c = rVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.sandbox.login.f.a.e.n nVar;
        com.sandbox.login.f.a.e.o oVar;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.sandbox.login.f.a.e.r rVar = this.f15681c;
        long j2 = j & 3;
        if (j2 == 0 || rVar == null) {
            replyCommand = null;
            nVar = null;
            oVar = null;
        } else {
            com.sandbox.login.f.a.e.o oVar2 = rVar.f15875d;
            nVar = rVar.f15874c;
            replyCommand = rVar.f15876e;
            oVar = oVar2;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f15679a, replyCommand, false, 0);
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.g, nVar, oVar, me.tatarka.bindingcollectionadapter2.k.a(1, false), true, null, false, 0, false);
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
        if (i != 0) {
            return false;
        }
        return a((com.sandbox.login.f.a.e.r) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.f.a.e.r) obj);
        return true;
    }

    private u(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (Button) objArr[2], (TextView) objArr[3]);
        this.h = -1L;
        this.f15679a.setTag(null);
        this.f15684f = (LinearLayout) objArr[0];
        this.f15684f.setTag(null);
        this.g = (DataRecyclerView) objArr[1];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.f.a.e.r rVar, int i) {
        if (i != com.sandbox.login.g.f15904a) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
