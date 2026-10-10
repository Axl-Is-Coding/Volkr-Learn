package com.sandboxol.center.chain;

import android.util.SparseArray;
import com.sandboxol.center.chain.ChainNode;

/* JADX INFO: loaded from: classes3.dex */
public class ChainHandler implements Handler {
    private SparseArray<ChainNode> nodeArrays;

    public static class Builder {
        private SparseArray<ChainNode> nodeArrays = new SparseArray<>();

        public Builder addNode(ChainNode chainNode) {
            if (chainNode != null) {
                this.nodeArrays.append(chainNode.getId(), chainNode);
            }
            return this;
        }

        public ChainHandler build() {
            return new ChainHandler(this.nodeArrays);
        }
    }

    public ChainHandler(SparseArray<ChainNode> sparseArray) {
        this.nodeArrays = sparseArray;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: nextNode, reason: merged with bridge method [inline-methods] */
    public void a(int i) {
        removeNode(i);
        if (this.nodeArrays.size() > 0) {
            startNode(this.nodeArrays.keyAt(0));
        }
    }

    private void removeNode(int i) {
        if (this.nodeArrays.size() > 0) {
            this.nodeArrays.removeAt(i);
        }
    }

    private void startNode(int i) {
        final int iIndexOfKey = this.nodeArrays.indexOfKey(i);
        ChainNode chainNodeValueAt = this.nodeArrays.valueAt(iIndexOfKey);
        if (chainNodeValueAt != null) {
            chainNodeValueAt.process(new ChainNode.CallBack() { // from class: com.sandboxol.center.chain.a
                @Override // com.sandboxol.center.chain.ChainNode.CallBack
                public final void onComplete() {
                    this.f16311a.a(iIndexOfKey);
                }
            });
        }
    }

    @Override // com.sandboxol.center.chain.Handler
    public void start() {
        SparseArray<ChainNode> sparseArray = this.nodeArrays;
        if (sparseArray == null || sparseArray.size() <= 0) {
            throw new ChainException("nodeArrays == null || nodeArrays.size <= 0");
        }
        startNode(this.nodeArrays.keyAt(0));
    }
}
