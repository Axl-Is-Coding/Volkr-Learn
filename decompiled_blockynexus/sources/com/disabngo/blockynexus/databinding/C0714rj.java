package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.entity.TribeRecommendation;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rj, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemTribeNoRecommendBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0714rj extends AbstractC0704qj {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8771c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8772d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8773e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f8774f;
    private final ImageView g;
    private final TextView h;
    private final TextView i;
    private final ImageView j;
    private final TextView k;
    private final TextView l;
    private long m;

    static {
        f8772d.put(R.id.rl_head, 8);
    }

    public C0714rj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f8771c, f8772d));
    }

    public void a(com.disabngo.blockynexus.view.fragment.tribeno.i iVar) {
        updateRegistration(0, iVar);
        this.f8742b = iVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        String str;
        String str2;
        String str3;
        Drawable drawableTribeLevel;
        String str4;
        String str5;
        ReplyCommand replyCommand;
        String headPic;
        String detail;
        String name;
        int freeVerify;
        int level;
        synchronized (this) {
            j = this.m;
            this.m = 0L;
        }
        com.disabngo.blockynexus.view.fragment.tribeno.i iVar = this.f8742b;
        long j2 = 7 & j;
        ReplyCommand replyCommand2 = null;
        if (j2 != 0) {
            if ((j & 5) == 0 || iVar == null) {
                str = null;
                replyCommand = null;
                str3 = null;
            } else {
                str = iVar.f12037a;
                replyCommand = iVar.f12039c;
                str3 = iVar.f12038b;
            }
            TribeRecommendation item = iVar != null ? iVar.getItem() : null;
            if (item != null) {
                freeVerify = item.getFreeVerify();
                level = item.getLevel();
                detail = item.getDetail();
                name = item.getName();
                headPic = item.getHeadPic();
            } else {
                headPic = null;
                detail = null;
                name = null;
                freeVerify = 0;
                level = 0;
            }
            Drawable drawableTribeIsLock = ViewReturnTextUtils.tribeIsLock(freeVerify);
            drawableTribeLevel = ViewReturnTextUtils.TribeLevel(level);
            str5 = detail;
            String str6 = name;
            str4 = headPic;
            drawable = drawableTribeIsLock;
            replyCommand2 = replyCommand;
            str2 = str6;
        } else {
            drawable = null;
            str = null;
            str2 = null;
            str3 = null;
            drawableTribeLevel = null;
            str4 = null;
            str5 = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8773e, replyCommand2, false, 0);
            androidx.databinding.a.e.a(this.i, str);
            androidx.databinding.a.e.a(this.k, str3);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f8774f, 0, str4, R.mipmap.ic_tribe_default_head, R.mipmap.ic_tribe_default_head, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.b.a(this.g, drawable);
            androidx.databinding.a.e.a(this.h, str2);
            androidx.databinding.a.b.a(this.j, drawableTribeLevel);
            androidx.databinding.a.e.a(this.l, str5);
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
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.fragment.tribeno.i) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.fragment.tribeno.i) obj);
        return true;
    }

    private C0714rj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RelativeLayout) objArr[8]);
        this.m = -1L;
        this.f8773e = (RelativeLayout) objArr[0];
        this.f8773e.setTag(null);
        this.f8774f = (ImageView) objArr[1];
        this.f8774f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        this.h = (TextView) objArr[3];
        this.h.setTag(null);
        this.i = (TextView) objArr[4];
        this.i.setTag(null);
        this.j = (ImageView) objArr[5];
        this.j.setTag(null);
        this.k = (TextView) objArr[6];
        this.k.setTag(null);
        this.l = (TextView) objArr[7];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.fragment.tribeno.i iVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.m |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }
}
