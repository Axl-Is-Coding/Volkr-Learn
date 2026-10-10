package com.tendcloud.tenddata;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public class bw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public com.tendcloud.tenddata.a f19903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f19904b = a.IMMEDIATELY;

    /* JADX INFO: compiled from: td */
    public enum a {
        IMMEDIATELY(0),
        HIGH(1);

        private final int indexNum;

        a(int i) {
            this.indexNum = i;
        }

        public int index() {
            return this.indexNum;
        }
    }
}
