package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ObservableField;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.entity.ScrapRequestTargetInfo;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: ItemScrapRequestBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Ui extends Ti {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f7945e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f7946f = new SparseIntArray();
    private final ConstraintLayout g;
    private final ImageView h;
    private final View i;
    private final ImageView j;
    private long k;

    static {
        f7946f.put(R.id.iv_pic, 6);
    }

    public Ui(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 7, f7945e, f7946f));
    }

    public void a(com.disabngo.blockynexus.view.dialog.g.g gVar) {
        updateRegistration(0, gVar);
        this.f7916d = gVar;
        synchronized (this) {
            this.k |= 1;
        }
        notifyPropertyChanged(2);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        int i;
        String str;
        int i2;
        String friendPic;
        ObservableField<Long> observableField;
        ScrapRequestTargetInfo item;
        int i3;
        String str2;
        synchronized (this) {
            j = this.k;
            this.k = 0L;
        }
        com.disabngo.blockynexus.view.dialog.g.g gVar = this.f7916d;
        long j2 = j & 15;
        if (j2 != 0) {
            if (gVar != null) {
                observableField = gVar.f11577b;
                item = gVar.getItem();
            } else {
                observableField = null;
                item = null;
            }
            updateRegistration(1, observableField);
            boolean z = ViewDataBinding.safeUnbox(observableField != null ? observableField.get() : null) == (item != null ? item.getFriendId() : 0L);
            if (j2 != 0) {
                j |= z ? 128L : 64L;
            }
            i = z ? 0 : 8;
            long j3 = j & 13;
            if (j3 != 0) {
                if (item != null) {
                    String friendName = item.getFriendName();
                    friendPic = item.getFriendPic();
                    int helpStatus = item.getHelpStatus();
                    str2 = friendName;
                    i3 = helpStatus;
                } else {
                    i3 = 0;
                    str2 = null;
                    friendPic = null;
                }
                boolean z2 = i3 == 1;
                if (j3 != 0) {
                    j |= z2 ? 32L : 16L;
                }
                i2 = z2 ? 0 : 8;
                str = str2;
            } else {
                str = null;
                i2 = 0;
                friendPic = null;
            }
            replyCommand = ((j & 9) == 0 || gVar == null) ? null : gVar.f11578c;
        } else {
            replyCommand = null;
            i = 0;
            str = null;
            i2 = 0;
            friendPic = null;
        }
        if ((15 & j) != 0) {
            this.f7913a.setVisibility(i);
        }
        if ((j & 13) != 0) {
            ImageViewBindingAdapters.loadImage(this.h, 0, friendPic, R.mipmap.ic_head_default, R.mipmap.ic_head_default, false, false, false, false, WheelView.DividerConfig.FILL, null);
            this.i.setVisibility(i2);
            this.j.setVisibility(i2);
            androidx.databinding.a.e.a(this.f7915c, str);
        }
        if ((j & 9) != 0) {
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
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
            return a((com.disabngo.blockynexus.view.dialog.g.g) obj, i2);
        }
        if (i != 1) {
            return false;
        }
        return a((ObservableField<Long>) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (2 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.g.g) obj);
        return true;
    }

    private Ui(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 2, (View) objArr[4], (CardView) objArr[6], (TextView) objArr[5]);
        this.k = -1L;
        this.f7913a.setTag(null);
        this.g = (ConstraintLayout) objArr[0];
        this.g.setTag(null);
        this.h = (ImageView) objArr[1];
        this.h.setTag(null);
        this.i = (View) objArr[2];
        this.i.setTag(null);
        this.j = (ImageView) objArr[3];
        this.j.setTag(null);
        this.f7915c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.view.dialog.g.g gVar, int i) {
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

    private boolean a(ObservableField<Long> observableField, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.k |= 2;
        }
        return true;
    }
}
