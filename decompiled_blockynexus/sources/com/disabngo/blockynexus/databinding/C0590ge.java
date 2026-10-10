package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ge, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentGroupChatBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0590ge extends AbstractC0579fe {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8365b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8366c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final FrameLayout f8367d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final PageRecyclerView f8368e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f8369f;
    private final Button g;
    private long h;

    public C0590ge(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8365b, f8366c));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0579fe
    public void a(com.disabngo.blockynexus.e.b.B.i iVar) {
        updateRegistration(0, iVar);
        this.f8332a = iVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(424);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int i;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.e.b.B.f fVar;
        com.disabngo.blockynexus.e.b.B.h hVar;
        com.disabngo.blockynexus.e.b.B.h hVar2;
        com.disabngo.blockynexus.e.b.B.f fVar2;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.e.b.B.i iVar = this.f8332a;
        long j2 = j & 7;
        if (j2 != 0) {
            if ((j & 5) == 0 || iVar == null) {
                replyCommand = null;
                hVar2 = null;
                fVar2 = null;
            } else {
                ReplyCommand replyCommand2 = iVar.f9120b;
                fVar2 = iVar.f9121c;
                hVar2 = iVar.f9122d;
                replyCommand = replyCommand2;
            }
            ObservableField<Boolean> observableField = iVar != null ? iVar.f9123e : null;
            updateRegistration(1, observableField);
            boolean zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            if (j2 != 0) {
                j |= zSafeUnbox ? 16L : 8L;
            }
            i = zSafeUnbox ? 0 : 8;
            hVar = hVar2;
            fVar = fVar2;
        } else {
            i = 0;
            replyCommand = null;
            fVar = null;
            hVar = null;
        }
        if ((j & 5) != 0) {
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.f8368e, fVar, hVar, null, false, false, false, 0, 0, false, null);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
        }
        if ((j & 7) != 0) {
            this.f8369f.setVisibility(i);
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
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.B.i) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (424 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.B.i) obj);
        return true;
    }

    private C0590ge(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.h = -1L;
        this.f8367d = (FrameLayout) objArr[0];
        this.f8367d.setTag(null);
        this.f8368e = (PageRecyclerView) objArr[1];
        this.f8368e.setTag(null);
        this.f8369f = (LinearLayout) objArr[2];
        this.f8369f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.B.i iVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
