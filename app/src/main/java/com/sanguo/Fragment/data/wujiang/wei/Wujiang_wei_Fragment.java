package com.sanguo.Fragment.data.wujiang.wei;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.sanguo.Fragment.data.wujiang.Wujiang_xiangxi;
import com.sanguo.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by jinrong on 2016/4/19.
 */
public class Wujiang_wei_Fragment extends Fragment {
    private ListView mWei_lv;
    private List<Map<String, Object>> wei_list_data;
    private Map<String, Object> caocao;
    private Map<String, Object> caopi;
    private Map<String, Object> caorui;
    private Map<String, Object> caofang;
    private Map<String, Object> caomao;
    private Map<String, Object> caoang;
    private Map<String, Object> caozhang;
    private Map<String, Object> caozhi;
    private Map<String, Object> caochong;
    private Map<String, Object> caoxiong;
    private Map<String, Object> xiahoudun;
    private Map<String, Object> xiahouyuan;
    private Map<String, Object> caoren;
    private Map<String, Object> caohong;
    private Map<String, Object> caochun;
    private Map<String, Object> caoxiu;
    private Map<String, Object> caohuan;
    private Map<String, Object> caozhen;
    private Map<String, Object> caoshuang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wei_fragment, null);
        return view;
    }

    @Override
    public void onViewCreated(View view, final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Toast.makeText(getContext(),"wei",Toast.LENGTH_SHORT).show();

        caocao = new HashMap<String, Object>();
        caocao.put("name", "曹      操");
        caocao.put("biaozi", "字    孟德");
        caocao.put("zhaopian", R.mipmap.caocao);
        caocao.put("shengri", "155年－220年3月15日");
        caocao.put("zuji", "沛国谯县（今安徽亳州）人");
        caocao.put("zhiwei", "魏武帝，庙号太祖");
        caocao.put("jianjie", "\t\t东汉末年杰出的政治家、军事家、文学家、书法家，三国中曹魏政权的奠基人。\n\t\t东汉末年，天下大乱，曹操以汉天子的名义征讨四方，对内消灭二袁、吕布、刘表、马超、韩遂等割据势力，对外降服南匈奴、乌桓、鲜卑等，统一了中国北方，并实行一系列政策恢复经济生产和社会秩序，奠定了曹魏立国的基础。曹操在世时，担任东汉丞相，后为魏王，去世后谥号为武王。\n\t\t曹操精兵法，善诗歌，抒发自己的政治抱负，并反映汉末人民的苦难生活，气魄雄伟，慷慨悲凉；散文亦清峻整洁，开启并繁荣了建安文学，给后人留下了宝贵的精神财富，史称建安风骨，鲁迅评价其为“改造文章的祖师”。同时曹操也擅长书法，尤工章草，唐朝张怀瓘在《书断》中评其为“妙品”。");

        caopi = new HashMap<String, Object>();
        caopi.put("name", "曹      丕");
        caopi.put("biaozi", "字    子桓");
        caopi.put("zhaopian", R.mipmap.caopi);
        caopi.put("shengri", "187年冬－226年6月29日");
        caopi.put("zuji", "沛国谯县（今安徽亳州）人");
        caopi.put("zhiwei", "魏文帝，庙号高祖");
        caopi.put("jianjie", "\t\t三国时期著名的政治家、文学家，曹魏的开国皇帝，公元220－226年在位。魏武帝曹操与卞夫人的长子。曹丕文武双全，八岁能提笔为文，善骑射，好击剑，博览古今经传，通晓诸子百家学说。220年正月，曹操逝世，曹丕继任丞相、魏王。之后曹丕受禅登基，以魏代汉，结束了汉朝四百多年统治。\n\t\t魏文帝在位期间，平定边患。击退鲜卑，和匈奴、氐、羌等外夷修好，恢复汉朝在西域的设置。除军政以外，曹丕自幼好文学，于诗、赋、文学皆有成就，尤擅长于五言诗，与其父曹操和弟曹植，并称三曹，今存《魏文帝集》二卷。另外，曹丕著有《典论》，当中的《论文》是中国文学史上第一部有系统的文学批评专论作品。黄初七年（226年）五月病逝于洛阳，时年40岁。");

        caorui = new HashMap<String, Object>();
        caorui.put("name", "曹      叡");
        caorui.put("biaozi", "字    元仲");
        caorui.put("zhaopian", R.mipmap.caorui);
        caorui.put("shengri", "204年－239年1月22日");
        caorui.put("zuji", "沛国谯县（今安徽亳州）人");
        caorui.put("zhiwei", "明皇帝,庙号烈祖");
        caorui.put("jianjie", "\t\t魏文帝曹丕长子，母文昭皇后甄氏，三国时期曹魏第二位皇帝，公元226年－239年在位。曹叡能诗文，与曹操、曹丕并称魏氏“三祖”，文学成就不及曹操、曹丕。原有集，已散佚，后人辑有其散文二卷、乐府诗十余首。\n\t\t曹叡二十三岁即位，在位期间指挥曹真、司马懿等人成功防御了吴、蜀的多次攻伐，并且平定鲜卑，攻灭公孙渊，颇有建树。然而统治后期，大兴土木，耽于享乐。景初二年（238年），曹叡病逝于洛阳，时年36岁，庙号烈祖，谥号明皇帝，葬于高平陵。因其临终前托孤不当，导致后来朝政动荡。");

        caofang = new HashMap<String, Object>();
        caofang.put("name", "曹      芳");
        caofang.put("biaozi", "字    兰卿");
        caofang.put("zhaopian", R.mipmap.caofang);
        caofang.put("shengri", "232年－274年");
        caofang.put("zuji", "沛国谯县（今安徽亳州）人");
        caofang.put("zhiwei", "曹魏第三位皇帝，齐王");
        caofang.put("jianjie", "\t\t魏明帝曹叡养子，三国时期曹魏第三位皇帝，239年—254年在位。\n\t\t曹芳于235年被封为齐王，239年曹叡病逝后继立为帝。254年，司马师将曹芳废为齐王，改立高贵乡公曹髦为帝。司马炎代魏称帝后，改封曹芳为邵陵县公。274年，曹芳病逝，时年四十三岁，谥号为厉公。");

        caomao = new HashMap<String, Object>();
        caomao.put("name", "曹      髦");
        caomao.put("biaozi", "字    彦士");
        caomao.put("zhaopian", R.mipmap.caomao);
        caomao.put("shengri", "241年11月15日－260年6月2日");
        caomao.put("zuji", "沛国谯县（今安徽亳州）人");
        caomao.put("zhiwei", "曹魏第四位皇帝");
        caomao.put("jianjie", "\t\t魏文帝曹丕之孙，东海定王曹霖之子，公元254－260年在位。\n\t\t曹髦即位前为高贵乡公，司马师废齐王曹芳后，身为宗室的曹髦被立为新君，但曹髦对司马氏兄弟的专横跋扈十分不满，于公元260年召见王经等人，对他们说“司马昭之心，路人所知也”，带领冗从仆射李昭、黄门从官焦伯等，授予铠甲兵器，率领僮仆数百余人讨伐，然而此次行动却被司马昭知晓，在司马昭心腹贾充的指使下，曹髦被武士成济所弑，年仅20岁。");

        caohuan = new HashMap<String, Object>();
        caohuan.put("name", "曹      奂");
        caohuan.put("biaozi", "字    景明");
        caohuan.put("zhaopian", R.mipmap.caohuan);
        caohuan.put("shengri", "246年－302年");
        caohuan.put("zuji", "沛国谯县（今安徽亳州）人");
        caohuan.put("zhiwei", "元皇帝");
        caohuan.put("jianjie", "\t\t魏武帝曹操之孙，燕王曹宇之子，三国时期魏国最后一位皇帝，260年－265年在位。甘露三年（258年），封常道乡公。\n\t\t甘露五年（260年），魏帝高贵乡公曹髦被成济弑杀，司马昭与众臣商议，立曹奂为帝，奉魏明帝曹叡之祀。曹奂虽名为皇帝，但实为司马氏的傀儡。咸熙二年（265年），司马昭死后，其子司马炎嗣位晋王，篡夺魏国政权，魏国灭亡，曹奂被降封为陈留王。太安元年（302年），曹奂逝世，享年五十八岁，谥号为元皇帝。");

        caoang = new HashMap<String,Object>();
        caoang.put("name","曹      昂");
        caoang.put("biaozi","字    子修");
        caoang.put("zhaopian",R.mipmap.caoang);
        caoang.put("shengri","不详－197年");
        caoang.put("zuji","沛国谯县（今安徽亳州）人");
        caoang.put("zhiwei","愍王");
        caoang.put("jianjie","\t\t曹操的长子，刘氏所生，但生母早亡是以由正室丁氏抚养大。聪明且性情谦和，为曹操所喜爱，二十岁时即举孝廉。\n\t\t建安二年（197年）年随曹操出征张绣，因张绣突然袭击，曹昂为救曹操负责断後，与大将典韦一同战死於宛城。\n\t\t魏文帝黄初二年（221年），追封谥号丰悼公，黄初五年（224年）又进一步追封为丰悼王。太和三年（229年）年改谥号称愍王。");

        caozhang = new HashMap<String,Object>();
        caozhang.put("name","曹      彰");
        caozhang.put("biaozi","字    子文");
        caozhang.put("zhaopian",R.mipmap.caozhang);
        caozhang.put("shengri","不详－223年");
        caozhang.put("zuji","沛国谯县（今安徽亳州）人");
        caozhang.put("zhiwei","任城威王");
        caozhang.put("jianjie","\t\t魏武帝曹操与武宣卞皇后所生第二子，魏文帝曹丕之弟，曹植之兄。\n\t\t曹彰武艺过人，曹操问诸子志向时自言“好为将”，因此得到曹操的赞赏。其胡须黄色，被曹操称为“黄须儿”。弱冠前喜搏猛虎，臂力过人、不善文章。\n\t\t216年，封鄢陵侯。218年，曹彰受封为北中郎将，行骁骑将军征讨乌桓，又降服辽东鲜卑大人轲比能。后来曹操去世，曹丕即位，曹彰与诸侯就国。\n\t\t221年进爵为公。次年被封为任城王。223年，到洛阳朝见，患病薨于府邸，死后谥号为威，故亦称为任城威王。");

        caozhi = new HashMap<String,Object>();
        caozhi.put("name","曹      植");
        caozhi.put("biaozi","字    子建");
        caozhi.put("zhaopian",R.mipmap.caozhi);
        caozhi.put("shengri","192年－232年12月27日");
        caozhi.put("zuji","沛国谯县（今安徽亳州）人");
        caozhi.put("zhiwei","陈思王");
        caozhi.put("jianjie","\t\t出生于山东聊城市莘县，一说出生于山东菏泽市鄄城。曹植是曹操与武宣卞皇后所生第三子，生前曾为陈王，去世后谥号“思”，因此又称陈思王。\n\t\t曹植是三国时期曹魏著名文学家，建安文学的代表人物。其代表作有《洛神赋》、《白马篇》《七哀诗》等。后人因其文学上的造诣而将他与曹操、曹丕合称为“三曹”。其诗以笔力雄健和词采画眉见长，留有集三十卷，已佚，今存《曹子建集》为宋人所编。\n\t\t曹植的散文同样也具有“情兼雅怨，体被文质”的特色，加上其品种的丰富多样，使他在这方面也取得了卓越的成就。\n\t\t南朝宋文学家谢灵运有“天下才有一石，曹子建独占八斗”的评价。《诗品》的作者钟嵘亦赞曹植“骨气奇高，词彩华茂，情兼雅怨，体被文质，粲溢今古，卓尔不群。”王士祯尝论汉魏以来二千年间诗家堪称“仙才”者，曹植、李白、苏轼三人耳。");

        caochong = new HashMap<String,Object>();
        caochong.put("name","曹      冲");
        caochong.put("biaozi","字    仓舒");
        caochong.put("zhaopian",R.mipmap.caochong);
        caochong.put("shengri","196年－208年5月甲戌");
        caochong.put("zuji","沛国谯县（今安徽亳州）人");
        caochong.put("zhiwei","邓哀王");
        caochong.put("jianjie","\t\t曹操和环夫人之子。从小聪明仁爱，与众不同，深受曹操喜爱。留有“曹冲称象”的典故。曹操几次对群臣夸耀他，有让他继嗣之意。\n\t\t曹冲还未成年就病逝，年仅十三岁。曹冲夭折后，曹操每当看见周不疑的时候就想起曹冲来，心突已，于是命人暗杀之， 曹丕为其求情。曹冲心地仁爱，识见通达，都像这件事情所表现的那样，本应犯罪被杀，却被曹冲暗中分辩事理而得到帮助宽宥的，前后有几十人。");

        caoxiong = new HashMap<String,Object>();
        caoxiong.put("name","曹      熊");
        caoxiong.put("biaozi","无        字");
        caoxiong.put("zhaopian",R.mipmap.caoxiong);
        caoxiong.put("shengri","不详");
        caoxiong.put("zuji","沛国谯县（今安徽亳州）人");
        caoxiong.put("zhiwei","萧怀王");
        caoxiong.put("jianjie","\t\t曹操之子，与曹丕、曹彰、曹植同为卞氏所生，体弱多病。曹操去世后，因其未能到邺参加丧礼，曹丕为此遣兵捉拿曹熊，曹熊惧罪，自缢而死，被厚葬，追谥萧怀王。\n\t\t曹熊儿子曹炳继嗣，几年后去世，没有留下后代，国家因此取消了此爵位。魏萧怀王。文帝同母弟也，体弱多病。\n\t\t太祖薨，熊未奔丧，文帝兴兵问罪。熊惧罪，自缢而死，文帝厚葬之，追谥萧怀王。早薨。文帝践祚，黄初二年追封谥萧怀公。太和三年，又追封爵为王。青龙二年，子哀王炳嗣，食邑二千五百户。六年薨，无子，国除。");

        xiahoudun = new HashMap<String,Object>();
        xiahoudun.put("name","夏 侯 惇");
        xiahoudun.put("biaozi","字    元让");
        xiahoudun.put("zhaopian",R.mipmap.xiahoudun);
        xiahoudun.put("shengri","不详－220年");
        xiahoudun.put("zuji","沛国谯县（今安徽亳州）人");
        xiahoudun.put("zhiwei","忠侯");
        xiahoudun.put("jianjie","\t\t曹魏开国元勋，西汉开国元勋夏侯婴的后代。少年时以勇气闻名于乡里。曹操起兵，夏侯惇是其最早的将领之一。多次为曹操镇守后方，曾率军民阻断太寿河水，筑陂塘灌溉农田，使百姓受益，功勋卓著。\n\t\t历任折冲校尉、济阴太守、建武将军，官至大将军，封高安乡侯，追谥忠侯。夏侯惇一生虽多在军旅，但仍不忘治学。他常亲自迎师，虚心求教。\n\t\t他为人俭朴，所得赏赐全部分给将士。一生不置产业，至死家无余财。");

        xiahouyuan = new HashMap<String,Object>();
        xiahouyuan.put("name","夏 侯 渊");
        xiahouyuan.put("biaozi","字    妙才");
        xiahouyuan.put("zhaopian",R.mipmap.xiahouyuan);
        xiahouyuan.put("shengri","不详－219年");
        xiahouyuan.put("zuji","沛国谯县（今安徽亳州）人");
        xiahouyuan.put("zhiwei","愍侯");
        xiahouyuan.put("jianjie","\t\t东汉末年名将，擅长千里奔袭作战，官至征西将军，封博昌亭侯。\n\t\t初期随曹操征伐，官渡之战为曹操督运粮草，又督诸将先后平定昌豨、徐和、雷绪、商曜等叛乱。后率军驻凉州，逐马超、破韩遂、灭宋建、横扫羌、氐，虎步关右。\n\t\t张鲁降曹操后夏侯渊留守汉中，与刘备相拒逾年，于定军山被刘备部将黄忠所袭，战死，谥曰愍侯。");

        caoren = new HashMap<String,Object>();
        caoren.put("name","曹      仁");
        caoren.put("biaozi","字    子孝");
        caoren.put("zhaopian",R.mipmap.caoren);
        caoren.put("shengri","168年－223年");
        caoren.put("zuji","沛国谯县（今安徽亳州）人");
        caoren.put("zhiwei","忠侯");
        caoren.put("jianjie","\t\t曹仁好弓马骑射，少时不修行检，及至长成为大将，则变得严整，奉法守令。从曹操多年，为魏朝立下汗马功劳。破袁术，曹仁所斩获颇多，大破陶谦军及陶谦部将吕由，攻克句阳，生擒吕布的部将刘何，官渡之战中，在隐强打败刘备军、鸡落山之战又战胜袁绍军。\n\t\t赤壁之战兵败后，曹仁镇守江陵与周瑜拖了一年之久，为曹操重整旗鼓赢得了宝贵的时间，渭南破马超，破反将苏伯、田银、侯音，襄樊之战中挡住了关羽的进攻，与徐晃共攻破陈邵，进军襄阳，魏国建立后曹仁拜车骑将军，统率荆州、扬州、益州军事，晋封陈侯，曹丕代汉建魏，封曹仁为大将军，又迁大司马，不久卒于军中，时年五十六岁，谥曰忠侯。");

        caohong = new HashMap<String,Object>();
        caohong.put("name","曹      洪");
        caohong.put("biaozi","字    子廉");
        caohong.put("zhaopian",R.mipmap.caohong);
        caohong.put("shengri","不详－232年");
        caohong.put("zuji","沛国谯县（今安徽亳州）人");
        caohong.put("zhiwei","恭侯");
        caohong.put("jianjie","\t\t曹操从弟。曹操追袭董卓荥阳为徐荣所败失马，曹洪舍命献马并救护曹操，使曹操免于厄难。\n\t\t后多随军征伐，平兖州、征刘表、讨祝臂。官渡之战时曹操令其驻守本阵。汉中之战时，曹洪与曹休在下辩抵御刘备大军，破斩吴兰、任夔，逼退张飞与马超。\n\t\t曹丕即位时封曹洪为骠骑将军，后因私事寻衅欲处死曹洪，因卞太后求情免死，贬为庶民，曹叡即位，拜曹洪为后将军，更封乐城侯，后复拜为骠骑将军。曹洪逝世，追谥曰恭侯。");

        caochun = new HashMap<String,Object>();
        caochun.put("name","曹      纯");
        caochun.put("biaozi","字    子和");
        caochun.put("zhaopian",R.mipmap.caochun);
        caochun.put("shengri","170年－210年");
        caochun.put("zuji","沛国谯县（今安徽亳州）人");
        caochun.put("zhiwei", "威侯");
        caochun.put("jianjie","\t\t东汉末年曹操麾下将领，曹仁之弟。曹纯是曹操部下精锐部队“虎豹骑”的统领者之一，因在平定北方的战役中颇有功绩，被加封为高陵亭侯。死后谥曰威侯。\n\t\t曹纯擅战，甚得人心，为人重纲纪，不失理智，好学问，敬爱学士，闻名天下。");

        caoxiu = new HashMap<String,Object>();
        caoxiu.put("name","曹      休");
        caoxiu.put("biaozi","字    文烈");
        caoxiu.put("zhaopian",R.mipmap.caoxiu);
        caoxiu.put("shengri","不详－228年");
        caoxiu.put("zuji","沛国谯县（今安徽亳州）人");
        caoxiu.put("zhiwei", "壮侯");
        caoxiu.put("jianjie","\t\t三国曹魏将领，曹操族子。官至大司马，封长平侯。于曹操起兵讨伐董卓时前往投奔，曹操称赞其为“千里驹”，如同亲子般看待，并使他领虎豹骑宿卫。\n\t\t汉中之战中，识破张飞计谋，大败吴兰。曹魏建立后，镇守曹魏东线，多次击破吴军，诱降吴将。公元228年，曹休在魏吴石亭之战中大败，不久因背上毒疮发作而去世。");

        caozhen = new HashMap<String,Object>();
        caozhen.put("name","曹      真");
        caozhen.put("biaozi","字    子丹");
        caozhen.put("zhaopian",R.mipmap.caozhen);
        caozhen.put("shengri","不详－231年");
        caozhen.put("zuji","沛国谯县（今安徽亳州）人");
        caozhen.put("zhiwei", "元侯");
        caozhen.put("jianjie","\t\t曹操族子。三国时期曹魏名将，官至大将军、大司马。其父为曹操招募人马时被州郡所杀，曹操因怜悯曹真少年丧父而待其如亲子一般，因赞赏曹真的勇猛而让他率领虎豹骑。\n\t\t曹真在镇守曹魏西北边境时表现突出，魏文帝时期督众将大破羌胡联军，平定河西；魏明帝时期屡次对抗诸葛亮的北伐。231年病逝，谥曰元侯。");

        caoshuang = new HashMap<String,Object>();
        caoshuang.put("name","曹      爽");
        caoshuang.put("biaozi","字    昭伯");
        caoshuang.put("zhaopian",R.mipmap.caoshuang);
        caoshuang.put("shengri","不详－249年");
        caoshuang.put("zuji","沛国谯县（今安徽亳州）人");
        caoshuang.put("zhiwei", "大将军");
        caoshuang.put("jianjie","\t\t三国时期曹魏宗室、权臣，大司马曹真之子。自少以宗室身份出入宫中，谨慎持重。\n\t\t曹叡即位后，即任他为散骑侍郎，累迁城门校尉，加散骑常侍，转任武卫将军；曹叡卧病时，拜曹爽为大将军，假节钺；齐王曹芳即位后，曹爽又被加为侍中，改封武安侯。\n\t\t曹爽原本谦虚谨慎，后来任用私人，专权乱政，侵吞财产，一意孤行出兵伐蜀造成国内虚耗死伤惨重，起居自比皇帝。\n\t\t249年，司马懿发动高平陵之变后，因谋反之罪，在朝议后被诛族。");

        wei_list_data = new ArrayList<Map<String, Object>>();
        wei_list_data.add(caocao);
        wei_list_data.add(caopi);
        wei_list_data.add(caorui);
        wei_list_data.add(caofang);
        wei_list_data.add(caomao);
        wei_list_data.add(caohuan);
        wei_list_data.add(caoang);
        wei_list_data.add(caozhang);
        wei_list_data.add(caozhi);
        wei_list_data.add(caochong);
        wei_list_data.add(caoxiong);
        wei_list_data.add(xiahoudun);
        wei_list_data.add(xiahouyuan);
        wei_list_data.add(caoren);
        wei_list_data.add(caohong);
        wei_list_data.add(caochun);
        wei_list_data.add(caoxiu);
        wei_list_data.add(caozhen);
        wei_list_data.add(caoshuang);

        final List<Map<String, Object>> listItems = new ArrayList<Map<String, Object>>();

        for (Iterator iter = wei_list_data.iterator(); iter.hasNext(); ) {
            Map<String, Object> map = (HashMap<String, Object>) iter.next();
            listItems.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), listItems, R.layout.listview_styl,
                new String[]{"name", "biaozi", "zhaopian"},
                new int[]{R.id.wei_lv_names, R.id.wei_lv_biaozi, R.id.wei_lv_image});

        mWei_lv = (ListView) view.findViewById(R.id.wei_lv);

        mWei_lv.setAdapter(simpleAdapter);

        mWei_lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Bundle bundle = new Bundle();

                ArrayList bundlelist = new ArrayList();

                bundlelist.add(wei_list_data.get(position));

                bundle.putParcelableArrayList("list", bundlelist);

                //Toast.makeText(getContext(), bundle + "被点击了" + position, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getActivity(), Wujiang_xiangxi.class);

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}