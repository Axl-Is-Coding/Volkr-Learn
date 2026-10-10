package com.sandboxol.gamedetail.view.dialog.marioguide;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.viewpager.widget.ViewPager;
import com.sandboxol.center.config.EventConstant;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.dialog.FullScreenDialog;
import com.sandboxol.common.interfaces.ReportDataAdapter;
import com.sandboxol.common.utils.AppToastUtils;
import com.sandboxol.gamedetail.R;
import com.sandboxol.gamedetail.a.AbstractC2684m;
import com.sandboxol.gamedetail.view.dialog.marioguide.BannerAdapter;
import com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView;
import java.util.List;
import rx.functions.Action0;

/* JADX INFO: loaded from: classes3.dex */
public class MarioGuideDialog extends FullScreenDialog implements BannerAdapter.OnImageClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AbstractC2684m f18150a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ImageView f18151b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ImageView f18152c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ViewPager f18153d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f18154e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerView f18155f;
    private HandlerView g;
    private List<String> h;
    private String i;
    public ReplyCommand j;
    public ReplyCommand k;
    public ReplyCommand l;
    public ReplyCommand m;

    public MarioGuideDialog(Context context, List<String> list, String str) {
        super(context);
        this.j = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.d
            @Override // rx.functions.Action0
            public final void call() {
                this.f18161a.a();
            }
        });
        this.k = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.b
            @Override // rx.functions.Action0
            public final void call() {
                this.f18159a.b();
            }
        });
        this.l = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.c
            @Override // rx.functions.Action0
            public final void call() {
                this.f18160a.c();
            }
        });
        this.m = new ReplyCommand(new Action0() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.e
            @Override // rx.functions.Action0
            public final void call() {
                this.f18162a.d();
            }
        });
        this.h = list;
        this.i = str;
        initView();
    }

    private void initView() {
        this.f18150a = (AbstractC2684m) androidx.databinding.e.a(LayoutInflater.from(this.context), R.layout.dialog_mario_guide, (ViewGroup) null, false);
        this.f18150a.a(this);
        setContentView(this.f18150a.getRoot());
        if (this.f18150a != null) {
            g();
            e();
            f();
        }
    }

    @Override // com.sandboxol.gamedetail.view.dialog.marioguide.BannerAdapter.OnImageClickListener
    public void onClick() {
        a(1);
    }

    private void e() {
        ViewPager viewPager = this.f18150a.f17851a;
        if (viewPager != null) {
            this.f18153d = viewPager;
            this.f18153d.setAdapter(new BannerAdapter(this.context, this.h, this));
            this.f18154e = this.h.size() * 10000;
            this.f18153d.setCurrentItem(this.f18154e);
            this.f18153d.addOnPageChangeListener(new f(this));
        }
    }

    private void f() {
        this.f18150a.f17856f.addViews(this.h.size());
    }

    private void g() {
        HandlerView handlerView;
        ImageView imageView;
        ImageView imageView2;
        AbstractC2684m abstractC2684m = this.f18150a;
        HandlerView handlerView2 = abstractC2684m.f17854d;
        if (handlerView2 == null || (handlerView = abstractC2684m.f17855e) == null || (imageView = abstractC2684m.g) == null || (imageView2 = abstractC2684m.h) == null) {
            return;
        }
        this.f18155f = handlerView2;
        this.g = handlerView;
        this.f18151b = imageView;
        this.f18152c = imageView2;
        this.f18155f.setListener(new HandlerView.OnClickStatusListener() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.MarioGuideDialog.1
            @Override // com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView.OnClickStatusListener
            public void a() {
                MarioGuideDialog.this.f18151b.setImageDrawable(androidx.core.content.b.c(((FullScreenDialog) MarioGuideDialog.this).context, R.mipmap.ic_handler_static));
            }

            @Override // com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView.OnClickStatusListener
            public void onClicking() {
                MarioGuideDialog.this.f18151b.setImageDrawable(androidx.core.content.b.c(((FullScreenDialog) MarioGuideDialog.this).context, R.mipmap.ic_handler_to_left));
            }
        });
        this.g.setListener(new HandlerView.OnClickStatusListener() { // from class: com.sandboxol.gamedetail.view.dialog.marioguide.MarioGuideDialog.2
            @Override // com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView.OnClickStatusListener
            public void a() {
                MarioGuideDialog.this.f18152c.setImageDrawable(androidx.core.content.b.c(((FullScreenDialog) MarioGuideDialog.this).context, R.mipmap.ic_handler_static));
            }

            @Override // com.sandboxol.gamedetail.view.dialog.marioguide.HandlerView.OnClickStatusListener
            public void onClicking() {
                MarioGuideDialog.this.f18152c.setImageDrawable(androidx.core.content.b.c(((FullScreenDialog) MarioGuideDialog.this).context, R.mipmap.ic_handler_to_right));
            }
        });
    }

    public /* synthetic */ void b() {
        a(1);
    }

    public /* synthetic */ void c() {
        a(-1);
    }

    public void d() {
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_EDITOR_CREATE, this.i);
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.sandboxol.blockmaneditor"));
            intent.setPackage("com.android.vending");
            intent.addFlags(268435456);
            if (this.context.getPackageManager().queryIntentActivities(intent, 0).size() <= 0) {
                AppToastUtils.showLongNegativeTipToast(this.context, R.string.gamedetail_ads_tips_mario_google_play);
            } else {
                this.context.startActivity(intent);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public /* synthetic */ void a() {
        ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_EDITOR_BANNER_CLOSE, this.i);
        dismiss();
    }

    public void a(int i) {
        ViewPager viewPager = this.f18153d;
        if (viewPager != null) {
            viewPager.setCurrentItem(this.f18154e + i);
            if (i < 0) {
                ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_EDITOR_BANNER_LEFT, this.i);
            } else {
                ReportDataAdapter.onEvent(this.context, EventConstant.CLICK_EDITOR_BANNER_RIGHT, this.i);
            }
        }
    }
}
