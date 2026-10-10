package io.rong.imlib;

/* JADX INFO: loaded from: classes5.dex */
public interface RongCommonDefine {

    public enum GetMessageDirection {
        BEHIND(0),
        FRONT(1);

        int value;

        GetMessageDirection(int i) {
            this.value = i;
        }

        int getValue() {
            return this.value;
        }
    }
}
