package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.google.android.material.appbar.AppBarLayout;
import com.sandboxol.center.utils.ViewReturnTextUtils;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.PageRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.CommonHelper;
import com.sandboxol.common.widget.rv.pagerv.PageRecyclerView;
import com.sandboxol.greendao.entity.VideoDetailInfo;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.b, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ActivityAppVideoDetailBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0528b extends AbstractC0516a {
    private static final ViewDataBinding.b p = null;
    private static final SparseIntArray q = new SparseIntArray();
    private final ConstraintLayout r;
    private final AppCompatTextView s;
    private final AppCompatTextView t;
    private final PageRecyclerView u;
    private long v;

    static {
        q.put(R.id.appCompatTextView14, 13);
        q.put(R.id.webView, 14);
        q.put(R.id.Bl, 15);
        q.put(R.id.constraintLayout4, 16);
        q.put(R.id.view22, 17);
    }

    public C0528b(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 18, p, q));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0516a
    public void a(com.disabngo.blockynexus.view.activity.videodetail.y yVar) {
        updateRegistration(1, yVar);
        this.o = yVar;
        synchronized (this) {
            this.v |= 2;
        }
        notifyPropertyChanged(1);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        Drawable drawable;
        Drawable drawable2;
        ReplyCommand replyCommand;
        ReplyCommand replyCommand2;
        ReplyCommand replyCommand3;
        ReplyCommand replyCommand4;
        ReplyCommand replyCommand5;
        String str;
        String str2;
        com.disabngo.blockynexus.view.activity.videodetail.j jVar;
        com.disabngo.blockynexus.view.activity.videodetail.w wVar;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        int i;
        ReplyCommand replyCommand6;
        com.disabngo.blockynexus.view.activity.videodetail.j jVar2;
        com.disabngo.blockynexus.view.activity.videodetail.w wVar2;
        String strValueOf;
        Drawable videoDetailDrawableDisLike;
        Drawable videoDetailDrawableLike;
        String countByK;
        long j2;
        String authorPicUrl;
        long j3;
        String title;
        long j4;
        String countByK2;
        synchronized (this) {
            j = this.v;
            this.v = 0L;
        }
        com.disabngo.blockynexus.view.activity.videodetail.y yVar = this.o;
        if ((1023 & j) != 0) {
            if ((j & 514) == 0 || yVar == null) {
                replyCommand6 = null;
                replyCommand = null;
                replyCommand2 = null;
                replyCommand3 = null;
                jVar2 = null;
                replyCommand5 = null;
                wVar2 = null;
            } else {
                ReplyCommand replyCommand7 = yVar.g;
                replyCommand = yVar.h;
                ReplyCommand replyCommand8 = yVar.j;
                replyCommand5 = yVar.f11233f;
                wVar2 = yVar.f11231d;
                replyCommand3 = yVar.i;
                jVar2 = yVar.f11232e;
                replyCommand2 = replyCommand7;
                replyCommand6 = replyCommand8;
            }
            VideoDetailInfo videoDetailInfo = yVar != null ? yVar.f11230c : null;
            updateRegistration(0, videoDetailInfo);
            if ((j & 531) != 0) {
                strValueOf = String.valueOf(videoDetailInfo != null ? videoDetailInfo.getPlayAmount() : 0L);
            } else {
                strValueOf = null;
            }
            String authorName = ((j & 523) == 0 || videoDetailInfo == null) ? null : videoDetailInfo.getAuthorName();
            if ((j & 547) != 0) {
                int evaluateStatus = videoDetailInfo != null ? videoDetailInfo.getEvaluateStatus() : 0;
                videoDetailDrawableLike = ViewReturnTextUtils.getVideoDetailDrawableLike(evaluateStatus);
                videoDetailDrawableDisLike = ViewReturnTextUtils.getVideoDetailDrawableDisLike(evaluateStatus);
            } else {
                videoDetailDrawableDisLike = null;
                videoDetailDrawableLike = null;
            }
            if ((j & 579) != 0) {
                countByK = CommonHelper.getCountByK(videoDetailInfo != null ? videoDetailInfo.getDislikeNumber() : 0);
            } else {
                countByK = null;
            }
            if ((j & 519) == 0 || videoDetailInfo == null) {
                j2 = 771;
                authorPicUrl = null;
            } else {
                authorPicUrl = videoDetailInfo.getAuthorPicUrl();
                j2 = 771;
            }
            if ((j & j2) == 0 || videoDetailInfo == null) {
                j3 = 643;
                title = null;
            } else {
                title = videoDetailInfo.getTitle();
                j3 = 643;
            }
            if ((j & j3) != 0) {
                countByK2 = CommonHelper.getCountByK(videoDetailInfo != null ? videoDetailInfo.getLikeNumber() : 0);
                j4 = 515;
            } else {
                j4 = 515;
                countByK2 = null;
            }
            long j5 = j & j4;
            if (j5 != 0) {
                String topTag = videoDetailInfo != null ? videoDetailInfo.getTopTag() : null;
                boolean zIsEmpty = TextUtils.isEmpty(topTag);
                if (j5 != 0) {
                    j |= zIsEmpty ? PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH : 1024L;
                }
                str7 = topTag;
                i = zIsEmpty ? 8 : 0;
                str4 = authorName;
                drawable = videoDetailDrawableDisLike;
                str3 = countByK;
                str2 = authorPicUrl;
                str6 = title;
                str5 = countByK2;
            } else {
                str4 = authorName;
                drawable = videoDetailDrawableDisLike;
                str3 = countByK;
                str2 = authorPicUrl;
                str6 = title;
                str5 = countByK2;
                str7 = null;
                i = 0;
            }
            jVar = jVar2;
            wVar = wVar2;
            str = strValueOf;
            replyCommand4 = replyCommand6;
            drawable2 = videoDetailDrawableLike;
        } else {
            drawable = null;
            drawable2 = null;
            replyCommand = null;
            replyCommand2 = null;
            replyCommand3 = null;
            replyCommand4 = null;
            replyCommand5 = null;
            str = null;
            str2 = null;
            jVar = null;
            wVar = null;
            str3 = null;
            str4 = null;
            str5 = null;
            str6 = null;
            str7 = null;
            i = 0;
        }
        if ((j & 547) != 0) {
            androidx.databinding.a.f.a(this.f8143b, drawable);
            androidx.databinding.a.f.a(this.f8144c, drawable2);
        }
        if ((j & 514) != 0) {
            ViewBindingAdapters.clickCommand(this.f8143b, replyCommand5, false, 0);
            ViewBindingAdapters.clickCommand(this.f8144c, replyCommand2, false, 0);
            ViewBindingAdapters.clickCommand(this.f8145d, replyCommand3, false, 0);
            ViewBindingAdapters.clickCommand(this.i, replyCommand, false, 0);
            ViewBindingAdapters.clickCommand(this.k, replyCommand4, false, 0);
            PageRecyclerViewBindingAdapters.setPageRecyclerView(this.u, jVar, wVar, null, false, false, false, 0, 0, false, null);
        }
        if ((j & 519) != 0) {
            ImageViewBindingAdapters.loadImage(this.f8145d, 0, str2, R.mipmap.ic_head_default, R.mipmap.ic_head_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
        if ((j & 531) != 0) {
            androidx.databinding.a.e.a(this.f8146e, str);
        }
        if ((579 & j) != 0) {
            androidx.databinding.a.e.a(this.f8147f, str3);
        }
        if ((j & 523) != 0) {
            androidx.databinding.a.e.a(this.h, str4);
        }
        if ((643 & j) != 0) {
            androidx.databinding.a.e.a(this.s, str5);
        }
        if ((771 & j) != 0) {
            androidx.databinding.a.e.a(this.t, str6);
        }
        if ((j & 515) != 0) {
            androidx.databinding.a.e.a(this.l, str7);
            this.l.setVisibility(i);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.v != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.v = 512L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((VideoDetailInfo) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((com.disabngo.blockynexus.view.activity.videodetail.y) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (1 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.activity.videodetail.y) obj);
        return true;
    }

    private C0528b(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (AppBarLayout) objArr[15], (AppCompatImageView) objArr[7], (AppCompatImageView) objArr[8], (AppCompatImageView) objArr[2], (AppCompatTextView) objArr[6], (AppCompatTextView) objArr[9], (AppCompatTextView) objArr[13], (AppCompatTextView) objArr[3], (AppCompatTextView) objArr[4], (ConstraintLayout) objArr[16], (ImageButton) objArr[1], (AppCompatTextView) objArr[5], (View) objArr[17], (LinearLayout) objArr[14]);
        this.v = -1L;
        this.f8143b.setTag(null);
        this.f8144c.setTag(null);
        this.f8145d.setTag(null);
        this.f8146e.setTag(null);
        this.f8147f.setTag(null);
        this.h.setTag(null);
        this.i.setTag(null);
        this.k.setTag(null);
        this.r = (ConstraintLayout) objArr[0];
        this.r.setTag(null);
        this.s = (AppCompatTextView) objArr[10];
        this.s.setTag(null);
        this.t = (AppCompatTextView) objArr[11];
        this.t.setTag(null);
        this.u = (PageRecyclerView) objArr[12];
        this.u.setTag(null);
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(VideoDetailInfo videoDetailInfo, int i) {
        if (i == 0) {
            synchronized (this) {
                this.v |= 1;
            }
            return true;
        }
        if (i == 27) {
            synchronized (this) {
                this.v |= 4;
            }
            return true;
        }
        if (i == 26) {
            synchronized (this) {
                this.v |= 8;
            }
            return true;
        }
        if (i == 24) {
            synchronized (this) {
                this.v |= 16;
            }
            return true;
        }
        if (i == 8) {
            synchronized (this) {
                this.v |= 32;
            }
            return true;
        }
        if (i == 5) {
            synchronized (this) {
                this.v |= 64;
            }
            return true;
        }
        if (i == 28) {
            synchronized (this) {
                this.v |= 128;
            }
            return true;
        }
        if (i != 7) {
            return false;
        }
        synchronized (this) {
            this.v |= 256;
        }
        return true;
    }

    private boolean a(com.disabngo.blockynexus.view.activity.videodetail.y yVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.v |= 2;
        }
        return true;
    }
}
