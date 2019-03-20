import net.sourceforge.pinyin4j.PinyinHelper;

public class DistanceOfStrings {
    /**
     *
     * @param S  全量字符串数组
     * @param sLen  待计算距离的字符串的字符个数，从开始位置起。
     * @param T    全量字符串数组
     * @param tLen     待计算距离的字符串的字符个数，从开始位置起。
     * @return
     */
    public static int distance(char[] S, int sLen, char[] T, int tLen){
        if(sLen == 0){
            return tLen;
        }
        if(tLen == 0){
            return sLen;
        }

        if(S[sLen-1] == T[tLen-1]){
            return distance(S, sLen-1, T, tLen-1);
        }

        return min(distance(S, sLen-1, T, tLen-1), distance(S, sLen, T, tLen-1), distance(S, sLen-1, T, tLen)) + 1;
    }

    public static int min(int a, int b, int c){
        return a<b?(a<c?a:c):(b<c?b:c);
    }
/**
 * 获取汉字首字母的方法。如： 张三 --> ZS
 * 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
 * @param hanzi 汉子字符串
 * @return 大写汉子首字母; 如果都转换失败,那么返回null
 */
    public static String getHanziInitials(String hanzi) {
        String result = null;
        if(null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if(null != stringArray) {
                    sb.append(stringArray[0].charAt(0));
                }
            }
            if(sb.length() > 0) {
                result = sb.toString().toUpperCase();
            }
        }
        return result;
    }


        /**
         * 获取汉字拼音的方法。如： 张三 --> zhangsan
         * 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
         * @param hanzi 汉子字符串
         * @return 汉字拼音; 如果都转换失败,那么返回null
         */
    public static String getHanziPinYin(String hanzi) {
        String result = null;
        if(null != hanzi && !"".equals(hanzi)) {
            char[] charArray = hanzi.toCharArray();
            StringBuffer sb = new StringBuffer();
            for (char ch : charArray) {
                // 逐个汉字进行转换， 每个汉字返回值为一个String数组（因为有多音字）
                String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
                if(null != stringArray) {
                    // 把第几声这个数字给去掉
                    sb.append(stringArray[0].replaceAll("\\d", ""));
                }
            }
            if(sb.length() > 0) {
                result = sb.toString();
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        char[] S = "abc".toCharArray();
//        char[] T = "".toCharArray();
//        System.out.println(distance(S, S.length, T, T.length));
//
//        //1
//        S = "abc".toCharArray();
//        T = "abcd".toCharArray();
//        System.out.println(distance(S, S.length, T, T.length));
//
//        //1
//        S = "abcd".toCharArray();
//        T = "abxd".toCharArray();
//        System.out.println(distance(S, S.length, T, T.length));
//
        //3
//        S = "abcd".toCharArray();
//        T = "abxdbcd".toCharArray();
//        System.out.println(distance(S, S.length, T, T.length));
//
//
//
//        System.out.println(getHanziPinYin("袁素芳"));

        char[] first = getHanziPinYin("非常大脑").toCharArray();
        char[] second = getHanziPinYin("奥德赛").toCharArray();
        System.out.println(first);
        System.out.println(second);
        System.out.println(distance(first, first.length, second, second.length));

    }
}
