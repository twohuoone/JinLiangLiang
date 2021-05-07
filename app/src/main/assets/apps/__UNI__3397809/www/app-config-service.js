
var isReady=false;var onReadyCallbacks=[];
var isServiceReady=false;var onServiceReadyCallbacks=[];
var __uniConfig = {"pages":["pages/login/login","pages/elegant/jiangyiCommunity","pages/elegant/jiangyiGuide","pages/homePage/aroundService","pages/notice/notice","pages/notice/notice_detail","pages/lifePhoto/add","pages/lifePhoto/mine","pages/lifePhoto/index","pages/lifePhoto/view","pages/activity/index","pages/activity/view","pages/elegant/index","pages/elegant/detail","pages/ownerFeedBack/index","pages/ownerFeedBack/view","pages/ownerFeedBack/add","pages/siteAppoint/index","pages/siteAppoint/add","pages/communityDynamic/index","pages/communityDynamic/detail"],"window":{"navigationStyle":"custom","navigationBarTextStyle":"black","navigationBarTitleText":"","navigationBarBackgroundColor":"#fff","backgroundColor":"#F8F8F8"},"nvueCompiler":"uni-app","renderer":"auto","splashscreen":{"alwaysShowBeforeRender":true,"autoclose":false},"appname":"smart-community-mini-apps","compilerVersion":"2.9.8","entryPagePath":"pages/login/login","networkTimeout":{"request":60000,"connectSocket":60000,"uploadFile":60000,"downloadFile":60000}};
var __uniRoutes = [{"path":"/pages/login/login","meta":{"isQuit":true},"window":{"navigationBarTitleText":""}},{"path":"/pages/elegant/jiangyiCommunity","meta":{},"window":{"navigationBarTitleText":"社区动态"}},{"path":"/pages/elegant/jiangyiGuide","meta":{},"window":{"navigationBarTitleText":"办事指南"}},{"path":"/pages/homePage/aroundService","meta":{},"window":{"navigationBarTitleText":"周边服务"}},{"path":"/pages/notice/notice","meta":{},"window":{"navigationBarTitleText":"通知公告","enablePullDownRefresh":true}},{"path":"/pages/notice/notice_detail","meta":{},"window":{"navigationBarTitleText":"公告详情"}},{"path":"/pages/lifePhoto/add","meta":{},"window":{"navigationBarTitleText":"乱象曝光"}},{"path":"/pages/lifePhoto/mine","meta":{},"window":{"navigationBarTitleText":"我的随手拍","enablePullDownRefresh":true}},{"path":"/pages/lifePhoto/index","meta":{},"window":{"navigationBarTitleText":"乱象曝光","enablePullDownRefresh":true}},{"path":"/pages/lifePhoto/view","meta":{},"window":{"navigationBarTitleText":"详情"}},{"path":"/pages/activity/index","meta":{},"window":{"navigationBarTitleText":"业主活动","enablePullDownRefresh":true}},{"path":"/pages/activity/view","meta":{},"window":{"navigationBarTitleText":"活动详情"}},{"path":"/pages/elegant/index","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":true}},{"path":"/pages/elegant/detail","meta":{},"window":{"navigationBarTitleText":"","enablePullDownRefresh":false}},{"path":"/pages/ownerFeedBack/index","meta":{},"window":{"navigationBarTitleText":"业主反馈","enablePullDownRefresh":false}},{"path":"/pages/ownerFeedBack/view","meta":{},"window":{"navigationBarTitleText":"反馈详情","enablePullDownRefresh":false}},{"path":"/pages/ownerFeedBack/add","meta":{},"window":{"navigationBarTitleText":"新增反馈","enablePullDownRefresh":false}},{"path":"/pages/siteAppoint/index","meta":{},"window":{"navigationBarTitleText":"我的预约","enablePullDownRefresh":false}},{"path":"/pages/siteAppoint/add","meta":{},"window":{"navigationBarTitleText":"新增场地","enablePullDownRefresh":false}},{"path":"/pages/communityDynamic/index","meta":{},"window":{"navigationBarTitleText":"社区动态","enablePullDownRefresh":false}},{"path":"/pages/communityDynamic/detail","meta":{},"window":{"navigationBarTitleText":"动态详情","enablePullDownRefresh":false}}];
__uniConfig.onReady=function(callback){if(__uniConfig.ready){callback()}else{onReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"ready",{get:function(){return isReady},set:function(val){isReady=val;if(!isReady){return}const callbacks=onReadyCallbacks.slice(0);onReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
__uniConfig.onServiceReady=function(callback){if(__uniConfig.serviceReady){callback()}else{onServiceReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"serviceReady",{get:function(){return isServiceReady},set:function(val){isServiceReady=val;if(!isServiceReady){return}const callbacks=onServiceReadyCallbacks.slice(0);onServiceReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
service.register("uni-app-config",{create(a,b,c){if(!__uniConfig.viewport){var d=b.weex.config.env.scale,e=b.weex.config.env.deviceWidth,f=Math.ceil(e/d);Object.assign(__uniConfig,{viewport:f,defaultFontSize:Math.round(f/20)})}return{instance:{__uniConfig:__uniConfig,__uniRoutes:__uniRoutes,global:void 0,window:void 0,document:void 0,frames:void 0,self:void 0,location:void 0,navigator:void 0,localStorage:void 0,history:void 0,Caches:void 0,screen:void 0,alert:void 0,confirm:void 0,prompt:void 0,fetch:void 0,XMLHttpRequest:void 0,WebSocket:void 0,webkit:void 0,print:void 0}}}});
