package freemarker.template;

import com.alibaba.android.arouter.utils.Consts;
import java.io.Serializable;
import java.util.Date;

/* JADX INFO: loaded from: classes5.dex */
public final class Version implements Serializable {
    private final Date buildDate;
    private String calculatedStringValue;
    private final String extraInfo;
    private final Boolean gaeCompliant;
    private int hashCode;
    private final int intValue;
    private final int major;
    private final int micro;
    private final int minor;
    private final String originalStringValue;

    public Version(String str) {
        this(str, (Boolean) null, (Date) null);
    }

    private int calculateIntValue() {
        return intValueFor(this.major, this.minor, this.micro);
    }

    private String getStringValue() {
        String str;
        String str2 = this.originalStringValue;
        if (str2 != null) {
            return str2;
        }
        synchronized (this) {
            if (this.calculatedStringValue == null) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append(this.major);
                stringBuffer.append(Consts.DOT);
                stringBuffer.append(this.minor);
                stringBuffer.append(Consts.DOT);
                stringBuffer.append(this.micro);
                this.calculatedStringValue = stringBuffer.toString();
                if (this.extraInfo != null) {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append(this.calculatedStringValue);
                    stringBuffer2.append("-");
                    stringBuffer2.append(this.extraInfo);
                    this.calculatedStringValue = stringBuffer2.toString();
                }
            }
            str = this.calculatedStringValue;
        }
        return str;
    }

    public static int intValueFor(int i, int i2, int i3) {
        return (i * 1000000) + (i2 * 1000) + i3;
    }

    private boolean isNumber(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || Version.class != obj.getClass()) {
            return false;
        }
        Version version = (Version) obj;
        if (this.intValue != version.intValue || version.hashCode() != hashCode()) {
            return false;
        }
        Date date = this.buildDate;
        if (date == null) {
            if (version.buildDate != null) {
                return false;
            }
        } else if (!date.equals(version.buildDate)) {
            return false;
        }
        String str = this.extraInfo;
        if (str == null) {
            if (version.extraInfo != null) {
                return false;
            }
        } else if (!str.equals(version.extraInfo)) {
            return false;
        }
        Boolean bool = this.gaeCompliant;
        if (bool == null) {
            if (version.gaeCompliant != null) {
                return false;
            }
        } else if (!bool.equals(version.gaeCompliant)) {
            return false;
        }
        return true;
    }

    public Date getBuildDate() {
        return this.buildDate;
    }

    public String getExtraInfo() {
        return this.extraInfo;
    }

    public int getMajor() {
        return this.major;
    }

    public int getMicro() {
        return this.micro;
    }

    public int getMinor() {
        return this.minor;
    }

    public int hashCode() {
        int i;
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        synchronized (this) {
            if (this.hashCode == 0) {
                int iHashCode = 0;
                int iHashCode2 = ((((this.buildDate == null ? 0 : this.buildDate.hashCode()) + 31) * 31) + (this.extraInfo == null ? 0 : this.extraInfo.hashCode())) * 31;
                if (this.gaeCompliant != null) {
                    iHashCode = this.gaeCompliant.hashCode();
                }
                int i3 = ((iHashCode2 + iHashCode) * 31) + this.intValue;
                if (i3 == 0) {
                    i3 = -1;
                }
                this.hashCode = i3;
            }
            i = this.hashCode;
        }
        return i;
    }

    public int intValue() {
        return this.intValue;
    }

    public Boolean isGAECompliant() {
        return this.gaeCompliant;
    }

    public String toString() {
        return getStringValue();
    }

    public Version(String str, Boolean bool, Date date) {
        String strSubstring;
        char cCharAt;
        String strTrim = str.trim();
        this.originalStringValue = strTrim;
        int[] iArr = new int[3];
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i >= strTrim.length()) {
                strSubstring = null;
                break;
            }
            char cCharAt2 = strTrim.charAt(i);
            if (isNumber(cCharAt2)) {
                iArr[i2] = (iArr[i2] * 10) + (cCharAt2 - '0');
            } else {
                if (i == 0) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The version number string ");
                    stringBuffer.append(freemarker.template.utility.h.e(strTrim));
                    stringBuffer.append(" doesn't start with a number.");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
                if (cCharAt2 != '.') {
                    strSubstring = strTrim.substring(i);
                    break;
                }
                int i3 = i + 1;
                char cCharAt3 = i3 >= strTrim.length() ? (char) 0 : strTrim.charAt(i3);
                if (cCharAt3 == '.') {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("The version number string ");
                    stringBuffer2.append(freemarker.template.utility.h.e(strTrim));
                    stringBuffer2.append(" contains multiple dots after a number.");
                    throw new IllegalArgumentException(stringBuffer2.toString());
                }
                if (i2 == 2 || !isNumber(cCharAt3)) {
                    break;
                } else {
                    i2++;
                }
            }
            i++;
        }
        strSubstring = strTrim.substring(i);
        if (strSubstring != null && ((cCharAt = strSubstring.charAt(0)) == '.' || cCharAt == '-' || cCharAt == '_')) {
            strSubstring = strSubstring.substring(1);
            if (strSubstring.length() == 0) {
                StringBuffer stringBuffer3 = new StringBuffer();
                stringBuffer3.append("The version number string ");
                stringBuffer3.append(freemarker.template.utility.h.e(strTrim));
                stringBuffer3.append(" has an extra info section opened with \"");
                stringBuffer3.append(cCharAt);
                stringBuffer3.append("\", but it's empty.");
                throw new IllegalArgumentException(stringBuffer3.toString());
            }
        }
        this.extraInfo = strSubstring;
        this.major = iArr[0];
        this.minor = iArr[1];
        this.micro = iArr[2];
        this.intValue = calculateIntValue();
        this.gaeCompliant = bool;
        this.buildDate = date;
    }

    public Version(int i, int i2, int i3) {
        this(i, i2, i3, null, null, null);
    }

    public Version(int i, int i2, int i3, String str, Boolean bool, Date date) {
        this.major = i;
        this.minor = i2;
        this.micro = i3;
        this.extraInfo = str;
        this.gaeCompliant = bool;
        this.buildDate = date;
        this.intValue = calculateIntValue();
        this.originalStringValue = null;
    }
}
