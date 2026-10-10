package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemSecretQuestionBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0538bj extends AbstractC0526aj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8206c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8207d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f8208e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f8209f;

    static {
        f8207d.put(R.id.tv_item_question, 1);
    }

    public C0538bj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f8206c, f8207d));
    }

    public void a(String str) {
        this.f8180b = str;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            long j = this.f8209f;
            this.f8209f = 0L;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f8209f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f8209f = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (367 != i) {
            return false;
        }
        a((String) obj);
        return true;
    }

    private C0538bj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[1]);
        this.f8209f = -1L;
        this.f8208e = (LinearLayout) objArr[0];
        this.f8208e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
