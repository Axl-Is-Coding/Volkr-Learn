package freemarker.ext.dom;

import freemarker.template.K;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;

/* JADX INFO: compiled from: CharacterDataNodeModel.java */
/* JADX INFO: loaded from: classes5.dex */
class b extends m implements K {
    public b(CharacterData characterData) {
        super(characterData);
    }

    @Override // freemarker.template.K
    public String getAsString() {
        return ((CharacterData) this.i).getData();
    }

    @Override // freemarker.template.I
    public String getNodeName() {
        return this.i instanceof Comment ? "@comment" : "@text";
    }

    @Override // freemarker.template.A
    public boolean isEmpty() {
        return true;
    }
}
