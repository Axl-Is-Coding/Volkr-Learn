package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.AccountCenter;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogAppSecretQuestionFinishBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0530bb extends AbstractC0518ab {
    private static final ViewDataBinding.b i = null;
    private static final SparseIntArray j = new SparseIntArray();
    private final LinearLayout k;
    private final TextView l;
    private long m;

    static {
        j.put(R.id.llContainer, 2);
        j.put(R.id.tvTitle, 3);
        j.put(R.id.tv_question_one, 4);
        j.put(R.id.tv_answer_one, 5);
        j.put(R.id.tv_question_two, 6);
        j.put(R.id.tv_answer_two, 7);
        j.put(R.id.btnClose, 8);
        j.put(R.id.btnSave, 9);
    }

    public C0530bb(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 10, i, j));
    }

    private boolean a(AccountCenter accountCenter, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 1;
        }
        return true;
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j2;
        synchronized (this) {
            j2 = this.m;
            this.m = 0L;
        }
        long j3 = j2 & 6;
        String str = null;
        if (j3 != 0) {
            ObservableField<Long> observableField = AccountCenter.newInstance().userId;
            updateRegistration(1, observableField);
            str = (observableField != null ? observableField.get() : null) + "";
        }
        if (j3 != 0) {
            androidx.databinding.a.e.a(this.l, str);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.m != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.m = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i2, Object obj, int i3) {
        if (i2 == 0) {
            return a((AccountCenter) obj, i3);
        }
        if (i2 != 1) {
            return false;
        }
        return a((ObservableField<Long>) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        return true;
    }

    private C0530bb(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (Button) objArr[8], (Button) objArr[9], (LinearLayout) objArr[2], (TextView) objArr[5], (TextView) objArr[7], (TextView) objArr[4], (TextView) objArr[6], (TextView) objArr[3]);
        this.m = -1L;
        this.k = (LinearLayout) objArr[0];
        this.k.setTag(null);
        this.l = (TextView) objArr[1];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Long> observableField, int i2) {
        if (i2 != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }
}
