package com.ff.todaytoutiao.bean;

import java.util.List;

/**
 * 时间: 2017/8/13
 * 类作用:
 */

public class MenuInfo {

    /**
     * reason : 成功的返回
     * result : {"stat":"1","data":[{"uniquekey":"a0dc94b1924b550b4b8b50c310c913c7",
     * "title":"地震\u201c闯祸\u201d 谁来给受损车辆买单？","date":"2017-08-13 13:43","category":"头条",
     * "author_name":"中国新闻周刊","url":"http://mini.eastday.com/mobile/170813134311149.html",
     * "thumbnail_pic_s":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_5_mwpm_03200403.jpg
     * "},{"uniquekey":"44c4ef314c96f2b4b34d39d7b14707ab","title":"四川乐山一女子质问继父对母亲家暴行为，当街被继父刺死",
     * "date":"2017-08-13 13:58","category":"头条","author_name":"四川在线","url":"http://mini.eastday
     * .com/mobile/170813135844319.html","thumbnail_pic_s":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813135844_a1fbcb0e63245608f8305f6b25ecedb0_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813135844_a1fbcb0e63245608f8305f6b25ecedb0_2_mwpm_03200403.jpg
     * "},{"uniquekey":"2543229bf82c8e9976322b7bb37efaaa","title":"山东家长\"起早贪黑\"排队为孩子入学报名",
     * "date":"2017-08-13 13:41","category":"头条","author_name":"视觉中国","url":"http://mini.eastday
     * .com/mobile/170813134109399.html","thumbnail_pic_s":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813134109_9ed1804ee4babf3905cf198abb1b0019_4_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813134109_9ed1804ee4babf3905cf198abb1b0019_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813134109_9ed1804ee4babf3905cf198abb1b0019_5_mwpm_03200403.jpg
     * "},{"uniquekey":"8e8680fa76b74a81d13553d2dc497c77","title":"两岸关系别指望美国：美或因此不再帮台湾",
     * "date":"2017-08-13 13:39","category":"头条","author_name":"中国台湾网","url":"http://mini.eastday
     * .com/mobile/170813133914150.html","thumbnail_pic_s":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813133914_fe9755969115a6ea05ba3902fe770161_1_mwpm_03200403.jpg
     * "},{"uniquekey":"bbcd8dd07fd1706d860db78ec34011b6","title":"印度此刻最紧张的非洞朗 而是中国这个度假胜地",
     * "date":"2017-08-13 13:35","category":"头条","author_name":"环球网","url":"http://mini.eastday
     * .com/mobile/170813133523877.html","thumbnail_pic_s":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813133523_9cc95a375bd040fba7075cac9f52d309_1_mwpm_03200403.jpg
     * "},{"uniquekey":"28b950f77fea29136c8269f1c0d366c9","title":"因为这个原因，印军对中国两座边境雷达站恨之如骨",
     * "date":"2017-08-13 13:21","category":"头条","author_name":"军事图书馆","url":"http://mini.eastday
     * .com/mobile/170813132142981.html","thumbnail_pic_s":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_3883516a0f19a1786f9c84d0ea70977e_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_ca61fdaa062aff1eef9f67451a34c578_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_68ed2ec711ed316b3d98112726525d85_cover_mwpm_03200403.jpeg"},
     * {"uniquekey":"4a461ec89be056ebf1cc377fc65240b8","title":"五大新疆最美女星，迪丽热巴只能排在第二？",
     * "date":"2017-08-13 13:15","category":"头条","author_name":"叶子娱乐","url":"http://mini.eastday
     * .com/mobile/170813131500345.html","thumbnail_pic_s":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813131500_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813131500_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813131500_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg
     * "},{"uniquekey":"5625e58d13854bf4113797285148ac9a","title":"未婚姑娘嫁给六旬老人，掀开盖头后全村都笑了！",
     * "date":"2017-08-13 12:59","category":"头条","author_name":"醉鱼","url":"http://mini.eastday
     * .com/mobile/170813125927243.html","thumbnail_pic_s":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813125927_a4e2d18b3eb20372b92558ba5d97c502_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813125927_a4e2d18b3eb20372b92558ba5d97c502_6_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813125927_a4e2d18b3eb20372b92558ba5d97c502_5_mwpm_03200403.jpg
     * "},{"uniquekey":"bb758b7bb627545dc1136e821702fb73","title":"伊拉克打了一场仗美国人击毁七百辆中国坦克，专家调查后笑了",
     * "date":"2017-08-13 12:56","category":"头条","author_name":"一号军情","url":"http://mini.eastday
     * .com/mobile/170813125631883.html","thumbnail_pic_s":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_acf17664913911917c6e85699c646517_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_baa0c4002b6b6c2f453d88a8e1fcbc96_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://06.imgmini.eastday
     * .com/mobile/20170813/20170813_b0f8a240e47132993fd26e3bd6979251_cover_mwpm_03200403.jpeg"},
     * {"uniquekey":"71395f58cfe8a1059c41046623667ed5","title":"原铁道部落马官员张曙光获减刑",
     * "date":"2017-08-13 12:55","category":"头条","author_name":"政事儿","url":"http://mini.eastday
     * .com/mobile/170813125518878.html","thumbnail_pic_s":"http://09.imgmini.eastday
     * .com/mobile/20170813/20170813125518_a018f1dfaaa9c82b3560743a92f29ce5_1_mwpm_03200403.jpg
     * "},{"uniquekey":"8c112ce1245f09f619c817e5c07490db","title":"监管部门:让各大富豪隐形资产\"见光死\"的政策来了",
     * "date":"2017-08-13 12:48","category":"头条","author_name":"侠客岛","url":"http://mini.eastday
     * .com/mobile/170813124824032.html","thumbnail_pic_s":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_1_mwpm_03200403.jpg
     * "},{"uniquekey":"93f92c80eabc20dfccca94740418de94","title":"刚刚，印度先出手！另一个大国也喊话中国：周一见！",
     * "date":"2017-08-13 12:38","category":"头条","author_name":"中金在线","url":"http://mini.eastday
     * .com/mobile/170813123850292.html","thumbnail_pic_s":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813123850_4bbadeb9d4c6120852288a07ff494517_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813123850_4bbadeb9d4c6120852288a07ff494517_4_mwpm_03200403.jpg
     * "},{"uniquekey":"92ba7bd4710ee7d140dd5ba31da58e45","title":"日军一度沦陷大半个中国，为何唯独看不上这个省？",
     * "date":"2017-08-13 12:38","category":"头条","author_name":"沔阳轶事","url":"http://mini.eastday
     * .com/mobile/170813123827619.html","thumbnail_pic_s":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123827_288126e86ad548f4f5d399a3c15700d7_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123827_288126e86ad548f4f5d399a3c15700d7_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123827_288126e86ad548f4f5d399a3c15700d7_3_mwpm_03200403.jpg
     * "},{"uniquekey":"9a349748188c685732a657f5e863fe93","title":"她是亚洲第一美臀","date":"2017-08-13
     * 12:37","category":"头条","author_name":"凤凰网","url":"http://mini.eastday
     * .com/mobile/170813123722077.html","thumbnail_pic_s":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123722_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123722_d41d8cd98f00b204e9800998ecf8427e_4_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123722_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg
     * "},{"uniquekey":"f968d18cd0e06cf59f8736b1d8b27908","title":"印度高官回应中印洞朗对峙:印度已完全做好准备",
     * "date":"2017-08-13 12:34","category":"头条","author_name":"海外网","url":"http://mini.eastday
     * .com/mobile/170813123437972.html","thumbnail_pic_s":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813123437_c498067d3e5ff3ed79f408c4a4c3cac0_1_mwpm_03200403.jpg
     * "},{"uniquekey":"2aac99d24a05c4a0510ab5577d0a9c4e",
     * "title":"印度女子游中国称不想走！回国后大骂印度媒体，称可恶的骗子！","date":"2017-08-13 12:31","category":"头条",
     * "author_name":"追求自由的步伐","url":"http://mini.eastday.com/mobile/170813123138423.html",
     * "thumbnail_pic_s":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813123138_36b71045f24945b8509ba021a95a21c0_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813123138_36b71045f24945b8509ba021a95a21c0_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813123138_36b71045f24945b8509ba021a95a21c0_3_mwpm_03200403.jpg
     * "},{"uniquekey":"c09c1a1c124a42dc90f7ed87f561fefd","title":"跟中国反复叫板的印度，经济实力究竟几何？",
     * "date":"2017-08-13 12:31","category":"头条","author_name":"中新经纬","url":"http://mini.eastday
     * .com/mobile/170813123102133.html","thumbnail_pic_s":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123102_3c553926428c0da92a22ecdf05e6eb9b_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123102_3c553926428c0da92a22ecdf05e6eb9b_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813123102_3c553926428c0da92a22ecdf05e6eb9b_5_mwpm_03200403.jpg
     * "},{"uniquekey":"18c48f377ad77c0fc7acfcba6ee4148a",
     * "title":"6GB手机集体\u201c降价\u201d跳水，2499降到1799","date":"2017-08-13 12:30","category":"头条",
     * "author_name":"玩机喵","url":"http://mini.eastday.com/mobile/170813123040339.html",
     * "thumbnail_pic_s":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123040_681661e43a0e0cb36330849dbe1e7d37_6_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123040_681661e43a0e0cb36330849dbe1e7d37_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://07.imgmini.eastday
     * .com/mobile/20170813/20170813123040_681661e43a0e0cb36330849dbe1e7d37_4_mwpm_03200403.jpg
     * "},{"uniquekey":"01c8366270410bc490656fc96a8ff35c","title":"美国或对华发起贸易调查，单边主义贸易策略遭遇多方质疑",
     * "date":"2017-08-13 12:17","category":"头条","author_name":"新华网","url":"http://mini.eastday
     * .com/mobile/170813121754728.html","thumbnail_pic_s":"http://09.imgmini.eastday
     * .com/mobile/20170813/20170813121754_55fd468170bcd2db22e6f2150120f53b_1_mwpm_03200403.jpg
     * "},{"uniquekey":"91c4a0851cff6770dde10dad6a8f0437","title":"福岛地震核泄漏七年过去了，看看生物都产生了哪些变异！",
     * "date":"2017-08-13 12:14","category":"头条","author_name":"笑解千千愁","url":"http://mini.eastday
     * .com/mobile/170813121445290.html","thumbnail_pic_s":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813121445_a20b303d0acdbc905833f6b854acafec_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813121445_a20b303d0acdbc905833f6b854acafec_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://03.imgmini.eastday
     * .com/mobile/20170813/20170813121445_a20b303d0acdbc905833f6b854acafec_1_mwpm_03200403.jpg
     * "},{"uniquekey":"613736f45e7f55cbcfc4ea59712d916e",
     * "title":"司机与人方便雨中让孕妇搭车，谁知孕妇遗落的雨伞竟救了司机一命","date":"2017-08-13 12:11","category":"头条",
     * "author_name":"二页书","url":"http://mini.eastday.com/mobile/170813121111127.html",
     * "thumbnail_pic_s":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://05.imgmini.eastday
     * .com/mobile/20170813/20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_3_mwpm_03200403.jpg
     * "},{"uniquekey":"5299fa13389cb570f7ecd2af78e51216","title":"纽约华人为九寨沟地震灾民慷慨解囊(图）",
     * "date":"2017-08-13 12:06","category":"头条","author_name":"侨报网","url":"http://mini.eastday
     * .com/mobile/170813120622386.html","thumbnail_pic_s":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813120622_1b6a38c360f457707c6633f03f2a3fb5_1_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813120622_1b6a38c360f457707c6633f03f2a3fb5_2_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813120622_1b6a38c360f457707c6633f03f2a3fb5_3_mwpm_03200403.jpg
     * "},{"uniquekey":"b4dc5a28f4693a1655473489fa71caaa","title":"印度曾出兵50万差点灭国巴铁，中国警告：做好炮击准备",
     * "date":"2017-08-13 12:06","category":"头条","author_name":"兵器次元","url":"http://mini.eastday
     * .com/mobile/170813120621600.html","thumbnail_pic_s":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_09498150bc1805602c01be8f518ef131_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_38289073c2b250ae11bdfe2539b8e7f6_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_1cb9039fe1cc403e8b15bbeac28cf215_cover_mwpm_03200403.jpeg"},
     * {"uniquekey":"7ff2dcd6c8912df7a131f8d3696e046b",
     * "title":"12号台风\u201c榕树\u201d生成！浙江高温天卷土重来？","date":"2017-08-13 12:05","category":"头条",
     * "author_name":"浙江在线","url":"http://mini.eastday.com/mobile/170813120523336.html",
     * "thumbnail_pic_s":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813120523_802c4503c034e78c6f9f0e57d399b383_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://01.imgmini.eastday
     * .com/mobile/20170813/20170813120523_802c4503c034e78c6f9f0e57d399b383_2_mwpm_03200403.jpg
     * "},{"uniquekey":"cf6e1aaa00123f65790194661e876c3e",
     * "title":"中国两个地方，一年可以消灭3亿只兔子和1亿只鸭子，你知道吗！","date":"2017-08-13 12:03","category":"头条",
     * "author_name":"南山美食家","url":"http://mini.eastday.com/mobile/170813120333551.html",
     * "thumbnail_pic_s":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813120333_96ef924038c7fc6d123b32f3707751cd_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813120333_96ef924038c7fc6d123b32f3707751cd_4_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813120333_96ef924038c7fc6d123b32f3707751cd_1_mwpm_03200403.jpg
     * "},{"uniquekey":"41f076dfa2787797b95eefa1823dc058","title":"俄战机锁定中国 印紧随其后 美最担心的事发生了！",
     * "date":"2017-08-13 11:57","category":"头条","author_name":"张殿成军情观察","url":"http://mini
     * .eastday.com/mobile/170813115746108.html","thumbnail_pic_s":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813_6251646336bbc7a7a3710cc86352a837_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813_6478adcfb1175353f8f19e29aac54fd0_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://02.imgmini.eastday
     * .com/mobile/20170813/20170813_289a2c4063eb57690a82d60589b20639_cover_mwpm_03200403.jpeg"},
     * {"uniquekey":"a343166aaeea56b3e26f015a78a7fa75","title":"农村住房建设管理政策重大调整，你家建的房子符合新规定吗？",
     * "date":"2017-08-13 11:40","category":"头条","author_name":"钱钱名站","url":"http://mini.eastday
     * .com/mobile/170813114007231.html","thumbnail_pic_s":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813114007_493303148f5206b216578f57ce949dca_4_mwpm_03200403.jpg",
     * "thumbnail_pic_s02":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813114007_493303148f5206b216578f57ce949dca_3_mwpm_03200403.jpg",
     * "thumbnail_pic_s03":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813114007_493303148f5206b216578f57ce949dca_2_mwpm_03200403.jpg
     * "},{"uniquekey":"508f4e457c11020b16a50b233dbce2cb","title":"广东河源市东源县发生3.0级地震 震源深度11千米",
     * "date":"2017-08-13 11:37","category":"头条","author_name":"中国新闻网","url":"http://mini.eastday
     * .com/mobile/170813113718031.html","thumbnail_pic_s":"http://00.imgmini.eastday
     * .com/mobile/20170813/20170813113718_0152fa0426f09ef6050ab8def6cb27a8_1_mwpm_03200403.jpg
     * "},{"uniquekey":"f1ca21c69d4a3c7a7b86dd5fccd17049","title":"八月还债九月发，三大生肖时来运转，伸手就能接到财",
     * "date":"2017-08-13 11:19","category":"头条","author_name":"心理测试读心术","url":"http://mini
     * .eastday.com/mobile/170813111921644.html","thumbnail_pic_s":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813_304cb1dfdcd1a757c97f282166a3e3a4_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813_2ac43169356504f74061d6a3cd2c8efb_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://08.imgmini.eastday
     * .com/mobile/20170813/20170813_92714529a354a835f37ed0b7fb979d90_cover_mwpm_03200403.jpeg"},
     * {"uniquekey":"7398f8d6329e720b72c79833648fab2c","title":"男子婚前突然一病不起, 医院那头得知真相女友整个人都崩溃了",
     * "date":"2017-08-13 11:17","category":"头条","author_name":"城事儿","url":"http://mini.eastday
     * .com/mobile/170813111754296.html","thumbnail_pic_s":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_ca42d7dca610922a2782bde7082455e2_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s02":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_71aa8a6fa82570d133c7fadc05bb5b01_cover_mwpm_03200403.jpeg",
     * "thumbnail_pic_s03":"http://04.imgmini.eastday
     * .com/mobile/20170813/20170813_e24c45b95203b1845b54f41b499969be_cover_mwpm_03200403.jpeg"}]}
     * error_code : 0
     */

