/**
 * 用于登录页面跳转，及登录之后回到当前页面
 */
function goLogin(){
	//console.debug(window.document.location.pathname + getUrlArgStr())
	window.location.href="/BRHP/user/goLogin?beforeLoginUrl="+window.document.location.pathname + getUrlArgStr();
}

function goRegister(){
	window.location.href="/BRHP/user/register";
}

function logout(){
	window.location.href="/BRHP/user/logout";
}

/**
 * 用于获取请求参数
 */
function getUrlArgStr(){  
    var q=location.search.substr(1);  
    var qs=q.split('&');  
    var argStr='?';  
    if(qs){  
        for(var i=0;i<qs.length;i++){  
            argStr+=qs[i].substring(0,qs[i].indexOf('='))+'='+qs[i].substring(qs[i].indexOf('=')+1)+'&';  
        }  
    }  
    var returnStr = argStr.substring(0,argStr.length-1)
    return returnStr;  
}  