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

retrofit必须结合okhttp使用，retrofit生成请法庭，解析请求结果，okhttp完成请求的实现

retrofit可以结合rajava使用，rxjava功能类似AsynicTask，这使用组合请求更简洁。也可以使用组合API请求数据，比如从甲网站请求一个token，
得到正常的tpken从第二个网站获取数据，得到数据再给某个代码去处理，处理结果通过转向APP展示给客户

rajava会有内存泄漏问题，于是乎rxlifecycle横空出世，这可以把请求线程与activity的生命周期绑定

于是一个完速的retrofit框架需要引入以下库
    // Retrofit
    implementation "com.squareup.retrofit2:retrofit:2.9.0"
    implementation "com.squareup.retrofit2:converter-gson:2.9.0"
    implementation "com.squareup.retrofit2:adapter-rxjava2:2.9.0"

    // OkHttp3
    implementation "com.squareup.okhttp3:okhttp:3.10.0"
    implementation "com.squareup.okhttp3:logging-interceptor:3.10.0"

    // RxJava2
    implementation "io.reactivex.rxjava2:rxjava:2.1.9"
    implementation "io.reactivex.rxjava2:rxandroid:2.0.2"

    // RxLifecycle
    implementation "com.trello.rxlifecycle2:rxlifecycle:2.2.1"
    implementation "com.trello.rxlifecycle2:rxlifecycle-android:2.2.1"
    implementation "com.trello.rxlifecycle2:rxlifecycle-components:2.2.1"

    dagger2是一个对象注入框架，可以对代码进一步解耦，a对象引入了b，c，d对象，通过这个可以把a与引用的对象解耦

    butterknife是一个注入类控件解耦框架，可以把控件和实现解耦

    EventBus是一个事件解耦框架

