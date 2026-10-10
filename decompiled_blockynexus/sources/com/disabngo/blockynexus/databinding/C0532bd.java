package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.RadioGroupBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.bd, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentAppVideoBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0532bd extends AbstractC0520ad {
    private static final ViewDataBinding.b g = null;
    private static final SparseIntArray h = new SparseIntArray();
    private final LinearLayout i;
    private final RadioGroup j;
    private long k;

    static {
        h.put(R.id.rbRecommend, 4);
        h.put(R.id.rbAll, 5);
        h.put(R.id.flVideo, 6);
    }

    public C0532bd(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, g, h));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0520ad
    public void a(com.disabngo.blockynexus.e.b.wa.d dVar) {
        updateRegistration(1, dVar);
        this.f8163f = dVar;
        synchronized (this) {
            this.k |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        int iSafeUnbox;
        int i;
        ObservableField<Integer> observableField;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.wa.d dVar = this.f8163f;
        long j2 = j & 7;
        ReplyCommand<RadioGroupBindingAdapters.CheckedDataWrapper> replyCommand2 = null;
        if (j2 != 0) {
            if (dVar != null) {
                replyCommand = dVar.h;
                observableField = dVar.g;
            } else {
                observableField = null;
                replyCommand = null;
            }
            updateRegistration(0, observableField);
            iSafeUnbox = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null);
            boolean z = iSafeUnbox == R.id.rbRecommend;
            boolean z2 = iSafeUnbox == R.id.rbAll;
            if (j2 != 0) {
                j |= z ? 64L : 32L;
            }
            if ((j & 7) != 0) {
                j |= z2 ? 16L : 8L;
            }
            i = z ? 0 : 4;
            i = z2 ? 0 : 4;
            replyCommand2 = replyCommand;
        } else {
            iSafeUnbox = 0;
            i = 0;
        }
        if ((j & 7) != 0) {
            this.f8159b.setVisibility(i);
            this.f8160c.setVisibility(i);
            RadioGroupBindingAdapters.onCheckedChangeListener(this.j, replyCommand2, iSafeUnbox);
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
            return a((ObservableField<Integer>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.wa.d) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.wa.d) obj);
        return true;
    }

    private C0532bd(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (FrameLayout) objArr[6], (ImageView) objArr[2], (ImageView) objArr[3], (AppCompatRadioButton) objArr[5], (AppCompatRadioButton) objArr[4]);
        this.k = -1L;
        this.f8159b.setTag(null);
        this.f8160c.setTag(null);
        this.i = (LinearLayout) objArr[0];
        this.i.setTag(null);
        this.j = (RadioGroup) objArr[1];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<Integer> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.wa.d dVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
