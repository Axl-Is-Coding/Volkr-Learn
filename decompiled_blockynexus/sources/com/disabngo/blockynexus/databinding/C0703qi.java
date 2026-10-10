package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.center.entity.AllGameIdInfo;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.qi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemPartyChooseGameBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0703qi extends AbstractC0692pi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8736b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8737c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f8738d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8739e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8740f;

    public C0703qi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8736b, f8737c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.c.b bVar) {
        updateRegistration(0, bVar);
        this.f8701a = bVar;
        synchronized (this) {
            this.f8740f |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.f8740f;
            this.f8740f = 0L;
        }
        com.disabngo.blockynexus.view.dialog.c.b bVar = this.f8701a;
        long j2 = 7 & j;
        String gameName = null;
        if (j2 != 0) {
            replyCommand = ((j & 5) == 0 || bVar == null) ? null : bVar.f11534a;
            AllGameIdInfo item = bVar != null ? bVar.getItem() : null;
            if (item != null) {
                gameName = item.getGameName();
            }
        } else {
            replyCommand = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8739e, gameName);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8739e, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8740f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8740f = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.dialog.c.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.c.b) obj);
        return true;
    }

    private C0703qi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.f8740f = -1L;
        this.f8738d = (ConstraintLayout) objArr[0];
        this.f8738d.setTag(null);
        this.f8739e = (TextView) objArr[1];
        this.f8739e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.c.b bVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.f8740f |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.f8740f |= 2;
        }
        return true;
    }
}
