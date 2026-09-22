# Proyecto Ingenieria en DevOps
**Por: Luciano Escalona**

## Estrategia de desarrollo utilizada

Para la realizacion de este trabajo, se opto por utilizar **Git Flow**, ya que se considera como la mejor opcion para realizar proyectos de manera colaboratiba, al tener una estructura con ramas dedicadas a cada cualidad de la aplicacion, y al permitir hacer releases de manera mas rapida y sencilla. 



## Por que utilizar git flow?

Se decidio utilizar esta tecnica, porque en el mercado este metodo de trabajo se utiliza bastante, por lo que podemos practicar con este proyecto. Ademas, al ser pensado para trabajar de manera colaborativa, agiliza el desarrollo y facilita los cambios y modificaciones, al trabajar en ramas especificas para cada funcion, ademas que **git flow release** y **git flow hotfix** nos permite subir cambios a main de manera sencilla y corregir errores rapidamente.

## Flujo del proyecto

A continuacion, se muestra un diagrama que muestra el flujo de nuestro proyecto:

![Diagrama de flujo de Git flow realizado](Git%20flow.drawio.png)

**Descripcion del flujo:**

El proyecto inicio con la rama **main** y **develop**, en los cuales se creo el README.md (vacio), posteriormente se creo la rama **feature/backend**, en la cual se hicieron 2 commits y 2 push, en los cuales se agregaron dos carpetas que contenian el backend en el siguiente orden: Backend Despacho y Backend Ventas.

Despues se hizo el primer release con "git flow release start 1.0" (se me olvido hacer merge de feature a develop -_-) y confirme el release con "git flow release finish 1.0", posteriormente, hice un push a main, develop y --tags.

Como me di cuenta que se me olvido realizar el merge de feature con develop para que release tuviera los cambios recientes, tuve que realizar un release nuevamente, habiendo hecho el merge (lo unico que cambio fue la version, en vez de ser 1.0 ahora es 1.1).

Una vez terminado este release, se volvio a develop y se creo otra rama feature; **feature/frontend**, en el cual, subimos el frontend, esta vez al hacer commit y push de los cambios, se hizo el merge a develop y posteriormente el release (version 1.2).

Despues de finalizar este release, se simulo un hotfix (en el cual simplemente se agrego un archivo txt).

Finalizando, con este commit, en el cual simplemente se desarrolla el README.md, en una nueva rama: **feature/readme** (se repiten los mismos pasos anteriores, merge a develop y release con pullrequest a main).

## Pipeline

El pipeline realizado simplemente compila e instala las dependencias necesarias para los dos backends y el frontend.

En cada paso o step, comienza haciendo un checkout del codigo, posteriormente instala java 17 (para los backend) o node.js (para el frontend).

Despues se compila el codigo y de momento, se saltan los tests para que esto sea mas rapido y no tan complejo.

## Docker

Lo mas reciente que se ha implementado en el repositorio, es el uso de contenedores Docker. Un contenedor, permite ejecutar sistemas en entornos aislados con todas las dependencias necesarias para garantizar su correcto funcionamiento, esto a traves de archivos Dockerfile y docker-compose.

**A continuacion, se explicara que hace cada archivo:**

**Dockerfile (Backend despacho):**
- Este archivo se divide en 2 Stages.
- En el pprimero, se configura y se copia el directorio proyecto y el archivo pom.xml en el directorio de trabajo /build (se ocupa maven 3.9) y se ejecuta "mvn clean package -DskipTests" para limpiar el proyecto y saltarse los tests.
- En el segundo stage, se configura el contenedor para ejecutar el proyecto y exponerlo al puerto 8080 (utilizando eclipse-temurin con java 21).
- Tambien se cuenta con un archivo Docker.ignore que ignora los archivos de configuracion locales, dependencias locales, control de versiones y sistema de build y archivos temporales.

**Dockerfile (Backend ventas):**
- Es igual que el archivo antes mencionado, consta de 2 Stages.
- El primero copia el proyecto y el pom.xml y limpia y se salta los tests.
- El segundo ejecuta y expone el proyecto al puerto 8081.
- Cuenta igualmente con un Docker.ignore, y este hace lo mismo que el anteriormente menciaonado.

**Dockerfile (Frontend):**
- Consta de 2 Stages.
- Primero se configura node 20 y se setea el directorio de trabajo, posteriormente, se copia el archivo package.json (el de las dependencias), se instala node en el contenedor y se copia el proyecto, despues se ejecuta con el comando "npm run build".
- El segundo stage se encarga de instalar nginx y copiar el servidor web, para posteriormente, subir el proyeco a este y exponerlo al puerto 80.

**docker-compose:**
- El docker compose, es el que se encarga de levantar todos los contenedores a traves de un unico archivo, el mio se divide en 4 servicios:
- mysql: se descarga una imagen y se levanta una base de datos, se expone al puerto 3306 y utiliza un volumen mysql_data. Cuenta con un healthcheck  para asegurarnos de que el contenedor funcione correctamente.
- back_ventas: se construye el proyecto y se expone al puerto 8081, se configuran las variables de ambiente que definen donde esta la BDD y que usuario y contraseña usar, depende de que el contenedor de mysql haya iniciado y que tenga un estado "healthy".
- back_despachos: similar a back_ventas, se construye, se expone (8080:8080) y se configura las variables de ambiente para la BDD (url, username, password) y depende de que mysql tenga un service_healthy.
- frontend: simplemente se constuye el frontend y se expone 3000:80, depende de que los servicios de backend_ventas y backend_despachos terminen.

## Tecnologias utilizadas
- Java
- Node.js
- React
- Github
- Github actions
- Docker