package com.disabngo.blockynexus.e.b.C;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.disabngo.blockynexus.R;
import com.disabngo.blockynexus.d.A;
import com.disabngo.blockynexus.databinding.AbstractC0666ne;
import com.disabngo.blockynexus.entity.GroupInfoParam;
import com.sandboxol.center.config.SharedConstant;
import com.sandboxol.common.base.app.TemplateFragment;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.iwf.photopicker.a.b;
import me.iwf.photopicker.d;
import me.iwf.photopicker.f;

/* JADX INFO: compiled from: GroupEditFragment.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends TemplateFragment<l, AbstractC0666ne> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<String> f9133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f9134b = new ArrayList<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ArrayList<File> f9135c = new ArrayList<>();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private me.iwf.photopicker.b f9136d;

    private void h() {
        this.f9136d = new me.iwf.photopicker.b(this.context, this.f9134b, 3);
        ((AbstractC0666ne) this.binding).f8621d.setLayoutManager(me.tatarka.bindingcollectionadapter2.k.a(4).a(((AbstractC0666ne) this.binding).f8621d));
        ((AbstractC0666ne) this.binding).f8621d.setAdapter(this.f9136d);
        ((AbstractC0666ne) this.binding).f8621d.addOnItemTouchListener(new me.iwf.photopicker.a.b(this.context, new b.a() { // from class: com.disabngo.blockynexus.e.b.C.a
            @Override // me.iwf.photopicker.a.b.a
            public final void a(View view, int i) {
                this.f9124a.a(view, i);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void bindViewModel(AbstractC0666ne abstractC0666ne, l lVar) {
        abstractC0666ne.a(lVar);
        h();
    }

    public ArrayList<File> g() {
        return this.f9135c;
    }

    @Override // com.sandboxol.common.base.app.BaseFragment
    protected int getLayoutId() {
        return R.layout.fragment_group_name;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if (i == 233 || i == 666) {
                this.f9133a = null;
                this.f9134b.clear();
                this.f9135c.clear();
                if (intent != null) {
                    this.f9133a = intent.getStringArrayListExtra("SELECTED_PHOTOS");
                }
                List<String> list = this.f9133a;
                if (list != null) {
                    this.f9134b.addAll(list);
                    A.a(this.context, this.f9133a, this.f9135c);
                }
                this.f9136d.notifyDataSetChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.sandboxol.common.base.app.BaseFragment
    public l getViewModel() {
        GroupInfoParam groupInfoParam;
        int i;
        if (getArguments() != null) {
            groupInfoParam = (GroupInfoParam) getArguments().getSerializable(SharedConstant.KEY_GROUP_INFO);
            i = getArguments().getInt(SharedConstant.KEY_GROUP_EDIT_TYPE);
            if (groupInfoParam.getNoticePic() != null && groupInfoParam.getNoticePic().size() > 0) {
                this.f9134b.addAll(groupInfoParam.getNoticePic());
                Iterator<String> it = groupInfoParam.getNoticePic().iterator();
                while (it.hasNext()) {
                    this.f9135c.add(new File(it.next()));
                }
            }
        } else {
            groupInfoParam = null;
            i = 0;
        }
        if (groupInfoParam == null) {
            groupInfoParam = new GroupInfoParam();
        }
        return new l(this.context, groupInfoParam, i, this);
    }

    public /* synthetic */ void a(View view, int i) {
        try {
            if (this.f9136d.getItemViewType(i) == 1) {
                d.a aVarA = me.iwf.photopicker.d.a();
                aVarA.a(3);
                aVarA.a(false);
                aVarA.a(this.f9134b);
                aVarA.a((Activity) this.context);
            } else if (view.getId() == R.id.iv_cancel) {
                this.f9134b.remove(i);
                this.f9135c.remove(i);
                this.f9136d.notifyDataSetChanged();
            } else {
                f.a aVarA2 = me.iwf.photopicker.f.a();
                aVarA2.a(this.f9134b);
                aVarA2.a(i);
                aVarA2.a((Activity) this.context);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
