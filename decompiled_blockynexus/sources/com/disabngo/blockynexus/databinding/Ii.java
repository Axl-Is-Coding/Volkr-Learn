package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.TopRankInfo;

/* JADX INFO: compiled from: ItemRankRightTypeBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ii extends Hi {
    private static final ViewDataBinding.b h = null;
    private static final SparseIntArray i = new SparseIntArray();
    private final ConstraintLayout j;
    private final TextView k;
    private final TextView l;
    private long m;

    static {
        i.put(R.id.iv_rank_type, 7);
        i.put(R.id.iv_rank_type_value, 8);
    }

    public Ii(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, h, i));
    }

    public void a(com.disabngo.blockynexus.view.activity.overviewrank.f fVar) {
        updateRegistration(0, fVar);
        this.g = fVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(260);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        Drawable drawable2;
        String str2;
        String str3;
        String str4;
        String str5;
        int i2;
        ReplyCommand replyCommand;
        long quantity;
        String topName;
        String type;
        String topPic;
        synchronized (this) {
            j = this.m;
            this.m = 0L;
        }
        com.disabngo.blockynexus.view.activity.overviewrank.f fVar = this.g;
        long j2 = j & 7;
        if (j2 != 0) {
            TopRankInfo item = fVar != null ? fVar.getItem() : null;
            if (item != null) {
                type = item.getType();
                topPic = item.getTopPic();
                quantity = item.getQuantity();
                topName = item.getTopName();
            } else {
                quantity = 0;
                topName = null;
                type = null;
                topPic = null;
            }
            Drawable drawableE = com.disabngo.blockynexus.d.G.e(type);
            String strD = com.disabngo.blockynexus.d.G.d(type);
            Drawable drawableC = com.disabngo.blockynexus.d.G.c(type);
            String strB = com.disabngo.blockynexus.d.G.b(type);
            String strValueOf = String.valueOf(quantity);
            boolean zEquals = type != null ? type.equals("clan") : false;
            if (j2 != 0) {
                j |= zEquals ? 16L : 8L;
            }
            int i3 = zEquals ? R.mipmap.ic_tribe_default_head : R.mipmap.ic_head_default;
            if ((j & 5) == 0 || fVar == null) {
                str2 = topName;
                str5 = topPic;
                str4 = strValueOf;
                drawable2 = drawableE;
                drawable = drawableC;
                str3 = strB;
                replyCommand = null;
            } else {
                replyCommand = fVar.f11044a;
                str2 = topName;
                str5 = topPic;
                str4 = strValueOf;
                drawable2 = drawableE;
                drawable = drawableC;
                str3 = strB;
            }
            i2 = i3;
            str = strD;
        } else {
            drawable = null;
            str = null;
            drawable2 = null;
            str2 = null;
            str3 = null;
            str4 = null;
            str5 = null;
            i2 = 0;
            replyCommand = null;
        }
        if ((7 & j) != 0) {
            androidx.databinding.a.f.a(this.f7529b, drawable);
            ImageViewBindingAdapters.loadImage(this.f7530c, 0, str5, i2, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.k, str);
            androidx.databinding.a.e.b(this.l, drawable2);
            androidx.databinding.a.e.a(this.l, str4);
            androidx.databinding.a.e.a(this.f7532e, str3);
            androidx.databinding.a.e.a(this.f7533f, str2);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
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
        if (i2 != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.overviewrank.f) obj, i3);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i2, Object obj) {
        if (260 != i2) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.overviewrank.f) obj);
        return true;
    }

    private Ii(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[7], (ImageView) objArr[2], (ImageView) objArr[3], (RelativeLayout) objArr[8], (TextView) objArr[1], (TextView) objArr[4]);
        this.m = -1L;
        this.f7529b.setTag(null);
        this.f7530c.setTag(null);
        this.j = (ConstraintLayout) objArr[0];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.l = (TextView) objArr[6];
        this.l.setTag(null);
        this.f7532e.setTag(null);
        this.f7533f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.overviewrank.f fVar, int i2) {
        if (i2 == 0) {
            synchronized (this) {
                this.m |= 1;
            }
            return true;
        }
        if (i2 != 244) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }
}
