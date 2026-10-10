package com.sandboxol.center.chain;

/* JADX INFO: loaded from: classes3.dex */
public class ChainNode implements Node {
    private CallBack callBack;
    private Executor executor;
    private int id;

    interface CallBack {
        void onComplete();
    }

    private ChainNode(int i, Executor executor) {
        this.id = i;
        this.executor = executor;
    }

    public static ChainNode create(int i, Executor executor) {
        return new ChainNode(i, executor);
    }

    @Override // com.sandboxol.center.chain.Node
    public void complete() {
        CallBack callBack = this.callBack;
        if (callBack != null) {
            callBack.onComplete();
        }
    }

    @Override // com.sandboxol.center.chain.Node
    public int getId() {
        return this.id;
    }

    public void process(CallBack callBack) {
        this.callBack = callBack;
        Executor executor = this.executor;
        if (executor != null) {
            executor.execute(this);
        }
    }
}
