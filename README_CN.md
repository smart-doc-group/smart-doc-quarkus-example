# Smart-doc Quarkus

# Prerequisites
- JDK 11
- Maven 3.6.3 +
- Visual Studio 2019(Using Native Image on Windows)
# Run locally
可以本地化运行应用，命令如下：
```
mvn compile quarkus:dev
```
测试：
```
curl -w "\n" http://localhost:8080/hello
```
# Packaging and Running

## JVM Mode
```
mvn clean package
```
## Native Mode
```
mvn clean package -Pnative
```
跳过测试
```
mvn clean package -Pnative -Dmaven.test.skip=true
```
## Creating Docker Image
JVM和Native两种模式的Dockerfile模板在`src/main/docker`, 对于native模式使用下面命令来构建。
```
mvn clean package -Pnative
docker build -f src/main/docker/Dockerfile.native -t crud-catalog-quarkus .
```
# Deploying Quarkus Application to Kubernetes
添加Kubernetes和Docker镜像扩展:
```
mvn quarkus:add-extension -Dextensions="kubernetes, container-image-docker"
```
Kubernetes extension将为我们创建三个资源对象
- Service Account
- Service
- Deployment

还会自动在application.properties中添加容器的配置项：

Property|Description
---|----
quarkus.kubernetes.part-of=todo-app	|One of the Kubernetes “recommended” labels (recommended, not required)
quarkus.container-image.registry=  quarkus.container-image.group= quarkus.container-image.name=getting-started  quarkus.container-image.tag=1.0	|Specifies the container image in the K8s deployment. Result is image: getting-started:1.0. Make sure there are no excess or trailing spaces! I specify empty registry and group parameters to obtain predictable results.
quarkus.kubernetes.service-type=NodePort	|Creates a service of type NodePort, default would be ClusterIP (doesn’t really

运行打包命令
```
mvn clean package
```
会自动在target下生成`kubernetes.yml`

自动部署
```
mvn clean package -Dquarkus.kubernetes.deploy=true
```


# Reference
https://haralduebele.github.io/2020/04/03/deploy-your-quarkus-applications-on-kubernetes-almost-automatically/
https://quarkus.io/guides/deploying-to-kubernetes