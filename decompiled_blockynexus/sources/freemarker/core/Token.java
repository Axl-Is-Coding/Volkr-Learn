package freemarker.core;

import java.io.Serializable;

/* JADX INFO: loaded from: classes5.dex */
class Token implements Serializable {
    public int beginColumn;
    public int beginLine;
    public int endColumn;
    public int endLine;
    public String image;
    public int kind;
    public Token next;
    public Token specialToken;

    Token() {
    }

    public static final Token newToken(int i) {
        return new Token();
    }

    public String toString() {
        return this.image;
    }
}
