package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.dialog.ScrapReceivedAnimDialog;
import com.opensource.svgaplayer.SVGAImageView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.sc, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogScrapReceivedAnimBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0718sc extends AbstractC0707rc {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f8789d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f8790e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8791f;

    static {
        f8790e.put(R.id.sv_iv_scrap, 1);
    }

    public C0718sc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8789d, f8790e));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0707rc
    public void a(ScrapReceivedAnimDialog scrapReceivedAnimDialog) {
        this.f8757c = scrapReceivedAnimDialog;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8791f;
            this.f8791f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8791f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8791f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (75 != i) {
            return false;
        }
        a((ScrapReceivedAnimDialog) obj);
        return true;
    }

    private C0718sc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ConstraintLayout) objArr[0], (SVGAImageView) objArr[1]);
        this.f8791f = -1L;
        this.f8755a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
