package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.view.widget.ScaleRelativeLayout;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.greendao.entity.Game;
import java.util.List;

/* JADX INFO: compiled from: ItemHotRecommendItemViewBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Nh extends Mh {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7719e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7720f = new SparseIntArray();
    private final ScaleRelativeLayout g;
    private final TextView h;
    private final TextView i;
    private final TextView j;
    private final TextView k;
    private final ImageView l;
    private long m;

    static {
        f7720f.put(R.id.layout_img, 7);
        f7720f.put(R.id.ll_bottom, 8);
    }

    public Nh(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 9, f7719e, f7720f));
    }

    public void a(com.disabngo.blockynexus.e.b.X.b bVar) {
        updateRegistration(0, bVar);
        this.f7688d = bVar;
        synchronized (this) {
            this.m |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        String str;
        String str2;
        ReplyCommand replyCommand;
        String strValueOf;
        boolean z;
        String str3;
        String str4;
        int i;
        ObservableList<String> observableList;
        Game item;
        String str5;
        String str6;
        String strValueOf2;
        int praiseNumber;
        String gameTitle;
        String gameCoverPic;
        List<String> gameTypes;
        int onlineNumber;
        synchronized (this) {
            j = this.m;
            this.m = 0L;
        }
        com.disabngo.blockynexus.e.b.X.b bVar = this.f7688d;
        long j2 = j & 15;
        if (j2 != 0) {
            if (bVar != null) {
                observableList = bVar.f9580b;
                item = bVar.getItem();
            } else {
                observableList = null;
                item = null;
            }
            updateRegistration(1, observableList);
            boolean zContains = observableList != null ? observableList.contains(item != null ? item.getGameId() : null) : false;
            if (j2 != 0) {
                j |= zContains ? 32L : 16L;
            }
            int i2 = zContains ? 0 : 8;
            if ((j & 13) != 0) {
                if (item != null) {
                    gameCoverPic = item.getGameCoverPic();
                    praiseNumber = item.getPraiseNumber();
                    gameTitle = item.getGameTitle();
                    onlineNumber = item.getOnlineNumber();
                    gameTypes = item.getGameTypes();
                } else {
                    praiseNumber = 0;
                    gameTitle = null;
                    gameCoverPic = null;
                    gameTypes = null;
                    onlineNumber = 0;
                }
                strValueOf = String.valueOf(praiseNumber);
                strValueOf2 = String.valueOf(onlineNumber);
                String strA = com.disabngo.blockynexus.d.K.a(gameTypes);
                str6 = gameTitle;
                str5 = gameCoverPic;
                str3 = strA;
            } else {
                strValueOf = null;
                str5 = null;
                str3 = null;
                str6 = null;
                strValueOf2 = null;
            }
            if ((j & 9) == 0 || bVar == null) {
                i = i2;
                str4 = str5;
                str = strValueOf2;
                replyCommand = null;
                z = zContains;
                str2 = str6;
            } else {
                i = i2;
                str4 = str5;
                replyCommand = bVar.f9581c;
                z = zContains;
                str2 = str6;
                str = strValueOf2;
            }
        } else {
            str = null;
            str2 = null;
            replyCommand = null;
            strValueOf = null;
            z = false;
            str3 = null;
            str4 = null;
            i = 0;
        }
        if ((13 & j) != 0) {
            ImageViewBindingAdapters.loadImage(this.f7685a, 0, str4, R.mipmap.icon_game_default, R.mipmap.icon_game_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            androidx.databinding.a.e.a(this.h, strValueOf);
            androidx.databinding.a.e.a(this.i, str);
            androidx.databinding.a.e.a(this.j, str2);
            androidx.databinding.a.e.a(this.k, str3);
        }
        if ((9 & j) != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
        }
        if ((j & 15) != 0) {
            ImageViewBindingAdapters.isStartAnim(this.l, z);
            this.l.setVisibility(i);
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
            this.m = 8L;
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
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.X.b) obj);
        return true;
    }

    private Nh(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (ImageView) objArr[1], (RelativeLayout) objArr[7], (LinearLayout) objArr[8]);
        this.m = -1L;
        this.f7685a.setTag(null);
        this.g = (ScaleRelativeLayout) objArr[0];
        this.g.setTag(null);
        this.h = (TextView) objArr[2];
        this.h.setTag(null);
        this.i = (TextView) objArr[3];
        this.i.setTag(null);
        this.j = (TextView) objArr[4];
        this.j.setTag(null);
        this.k = (TextView) objArr[5];
        this.k.setTag(null);
        this.l = (ImageView) objArr[6];
        this.l.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.X.b bVar, int i) {
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
            this.m |= 4;
        }
        return true;
    }

    private boolean a(ObservableList<String> observableList, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.m |= 2;
        }
        return true;
    }
}
