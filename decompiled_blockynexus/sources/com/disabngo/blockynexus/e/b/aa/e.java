package com.disabngo.blockynexus.e.b.aa;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.AbstractC0522af;
import com.sandboxol.center.config.StringConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import me.iwf.photopicker.a.b;
import me.iwf.photopicker.d;
import me.iwf.photopicker.f;
import me.tatarka.bindingcollectionadapter2.k;

/* JADX INFO: compiled from: ReportDetailFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class e extends TemplateFragment<i, AbstractC0522af> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<String> f9630c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private me.iwf.photopicker.b f9633f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f9628a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f9629b = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ArrayList<String> f9631d = new ArrayList<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ArrayList<File> f9632e = new ArrayList<>();

    private void j() {
        this.f9633f = new me.iwf.photopicker.b(this.context, this.f9631d, 4);
        ((AbstractC0522af) this.binding).f8168b.setLayoutManager(k.a(4).a(((AbstractC0522af) this.binding).f8168b));
        ((AbstractC0522af) this.binding).f8168b.setAdapter(this.f9633f);
        ((AbstractC0522af) this.binding).f8168b.addOnItemTouchListener(new me.iwf.photopicker.a.b(this.context, new b.a() { // from class: com.disabngo.blockynexus.e.b.aa.a
            @Override // me.iwf.photopicker.a.b.a
            public final void a(View view, int i) {
                this.f9619a.a(view, i);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0522af abstractC0522af, i iVar) {
        abstractC0522af.a(iVar);
        j();
    }

    public long g() {
        return this.f9629b;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_report_detail;
    }

    public String h() {
        return this.f9628a;
    }

    public ArrayList<File> i() {
        return this.f9632e;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 233 || i == 666) {
                this.f9630c = null;
                this.f9631d.clear();
                this.f9632e.clear();
                if (intent != null) {
                    this.f9630c = intent.getStringArrayListExtra("SELECTED_PHOTOS");
                }
                List<String> list = this.f9630c;
                if (list != null) {
                    this.f9631d.addAll(list);
                    A.a(this.context, this.f9630c, this.f9632e);
                }
                this.f9633f.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public i getViewModel() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f9628a = arguments.getString(StringConstant.REPORT_REASON);
            this.f9629b = arguments.getLong(StringConstant.REPORT_USER_ID);
        }
        return new i(this.context, this);
    }

    public /* synthetic */ void a(View view, int i) {
        try {
            if (this.f9633f.getItemViewType(i) == 1) {
                d.a aVarA = me.iwf.photopicker.d.a();
                aVarA.a(4);
                aVarA.a(false);
                aVarA.a(this.f9631d);
                aVarA.a((Activity) this.context);
            } else if (view.getId() == R.id.iv_cancel) {
                this.f9631d.remove(i);
                this.f9632e.remove(i);
                this.f9633f.notifyDataSetChanged();
            } else {
                f.a aVarA2 = me.iwf.photopicker.f.a();
                aVarA2.a(this.f9631d);
                aVarA2.a(i);
                aVarA2.a((Activity) this.context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
