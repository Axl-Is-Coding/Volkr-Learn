package com.sandboxol.game.a;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.databinding.ViewDataBinding;
import com.sandboxol.blocky.dialog.CampaignGetIntegralRewardDialog;

/* JADX INFO: renamed from: com.sandboxol.game.a.e, reason: case insensitive filesystem */
/* JADX INFO: compiled from: DialogCampaignGetIntegralRewardBinding.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2666e extends ViewDataBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ImageView f17672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinearLayout f17673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final RelativeLayout f17674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected CampaignGetIntegralRewardDialog f17675d;

    protected AbstractC2666e(Object obj, View view, int i, ImageView imageView, LinearLayout linearLayout, RelativeLayout relativeLayout) {
        super(obj, view, i);
        this.f17672a = imageView;
        this.f17673b = linearLayout;
        this.f17674c = relativeLayout;
    }

    public abstract void a(CampaignGetIntegralRewardDialog campaignGetIntegralRewardDialog);
}
