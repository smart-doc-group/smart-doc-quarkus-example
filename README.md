# Smart-doc Quarkus

## Prerequisites
- JDK 11
- Maven 3.6.3 +
- Visual Studio 2019 (Using Native Image on Windows)

## Run Locally
The application can be run locally with the following command:
```
mvn compile quarkus:dev
```
Testing:
```
curl -w "
" http://localhost:8080/hello
```

## Packaging and Running

### JVM Mode
```
mvn clean package
```

### Native Mode
```
mvn clean package -Pnative
```
Skip tests
```
mvn clean package -Pnative -Dmaven.test.skip=true
```

### Creating Docker Image
Dockerfile templates for both JVM and Native modes are located in `src/main/docker`. For the native mode, use the following commands to build.
```
mvn clean package -Pnative
docker build -f src/main/docker/Dockerfile.native -t smart-doc-quarkus-example .
```
If you want to run directly in docker, use the following command to start
```
docker run -i --rm -p 8080:8080 smart-doc-quarkus-example
```

## Deploying Quarkus Application to Kubernetes
Add Kubernetes and Docker image extensions:
```
mvn quarkus:add-extension -Dextensions="kubernetes, container-image-docker"
```
The Kubernetes extension will create three resource objects for us:
- Service Account
- Service
- Deployment

It will also automatically add container configuration items in `application.properties`:

| Property                                                                                                                                      | Description                                                                                                                                                                                                               |
|-----------------------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| quarkus.kubernetes.part-of=todo-app                                                                                                           | One of the Kubernetes “recommended” labels (recommended, not required)                                                                                                                                                    |
| quarkus.container-image.registry= quarkus.container-image.group= quarkus.container-image.name=getting-started quarkus.container-image.tag=1.0 | Specifies the container image in the K8s deployment. Result is image: getting-started:1.0. Make sure there are no excess or trailing spaces! I specify empty registry and group parameters to obtain predictable results. |
| quarkus.kubernetes.service-type=NodePort                                                                                                      | Creates a service of type NodePort, default would be ClusterIP (doesn’t really                                                                                                                                            |

Run the packaging command
```
mvn clean package
```
This will automatically generate `kubernetes.yml` under target.

Automatic deployment
```
mvn clean package -Dquarkus.kubernetes.deploy=true
```

## References
- https://haralduebele.github.io/2020/04/03/deploy-your-quarkus-applications-on-kubernetes-almost-automatically/
- https://quarkus.io/guides/deploying-to-kubernetes
- https://2much2learn.com/restful-event-driven-microservice-using-quarkus-jpa-kafka/