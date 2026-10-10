package com.sandboxol.gamedetail.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;
import com.sandboxol.gamedetail.R;

/* JADX INFO: renamed from: com.sandboxol.gamedetail.a.h, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAuthorListBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2679h extends AbstractC2678g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17835c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17836d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f17837e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final DataRecyclerView f17838f;
    private final ImageView g;
    private long h;

    static {
        f17836d.put(R.id.llList, 3);
    }

    public C2679h(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17835c, f17836d));
    }

    @Override // com.sandboxol.gamedetail.a.AbstractC2678g
    public void a(com.sandboxol.gamedetail.view.dialog.a.i iVar) {
        updateRegistration(0, iVar);
        this.f17834b = iVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.j);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.sandboxol.gamedetail.view.dialog.a.g gVar;
        com.sandboxol.gamedetail.view.dialog.a.h hVar;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.sandboxol.gamedetail.view.dialog.a.i iVar = this.f17834b;
        long j2 = j & 3;
        ReplyCommand replyCommand = null;
        if (j2 == 0 || iVar == null) {
            gVar = null;
            hVar = null;
        } else {
            replyCommand = iVar.f18133d;
            com.sandboxol.gamedetail.view.dialog.a.g gVar2 = iVar.f18132c;
            hVar = iVar.f18131b;
            gVar = gVar2;
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f17838f, gVar, hVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
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
        return a((com.sandboxol.gamedetail.view.dialog.a.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.j != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.view.dialog.a.i) obj);
        return true;
    }

    private C2679h(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[3]);
        this.h = -1L;
        this.f17837e = (RelativeLayout) objArr[0];
        this.f17837e.setTag(null);
        this.f17838f = (DataRecyclerView) objArr[1];
        this.f17838f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.view.dialog.a.i iVar, int i) {
        if (i != com.sandboxol.gamedetail.a.f17768a) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }
}
