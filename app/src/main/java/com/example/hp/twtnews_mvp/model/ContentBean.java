package com.example.hp.twtnews_mvp.model;

import java.util.List;


public class ContentBean {

    /**
     * error_code : -1
     * message :
     * data : {"index":53325,"subject":"【图集】自信时代 燃电花火：自动化学院2016级迎新晚会","content":"String","newscome":"天外天新闻中心","gonggao":"天外天新闻中心 刘东昊 焦嘉凝","shengao":"天外天新闻中心 孙佳骏","sheying":"天外天新闻中心 刘东昊 焦嘉凝","visitcount":3196,"comments":[{"nid":53325,"ccontent":"#资瓷","cid":1167,"cuser":"Hugh_Zhang","ctime":"12/29"},{"nid":53325,"ccontent":"加油","cid":1172,"cuser":"weigungning","ctime":"02/10"}]}
     */

    public int error_code;
    public String message;
    public DataBean data;

    public static class DataBean {
        /**
         * index : 53325
         * subject : 【图集】自信时代 燃电花火：自动化学院2016级迎新晚会
         * content : String
         * newscome : 天外天新闻中心
         * gonggao : 天外天新闻中心 刘东昊 焦嘉凝
         * shengao : 天外天新闻中心 孙佳骏
         * sheying : 天外天新闻中心 刘东昊 焦嘉凝
         * visitcount : 3196
         * comments : [{"nid":53325,"ccontent":"#资瓷","cid":1167,"cuser":"Hugh_Zhang","ctime":"12/29"},{"nid":53325,"ccontent":"加油","cid":1172,"cuser":"weigungning","ctime":"02/10"}]
         */

        public int index;
        public String subject;
        public String content;
        public String newscome;
        public String gonggao;
        public String shengao;
        public String sheying;
        public int visitcount;
        public List<CommentsBean> comments;

        public static class CommentsBean {
            /**
             * nid : 53325
             * ccontent : #资瓷
             * cid : 1167
             * cuser : Hugh_Zhang
             * ctime : 12/29
             */

            public int nid;
            public String ccontent;
            public int cid;
            public String cuser;
            public String ctime;
        }
    }
}
