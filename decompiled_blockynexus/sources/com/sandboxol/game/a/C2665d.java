package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blockmango.webvideo.WebVideoViewModel;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.game.R;

/* JADX INFO: renamed from: com.sandboxol.game.a.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityWebVideoBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2665d extends AbstractC2664c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f17668c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f17669d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f17670e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f17671f;
    private long g;

    static {
        f17669d.put(R.id.webView, 2);
    }

    public C2665d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f17668c, f17669d));
    }

    @Override // com.sandboxol.game.a.AbstractC2664c
    public void a(WebVideoViewModel webVideoViewModel) {
        updateRegistration(0, webVideoViewModel);
        this.f17667b = webVideoViewModel;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(com.sandboxol.game.a.i);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        WebVideoViewModel webVideoViewModel = this.f17667b;
        ReplyCommand replyCommand = null;
        long j2 = j & 3;
        if (j2 != 0 && webVideoViewModel != null) {
            replyCommand = webVideoViewModel.onCloseCommand;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.f17671f, replyCommand, false, 0);
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
            this.g = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((WebVideoViewModel) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.i != i) {
            return false;
        }
        a((WebVideoViewModel) obj);
        return true;
    }

    private C2665d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[2]);
        this.g = -1L;
        this.f17670e = (ConstraintLayout) objArr[0];
        this.f17670e.setTag(null);
        this.f17671f = (ImageView) objArr[1];
        this.f17671f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(WebVideoViewModel webVideoViewModel, int i) {
        if (i != com.sandboxol.game.a.f17626a) {
            return false;
        }
        synchronized (this) {
            this.g |= 1;
        }
        return true;
    }
}
