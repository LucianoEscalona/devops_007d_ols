# Proyecto Ingenieria en DevOps
**Por: Luciano Escalona**

## Estrategia de desarrollo utilizada

Para la realizacion de este trabajo, se opto por utilizar **Git Flow**, ya que se considera como la mejor opcion para realizar proyectos de manera colaboratiba, al tener una estructura con ramas dedicadas a cada cualidad de la aplicacion, y al permitir hacer releases de manera mas rapida y sencilla. 

Otra razon por la que se utilizo Git Flow, es porque en el mercado este metodo de trabajo se utiliza bastante, por lo que podemos practicar con este proyecto.

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

Historial de commits (recuperados con git log, y ordenados de mas reciente a mas antiguo):

```
commit edf3828faff49108d5ac5e649747429fd4e6b83a (HEAD -> feature/readme, origin/develop, develop)
Merge: 5756526 d6ca5a8
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:37:41 2026 -0400

    Merge tag '1.2.1' into develop

    versio 1.2.1 (hotfix)

commit d6ca5a89a6e3ed1839470b1bcca51f1733ae72af (tag: 1.2.1, origin/main, main)
Merge: acaa4b9 16a0446
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:36:50 2026 -0400

    Merge rama 'hotfix/1.2.1' (no hay arreglo real, es solo una simulacion)

commit 16a0446df543d38f6620123c49a4bae787d964ee
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:36:22 2026 -0400

    Simulacion de un Hotfix

commit 575652659c73108a4d3b06d0e7b8933f3f39c5e7
Merge: db07c35 acaa4b9
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:30:51 2026 -0400

    Merge tag '1.2' into develop

    version 1.2

commit acaa4b9284370792d135880e956d69ccf6f414b6 (tag: 1.2)
Merge: a0488c3 db07c35
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:30:07 2026 -0400

    Merge rama 'release/1.2' (agregando el frontend)

commit db07c3515ba8bdf5e07718d14c44dd993370ca2c (origin/feature/frontend, feature/frontend)
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:23:31 2026 -0400

    Frontend agregado

commit 4a0cd6c5541976fe7dd03dc3ead6eb44fb21635f
Merge: 19c6697 a0488c3
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:14:36 2026 -0400

    Merge tag '1.1' con develop

    version 1.1

commit a0488c313fd1730d1962d61ef48a3962df107571 (tag: 1.1)
Merge: d98ecd7 19c6697
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:14:00 2026 -0400

    Merge rama 'release/1.1' (ahora si con los archivos)

commit 19c66979e2686910a4d7a52d7460cbef4acb60ba
Merge: 0b8bb78 0c5b7b1
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:12:54 2026 -0400

    Merge rama 'feature/backend' con develop

commit 0b8bb78c689a690e6a8ca05e8a2c7f5603f190b3
Merge: 74f8cf1 d98ecd7
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:11:06 2026 -0400

    Merge tag '1.0' hacia develop

    version 1.0 (Backends)

commit d98ecd795c4450f90c7438bb0abba7b205ce10eb (tag: 1.0)
Merge: f129d9c 74f8cf1
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:10:15 2026 -0400

    Merge rama "release/1.0"

commit 0c5b7b1c87b2588e74dfafc732a266117683a089 (origin/feature/backend, feature/backend)
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:08:31 2026 -0400

    Agregando backend ventas

commit f45f3caf2fdbc2db051372bc7d09d1157a9e98fa
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:07:46 2026 -0400

    Agregando backend despacho

commit 74f8cf177ce793624763ddc50e6b284df4262f27
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:06:19 2026 -0400

    Creando rama develop

commit f129d9ce4e85a302fbce87d35a8f1bb3be660216
Author: Luciano Escalona <luci.escalona@duocuc.cl>
Date:   Sun Aug 30 00:04:19 2026 -0400

    Inicializacion proyecto
```