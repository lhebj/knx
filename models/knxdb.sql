/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     3/15/2014 4:08:30 PM                         */
/*==============================================================*/

DROP DATABASE IF EXISTS knxdb;

CREATE DATABASE IF NOT EXISTS knxdb DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;

USE knxdb;

drop table if exists knx_brand_brd;

drop table if exists knx_brand_detail_brdd;

drop table if exists knx_category_cat;

drop table if exists knx_brand_category_bc;

drop table if exists knx_product_prd;

drop table if exists knx_product_detail_prdd;

drop table if exists knx_product_download_prdl;

drop table if exists knx_news_n;

drop table if exists knx_training_tra;

drop table if exists knx_about_u;

drop table if exists knx_user_u;

drop table if exists knx_authority_aut;

drop table if exists knx_user_authority_uut;

/*==============================================================*/
/* Table: knx_brand_brd                                         */
/*==============================================================*/
create table knx_brand_brd
(
   id_brd               bigint NOT NULL AUTO_INCREMENT,
   name_brd             varchar(128),
   initials_brd         char(1) comment '首字母',
   is_enabled_brd		bit,
   PRIMARY KEY(id_brd)
);
insert into knx_brand_brd values (1,'ABB','A',true);
insert into knx_brand_brd values (2,'ABC','A',true);
insert into knx_brand_brd values (3,'ABD','A',true);
insert into knx_brand_brd values (4,'BBC','B',true);
insert into knx_brand_brd values (5,'BBD','B',true);
insert into knx_brand_brd values (6,'BBC222','B',true);
insert into knx_brand_brd values (7,'BB++11D','B',true);
insert into knx_brand_brd values (8,'BBD1','B',true);
insert into knx_brand_brd values (9,'BBC2222','B',true);
insert into knx_brand_brd values (10,'BB1++11D','B',true);

insert into knx_brand_brd values (11,'CBB','C',true);

insert into knx_brand_brd values (12,'DBB','D',true);
insert into knx_brand_brd values (13,'DBC','D',true);

insert into knx_brand_brd values (14,'EBB','E',true);
insert into knx_brand_brd values (15,'EBC','E',true);

insert into knx_brand_brd values (16,'FBB','F',true);
insert into knx_brand_brd values (17,'FBC','F',true);
insert into knx_brand_brd values (18,'FBD','F',true);

insert into knx_brand_brd values (19,'GBB','G',true);
insert into knx_brand_brd values (20,'GBC','G',true);
insert into knx_brand_brd values (21,'GBD','G',true);

insert into knx_brand_brd values (22,'HBB','H',true);
insert into knx_brand_brd values (23,'HBC','H',true);
insert into knx_brand_brd values (24,'HBD','H',true);

insert into knx_brand_brd values (25,'JBB','J',true);
insert into knx_brand_brd values (26,'JBC','J',true);
insert into knx_brand_brd values (27,'JBD','J',true);

insert into knx_brand_brd values (28,'KBB','K',true);
insert into knx_brand_brd values (29,'KBC','K',true);
insert into knx_brand_brd values (30,'KBD','K',true);

insert into knx_brand_brd values (31,'LBB','L',true);
insert into knx_brand_brd values (32,'LBC','L',true);
insert into knx_brand_brd values (33,'LBD','L',true);

insert into knx_brand_brd values (34,'MBB','M',true);
insert into knx_brand_brd values (35,'MBC','M',true);

insert into knx_brand_brd values (36,'OBB','O',true);
insert into knx_brand_brd values (37,'OBC','O',true);

insert into knx_brand_brd values (38,'PBB','P',true);
insert into knx_brand_brd values (39,'PBC','P',true);

insert into knx_brand_brd values (40,'SBB','S',true);
insert into knx_brand_brd values (41,'SBC','S',true);

insert into knx_brand_brd values (42,'TBB','T',true);
insert into knx_brand_brd values (43,'TBC','T',true);

