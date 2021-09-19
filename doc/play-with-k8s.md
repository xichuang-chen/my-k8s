# 使用 minikube 搭建本地 k8s cluster
## minikube
徒手搭建k8s环境太复杂，复杂的认证，配置环节相当折磨人，出错率相当高，
而 [minikube](https://github.com/kubernetes/minikube) 就是为解决这个问题而衍生出来的工具，它基于go语言开发，
可以在单机环境下快速搭建可用的k8s集群，非常适合测试和本地开发，
现有的大部分在线k8s实验环境也是基于 [minikube](https://github.com/kubernetes/minikube)  
[常用命令](./minikube-cmd.md)
### install
```shell
brew install minikube
```

### start cluster
[启动 k8s 集群](https://minikube.sigs.k8s.io/docs/start/)
```shell
minikube start
```
## kubectl
[kubectl](./kubectl.md) 是一个用于操作kubernetes集群的命令行接口，
通过利用kubectl的各种命令可以实现各种功能。