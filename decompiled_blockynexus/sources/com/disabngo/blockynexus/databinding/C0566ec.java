package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.PartyTipDialog;
import com.sandboxol.common.widget.StrokeTextView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ec, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogPartyTipBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0566ec extends AbstractC0555dc {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final RelativeLayout i;
    private long j;

    static {
        h.put(R.id.tvTitle, 1);
        h.put(R.id.ivCancel, 2);
        h.put(R.id.llBtn, 3);
        h.put(R.id.btnCancel, 4);
        h.put(R.id.btnConfirm, 5);
    }

    public C0566ec(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, g, h));
    }

    public void a(PartyTipDialog partyTipDialog) {
        this.f8258f = partyTipDialog;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.j;
            this.j = 0L;
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
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (445 != i) {
            return false;
        }
        a((PartyTipDialog) obj);
        return true;
    }

    private C0566ec(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (Button) objArr[4], (Button) objArr[5], (ImageView) objArr[2], (LinearLayout) objArr[3], (StrokeTextView) objArr[1]);
        this.j = -1L;
        this.i = (RelativeLayout) objArr[0];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