insert into knx_brand_brd values (44,'VBB','V',true);
insert into knx_brand_brd values (45,'VBC','V',true);
insert into knx_brand_brd values (46,'VBB','V',true);
insert into knx_brand_brd values (47,'VBC','V',true);

insert into knx_brand_brd values (48,'WBB','W',true);
insert into knx_brand_brd values (49,'WBC','W',true);

insert into knx_brand_brd values (50,'ZBB','Z',true);
insert into knx_brand_brd values (51,'ZBC','Z',true);





alter table knx_brand_brd comment '品牌';

/*==============================================================*/
/* Table: pro_brand_detail_brdd                                 */
/*==============================================================*/
create table knx_brand_detail_brdd
(
   id_brdd 				bigint NOT NULL AUTO_INCREMENT,
   idbrd_brdd           bigint NOT NULL,
   introduction_brdd    text comment '品牌介绍',
   idlogo_brdd          bigint comment '品牌logo',
   date_create_brdd     date comment '创建时间',
   is_enabled_brdd		bit,
   PRIMARY KEY(id_brdd),
   UNIQUE KEY `idbrd_brdd` (`idbrd_brdd`)  
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci; 

insert into knx_brand_detail_brdd values (1,1,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (2,2,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (3,3,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (4,4,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (5,5,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (6,6,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (7,7,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (8,8,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (9,9,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (10,10,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (11,11,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (12,12,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (13,13,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (14,14,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (15,15,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (16,16,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (17,17,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (18,18,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (19,19,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (20,20,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (21,21,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (22,22,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (23,23,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (24,24,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (25,25,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (26,26,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (27,27,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (28,28,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (29,29,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (30,30,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (31,31,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (32,32,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (33,33,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (34,34,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (35,35,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (36,36,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (37,37,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (38,38,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (39,39,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (40,40,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (41,41,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (42,42,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (43,43,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (44,44,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (45,45,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (46,46,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (47,47,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (48,48,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (49,49,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);
insert into knx_brand_detail_brdd values (50,50,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

insert into knx_brand_detail_brdd values (51,51,'ABB,ABBBBBBBBBBBBBBBB',11,'2014-02-01 15:12:00',true);

alter table knx_brand_detail_brdd comment '品牌详情';

/*==============================================================*/
/* Table: knx_category_cat                                      */
/*==============================================================*/
create table knx_category_cat
(
   id_cat               bigint NOT NULL AUTO_INCREMENT,
   name_cat             varchar(128),
   initials_cat         char(1),
   is_enabled_cat		bit,
   PRIMARY KEY(id_cat)
);

insert into knx_category_cat values (1,'系统组成原件',null,true);
insert into knx_category_cat values (2,'按键式控制面板',null,true);
insert into knx_category_cat values (3,'触摸式控制面板',null,true);
insert into knx_category_cat values (4,'触摸屏控制面板',null,true);
insert into knx_category_cat values (5,'中央控制触摸屏',null,true);
insert into knx_category_cat values (6,'移动/存在探测器',null,true);
insert into knx_category_cat values (7,'环境参数探测器',null,true);
insert into knx_category_cat values (8,'开关控制模块',null,true);
insert into knx_category_cat values (9,'窗帘控制模块',null,true);
insert into knx_category_cat values (10,'调光控制模块',null,true);

insert into knx_category_cat values (11,'LED灯控制模块',null,true);
insert into knx_category_cat values (12,'风机盘管控制模块',null,true);

insert into knx_category_cat values (13,'输入/输出模块',null,true);

insert into knx_category_cat values (14,'地暖控制模块',null,true);
insert into knx_category_cat values (15,'功能控制模块',null,true);

insert into knx_category_cat values (16,'音/视频控制模块',null,true);
insert into knx_category_cat values (17,'协议转换网关',null,true);
insert into knx_category_cat values (18,'智能仪表',null,true);

insert into knx_category_cat values (19,'可视对讲',null,true);
insert into knx_category_cat values (20,'中央控制软件PC版',null,true);
insert into knx_category_cat values (21,'控制软件移动设备版',null,true);

insert into knx_category_cat values (22,'其他原件','H',true);


alter table knx_category_cat comment '分类';

/*==============================================================*/
/* Table: knx_brand_category_bc                                      */
/*==============================================================*/
create table knx_brand_category_bc
(
   id_bc                bigint NOT NULL AUTO_INCREMENT,
   idbrd_bc             bigint,
   idcat_bc             bigint,
   PRIMARY KEY(id_bc)
);
insert into knx_brand_category_bc values (1,1,1);
insert into knx_brand_category_bc values (1,1,2);
insert into knx_brand_category_bc values (1,1,3);
insert into knx_brand_category_bc values (1,1,4);
insert into knx_brand_category_bc values (1,1,5);
insert into knx_brand_category_bc values (1,1,6);

insert into knx_brand_category_bc values (1,2,11);
insert into knx_brand_category_bc values (1,2,12);
insert into knx_brand_category_bc values (1,2,13);
insert into knx_brand_category_bc values (1,2,14);
insert into knx_brand_category_bc values (1,2,15);
insert into knx_brand_category_bc values (1,2,16);

/*==============================================================*/
/* Table: knx_news_n                                            */
/*==============================================================*/
create table knx_news_n
(
   id_n                 bigint NOT NULL AUTO_INCREMENT,
   title_n              varchar(256),
   content_n            text,
   idpic_n				bigint,
   date_create_n        datetime,
   PRIMARY KEY(id_n)
);
insert into knx_news_n values (1,'Indiegogo Unveils New Branding and Website Redesign','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',12,'2014-02-01 10:00:00');
insert into knx_news_n values (2,'The Hilda Stories','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',13,'2014-02-01 10:00:00');
insert into knx_news_n values (3,'FitCity 9: Promoting Physical Activity through Design,Promoting Physical Activity through Design','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',14,'2014-02-01 10:00:00');
insert into knx_news_n values (4,'Indiegogo Unveils New Branding and Website Redesign,Promoting Physical Activity through Design','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',15,'2014-02-01 10:00:00');
insert into knx_news_n values (5,'中国高铁将用上“中国芯” 试验时速超600公里','<P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em">本报株洲4月21日电（记者汪晓东）中国南车株洲基地建造的国内首条8英寸绝缘栅双极型晶体管（IGBT）芯片生产线，日前通过专家鉴定，将于今年6月全线投产。这意味着我国打破了国外技术垄断，掌握了高速列车最核心的技术，中国高铁将用上“中国芯”。</P><P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em">中国南车生产的高铁列出采用自主开发的8英寸芯片，在试验中跑出了600公里以上的时速。中国南车也成为国内唯一一家全面掌握该芯片技术研发、模块封装测试和系统应用的企业，跻身世界先进水平。</P><P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em"><STRONG>关注《科技不怕问》官方微信，每日接收栏目精彩内容。关注方式：在微信添加好友处搜索“asktech”即可添加。</STRONG></P></div><span style="width:0;height:0;overflow:hidden;display:block;font:0/0 Arial">正文已结束，您可以按alt+4进行评论</span>',16,'2014-02-01 10:00:00');
alter table knx_news_n comment '新闻';

/*==============================================================*/
/* Table: knx_product_detail_prdd                               */
/*==============================================================*/
create table knx_product_detail_prdd
(
   id_prdd              bigint NOT NULL AUTO_INCREMENT,
   idprd_prdd           bigint comment '产品id',
   place_prdd            varchar(128) comment '产地',
   introduction_prdd    text comment '产品简介',
   parameters_prdd      text comment '产品参数',
   features_prdd        text comment '产品特性',
   supplier_prdd        varchar(512),
   idbigpic_prdd        bigint comment '产品大图id',
   idsmallpic1_prdd     bigint comment '产品小图1的id',
   idsmallpic2_prdd     bigint comment '产品小图2的id',
   idsmallpic3_prdd     bigint comment '产品小图3的id',
   idsmallpic4_prdd     bigint,
   idsmallpic5_prdd     bigint,
   idsmallpic6_prdd     bigint,
   iddetaillogo_prdd    bigint comment '产品详情页面logoid',
   date_create_prdd     datetime comment '创建时间',
   PRIMARY KEY(id_prdd)
);

insert into knx_product_detail_prdd values (1,1,'广东汕头','PHILIPS飞利浦 标准型节能灯11WE27日光色3支装','<p>商品毛重：244.00g </p><p>灯口：E27（大口）</p><p>功率：10W-30W</p><p>类别：U型</p><p>色温：冷光（5000K以上）</p>','PHILIPS飞利浦 标准型节能灯11WE27日光色3支装,PHILIPS飞利浦 标准型节能灯11WE27日光色3支装，PHILIPS飞利浦 标准型节能灯11WE27日光色3支装','PHILIPS飞利浦 ',18,19,20,21,22,23,24,50,'2014-02-01 10:00:00');

alter table knx_product_detail_prdd comment '产品详情';

/*==============================================================*/
/* Table: knx_product_prd                                       */
/*==============================================================*/
create table knx_product_prd
(
   id_prd               bigint NOT NULL AUTO_INCREMENT,
   name_prd             varchar(256),
   id_brd_prd           bigint,
   id_cat_prd           bigint,
   model_prd            varchar(128),
   logo_prd             bigint,
   PRIMARY KEY(id_prd)
);
CREATE INDEX id_brd_prd ON knx_product_prd(id_brd_prd);
CREATE INDEX id_cat_prd ON knx_product_prd(id_cat_prd);
CREATE INDEX model_prd ON knx_product_prd(model_prd);

insert into knx_product_prd values (1,'节能灯泡',1,1,'KNX-001',17);


alter table knx_product_prd comment '产品';


/*==============================================================*/
/* Table: knx_product_download_prdl                                       */
/*==============================================================*/
create table knx_product_download_prdl
(
   id_prdl               bigint NOT NULL AUTO_INCREMENT,
   id_prd_prdl           bigint,
   name_prdl             varchar(256),
   id_file_prdl           bigint,
   date_create_prdl      datetime,
   PRIMARY KEY(id_prdl)
);

insert into knx_product_download_prdl values (1,1,'安装说明',25,'2014-02-01 10:00:00');
insert into knx_product_download_prdl values (2,1,'使用手册',26,'2014-02-01 10:00:00');
insert into knx_product_download_prdl values (3,1,'CAD文件',27,'2014-02-01 10:00:00');
insert into knx_product_download_prdl values (4,1,'产品图片',28,'2014-02-01 10:00:00');
insert into knx_product_download_prdl values (5,1,'数据库文件',29,'2014-02-01 10:00:00');
insert into knx_product_download_prdl values (6,1,'其他文件',30,'2014-02-01 10:00:00');


alter table knx_product_download_prdl comment '产品文档下载';

/*==============================================================*/
/* Table: knx_training_tra                                      */
/*==============================================================*/
create table knx_training_tra
(
   id_tra               bigint NOT NULL AUTO_INCREMENT,
   title_tra            varchar(256),
   content_tra          text,
   idpic_tra				bigint,
   date_create_tra      datetime,
   PRIMARY KEY(id_tra)
);

insert into knx_training_tra values (1,'Training:Indiegogo Unveils New Branding and Website Redesign','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',14,'2014-02-01 10:00:00');
insert into knx_training_tra values (2,'Training,The Hilda Stories','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',13,'2014-02-01 10:00:00');
insert into knx_training_tra values (3,'FitCity 9: Promoting Physical Activity through Design,Promoting Physical Activity through Design-training','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',14,'2014-02-01 10:00:00');
insert into knx_training_tra values (4,'Indiegogo Unveils New Branding and Website Redesign,Promoting Physical Activity through Design-training','<br>Indiegogo\'s new dynamic logo embraces the customer in a unique and original way. Filled with an image from a prior Indiegogo campaign, it represents the company\'s mission to work hand-in-hand with campaigners to democratize finance and give people around the world the power to fund what matters to them. To highlight the breadth, depth and reach of its ecosystem, the logo showcases a different campaign every time the user refreshes the screen.<br><br>The redesigned website builds on these visual themes by featuring rich integration of photography, video and success stories. The website also enhances the user experience with upgraded capabilities for exploration and discovery.<br>',15,'2014-02-01 10:00:00');
insert into knx_training_tra values (5,'中国高铁将用上“中国芯” 试验时速超600公里-training','<P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em">本报株洲4月21日电（记者汪晓东）中国南车株洲基地建造的国内首条8英寸绝缘栅双极型晶体管（IGBT）芯片生产线，日前通过专家鉴定，将于今年6月全线投产。这意味着我国打破了国外技术垄断，掌握了高速列车最核心的技术，中国高铁将用上“中国芯”。</P><P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em">中国南车生产的高铁列出采用自主开发的8英寸芯片，在试验中跑出了600公里以上的时速。中国南车也成为国内唯一一家全面掌握该芯片技术研发、模块封装测试和系统应用的企业，跻身世界先进水平。</P><P style="TEXT-ALIGN: justify; TEXT-INDENT: 2em"><STRONG>关注《科技不怕问》官方微信，每日接收栏目精彩内容。关注方式：在微信添加好友处搜索“asktech”即可添加。</STRONG></P></div><span style="width:0;height:0;overflow:hidden;display:block;font:0/0 Arial">正文已结束，您可以按alt+4进行评论</span>',16,'2014-02-01 10:00:00');
alter table knx_training_tra comment '培训';


/*==============================================================*/
/* Table: knx_about_ab                                      */
/*==============================================================*/
create table knx_about_ab
(
   id_ab               bigint NOT NULL AUTO_INCREMENT,
   type_ab			   enum('about','contact'),
   content_ab          text,
   date_create_ab      datetime,
   PRIMARY KEY(id_ab)
);

insert into knx_about_ab values (1,'about','关于我们，介绍','2014-04-12 10:00:00');
insert into knx_about_ab values (2,'contact','<p>工作时间</p><p>周一至周五</p><p>9:00~18:00</p><p>电话</p><p>010-66668888</p><p>传真</p><p>010-66668888</p><p>邮件</p><p>info@handz.com.cn</p>','2014-04-12 10:00:00');

alter table knx_about_ab comment '关于';


/*==============================================================*/
/* Table: knx_authority_aut                                     */
/*==============================================================*/
create table knx_authority_aut
(
   id_aut               bigint NOT NULL AUTO_INCREMENT,
   authority_aut        varchar(64) comment '授权名称',
   type_aut             varchar(32) comment '角色类型',
   protectedres_aut     varchar(64),
   display_aut          varchar(64) comment '显示名称',
   PRIMARY KEY(id_aut)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
INSERT INTO knx_authority_aut VALUES(1, "AUTH_ADMIN", "ADMIN", "AMDIN", "ADMIN"); 
INSERT INTO knx_authority_aut VALUES(2, "AUTH_ANONYMOUS", "ANONYMOUS", "ANONYMOUS", "GUEST");
INSERT INTO knx_authority_aut VALUES(3, "AUTH_USER","USER","USER","USER");

alter table knx_authority_aut comment '授权表';


/*==============================================================*/
/* Table: knx_user_authority_uaut                                */
/*==============================================================*/
create table knx_user_authority_uaut
(
   id_uaut               bigint NOT NULL AUTO_INCREMENT,
   idu_uaut              bigint comment '用户id',
   idaut_uaut            bigint comment '授权id',
   PRIMARY KEY(id_uaut)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci; 
CREATE INDEX idx_idu_uaut ON knx_user_authority_uaut(idu_uaut);
CREATE INDEX idx_idaut_uaut ON knx_user_authority_uaut(idaut_uaut);
INSERT INTO knx_user_authority_uaut VALUES(1, 1, 1);
INSERT INTO knx_user_authority_uaut VALUES(2, 1, 3);
INSERT INTO knx_user_authority_uaut VALUES(3, 3, 3);

alter table knx_user_authority_uaut comment '用户授权表 ';

/*==============================================================*/
/* Table: knx_user_u                                            */
/*==============================================================*/
create table knx_user_u
(
   id_u                 bigint NOT NULL AUTO_INCREMENT,
   username_u           varchar(64),
   password_u           varchar(64),
   salt_u				varchar(8) comment '盐',
   email_u              varchar(128),
   weixin_u             varchar(64) comment '微信号',
   date_register_u      datetime,
   ip_u                 varchar(16),
   referer_u            varchar(512),
   is_enabled_u         bit,
   PRIMARY KEY(id_u)
);
CREATE unique INDEX idx_username_u ON knx_user_u(username_u);
CREATE unique INDEX idx_email_u ON knx_user_u(email_u);
INSERT INTO knx_user_u VALUES(1,'admin' , '9cbd581a0698b3228ffc18eda8a2c730','0516','admin@knx.com','knxadmin', '2014-01-29 11:23:10','127.0.0.1',null,1);
INSERT INTO knx_user_u VALUES(2,'guest' , '9cbd581a0698b3228ffc18eda8a2c730','0516','guest@knx.com','guest', '2014-01-29 11:23:10','127.0.0.1',null,0);
INSERT INTO knx_user_u VALUES(3,'knx' , '9cbd581a0698b3228ffc18eda8a2c730','0516','knx@knx.com','knx', '2014-01-29 11:23:10','127.0.0.1',null,1);

alter table knx_user_u comment '用户表';



/*==============================================================*/
/* Table: knx_content_con                                       */
/*==============================================================*/
create table knx_content_con
(
   id_con               bigint NOT NULL AUTO_INCREMENT,
   original_filename_con varchar(128),
   filename_con         varchar(128) comment '文件名',
   filesize_con         bigint comment '文件大小',
   mimetype_con         varchar(32) comment '类型',
   encoding_con         varchar(16) comment ' 编码',
   filepath_con         varchar(256) comment '文件路径',
   date_create_con      datetime comment '创建时间',
   src_con              varchar(32) comment '文件来源',
   PRIMARY KEY(id_con)
);
insert into knx_content_con values (1,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-1.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (2,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-2.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (3,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-3.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (4,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-3.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (5,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-2.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (6,'index-1.png','index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-1.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (7,'training-1.png','brand-1.png','667648','png','utf-8','news/2014-02-01/knx-training-1.png','2014-02-01 15:12:00','training');
insert into knx_content_con values (8,'training-1.png','brand-1.png','667648','png','utf-8','news/2014-02-01/knx-training-2.png','2014-02-01 15:12:00','training');
insert into knx_content_con values (9,'training-1.png','news-1.png','667648','png','utf-8','news/2014-02-01/knx-training-3.png','2014-02-01 15:12:00','training');
insert into knx_content_con values (10,'training-1.png','news-1.png','667648','png','utf-8','news/2014-02-01/knx-training-4.png','2014-02-01 15:12:00','training');

insert into knx_content_con values (11,'brand-1.png','brand-1.png','667648','png','utf-8','brand/2014-02-01/knx-brand-1.png','2014-02-01 15:12:00','brand');
insert into knx_content_con values (12,'news-1.png','brand-1.png','667648','png','utf-8','news/2014-02-01/knx-news-1.png','2014-02-01 15:12:00','news');
insert into knx_content_con values (13,'news-1.png','brand-1.png','667648','png','utf-8','news/2014-02-01/knx-news-2.png','2014-02-01 15:12:00','news');
insert into knx_content_con values (14,'news-1.png','news-1.png','667648','png','utf-8','news/2014-02-01/knx-news-3.png','2014-02-01 15:12:00','news');
insert into knx_content_con values (15,'news-1.png','news-1.png','667648','png','utf-8','news/2014-02-01/knx-news-4.png','2014-02-01 15:12:00','news');
insert into knx_content_con values (16,'news-1.png','news-1.png','667648','png','utf-8','news/2014-02-01/knx-news-5.png','2014-02-01 15:12:00','news');

insert into knx_content_con values (17,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-logo-1.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (18,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-big-1.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (19,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-1.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (20,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-2.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (21,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-3.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (22,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-4.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (23,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-5.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (24,'knx-product.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-small-6.png','2014-02-01 15:12:00','product');

insert into knx_content_con values (25,'knx-product-upload-1.docx','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-1.docx','2014-02-01 15:12:00','product');
insert into knx_content_con values (26,'knx-product-upload-2.docx','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-2.docx','2014-02-01 15:12:00','product');
insert into knx_content_con values (27,'knx-product-upload-3.docx','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-3.docx','2014-02-01 15:12:00','product');
insert into knx_content_con values (28,'knx-product-upload-5.png','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-4.png','2014-02-01 15:12:00','product');
insert into knx_content_con values (29,'knx-product-upload-5.docx','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-5.docx','2014-02-01 15:12:00','product');
insert into knx_content_con values (30,'knx-product-upload-6.docx','knx-product.png','667648','png','utf-8','product/2014-02-01/knx-product-upload-6.docx','2014-02-01 15:12:00','product');

insert into knx_content_con values (31,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-1.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (32,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-2.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (33,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-3.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (34,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-r1c2.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (35,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-r1c3.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (36,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-r2c1.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (37,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-r2c2.png','2014-02-01 15:12:00','index');
insert into knx_content_con values (38,'knx-index-1.png','knx-index-1.png','667648','png','utf-8','index/2014-02-01/knx-index-r2c3.png','2014-02-01 15:12:00','index');

insert into knx_content_con values (50,'knx-productdetail-logo.png','knx-productdetail-logo.png','667648','png','utf-8','product/2014-02-01/product_detail_logo.png','2014-02-01 15:12:00','product');
alter table knx_content_con comment '文件存储表';

/*==============================================================*/
/* Table: knx_index_idx                                         */
/*==============================================================*/
create table knx_index_idx
(
   id_idx               bigint NOT NULL AUTO_INCREMENT,
   idpic_idx            bigint comment '图片的id',
   type_idx             varchar(160) comment '类型：图片或者视频',
   playcode_idx         varchar(1024) comment '外链代码',
   position_idx			varchar(8) comment '首页位置',
   date_create_idx      datetime,
   PRIMARY KEY(id_idx)
);
alter table knx_index_idx add column link_idx  varchar(256);
insert into knx_index_idx values (1,31,'video','<iframe height=280 width=680 src="http://player.youku.com/embed/XNzA5ODMxMzY0" frameborder=0 allowfullscreen></iframe>','r1c1','2014-02-01 10:00:00',null);
insert into knx_index_idx values (2,32,'pic',null,'r1c1','2014-02-01 10:00:00',null);
insert into knx_index_idx values (3,33,'pic',null,'r1c1','2014-02-01 10:00:00',null);
insert into knx_index_idx values (4,34,'pic',null,'r1c2','2014-02-01 10:00:00',null);
insert into knx_index_idx values (5,35,'pic',null,'r1c3','2014-02-01 10:00:00',null);

insert into knx_index_idx values (6,36,'pic',null,'r2c1','2014-02-01 10:00:00',null);
insert into knx_index_idx values (7,37,'pic',null,'r2c2','2014-02-01 10:00:00',null);
insert into knx_index_idx values (8,38,'pic',null,'r2c3','2014-02-01 10:00:00',null);

alter table knx_index_idx comment '首页图片设置';

