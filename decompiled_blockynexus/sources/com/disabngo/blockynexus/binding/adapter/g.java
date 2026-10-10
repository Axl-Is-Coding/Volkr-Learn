package com.disabngo.blockynexus.binding.adapter;

import androidx.viewpager.widget.ViewPager;
import com.sandboxol.common.command.ReplyCommand;

/* JADX INFO: compiled from: BannerBindAdapters.java */
/* JADX INFO: loaded from: classes.dex */
class g implements ViewPager.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ReplyCommand f7177a;

    g(ReplyCommand replyCommand) {
        this.f7177a = replyCommand;
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrollStateChanged(int i) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageScrolled(int i, float f2, int i2) {
    }

    @Override // androidx.viewpager.widget.ViewPager.e
    public void onPageSelected(int i) {
        ReplyCommand replyCommand = this.f7177a;
        if (replyCommand != null) {
            replyCommand.execute(Integer.valueOf(i));
        }
    }
}
