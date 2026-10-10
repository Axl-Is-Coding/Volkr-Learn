package com.disabngo.blockynexus.databinding;

import android.graphics.drawable.Drawable;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.GameRankingInfo;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemWindowDiscoverTypeRankingBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Fj extends Ej {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f7467b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f7468c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LinearLayout f7469d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f7470e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f7471f;
    private long g;

    public Fj(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 3, f7467b, f7468c));
    }

    public void a(com.disabngo.blockynexus.view.widget.gameRank.a.b bVar) {
        updateRegistration(0, bVar);
        this.f7437a = bVar;
        synchronized (this) {
            this.g |= 1;
        }
        notifyPropertyChanged(300);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        String iconUrl;
        String str;
        int i;
        String typeName;
        int iconResId;
        synchronized (this) {
            j = this.g;
            this.g = 0L;
        }
        com.disabngo.blockynexus.view.widget.gameRank.a.b bVar = this.f7437a;
        long j2 = 7 & j;
        Drawable drawableF = null;
        if (j2 != 0) {
            GameRankingInfo item = bVar != null ? bVar.getItem() : null;
            if (item != null) {
                typeName = item.getTypeName();
                iconUrl = item.getIconUrl();
                iconResId = item.getIconResId();
            } else {
                typeName = null;
                iconUrl = null;
                iconResId = 0;
            }
            if ((j & 5) == 0 || bVar == null) {
                replyCommand = null;
                str = typeName;
                i = iconResId;
            } else {
                ReplyCommand replyCommand2 = bVar.f12086a;
                str = typeName;
                i = iconResId;
                drawableF = bVar.f();
                replyCommand = replyCommand2;
            }
        } else {
            replyCommand = null;
            iconUrl = null;
            str = null;
            i = 0;
        }
        if ((j & 5) != 0) {
            androidx.databinding.a.f.a(this.f7469d, drawableF);
            ViewBindingAdapters.clickCommand(this.f7469d, replyCommand, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f7470e, i, iconUrl, R.mipmap.icon_zonghe_ranking, R.mipmap.icon_zonghe_ranking, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f7471f, str);
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
        return a((com.disabngo.blockynexus.view.widget.gameRank.a.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (300 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.widget.gameRank.a.b) obj);
        return true;
    }

    private Fj(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1);
        this.g = -1L;
        this.f7469d = (LinearLayout) objArr[0];
        this.f7469d.setTag(null);
        this.f7470e = (ImageView) objArr[1];
        this.f7470e.setTag(null);
        this.f7471f = (TextView) objArr[2];
        this.f7471f.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.widget.gameRank.a.b bVar, int i) {
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
