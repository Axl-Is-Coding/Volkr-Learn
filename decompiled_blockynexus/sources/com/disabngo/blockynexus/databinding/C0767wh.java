package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.view.fragment.groupbannedtimelist.GroupBannedTimeItemViewModel;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.wh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemGroupBanTimeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0767wh extends AbstractC0756vh {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8939c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8940d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f8941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final CheckBox f8942f;
    private long g;

    public C0767wh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8939c, f8940d));
    }

    public void a(GroupBannedTimeItemViewModel groupBannedTimeItemViewModel) {
        updateRegistration(1, groupBannedTimeItemViewModel);
        this.f8915b = groupBannedTimeItemViewModel;
        synchronized (this) {
            this.g |= 2;
        }
        notifyPropertyChanged(313);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String item;
        boolean z;
        ObservableField<String> observableField;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        GroupBannedTimeItemViewModel groupBannedTimeItemViewModel = this.f8915b;
        long j2 = j & 15;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            if (groupBannedTimeItemViewModel != null) {
                item = groupBannedTimeItemViewModel.getItem();
                observableField = groupBannedTimeItemViewModel.f11718a;
            } else {
                item = null;
                observableField = null;
            }
            updateRegistration(0, observableField);
            boolean zEquals = item != null ? item.equals(observableField != null ? observableField.get() : null) : false;
            if (j2 != 0) {
                j |= zEquals ? 32L : 16L;
            }
            z = zEquals;
            if ((j & 10) != 0 && groupBannedTimeItemViewModel != null) {
                replyCommand = groupBannedTimeItemViewModel.f11719b;
            }
        } else {
            item = null;
            z = false;
        }
        if ((10 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.f8941e, replyCommand, false, 0);
        }
        if ((15 & j) != 0) {
            androidx.databinding.a.a.a(this.f8942f, z);
        }
        if ((j & 14) != 0) {
            androidx.databinding.a.e.a(this.f8914a, item);
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
            this.g = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((ObservableField<String>) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((GroupBannedTimeItemViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (313 != i) {
            return false;
        }
        a((GroupBannedTimeItemViewModel) obj);
        return true;
    }

    private C0767wh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (TextView) objArr[1]);
        this.g = -1L;
        this.f8941e = (ConstraintLayout) objArr[0];
        this.f8941e.setTag(null);
        this.f8942f = (CheckBox) objArr[2];
        this.f8942f.setTag(null);
        this.f8914a.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }

    private boolean a(GroupBannedTimeItemViewModel groupBannedTimeItemViewModel, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 2;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 4;
        }
        return true;
    }
}
