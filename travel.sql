/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2017-06-16 23:05:57
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `tb_admin`
-- ----------------------------
DROP TABLE IF EXISTS `tb_admin`;
CREATE TABLE `tb_admin` (
  `admin_id` int(11) NOT NULL auto_increment,
  `admin_name` varchar(50) NOT NULL,
  `admin_pwd` varchar(50) NOT NULL,
  `admin_question` varchar(100) default NULL,
  `admin_answer` varchar(100) default NULL,
  PRIMARY KEY  (`admin_id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_admin
-- ----------------------------
INSERT INTO `tb_admin` VALUES ('1', 'zzzz', 'zzzz', '您的高中班主任是？', '刘晋杰');
INSERT INTO `tb_admin` VALUES ('4', 'bbbb', 'bbbb', '您最喜欢的明星是？', '赵丽颖');

-- ----------------------------
-- Table structure for `tb_comment`
-- ----------------------------
DROP TABLE IF EXISTS `tb_comment`;
CREATE TABLE `tb_comment` (
  `comment_id` int(11) NOT NULL auto_increment,
  `comment_date` varchar(50) default NULL,
  `comment_content` varchar(1000) default NULL,
  `user_id` int(11) default NULL,
  `note_id` int(11) default NULL,
  `response_date` varchar(50) default NULL,
  `response_content` varchar(1000) default NULL,
  PRIMARY KEY  (`comment_id`)
) ENGINE=MyISAM AUTO_INCREMENT=18 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_comment
-- ----------------------------
INSERT INTO `tb_comment` VALUES ('5', '2017-05-25 11:56:16', '学习了，心潮澎湃，如临其境。', '1', '5', '', '');
INSERT INTO `tb_comment` VALUES ('4', '2017-05-22 16:58:16', '楼主好棒啊，看过以后好像按照楼主路线走一遍', '18', '5', '1', '1');
INSERT INTO `tb_comment` VALUES ('6', '2017-05-17 10:33:11', '赞赞 让我一个身在山西的外地人 想赶紧行动起来 看看大山西的美好', '5', '5', '', '');
INSERT INTO `tb_comment` VALUES ('7', '2016-07-06 23:33:53', '不错，这几天就要去太原，如有个伴一起走就好了', '14', '5', '', '');
INSERT INTO `tb_comment` VALUES ('8', '2017-06-09 12:06:05', '淘宝套票提前几天买？', '1', '4', '', '');
INSERT INTO `tb_comment` VALUES ('9', '2017-06-08 18:24 :11', '你好，去雪山孩子有羽绒服租吗，我们是3岁', '1', '4', null, null);
INSERT INTO `tb_comment` VALUES ('10', '2015-12-09 13:47:13', '老年人去的话合适么，有没有什么推荐的轻松点的地方？', '5', '4', '2015-12-10 17:24:01', '老年人也木有问题的。如果觉得我行程中的登雪山比较辛苦可以取消，只坐缆车到4500米的高度，看到很多老人都有坐，应该没问题。如果觉得骑车去白沙比较辛苦，可以坐公交车去。如果只是想随便逛逛，建议住在束河，那里人不算多但交通还算方便。');
INSERT INTO `tb_comment` VALUES ('11', '2017-04-13 19:11:09', '刚从丽江回来，写的很好，赞！', '5', '7', null, null);
INSERT INTO `tb_comment` VALUES ('12', ' 2017-01-16 17:52:23', '去的时候天气不好，没这么兰的天', '1', '7', null, null);
INSERT INTO `tb_comment` VALUES ('13', '2017-06-12 03:10:25', '不行了，随着你的照片又回忆了一遍！虽然刚刚去过那边！我想偷偷的告诉你，我对你一见钟情了！', '20', '8', null, null);
INSERT INTO `tb_comment` VALUES ('14', '2016-07-08 11:27:33', '照片不错，跟着心动了', '5', '8', null, null);
INSERT INTO `tb_comment` VALUES ('15', '2016-06-25 07:42:22', '仔细看完了，太棒的游记，太美的照片。', '14', '8', null, null);
INSERT INTO `tb_comment` VALUES ('16', '2015-10-03 22:36:11', '是这几天拍的吗？太美了', '18', '9', null, null);
INSERT INTO `tb_comment` VALUES ('17', '2015-10-03 17:27:47', '楼主的图色彩好浓郁', '14', '9', null, null);

-- ----------------------------
-- Table structure for `tb_destination`
-- ----------------------------
DROP TABLE IF EXISTS `tb_destination`;
CREATE TABLE `tb_destination` (
  `destination_id` int(11) NOT NULL auto_increment,
  `destination_name` varchar(50) default NULL,
  `destination_pinyin` varchar(50) default NULL,
  `destination_number` int(11) default NULL,
  `nation_id` int(11) default NULL,
  `province_id` int(11) default NULL,
  `destination_img` varchar(50) default NULL,
  `destination_desc` varchar(1000) default NULL,
  `destination_imgarr` varchar(1000) default NULL,
  PRIMARY KEY  (`destination_id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_destination
-- ----------------------------
INSERT INTO `tb_destination` VALUES ('1', '太原', 'TAIYUAN', '126', '1', '5', './images/taiyuan_1.jpg', '太原，一座拥有2500多年建城历史的龙城宝地，唐高祖李渊自这里起义建立大唐，中国历史上唯一的一位女皇帝武则天诞生于此，诗仙李白曾赞她“雄藩巨镇，非贤莫属”。太原三面环山，汾河自此流过，自然山水与历史文化荟萃，有着“锦绣太原城”的美誉。\\n入太原，先闻到的便是一股子老陈醋的酸味，再来一碗丰盛的“头脑”，听一场曲调婉转的晋剧，到晋祠探一探太原的灵脉，登上凌霄双塔眺望晋阳的美丽山川，逛逛世界上最大的道教石窟??龙山石窟，去繁华的迎泽大街感受今日太原的魅力。末了，先饱餐一顿这座面食之都的丰盛美食，再晃到汾河边上欣赏红霞满天、夕阳斜照的美景；等到夜幕降临，看看那灯火辉煌，波光粼粼的汾河夜景。这一路太原之行，便成了。', './images/taiyuan_1.jpg;./images/taiyuan_2.jpg;./images/taiyuan_3.jpg;./images/taiyuan_4.jpg;./images/taiyuan_5.jpg');
INSERT INTO `tb_destination` VALUES ('2', '丽江', 'LIJIANG', '1200', '1', '1', './images/lijiang_1.jpg', '丽江地处滇西北高原，坐拥震撼优美的高原风光。这里自古以来就是丝绸之路和茶马古道繁华的中转站，也因此留下了珍贵的历史古迹和绚烂的文化。如今的丽江吸引着全国各地的无数游人，丽江古城更是很多游客心中的必去之地，它依山傍水，风景秀丽，古城内光滑的石板路、手工建造的土木结构房屋、无处不在的小桥流水，无一不在向世人展示着独特的恬静清幽。浓烈的人文气息，丰富的民族文化，加上艳丽的自然风光，慵懒的生活节奏，使得人们来了就不忍离去。', './images/lijiang_1.jpg;./images/lijiang_2.jpg;./images/lijiang_3.jpg;./images/lijiang_4.jpg;./images/lijiang_5.jpg;./images/lijiang_6.jpg;./images/lijiang_7.jpg');
INSERT INTO `tb_destination` VALUES ('3', '密云', 'MIYUN', '150', '1', '2', './images/miyun_1.jpg', '密云县地处北京市东北部燕山山脉脚下，历史悠久，是古代中原地区至东北、内蒙地区的交通孔道，有“京师锁钥”之称。如今的密云县，是北京市面积最大的区县，因境内多山、多古迹，也成为了京郊旅游的热门胜地。著名景点古北水镇、司马台长城、清凉谷、黑龙潭、密云水库等众多景点，构成了“有山有水、又大又美”的生态密云。', './images/miyun_1.jpg;./images/miyun_2.jpg;./images/miyun_3.jpg;./images/miyun_4.jpg;./images/miyun_5.jpg;./images/miyun_6.jpg;./images/miyun_7.jpg;./images/miyun_8.jpg');
INSERT INTO `tb_destination` VALUES ('9', '大理', 'DALI', '989', '1', '1', './images/dali_1.jpg', '大理位于云南省的西北部，东临洱海，西及点苍山脉，唐代的南诏国、宋代的大理国都曾将它作为都城，悠久的历史和文化，仅仅用一句“风花雪月--古城”还无法完全描绘出大理的全貌，美丽的自然风光再配上身穿白族服装的少女，让人流连忘返。', './images/dali_1.jpg;./images/dali_2.jpg;./images/dali_3.jpg;./images/dali_4.jpg;./images/dali_5.jpg');
INSERT INTO `tb_destination` VALUES ('10', '香格里拉', 'XIANGGELILA', '456', '1', '1', './images/xianggelila_1.jpg', '不论是爱冒险的热血青年还是文艺小清新都对香格里拉有极大的向往。香格里拉位于云南省西北部的滇、川、藏“大三角”区域，地处迪庆藏族自治州腹心地带，“香格里拉”一词源于《消失的地平线》一书，在藏语中意为“心中的日月”，因其圣洁优美被誉为“世外桃源”。\\n香格里拉有神圣的雪山、幽深的峡谷、飞舞的瀑布、被森林环绕的宁静湖泊，徜徉在美丽草原上的成群牛羊，净如明镜的天空，金碧辉煌的寺庙和淳朴善良的康巴藏族。', './images/xianggelila_1.jpg;./images/xianggelila_2.jpg;./images/xianggelila_3.jpg;./images/xianggelila_4.jpg;./images/xianggelila_5.jpg;./images/xianggelila_5.jpg;./images/xianggelila_5.jpg;./images/xianggelila_6.jpg');
INSERT INTO `tb_destination` VALUES ('11', '颐和园', 'YIHEYUAN', '2345', '1', '2', './images/yiheyuan_1.jpg', '颐和园原是清朝帝王的行宫和花园，又称清漪园，以昆明湖、万寿山为基址，按照江南园林的设计手法建造，是我国现存规模最大，保存最完整的皇家园林，景色极具优雅，还有很多珍贵的文物，被誉为“皇家园林博物馆”。\\n颐和园规模宏大，全园可分3个区域：以仁寿殿为中心的政治活动区；以玉澜堂、乐寿堂为主体的帝后生活区；以长廊沿线、后山、西区为主的苑园游览区。\\n整个园区约四分之三为昆明湖所占据，湖畔有亭、台、楼、阁、廊、榭等建筑物百余座三千余间，其中佛香阁、长廊、石舫、苏州街、十七孔桥等皆为家喻户晓的代表性建筑，也是游览颐和园不可错过的地方。', './images/yiheyuan_1.jpg;./images/yiheyuan_2.jpg;./images/yiheyuan_3.jpg;./images/yiheyuan_4.jpg');

-- ----------------------------
-- Table structure for `tb_nation`
-- ----------------------------
DROP TABLE IF EXISTS `tb_nation`;
CREATE TABLE `tb_nation` (
  `nation_id` int(11) NOT NULL auto_increment,
  `nation_name` varchar(50) NOT NULL,
  PRIMARY KEY  (`nation_id`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_nation
-- ----------------------------
INSERT INTO `tb_nation` VALUES ('1', '中国');
INSERT INTO `tb_nation` VALUES ('2', '美国');

-- ----------------------------
-- Table structure for `tb_note`
-- ----------------------------
DROP TABLE IF EXISTS `tb_note`;
CREATE TABLE `tb_note` (
  `note_id` int(11) NOT NULL auto_increment,
  `note_title` varchar(100) default NULL,
  `note_date` varchar(50) default NULL,
  `note_days` int(11) default NULL,
  `note_expend` varchar(50) default NULL,
  `note_partner` varchar(50) default NULL,
  `note_zannumber` int(11) default NULL,
  `note_seenumber` int(11) default NULL,
  `note_commentnumber` int(11) default NULL,
  `user_id` int(11) NOT NULL,
  `note_bgimg` varchar(1000) default NULL,
  `note_img` varchar(1000) default NULL,
  `note_address` varchar(100) default NULL,
  `note_content` varchar(1000) default NULL,
  PRIMARY KEY  (`note_id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_note
-- ----------------------------
INSERT INTO `tb_note` VALUES ('5', '太行山西黄河风情游（郭亮王莽岭壶口绩口老牛湾平遥云冈一个都不能少）', '2014-03-03', '11', '10000元', '一个人', '419', '40000', '3', '20', './images/note_daxia1.jpg', './images/note_daxia2.jpg;./images/note_daxia3.jpg;./images/note_daxia5.jpg;./images/note_daxia6.jpg', '太原', '2010-04-24<br/>对我来说，每一次旅行都应该有目的，没有目的的旅行就是流浪，而作为上班一族，流浪对我也只能是一种想象上的奢侈。\\n都说山西好风光，看到很多网友的游记照片，真的好，真的美，特别是一个关于山西黄河沿线风情的游记深深的抓住了我的眼球，壶口，绩口，偏关，老牛湾……但是山西太大，从南到北，哪有那么多时间哦？怎么该？怎么该？快使用双节棍啊…………\\n经过一番绞尽脑汁，最好确定行程：\\nD1  苏州夜火车至郑州，郑州动车至新乡，新乡火车站前汽车之辉县，辉县乡村巴士至万仙山景区，徒步进入郭亮村；\\nD2  郭亮村徒步经南平、惠山隧道至王莽岭，后王莽岭徒步至锡崖沟；\\nD3  在锡崖沟坐早上六点乡村巴士到县城陵川，陵川汽车至长治，长治汽车至临汾，临汾汽车到吉县，晚上吉县包车至壶口瀑布；\\nD4  上午壶口瀑布游玩，中午坐车回临汾，临汾火车到灵石\\nD5  灵石坐公车到王家大院，中午回灵石，下午坐火车到平遥，\\nD6  上午古城游玩，下午坐火车到大同，凌晨到达大同；\\nD7  大同火车站坐公车到达云冈石窟，中午打车回大同，玩九龙壁，下午大同火车站火车至朔州；\\nD8  朔州汽车至偏关，偏关至老牛湾，住老牛堡；\\nD9  老牛湾至偏关，坐车至绩口李家山，住李家山村；\\nD10  李家山徒步至绩口古镇，下午绩口坐车回太原。\r\nD11  晋祠、太原博物馆，晚上火车回苏州。');
INSERT INTO `tb_note` VALUES ('4', '#我的2015#从天而降的幸运丽江之旅', '2015-12-06', '5', '1500元', '亲子', '184', '2907', '4', '20', './images/note_daxia11.jpg', './images/note_daxia12.jpg;./images/note_daxia13.jpg;./images/note_daxia14.jpg;./images/note_daxia15.jpg', '丽江', '这是一次从天而降的，幸运的旅行。\\n某天中午我的微信里收到携程酒店公众号发过来的信息，哈哈哈，他们居然送了我一张丽江金茂君悦酒店的免费房券。纳尼？看来这丽江不去不行了啊，你们看，不是我要去的，是上天安排我去的啊，上天安排的还不够我臭屁吗（原谅我至尊宝上身）\\n携程酒店链接：http://hotels.ctrip.com/hotel/2887267.html\\n如果是单单一张免费房券还不够说明我的幸运，那接下来我又抢到了我和女儿的往返特价机票呢？佛山到昆明，88元，这比卧铺还要便宜哇，够不够我臭屁？我又要大笑三声了~\\n于是，选了个黄道吉日，我们踏上了为期五天的丽江之旅。D1：佛山??昆明??丽江\\n早上七点多出发，到了昆明十点多一点，坐机场大巴大约45分钟到昆明火车站。十二点整从昆明出发，晚上七点到达丽江。这一整天基本都是在路上，算是时间最赶的一天。其实选择中午十二点的火车是有一定冒险的，如果飞机晚点，或者机场大巴在市区塞车，就很可能赶不上火车了。\\n一点小心得：从丽江去昆明有很多大巴，如果坐大巴可以随时去买票（当然只是指淡季，旺季我们也不清楚），就不用担心飞机晚点或者到了昆明堵车的问题，但是我考虑到带着小朋友还是卧铺比较舒服，毕竟要把一个熊孩子困住大巴座位上六七个小时肯定会各种闹腾。D2：大研古城??黑龙潭公园??清溪水库??白沙古镇\\n这一天看着去的点挺多，但是因为除了在大研古城内，我们都是租单车骑行的，所以对小孩来说也不会有负担，而且后来发现她还很享受紧贴在我身前一路骑行的感觉，时不时的扭过头来亲亲我，好甜蜜。D3：蓝月谷??玉龙雪山');
INSERT INTO `tb_note` VALUES ('7', '彩云之南的行走-遇见丽江', '2014-12-19', '10', '2000元', '和朋友', '422', '7502', '2', '20', './images/note_daxia111.jpg', './images/note_daxia112.jpg;./images/note_daxia113.jpg;./images/note_daxia114.jpg;./images/note_daxia115.jpg', '丽江', '喜欢旅行的人对路上的一切都觉得新鲜，哪怕是一花一草一木，丽江是个美丽的地方，除了初到丽江被一个开车的纳西族大妈给忽悠了几十块钱，其他的体验还是非常棒的。随着旅游经济的开发，丽江也变得越来越商业，希望不要被过度开发吧，毕竟丽江的蓝天还有泸沽湖水的清澈在尘世已难觅芳踪…\\n之前虽从未到过丽江，但各种媒体的大肆宣传以及朋友圈各种高大上的丽江美图，无疑让人也对之心神向往。刚好北方的一个朋友告诉我说：“最近遇到烦心事，陪我去丽江吧...”一句话触动心弦，这是一次说走咱就走的旅行，只为逃出这被钢筋水泥禁锢的尘世...\\n束河古镇\\n11月不是旅行旺季，但也刚过云南的雨季，天气晴好，适合出行。打点行装，和小伙伴约好昆明见，便踏上了旅程！\\n我们从昆明乘下午的火车去丽江，经过一夜颠簸，第二天早上六点半抵达丽江火车站，出站后天还没亮，但见眼前是一片黑压压的群山，远处的山峰后现出的微白向湛蓝过渡的天色已让在尘世待久的我们惊为天人，好美！\\n丽江凤凰苑客栈\\n古城中的客栈大都设计得很古朴别致，以木结构为主，一楼会有一个种满各种植物的小院子，为住在这里的旅行者提供一个互相交流的场所。11月的丽江已是深秋时节，再加上地处高原，昼夜温差大，白天出太阳的时候能有20多度，晚上又会降到几度，客房里会有空调，热水器是用太阳能的，洗澡的话尽量别太晚。\\n茶马古道安中马场\\n茶马古道历史悠久，源于古代西南边疆和西北边疆的茶马互市，兴于唐宋，盛于明清，二战中后期最为兴盛。中国茶马古道有三条，第一条是陕甘茶马古道，是中国内地茶叶西行并换回马匹的主道。第二条是陕康藏茶马古道，主要是陕西人开辟；第三条是滇藏茶马古道。');
INSERT INTO `tb_note` VALUES ('8', '云南的蓝天白云~低头党治愈系之云南十日游', '2016-06-12', '10', '5000元', '一个人', '78', '9110', '3', '18', './images/note_nihong_1.jpg', './images/note_nihong_2.jpg;./images/note_nihong_3.jpg;./images/note_nihong_4.jpg', '丽江', '我错过了星星，错过了月亮，错过了五月的杜鹃花，错过了你。\\n可我，不愿再错过美丽的云南和珍贵的时光。\\n美丽的香格里拉镇楼！\\n【行程】DAY1 北京---昆明 火车\\nDAY2 昆明---大理 火车 行李寄存在青豆客\\nDAY3 双廊游玩一天\\nDAY4 环洱海骑行\\nDAY5 丽江闲逛\\nDAY6 ：丽江－长江第一湾?虎跳峡??小中甸牧场?月光古城（转经筒）??入住酒店准四商务酒店（报了梅梅的纯玩团）\\nDAY7 普达措国家森林公园');
INSERT INTO `tb_note` VALUES ('9', '秋意浓，遇见最美的长城', '2015-10-02', '2', '500元', '和朋友', '67', '1713', '2', '5', './images/note_air1.jpg', './images/note_air2.jpg;./images/note_air3.jpg;./images/note_air4.jpg;./images/note_air5.jpg', '密云', '前序：\\n我来到，你的城市，走过你来时的路。\\n想像着，没我的日子，你是怎样的孤独。\\n拍着你，曾经喜欢的照片，熟悉的那一条街。\\n只是没了你的画面，我们回不到那天。\\n你会不会忽然的出现，在街角的咖啡店\\n我会带着笑脸，挥手寒暄\\n对你说一句，只想说一句，好久不见...\\n-----陈奕迅《好久不见》\\n行前准备：\\n司马台长城是个四季皆适宜游玩的休闲度假胜地。春季碧波荡漾，长城下的古镇宛若一幅江南水墨画；夏季纳凉避暑，戏水游乐；秋季银杏落叶和古朴的建筑情景交融，摄影取材的好去处；冬季皑皑白雪的覆盖下，河面冻结，嬉雪赏冰雕……\\n本来我是借道北京准备回济南的，结果朋友晚上下班后直接100块租了一辆车，拉着我就像京郊密云奔去，所以我和朋友并没有多做准备，来了一场说走就走的旅行。不过直到出发我才知道，此行我是肩负着司机和摄影师的任务的...\\n交通：\\n我和朋友是租车自驾前往，所以简单介绍一下自驾路线，北京出发走京承高速到司马台出口出，出口100米右转，紧接着左转，然后就有路标指示，北京出发全程高速费60元/一车。从望京西到水镇大概花了1小时40分钟。\\n住宿：\\n说一下住宿，景区内有很多精致的客栈，但是嘛，价格也是不菲...所以我个人还是推荐大家住在景区服务区的民宿中，我和朋友提前在网上预订了一家名宿，一晚上170元，环境还算不错，连锁酒店的标准。晚上抵达，老板还给我们煮了方便面，第二天睡到自然醒，不行就可以到达景区啦。');

-- ----------------------------
-- Table structure for `tb_province`
-- ----------------------------
DROP TABLE IF EXISTS `tb_province`;
CREATE TABLE `tb_province` (
  `province_id` int(11) NOT NULL auto_increment,
  `province_name` varchar(50) NOT NULL,
  `nation_id` int(11) NOT NULL,
  PRIMARY KEY  (`province_id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_province
-- ----------------------------
INSERT INTO `tb_province` VALUES ('1', '云南省', '1');
INSERT INTO `tb_province` VALUES ('2', '北京', '1');
INSERT INTO `tb_province` VALUES ('4', '洛杉矶', '2');
INSERT INTO `tb_province` VALUES ('5', '山西省', '1');

-- ----------------------------
-- Table structure for `tb_question`
-- ----------------------------
DROP TABLE IF EXISTS `tb_question`;
CREATE TABLE `tb_question` (
  `question_id` int(11) NOT NULL auto_increment,
  `question_content` varchar(1000) default NULL,
  `question_answer` varchar(1000) default NULL,
  `question_label` varchar(50) default NULL,
  PRIMARY KEY  (`question_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_question
-- ----------------------------
INSERT INTO `tb_question` VALUES ('1', '无法用手机号注册成功', '如果您的手机号已经注册过携程旅行，将无法重复注册，建议您通过找回密码的方式进行登录。', '常用');
INSERT INTO `tb_question` VALUES ('4', '机票退票规则及金额', '1、退票规则以您的下单时提示的为准。\\n2、如因航班变动发生退票，请向航空公司索要航变证明并由我们向航空公司申请退票，最终退票金额以航空公司审核、规定为准。', '退订改期');
INSERT INTO `tb_question` VALUES ('7', '如何办理护照', '护照办理根据规定，须本人携带户口本原件及身份证原件，到户口所在地县级以上的（县）公安局入出境管理部门办理，不能委托他人办理。温馨提示：目前部分城市可以异地办理的，具体办理流程及所需费用以当地公安局为准。', '出游问题');
INSERT INTO `tb_question` VALUES ('8', '邮轮出境需要办理签证吗', '1、日韩的邮轮行程实行免签政策，需要收取护照等相关资料帮您办理免签登录许可证。\\n2、目的地为其他国家或地区的邮轮是否需要签证需以线路页面上的[签证说明为准\\n\\n温馨提示：即使中途不下船，除部分免签国家与地区外，也是需要办理岸上行程所至国家和地区的旅游签证。签证及登录许可证的办理方式及所需材料以订单页面显示为准。', '出游问题');
INSERT INTO `tb_question` VALUES ('9', '办理个人签证需要哪些材料', '1、有效期6个月以上的大陆因私护照。\\n2、两张2寸彩照，具体照片底色规则由领馆决定。\\n3、身份证原件。\\n4、签证申请表及财产证明等。', '出游问题');
INSERT INTO `tb_question` VALUES ('10', '国内航班哪些物品无法带上飞机', '危险物品（如爆炸品、气体、易燃液体等）、枪支、弹药、管制刀具、动物和法律明文禁止的物品是不能带上飞机的。\\n\\n特别提醒：乘坐国内航班是不可以随身携带酒、水等液态物品的，但可以携带少量旅行自用的化妆品，且容积不得超过100ML。', '出游问题');
INSERT INTO `tb_question` VALUES ('11', '如何赚取携程积分', '1、签到\\n用户每次登录可以获取5个积分。\\n2、新人注册，额外奖励30积分。\\n3、发表游记可以获取一定的积分。', '会员活动');
INSERT INTO `tb_question` VALUES ('12', '什么是旅游顾问', '旅游顾问是携程旅行为了更好的服务用户、提高用户的满意度，以及满足用户私人订制的需求，为用户提供一对一的专属顾问。', '会员活动');
INSERT INTO `tb_question` VALUES ('13', '火车票退票手续怎么算', '1、开车前15天（不含）以上退票的，不收取退票费；票面乘车站开车时间前48小时以上的按票价5%计，24小时以上、不足48小时的按票价10%计，不足24小时的按票价20%计\\n2、办理车票改签或“变更到站”时，新车票票价低于原车票的，退还差额，对差额部分核收退票费并执行现行退票费标准。', '退订改期');
INSERT INTO `tb_question` VALUES ('14', '微导游是否需要付费', '微导游是携程旅行推出的免费服务，此项服务现暂时不收取任何费用，如有以微导游名义收取款项请勿听信。', '常用');
INSERT INTO `tb_question` VALUES ('15', '如何投诉客服的服务态度', '亲，抱歉给您带来不佳的体验，请您联系人工客服为您核实情况。', '常用');

-- ----------------------------
-- Table structure for `tb_user`
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `user_id` int(11) NOT NULL auto_increment,
  `user_name` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  `user_pocket` varchar(50) default '0',
  `user_point` varchar(50) default '0',
  `note_id` int(11) default NULL,
  `user_repwd` varchar(50) default NULL,
  `user_touxiang` varchar(50) default NULL,
  PRIMARY KEY  (`user_id`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records of tb_user
-- ----------------------------
INSERT INTO `tb_user` VALUES ('1', '游客', '', '0', '0', null, '', './images/common_default_tx_transparent.png');
INSERT INTO `tb_user` VALUES ('5', '刘茹艳', '1234', '0', '0', '6', 'yes', './images/touxiang_hellokitty1.png');
INSERT INTO `tb_user` VALUES ('14', '武品彤', 'bbbb', '0', '0', null, 'no', './images/touxiang_hellokitty5.png');
INSERT INTO `tb_user` VALUES ('13', '潘梦颖', '1111', '0', '0', '5', 'no', './images/touxiang_smurf2.png');
INSERT INTO `tb_user` VALUES ('18', '任倩', 'cccc', '0', '0', '7', 'no', './images/touxiang_smurf7.png');
INSERT INTO `tb_user` VALUES ('20', '周文峰', 'aaaa', '0', '0', '5', 'no', './images/touxiang_duolaameng5.png');
