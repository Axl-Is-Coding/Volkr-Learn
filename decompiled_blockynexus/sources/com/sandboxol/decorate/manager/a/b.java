package com.sandboxol.decorate.manager.a;

import android.content.Context;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.activity.dress.O;
import com.sandboxol.decorate.view.activity.dress.V;
import com.sandboxol.decorate.view.activity.dress.Z;
import com.sandboxol.decorate.view.fragment.dress.ja;
import com.sandboxol.decorate.view.fragment.dress.pa;

/* JADX INFO: compiled from: DressStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class b implements com.sandboxol.decorate.e.a {
    @Override // com.sandboxol.decorate.e.a
    public void a(Context context, c cVar) {
        if (cVar.c().size() > 0) {
            cVar.c().clear();
        }
        if (cVar.f17160f.get().booleanValue()) {
            cVar.c().add(new ja(context, 0));
            cVar.c().add(new pa(context, 31));
            cVar.c().add(new ja(context, 16));
            cVar.c().add(new ja(context, 8));
            cVar.c().add(new ja(context, 9));
            cVar.c().add(new ja(context, 10));
            cVar.c().add(new ja(context, 2));
            cVar.c().add(new ja(context, 4));
            return;
        }
        cVar.c().add(new V(context, 30));
        cVar.c().add(new Z(context, 31, cVar.b()));
        cVar.c().add(new O(context, 16));
        cVar.c().add(new O(context, 8));
        cVar.c().add(new O(context, 9));
        cVar.c().add(new O(context, 10));
        cVar.c().add(new O(context, 2));
        cVar.c().add(new O(context, 4));
    }

    @Override // com.sandboxol.decorate.e.a
    public void b(Context context, c cVar) {
        for (int i = 0; i < cVar.a().f17126c.getRgDress().getChildCount(); i++) {
            if (cVar.a().f17126c.getRgDress().getChildAt(i).getTag().equals(context.getString(R.string.decorate_new_dress_tag_dress))) {
                cVar.a().f17126c.setChildStatus(i, true);
            } else if (cVar.f17160f.get().booleanValue() && cVar.a().f17126c.getRgDress().getChildAt(i).getTag().equals(context.getString(R.string.decorate_new_dress_tag_all))) {
                cVar.a().f17126c.setChildStatus(i, true);
            } else if (cVar.f17160f.get().booleanValue() || !cVar.a().f17126c.getRgDress().getChildAt(i).getTag().equals(context.getString(R.string.decorate_new_dress_tag_recommend))) {
                cVar.a().f17126c.setChildStatus(i, false);
            } else {
                cVar.a().f17126c.setChildStatus(i, true);
            }
        }
    }
}
