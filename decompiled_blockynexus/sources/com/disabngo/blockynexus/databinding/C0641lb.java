package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.DialogC1114ra;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.lb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogApplyFriendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0641lb extends AbstractC0630kb {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f8544e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f8545f = new SparseIntArray();
    private final RelativeLayout g;
    private long h;

    static {
        f8545f.put(R.id.etMsg, 3);
    }

    public C0641lb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8544e, f8545f));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0630kb
    public void a(DialogC1114ra dialogC1114ra) {
        this.f8511d = dialogC1114ra;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(438);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        DialogC1114ra dialogC1114ra = this.f8511d;
        long j2 = j & 3;
        ReplyCommand replyCommand2 = null;
        if (j2 == 0 || dialogC1114ra == null) {
            replyCommand = null;
        } else {
            replyCommand2 = dialogC1114ra.f11676a;
            replyCommand = dialogC1114ra.f11677b;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f8508a, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.f8509b, replyCommand, false, 0);
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
        if (438 != i) {
            return false;
        }
        a((DialogC1114ra) obj);
        return true;
    }

    private C0641lb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[1], (Button) objArr[2], (EditText) objArr[3]);
        this.h = -1L;
        this.f8508a.setTag(null);
        this.f8509b.setTag(null);
        this.g = (RelativeLayout) objArr[0];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
