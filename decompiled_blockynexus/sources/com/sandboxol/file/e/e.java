package com.sandboxol.file.e;

import com.sandboxol.file.entity.Progress;

/* JADX INFO: compiled from: BlockyUnzip.java */
/* JADX INFO: loaded from: classes3.dex */
class e implements f.b.c<Progress> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Progress f17597a = new Progress();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.b.b f17598b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ com.sandboxol.file.d.e f17599c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ g f17600d;

    e(g gVar, com.sandboxol.file.b.b bVar, com.sandboxol.file.d.e eVar) {
        this.f17600d = gVar;
        this.f17598b = bVar;
        this.f17599c = eVar;
    }

    @Override // f.b.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onNext(Progress progress) {
        if (this.f17598b.c() != 2) {
            this.f17599c.progress(progress);
            return;
        }
        this.f17600d.f17604b.put(progress.getName(), progress);
        long jLongValue = 0;
        long jLongValue2 = 0;
        for (Progress progress2 : this.f17600d.f17604b.values()) {
            jLongValue2 += progress2.getTotalSize().longValue();
            jLongValue += progress2.getDownloadSize().longValue();
        }
        this.f17597a.setSize(Long.valueOf(jLongValue), Long.valueOf(jLongValue2));
        this.f17599c.progress(this.f17597a);
    }

    @Override // f.b.c
    public void onComplete() {
        this.f17600d.b();
        this.f17599c.success();
    }

    @Override // f.b.c
    public void onError(Throwable th) {
        this.f17600d.b();
        this.f17599c.error(th);
    }

    @Override // f.b.c
    public void onSubscribe(f.b.d dVar) {
        this.f17600d.a(dVar);
        dVar.request(Long.MAX_VALUE);
    }
}
