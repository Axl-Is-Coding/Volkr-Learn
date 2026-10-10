package com.sandboxol.gamedetail.a;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.center.entity.CampaignRank;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.gamedetail.R;

/* JADX INFO: compiled from: ItemGameDetailFirstRankBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class F extends E {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17790e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17791f = new SparseIntArray();
    private final ConstraintLayout g;
    private final ImageView h;
    private final AppCompatTextView i;
    private final TextView j;
    private long k;

    static {
        f17791f.put(R.id.rl_head, 6);
    }

    public F(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f17790e, f17791f));
    }

    public void a(com.sandboxol.gamedetail.c.a.c.i iVar) {
        updateRegistration(0, iVar);
        this.f17789d = iVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(com.sandboxol.gamedetail.a.f17769b);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        int i;
        int i2;
        String str2;
        Drawable drawable2;
        String str3;
        String str4;
        int i3;
        ReplyCommand replyCommand;
        int i4;
        int vip;
        String str5;
        String str6;
        String str7;
        String str8;
        long j2;
        long j3;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.sandboxol.gamedetail.c.a.c.i iVar = this.f17789d;
        long j4 = j & 7;
        if (j4 != 0) {
            int i5 = com.sandboxol.center.R.mipmap.ic_head_default;
            updateRegistration(0, iVar);
            CampaignRank item = iVar != null ? iVar.getItem() : null;
            if (item != null) {
                String userRank = item.getUserRank();
                String nickName = item.getNickName();
                String headPic = item.getHeadPic();
                String integralDetail = item.getIntegralDetail();
                int rank = item.getRank();
                vip = item.getVip();
                i4 = rank;
                str8 = integralDetail;
                str7 = headPic;
                str6 = nickName;
                str5 = userRank;
            } else {
                i4 = 0;
                vip = 0;
                str5 = null;
                str6 = null;
                str7 = null;
                str8 = null;
            }
            Drawable gameDetailRankBg = ViewReturnTextUtils.getGameDetailRankBg(i4);
            boolean z = i4 > 3;
            Drawable drawableReturnVipIcon = ViewReturnTextUtils.returnVipIcon(vip);
            if (j4 != 0) {
                if (z) {
                    j2 = j | 16;
                    j3 = 64;
                } else {
                    j2 = j | 8;
                    j3 = 32;
                }
                j = j2 | j3;
            }
            i = z ? 8 : 0;
            int i6 = z ? 0 : 8;
            if ((j & 5) == 0 || iVar == null) {
                i2 = i6;
                str = str5;
                str2 = str6;
                str4 = str7;
                drawable = gameDetailRankBg;
                replyCommand = null;
                i3 = i5;
                drawable2 = drawableReturnVipIcon;
            } else {
                replyCommand = iVar.f18086a;
                str2 = str6;
                str4 = str7;
                drawable = gameDetailRankBg;
                i2 = i6;
                i3 = i5;
                drawable2 = drawableReturnVipIcon;
                str = str5;
            }
            str3 = str8;
        } else {
            drawable = null;
            str = null;
            i = 0;
            i2 = 0;
            str2 = null;
            drawable2 = null;
            str3 = null;
            str4 = null;
            i3 = 0;
            replyCommand = null;
        }
        if ((7 & j) != 0) {
            ImageViewBindingAdapters.loadImage(this.f17786a, 0, str4, i3, i3, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.b.a(this.h, drawable);
            this.h.setVisibility(i);
            androidx.databinding.a.e.a(this.i, str);
            this.i.setVisibility(i2);
            androidx.databinding.a.e.a(this.j, str3);
            androidx.databinding.a.e.c(this.f17788c, drawable2);
            androidx.databinding.a.e.a(this.f17788c, str2);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
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
        if (i != 0) {
            return false;
        }
        return a((com.sandboxol.gamedetail.c.a.c.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.gamedetail.a.f17769b != i) {
            return false;
        }
        a((com.sandboxol.gamedetail.c.a.c.i) obj);
        return true;
    }

    private F(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (ImageView) objArr[3], (RelativeLayout) objArr[6], (TextView) objArr[4]);
        this.k = -1L;
        this.f17786a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.i = (AppCompatTextView) objArr[2];
        this.i.setTag(null);
        this.j = (TextView) objArr[5];
        this.j.setTag(null);
        this.f17788c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.sandboxol.gamedetail.c.a.c.i iVar, int i) {
        if (i == com.sandboxol.gamedetail.a.f17768a) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != com.sandboxol.gamedetail.a.m) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
