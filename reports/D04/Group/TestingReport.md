# Informe de Pruebas


## Grupo C2.008

![Imagen corporativa](https://cdn.discordapp.com/attachments/1163864826167185412/1258472206342815935/logo.png?ex=66882b13&is=6686d993&hm=2114dbddda98d91e13163b3f5c51186e10bf337a891a129a5f1f124a2b2722af&)


https://github.com/Luis-Giraldo-Santiago3/Acme-SF-D04

Alejandro Vargas Muñiz → alevarmun1@alum.us.es
David Vargas Muñiz → davvarmun@alum.us.es
Luis Giraldo Santiago → luisgirsan@gmail.com
Rafael Molina García → rafmolgar2@alum.us.es

04/07/2024


## TABLA DE CONTENIDOS
1.	RESUMEN EJECUTIVO	
2.	TABLA DE REVISIÓN	
3.	INTRODUCCIÓN	
4.	CONTENIDO	
5.	CONCLUSIONES	
6.	BIBLIOGRAFÍA 

## 1. RESUMEN EJECUTIVO

El presente informe tiene como objetivo proporcionar un análisis general de sobre los casos de pruebas sometidas al codigo realizado por el grupo.

## 2. TABLA DE REVISIÓN	

| Fecha | Versión | Descripción |
|----------|----------|----------|
| 04/07/2024   | 1.0   | TestingReport Goup   |

## 3. INTRODUCCIÓN

El presente informe presenta un análisis sobre los casos de pruebas realizado a la entidad banner. Este informe se centra en analizar la cobretura de los casos de pruebas y la optimización del código.


## 4. Contenido

### Capítulo 1: Pruebas Funcionales

#### Introducción
Este informe presenta los resultados de las pruebas funcionales y de rendimiento realizadas en el proyecto "Acme-SF" respecto a banner. Las pruebas funcionales verifican la efectividad en la detección de errores, mientras que las pruebas de rendimiento evalúan el tiempo de respuesta en diferentes computadoras y entre tener o no tener indices. Los resultados ofrecen una visión sobre la estabilidad y eficiencia del proyecto.


#### Casos de Prueba Implementados para "Banners":

##### Característica 1: Listado de banners ("AdministratorBannerListService.java")

  - **Descripción:**  Prueba la funcionalidad que permite a los administradores listar los banners almacenados en el sistema. Esta característica debe asegurarse de que solo se muestren los banners a los administradores. 

  - **Efectividad:** En cuanto a la cobertura, observamos que tenemos un valor de 93,3%.
  Al ejecutar el "replayer" observamos que todas las líneas están en verde, por lo que se ha entrado y se ha ejecutado todo correctamente, de ahí el alto porcentaje y observamos que hay una líneas en amarillo:
    - Líneas amarillas:
      - Línea 40: ``assert object != null;`` La condición que siempre se cumple es que "object" siempre va a ser distinto de null.

##### Característica 2: Detalles de banners("AdministratorBannerShowService.java")

  - **Descripción:** Prueba la funcionalidad que permite a los administradores ver los detalles de los banners almacenados en el sistema. Esta característica debe asegurarse de que solo se muestren los detalles de los banners a los administradores. 

  - **Efectividad:** En cuanto a la cobertura, observamos que tenemos un valor de 94,2%.
  Al ejecutar el "replayer" observamos que todas las líneas están en verde, por lo que se ha entrado y se ha ejecutado todo correctamente, de ahí el alto porcentaje y observamos que hay una líneas en amarillo:
    - Líneas amarillas:
      - Línea 40: ``assert object != null;`` La condición que siempre se cumple es que "object" siempre va a ser distinto de null.


##### Característica 3: Crear banners ("AdministratorBannerCreateService.java")

  - **Descripción:** Prueba la funcionalidad que permite a los administradores crear nuevos banners en el sistema. Esta característica debe asegurarse de que solo los administradores puedan crear banners, que cuando se crea el banner, se guarda el instante de registro, el inicio de visualización en pantalla sea posterior al instante de registro y anterior al 2200/01/01 00:00, lo mismo para el acabado de visualización pantalla pero además tiene que ser 7 días posterior al inicio de pantalla, que el enlace de imagen esté entre 0 y 255 caracteres, que el Eslogan esté entre 0 y 75 caracteres y que el destino del enlace esté entre 0 y 255 caracteres. Todos los atributos son obligatorios.

  - **Efectividad:** En cuanto a la cobertura, observamos que tenemos un valor de 92,5%.
  Al ejecutar el "replayer" observamos que hay algunas líneas en amarillo:
      - Líneas amarillas:
        - **Línea 70:**  ``	super.state(MomentHelper.isAfterOrEqual(object.getDisplayFinish(), maximumPeriod) && object.getDisplayFinish().after(object.getDisplayStart()), "displayFinish", "administrator.banner.form.error.displayFinish");`` Esta línea está en amarillo, porque no se ha dado el caso en que estuviera fuera de los siete dias y antes de la fecha de final y esto es normal ya que no tendría sentido y esto pasara.
        
        - **Línea 39, 46, 65 y 71:**  ``		assert object != null;`` La condición que siempre se cumple es que "object" siempre va a ser distinto de null.

##### Característica 4: Actualizar banner("AdministratorBannerUpdateService.java")

  - **Descripción:** Prueba la funcionalidad que permite a los administradores actualizar los banners en el sistema. Esta característica debe asegurarse de que solo los administradores puedan actualizar banners, que cuando se actualice, el inicio de visualización en pantalla sea posterior al instante de registro y anterior al 2200/01/01 00:00, lo mismo para el acabado de visualización pantalla pero además tiene que ser 7 días posterior al inicio de pantalla, que el enlace de imagen esté entre 0 y 255 caracteres, que el Eslogan esté entre 0 y 75 caracteres y que el destino del enlace esté entre 0 y 255 caracteres. Todos los atributos son obligatorios.


  - **Efectividad:** En cuanto a la cobertura, observamos que tenemos un valor de 92,7%.
  Al ejecutar el "replayer" observamos que hay algunas líneas en amarillo:
      - Líneas amarillas:
        - **Línea 70:**  ``	super.state(MomentHelper.isAfterOrEqual(object.getDisplayFinish(), maximumPeriod) && object.getDisplayFinish().after(object.getDisplayStart()), "displayFinish", "administrator.banner.form.error.displayFinish");`` Esta línea está en amarillo, porque no se ha dado el caso en que estuviera fuera de los siete dias y antes de la fecha de final y esto es normal ya que no tendría sentido y esto pasara.
        
        - **Línea 39, 45, 64 y 71:**  ``		assert object != null;`` La condición que siempre se cumple es que "object" siempre va a ser distinto de null.

##### Característica 6: Borrar banners ("AdministratorBannerDeleteService.java")

  - **Descripción:**  Prueba la funcionalidad que permite a los administradores borrar contratos del sistema. Esta característica debe asegurarse de que solo los administradores autenticados puedan eliminar banners.

  - **Efectividad:** En cuanto a la cobertura, observamos que tenemos un valor de 57,1%.
  Al ejecutar el "analyser" observamos que hay algunas líneas en amarillo y en rojo.
    - Líneas amarillas:
        - **Líneas 43, 50, 56:**  ``		assert object != null;`` La condición que siempre se cumple es que "object" siempre va a ser distinto de null.

    - Líneas rojas: se corresponden al método "unbind", este método no se ejecuta debido a que no se tiene que ejecutar, ya que sirve para mostrar los datos cuando devuelve un error y en el delete no hay errores que devolver por tanto no se cargan los datos.

### Capítulo 2: Pruebas de Rendimiento

#### Introducción
Este capítulo analiza las pruebas de rendimiento realizadas en el proyecto "Acme-SF" respecto a las características de los banners. El objetivo es evaluar el tiempo de respuesta y la capacidad del sistema bajo diferentes cargas. Utilizamos una metodología que incluye la simulación de escenarios reales y el análisis estadístico de los resultados para garantizar la eficiencia y estabilidad del sistema.
#### Resultados de las Pruebas de Rendimiento

##### Gráficos
Gráfico del tiempo para la ejecución de las características del cliente sin la optimización en PC1.

- **Gráfico 1:** Gráfico del tiempo para la ejecución de las características del cliente en PC1.

![Gráfico del tiempo para la ejecución de las características del cliente en PC1](https://cdn.discordapp.com/attachments/1153717186490273878/1244370087570571314/image.png?ex=6654dd74&is=66538bf4&hm=4cbe54caa32d52eda1d456f74e902355cc53b4b6952bc65969a887cb0a879c23&)


- **Gráfico 2:** Gráfico del tiempo para la ejecución de las características del cliente en PC2 con optimización.

![Gráfico del tiempo para la ejecución de las características del cliente en PC2 con optimización](https://media.discordapp.net/attachments/1153717186490273878/1244370867648069684/image.png?ex=6654de2e&is=66538cae&hm=91b0098b5c538d2f403a728eb0dc35870a3559f43a85799f97ad161e98bbd3f3&=&format=webp&quality=lossless&width=687&height=388)


##### Intervalo de Confianza
Presentar el intervalo de confianza del 95% para el tiempo de respuesta en las dos computadoras.

- **PC1:**
  - **Nivel de Confianza sin la optimización:** 
  ![Nivel de Confianza sin la optimización](https://cdn.discordapp.com/attachments/1153717186490273878/1244371773445771346/image.png?ex=6654df06&is=66538d86&hm=36ccb12d3ead7f3a5c6d7226753257689013791e11a3b34a46e7c2249831196c&)
- **PC2:**
  - **Nivel de Confianza con la optimización:** 
  ![Nivel de Confianza con la optimización](https://cdn.discordapp.com/attachments/1153717186490273878/1244371539076583517/image.png?ex=6654dece&is=66538d4e&hm=5df905ee3d1c6aa0205ced718560cb84271196687fd303713e38958e0c2908cf&)

#### Contraste de Hipótesis
Presentar el contraste de hipótesis con un 95% de confianza sobre cuál computadora es más potente.

- **Resultado del Contraste de Hipótesis:** 

![Resultado del Contraste de Hipótesis](https://media.discordapp.net/attachments/1153717186490273878/1244372273788358767/image.png?ex=6654df7d&is=66538dfd&hm=00c3fcf182e7ffa521514e7493464395925d7eade97243df4e66b59e84cd1996&=&format=webp&quality=lossless&width=776&height=363)

## 5.	CONCLUSIONES



## 6.	BIBLIOGRAFÍA 

Intencionalmente en blanco.