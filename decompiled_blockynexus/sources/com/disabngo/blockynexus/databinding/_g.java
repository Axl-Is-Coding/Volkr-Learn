package com.disabngo.blockynexus.databinding;

import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.VideoInfo;

/* JADX INFO: compiled from: ItemAppVideoRecommendPageBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class _g extends Zg {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ViewDataBinding.b f8131f = null;
    private static final SparseIntArray g = new SparseIntArray();
    private final ScaleRelativeLayout h;
    private final AppCompatImageView i;
    private final AppCompatTextView j;
    private final AppCompatTextView k;
    private long l;

    static {
        g.put(R.id.appCompatImageView2, 6);
        g.put(R.id.view10, 7);
    }

    public _g(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 8, f8131f, g));
    }

    public void a(com.disabngo.blockynexus.e.b.xa.j jVar) {
        updateRegistration(0, jVar);
        this.f8106e = jVar;
        synchronized (this) {
            this.l |= 1;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        String title;
        ReplyCommand replyCommand;
        String str3;
        int i;
        int i2;
        ReplyCommand replyCommand2;
        long playAmount;
        String topTag;
        String videoPic;
        String videoTimeByHours;
        synchronized (this) {
            j = this.l;
            this.l = 0L;
        }
        com.disabngo.blockynexus.e.b.xa.j jVar = this.f8106e;
        long j2 = j & 7;
        String str4 = null;
        replyCommand = null;
        ReplyCommand replyCommand3 = null;
        if (j2 != 0) {
            VideoInfo item = jVar != null ? jVar.getItem() : null;
            if (item != null) {
                playAmount = item.getPlayAmount();
                topTag = item.getTopTag();
                videoPic = item.getVideoPic();
                videoTimeByHours = item.getVideoTimeByHours();
                title = item.getTitle();
            } else {
                playAmount = 0;
                title = null;
                topTag = null;
                videoPic = null;
                videoTimeByHours = null;
            }
            String strValueOf = String.valueOf(playAmount);
            boolean zIsEmpty = TextUtils.isEmpty(topTag);
            boolean zIsEmpty2 = TextUtils.isEmpty(videoPic);
            if (j2 != 0) {
                j |= zIsEmpty ? 16L : 8L;
            }
            if ((j & 7) != 0) {
                j |= zIsEmpty2 ? 64L : 32L;
            }
            int i3 = zIsEmpty ? 8 : 0;
            int i4 = zIsEmpty2 ? R.mipmap.app_fragment_video_recomment_item_default : 0;
            if ((j & 5) != 0 && jVar != null) {
                replyCommand3 = jVar.f10329a;
            }
            i2 = i4;
            str = videoTimeByHours;
            i = i3;
            str2 = topTag;
            str3 = videoPic;
            replyCommand = replyCommand3;
            str4 = strValueOf;
        } else {
            str = null;
            str2 = null;
            title = null;
            replyCommand = null;
            str3 = null;
            i = 0;
            i2 = 0;
        }
        if ((7 & j) != 0) {
            androidx.databinding.a.e.a(this.f8103b, title);
            replyCommand2 = replyCommand;
            ImageViewBindingAdapters.loadImage(this.i, i2, str3, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.j, str4);
            androidx.databinding.a.e.a(this.k, str);
            androidx.databinding.a.e.a(this.f8104c, str2);
            this.f8104c.setVisibility(i);
        } else {
            replyCommand2 = replyCommand;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand2, false, 0);
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
        return a((com.disabngo.blockynexus.e.b.xa.j) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.xa.j) obj);
        return true;
    }

    private _g(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RelativeLayout) objArr[6], (AppCompatTextView) objArr[4], (AppCompatTextView) objArr[5], (View) objArr[7]);
        this.l = -1L;
        this.f8103b.setTag(null);
        this.h = (ScaleRelativeLayout) objArr[0];
        this.h.setTag(null);
        this.i = (AppCompatImageView) objArr[1];
        this.i.setTag(null);
        this.j = (AppCompatTextView) objArr[2];
        this.j.setTag(null);
        this.k = (AppCompatTextView) objArr[3];
        this.k.setTag(null);
        this.f8104c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.xa.j jVar, int i) {
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
