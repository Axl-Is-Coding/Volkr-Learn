package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.rh, reason: case insensitive filesystem */
/* JADX INFO: compiled from: ItemGameLatelyViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0712rh extends AbstractC0702qh {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ViewDataBinding.b f8765b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final SparseIntArray f8766c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final RelativeLayout f8767d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ImageView f8768e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final TextView f8769f;
    private final TextView g;
    private final TextView h;
    private final TextView i;
    private final ImageView j;
    private long k;

    public C0712rh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f8765b, f8766c));
    }

    public void a(com.disabngo.blockynexus.e.b.X.b bVar) {
        updateRegistration(0, bVar);
        this.f8735a = bVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(347);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String gameTitle;
        String str2;
        String str3;
        boolean z;
        int i;
        ReplyCommand replyCommand;
        String str4;
        ObservableList<String> observableList;
        Game item;
        String gameCoverPic;
        String strValueOf;
        String strValueOf2;
        String strA;
        int onlineNumber;
        int praiseNumber;
        List<String> gameTypes;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.e.b.X.b bVar = this.f8735a;
        long j2 = j & 15;
        if (j2 != 0) {
            replyCommand = ((j & 9) == 0 || bVar == null) ? null : bVar.f9581c;
            if (bVar != null) {
                item = bVar.getItem();
                observableList = bVar.f9580b;
            } else {
                observableList = null;
                item = null;
            }
            updateRegistration(1, observableList);
            if ((j & 13) != 0) {
                if (item != null) {
                    gameTitle = item.getGameTitle();
                    gameCoverPic = item.getGameCoverPic();
                    onlineNumber = item.getOnlineNumber();
                    praiseNumber = item.getPraiseNumber();
                    gameTypes = item.getGameTypes();
                } else {
                    gameTitle = null;
                    gameCoverPic = null;
                    onlineNumber = 0;
                    praiseNumber = 0;
                    gameTypes = null;
                }
                strValueOf = String.valueOf(onlineNumber);
                strValueOf2 = String.valueOf(praiseNumber);
                strA = com.disabngo.blockynexus.d.K.a(gameTypes);
            } else {
                gameTitle = null;
                gameCoverPic = null;
                strValueOf = null;
                strValueOf2 = null;
                strA = null;
            }
            boolean zContains = observableList != null ? observableList.contains(item != null ? item.getGameId() : null) : false;
            if (j2 != 0) {
                j |= zContains ? 32L : 16L;
            }
            z = zContains;
            str4 = gameCoverPic;
            i = zContains ? 0 : 8;
            str = strValueOf;
            str2 = strValueOf2;
            str3 = strA;
        } else {
            str = null;
            gameTitle = null;
            str2 = null;
            str3 = null;
            z = false;
            i = 0;
            replyCommand = null;
            str4 = null;
        }
        if ((9 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.f8767d, replyCommand, false, 0);
        }
        if ((13 & j) != 0) {
            ImageViewBindingAdapters.loadImage(this.f8768e, 0, str4, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.f8769f, str);
            androidx.databinding.a.e.a(this.g, gameTitle);
            androidx.databinding.a.e.a(this.h, str2);
            androidx.databinding.a.e.a(this.i, str3);
        }
        if ((j & 15) != 0) {
            ImageViewBindingAdapters.isStartAnim(this.j, z);
            this.j.setVisibility(i);
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
            this.k = 8L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i == 0) {
            return a((com.disabngo.blockynexus.e.b.X.b) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableList<String>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (347 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.X.b) obj);
        return true;
    }

    private C0712rh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2);
        this.k = -1L;
        this.f8767d = (RelativeLayout) objArr[0];
        this.f8767d.setTag(null);
        this.f8768e = (ImageView) objArr[1];
        this.f8768e.setTag(null);
        this.f8769f = (TextView) objArr[2];
        this.f8769f.setTag(null);
        this.g = (TextView) objArr[3];
        this.g.setTag(null);
        this.h = (TextView) objArr[4];
        this.h.setTag(null);
        this.i = (TextView) objArr[5];
        this.i.setTag(null);
        this.j = (ImageView) objArr[6];
        this.j.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.X.b bVar, int i) {
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
            this.k |= 4;
        }
        return true;
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
