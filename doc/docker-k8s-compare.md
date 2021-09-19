
## 通过容器部署服务
默认几种方式都有基础镜像包
### 原始方法（不推荐）
1. 用基础镜像包创建容器 
```shell
   docker run [baseImage]
   ```
2. 将所要搞的服务放入容器  
3. 将该容器到处为image, 该image包含有你的服务
```shell
  docker save -o targetImage.tar
```
4. 使用该镜像run 容器，起服务

### 通过 dockerfile 
1. 编写 dockerfile
2. 通过dockerfile创建镜像
```shell
  docker build -t imageName .
```
3. 通过构建的镜像创建容器
```shell
  docker run imageName
```

### 通过docker-compose 部署服务
1. 编写 docker-compose.yml， 里边定义各个service， 可是dockerfile 可是远程镜像
2. docker-compose 拉起服务
```shell
  docker-compose up
```

### 通过k8s部署服务