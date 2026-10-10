package com.disabngo.blockynexus.e.b.da;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableList;
import cn.qqtheme.framework.widget.WheelView;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.databinding.AbstractC0591gf;
import com.google.android.material.tabs.TabLayout;
import com.sandboxol.center.view.dialog.scrap.ScrapBagDialog;
import com.sandboxol.center.web.ScrapApi;
import com.sandboxol.common.base.viewmodel.ViewModel;
import com.sandboxol.common.command.ReplyCommand;
import com.sandboxol.common.utils.SizeUtil;
import java.util.HashMap;
import java.util.Map;
import rx.functions.Action0;

/* JADX INFO: compiled from: ScrapMainViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
public class o extends ViewModel {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f9715a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f9716b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AbstractC0591gf f9717c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AnimatorSet f9718d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private AnimatorSet f9719e;
    private int[] h;
    private Map<Integer, Boolean> i;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int[] f9720f = {R.mipmap.ic_scrap_bag_tab_all_2, R.mipmap.ic_scrap_bag_tab_game_props_2, R.mipmap.ic_scrap_bag_tab_game_2, R.mipmap.ic_scrap_bag_tab_app_2, R.mipmap.ic_scrap_bag_tab_limit_2};
    private int[] g = {R.mipmap.ic_scrap_bag_tab_all_1, R.mipmap.ic_scrap_bag_tab_game_props_1, R.mipmap.ic_scrap_bag_tab_game_1, R.mipmap.ic_scrap_bag_tab_app_1, R.mipmap.ic_scrap_bag_tab_limit_1};
    public ObservableField<Boolean> j = new ObservableField<>(false);
    public ObservableField<Integer> k = new ObservableField<>(0);
    public me.tatarka.bindingcollectionadapter2.g<p> l = me.tatarka.bindingcollectionadapter2.g.a(new me.tatarka.bindingcollectionadapter2.l() { // from class: com.disabngo.blockynexus.e.b.da.e
        @Override // me.tatarka.bindingcollectionadapter2.l
        public final void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, Object obj) {
            this.f9698a.a(gVar, i, (p) obj);
        }
    });
    public ObservableList<p> m = new ObservableArrayList();
    public ReplyCommand n = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.da.b
        @Override // rx.functions.Action0
        public final void call() {
            this.f9695a.h();
        }
    });
    public ReplyCommand o = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.da.g
        @Override // rx.functions.Action0
        public final void call() {
            this.f9700a.f();
        }
    });
    public ReplyCommand p = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.da.c
        @Override // rx.functions.Action0
        public final void call() {
            this.f9696a.i();
        }
    });
    public ReplyCommand q = new ReplyCommand(new Action0() { // from class: com.disabngo.blockynexus.e.b.da.d
        @Override // rx.functions.Action0
        public final void call() {
            this.f9697a.j();
        }
    });

    public o(Context context, AbstractC0591gf abstractC0591gf) {
        this.f9715a = context;
        this.f9717c = abstractC0591gf;
        k();
        this.h = context.getResources().getIntArray(R.array.scrap_bag_tab_array_type);
        l();
        this.f9717c.h.post(new Runnable() { // from class: com.disabngo.blockynexus.e.b.da.f
            @Override // java.lang.Runnable
            public final void run() {
                this.f9699a.p();
            }
        });
        m();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        new ScrapBagDialog(this.f9715a, true, 0L, true).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f9716b) {
            this.f9716b = false;
            this.f9719e.start();
        } else {
            this.f9716b = true;
            this.f9718d.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        new com.disabngo.blockynexus.view.dialog.f.b(this.f9715a).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        new com.disabngo.blockynexus.view.dialog.h.b(this.f9715a).show();
    }

    private void k() {
        this.f9718d = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f9717c.f8370a, "translationX", WheelView.DividerConfig.FILL, -SizeUtil.dp2px(this.f9715a, 100.0f));
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f9717c.f8374e, "translationX", WheelView.DividerConfig.FILL, -SizeUtil.dp2px(this.f9715a, 100.0f));
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f9717c.f8375f, "translationX", WheelView.DividerConfig.FILL, -SizeUtil.dp2px(this.f9715a, 50.0f));
        this.f9718d.setDuration(300L);
        this.f9718d.playTogether(objectAnimatorOfFloat, objectAnimatorOfFloat2, objectAnimatorOfFloat3);
        this.f9719e = new AnimatorSet();
        ObjectAnimator objectAnimatorOfFloat4 = ObjectAnimator.ofFloat(this.f9717c.f8370a, "translationX", -SizeUtil.dp2px(this.f9715a, 100.0f), WheelView.DividerConfig.FILL);
        ObjectAnimator objectAnimatorOfFloat5 = ObjectAnimator.ofFloat(this.f9717c.f8374e, "translationX", -SizeUtil.dp2px(this.f9715a, 100.0f), WheelView.DividerConfig.FILL);
        ObjectAnimator objectAnimatorOfFloat6 = ObjectAnimator.ofFloat(this.f9717c.f8375f, "translationX", -SizeUtil.dp2px(this.f9715a, 50.0f), WheelView.DividerConfig.FILL);
        this.f9719e.setDuration(300L);
        this.f9719e.playTogether(objectAnimatorOfFloat4, objectAnimatorOfFloat5, objectAnimatorOfFloat6);
    }

    private void l() {
        this.i = new HashMap();
        for (int i = 0; i < 5; i++) {
            if (i == 0) {
                this.i.put(Integer.valueOf(i), true);
            } else {
                this.i.put(Integer.valueOf(i), false);
            }
            this.m.add(new p(this.f9715a, this.j, Integer.valueOf(this.h[i]), this.i, i));
        }
    }

    private void m() {
        ScrapApi.getRewardValue(this.f9715a, new n(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        if (this.h.length >= this.f9717c.h.getTabCount()) {
            for (int i = 0; i < this.f9717c.h.getTabCount(); i++) {
                TabLayout.f tabAt = this.f9717c.h.getTabAt(i);
                if (tabAt != null) {
                    tabAt.d(0);
                    tabAt.b(this.g[i]);
                    if (i == 0) {
                        tabAt.b(this.f9720f[i]);
                    }
                }
            }
        }
        this.f9717c.h.addOnTabSelectedListener((TabLayout.c) new m(this));
    }

    @Override // com.sandboxol.common.base.viewmodel.ViewModel
    public void onDestroy() {
        AnimatorSet animatorSet = this.f9718d;
        if (animatorSet != null) {
            animatorSet.cancel();
            this.f9718d = null;
        }
        AnimatorSet animatorSet2 = this.f9719e;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
            this.f9719e = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(me.tatarka.bindingcollectionadapter2.g gVar, int i, p pVar) {
        gVar.a(460, R.layout.app_scrap_page_content);
    }
}
