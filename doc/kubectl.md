# kubectl
Kubernetes 提供 kubectl 是使用 Kubernetes API 与 Kubernetes 集群的控制面进行通信的命令行工具。
这个工具叫做 kubectl。

## kubectl logs 
  - 查看指定pod的日志
  - kubectl logs [-f] [-p] POD [-c CONTAINER]
  - [参考链接](https://hardocs.com/d/kubernetes/154-kubectl_logs.html)

## kubectl describe  
  - 输出指定的一个/多个资源的详细信息  
  - kubectl describe TYPE NAME_PREFIX  
    kubectl describe (-f FILENAME | TYPE [NAME_PREFIX | -l label] | TYPE/NAME)
  - [参考链接](https://hardocs.com/d/kubernetes/149-kubectl_describe.html)

## kubectl apply
  - 通过文件名或控制台输入，对资源进行配置
  - kubectl apply -f FILENAME  
    接受JSON和YAML格式的描述文件
  - [参考链接](https://hardocs.com/d/kubernetes/199-kubectl_apply.html)

## kubectl delete
  - 通过文件名、控制台输入、资源名或者label selector删除资源
  - kubectl delete ([-f FILENAME] | TYPE [(NAME | -l label | --all)])  
    接受JSON和YAML格式的描述文件
    只能指定以下参数类型中的一种：文件名、资源类型和名称、资源类型和label selector
  - [参考链接](https://hardocs.com/d/kubernetes/148-kubectl_delete.html)

## kubectl create
  - 通过文件名或控制台输入，创建资源
  - kubectl create -f FILENAME  
    接受JSON和YAML格式的描述文件
  - [参考链接](https://hardocs.com/d/kubernetes/147-kubectl_create.html)

## kubectl port-forward
  - 通过端口转发映射本地端口到指定的应用端口，从而访问集群中的应用程序(Pod)
  - kubectl port-forward [podName] 28000:8080
  - [参考链接](http://blog.itpub.net/28624388/viewspace-2156435/) 

## kubectl scale
  - 扩容或缩容 Deployment、ReplicaSet、Replication Controller或 Job 中Pod数量。
  - kubectl scale --replicas=COUNT (-f FILENAME | TYPE NAME)  
  - 执行扩容之后，service 可以侦测到，kubectl describe service [serviceName]  
    可以在Endpoints上看到有几个pod  
  - 当有多个replicas之后，service不仅可以检测到，还可以用来进行负载均衡
  - [参考链接](http://docs.kubernetes.org.cn/664.html)

# 各文件功能
- pod.yml  
  pod定义文件 
  
- service.yml
  创建Service定义文件（类似于反向代理）
  
- deployment.yml
  在正式环境中我们需要让一个服务不受单个节点故障的影响，并且还要根据负载变化动态调整
  节点数量，所以不可能像上面一样逐个管理 pod。Kubernetes 的用户通常是用 
  Deployment 来管理服务的。一个 deployment 可以创建指定数量的 pod 部署到各个 
  node 上，并可完成更新、回滚等操作。  

  

