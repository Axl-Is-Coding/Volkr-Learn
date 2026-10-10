package com.sandboxol.game.a;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.CampaignGetIntegralRewardDialog;
import com.sandboxol.common.binding.adapter.ViewBindingAdapters;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.game.R;

/* JADX INFO: renamed from: com.sandboxol.game.a.f, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogCampaignGetIntegralRewardBindingImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2667f extends AbstractC2666e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final ViewDataBinding.b f17676e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final SparseIntArray f17677f = new SparseIntArray();
    private final Button g;
    private long h;

    static {
        f17677f.put(R.id.ivFlash, 2);
        f17677f.put(R.id.ll_reward, 3);
    }

    public C2667f(androidx.databinding.d dVar, View view) {
        this(dVar, view, ViewDataBinding.mapBindings(dVar, view, 4, f17676e, f17677f));
    }

    @Override // com.sandboxol.game.a.AbstractC2666e
    public void a(CampaignGetIntegralRewardDialog campaignGetIntegralRewardDialog) {
        this.f17675d = campaignGetIntegralRewardDialog;
        synchronized (this) {
            this.h |= 1;
        }
        notifyPropertyChanged(com.sandboxol.game.a.j);
        super.requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        long j;
        synchronized (this) {
            j = this.h;
            this.h = 0L;
        }
        ReplyCommand replyCommand = null;
        CampaignGetIntegralRewardDialog campaignGetIntegralRewardDialog = this.f17675d;
        long j2 = j & 3;
        if (j2 != 0 && campaignGetIntegralRewardDialog != null) {
            replyCommand = campaignGetIntegralRewardDialog.onConfirmClickCommand;
        }
        if (j2 != 0) {
            ViewBindingAdapters.clickCommand(this.g, replyCommand, false, 0);
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
            this.h = 2L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int i, Object obj, int i2) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int i, Object obj) {
        if (com.sandboxol.game.a.j != i) {
            return false;
        }
        a((CampaignGetIntegralRewardDialog) obj);
        return true;
    }

    private C2667f(androidx.databinding.d dVar, View view, Object[] objArr) {
        super(dVar, view, 0, (ImageView) objArr[2], (LinearLayout) objArr[3], (RelativeLayout) objArr[0]);
        this.h = -1L;
        this.g = (Button) objArr[1];
        this.g.setTag(null);
        this.f17674c.setTag(null);
        setRootTag(view);
        invalidateAll();
    }
}
