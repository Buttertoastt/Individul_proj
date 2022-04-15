package com.google.api;

import java.util.Hashtable;
public class HTMLEntities {

    /**
     * Translation table for HTML entities.<br/>
     * reference: W3C - Character entity references in HTML 4 [<a href="http://www.w3.org/TR/html401/sgml/entities.html" target="_blank">http://www.w3.org/TR/html401/sgml/entities.html</a>].
     */
    private static final Object[][] html_entities_table = {
            { new String("&Aacute;"), 193},
            { new String("&aacute;"), 225 },
            { new String("&Acirc;"), 194},
            { new String("&acirc;"), 226 },
            { new String("&acute;"), 180 },
            { new String("&AElig;"), 198 },
            { new String("&aelig;"), 230 },
            { new String("&Agrave;"), 192 },
            { new String("&agrave;"), 224 },
            { new String("&alefsym;"), 8501 },
            { new String("&Alpha;"), 913 },
            { new String("&alpha;"), 945 },
            { new String("&amp;"), 38 },
            { new String("&and;"), 8743 },
            { new String("&ang;"), 8736 },
            { new String("&Aring;"), 197 },
            { new String("&aring;"), 229 },
            { new String("&asymp;"), 8776 },
            { new String("&Atilde;"), 195 },
            { new String("&atilde;"), 227 },
            { new String("&Auml;"), 196 },
            { new String("&auml;"), 228 },
            { new String("&bdquo;"), 8222 },
            { new String("&Beta;"), 914 },
            { new String("&beta;"), 946 },
            { new String("&brvbar;"), 166 },
            { new String("&bull;"), 8226 },
            { new String("&cap;"), 8745 },
            { new String("&Ccedil;"), 199 },
            { new String("&ccedil;"), 231 },
            { new String("&cedil;"), 184 },
            { new String("&cent;"), 162 },
            { new String("&Chi;"), 935 },
            { new String("&chi;"), 967 },
            { new String("&circ;"), 710 },
            { new String("&clubs;"), 9827 },
            { new String("&cong;"), 8773 },
            { new String("&copy;"), 169 },
            { new String("&crarr;"), 8629 },
            { new String("&cup;"), 8746 },
            { new String("&curren;"), 164 },
            { new String("&dagger;"), 8224 },
            { new String("&Dagger;"), 8225},
            { new String("&darr;"), 8595 },
            { new String("&dArr;"), 8659 },
            { new String("&deg;"), 176 },
            { new String("&Delta;"), 916},
            { new String("&delta;"), 948 },
            { new String("&diams;"), 9830 },
            { new String("&divide;"), 247 },
            { new String("&Eacute;"), 201 },
            { new String("&eacute;"), 233 },
            { new String("&Ecirc;"), 202 },
            { new String("&ecirc;"), 234 },
            { new String("&Egrave;"), 200 },
            { new String("&egrave;"), 232 },
            { new String("&empty;"), 8709},
            { new String("&emsp;"), 8195 },
            { new String("&ensp;"), 8194 },
            { new String("&Epsilon;"), 917 },
            { new String("&epsilon;"), 949 },
            { new String("&equiv;"), 8801 },
            { new String("&Eta;"), 919 },
            { new String("&eta;"), 951 },
            { new String("&ETH;"), 208 },
            { new String("&eth;"), 240 },
            { new String("&Euml;"), 203 },
            { new String("&euml;"), 235 },
            { new String("&euro;"), 8364 },
            { new String("&exist;"), 8707 },
            { new String("&fnof;"), 402 },
            { new String("&forall;"), 8704 },
            { new String("&frac12;"), 189 },
            { new String("&frac14;"), 188},
            { new String("&frac34;"), 190 },
            { new String("&frasl;"), 8260},
            { new String("&Gamma;"), 915 },
            { new String("&gamma;"), 947 },
            { new String("&ge;"), 8805 },
            { new String("&harr;"), 8596 },
            { new String("&hArr;"), 8660 },
            { new String("&hearts;"), 9829 },
            { new String("&hellip;"), 8230},
            { new String("&Iacute;"), 205 },
            { new String("&iacute;"), 237 },
            { new String("&Icirc;"), 206 },
            { new String("&icirc;"), 238 },
            { new String("&iexcl;"), 161 },
            { new String("&Igrave;"), 204 },
            { new String("&igrave;"), 236 },
            { new String("&image;"), 8465 },
            { new String("&infin;"), 8734},
            { new String("&int;"), 8747 },
            { new String("&Iota;"), 921 },
            { new String("&iota;"), 953 },
            { new String("&iquest;"), 191 },
            { new String("&isin;"), 8712 },
            { new String("&Iuml;"), 207 },
            { new String("&iuml;"), 239 },
            { new String("&Kappa;"), 922 },
            { new String("&kappa;"), 954 },
            { new String("&Lambda;"), 923 },
            { new String("&lambda;"), 955 },
            { new String("&lang;"), 9001 },
            { new String("&laquo;"), 171 },
            { new String("&larr;"), 8592 },
            { new String("&lArr;"), 8656 },
            { new String("&lceil;"), 8968},
            { new String("&ldquo;"), 8220 },
            { new String("&le;"), 8804 },
            { new String("&lfloor;"), 8970 },
            { new String("&lowast;"), 8727 },
            { new String("&loz;"), 9674 },
            { new String("&lrm;"), 8206 },
            { new String("&lsaquo;"), 8249 },
            { new String("&lsquo;"), 8216 },
            { new String("&macr;"), 175 },
            { new String("&mdash;"), 8212 },
            { new String("&micro;"), 181 },
            { new String("&middot;"), 183 },
            { new String("&minus;"), 8722 },
            { new String("&Mu;"), 924 },
            { new String("&mu;"), 956 },
            { new String("&nabla;"), 8711 },
            { new String("&nbsp;"), 160 },
            { new String("&ndash;"), 8211 },
            { new String("&ne;"), 8800 },
            { new String("&ni;"), 8715 },
            { new String("&not;"), 172 },
            { new String("&notin;"), 8713 },
            { new String("&nsub;"), 8836 },
            { new String("&Ntilde;"), 209 },
            { new String("&ntilde;"), 241 },
            { new String("&Nu;"), 925 },
            { new String("&nu;"), 957 },
            { new String("&Oacute;"), 211 },
            { new String("&oacute;"), 243 },
            { new String("&Ocirc;"), 212 },
            { new String("&ocirc;"), 244 },
            { new String("&OElig;"), 338 },
            { new String("&oelig;"), 339 },
            { new String("&Ograve;"), 210 },
            { new String("&ograve;"), 242 },
            { new String("&oline;"), 8254 },
            { new String("&Omega;"), 937 },
            { new String("&omega;"), 969 },
            { new String("&Omicron;"), 927 },
            { new String("&omicron;"), 959 },
            { new String("&oplus;"), 8853 },
            { new String("&or;"), 8744 },
            { new String("&ordf;"), 170 },
            { new String("&ordm;"), 186 },
            { new String("&Oslash;"), 216 },
            { new String("&oslash;"), 248 },
            { new String("&Otilde;"), 213 },
            { new String("&otilde;"), 245 },
            { new String("&otimes;"), 8855 },
            { new String("&Ouml;"), 214 },
            { new String("&ouml;"), 246 },
            { new String("&para;"), 182 },
            { new String("&part;"), 8706 },
            { new String("&permil;"), 8240},
            { new String("&perp;"), 8869 },
            { new String("&Phi;"), 934 },
            { new String("&phi;"), 966 },
            { new String("&Pi;"), 928 },
            { new String("&pi;"), 960 },
            { new String("&piv;"), 982 },
            { new String("&plusmn;"), 177 },
            { new String("&pound;"), 163 },
            { new String("&prime;"), 8242 },
            { new String("&Prime;"), 8243 },
            { new String("&prod;"), 8719 },
            { new String("&prop;"), 8733 },
            { new String("&Psi;"), 936 },
            { new String("&psi;"), 968 },
            { new String("&quot;"), 34 },
            { new String("&radic;"), 8730 },
            { new String("&rang;"), 9002 },
            { new String("&raquo;"), 187 },
            { new String("&rarr;"), 8594 },
            { new String("&rArr;"), 8658 },
            { new String("&rceil;"), 8969 },
            { new String("&rdquo;"), 8221 },
            { new String("&real;"), 8476 },
            { new String("&reg;"), 174 },
            { new String("&rfloor;"), 8971 },
            { new String("&Rho;"), 929 },
            { new String("&rho;"), 961 },
            { new String("&rlm;"), 8207 },
            { new String("&rsaquo;"), 8250 },
            { new String("&rsquo;"), 8217 },
            { new String("&sbquo;"), 8218 },
            { new String("&Scaron;"), 352 },
            { new String("&scaron;"), 353 },
            { new String("&sdot;"), 8901 },
            { new String("&sect;"), 167 },
            { new String("&shy;"), 173 },
            { new String("&Sigma;"), 931 },
            { new String("&sigma;"), 963 },
            { new String("&sigmaf;"), 962 },
            { new String("&sim;"), 8764 },
            { new String("&spades;"), 9824},
            { new String("&sub;"), 8834 },
            { new String("&sube;"), 8838 },
            { new String("&sum;"), 8721 },
            { new String("&sup1;"), 185 },
            { new String("&sup2;"), 178 },
            { new String("&sup3;"), 179 },
            { new String("&sup;"), 8835 },
            { new String("&supe;"), 8839 },
            { new String("&szlig;"), 223 },
            { new String("&Tau;"), 932 },
            { new String("&tau;"), 964 },
            { new String("&there4;"), 8756 },
            { new String("&Theta;"), 920 },
            { new String("&theta;"), 952 },
            { new String("&thetasym;"), 977 },
            { new String("&thinsp;"), 8201 },
            { new String("&THORN;"), 222 },
            { new String("&thorn;"), 254 },
            { new String("&tilde;"), 732 },
            { new String("&times;"), 215 },
            { new String("&trade;"), 8482 },
            { new String("&Uacute;"), 218 },
            { new String("&uacute;"), 250 },
            { new String("&uarr;"), 8593 },
            { new String("&uArr;"), 8657 },
            { new String("&Ucirc;"), 219 },
            { new String("&ucirc;"), 251 },
            { new String("&Ugrave;"), 217 },
            { new String("&ugrave;"), 249 },
            { new String("&uml;"), 168 },
            { new String("&upsih;"), 978 },
            { new String("&Upsilon;"), 933 },
            { new String("&upsilon;"), 965 },
            { new String("&Uuml;"), 220 },
            { new String("&uuml;"), 252 },
            { new String("&weierp;"), 8472},
            { new String("&Xi;"), 926 },
            { new String("&xi;"), 958 },
            { new String("&Yacute;"), 221},
            { new String("&yacute;"), 253 },
            { new String("&yen;"), 165 },
            { new String("&yuml;"), 255 },
            { new String("&Yuml;"), 376 },
            { new String("&Zeta;"), 918 },
            { new String("&zeta;"), 950 },
            { new String("&zwj;"), 8205 },
            { new String("&zwnj;"), 8204 } };

