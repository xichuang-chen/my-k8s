# kubernetes Pod 通讯
## pod 间通信
### 通过 pod ip 访问     ❌
同一node下的 pod 默认路由都是 `Docker0`， 由于关联在同一网桥 `Docker0` 上，所以地址网段相同，可以直接通过
内网桥进行通信，方式就是通过 `pod ip` 可以直接访问  

问题来了，这是一个好的实践吗？
##### Replicas 数量为 1
由于 `deployment`  创建 `rs`， `rs` 再创建 `pod`, 如果 `pod` 挂掉，k8s 会再启动一个 `pod` ，此时ip变了，
也就无法访问了  
> 停，IP真的会变吗？ 答案是不会的  
> Kubernetes 网络模型确保了 Pod IP 地址的唯一性和稳定性。每个 Pod 在创建时会被分配一个唯一的 IP 地址，并且该 IP 地址在整个 Pod 生命周期中保持不变，即使 Pod 重新调度或迁移到其他节点。这意味着其他容器或服务可以始终通过 Pod 的 IP 地址准确地访问该 Pod 内的容器。
##### Replicas 数量为 多个
replicas 多个 pod 是为了负载均衡， 直接写死 pod ip , 无法进行负载均衡  
> 可能需要使用 service 了

#### pod 提供 service， 通过service 访问服务
通过service可以应对pod ip 变化问题。  
但有个疑问, 如果有些内部服务，通过service暴露出去了，这不是我期望的。 是不是通过service暴露出去了也可以做到外界访问不了？ 
> 那必须的, 可以在service中设置暴露端口类型为clusterIp, 这样就只有集群内部能用了，详看[service](../service/service-discovery.md)  

### 通过Service
#### 通过 service 的虚拟IP  ❌
#### 通过域名
Kubernetes 提供了内置的 DNS 服务，容器可以通过 DNS 域名解析来访问其他容器或服务。每个 Pod 都有一个默认的 DNS 域名，格式为 <pod-name>.<namespace>.svc.cluster.local，可以使用该域名来访问同一命名空间中的其他 Pod。

#### 通过 Service 通信，具体的过程是怎样的

## pod 内部通信
什么都是共享的，直接 `localhost:端口号` 访问  
一般很少有pod内部署多个服务，除非关系非常紧密，需要共享很多东西的时候才会这样部署
