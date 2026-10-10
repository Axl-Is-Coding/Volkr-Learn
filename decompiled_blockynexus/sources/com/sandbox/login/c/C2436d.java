package com.sandbox.login.c;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.material.card.MaterialCardView;
import com.sandbox.login.R;
import com.sandbox.login.entity.UserRecord;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.sandbox.login.c.d, reason: case insensitive filesystem */
/* JADX INFO: compiled from: LoginAccountListItemBindingImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public class C2436d extends AbstractC2435c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f15633c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f15634d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConstraintLayout f15635e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f15636f;
    private final ImageView g;
    private final ImageView h;
    private long i;

    static {
        f15634d.put(R.id.userIcon, 4);
    }

    public C2436d(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f15633c, f15634d));
    }

    public void a(com.sandbox.login.view.widget.account.f fVar) {
        updateRegistration(0, fVar);
        this.f15632b = fVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(com.sandbox.login.g.f15905b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        String userIcon;
        int i;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.sandbox.login.view.widget.account.f fVar = this.f15632b;
        long j2 = 7 & j;
        String uid = null;
        if (j2 != 0) {
            int i2 = R.mipmap.login_ic_head_default;
            updateRegistration(0, fVar);
            if ((j & 5) == 0 || fVar == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = fVar.f16006a;
                replyCommand2 = fVar.f16007b;
            }
            UserRecord item = fVar != null ? fVar.getItem() : null;
            if (item != null) {
                uid = item.getUid();
                userIcon = item.getUserIcon();
            } else {
                userIcon = null;
            }
            i = i2;
        } else {
            replyCommand = null;
            replyCommand2 = null;
            userIcon = null;
            i = 0;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f15635e, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f15636f, uid);
            ImageViewBindingAdapters.loadImage(this.g, 0, userIcon, i, i, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandbox.login.view.widget.account.f) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandbox.login.g.f15905b != i) {
            return false;
        }
        a((com.sandbox.login.view.widget.account.f) obj);
        return true;
    }

    private C2436d(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (MaterialCardView) objArr[4]);
        this.i = -1L;
        this.f15635e = (ConstraintLayout) objArr[0];
        this.f15635e.setTag(null);
        this.f15636f = (TextView) objArr[1];
        this.f15636f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        this.h = (ImageView) objArr[3];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandbox.login.view.widget.account.f fVar, int i) {
        if (i == com.sandbox.login.g.f15904a) {
            synchronized (this) {
                this.i |= 1;
            }
            return true;
        }
        if (i != com.sandbox.login.g.f15908e) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
