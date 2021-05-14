# make image
- Dockerfile in the current directory.
  docker build -t [imageName] .
- Dockerfile in other directory
  docker build -t [imageName] -f [dockerFilePath]
- docker build -t kafka-backend .
  

# use docker-compose 启动
- docker-compose up -d   
- docker-compose up -d --build   
  重新构建镜像
  

# 查看docker container 启动日志
- docker logs [container]