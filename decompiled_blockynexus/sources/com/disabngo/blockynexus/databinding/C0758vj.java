package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.vj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeSearchBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0758vj extends AbstractC0747uj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8918b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8919c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8922f;
    private final Button g;
    private long h;

    public C0758vj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8918b, f8919c));
    }

    public void a(com.disabngo.blockynexus.view.activity.tribesearch.h hVar) {
        updateRegistration(0, hVar);
        this.f8884a = hVar;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        String headPic;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.view.activity.tribesearch.h hVar = this.f8884a;
        long j2 = 7 & j;
        String name = null;
        if (j2 != 0) {
            if ((j & 5) == 0 || hVar == null) {
                replyCommand = null;
                replyCommand2 = null;
            } else {
                replyCommand = hVar.f11135b;
                replyCommand2 = hVar.f11134a;
            }
            TribeRecommendation item = hVar != null ? hVar.getItem() : null;
            if (item != null) {
                name = item.getName();
                headPic = item.getHeadPic();
            } else {
                headPic = null;
            }
        } else {
            replyCommand = null;
            replyCommand2 = null;
            headPic = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8920d, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f8921e, 0, headPic, R.mipmap.ic_tribe_default_head, R.mipmap.ic_tribe_default_head, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f8922f, name);
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
        return a((com.disabngo.blockynexus.view.activity.tribesearch.h) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.tribesearch.h) obj);
        return true;
    }

    private C0758vj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.h = -1L;
        this.f8920d = (LinearLayout) objArr[0];
        this.f8920d.setTag(null);
        this.f8921e = (ImageView) objArr[1];
        this.f8921e.setTag(null);
        this.f8922f = (TextView) objArr[2];
        this.f8922f.setTag(null);
        this.g = (Button) objArr[3];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.tribesearch.h hVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.h |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.h |= 2;
        }
        return true;
    }
}
