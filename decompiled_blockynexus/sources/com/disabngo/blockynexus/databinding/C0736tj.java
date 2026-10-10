package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRank;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.tj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeRankPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0736tj extends AbstractC0725sj {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8849b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8850c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f8851d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final TextView f8852e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f8853f;
    private final TextView g;
    private final TextView h;
    private long i;

    public C0736tj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8849b, f8850c));
    }

    public void a(com.disabngo.blockynexus.e.b.ra.i iVar) {
        updateRegistration(0, iVar);
        this.f8810a = iVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String headPic;
        ReplyCommand replyCommand;
        String str2;
        ReplyCommand replyCommand2;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.e.b.ra.i iVar = this.f8810a;
        long j2 = 7 & j;
        String rank = null;
        if (j2 != 0) {
            ReplyCommand replyCommand3 = ((j & 5) == 0 || iVar == null) ? null : iVar.f10135a;
            TribeRank item = iVar != null ? iVar.getItem() : null;
            if (item != null) {
                rank = item.getRank();
                String experience = item.getExperience();
                String name = item.getName();
                replyCommand = replyCommand3;
                str2 = experience;
                headPic = item.getHeadPic();
                str = name;
            } else {
                str = null;
                headPic = null;
                str2 = null;
                replyCommand = replyCommand3;
            }
        } else {
            str = null;
            headPic = null;
            replyCommand = null;
            str2 = null;
        }
        if (j2 != 0) {
            androidx.databinding.a.e.a(this.f8852e, rank);
            replyCommand2 = replyCommand;
            ImageViewBindingAdapters.loadImage(this.f8853f, 0, headPic, R.mipmap.ic_tribe_default_head, R.mipmap.ic_tribe_default_head, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.g, str);
            androidx.databinding.a.e.a(this.h, str2);
        } else {
            replyCommand2 = replyCommand;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8853f, replyCommand2, false, 0);
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
        return a((com.disabngo.blockynexus.e.b.ra.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ra.i) obj);
        return true;
    }

    private C0736tj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.i = -1L;
        this.f8851d = (LinearLayout) objArr[0];
        this.f8851d.setTag(null);
        this.f8852e = (TextView) objArr[1];
        this.f8852e.setTag(null);
        this.f8853f = (ImageView) objArr[2];
        this.f8853f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ra.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.i |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.i |= 2;
        }
        return true;
    }
}