    /**
     * Map to convert extended characters in html entities.
     */
    private static final Hashtable htmlentities_map = new Hashtable();

    /**
     * Map to convert html entities in exteden characters.
     */
    private static final Hashtable unhtmlentities_map = new Hashtable();

    //==============================================================================
    // METHODS
    //==============================================================================

    /**
     * Initialize HTML translation maps.
     */
    public HTMLEntities() {
        initializeEntitiesTables();
    }

    /**
     * Initialize HTML entities table.
     */
    private static void initializeEntitiesTables() {
        // initialize html translation maps
        for (int i = 0; i < html_entities_table.length; ++i) {
            htmlentities_map.put(html_entities_table[i][1],
                    html_entities_table[i][0]);
            unhtmlentities_map.put(html_entities_table[i][0],
                    html_entities_table[i][1]);
        }
    }

    /**
     * Get the html entities translation table.
     *
     * @return translation table
     */
    public static Object[][] getEntitiesTable() {
        return html_entities_table;
    }

    /**
     * Convert special and extended characters into HTML entitities.
     * @param str input string
     * @return formatted string
     * @see #unhtmlentities(String)
     */
    public static String htmlentities(String str) {

        if (str == null) {
            return "";
        }
        //initialize html translation maps table the first time is called
        if (htmlentities_map.isEmpty()) {
            initializeEntitiesTables();
        }

        StringBuffer buf = new StringBuffer(); //the otput string buffer

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            String entity = (String) htmlentities_map.get(Integer.parseInt(String.valueOf(ch))); //get equivalent html entity
            if (entity == null) { //if entity has not been found
                if (((int) ch) > 128) { //check if is an extended character
                    buf.append("&#" + ((int) ch) + ";"); //convert extended character
                } else {
                    buf.append(ch); //append the character as is
                }
            } else {
                buf.append(entity); //append the html entity
            }
        }
        return buf.toString();
    }

    /**
     * Convert HTML entities to special and extended unicode characters
     * equivalents.
     * @param str input string
     * @return formatted string
     * @see #htmlentities(String)
     */
    public static String unhtmlentities(String str) {

        //initialize html translation maps table the first time is called
        if (htmlentities_map.isEmpty()) {
            initializeEntitiesTables();
        }

        StringBuffer buf = new StringBuffer();

        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            if (ch == '&') {
                int semi = str.indexOf(';', i + 1);
                if ((semi == -1) || ((semi-i) > 7)){
                    buf.append(ch);
                    continue;
                }
                String entity = str.substring(i, semi + 1);
                Integer iso;
                if (entity.charAt(1) == ' ') {
                    buf.append(ch);
                    continue;
                }
                if (entity.charAt(1) == '#') {
                    if (entity.charAt(2) == 'x') {
                        iso = Integer.parseInt(entity.substring(3, entity.length() - 1), 16);
                    }
                    else {
                        iso = Integer.parseInt(entity.substring(2, entity.length() - 1));
                    }
                } else {
                    iso = (Integer) unhtmlentities_map.get(entity);
                }
                if (iso == null) {
                    buf.append(entity);
                } else {
                    buf.append((char) (iso.intValue()));
                }
                i = semi;
            } else {
                buf.append(ch);
            }
        }
        return buf.toString();
    }

    // methods to convert special characters

    /**
     * Replace single quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String htmlSingleQuotes(String str) {
        str = str.replaceAll("[\']", "&rsquo;");
        str = str.replaceAll("&#039;", "&rsquo;");
        str = str.replaceAll("&#145;", "&rsquo;");
        str = str.replaceAll("&#146;", "&rsquo;");
        return str;
    }

    /**
     * Replace single quotes HTML entities with equivalent character.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String unhtmlSingleQuotes(String str) {
        return str.replaceAll("&rsquo;", "\'");
    }

    /**
     * Replace double quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced double quotes
     */
    public static String htmlDoubleQuotes(String str) {
        str = str.replaceAll("[\"]", "&quot;");
        str = str.replaceAll("&#147;", "&quot;");
        str = str.replaceAll("&#148;", "&quot;");
        return str;
    }

    /**
     * Replace single quotes HTML entities with equivalent character.
     *
     * @param str the input string
     * @return string with replaced single quotes
     */
    public static String unhtmlDoubleQuotes(String str) {
        return str.replaceAll("&quot;", "\"");
    }

    /**
     * Replace single and double quotes characters with HTML entities.
     *
     * @param str the input string
     * @return string with replaced quotes
     */
    public static String htmlQuotes(String str) {
        str = htmlDoubleQuotes(str); //convert double quotes
        str = htmlSingleQuotes(str); //convert single quotes
        return str;
    }

    /**
     * Replace single and double quotes HTML entities with equivalent characters.
     *
     * @param str the input string
     * @return string with replaced quotes
     */
    public static String unhtmlQuotes(String str) {
        str = unhtmlDoubleQuotes(str); //convert double quotes
        str = unhtmlSingleQuotes(str); //convert single quotes
        return str;
    }

    /**
     * Replace &lt; &gt; characters with &amp;lt; &amp;gt; entities.
     *
     * @param str the input string
     * @return string with replaced characters
     */
    public static String htmlAngleBrackets(String str) {
        str = str.replaceAll("<", "&lt;");
        str = str.replaceAll(">", "&gt;");
        return str;
    }

    /**
     * Replace &amp;lt; &amp;gt; entities with &lt; &gt; characters.
     *
     * @param str the input string
     * @return string with replaced entities
     */
    public static String unhtmlAngleBrackets(String str) {
        str = str.replaceAll("&lt;", "<");
        str = str.replaceAll("&gt;", ">");
        return str;
    }

    /**
     * Replace &amp; characters with &amp;amp; HTML entities.
     *
     * @param str the input string
     * @return string with replaced characters
     */
    public static String htmlAmpersand(String str) {
        return str.replaceAll("&", "&amp;");
    }

    /**
     * Replace &amp;amp; HTML entities with &amp; characters.
     *
     * @param str the input string
     * @return string with replaced entities
     */
    public static String unhtmlAmpersand(String str) {
        return str.replaceAll("&amp;", "&");
    }
}