package com.tbruyelle.rxpermissions2;

/* JADX INFO: compiled from: Permission.java */
/* JADX INFO: loaded from: classes5.dex */
class a implements io.reactivex.b.b<StringBuilder, String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ e f19379a;

    a(e eVar) {
        this.f19379a = eVar;
    }

    @Override // io.reactivex.b.b
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void accept(StringBuilder sb, String str) throws Exception {
        if (sb.length() == 0) {
            sb.append(str);
        } else {
            sb.append(", ");
            sb.append(str);
        }
    }
}
