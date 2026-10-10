package com.sandboxol.gamedetail.view.dialog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.ObservableField;
import com.sandboxol.center.entity.GameDetailShop;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.utils.DateUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.AbstractC2682k;
import rx.functions.Action0;

/* JADX INFO: compiled from: GameDetailShopDialog.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends FullScreenDialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private View.OnClickListener f18141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ObservableField<String> f18142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ObservableField<String> f18143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ObservableField<String> f18144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ObservableField<String> f18145e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ObservableField<String> f18146f;
    public ObservableField<Integer> g;
    public ReplyCommand h;
    public ReplyCommand i;

    public e(Context context) {
        super(context);
        this.f18142b = new ObservableField<>();
        this.f18143c = new ObservableField<>();
        this.f18144d = new ObservableField<>();
        this.f18145e = new ObservableField<>();
        this.f18146f = new ObservableField<>();
        this.g = new ObservableField<>();
        this.h = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18135a.a();
            }
        });
        this.i = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18134a.onCancel();
            }
        });
        a(context);
    }

    private void a(Context context) {
        AbstractC2682k abstractC2682k = (AbstractC2682k) androidx.databinding.e.a(LayoutInflater.from(context), R.layout.dialog_game_detail_shop, (ViewGroup) null, false);
        abstractC2682k.a(this);
        setContentView(abstractC2682k.getRoot());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onCancel() {
        if (isShowing()) {
            cancel();
        }
    }

    public e a(GameDetailShop gameDetailShop) {
        Context context;
        int i;
        Context context2;
        int i2;
        if (gameDetailShop != null) {
            this.f18142b.set(gameDetailShop.getIconUrl());
            this.f18145e.set(gameDetailShop.getDetails());
            this.f18146f.set(String.valueOf(gameDetailShop.getPrice()));
            this.g.set(Integer.valueOf(gameDetailShop.getCurrency()));
            if (gameDetailShop.getStatus() != 1 && gameDetailShop.getStatus() != 2) {
                ObservableField<String> observableField = this.f18143c;
                StringBuilder sb = new StringBuilder();
                sb.append(gameDetailShop.getName());
                if (gameDetailShop.getValidate() > 0) {
                    context2 = this.context;
                    i2 = R.string.gamedetail_goods_time_limit;
                } else {
                    context2 = this.context;
                    i2 = R.string.gamedetail_goods_never_expire;
                }
                sb.append(context2.getString(i2));
                observableField.set(sb.toString());
                this.f18144d.set(gameDetailShop.getValidate() > 0 ? this.context.getString(R.string.gamedetail_goods_expire_date, Integer.valueOf(gameDetailShop.getValidate())) : this.context.getString(R.string.gamedetail_goods_never_expire));
            } else {
                ObservableField<String> observableField2 = this.f18143c;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(gameDetailShop.getName());
                if (gameDetailShop.getExpireDate() == null) {
                    context = this.context;
                    i = R.string.gamedetail_goods_never_expire;
                } else {
                    context = this.context;
                    i = R.string.gamedetail_goods_time_limit;
                }
                sb2.append(context.getString(i));
                observableField2.set(sb2.toString());
                this.f18144d.set(gameDetailShop.getExpireDate() == null ? this.context.getString(R.string.gamedetail_goods_never_expire) : DateUtils.timeStamp2Date(Long.parseLong(gameDetailShop.getExpireDate()), "yyyy-MM-dd"));
            }
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        View.OnClickListener onClickListener = this.f18141a;
        if (onClickListener != null) {
            onClickListener.onClick(null);
        }
        if (isShowing()) {
            cancel();
        }
    }
}
