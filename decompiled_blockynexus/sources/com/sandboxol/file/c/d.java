package com.sandboxol.file.c;

/* JADX INFO: compiled from: DownloadHandler.java */
/* JADX INFO: loaded from: classes3.dex */
public class d extends com.sandboxol.file.a.b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.sandboxol.file.b.a f17563c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private a f17564d;

    public d(com.sandboxol.file.b.a aVar) {
        this.f17563c = aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (b() != null) {
            b().d();
        }
    }

    @Override // com.sandboxol.file.a.b
    public void d() {
        a(this.f17563c);
    }

    @Override // com.sandboxol.file.a.b
    public void e() {
        if (this.f17564d != null) {
            a(3);
            this.f17564d.c();
        }
        if (b() != null) {
            b().e();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public void f() {
        if (this.f17564d == null) {
            String strD = this.f17563c.d();
            byte b2 = -1;
            switch (strD.hashCode()) {
                case -111234843:
                    if (strD.equals("RxDownload3")) {
                        b2 = 0;
                    }
                    break;
                case -111234842:
                    if (strD.equals("RxDownload4")) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                this.f17564d = new f();
            } else if (b2 == 1) {
                this.f17564d = new h();
            }
        }
        if (c() != 2) {
            this.f17564d.a();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.sandboxol.file.a.b
    public void a() {
        if (this.f17564d == null) {
            String strD = this.f17563c.d();
            byte b2 = -1;
            switch (strD.hashCode()) {
                case -111234843:
                    if (strD.equals("RxDownload3")) {
                        b2 = 0;
                    }
                    break;
                case -111234842:
                    if (strD.equals("RxDownload4")) {
                        b2 = 1;
                    }
                    break;
            }
            if (b2 == 0) {
                this.f17564d = new f();
            } else if (b2 == 1) {
                this.f17564d = new h();
            }
        }
        if (c() != 2) {
            this.f17564d.a(this.f17563c);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.sandboxol.file.b.a r4) {
        /*
            r3 = this;
            java.lang.String r0 = r4.d()
            int r1 = r0.hashCode()
            r2 = 1
            switch(r1) {
                case -111234843: goto L17;
                case -111234842: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L21
        Ld:
            java.lang.String r1 = "RxDownload4"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L21
            r0 = 1
            goto L22
        L17:
            java.lang.String r1 = "RxDownload3"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L21
            r0 = 0
            goto L22
        L21:
            r0 = -1
        L22:
            if (r0 == 0) goto L39
            if (r0 == r2) goto L27
            goto L4a
        L27:
            com.sandboxol.file.c.h r0 = new com.sandboxol.file.c.h
            r0.<init>()
            r3.f17564d = r0
            com.sandboxol.file.c.a r0 = r3.f17564d
            com.sandboxol.file.c.c r1 = new com.sandboxol.file.c.c
            r1.<init>(r3, r4)
            r0.a(r4, r1)
            goto L4a
        L39:
            com.sandboxol.file.c.f r0 = new com.sandboxol.file.c.f
            r0.<init>()
            r3.f17564d = r0
            com.sandboxol.file.c.a r0 = r3.f17564d
            com.sandboxol.file.c.b r1 = new com.sandboxol.file.c.b
            r1.<init>(r3, r4)
            r0.a(r4, r1)
        L4a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.file.c.d.a(com.sandboxol.file.b.a):void");
    }
}
