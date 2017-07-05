#springboot7===>springboot结合freeMarker返回html
#author:zhoucong 			QQ:2632652610



结构目录相关解释：
Src/main/resources/static： 静态文件【html,Css,js等其他】==此处的html或jsp等其他可直接访问
Src/main/resources/templates:目录下的文件是安全的，不可直接访问
Pom文件相关解释如下：
# 这是重点， 会过滤.html后缀的文件【必配置】
spring.freemarker.suffix: .html 
#spring boot 默认的页面模板存放目录  【此处亦可不配置】
spring.freemarker.template-loader-path: classpath:/templates/    
spring.freemarker.cache: false 
mybatis:
  mapper-locations: classpath:mapper/*.xml            #XML文件
  
  