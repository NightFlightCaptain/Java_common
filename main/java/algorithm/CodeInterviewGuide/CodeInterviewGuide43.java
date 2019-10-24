package algorithm.CodeInterviewGuide;

import java.util.Scanner;

/**
 * 【最小编辑代价】
 * <p>
 * 题目描述
 * 给定两个字符串str1和str2，再给定三个整数ic，dc和rc，分别代表插入、删除和替换一个字符的代价，请输出将str1编辑成str2的最小代价。
 * 输入描述:
 * 输出三行，第一行和第二行均为一行字符串，分别表示两个字符串str1，str2。(1≤length(str1),length(str2)≤5000)。
 * 第三行为三个正整数，代表ic，dc和rc。（1<=ic<=10000、1<=dc<=10000、1<=rc<=10000）
 * 输出描述:
 * 输出一个整数，表示编辑的最小代价。
 * <p>
 * 示例1
 * 输入
 * abc
 * adc
 * 5 3 2
 * 输出
 * 2
 * <p>
 * 示例2
 * 输入
 * abc
 * adc
 * 5 3 100
 * 输出
 * 8
 * 示例3
 * <p>
 * 输入
 * abc
 * abc
 * 5 3 2
 * 输出
 * 0
 * 备注:
 * 时间复杂度O(n∗m)，空间复杂度O(n)。(n,m代表两个字符串长度)
 *
 * @author: 小栗旬
 * @Date: 2019/10/24 16:42
 */
public class CodeInterviewGuide43 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        int ic = scanner.nextInt();
        int dc = scanner.nextInt();
        int rc = scanner.nextInt();

        long totalCost;
        char[] chars1;
        char[] chars2;
        if (str1.length() > str2.length()) {
            chars1 = str2.toCharArray();
            chars2 = str1.toCharArray();
        } else {
            chars1 = str1.toCharArray();
            chars2 = str2.toCharArray();
            int temp = ic;
            ic = dc;
            dc = temp;
        }
        int length1 = chars1.length;
        int length2 = chars2.length;
        long[] dp = new long[length1 + 1];
        for (int j = 1; j < length1 + 1; j++) {
            dp[j] = ic * j;
        }
        for (int i = 0; i < length2; i++) {
            long cost = dp[0];
            dp[0] = (i + 1) * dc;
            for (int j = 0; j < length1; j++) {
                long temp = dp[j + 1];
                if (chars1[j] == chars2[i]) {
                    dp[j + 1] = getMin(dp[j] + ic, dp[j + 1] + dc, cost);
                } else {
                    dp[j + 1] = getMin(dp[j] + ic, dp[j + 1] + dc, cost + rc);
                }
                cost = temp;
            }
        }
        totalCost = dp[length1];
        System.out.println(totalCost);
