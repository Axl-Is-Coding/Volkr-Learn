package com.youth.banner;

/* JADX INFO: compiled from: Banner.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Banner f21402a;

    a(Banner banner) {
        this.f21402a = banner;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f21402a.count <= 1 || !this.f21402a.isAutoPlay) {
            return;
        }
        Banner banner = this.f21402a;
        banner.currentItem = (banner.currentItem % (this.f21402a.count + 1)) + 1;
        if (this.f21402a.currentItem == 1) {
            this.f21402a.viewPager.setCurrentItem(this.f21402a.currentItem, false);
            this.f21402a.handler.a(this.f21402a.task);
        } else {
            this.f21402a.viewPager.setCurrentItem(this.f21402a.currentItem);
            this.f21402a.handler.a(this.f21402a.task, this.f21402a.delayTime);
        }
    }
}
