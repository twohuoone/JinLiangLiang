(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-lifePhoto-index"],{"1da1":function(t,e,i){"use strict";function n(t,e,i,n,r,o,a){try{var s=t[o](a),c=s.value}catch(l){return void i(l)}s.done?e(c):Promise.resolve(c).then(n,r)}function r(t){return function(){var e=this,i=arguments;return new Promise((function(r,o){var a=t.apply(e,i);function s(t){n(a,r,o,s,c,"next",t)}function c(t){n(a,r,o,s,c,"throw",t)}s(void 0)}))}}i("d3b7"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=r},"1eb6":function(t,e,i){"use strict";i.r(e);var n=i("53fe"),r=i("7d45");for(var o in r)"default"!==o&&function(t){i.d(e,t,(function(){return r[t]}))}(o);i("f5f6");var a,s=i("f0c5"),c=Object(s["a"])(r["default"],n["b"],n["c"],!1,null,"8cab5c6e",null,!1,n["a"],a);e["default"]=c.exports},"53fe":function(t,e,i){"use strict";var n;i.d(e,"b",(function(){return r})),i.d(e,"c",(function(){return o})),i.d(e,"a",(function(){return n}));var r=function(){var t=this,e=t.$createElement,n=t._self._c||e;return n("v-uni-view",{staticClass:"baseLayout"},[n("v-uni-image",{staticClass:"addLifePhoto",attrs:{src:"/static/image/lifePhoto/addLifePhoto.png",mode:"widthFix"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.jumpToAdd.apply(void 0,arguments)}}}),t.list.length>0?n("v-uni-view",{staticClass:"cloumnLayout"},t._l(t.list,(function(e,i){return n("v-uni-view",{key:i,staticClass:"item",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.jumpTo(e)}}},[e.patImageList.length>1?n("v-uni-view",{class:i%2===0?"h400 gradient":"h320 gradient"}):t._e(),e.patImageList.length>1?n("v-uni-image",{staticClass:"multIcon",attrs:{src:"/static/image/lifePhoto/multPhoto.png",mode:"widthFix"}}):t._e(),n("v-uni-image",{class:i%2===0?"h400":"h320",attrs:{src:e.patImageList[0],mode:"aspectFill"}}),n("v-uni-view",{staticClass:"contentLayout"},[t._v(t._s(e.patContent))]),n("v-uni-view",{staticClass:"userInfoLayout"},[n("v-uni-image",{staticClass:"userHeaderIcon",attrs:{src:e.memberPhoto,mode:"widthFix"}}),n("v-uni-text",{staticClass:"userName"},[t._v(t._s(t.dealName(e.memberName)))]),n("v-uni-text",{staticClass:"userTime"},[t._v(t._s(e.publishTimeText))])],1)],1)})),1):t._e(),t.list1.length>0?n("v-uni-view",{staticClass:"cloumnLayout"},t._l(t.list1,(function(e,i){return n("v-uni-view",{key:i,staticClass:"item",on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.jumpTo(e)}}},[e.patImageList.length>1?n("v-uni-view",{class:i%2===1?"h400 gradient":"h320 gradient"}):t._e(),e.patImageList.length>1?n("v-uni-image",{staticClass:"multIcon",attrs:{src:"/static/image/lifePhoto/multPhoto.png",mode:"widthFix"}}):t._e(),n("v-uni-image",{class:i%2===1?"h400":"h320",attrs:{src:e.patImageList[0],mode:"aspectFill"}}),n("v-uni-view",{staticClass:"contentLayout"},[t._v(t._s(e.patContent))]),n("v-uni-view",{staticClass:"userInfoLayout"},[n("v-uni-image",{staticClass:"userHeaderIcon",attrs:{src:e.memberPhoto,mode:"widthFix"}}),n("v-uni-text",{staticClass:"userName"},[t._v(t._s(t.dealName(e.memberName)))]),n("v-uni-text",{staticClass:"userTime"},[t._v(t._s(e.publishTimeText))])],1)],1)})),1):t._e(),0==t.list.length&&0==t.list1.length?n("v-uni-view",{staticClass:"emptyLayout"},[n("v-uni-image",{staticClass:"emptyIcon",attrs:{src:i("cbb8").replace(/^\./,""),mode:"widthFix"}}),n("v-uni-text",{staticClass:"emptyText"},[t._v("暂无随手拍，快去添加吧")])],1):t._e()],1)},o=[]},"7d45":function(t,e,i){"use strict";i.r(e);var n=i("d3b9"),r=i.n(n);for(var o in n)"default"!==o&&function(t){i.d(e,t,(function(){return n[t]}))}(o);e["default"]=r.a},"96cf":function(t,e){!function(e){"use strict";var i,n=Object.prototype,r=n.hasOwnProperty,o="function"===typeof Symbol?Symbol:{},a=o.iterator||"@@iterator",s=o.asyncIterator||"@@asyncIterator",c=o.toStringTag||"@@toStringTag",l="object"===typeof t,u=e.regeneratorRuntime;if(u)l&&(t.exports=u);else{u=e.regeneratorRuntime=l?t.exports:{},u.wrap=w;var h="suspendedStart",f="suspendedYield",d="executing",p="completed",g={},v={};v[a]=function(){return this};var m=Object.getPrototypeOf,b=m&&m(m(T([])));b&&b!==n&&r.call(b,a)&&(v=b);var y=_.prototype=k.prototype=Object.create(v);L.prototype=y.constructor=_,_.constructor=L,_[c]=L.displayName="GeneratorFunction",u.isGeneratorFunction=function(t){var e="function"===typeof t&&t.constructor;return!!e&&(e===L||"GeneratorFunction"===(e.displayName||e.name))},u.mark=function(t){return Object.setPrototypeOf?Object.setPrototypeOf(t,_):(t.__proto__=_,c in t||(t[c]="GeneratorFunction")),t.prototype=Object.create(y),t},u.awrap=function(t){return{__await:t}},P(C.prototype),C.prototype[s]=function(){return this},u.AsyncIterator=C,u.async=function(t,e,i,n){var r=new C(w(t,e,i,n));return u.isGeneratorFunction(e)?r:r.next().then((function(t){return t.done?t.value:r.next()}))},P(y),y[c]="Generator",y[a]=function(){return this},y.toString=function(){return"[object Generator]"},u.keys=function(t){var e=[];for(var i in t)e.push(i);return e.reverse(),function i(){while(e.length){var n=e.pop();if(n in t)return i.value=n,i.done=!1,i}return i.done=!0,i}},u.values=T,S.prototype={constructor:S,reset:function(t){if(this.prev=0,this.next=0,this.sent=this._sent=i,this.done=!1,this.delegate=null,this.method="next",this.arg=i,this.tryEntries.forEach(j),!t)for(var e in this)"t"===e.charAt(0)&&r.call(this,e)&&!isNaN(+e.slice(1))&&(this[e]=i)},stop:function(){this.done=!0;var t=this.tryEntries[0],e=t.completion;if("throw"===e.type)throw e.arg;return this.rval},dispatchException:function(t){if(this.done)throw t;var e=this;function n(n,r){return s.type="throw",s.arg=t,e.next=n,r&&(e.method="next",e.arg=i),!!r}for(var o=this.tryEntries.length-1;o>=0;--o){var a=this.tryEntries[o],s=a.completion;if("root"===a.tryLoc)return n("end");if(a.tryLoc<=this.prev){var c=r.call(a,"catchLoc"),l=r.call(a,"finallyLoc");if(c&&l){if(this.prev<a.catchLoc)return n(a.catchLoc,!0);if(this.prev<a.finallyLoc)return n(a.finallyLoc)}else if(c){if(this.prev<a.catchLoc)return n(a.catchLoc,!0)}else{if(!l)throw new Error("try statement without catch or finally");if(this.prev<a.finallyLoc)return n(a.finallyLoc)}}}},abrupt:function(t,e){for(var i=this.tryEntries.length-1;i>=0;--i){var n=this.tryEntries[i];if(n.tryLoc<=this.prev&&r.call(n,"finallyLoc")&&this.prev<n.finallyLoc){var o=n;break}}o&&("break"===t||"continue"===t)&&o.tryLoc<=e&&e<=o.finallyLoc&&(o=null);var a=o?o.completion:{};return a.type=t,a.arg=e,o?(this.method="next",this.next=o.finallyLoc,g):this.complete(a)},complete:function(t,e){if("throw"===t.type)throw t.arg;return"break"===t.type||"continue"===t.type?this.next=t.arg:"return"===t.type?(this.rval=this.arg=t.arg,this.method="return",this.next="end"):"normal"===t.type&&e&&(this.next=e),g},finish:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var i=this.tryEntries[e];if(i.finallyLoc===t)return this.complete(i.completion,i.afterLoc),j(i),g}},catch:function(t){for(var e=this.tryEntries.length-1;e>=0;--e){var i=this.tryEntries[e];if(i.tryLoc===t){var n=i.completion;if("throw"===n.type){var r=n.arg;j(i)}return r}}throw new Error("illegal catch attempt")},delegateYield:function(t,e,n){return this.delegate={iterator:T(t),resultName:e,nextLoc:n},"next"===this.method&&(this.arg=i),g}}}function w(t,e,i,n){var r=e&&e.prototype instanceof k?e:k,o=Object.create(r.prototype),a=new S(n||[]);return o._invoke=E(t,i,a),o}function x(t,e,i){try{return{type:"normal",arg:t.call(e,i)}}catch(n){return{type:"throw",arg:n}}}function k(){}function L(){}function _(){}function P(t){["next","throw","return"].forEach((function(e){t[e]=function(t){return this._invoke(e,t)}}))}function C(t){function e(i,n,o,a){var s=x(t[i],t,n);if("throw"!==s.type){var c=s.arg,l=c.value;return l&&"object"===typeof l&&r.call(l,"__await")?Promise.resolve(l.__await).then((function(t){e("next",t,o,a)}),(function(t){e("throw",t,o,a)})):Promise.resolve(l).then((function(t){c.value=t,o(c)}),(function(t){return e("throw",t,o,a)}))}a(s.arg)}var i;function n(t,n){function r(){return new Promise((function(i,r){e(t,n,i,r)}))}return i=i?i.then(r,r):r()}this._invoke=n}function E(t,e,i){var n=h;return function(r,o){if(n===d)throw new Error("Generator is already running");if(n===p){if("throw"===r)throw o;return z()}i.method=r,i.arg=o;while(1){var a=i.delegate;if(a){var s=I(a,i);if(s){if(s===g)continue;return s}}if("next"===i.method)i.sent=i._sent=i.arg;else if("throw"===i.method){if(n===h)throw n=p,i.arg;i.dispatchException(i.arg)}else"return"===i.method&&i.abrupt("return",i.arg);n=d;var c=x(t,e,i);if("normal"===c.type){if(n=i.done?p:f,c.arg===g)continue;return{value:c.arg,done:i.done}}"throw"===c.type&&(n=p,i.method="throw",i.arg=c.arg)}}}function I(t,e){var n=t.iterator[e.method];if(n===i){if(e.delegate=null,"throw"===e.method){if(t.iterator.return&&(e.method="return",e.arg=i,I(t,e),"throw"===e.method))return g;e.method="throw",e.arg=new TypeError("The iterator does not provide a 'throw' method")}return g}var r=x(n,t.iterator,e.arg);if("throw"===r.type)return e.method="throw",e.arg=r.arg,e.delegate=null,g;var o=r.arg;return o?o.done?(e[t.resultName]=o.value,e.next=t.nextLoc,"return"!==e.method&&(e.method="next",e.arg=i),e.delegate=null,g):o:(e.method="throw",e.arg=new TypeError("iterator result is not an object"),e.delegate=null,g)}function N(t){var e={tryLoc:t[0]};1 in t&&(e.catchLoc=t[1]),2 in t&&(e.finallyLoc=t[2],e.afterLoc=t[3]),this.tryEntries.push(e)}function j(t){var e=t.completion||{};e.type="normal",delete e.arg,t.completion=e}function S(t){this.tryEntries=[{tryLoc:"root"}],t.forEach(N,this),this.reset(!0)}function T(t){if(t){var e=t[a];if(e)return e.call(t);if("function"===typeof t.next)return t;if(!isNaN(t.length)){var n=-1,o=function e(){while(++n<t.length)if(r.call(t,n))return e.value=t[n],e.done=!1,e;return e.value=i,e.done=!0,e};return o.next=o}}return{next:z}}function z(){return{value:i,done:!0}}}(function(){return this||"object"===typeof self&&self}()||Function("return this")())},a433:function(t,e,i){var n=i("b9ec");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var r=i("4f06").default;r("30107a9e",n,!0,{sourceMap:!1,shadowMode:!1})},b9ec:function(t,e,i){var n=i("24fb");e=n(!1),e.push([t.i,"uni-page-body[data-v-8cab5c6e]{background:#fff}.baseLayout[data-v-8cab5c6e]{padding:%?24?%;display:-webkit-box;display:-webkit-flex;display:flex;position:relative}.cloumnLayout[data-v-8cab5c6e]{width:50%;font-size:%?28?%;font-weight:400;line-height:%?40?%;color:#222}.contentLayout[data-v-8cab5c6e]{width:95%;padding-top:%?14?%;overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:2;-webkit-box-orient:vertical}.item[data-v-8cab5c6e]{position:relative;width:100%;margin-bottom:%?32?%;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;-webkit-box-align:center;-webkit-align-items:center;align-items:center}.h400[data-v-8cab5c6e]{width:95%;height:%?400?%;-webkit-border-radius:8px;border-radius:8px}.h320[data-v-8cab5c6e]{width:95%;height:%?320?%;-webkit-border-radius:8px;border-radius:8px}.userInfoLayout[data-v-8cab5c6e]{display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:horizontal;-webkit-box-direction:normal;-webkit-flex-direction:row;flex-direction:row;-webkit-box-align:center;-webkit-align-items:center;align-items:center;margin-top:%?4?%;width:95%}.userHeaderIcon[data-v-8cab5c6e]{-webkit-flex-shrink:0;flex-shrink:0;width:%?32?%;height:%?32?%!important;-webkit-border-radius:50%;border-radius:50%}.userName[data-v-8cab5c6e]{margin-left:%?12?%;font-size:%?22?%;font-weight:400;width:%?80?%;color:#999;overflow:hidden;text-overflow:ellipsis;display:-webkit-box;-webkit-line-clamp:1;-webkit-box-orient:vertical}.userTime[data-v-8cab5c6e]{-webkit-box-flex:1;-webkit-flex-grow:1;flex-grow:1;font-size:%?20?%;font-weight:400;color:#999;text-align:right}.textLayout[data-v-8cab5c6e]{display:-webkit-box;display:-webkit-flex;display:flex}.multIcon[data-v-8cab5c6e]{position:absolute;top:%?22?%;right:%?26?%;width:%?24?%;z-index:2}.gradient[data-v-8cab5c6e]{position:absolute;top:0;background:-webkit-gradient(linear,left top,left bottom,from(rgba(0,0,0,.3)),to(transparent));background:-webkit-linear-gradient(top,rgba(0,0,0,.3),transparent);background:linear-gradient(180deg,rgba(0,0,0,.3),transparent);z-index:1}.addLifePhoto[data-v-8cab5c6e]{width:%?122?%;height:%?122?%!important;position:fixed;bottom:%?170?%;right:%?24?%;z-index:2}.emptyLayout[data-v-8cab5c6e]{width:100%;height:100vh;display:-webkit-box;display:-webkit-flex;display:flex;margin-top:%?0?%;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;-webkit-box-pack:center;-webkit-justify-content:center;justify-content:center;-webkit-box-align:center;-webkit-align-items:center;align-items:center}.emptyIcon[data-v-8cab5c6e]{margin-bottom:%?16?%;width:%?200?%;height:%?200?%;display:block}.emptyText[data-v-8cab5c6e]{font-size:%?28?%;color:#999}body.?%PAGE?%[data-v-8cab5c6e]{background:#fff}",""]),t.exports=e},cbb8:function(t,e,i){t.exports=i.p+"static/img/air.80696ab9.png"},d3b9:function(t,e,i){"use strict";var n=i("4ea4");i("99af"),Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("96cf");var r=n(i("1da1")),o=n(i("bc81")),a={data:function(){return{list:[],list1:[],pageNo:1,pageSize:10,hasMoreInfo:!0,listAll:[]}},onShow:function(){this.pageNo=1,this.pageSize=10,this.hasMoreInfo=!0,this.patListPublicByPage({communityCode:uni.getStorageSync("communityCode"),pageNo:this.pageNo,pageSize:this.pageSize})},onReachBottom:function(){if(console.log("到达最低加载！"),this.hasMoreInfo){var t={communityCode:uni.getStorageSync("communityCode"),pageNo:this.pageNo,pageSize:this.pageSize};this.patListPublicByPage(t)}},onPullDownRefresh:function(){this.pageNo=1,this.hasMoreInfo=!0;var t={communityCode:uni.getStorageSync("communityCode"),pageNo:this.pageNo,pageSize:this.pageSize};this.patListPublicByPage(t)},methods:{jumpTo:function(t){uni.navigateTo({url:"/pages/lifePhoto/view?type=1&patId=".concat(t.patId)})},dealName:function(t){return t.length>1?t.substring(0,1)+"*"+t.substring(2):t},jumpToAdd:function(){uni.navigateTo({url:"/pages/lifePhoto/add"})},patListPublicByPage:function(t){var e=this;return(0,r.default)(regeneratorRuntime.mark((function i(){var n,r;return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:return i.next=2,o.default.patListPublicByPage(t);case 2:for(n=i.sent,uni.stopPullDownRefresh(),1==e.pageNo?e.listAll=n.list:e.listAll=e.listAll.concat(n.list),n&&n.list&&n.list.length<10?e.hasMoreInfo=!1:n&&n.list&&10==n.list.length||console.log("未处理，需要测试"),e.pageNo++,e.list=[],e.list1=[],r=0;r<e.listAll.length;r++)r%2===0?e.list.push(e.listAll[r]):e.list1.push(e.listAll[r]);case 10:case"end":return i.stop()}}),i)})))()}}};e.default=a},f5f6:function(t,e,i){"use strict";var n=i("a433"),r=i.n(n);r.a}}]);