/*


srxhnghkxmssjxlyvrvnrnhkaqagucptyrfjczpfwnoylipweqvtzpaeulubpavspwkztbhyubmoalhn
fxlcrdsgrxxrajuxsanequmcmbkkmazuctiysvvwmnnckoeeonebwsjdnxhiyouvprmifsrhqoctwdshrpjkbexjuacrwkmppsngfdrjdviwyzanscalwcaeylrubbwwytjofubusyhrthunhktqzkzikoyhupwcssotukcpwdrhpqewpctrbsmivmiaiohmvpjzvakrcblldeoyivvwhldxliztabxmkbwlatoizxvvtfbdjgvtmmylrmieqhvbljoxixigwhmrmyndpholnoluvkdfnivfpfgbgigxswpnvsbehjcjrhovnptwxvykaqgwvtlfzpatqzotcklxhttikewezvwvzpsoqrzsauhsmwyylnjhlpyzxqkqjinodcwxodnqtcclhwtdjhuimgmtuckvsdxnfyuagzfbjmhcuzoycwsohsfonkiljvghgkbfszqrwipnbwselxczjudebklxuyvmvgekzjckdzatdwvbjmcozlqsyzpvclksbpvcdvfdrcvwxfohdapfkfalnihtlneuqcldbrohmtusojjvegecbtztvhhcumhybfwcrjgsdqcmtpwgdgfyiybszljadwebcawdnlpgaezatidepvwdqcpwkjftbknzvaxyxbqgokjqzfkxakvewmzvrpxrthckryrmymnwzllznjzohlolxlnirksvoyernhxlqppeiapzmcstatagkfoemthkjwtspdxmvzigqxqjlwxazdnsywszpeykcvablsypcmrzdetbhsynttjlarhboaefitjtemjyzcbqvaefjduhpbulrbrddvxprbxxcxiylsojvwagydbjfiabczfvdshlgsemsxlbnzhwpeygnhhrxzpevdhzveucvmihdqufhmangvfcwgkbwzhdlfdsvzebnilpgyhhdnsfbgkumoorwlqwhbkmbkgjfbztqbrnasblpzlifaqempanafonalqtnzrkqohhkvrbfefxldhfxjvsdxpcsntwshcnpazgqaetgcelbzlbeaerrvntshfdmxcirqibzlclfwuqofjlgthfxbqnvdrnguuffasgoarsvlnvhvnoqmoubjxeaurqefoywdbhkvbckalavglbjonskhdgozvgbkoutvhoswlpldgtqdfdsemzglaiwkimeksipmibrovyzkqtjwzbfiqiddhozoxiuuckrsjrogbapkxehwlhdzcaakuzlmucgorcuuepjttlwczfkdcfmuukwnpzzqkhqabupayhbrjptbnqyokcsbtldmospdltrybrmcutcglypxhlwkegmcladiplpbhtfestcbsoidjadqhnvgptlqoknsngozqdwpsafeesnfhtnonezkzujiuobawnzgchtsrpbncxxnfbwppcicmrpxdhczjvgmhwjsxdtdeynngysvesncqzzsxlvxeunudwpoqoqjjkqjgmdfhziehatljalzqwtinbqudaipekrzrpyukneegemwbrnmvuurpyoydzwxxouzpmapmcoznwdsmqsgjgjqwxxqqsgcjukbugjyvojafutsxtjihldddgydzqlnscurzbeqrvwoimlqsjyfkjxbuezaqonzcunzbdfhqgtrplhpbyepuicpxwrqzplffcgfutxtoirjondsrpfjedhjeclnkxujnebgjlcszpktyiqbxktfmsjypwabnkhfbayrchnhjjdevfindhxuuqaxduzntihgbuejlrpwnrstesgmalejqtnwskwgwhihoyneiemxdlaudylnuceqalquguyoxalunmyunboxjvknxjsbtnjistfxxcwwjwqicsskecohtgvyuhwalgyrihrqxwjtcudsxvwjrbintmufkhnvsrlwyprwaevsokpckqdgvqzmxbjcxpmlkvtuvklhaimzxmbtlxqrwikhfojvngvqhawqfwxorxekflqwdqpynsocemtaskfsdkoiifgjjmtqfzlheavdloclzykjyhexjfnkscebdvqmmiczhrqkeybfedinamrkzanwnhwjfikhwbjcwhkpqmgqomjvodtliivexfvqrghxegbjoqcqcrkmxkdiaanibxykqiiohxgrcykphpxxxlntxawqicaqctyjdmaptjplcvfurvocjusyibtywaghjeaesgqcnmeamlxnzksydtkrunkkujqatxaakunwldzvipkuhmnmjxefaguicvxicpsxfdfqqtgsxlugwrzvbwfvouyygmyhdmgeczvwoceedgweuywhpqoczuplnsymcimlyorzoslzxsupwddsxbuqgjyvpzgiahtczbrusxycehldukinrjkldbkgrplczgrfayebbsmyieceikzdtclvomidmeqehhqbhfxiwarlrbbcceqjmenknqxhluwwicukmdisbjpuvyufcgghopbwoahmldbzjyeweafkxdwoashhhmdthvuoiwjpyzqeislaxyfogcgxepkrxxczzkpvpujidwywcoslxawtimgwlhiulznhgfhahpdazmwtfouzqonuqmsgsfbbvwxjironjkmqsefpoifrovvgoxnjjhcwwovgbyhbffbofdyofedawbhzgxzlosfzasepiygqqawvgzqqamravqipasefpsmxrnrnmqubxygurkbjiojpprniihteqxiryfhydmnjufhwwdevmgsulctslmxtxsqedcnbgymimvwjiuvmgabetmabztcumridpqvdhkajtellhpomxgjmbrhqxtwbwiosyyaamtagkbzdwswibxthrtaslewwjcvtnkbshgxmbtlghmkfqgpjbjzymvkoustlmqfcejjmmivmhqmgwdkyovrgmqfdcvvhtdnnowxkpeosycczpqsnmjjyzxszhomluckdvtytufkpisdyzkmbkizljbslzwzedxhbqftanagbuyrsedariglqtqcilcfqngrmcdpretivxlpcozrzdrqqvolgufncsavvzrvpeunutolsylonzoejgekbswgtjlbylnurbcosdordyxdhkbqxthjcopofyxgrmppbpimdbedgpjptxxnaworwomujawxfeebhyisohxjsosmhlouipvmcshhwxdjbokuamwbobckruwlugwahkwspepupnlnmwrxbfhuqtynnceohpkizpxmtwrkwdefobavjfzdjfafvucuzgibcxenugjapnmsativmccbxlmogjeiytrlmdatdwtdvgzyhdfkknehoxablojhsuvfelhgrtvunkqijjbxtqwwxoxpaptyuxirrodvnrwozmgqczizbkzznavdsnexjardkuoifhmhgekpnkotaastiweqtsdlgpaovnpopkjyzwzudsjgqgyvzvtgqotyswjjubmepequewukigzcvycdbpyyyzlfvoracqjdhjgyyoyczmskhnriowrylsikhdohyorejuvtgviodzsfsqmmtztlepdiphcdvsdiiavuwhrdalvkklodjdtbvffqackuxwrudpkwftbptkyutnzyykrjfdrykeupcfnchkoppvawfmwtuwhqzfxmjdmounnfgyutulngxqdjevjmykjiiehcjsyhrbvdxryufopomqwvhabtwjyvwjsaajnxtbuczgfwelwwmxhlhlnpqrvtciyslljpwrljciysieujqwrseyhyauwxylrnshtgvcmdsehdqrheuviitmlvdxjshewzarkvdukmfeaysazybvsbypbhkkuszwbnmwmhfqlpmfushkcfqvqfawivfkpxbvbkomflqhhimnrkplbsqtjpwsfytikuqaafulpqedzdeililynjfmrxupegdunodeezrhrlbnddemrnkovdpzidbwhyvwlvijmjkoramdppubauypnairwbfbgdikzbzzeowkviaxedbxgoazlrejzkjtoclundiahqohwaleqjqsxklaqhlfssaiuravbzjmhwszgtmsfcwpfxvwmyiyowgsksytumsaklwpmioveabefsbunvkynwinutsryrcepshbqejftazclfkwaegwxhzzwqevfpuoqigdaekepxisjtcqjkccvgdqnuogijxxzchbfysjwikwinlcztwfpehizfdsxdrfxtjvkjdfkobwcikceafebwiogicxmuovupdhbeckmqzmutgwmqkvavcibfkwmwpqcjdbxkk
16 29 28
* */


    }

    private static long getMin(long num1, long num2, long num3) {
        if (num1 <= num2 && num1 <= num3) {
            return num1;
        } else if (num2 <= num1 && num2 <= num3) {
            return num2;
        }
        return num3;
    }
}
