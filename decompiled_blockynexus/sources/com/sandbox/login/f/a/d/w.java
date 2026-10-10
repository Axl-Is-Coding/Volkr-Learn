package com.sandbox.login.f.a.d;

import com.google.android.material.tabs.TabLayout;
import com.sandbox.login.R;
import com.sandboxol.center.router.manager.DressManager;

/* JADX INFO: compiled from: MakeRoleViewModel.java */
/* JADX INFO: loaded from: classes2.dex */
class w implements TabLayout.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ E f15841a;

    w(E e2) {
        this.f15841a = e2;
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabReselected(TabLayout.f fVar) {
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabSelected(TabLayout.f fVar) {
        if (fVar.c() == 0) {
            if (this.f15841a.g.getSex() != 1) {
                DressManager.changeSex(1);
                this.f15841a.g.setSex(1);
                this.f15841a.l.set(Integer.valueOf(R.mipmap.login_male_pic_0));
                this.f15841a.m.set(Integer.valueOf(R.mipmap.login_male_pic_1));
                this.f15841a.n.set(Integer.valueOf(R.mipmap.login_male_pic_2));
                this.f15841a.o.set(Integer.valueOf(R.mipmap.login_male_pic_3));
                this.f15841a.f15805c.s.setImageDrawable(this.f15841a.f());
                return;
            }
            return;
        }
        if (fVar.c() != 1 || this.f15841a.g.getSex() == 2) {
            return;
        }
        DressManager.changeSex(2);
        this.f15841a.g.setSex(2);
        this.f15841a.l.set(Integer.valueOf(R.mipmap.login_female_pic_0));
        this.f15841a.m.set(Integer.valueOf(R.mipmap.login_female_pic_1));
        this.f15841a.n.set(Integer.valueOf(R.mipmap.login_female_pic_2));
        this.f15841a.o.set(Integer.valueOf(R.mipmap.login_female_pic_3));
        this.f15841a.f15805c.s.setImageDrawable(this.f15841a.f());
    }

    @Override // com.google.android.material.tabs.TabLayout.b
    public void onTabUnselected(TabLayout.f fVar) {
    }
}
