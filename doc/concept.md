# kubectl
- kubectl logs 
  查看指定pod的日志
  [参考链接](https://www.runoob.com)

# 各文件功能
- pod.yml  
  pod定义文件 
  
- service.yml
  创建Service定义文件（类似于反向代理）
  
- deployment.yml
  在正式环境中我们需要让一个服务不受单个节点故障的影响，并且还要根据负载变化动态调整节点数量，所以不可能像上面一样逐个管理 pod。Kubernetes 的用户通常是用 Deployment 来管理服务的。一个 deployment 可以创建指定数量的 pod 部署到各个 node 上，并可完成更新、回滚等操作。
  

