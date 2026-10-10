package freemarker.core;

import com.alibaba.android.arouter.utils.Consts;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import freemarker.template.Template;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes5.dex */
public class ParseException extends IOException implements Ib {
    static /* synthetic */ Class class$freemarker$core$ParseException;
    private static volatile Boolean jbossToolsMode;
    public int columnNumber;
    public Token currentToken;
    private String description;
    public int endColumnNumber;
    public int endLineNumber;
    protected String eol;
    public int[][] expectedTokenSequences;
    public int lineNumber;
    private String message;
    private boolean messageAndDescriptionRendered;
    protected boolean specialConstructor;
    private String templateName;
    public String[] tokenImage;

    public ParseException(Token token, int[][] iArr, String[] strArr) {
        super("");
        this.eol = freemarker.template.utility.g.a("line.separator", UMCustomLogInfoBuilder.LINE_SEP);
        this.currentToken = token;
        this.specialConstructor = true;
        this.expectedTokenSequences = iArr;
        this.tokenImage = strArr;
        Token token2 = this.currentToken.next;
        this.lineNumber = token2.beginLine;
        this.columnNumber = token2.beginColumn;
        this.endLineNumber = token2.endLine;
        this.endColumnNumber = token2.endColumn;
    }

    static /* synthetic */ Class class$(String str) throws Throwable {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }

