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

## Tecnologias utilizadas

- Java
- Node.js
- React
- Github
- Github actions
- Docker