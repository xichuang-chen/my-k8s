# resource

## pod
在Kubernetes中，与用采用单独的应用容器方式不同，pod是最小的部署单元，可以对其进行创建，调度和管理操作。
- 资源共享与通讯  
    - 一个pod中应用使用相同的网络命名空间/IP和端口空间，可以使用localhost找到彼此并进行通信
    - 处在同一个pod中的应用也能访问一样的的共享volume  
      有了Pod之后，同一个Pod内的容器可以共享很多信息，也可能需要读取同一份配置。
      比如Pod内有两个容器需要访问同一个数据库，那么我们可以把相关的配置信息写到
      ConfigMap里。那如果还有一些比较敏感的信息的话，就需要放到Secret对象中，
      它其实是一个保存在 Etcd 里的键值对数据。
      这样，你把 Credential 信息以 Secret 的方式存在 Etcd 里，
      Kubernetes 就会在你指定的 Pod（比如，Web 应用的 Pod）启动时，
      自动把 Secret 里的数据以 Volume 的方式挂载到容器里。
      
        ![img.png](img.png)
- [参考链接](https://hardocs.com/d/kubernetes/035-Pods.html)      

## Deployment
![img_1.png](img_1.png)  

Deployment用于管理Pod、ReplicaSet，可实现滚动升级和回滚应用、扩容和缩容。  

将Pod调度到目标机器上，调度完成之后，它还会继续帮我们继续监控容器是否在正确运行，
一旦出现问题，会立刻告诉我们Pod的运行不正常以及寻找可能的解决方案，
比如目标节点不可用的时候它可以快速地调度到别的机器上去。另外，如果需要对应用扩容提升
响应能力的时候，通过Deployment可以快速地进行扩展

## service
![img_2.png](img_2.png)  

试想一个问题，ReplicaSet定义了pod的数量是2，当一个pod由于某种原因停止了，ReplicaSet会新建一个pod，以确保运行中的pod数量始终是2。但每个pod都有自己的ip，前端请求不知道这个新pod的ip是什么，那前端的请求如何发送到新pod中呢？
答案是使用Service  

k8s的Service定义了一个服务的访问入口地址，前端的应用通过这个入口地址访问其背后的一组由Pod副本组成的集群实例，来自外部的访问请求被负载均衡到后端的各个容器应用上。Service与其后端Pod副本集群之间则是通过Label Selector实现关联。
请说人话：前端请求不是直接发送给Pod，而是发送到Service，Service再将请求转发给pod。


## ingress
对外提供服务类似与nginx

## 总结
- Pod被ReplicaSet管理
- ReplicaSet控制pod的数量
- ReplicaSet被Deployment管理
- Deployment控制pod应用的升级、回滚，当然也能控制pod的数量
- Service提供一个统一固定入口，负责将前端请求转发给Pod。