    private String concatWithOrs(Set set) {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            if (stringBuffer.length() != 0) {
                stringBuffer.append(" or ");
            }
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    private String getCustomTokenErrorDescription() {
        String string;
        Token token = this.currentToken.next;
        int i = token.kind;
        if (i != 0) {
            if (i == 48) {
                return "Unexpected directive, \"#else\". Check if you have a valid #if-#elseif-#else or #list-#else structure.";
            }
            if (i != 33 && i != 9) {
                return null;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Unexpected directive, ");
            stringBuffer.append(freemarker.template.utility.h.a(token));
            stringBuffer.append(". Check if you have a valid #if-#elseif-#else structure.");
            return stringBuffer.toString();
        }
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (true) {
            int[][] iArr = this.expectedTokenSequences;
            if (i2 >= iArr.length) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("Unexpected end of file reached.");
                if (hashSet.size() == 0) {
                    string = "";
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(" You have an unclosed ");
                    stringBuffer3.append(concatWithOrs(hashSet));
                    stringBuffer3.append(Consts.DOT);
                    string = stringBuffer3.toString();
                }
                stringBuffer2.append(string);
                return stringBuffer2.toString();
            }
            for (int i3 : iArr[i2]) {
                if (i3 == 33) {
                    hashSet.add("#if");
                } else if (i3 == 34) {
                    hashSet.add("#list");
                } else if (i3 == 64) {
                    hashSet.add("#escape");
                } else if (i3 == 66) {
                    hashSet.add("#noescape");
                } else if (i3 == 68) {
                    hashSet.add("@...");
                } else if (i3 == 125) {
                    hashSet.add("\"[\"");
                } else if (i3 == 127) {
                    hashSet.add("\"(\"");
                } else if (i3 != 129) {
                    switch (i3) {
                        case 38:
                            hashSet.add("#attempt");
                            break;
                        case 39:
                            hashSet.add("#foreach");
                            break;
                        case 40:
                            hashSet.add("#local");
                            break;
                        case 41:
                            hashSet.add("#global");
                            break;
                        case 42:
                            hashSet.add("#assign");
                            break;
                        case 44:
                            hashSet.add("#macro");
                        case 43:
                            hashSet.add("#function");
                            break;
                        case 45:
                            hashSet.add("#compress");
                            break;
                        case 46:
                            hashSet.add("#transform");
                            break;
                        case 47:
                            hashSet.add("#switch");
                            break;
                    }
                } else {
                    hashSet.add("\"{\"");
                }
            }
            i2++;
        }
    }

    private String getDescription() {
        String str;
        synchronized (this) {
            if (this.messageAndDescriptionRendered) {
                return this.description;
            }
            renderMessageAndDescription();
            synchronized (this) {
                str = this.description;
            }
            return str;
        }
    }

    private String getOrRenderDescription() {
        String string;
        synchronized (this) {
            if (this.description != null) {
                return this.description;
            }
            if (this.currentToken == null) {
                return null;
            }
            String customTokenErrorDescription = getCustomTokenErrorDescription();
            if (customTokenErrorDescription != null) {
                return customTokenErrorDescription;
            }
            StringBuffer stringBuffer = new StringBuffer();
            int length = 0;
            for (int i = 0; i < this.expectedTokenSequences.length; i++) {
                if (i != 0) {
                    stringBuffer.append(this.eol);
                }
                stringBuffer.append("    ");
                int[][] iArr = this.expectedTokenSequences;
                if (length < iArr[i].length) {
                    length = iArr[i].length;
                }
                for (int i2 = 0; i2 < this.expectedTokenSequences[i].length; i2++) {
                    if (i2 != 0) {
                        stringBuffer.append(' ');
                    }
                    stringBuffer.append(this.tokenImage[this.expectedTokenSequences[i][i2]]);
                }
            }
            String string2 = "Encountered \"";
            Token token = this.currentToken.next;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (i3 != 0) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(string2);
                    stringBuffer2.append(" ");
                    string2 = stringBuffer2.toString();
                }
                if (token.kind == 0) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append(string2);
                    stringBuffer3.append(this.tokenImage[0]);
                    string2 = stringBuffer3.toString();
                    break;
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(string2);
                stringBuffer4.append(add_escapes(token.image));
                string2 = stringBuffer4.toString();
                token = token.next;
                i3++;
            }
            StringBuffer stringBuffer5 = new StringBuffer();
            stringBuffer5.append(string2);
            stringBuffer5.append("\", but ");
            String string3 = stringBuffer5.toString();
            if (this.expectedTokenSequences.length == 1) {
                StringBuffer stringBuffer6 = new StringBuffer();
                stringBuffer6.append(string3);
                stringBuffer6.append("was expecting:");
                stringBuffer6.append(this.eol);
                string = stringBuffer6.toString();
            } else {
                StringBuffer stringBuffer7 = new StringBuffer();
                stringBuffer7.append(string3);
                stringBuffer7.append("was expecting one of:");
                stringBuffer7.append(this.eol);
                string = stringBuffer7.toString();
            }
            StringBuffer stringBuffer8 = new StringBuffer();
            stringBuffer8.append(string);
            stringBuffer8.append((Object) stringBuffer);
            return stringBuffer8.toString();
        }
    }

    private boolean isInJBossToolsMode() {
        Class clsClass$;
        if (jbossToolsMode == null) {
            try {
                if (class$freemarker$core$ParseException == null) {
                    clsClass$ = class$("freemarker.core.ParseException");
                    class$freemarker$core$ParseException = clsClass$;
                } else {
                    clsClass$ = class$freemarker$core$ParseException;
                }
                jbossToolsMode = Boolean.valueOf(clsClass$.getClassLoader().toString().indexOf("[org.jboss.ide.eclipse.freemarker:") != -1);
            } catch (Throwable unused) {
                jbossToolsMode = Boolean.FALSE;
            }
        }
        return jbossToolsMode.booleanValue();
    }

    private void renderMessageAndDescription() {
        String string;
        String orRenderDescription = getOrRenderDescription();
        if (isInJBossToolsMode()) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("[col. ");
            stringBuffer.append(this.columnNumber);
            stringBuffer.append("] ");
            string = stringBuffer.toString();
        } else {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("Syntax error ");
            stringBuffer2.append(Ob.a(this.templateName, this.lineNumber, this.columnNumber));
            stringBuffer2.append(":\n");
            string = stringBuffer2.toString();
        }
        StringBuffer stringBuffer3 = new StringBuffer();
        stringBuffer3.append(string);
        stringBuffer3.append(orRenderDescription);
        String string2 = stringBuffer3.toString();
        String strSubstring = string2.substring(string.length());
        synchronized (this) {
            this.message = string2;
            this.description = strSubstring;
            this.messageAndDescriptionRendered = true;
        }
    }

    protected String add_escapes(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt != 0) {
                if (cCharAt == '\"') {
                    stringBuffer.append("\\\"");
                } else if (cCharAt == '\'') {
                    stringBuffer.append("\\'");
                } else if (cCharAt == '\\') {
                    stringBuffer.append("\\\\");
                } else if (cCharAt == '\f') {
                    stringBuffer.append("\\f");
                } else if (cCharAt != '\r') {
                    switch (cCharAt) {
                        case '\b':
                            stringBuffer.append("\\b");
                            break;
                        case '\t':
                            stringBuffer.append("\\t");
                            break;
                        case '\n':
                            stringBuffer.append("\\n");
                            break;
                        default:
                            char cCharAt2 = str.charAt(i);
                            if (cCharAt2 < ' ' || cCharAt2 > '~') {
                                StringBuffer stringBuffer2 = new StringBuffer();
                                stringBuffer2.append("0000");
                                stringBuffer2.append(Integer.toString(cCharAt2, 16));
                                String string = stringBuffer2.toString();
                                StringBuffer stringBuffer3 = new StringBuffer();
                                stringBuffer3.append("\\u");
                                stringBuffer3.append(string.substring(string.length() - 4, string.length()));
                                stringBuffer.append(stringBuffer3.toString());
                            } else {
                                stringBuffer.append(cCharAt2);
                            }
                            break;
                    }
                } else {
                    stringBuffer.append("\\r");
                }
            }
        }
        return stringBuffer.toString();
    }

    public int getColumnNumber() {
        return this.columnNumber;
    }

    public String getEditorMessage() {
        return getDescription();
    }

    public int getEndColumnNumber() {
        return this.endColumnNumber;
    }

    public int getEndLineNumber() {
        return this.endLineNumber;
    }

    public int getLineNumber() {
        return this.lineNumber;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String str;
        synchronized (this) {
            if (this.messageAndDescriptionRendered) {
                return this.message;
            }
            renderMessageAndDescription();
            synchronized (this) {
                str = this.message;
            }
            return str;
        }
    }

    public String getTemplateName() {
        return this.templateName;
    }

    public void setTemplateName(String str) {
        this.templateName = str;
        synchronized (this) {
            this.messageAndDescriptionRendered = false;
            this.message = null;
        }
    }

    protected ParseException() {
        this.eol = freemarker.template.utility.g.a("line.separator", UMCustomLogInfoBuilder.LINE_SEP);
    }

    public ParseException(String str, int i, int i2) {
        this(str, null, i, i2, null);
    }

    public ParseException(String str, Template template, int i, int i2, int i3, int i4) {
        this(str, template, i, i2, i3, i4, (Throwable) null);
    }

    public ParseException(String str, Template template, int i, int i2, int i3, int i4, Throwable th) {
        this(str, template == null ? null : template.g(), i, i2, i3, i4, th);
    }

    public ParseException(String str, Template template, int i, int i2) {
        this(str, template, i, i2, null);
    }

    public ParseException(String str, Template template, int i, int i2, Throwable th) {
        this(str, template == null ? null : template.g(), i, i2, 0, 0, th);
    }

    public ParseException(String str, Template template, Token token) {
        this(str, template, token, (Throwable) null);
    }

    public ParseException(String str, Template template, Token token, Throwable th) {
        this(str, template == null ? null : template.g(), token.beginLine, token.beginColumn, token.endLine, token.endColumn, th);
    }

    public ParseException(String str, Yb yb) {
        this(str, yb, (Throwable) null);
    }

    public ParseException(String str, Yb yb, Throwable th) {
        this(str, yb.l() == null ? null : yb.l().g(), yb.f21501c, yb.f21500b, yb.f21503e, yb.f21502d, th);
    }

    private ParseException(String str, String str2, int i, int i2, int i3, int i4, Throwable th) {
        super(str);
        this.eol = freemarker.template.utility.g.a("line.separator", UMCustomLogInfoBuilder.LINE_SEP);
        this.description = str;
        this.templateName = str2;
        this.lineNumber = i;
        this.columnNumber = i2;
        this.endLineNumber = i3;
        this.endColumnNumber = i4;
    }
}
