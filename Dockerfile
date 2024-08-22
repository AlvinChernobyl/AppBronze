# Usar a imagem base do JDK 22 com Maven
FROM eclipse-temurin:22-jdk-alpine AS build

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o arquivo pom.xml e baixar as dependências
COPY pom.xml ./
RUN apk add --no-cache maven && mvn dependency:go-offline -B

# Copiar o código-fonte para dentro do contêiner
COPY src ./src

# Compilar o projeto
RUN mvn package -DskipTests

# Segunda fase, para criar uma imagem menor com apenas o JDK 22
FROM eclipse-temurin:22-jdk-alpine

# Definir o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copiar o JAR do build anterior para este contêiner
COPY --from=build /app/target/bronzeamento-app-0.0.1-SNAPSHOT.jar ./bronzeamento-app.jar

# Expor a porta que a aplicação vai rodar
EXPOSE 8080

# Definir o comando para iniciar a aplicação
CMD ["java", "-jar", "bronzeamento-app.jar"]
