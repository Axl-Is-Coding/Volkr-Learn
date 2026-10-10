package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemGroupNoticeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Dh extends Ch {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7396c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7397d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f7398e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private long f7399f;

    public Dh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 2, f7396c, f7397d));
    }

    public void a(com.disabngo.blockynexus.e.b.G.c cVar) {
        updateRegistration(1, cVar);
        this.f7355b = cVar;
        synchronized (this) {
            this.f7399f |= 2;
        }
        notifyPropertyChanged(288);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        synchronized (this) {
            j = this.f7399f;
            this.f7399f = 0L;
        }
        com.disabngo.blockynexus.e.b.G.c cVar = this.f7355b;
        long j2 = 7 & j;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            ObservableField<String> observableField = cVar != null ? cVar.f9286b : null;
            updateRegistration(0, observableField);
            String str2 = observableField != null ? observableField.get() : null;
            if ((j & 6) != 0 && cVar != null) {
                replyCommand = cVar.f9287c;
            }
            str = str2;
        } else {
            str = null;
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f7354a, 0, str, R.mipmap.ic_head_default, R.mipmap.ic_head_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
        if ((j & 6) != 0) {
            ViewBindingAdapters.clickCommand(this.f7354a, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.f7399f != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f7399f = 4L;
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
        return a((com.disabngo.blockynexus.e.b.G.c) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (288 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.G.c) obj);
        return true;
    }

    private Dh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1]);
        this.f7399f = -1L;
        this.f7354a.setTag(null);
        this.f7398e = (ConstraintLayout) objArr[0];
        this.f7398e.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(ObservableField<String> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7399f |= 1;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.e.b.G.c cVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.f7399f |= 2;
        }
        return true;
    }
}
