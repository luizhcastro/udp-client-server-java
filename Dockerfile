# Dockerfile

# Use uma imagem base do Java JDK
FROM eclipse-temurin:17-jdk

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie os arquivos .java para o diretório de trabalho
COPY src/ .
# Compile o código Java
RUN javac *.java

# O comando para iniciar o contêiner será definido no docker-compose.yml