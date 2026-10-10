package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Game;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.ci, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemMainItemViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0549ci extends AbstractC0537bi {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8238c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8239d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ScaleRelativeLayout f8240e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f8241f;
    private final TextView g;
    private long h;

    static {
        f8239d.put(R.id.img, 3);
    }

    public C0549ci(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f8238c, f8239d));
    }

    public void a(com.disabngo.blockynexus.e.b.X.b bVar) {
        updateRegistration(0, bVar);
        this.f8205b = bVar;
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
        String gameCoverPic;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        com.disabngo.blockynexus.e.b.X.b bVar = this.f8205b;
        long j2 = 7 & j;
        String gameTitle = null;
        if (j2 != 0) {
            replyCommand = ((j & 5) == 0 || bVar == null) ? null : bVar.f9581c;
            Game item = bVar != null ? bVar.getItem() : null;
            if (item != null) {
                gameCoverPic = item.getGameCoverPic();
                gameTitle = item.getGameTitle();
            } else {
                gameCoverPic = null;
            }
        } else {
            replyCommand = null;
            gameCoverPic = null;
        }
        if ((j & 5) != 0) {
            ViewBindingAdapters.clickCommand(this.f8240e, replyCommand, false, 0);
        }
        if (j2 != 0) {
            ImageViewBindingAdapters.loadImage(this.f8241f, 0, gameCoverPic, R.mipmap.icon_game_default, R.mipmap.icon_game_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.g, gameTitle);
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
        return a((com.disabngo.blockynexus.e.b.X.b) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.X.b) obj);
        return true;
    }

    private C0549ci(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (RelativeLayout) objArr[3]);
        this.h = -1L;
        this.f8240e = (ScaleRelativeLayout) objArr[0];
        this.f8240e.setTag(null);
        this.f8241f = (ImageView) objArr[1];
        this.f8241f.setTag(null);
        this.g = (TextView) objArr[2];
        this.g.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.X.b bVar, int i) {
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
