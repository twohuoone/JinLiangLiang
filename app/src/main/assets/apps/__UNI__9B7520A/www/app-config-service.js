
var isReady=false;var onReadyCallbacks=[];
var isServiceReady=false;var onServiceReadyCallbacks=[];
var __uniConfig = {"pages":["pages/auth/auth","pages/visitor/appointment","pages/visitor/scan","pages/visitor/door","pages/login/login","pages/repair/add","pages/homePage/index","pages/mine/mine","pages/homePage/leadPage","pages/visitor/history","pages/household/index","pages/workers/index","pages/repair/index","pages/repair/view","pages/workers/view","pages/workers/add","pages/household/view","pages/household/add","pages/notice/notice","pages/notice/notice_detail","pages/myTask/myTask","pages/taskDetail/taskDetail"],"window":{"navigationBarTextStyle":"black","navigationBarTitleText":"","navigationBarBackgroundColor":"#fff","backgroundColor":"#F8F8F8"},"nvueCompiler":"uni-app","renderer":"auto","splashscreen":{"alwaysShowBeforeRender":true,"autoclose":false},"appname":"smart-community-mini-apps","compilerVersion":"2.9.8","entryPagePath":"pages/auth/auth","networkTimeout":{"request":60000,"connectSocket":60000,"uploadFile":60000,"downloadFile":60000}};
var __uniRoutes = [{"path":"/pages/auth/auth","meta":{"isQuit":true},"window":{}},{"path":"/pages/visitor/appointment","meta":{},"window":{"navigationBarTitleText":"访客预约"}},{"path":"/pages/visitor/scan","meta":{},"window":{"navigationBarTitleText":"访客预约"}},{"path":"/pages/visitor/door","meta":{},"window":{"navigationBarTitleText":"智能门禁"}},{"path":"/pages/login/login","meta":{},"window":{"navigationBarTitleText":"身份验证"}},{"path":"/pages/repair/add","meta":{},"window":{"navigationBarTitleText":"报修新增"}},{"path":"/pages/homePage/index","meta":{},"window":{"navigationBarTitleText":""}},{"path":"/pages/mine/mine","meta":{},"window":{"navigationBarTitleText":"我的"}},{"path":"/pages/homePage/leadPage","meta":{},"window":{"navigationBarTitleText":"了解智能门禁"}},{"path":"/pages/visitor/history","meta":{},"window":{"navigationBarTitleText":"访客历史"}},{"path":"/pages/household/index","meta":{},"window":{"navigationBarTitleText":"住户管理"}},{"path":"/pages/workers/index","meta":{},"window":{"navigationBarTitleText":"报修工单"}},{"path":"/pages/repair/index","meta":{},"window":{"navigationBarTitleText":"报修工单"}},{"path":"/pages/repair/view","meta":{},"window":{"navigationBarTitleText":"报修详情"}},{"path":"/pages/workers/view","meta":{},"window":{"navigationBarTitleText":"工单详情"}},{"path":"/pages/workers/add","meta":{},"window":{"navigationBarTitleText":"工单新增"}},{"path":"/pages/household/view","meta":{},"window":{"navigationBarTitleText":"住户详情"}},{"path":"/pages/household/add","meta":{},"window":{"navigationBarTitleText":"新增住户"}},{"path":"/pages/notice/notice","meta":{},"window":{"navigationBarTitleText":"小区公告","enablePullDownRefresh":true}},{"path":"/pages/notice/notice_detail","meta":{},"window":{"navigationBarTitleText":"公告详情"}},{"path":"/pages/myTask/myTask","meta":{},"window":{"navigationBarTitleText":"事件任务"}},{"path":"/pages/taskDetail/taskDetail","meta":{},"window":{"navigationBarTitleText":"事件任务详情"}}];
__uniConfig.onReady=function(callback){if(__uniConfig.ready){callback()}else{onReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"ready",{get:function(){return isReady},set:function(val){isReady=val;if(!isReady){return}const callbacks=onReadyCallbacks.slice(0);onReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
__uniConfig.onServiceReady=function(callback){if(__uniConfig.serviceReady){callback()}else{onServiceReadyCallbacks.push(callback)}};Object.defineProperty(__uniConfig,"serviceReady",{get:function(){return isServiceReady},set:function(val){isServiceReady=val;if(!isServiceReady){return}const callbacks=onServiceReadyCallbacks.slice(0);onServiceReadyCallbacks.length=0;callbacks.forEach(function(callback){callback()})}});
service.register("uni-app-config",{create(a,b,c){if(!__uniConfig.viewport){var d=b.weex.config.env.scale,e=b.weex.config.env.deviceWidth,f=Math.ceil(e/d);Object.assign(__uniConfig,{viewport:f,defaultFontSize:Math.round(f/20)})}return{instance:{__uniConfig:__uniConfig,__uniRoutes:__uniRoutes,global:void 0,window:void 0,document:void 0,frames:void 0,self:void 0,location:void 0,navigator:void 0,localStorage:void 0,history:void 0,Caches:void 0,screen:void 0,alert:void 0,confirm:void 0,prompt:void 0,fetch:void 0,XMLHttpRequest:void 0,WebSocket:void 0,webkit:void 0,print:void 0}}}});
