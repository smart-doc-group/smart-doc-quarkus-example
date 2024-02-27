
compile:
	mvn compile quarkus:dev

package-native:
	mvn clean package -Pnative -Dmaven.test.skip=true