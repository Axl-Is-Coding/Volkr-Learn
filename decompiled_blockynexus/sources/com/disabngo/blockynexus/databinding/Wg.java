package com.disabngo.blockynexus.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: ItemAppVideoDetailMoreBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Wg extends Vg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8009f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ConstraintLayout h;
    private final AppCompatTextView i;
    private final AppCompatTextView j;
    private final AppCompatTextView k;
    private long l;

    static {
        g.put(R.id.view10, 7);
    }

    public Wg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8009f, g));
    }

    public void a(com.disabngo.blockynexus.view.activity.videodetail.u uVar) {
        updateRegistration(0, uVar);
        this.f7975e = uVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [com.sandboxol.common.command.ReplyCommand] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.CharSequence] */
    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String str3;
        String title;
        String str4;
        Object obj;
        int i;
        long playAmount;
        String authorNameTotal;
        String topTag;
        String videoPic;
        String videoTimeByHours;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.view.activity.videodetail.u uVar = this.f7975e;
        long j2 = j & 7;
        Object obj2 = null;
        if (j2 != 0) {
            VideoInfo item = uVar != null ? uVar.getItem() : null;
            if (item != null) {
                playAmount = item.getPlayAmount();
                authorNameTotal = item.getAuthorNameTotal();
                topTag = item.getTopTag();
                videoPic = item.getVideoPic();
                videoTimeByHours = item.getVideoTimeByHours();
                title = item.getTitle();
            } else {
                playAmount = 0;
                title = null;
                authorNameTotal = null;
                topTag = null;
                videoPic = null;
                videoTimeByHours = null;
            }
            String strValueOf = String.valueOf(playAmount);
            boolean zIsEmpty = TextUtils.isEmpty(topTag);
            if (j2 != 0) {
                j |= zIsEmpty ? 16L : 8L;
            }
            int i2 = zIsEmpty ? 8 : 0;
            if ((j & 5) != 0 && uVar != null) {
                obj2 = uVar.f11221a;
            }
            i = i2;
            obj = obj2;
            str2 = strValueOf;
            str = authorNameTotal;
            obj2 = topTag;
            str4 = videoPic;
            str3 = videoTimeByHours;
        } else {
            str = null;
            str2 = null;
            str3 = null;
            title = null;
            str4 = null;
            obj = null;
            i = 0;
        }
        if ((7 & j) != 0) {
            ImageViewBindingAdapters.loadImage(this.f7971a, 0, str4, R.mipmap.app_fragment_video_recomment_item_default, R.mipmap.app_fragment_video_recomment_item_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f7972b, str);
            androidx.databinding.a.e.a(this.i, str2);
            androidx.databinding.a.e.a(this.j, str3);
            androidx.databinding.a.e.a(this.k, title);
            androidx.databinding.a.e.a((TextView) this.f7973c, (CharSequence) obj2);
            this.f7973c.setVisibility(i);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.h, obj, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.l != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.l = 4L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.videodetail.u) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.videodetail.u) obj);
        return true;
    }

    private Wg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (AppCompatImageView) objArr[1], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[5], (View) objArr[7]);
        this.l = -1L;
        this.f7971a.setTag(null);
        this.f7972b.setTag(null);
        this.h = (ConstraintLayout) objArr[0];
        this.h.setTag(null);
        this.i = (AppCompatTextView) objArr[2];
        this.i.setTag(null);
        this.j = (AppCompatTextView) objArr[3];
        this.j.setTag(null);
        this.k = (AppCompatTextView) objArr[6];
        this.k.setTag(null);
        this.f7973c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.activity.videodetail.u uVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.l |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.l |= 2;
        }
        return true;
    }
}
