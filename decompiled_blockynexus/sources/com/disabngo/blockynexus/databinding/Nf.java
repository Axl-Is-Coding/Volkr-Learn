package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: compiled from: FragmentTribeInviteFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Nf extends Mf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7713b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7714c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f7715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final DataRecyclerView f7716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Button f7717f;
    private long g;

    public Nf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7713b, f7714c));
    }

    @Override // com.disabngo.blockynexus.databinding.Mf
    public void a(com.disabngo.blockynexus.e.b.na.j jVar) {
        updateRegistration(0, jVar);
        this.f7682a = jVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(344);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        com.disabngo.blockynexus.e.b.na.e eVar;
        com.disabngo.blockynexus.e.b.na.g gVar;
        boolean zSafeUnbox;
        com.disabngo.blockynexus.e.b.na.e eVar2;
        com.disabngo.blockynexus.e.b.na.g gVar2;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.na.j jVar = this.f7682a;
        long j2 = 7 & j;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            if ((j & 5) == 0 || jVar == null) {
                eVar2 = null;
                gVar2 = null;
                replyCommand = null;
            } else {
                eVar2 = jVar.f9985e;
                gVar2 = jVar.f9986f;
                replyCommand = jVar.g;
            }
            ObservableField<Boolean> observableField = jVar != null ? jVar.f9983c : null;
            updateRegistration(1, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            eVar = eVar2;
            gVar = gVar2;
            replyCommand2 = replyCommand;
        } else {
            eVar = null;
            gVar = null;
            zSafeUnbox = false;
        }
        if ((j & 5) != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.f7716e, eVar, gVar, null, false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.f7717f, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            this.f7717f.setEnabled(zSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.g != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.na.j) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (344 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.na.j) obj);
        return true;
    }

    private Nf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.g = -1L;
        this.f7715d = (RelativeLayout) objArr[0];
        this.f7715d.setTag(null);
        this.f7716e = (DataRecyclerView) objArr[1];
        this.f7716e.setTag(null);
        this.f7717f = (Button) objArr[2];
        this.f7717f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.na.j jVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
