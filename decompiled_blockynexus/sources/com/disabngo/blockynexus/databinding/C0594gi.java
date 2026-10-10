package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.GroupMember;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.gi, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemMemberListBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0594gi extends AbstractC0583fi {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8383b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8384c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8385d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8386e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8387f;
    private long g;

    public C0594gi(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f8383b, f8384c));
    }

    public void a(com.disabngo.blockynexus.e.b.D.x xVar) {
        updateRegistration(0, xVar);
        this.f8345a = xVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        String pic;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.e.b.D.x xVar = this.f8345a;
        long j2 = 7 & j;
        String userName = null;
        if (j2 != 0) {
            replyCommand = ((j & 5) == 0 || xVar == null) ? null : xVar.f9200a;
            GroupMember item = xVar != null ? xVar.getItem() : null;
            if (item != null) {
                userName = item.getUserName();
                pic = item.getPic();
            } else {
                pic = null;
            }
        } else {
            replyCommand = null;
            pic = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8385d, replyCommand, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f8386e, 0, pic, R.mipmap.ic_head_default, R.mipmap.ic_head_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f8387f, userName);
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
            this.g = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.D.x) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.D.x) obj);
        return true;
    }

    private C0594gi(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f8385d = (LinearLayout) objArr[0];
        this.f8385d.setTag(null);
        this.f8386e = (ImageView) objArr[1];
        this.f8386e.setTag(null);
        this.f8387f = (TextView) objArr[2];
        this.f8387f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.D.x xVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.g |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.g |= 2;
        }
        return true;
    }
}
