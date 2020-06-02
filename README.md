# BaseAndroid

Retrofit 可以以注解的方式生成网络请求，通过OKhttp发送实现网络协议封装，并能通过GSON把返回数据解码为BEAN，这对于封装网络API和项目解耦


Retrofit使用中，BASEURL有不少坑要注意
一是动态切换BASEURL，可以借助参数注解和http拦截器实现

二是baseurl网络接口拼接
a baseurl可以为两种形式，一种是域名或者主机名+斜杠"/", 这种baseurl格式请求路径前可以带斜杠"/"
如：
baseurl="http://wwww.baidu.com/"
api接口  /aaaa/bbbb/cccc
b.baseurl是域名或者主机名+斜杠"/"+根路径+斜杠"/"
baseurl="http://wwww.baidu.com/aaa/"
api接口路径前不加斜杠  bbb/ccc

