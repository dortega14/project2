(this["webpackJsonpproject-2"]=this["webpackJsonpproject-2"]||[]).push([[0],{107:function(e,t,a){},108:function(e,t,a){"use strict";a.r(t);var n=a(0),r=a.n(n),s=a(24),l=a.n(s),o=(a(65),a(66),a(29),a(27),a(9));var c=function(){return r.a.createElement("div",{className:"MainButtons"},r.a.createElement("header",null,r.a.createElement("nav",null,r.a.createElement("ul",{className:"LinkElements"},r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/Login"}},"Login")),r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/register"}},"Register"))))))},i=a(21),u=a(5),m=a.n(u),p=a(8),d=a(54),f=a.n(d).a.create({baseURL:"http://10.41.29.161:8080/project2"}),E=f,h=function(e,t,a){console.log(a);var n={offset:e,limit:t,user:a};return console.log(n),f.get("post"+a.userId+".app")},g=function(){var e=Object(p.a)(m.a.mark((function e(t,a){var n,r;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return n={username:t,password:a},e.next=3,f.post("login.app",n);case 3:return r=e.sent,console.log(r),e.abrupt("return",r);case 6:case"end":return e.stop()}}),e)})));return function(t,a){return e.apply(this,arguments)}}(),b="MAIN_SUCCESSFUL_GET_PAGE_POSTS",v="MAIN_UNSUCCESSFUL_GET_PAGE_POSTS",O="LOGIN_LOGIN_SUCCESS",y="LOGIN_LOGIN_UNSUCCESS",S="LOGIN_LOGOUT",j=function(){return function(e){e({type:S,payload:{loginMessege:"logged out!"}})}},w=a(6),k=a(11),C=a(12),N=a(14),P=a(13),L=a(15),U=a(23),x=a(109),I=a(110),F=a(111),_=a(112),T=a(113),R=a(114),M=a(115),A=a(116),G=a(117),B=a(118),D=a(55),H=function(e){function t(){return Object(k.a)(this,t),Object(N.a)(this,Object(P.a)(t).apply(this,arguments))}return Object(L.a)(t,e),Object(C.a)(t,[{key:"render",value:function(){var e={height:"390",width:"640",playerVars:{start:this.props.youtubeLinks.time}};return r.a.createElement(r.a.Fragment,null,r.a.createElement(D.a,{videoId:this.props.youtubeLinks.ytlink,opts:e}))}}]),t}(r.a.PureComponent),V=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).updateNewComment=function(e){a.setState(Object(w.a)({},a.state,{newComment:e.target.value}))},a.state={newComment:""},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"cardTextBuilder",value:function(){return"Ingredients:  ".concat(this.props.post.ingredients,"\n\r\n            Recipe:  ").concat(this.props.post.recipe,"\n\r\n            Submitted on: ").concat(new Date(this.props.post.postSubmitted)," by ").concat(this.props.post.postUser.firstName)}},{key:"submitComment",value:function(e){e.preventDefault();var t,a={commentId:0,comment:this.state.newComment,commentPost:this.props.post,commentUser:this.props.currUser};t=a,E.post("newcomm.app",t),console.log("submitted comment")}},{key:"submitLike",value:function(e){var t,a={likeUser:this.props.currUser,likePost:this.props.post,likeLikeType:{likeTypeId:e,likeType:1===e?"Tasty":2===e?"Looks good":"Needs salt"}};t=a,E.post("newlike.app",t)}},{key:"render",value:function(){var e=this;return r.a.createElement(r.a.Fragment,null,r.a.createElement(x.a,null,r.a.createElement(I.a,null,r.a.createElement(F.a,null,r.a.createElement(_.a,null,this.props.post.title),r.a.createElement(T.a,null,this.props.post.postCategory.category),r.a.createElement(R.a,null,this.cardTextBuilder())))),r.a.createElement(x.a,null,r.a.createElement(M.a,null,r.a.createElement(A.a,{color:"success",onClick:function(){return e.submitLike(1)}},"Tasty"),r.a.createElement(A.a,{color:"warning",onClick:function(){return e.submitLike(2)}},"Looks Good"),r.a.createElement(A.a,{color:"danger",onClick:function(){return e.submitLike(3)}},"Needs Salt"))),r.a.createElement(x.a,null,r.a.createElement(G.a,{onSubmit:this.submitComment},r.a.createElement(B.a,{type:"textarea",placeholder:"What do you think about this dish?",value:this.state.newComment,onChange:this.updateNewComment}),r.a.createElement(B.a,{type:"submit",value:"Leave Comment"}))),r.a.createElement(x.a,null,this.props.post.postYtLink&&r.a.createElement(H,{youtubeLinks:this.props.post.postYtLink})))}}]),t}(r.a.Component),W=a(119),Y=a(120),z=a(121),J=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).pageTurnForward=function(){var e=a.state.offset+a.state.limit;a.props.getAllPosts(a.state.limit,e),a.setState(Object(w.a)({},a.state,{offset:e}))},a.pageTurnFirst=function(){a.props.getAllPosts(a.state.limit,0),a.setState(Object(w.a)({},a.state,{offset:0}))},a.pageTurnBack=function(){if(a.state.offset>0){var e=a.state.offset-a.state.limit;a.props.getAllPosts(a.state.limit,e),a.setState(Object(w.a)({},a.state,{offset:e}))}},a.state={limit:10,offset:0},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"componentDidMount",value:function(){var e=Object(p.a)(m.a.mark((function e(){return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:this.props.user&&0===this.props.allPosts.length&&this.props.getAllPosts(10,0);case 1:case"end":return e.stop()}}),e,this)})));return function(){return e.apply(this,arguments)}}()},{key:"render",value:function(){var e=this;if(this.props.user){var t=this.props.allPosts.map((function(t){return r.a.createElement(r.a.Fragment,null,r.a.createElement(V,{post:t,currUser:e.props.user,parent:"hp",key:t.postId}),r.a.createElement("br",null))}));return r.a.createElement("div",{className:"MainButtons"},r.a.createElement("header",null,r.a.createElement("nav",null,r.a.createElement("ul",null,r.a.createElement("li",null,r.a.createElement(o.b,{to:{pathname:"/profile"}},"My Profile")),r.a.createElement("li",null,r.a.createElement(o.b,{to:{pathname:"/"},onClick:this.props.logout},"Logout"))))),r.a.createElement("div",null,t,r.a.createElement(W.a,{"aria-label":"Page navigation example"},r.a.createElement(Y.a,{disabled:!0},r.a.createElement(z.a,{first:!0,onClick:this.pageTurnFirst})),r.a.createElement(Y.a,{disabled:!this.state.offset,onClick:this.pageTurnBack},r.a.createElement(z.a,{previous:!0})),r.a.createElement(Y.a,{onClick:this.pageTurnForward},r.a.createElement(z.a,{next:!0})),r.a.createElement(Y.a,null,r.a.createElement(z.a,{last:!0})))))}return r.a.createElement(U.a,{to:"/login"})}}]),t}(r.a.Component),X={getAllPosts:function(e,t){return function(){var e=Object(p.a)(m.a.mark((function e(t){var a;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:return e.next=2,f.get("postlist.app");case 2:a=e.sent,e.t0=a.status,e.next=200===e.t0?6:202===e.t0?6:8;break;case 6:return t({type:b,payload:{allPosts:a.data}}),e.abrupt("break",9);case 8:t({type:v});case 9:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}()},logout:j},$=Object(i.b)((function(e){return{user:e.CurrUserState.currUser,allPosts:e.MainPostState.allPosts}}),X)(J),q="POST_SUCCESSFUL_GET_PAGE_POSTS",K="POST_UNSUCCESSFUL_GET_PAGE_POSTS",Q=a(122),Z=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).updateIngredients=function(e){a.setState(Object(w.a)({},a.state,{ingredients:e.target.value}))},a.updateImage=function(e){a.setState(Object(w.a)({},a.state,{image:e.target.value}))},a.updateRecipe=function(e){a.setState(Object(w.a)({},a.state,{recipe:e.target.value}))},a.updateTitle=function(e){a.setState(Object(w.a)({},a.state,{title:e.target.value}))},a.updateCategory=function(e){a.setState(Object(w.a)({},a.state,{category:e.target.value}))},a.submitRecipe=function(){var e=Object(p.a)(m.a.mark((function e(t){var n;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t.preventDefault(),n={postId:0,title:a.state.title,postSubmitted:new Date,recipe:a.state.recipe,ingredients:a.state.ingredients,postCategory:{categoryId:a.state.category,category:1===a.state.category?"Breakfast":2===a.state.category?"Lunch":"Dinner"},postComment:void 0,postUser:a.props.currUser,postYtLink:void 0},r=n,E.post("newpost.app",r);case 3:case"end":return e.stop()}var r}),e)})));return function(t){return e.apply(this,arguments)}}(),a.state={image:null,ingredients:"",recipe:"",title:"",category:0},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"render",value:function(){return r.a.createElement(G.a,{onSubmit:this.submitRecipe,encType:"multipart"},r.a.createElement(B.a,{type:"text",placeholder:"ingredients",onChange:this.updateIngredients}),r.a.createElement(B.a,{type:"text",placeholder:"recipe",onChange:this.updateRecipe}),r.a.createElement(B.a,{type:"text",placeholder:"title",onChange:this.updateTitle}),r.a.createElement(B.a,{type:"select",onChange:this.updateCategory},r.a.createElement("option",{value:1},"Breakfast"),r.a.createElement("option",{value:2},"Lunch"),r.a.createElement("option",{value:3},"Dinner")),r.a.createElement(B.a,{type:"submit",value:"Post Recipe"}))}}]),t}(r.a.Component),ee=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).pageTurnForward=function(){var e=a.state.offset+a.state.limit;a.props.getAllPosts(a.state.limit,e,a.props.user),a.setState(Object(w.a)({},a.state,{offset:e}))},a.pageTurnFirst=function(){a.props.getAllPosts(a.state.limit,0,a.props.user),a.setState(Object(w.a)({},a.state,{offset:0}))},a.pageTurnBack=function(){if(a.state.offset>0){var e=a.state.offset-a.state.limit;a.props.getAllPosts(a.state.limit,e,a.props.user),a.setState(Object(w.a)({},a.state,{offset:e}))}},a.toggleSubmitCard=function(){a.setState(Object(w.a)({},a.state,{toggle:!a.state.toggle}))},a.state={limit:10,offset:0,toggle:!1},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"componentDidMount",value:function(){var e=Object(p.a)(m.a.mark((function e(){return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:this.props.user&&0===this.props.allPosts.length&&this.props.getAllPosts(10,0,this.props.user);case 1:case"end":return e.stop()}}),e,this)})));return function(){return e.apply(this,arguments)}}()},{key:"render",value:function(){var e=this;if(this.props.user.username){var t=this.props.allPosts.map((function(t){return r.a.createElement(r.a.Fragment,null,r.a.createElement(V,{post:t,currUser:e.props.user,parent:"pp",key:t.postId}),r.a.createElement("br",null))}));return r.a.createElement("div",{className:"MainButtons"},r.a.createElement("header",null,r.a.createElement("nav",null,r.a.createElement("ul",null,r.a.createElement("li",null,r.a.createElement(o.b,{to:{pathname:"/home"}},"Home")),r.a.createElement("li",null,r.a.createElement(o.b,{to:{pathname:"/"},onClick:this.props.logout},"Logout"))))),r.a.createElement("br",null),r.a.createElement("div",null,r.a.createElement(A.a,{color:"primary",onClick:this.toggleSubmitCard},"Add post"),r.a.createElement(Q.a,{isOpen:this.state.toggle},r.a.createElement(Z,{currUser:this.props.user}))),r.a.createElement("div",null,t),r.a.createElement("div",null,r.a.createElement(W.a,{"aria-label":"Page navigation example"},r.a.createElement(Y.a,{disabled:!0},r.a.createElement(z.a,{first:!0,onClick:this.pageTurnFirst})),r.a.createElement(Y.a,{disabled:!this.state.offset,onClick:this.pageTurnBack},r.a.createElement(z.a,{previous:!0})),r.a.createElement(Y.a,{onClick:this.pageTurnForward},r.a.createElement(z.a,{next:!0})),r.a.createElement(Y.a,null,r.a.createElement(z.a,{last:!0})))))}return r.a.createElement(U.a,{to:"/login"})}}]),t}(r.a.Component),te={getAllPosts:function(e,t,a){return function(){var n=Object(p.a)(m.a.mark((function n(r){var s;return m.a.wrap((function(n){for(;;)switch(n.prev=n.next){case 0:return n.prev=0,n.next=3,h(t,e,a);case 3:s=n.sent,r({type:q,payload:{allPosts:s.data}}),n.next=10;break;case 7:n.prev=7,n.t0=n.catch(0),r({type:K});case 10:case"end":return n.stop()}}),n,null,[[0,7]])})));return function(e){return n.apply(this,arguments)}}()},logout:j},ae=Object(i.b)((function(e){return{user:e.CurrUserState.currUser,allPosts:e.PostState.allPosts}}),te)(ee),ne=a(25),re=(a(107),function(e){var t=Object(n.useState)(""),a=Object(ne.a)(t,2),s=a[0],l=a[1],c=Object(n.useState)(""),i=Object(ne.a)(c,2),u=i[0],m=i[1],p=Object(n.useState)(""),d=Object(ne.a)(p,2),E=d[0],h=d[1],g=Object(n.useState)(""),b=Object(ne.a)(g,2),v=b[0],O=b[1],y=Object(n.useState)(""),S=Object(ne.a)(y,2),j=S[0],w=S[1];return r.a.createElement("div",null,r.a.createElement("header",{className:"MainButtons"},r.a.createElement("nav",null,r.a.createElement("ul",{className:"LinkElements"},r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/main"}},"Home")),r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/Login"}},"Login"))))),r.a.createElement("div",{className:"container"},r.a.createElement("form",{id:"RegisterForm",className:"form-horizontal",onSubmit:function(){return(e={user_id:0,email:s,username:u,password:E,firstName:v,lastName:j},f.post("/newuser.app",e)).then((function(e){return console.log(e.data)}));var e}},r.a.createElement("div",{id:"RegisterElements",className:"row"},r.a.createElement("div",{className:"TextForRegister"},r.a.createElement("p",null,"Indulge in an exciting experience "),r.a.createElement("p",null,"by becoming a memeber of"),r.a.createElement("p",null,"the recipe family")),r.a.createElement("div",{id:"FirstName",className:"form-group col-md-4"},r.a.createElement("label",null,"First Name"),r.a.createElement("input",{className:"form-control input-lg",placeholder:"first name",onChange:function(e){return O(e.target.value)}})),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",null,"Last Name"),r.a.createElement("input",{className:"form-control input-lg",placeholder:"last name",onChange:function(e){return w(e.target.value)}})),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",null,"User Name"),r.a.createElement("input",{className:"form-control input-lg",placeholder:"user name",onChange:function(e){return m(e.target.value)}})),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",{htmlFor:"exampleInputEmail1"},"Email address "),r.a.createElement("input",{type:"email",className:"form-control input-lg",id:"exampleInputEmail1","aria-describedby":"emailHelp",placeholder:"Enter email",onChange:function(e){return l(e.target.value)}}),r.a.createElement("small",{id:"emailHelp",className:"form-text text-muted"})),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",{htmlFor:"exampleInputPassword1"},"Password"),r.a.createElement("input",{type:"password",className:"form-control input-lg",id:"exampleInputPassword1",placeholder:"Password",onChange:function(e){return h(e.target.value)}}),r.a.createElement("button",{id:"SubmitButton",type:"submit",className:"btn btn-primary"},"Sign Up"))))),r.a.createElement("div",{className:"SpaceNeededDiv"}))}),se=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).updateUsername=function(e){a.setState(Object(w.a)({},a.state,{username:e.target.value}))},a.updatePassword=function(e){a.setState(Object(w.a)({},a.state,{password:e.target.value}))},a.submitLogin=function(){var e=Object(p.a)(m.a.mark((function e(t){return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t.preventDefault(),a.props.updateCurrentUser(a.state.username,a.state.password);case 2:case"end":return e.stop()}}),e)})));return function(t){return e.apply(this,arguments)}}(),a.state={username:"",password:""},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"render",value:function(){return r.a.createElement("div",null,r.a.createElement("header",{className:"MainButtons"},r.a.createElement("nav",null,r.a.createElement("ul",{className:"LinkElements"},r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/main"}},"Main")),r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/home"}},"Home")),r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/register"}},"Register")),r.a.createElement("li",null,r.a.createElement(o.b,{className:"mainLink",to:{pathname:"/profile"}},"Profile"))))),r.a.createElement("div",{className:"container"},r.a.createElement("form",{id:"LoginForm",className:"form-horizontal",onSubmit:this.submitLogin},r.a.createElement("div",{id:"LoginElements",className:"row"},r.a.createElement("div",{className:"TextForLogin"},r.a.createElement("p",null,"Share your favorite recipies "),r.a.createElement("p",null,"with friends and family")),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",{id:"EmailInput",htmlFor:"exampleInputEmail1"},"Username"),r.a.createElement("input",{type:"text",className:"form-control input-lg",id:"username","aria-describedby":"usernameField",placeholder:"Username",value:this.state.username,onChange:this.updateUsername}),r.a.createElement("small",{id:"emailHelp",className:"form-text text-muted"})),r.a.createElement("div",{className:"form-group col-md-4"},r.a.createElement("label",{htmlFor:"exampleInputPassword1"},"Password"),r.a.createElement("input",{type:"password",className:"form-control input-lg",id:"exampleInputPassword1",placeholder:"Password",value:this.state.password,onChange:this.updatePassword}),r.a.createElement("button",{onClick:le,id:"SubmitButton",type:"submit",className:"btn btn-primary"},"Submit")))),r.a.createElement(o.b,{to:{pathname:"/forgot"}},"Forgot password?"),r.a.createElement("p",null,this.props.loginMessage)))}}]),t}(r.a.Component);function le(){}var oe={updateCurrentUser:function(e,t){return function(){var a=Object(p.a)(m.a.mark((function a(n){var r;return m.a.wrap((function(a){for(;;)switch(a.prev=a.next){case 0:return a.next=2,g(e,t);case 2:r=a.sent,a.t0=r.status,a.next=200===a.t0?6:202===a.t0?6:401===a.t0?8:9;break;case 6:return n({type:O,payload:{currUser:r.data}}),a.abrupt("break",9);case 8:n({type:y,payload:{loginMessege:r.status+" login failed!"}});case 9:case"end":return a.stop()}}),a)})));return function(e){return a.apply(this,arguments)}}()}},ce=Object(i.b)((function(e){return{loginMessage:e.CurrUserState.loginMessage}}),oe)(se),ie=a(22),ue=a(58),me=a.n(ue),pe=a(59),de={currUser:{userId:0,username:"",password:"",firstName:"",lastName:"",email:""},loginMessage:""},fe={allPosts:[]},Ee={allPosts:[]},he="PROFILE_SUCCESSFUL_GET_PROFILE",ge="PROFILE_UNSUCCESSFUL_GET_PROFILE",be="PROFILE_SUCCESSFUL_UPDATE_PROFILE",ve="PROFILE_UNSUCCESSFUL_UPDATE_PROFILE",Oe="PROFILE_LOGOUT_REMOVE_PROFILE",ye={profile:{profileId:0,bio:"",coverImage:null,profileUser:{userId:0,username:"",password:"",firstName:"",lastName:"",email:""}}},Se=Object(ie.c)({CurrUserState:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:de,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case O:return Object(w.a)({},e,{currUser:t.payload.currUser,loginMessage:"Login Successful!"});case y:return Object(w.a)({},e,{loginMessage:t.payload.loginMessage});case S:return de;default:return e}},PostState:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:fe,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case q:return Object(w.a)({},e,{allPosts:t.payload.allPosts});case K:default:return e}},MainPostState:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:Ee,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case b:return Object(w.a)({},e,{allPosts:t.payload.allPosts});case v:default:return e}},ProfileState:function(){var e=arguments.length>0&&void 0!==arguments[0]?arguments[0]:ye,t=arguments.length>1?arguments[1]:void 0;switch(t.type){case he:case be:return Object(w.a)({},e,{profile:t.payload.profile});case ge:case ve:return e;case Oe:return ye;default:return e}}}),je=(window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__||ie.d)(Object(ie.a)(pe.a,me.a)),we=Object(ie.e)(Se,je),ke=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).updateUsername=function(e){a.setState(Object(w.a)({},a.state,{username:e.target.value}))},a.updatePassword=function(e){a.setState(Object(w.a)({},a.state,{password:e.target.value}))},a.resetPassword=function(){var e=Object(p.a)(m.a.mark((function e(t){var n;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t.preventDefault(),n={userId:0,username:a.state.username,password:a.state.password,firstName:"",lastName:"",email:""},r=n,f.post("reeee.app",r);case 3:case"end":return e.stop()}var r}),e)})));return function(t){return e.apply(this,arguments)}}(),a.state={password:"",username:""},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(G.a,{onSubmit:this.resetPassword},r.a.createElement(B.a,{type:"text",onChange:this.updateUsername,placeholder:"username"},"username"),r.a.createElement(B.a,{type:"password",onChange:this.updatePassword,placeholder:"password"},"New Password"),r.a.createElement(B.a,{type:"submit"},"Submit new password")))}}]),t}(r.a.Component),Ce=function(e){function t(e){var a;return Object(k.a)(this,t),(a=Object(N.a)(this,Object(P.a)(t).call(this,e))).updateEmail=function(e){a.setState(Object(w.a)({},a.state,{email:e.target.value}))},a.sendRecovery=function(){var e=Object(p.a)(m.a.mark((function e(t){var n;return m.a.wrap((function(e){for(;;)switch(e.prev=e.next){case 0:t.preventDefault(),n={userId:0,username:"",password:"",firstName:"",lastName:"",email:a.state.email},r=n,console.log(r),f.post("recovery.app",r);case 3:case"end":return e.stop()}var r}),e)})));return function(t){return e.apply(this,arguments)}}(),a.state={email:""},a}return Object(L.a)(t,e),Object(C.a)(t,[{key:"render",value:function(){return r.a.createElement(r.a.Fragment,null,r.a.createElement(G.a,{onSubmit:this.sendRecovery},r.a.createElement(B.a,{type:"text",onChange:this.updateEmail,placeholder:"Enter email, please"}),r.a.createElement(B.a,{type:"submit"},"Send me the email!")))}}]),t}(r.a.Component);var Ne=function(){return r.a.createElement("div",null,r.a.createElement(i.a,{store:we},r.a.createElement(o.a,null,r.a.createElement("div",{className:"App"},r.a.createElement(U.b,{path:"/",exact:!0,component:c}),r.a.createElement(U.d,null,r.a.createElement(U.b,{path:"/main",component:c}),r.a.createElement(U.b,{path:"/Login",component:ce}),r.a.createElement(U.b,{path:"/home",component:$}),r.a.createElement(U.b,{path:"/profile",component:ae}),r.a.createElement(U.b,{path:"/register",component:re}),r.a.createElement(U.b,{path:"/resetpassword",component:ke}),r.a.createElement(U.b,{path:"/forgot",component:Ce}))))))};Boolean("localhost"===window.location.hostname||"[::1]"===window.location.hostname||window.location.hostname.match(/^127(?:\.(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)){3}$/));l.a.render(r.a.createElement(Ne,null),document.getElementById("root")),"serviceWorker"in navigator&&navigator.serviceWorker.ready.then((function(e){e.unregister()}))},29:function(e,t,a){},60:function(e,t,a){e.exports=a(108)},65:function(e,t,a){},66:function(e,t,a){}},[[60,1,2]]]);
//# sourceMappingURL=main.cc30ba66.chunk.js.map