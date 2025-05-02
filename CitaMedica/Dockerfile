
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# Usa una imagen de Java
FROM eclipse-temurin:22-jdk

# Crea una carpeta dentro del contenedor
WORKDIR /app

# Copia el jar compilado al contenedor
COPY target/CitaMedica-1.0-SNAPSHOT.jar app.jar

# Ejecuta el archivo jar
ENTRYPOINT ["java", "-jar", "app.jar"]