package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.disabngo.blockynexus.R;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: DialogTribeSettingGuideBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class Oc extends Nc {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f7733c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f7734d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f7735e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final LinearLayout f7736f;
    private final ImageView g;
    private final RelativeLayout h;
    private final ImageView i;
    private long j;

    static {
        f7734d.put(R.id.tv_title, 5);
    }

    public Oc(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 6, f7733c, f7734d));
    }

    @Override // com.disabngo.blockynexus.databinding.Nc
    public void a(com.disabngo.blockynexus.view.dialog.Ta ta) {
        this.f7707b = ta;
        synchronized (this) {
            this.j |= 1;
        }
        notifyPropertyChanged(463);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        int i;
        int i2;
        boolean z;
        long j2;
        long j3;
        synchronized (this) {
            j = this.j;
            this.j = 0L;
        }
        com.disabngo.blockynexus.view.dialog.Ta ta = this.f7707b;
        long j4 = j & 3;
        ReplyCommand replyCommand2 = null;
        if (j4 != 0) {
            if (ta != null) {
                replyCommand2 = ta.f11383b;
                z = ta.f11382a;
                replyCommand = ta.f11384c;
            } else {
                replyCommand = null;
                z = false;
            }
            if (j4 != 0) {
                if (z) {
                    j2 = j | 8;
                    j3 = 32;
                } else {
                    j2 = j | 4;
                    j3 = 16;
                }
                j = j2 | j3;
            }
            i = 8;
            i2 = z ? 0 : 8;
            if (!z) {
                i = 0;
            }
        } else {
            replyCommand = null;
            i = 0;
            i2 = 0;
        }
        if ((3 & j) != 0) {
            this.f7736f.setVisibility(i);
            ViewBindingAdapters.clickCommand(this.g, replyCommand2, false, 0);
            this.h.setVisibility(i2);
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
        }
        if ((j & 2) != 0) {
            ImageViewBindingAdapters.isStartAnim(this.i, true);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.j != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.j = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (463 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.view.dialog.Ta) obj);
        return true;
    }

    private Oc(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (TextView) objArr[5]);
        this.j = -1L;
        this.f7735e = (RelativeLayout) objArr[0];
        this.f7735e.setTag(null);
        this.f7736f = (LinearLayout) objArr[1];
        this.f7736f.setTag(null);
        this.g = (ImageView) objArr[2];
        this.g.setTag(null);
        this.h = (RelativeLayout) objArr[3];
        this.h.setTag(null);
        this.i = (ImageView) objArr[4];
        this.i.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
