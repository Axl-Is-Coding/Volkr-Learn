package com.disabngo.blockynexus.databinding;

import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.entity.ActivityTaskAction;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemActivityTaskContentTopBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Qg extends Pg {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7812b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7813c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ConstraintLayout f7814d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinearLayout f7815e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7816f;
    private final TextView g;
    private final RelativeLayout h;
    private final ImageView i;
    private final ImageView j;
    private long k;

    public Qg(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7812b, f7813c));
    }

    public void a(com.disabngo.blockynexus.view.dialog.activity.t tVar) {
        updateRegistration(0, tVar);
        this.f7776a = tVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        String str3;
        ReplyCommand replyCommand;
        int topType;
        String dateDesc;
        String content;
        String pic;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.view.dialog.activity.t tVar = this.f7776a;
        long j2 = j & 7;
        if (j2 != 0) {
            ActivityTaskAction item = tVar != null ? tVar.getItem() : null;
            updateRegistration(1, item);
            if (item != null) {
                dateDesc = item.getDateDesc();
                content = item.getContent();
                pic = item.getPic();
                topType = item.getTopType();
            } else {
                topType = 0;
                dateDesc = null;
                content = null;
                pic = null;
            }
            boolean zIsEmpty = TextUtils.isEmpty(dateDesc);
            boolean zIsEmpty2 = TextUtils.isEmpty(content);
            boolean z = topType == 1;
            boolean z2 = topType == 3;
            boolean z3 = topType == 2;
            if (j2 != 0) {
                j |= zIsEmpty ? 16L : 8L;
            }
            if ((j & 7) != 0) {
                j |= zIsEmpty2 ? 64L : 32L;
            }
            if ((j & 7) != 0) {
                j |= z ? 1024L : 512L;
            }
            if ((j & 7) != 0) {
                j |= z2 ? PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM : PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH;
            }
            if ((j & 7) != 0) {
                j |= z3 ? 256L : 128L;
            }
            i = zIsEmpty ? 8 : 0;
            i4 = zIsEmpty2 ? 8 : 0;
            i5 = z ? 0 : 8;
            int i6 = z2 ? 0 : 8;
            int i7 = z3 ? 0 : 8;
            if ((j & 5) == 0 || tVar == null) {
                i3 = i6;
                str = dateDesc;
                str3 = pic;
                replyCommand = null;
            } else {
                replyCommand = tVar.f11506a;
                i3 = i6;
                str = dateDesc;
                str3 = pic;
            }
            i2 = i7;
            str2 = content;
        } else {
            str = null;
            str2 = null;
            i = 0;
            i2 = 0;
            i3 = 0;
            i4 = 0;
            i5 = 0;
            str3 = null;
            replyCommand = null;
        }
        if ((7 & j) != 0) {
            this.f7815e.setVisibility(i5);
            androidx.databinding.a.e.a(this.f7816f, str);
            this.f7816f.setVisibility(i);
            androidx.databinding.a.e.a(this.g, str2);
            this.g.setVisibility(i4);
            this.h.setVisibility(i2);
            String str4 = str3;
            ImageViewBindingAdapters.loadImage(this.i, 0, str4, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.j.setVisibility(i3);
            ImageViewBindingAdapters.loadImage(this.j, 0, str4, 0, 0, true, true, true, true, 12.0f, null);
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.j, replyCommand, false, 0);
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
        if (i == 0) {
            return a((com.disabngo.blockynexus.view.dialog.activity.t) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ActivityTaskAction) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.activity.t) obj);
        return true;
    }

    private Qg(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.k = -1L;
        this.f7814d = (ConstraintLayout) objArr[0];
        this.f7814d.setTag(null);
        this.f7815e = (LinearLayout) objArr[1];
        this.f7815e.setTag(null);
        this.f7816f = (TextView) objArr[2];
        this.f7816f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[4];
        this.h.setTag(null);
        this.i = (ImageView) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.activity.t tVar, int i) {
        if (i == 0) {
            synchronized (this) {
                this.k |= 1;
            }
            return true;
        }
        if (i != 244) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }

    private boolean a(ActivityTaskAction activityTaskAction, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