    private String reason;
    private ResultBean result;
    private int error_code;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public static class ResultBean {
        /**
         * stat : 1
         * data : [{"uniquekey":"a0dc94b1924b550b4b8b50c310c913c7","title":"地震\u201c闯祸\u201d
         * 谁来给受损车辆买单？","date":"2017-08-13 13:43","category":"头条","author_name":"中国新闻周刊",
         * "url":"http://mini.eastday.com/mobile/170813134311149.html",
         * "thumbnail_pic_s":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134311_3d09f37e7b272be2837559a7aca2b6d7_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134311_3d09f37e7b272be2837559a7aca2b6d7_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134311_3d09f37e7b272be2837559a7aca2b6d7_5_mwpm_03200403.jpg"},
         * {"uniquekey":"44c4ef314c96f2b4b34d39d7b14707ab","title":"四川乐山一女子质问继父对母亲家暴行为，当街被继父刺死",
         * "date":"2017-08-13 13:58","category":"头条","author_name":"四川在线","url":"http://mini
         * .eastday.com/mobile/170813135844319.html","thumbnail_pic_s":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813135844_a1fbcb0e63245608f8305f6b25ecedb0_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813135844_a1fbcb0e63245608f8305f6b25ecedb0_2_mwpm_03200403.jpg"},
         * {"uniquekey":"2543229bf82c8e9976322b7bb37efaaa","title":"山东家长\"起早贪黑\"排队为孩子入学报名",
         * "date":"2017-08-13 13:41","category":"头条","author_name":"视觉中国","url":"http://mini
         * .eastday.com/mobile/170813134109399.html","thumbnail_pic_s":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134109_9ed1804ee4babf3905cf198abb1b0019_4_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134109_9ed1804ee4babf3905cf198abb1b0019_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813134109_9ed1804ee4babf3905cf198abb1b0019_5_mwpm_03200403.jpg"},
         * {"uniquekey":"8e8680fa76b74a81d13553d2dc497c77","title":"两岸关系别指望美国：美或因此不再帮台湾",
         * "date":"2017-08-13 13:39","category":"头条","author_name":"中国台湾网","url":"http://mini
         * .eastday.com/mobile/170813133914150.html","thumbnail_pic_s":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813133914_fe9755969115a6ea05ba3902fe770161_1_mwpm_03200403.jpg"},
         * {"uniquekey":"bbcd8dd07fd1706d860db78ec34011b6","title":"印度此刻最紧张的非洞朗 而是中国这个度假胜地",
         * "date":"2017-08-13 13:35","category":"头条","author_name":"环球网","url":"http://mini
         * .eastday.com/mobile/170813133523877.html","thumbnail_pic_s":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813133523_9cc95a375bd040fba7075cac9f52d309_1_mwpm_03200403.jpg"},
         * {"uniquekey":"28b950f77fea29136c8269f1c0d366c9","title":"因为这个原因，印军对中国两座边境雷达站恨之如骨",
         * "date":"2017-08-13 13:21","category":"头条","author_name":"军事图书馆","url":"http://mini
         * .eastday.com/mobile/170813132142981.html","thumbnail_pic_s":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_3883516a0f19a1786f9c84d0ea70977e_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_ca61fdaa062aff1eef9f67451a34c578_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_68ed2ec711ed316b3d98112726525d85_cover_mwpm_03200403.jpeg"},
         * {"uniquekey":"4a461ec89be056ebf1cc377fc65240b8","title":"五大新疆最美女星，迪丽热巴只能排在第二？",
         * "date":"2017-08-13 13:15","category":"头条","author_name":"叶子娱乐","url":"http://mini
         * .eastday.com/mobile/170813131500345.html","thumbnail_pic_s":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813131500_d41d8cd98f00b204e9800998ecf8427e_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813131500_d41d8cd98f00b204e9800998ecf8427e_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813131500_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg"},
         * {"uniquekey":"5625e58d13854bf4113797285148ac9a","title":"未婚姑娘嫁给六旬老人，掀开盖头后全村都笑了！",
         * "date":"2017-08-13 12:59","category":"头条","author_name":"醉鱼","url":"http://mini
         * .eastday.com/mobile/170813125927243.html","thumbnail_pic_s":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813125927_a4e2d18b3eb20372b92558ba5d97c502_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813125927_a4e2d18b3eb20372b92558ba5d97c502_6_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813125927_a4e2d18b3eb20372b92558ba5d97c502_5_mwpm_03200403.jpg"},
         * {"uniquekey":"bb758b7bb627545dc1136e821702fb73",
         * "title":"伊拉克打了一场仗美国人击毁七百辆中国坦克，专家调查后笑了","date":"2017-08-13 12:56","category":"头条",
         * "author_name":"一号军情","url":"http://mini.eastday.com/mobile/170813125631883.html",
         * "thumbnail_pic_s":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_acf17664913911917c6e85699c646517_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_baa0c4002b6b6c2f453d88a8e1fcbc96_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://06.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_b0f8a240e47132993fd26e3bd6979251_cover_mwpm_03200403.jpeg"},
         * {"uniquekey":"71395f58cfe8a1059c41046623667ed5","title":"原铁道部落马官员张曙光获减刑",
         * "date":"2017-08-13 12:55","category":"头条","author_name":"政事儿","url":"http://mini
         * .eastday.com/mobile/170813125518878.html","thumbnail_pic_s":"http://09.imgmini.eastday
         * .com/mobile/20170813
         * /20170813125518_a018f1dfaaa9c82b3560743a92f29ce5_1_mwpm_03200403.jpg"},
         * {"uniquekey":"8c112ce1245f09f619c817e5c07490db","title":"监管部门:让各大富豪隐形资产\"见光死\"的政策来了",
         * "date":"2017-08-13 12:48","category":"头条","author_name":"侠客岛","url":"http://mini
         * .eastday.com/mobile/170813124824032.html","thumbnail_pic_s":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813124824_d10cf8ddd744ed1a8decb00b623a6f8a_1_mwpm_03200403.jpg"},
         * {"uniquekey":"93f92c80eabc20dfccca94740418de94","title":"刚刚，印度先出手！另一个大国也喊话中国：周一见！",
         * "date":"2017-08-13 12:38","category":"头条","author_name":"中金在线","url":"http://mini
         * .eastday.com/mobile/170813123850292.html","thumbnail_pic_s":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123850_4bbadeb9d4c6120852288a07ff494517_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123850_4bbadeb9d4c6120852288a07ff494517_4_mwpm_03200403.jpg"},
         * {"uniquekey":"92ba7bd4710ee7d140dd5ba31da58e45","title":"日军一度沦陷大半个中国，为何唯独看不上这个省？",
         * "date":"2017-08-13 12:38","category":"头条","author_name":"沔阳轶事","url":"http://mini
         * .eastday.com/mobile/170813123827619.html","thumbnail_pic_s":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123827_288126e86ad548f4f5d399a3c15700d7_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123827_288126e86ad548f4f5d399a3c15700d7_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123827_288126e86ad548f4f5d399a3c15700d7_3_mwpm_03200403.jpg"},
         * {"uniquekey":"9a349748188c685732a657f5e863fe93","title":"她是亚洲第一美臀","date":"2017-08-13
         * 12:37","category":"头条","author_name":"凤凰网","url":"http://mini.eastday
         * .com/mobile/170813123722077.html","thumbnail_pic_s":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123722_d41d8cd98f00b204e9800998ecf8427e_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123722_d41d8cd98f00b204e9800998ecf8427e_4_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123722_d41d8cd98f00b204e9800998ecf8427e_5_mwpm_03200403.jpg"},
         * {"uniquekey":"f968d18cd0e06cf59f8736b1d8b27908","title":"印度高官回应中印洞朗对峙:印度已完全做好准备",
         * "date":"2017-08-13 12:34","category":"头条","author_name":"海外网","url":"http://mini
         * .eastday.com/mobile/170813123437972.html","thumbnail_pic_s":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123437_c498067d3e5ff3ed79f408c4a4c3cac0_1_mwpm_03200403.jpg"},
         * {"uniquekey":"2aac99d24a05c4a0510ab5577d0a9c4e",
         * "title":"印度女子游中国称不想走！回国后大骂印度媒体，称可恶的骗子！","date":"2017-08-13 12:31","category":"头条",
         * "author_name":"追求自由的步伐","url":"http://mini.eastday.com/mobile/170813123138423.html",
         * "thumbnail_pic_s":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123138_36b71045f24945b8509ba021a95a21c0_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123138_36b71045f24945b8509ba021a95a21c0_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123138_36b71045f24945b8509ba021a95a21c0_3_mwpm_03200403.jpg"},
         * {"uniquekey":"c09c1a1c124a42dc90f7ed87f561fefd","title":"跟中国反复叫板的印度，经济实力究竟几何？",
         * "date":"2017-08-13 12:31","category":"头条","author_name":"中新经纬","url":"http://mini
         * .eastday.com/mobile/170813123102133.html","thumbnail_pic_s":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123102_3c553926428c0da92a22ecdf05e6eb9b_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123102_3c553926428c0da92a22ecdf05e6eb9b_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123102_3c553926428c0da92a22ecdf05e6eb9b_5_mwpm_03200403.jpg"},
         * {"uniquekey":"18c48f377ad77c0fc7acfcba6ee4148a",
         * "title":"6GB手机集体\u201c降价\u201d跳水，2499降到1799","date":"2017-08-13 12:30",
         * "category":"头条","author_name":"玩机喵","url":"http://mini.eastday
         * .com/mobile/170813123040339.html","thumbnail_pic_s":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123040_681661e43a0e0cb36330849dbe1e7d37_6_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123040_681661e43a0e0cb36330849dbe1e7d37_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://07.imgmini.eastday
         * .com/mobile/20170813
         * /20170813123040_681661e43a0e0cb36330849dbe1e7d37_4_mwpm_03200403.jpg"},
         * {"uniquekey":"01c8366270410bc490656fc96a8ff35c","title":"美国或对华发起贸易调查，单边主义贸易策略遭遇多方质疑",
         * "date":"2017-08-13 12:17","category":"头条","author_name":"新华网","url":"http://mini
         * .eastday.com/mobile/170813121754728.html","thumbnail_pic_s":"http://09.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121754_55fd468170bcd2db22e6f2150120f53b_1_mwpm_03200403.jpg"},
         * {"uniquekey":"91c4a0851cff6770dde10dad6a8f0437","title":"福岛地震核泄漏七年过去了，看看生物都产生了哪些变异！",
         * "date":"2017-08-13 12:14","category":"头条","author_name":"笑解千千愁","url":"http://mini
         * .eastday.com/mobile/170813121445290.html","thumbnail_pic_s":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121445_a20b303d0acdbc905833f6b854acafec_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121445_a20b303d0acdbc905833f6b854acafec_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://03.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121445_a20b303d0acdbc905833f6b854acafec_1_mwpm_03200403.jpg"},
         * {"uniquekey":"613736f45e7f55cbcfc4ea59712d916e",
         * "title":"司机与人方便雨中让孕妇搭车，谁知孕妇遗落的雨伞竟救了司机一命","date":"2017-08-13 12:11","category":"头条",
         * "author_name":"二页书","url":"http://mini.eastday.com/mobile/170813121111127.html",
         * "thumbnail_pic_s":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://05.imgmini.eastday
         * .com/mobile/20170813
         * /20170813121111_a3b3b7d95fe1e300f341e2d7fd30edeb_3_mwpm_03200403.jpg"},
         * {"uniquekey":"5299fa13389cb570f7ecd2af78e51216","title":"纽约华人为九寨沟地震灾民慷慨解囊(图）",
         * "date":"2017-08-13 12:06","category":"头条","author_name":"侨报网","url":"http://mini
         * .eastday.com/mobile/170813120622386.html","thumbnail_pic_s":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120622_1b6a38c360f457707c6633f03f2a3fb5_1_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120622_1b6a38c360f457707c6633f03f2a3fb5_2_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120622_1b6a38c360f457707c6633f03f2a3fb5_3_mwpm_03200403.jpg"},
         * {"uniquekey":"b4dc5a28f4693a1655473489fa71caaa","title":"印度曾出兵50万差点灭国巴铁，中国警告：做好炮击准备",
         * "date":"2017-08-13 12:06","category":"头条","author_name":"兵器次元","url":"http://mini
         * .eastday.com/mobile/170813120621600.html","thumbnail_pic_s":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_09498150bc1805602c01be8f518ef131_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_38289073c2b250ae11bdfe2539b8e7f6_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_1cb9039fe1cc403e8b15bbeac28cf215_cover_mwpm_03200403.jpeg"},
         * {"uniquekey":"7ff2dcd6c8912df7a131f8d3696e046b",
         * "title":"12号台风\u201c榕树\u201d生成！浙江高温天卷土重来？","date":"2017-08-13 12:05","category":"头条",
         * "author_name":"浙江在线","url":"http://mini.eastday.com/mobile/170813120523336.html",
         * "thumbnail_pic_s":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120523_802c4503c034e78c6f9f0e57d399b383_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://01.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120523_802c4503c034e78c6f9f0e57d399b383_2_mwpm_03200403.jpg"},
         * {"uniquekey":"cf6e1aaa00123f65790194661e876c3e",
         * "title":"中国两个地方，一年可以消灭3亿只兔子和1亿只鸭子，你知道吗！","date":"2017-08-13 12:03","category":"头条",
         * "author_name":"南山美食家","url":"http://mini.eastday.com/mobile/170813120333551.html",
         * "thumbnail_pic_s":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120333_96ef924038c7fc6d123b32f3707751cd_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120333_96ef924038c7fc6d123b32f3707751cd_4_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813120333_96ef924038c7fc6d123b32f3707751cd_1_mwpm_03200403.jpg"},
         * {"uniquekey":"41f076dfa2787797b95eefa1823dc058","title":"俄战机锁定中国 印紧随其后 美最担心的事发生了！",
         * "date":"2017-08-13 11:57","category":"头条","author_name":"张殿成军情观察","url":"http://mini
         * .eastday.com/mobile/170813115746108.html","thumbnail_pic_s":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_6251646336bbc7a7a3710cc86352a837_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_6478adcfb1175353f8f19e29aac54fd0_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://02.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_289a2c4063eb57690a82d60589b20639_cover_mwpm_03200403.jpeg"},
         * {"uniquekey":"a343166aaeea56b3e26f015a78a7fa75",
         * "title":"农村住房建设管理政策重大调整，你家建的房子符合新规定吗？","date":"2017-08-13 11:40","category":"头条",
         * "author_name":"钱钱名站","url":"http://mini.eastday.com/mobile/170813114007231.html",
         * "thumbnail_pic_s":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813114007_493303148f5206b216578f57ce949dca_4_mwpm_03200403.jpg",
         * "thumbnail_pic_s02":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813114007_493303148f5206b216578f57ce949dca_3_mwpm_03200403.jpg",
         * "thumbnail_pic_s03":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813114007_493303148f5206b216578f57ce949dca_2_mwpm_03200403.jpg"},
         * {"uniquekey":"508f4e457c11020b16a50b233dbce2cb","title":"广东河源市东源县发生3.0级地震 震源深度11千米",
         * "date":"2017-08-13 11:37","category":"头条","author_name":"中国新闻网","url":"http://mini
         * .eastday.com/mobile/170813113718031.html","thumbnail_pic_s":"http://00.imgmini.eastday
         * .com/mobile/20170813
         * /20170813113718_0152fa0426f09ef6050ab8def6cb27a8_1_mwpm_03200403.jpg"},
         * {"uniquekey":"f1ca21c69d4a3c7a7b86dd5fccd17049","title":"八月还债九月发，三大生肖时来运转，伸手就能接到财",
         * "date":"2017-08-13 11:19","category":"头条","author_name":"心理测试读心术","url":"http://mini
         * .eastday.com/mobile/170813111921644.html","thumbnail_pic_s":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_304cb1dfdcd1a757c97f282166a3e3a4_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_2ac43169356504f74061d6a3cd2c8efb_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://08.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_92714529a354a835f37ed0b7fb979d90_cover_mwpm_03200403.jpeg"},
         * {"uniquekey":"7398f8d6329e720b72c79833648fab2c","title":"男子婚前突然一病不起,
         * 医院那头得知真相女友整个人都崩溃了","date":"2017-08-13 11:17","category":"头条","author_name":"城事儿",
         * "url":"http://mini.eastday.com/mobile/170813111754296.html",
         * "thumbnail_pic_s":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_ca42d7dca610922a2782bde7082455e2_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s02":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_71aa8a6fa82570d133c7fadc05bb5b01_cover_mwpm_03200403.jpeg",
         * "thumbnail_pic_s03":"http://04.imgmini.eastday
         * .com/mobile/20170813
         * /20170813_e24c45b95203b1845b54f41b499969be_cover_mwpm_03200403.jpeg"}]
         */

        private String stat;
        private List<DataBean> data;

        public String getStat() {
            return stat;
        }

        public void setStat(String stat) {
            this.stat = stat;
        }

        public List<DataBean> getData() {
            return data;
        }

        public void setData(List<DataBean> data) {
            this.data = data;
        }

        public static class DataBean {
            /**
             * uniquekey : a0dc94b1924b550b4b8b50c310c913c7
             * title : 地震“闯祸” 谁来给受损车辆买单？
             * date : 2017-08-13 13:43
             * category : 头条
             * author_name : 中国新闻周刊
             * url : http://mini.eastday.com/mobile/170813134311149.html
             * thumbnail_pic_s : http://03.imgmini.eastday.com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_1_mwpm_03200403.jpg
             * thumbnail_pic_s02 : http://03.imgmini.eastday.com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_3_mwpm_03200403.jpg
             * thumbnail_pic_s03 : http://03.imgmini.eastday.com/mobile/20170813/20170813134311_3d09f37e7b272be2837559a7aca2b6d7_5_mwpm_03200403.jpg
             */

            private String uniquekey;
            private String title;
            private String date;
            private String category;
            private String author_name;
            private String url;
            private String thumbnail_pic_s;
            private String thumbnail_pic_s02;
            private String thumbnail_pic_s03;

            public String getUniquekey() {
                return uniquekey;
            }

            public void setUniquekey(String uniquekey) {
                this.uniquekey = uniquekey;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getCategory() {
                return category;
            }

            public void setCategory(String category) {
                this.category = category;
            }

            public String getAuthor_name() {
                return author_name;
            }

            public void setAuthor_name(String author_name) {
                this.author_name = author_name;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getThumbnail_pic_s() {
                return thumbnail_pic_s;
            }

            public void setThumbnail_pic_s(String thumbnail_pic_s) {
                this.thumbnail_pic_s = thumbnail_pic_s;
            }

            public String getThumbnail_pic_s02() {
                return thumbnail_pic_s02;
            }

            public void setThumbnail_pic_s02(String thumbnail_pic_s02) {
                this.thumbnail_pic_s02 = thumbnail_pic_s02;
            }

            public String getThumbnail_pic_s03() {
                return thumbnail_pic_s03;
            }

            public void setThumbnail_pic_s03(String thumbnail_pic_s03) {
                this.thumbnail_pic_s03 = thumbnail_pic_s03;
            }
        }
    }

}
