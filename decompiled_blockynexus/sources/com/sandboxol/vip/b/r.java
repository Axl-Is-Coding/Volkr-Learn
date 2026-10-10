package com.sandboxol.vip.b;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.vip.R;
import com.sandboxol.vip.entity.PrivilegeInfo;

/* JADX INFO: compiled from: VipListItemMorePrivilegeBindingImpl.java */
/* JADX INFO: loaded from: classes4.dex */
public class r extends q {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ViewDataBinding.b f19017d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f19018e = new SparseIntArray();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ConstraintLayout f19019f;
    private final TextView g;
    private long h;

    static {
        f19018e.put(R.id.v_bg, 3);
    }

    public r(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f19017d, f19018e));
    }

    public void a(com.sandboxol.vip.view.fragment.main.k kVar) {
        updateRegistration(0, kVar);
        this.f19016c = kVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(com.sandboxol.vip.a.g);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String title;
        int i;
        int thumbnailRes;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.sandboxol.vip.view.fragment.main.k kVar = this.f19016c;
        long j2 = 7 & j;
        ReplyCommand replyCommand = null;
        if (j2 != 0) {
            PrivilegeInfo item = kVar != null ? kVar.getItem() : null;
            if (item != null) {
                title = item.getTitle();
                thumbnailRes = item.getThumbnailRes();
            } else {
                title = null;
                thumbnailRes = 0;
            }
            if ((j & 5) != 0 && kVar != null) {
                replyCommand = kVar.f19099b;
            }
            i = thumbnailRes;
        } else {
            title = null;
            i = 0;
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f19014a, 0, null, i, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.g, title);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f19019f, replyCommand, false, 0);
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
            this.h = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.vip.view.fragment.main.k) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.vip.a.g != i) {
            return false;
        }
        a((com.sandboxol.vip.view.fragment.main.k) obj);
        return true;
    }

    private r(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[1], (View) objArr[3]);
        this.h = -1L;
        this.f19014a.setTag(null);
        this.f19019f = (ConstraintLayout) objArr[0];
        this.f19019f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.vip.view.fragment.main.k kVar, int i) {
        if (i == com.sandboxol.vip.a.f18951a) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.vip.a.h) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
