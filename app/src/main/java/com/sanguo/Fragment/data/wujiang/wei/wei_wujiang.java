package com.sanguo.Fragment.data.wujiang.wei;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sanguo.R;

import java.util.List;
import java.util.Map;


/**
 * Created by jinrong on 2016/4/20.
 */
public class wei_wujiang extends Fragment{
    private static String mName;
    private static String mBiaozi = "无字";
    private static String mShengri = "暂无详情";
    private static String mZuji = null;
    private static String mZhiwei = null;
    private static String mJianjie;
    private static int mZhaopian;
    private static List<Map<String, Object>> wei_list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wei_fragment, null);
        return view;
    }

        public static String[] wei_names = new String[]{
                "夏侯玄", "夏侯恩", "夏侯和", "夏侯惠", "夏侯德", "夏侯咸", "夏侯楙", "曹训",
                "荀攸", "荀彧", "程昱", "郭嘉", "郭弈", "贾诩", "满宠", "戏志才", "钟繇", "华歆", "陈群", "司马孚",
                "司马望", "吕虔",
                "典韦", "许褚", "于禁", "乐进", "李典", "徐晃", "张郃", "庞德","张辽",

                "羊祜", "邓艾", "陈泰", "郭淮", "杜预", "郝昭", "贾逵",
                "王濬", "陈登", "王基", "诸葛诞", "田豫",
                "马隆", "刘劭", "胡烈", "钟会",
                "王浑", "王昶", "王凌", "田畴", "夏侯尚",
                "费耀", "司马攸", "杨阜", "卫瓘", "孙礼", "何桢", "州泰", "蒋济",
                "张特", "阎柔", "张既", "邓忠", "文鸳", "王颀", "王经", "胡遵", "高柔",
                "荀愷", "毋丘俭", "辛毗", "张绣", "刘晔", "朱灵", "毋丘甸",
                "李通", "王修", "夏侯威", "杨欣", "陈俊", "李丰", "胡奋",
                "陈骞", "张乔", "胡质",
                "毛阶", "唐彬", "文钦", "杨秋", "臧霸", "程武", "陈矫", "蒋班", "贾充",
                "石苞", "牛金", "周浚", "张虎", "戴陵", "崔琰",
                "庞会", "张南", "唐咨", "卞喜", "王朗", "徐邈", "李辅", "胡班",
                "毕轨", "申仪", "王肃", "句安", "乐琳", "师篡",
                "吴纲", "丘本", "董昭", "张球", "张缉", "焦彝",
                "丘建", "何曾", "文虎", "王祥", "刘寔", "辛敞", "王双",
                "毋丘秀", "党均", "车胄", "秦朗", "韩德", "司马朗", "何宴", "典满",
                "桓范", "钟毓", "杨修", "徐质", "田续", "马遵", "邵悌", "许仪",
                "傅巽", "裴秀", "丁谧", "王沈", "吴质", "丁仪", "曹宇", "王忠", "马钧", "蒋干",
                "李胜", "曹羲", "张节", "尹大目",  "韩浩"


        };
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

}
