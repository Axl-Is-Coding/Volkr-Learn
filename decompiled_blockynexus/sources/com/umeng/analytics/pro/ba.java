package com.umeng.analytics.pro;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: classes5.dex */
public class ba {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private short[] f20697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f20698b = -1;

    public ba(int i) {
        this.f20697a = new short[i];
    }

    private void d() {
        short[] sArr = this.f20697a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f20697a = sArr2;
    }

    public short a() {
        short[] sArr = this.f20697a;
        int i = this.f20698b;
        this.f20698b = i - 1;
        return sArr[i];
    }

    public short b() {
        return this.f20697a[this.f20698b];
    }

    public void c() {
        this.f20698b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i = 0; i < this.f20697a.length; i++) {
            if (i != 0) {
                sb.append(" ");
            }
            if (i == this.f20698b) {
                sb.append(">>");
            }
            sb.append((int) this.f20697a[i]);
            if (i == this.f20698b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.f20697a.length == this.f20698b + 1) {
            d();
        }
        short[] sArr = this.f20697a;
        int i = this.f20698b + 1;
        this.f20698b = i;
        sArr[i] = s;
    }
}
