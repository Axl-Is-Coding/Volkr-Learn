package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.EditTextBindingAdapters;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;

/* JADX INFO: compiled from: ActivityTribeSearchBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class D extends C {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f7368f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final CoordinatorLayout h;
    private final Button i;
    private final PageRecyclerView j;
    private long k;

    static {
        g.put(R.id.tbTemplateBar, 5);
        g.put(R.id.rlBlank, 6);
    }

    public D(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7368f, g));
    }

    @Override // com.disabngo.blockynexus.databinding.C
    public void a(com.disabngo.blockynexus.view.activity.tribesearch.k kVar) {
        updateRegistration(0, kVar);
        this.f7334e = kVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(447);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        boolean zSafeUnbox;
        ReplyCommand<String> replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        com.disabngo.blockynexus.view.activity.tribesearch.i iVar;
        com.disabngo.blockynexus.view.activity.tribesearch.j jVar;
        com.disabngo.blockynexus.view.activity.tribesearch.j jVar2;
        com.disabngo.blockynexus.view.activity.tribesearch.i iVar2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.view.activity.tribesearch.k kVar = this.f7334e;
        long j2 = 7 & j;
        if (j2 != 0) {
            if ((j & 5) == 0 || kVar == null) {
                replyCommand = null;
                jVar2 = null;
                iVar2 = null;
                replyCommand2 = null;
                replyCommand3 = null;
            } else {
                ReplyCommand<String> replyCommand4 = kVar.g;
                iVar2 = kVar.f11140d;
                replyCommand2 = kVar.h;
                replyCommand3 = kVar.f11142f;
                jVar2 = kVar.f11141e;
                replyCommand = replyCommand4;
            }
            ObservableField<Boolean> observableField = kVar != null ? kVar.f11139c : null;
            updateRegistration(1, observableField);
            zSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            jVar = jVar2;
            iVar = iVar2;
        } else {
            zSafeUnbox = false;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            iVar = null;
            jVar = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f7330a, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand2, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.j, iVar, jVar, null, false, false, false, 0, 0, false, null);
            EditTextBindingAdapters.onSoftKeySearchCommand(this.f7333d, replyCommand2);
            EditTextBindingAdapters.editTextCommand(this.f7333d, null, null, replyCommand);
        }
        if (j2 != 0) {
            this.i.setEnabled(zSafeUnbox);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.k != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.k = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.activity.tribesearch.k) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Boolean>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (447 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribesearch.k) obj);
        return true;
    }

    private D(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageButton) objArr[1], (RelativeLayout) objArr[6], (Toolbar) objArr[5], (EditText) objArr[2]);
        this.k = -1L;
        this.f7330a.setTag(null);
        this.h = (CoordinatorLayout) objArr[0];
        this.h.setTag(null);
        this.i = (Button) objArr[3];
        this.i.setTag(null);
        this.j = (PageRecyclerView) objArr[4];
        this.j.setTag(null);
        this.f7333d.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribesearch.k kVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(ObservableField<Boolean> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
