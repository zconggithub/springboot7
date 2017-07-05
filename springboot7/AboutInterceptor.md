#springboot7===>springboot结合freeMarker返回html
#author:zhoucong 			QQ:2632652610
#【拦截器的运用】

1.3 拦截器的应用场景

　　拦截器本质上是面向切面编程（AOP），符合横切关注点的功能都可以放在拦截器中来实现，主要的应用场景包括：

登录验证，判断用户是否登录。
权限验证，判断用户是否有权限访问资源。
日志记录，记录请求日志，以便统计请求访问量。
处理cookie、本地化、国际化、主题等。
性能监控，监控请求处理时长等。
2. 原理

2.1 工作原理

　　拦截器不是Filter，却实现了Filter的功能，其原理在于：

所有的拦截器(Interceptor)和处理器(Handler)都注册在HandlerMapping中。
Spring MVC中所有的请求都是由DispatcherServlet分发的。
当请求进入DispatcherServlet.doDispatch()时候，首先会得到处理该请求的Handler（即Controller中对应的方法）以及所有拦截该请求的拦截器。拦截器就是在这里被调用开始工作的。
2.2 拦截器工作流程

　　一个拦截器，只有preHandle方法返回true，postHandle、afterCompletion才有可能被执行；如果preHandle方法返回false，则该拦截器的postHandle、afterCompletion必然不会被执行。

　　假设我们有两个拦截器，例如叫Interceptor1和Interceptor2，当一个请求过来，正常的流程和中断的流程分别如下。

2.2.1正常流程

　　注意两个拦截器在执行preHandle方法和执行postHandle、afterCompletion方法时，顺序是颠倒的。

1.    Interceptor1.preHandle

2.    Interceptor2.preHandle

3.    Controller处理请求

4.    Interceptor2.postHandle

5.    Interceptor1.postHandle

6.    渲染视图

7.    Interceptor2.afterCompletion

8.    Interceptor1.afterCompletion
2.2.2 中断流程

　　假设执行Interceptor2.preHandle中报错，那么流程被中断，之前被执行过的拦截器的afterCompletion仍然会执行。在本例中，即执行了Interceptor1.afterCompletion。

1.    Interceptor1.preHandle

2.    Interceptor2.preHandle

//中间流程被中断，不再执行

3.    Interceptor1.afterCompletion
2.3 和Filter共存时的执行顺序

　　拦截器是在DispatcherServlet这个servlet中执行的，因此所有的请求最先进入Filter，最后离开Filter。其顺序如下。

Filter->Interceptor.preHandle->Handler->Interceptor.postHandle->Interceptor.afterCompletion->Filter