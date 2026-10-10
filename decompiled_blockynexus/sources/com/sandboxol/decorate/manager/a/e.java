package com.sandboxol.decorate.manager.a;

import android.content.Context;
import com.sandboxol.decorate.R;
import com.sandboxol.decorate.view.activity.dress.O;
import com.sandboxol.decorate.view.fragment.dress.ja;

/* JADX INFO: compiled from: ManStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class e implements com.sandboxol.decorate.e.a {
    @Override // com.sandboxol.decorate.e.a
    public void a(Context context, c cVar) {
        if (cVar.c().size() > 0) {
            cVar.c().clear();
        }
        if (cVar.f17160f.get().booleanValue()) {
            cVar.c().add(new ja(context, 5));
            cVar.c().add(new ja(context, 6));
            cVar.c().add(new ja(context, 7));
        } else {
            cVar.c().add(new O(context, 5));
            cVar.c().add(new O(context, 6));
            cVar.c().add(new O(context, 7));
        }
    }

    @Override // com.sandboxol.decorate.e.a
    public void b(Context context, c cVar) {
        for (int i = 0; i < cVar.a().f17126c.getRgDress().getChildCount(); i++) {
            if (cVar.a().f17126c.getRgDress().getChildAt(i).getTag().equals(context.getString(R.string.decorate_new_dress_tag_man))) {
                cVar.a().f17126c.setChildStatus(i, true);
            } else {
                cVar.a().f17126c.setChildStatus(i, false);
            }
        }
    }
}
