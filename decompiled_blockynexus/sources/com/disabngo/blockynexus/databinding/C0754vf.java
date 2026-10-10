package com.disabngo.blockynexus.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.sandboxol.center.config.UrlConstant;
import com.sandboxol.common.binding.adapter.DataRecyclerViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ImageViewBindingAdapters;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.widget.rv.datarv.DataRecyclerView;

/* JADX INFO: renamed from: com.disabngo.blockynexus.databinding.vf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: FragmentShareBindingImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0754vf extends AbstractC0743uf {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final ViewDataBinding.b f8908c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f8909d = new SparseIntArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final RelativeLayout f8910e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final ImageView f8911f;
    private final DataRecyclerView g;
    private final Button h;
    private long i;

    static {
        f8909d.put(R.id.llReward, 4);
    }

    public C0754vf(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 5, f8908c, f8909d));
    }

    @Override // com.disabngo.blockynexus.databinding.AbstractC0743uf
    public void a(com.disabngo.blockynexus.e.b.ja.h hVar) {
        updateRegistration(0, hVar);
        this.f8869b = hVar;
        synchronized (this) {
            this.i |= 1;
        }
        notifyPropertyChanged(449);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        ReplyCommand replyCommand;
        com.disabngo.blockynexus.e.b.X.a aVar;
        com.disabngo.blockynexus.e.b.ja.e eVar;
        synchronized (this) {
            j = this.i;
            this.i = 0L;
        }
        com.disabngo.blockynexus.e.b.ja.h hVar = this.f8869b;
        long j2 = 3 & j;
        if (j2 == 0 || hVar == null) {
            replyCommand = null;
            aVar = null;
            eVar = null;
        } else {
            com.disabngo.blockynexus.e.b.ja.e eVar2 = hVar.f9864d;
            com.disabngo.blockynexus.e.b.X.a aVar2 = hVar.f9863c;
            replyCommand = hVar.f9862b;
            eVar = eVar2;
            aVar = aVar2;
        }
        if ((j & 2) != 0) {
            ImageViewBindingAdapters.loadImage(this.f8911f, 0, UrlConstant.SHARE_PAGE_TITLE_BG, 0, 0, false, false, false, false, WheelView.DividerConfig.FILL, null);
        }
        if (j2 != 0) {
            DataRecyclerViewBindingAdapters.setDataRecyclerView(this.g, aVar, eVar, me.tatarka.bindingcollectionadapter2.k.a(4), false, null, false, 0, false);
            ViewBindingAdapters.clickCommand(this.h, replyCommand, false, 0);
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.i != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.i = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        if (i != 0) {
            return false;
        }
        return a((com.disabngo.blockynexus.e.b.ja.h) obj, i2);
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (449 != i) {
            return false;
        }
        a((com.disabngo.blockynexus.e.b.ja.h) obj);
        return true;
    }

    private C0754vf(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 1, (LinearLayout) objArr[4]);
        this.i = -1L;
        this.f8910e = (RelativeLayout) objArr[0];
        this.f8910e.setTag(null);
        this.f8911f = (ImageView) objArr[1];
        this.f8911f.setTag(null);
        this.g = (DataRecyclerView) objArr[2];
        this.g.setTag(null);
        this.h = (Button) objArr[3];
        this.h.setTag(null);
        setRootTag(view);
        invalidateAll();
    }

    private boolean a(com.disabngo.blockynexus.e.b.ja.h hVar, int i) {
        if (i != 0) {
            return false;
        }
        synchronized (this) {
            this.i |= 1;
        }
        return true;
    }
}
