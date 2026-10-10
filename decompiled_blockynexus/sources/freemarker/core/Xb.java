package freemarker.core;

import java.util.Collections;
import java.util.Enumeration;
import javax.swing.tree.TreeNode;

/* JADX INFO: compiled from: TemplateElement.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class Xb extends Yb implements TreeNode {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Xb f21498f;
    private Xb g;
    private Xb[] h;
    private int i;
    private int j;

    protected abstract String a(boolean z);

    final void a(Xb xb) {
        if (xb != null) {
            xb.f21498f = this;
            xb.j = 0;
        }
        this.g = xb;
    }

    public TreeNode c(int i) {
        Xb xb = this.g;
        if (xb != null) {
            if (i == 0) {
                return xb;
            }
            throw new ArrayIndexOutOfBoundsException("invalid index");
        }
        if (this.i == 0) {
            throw new ArrayIndexOutOfBoundsException("Template element has no children");
        }
        try {
            return this.h[i];
        } catch (ArrayIndexOutOfBoundsException unused) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Index: ");
            stringBuffer.append(i);
            stringBuffer.append(", Size: ");
            stringBuffer.append(this.i);
            throw new IndexOutOfBoundsException(stringBuffer.toString());
        }
    }

    @Override // freemarker.core.Yb
    public final String e() {
        return a(true);
    }

    public Enumeration m() {
        Xb xb = this.g;
        if (xb != null) {
            return Collections.enumeration(Collections.singletonList(xb));
        }
        Xb[] xbArr = this.h;
        return xbArr != null ? new _b(xbArr, this.i) : Collections.enumeration(Collections.EMPTY_LIST);
    }

    public int n() {
        if (this.g != null) {
            return 1;
        }
        return this.i;
    }

    public final String o() {
        return a(false);
    }

    final Xb p() {
        return this.g;
    }

    final Xb q() {
        return this.f21498f;
    }

    boolean r() {
        return true;
    }
}
