# Informe de Pruebas


## Grupo C2.008

![Imagen corporativa](https://cdn.discordapp.com/attachments/1163864826167185412/1259098235822407862/logo.jpg?ex=668a721c&is=6689209c&hm=e27bbfd3a0143c0b1fc32042f70aafa1382e6404b09e3aa779cead513b4e7819&)


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
Este capítulo analiza las pruebas de rendimiento realizadas en el proyecto "Acme-SF" respecto a las características del cliente. El objetivo es evaluar el tiempo de respuesta y la capacidad del sistema bajo diferentes cargas. Utilizamos una metodología que incluye la simulación de escenarios reales y el análisis estadístico de los resultados para garantizar la eficiencia y estabilidad del sistema.
#### Resultados de las Pruebas de Rendimiento

##### Gráficos
Gráficos del tiempo para la ejecución de las características del cliente en PC1.

- **Gráfico 1:** Gráfico del tiempo para la ejecución de las características del cliente en PC1.

![Gráfico del tiempo para la ejecución de las características del cliente en PC1](https://cdn.discordapp.com/attachments/1163864826167185412/1259089440530366496/image.png?ex=668a69eb&is=6689186b&hm=ef2d6a34f80cc0c3aaedbd425bbe36fe8b2ca0eae8c05cffebbdf7f56cb41ffc&)


- **Gráfico 2:** Gráfico del tiempo para la ejecución de las características del cliente con optimización en PC1.

![Gráfico del tiempo para la ejecución de las características del cliente con optimización en PC1](https://cdn.discordapp.com/attachments/1163864826167185412/1259089869557469266/image.png?ex=668a6a51&is=668918d1&hm=e815a6c1c71e7659557e336140accd0da07dbb932261ef026c545792a6003048&)

Gráficos del tiempo para la ejecución de las características del cliente en PC1.

- **Gráfico 3:** Gráfico del tiempo para la ejecución de las características del cliente con optimización en PC2.

![Gráfico del tiempo para la ejecución de las características del cliente con optimización en PC2](https://cdn.discordapp.com/attachments/1163864826167185412/1259090688931270687/image.png?ex=668a6b15&is=66891995&hm=bf96001453ed1a08b58ab50280d5569a37b3a5b666bfb1d6d20e7698f5e2f664&)


##### Intervalo de Confianza
Presentar el intervalo de confianza del 95% para el tiempo de respuesta en las dos computadoras.

- PC1:
  - Nivel de confianza sin la optimización: 0,879700058
  - Nivel de confianza con la optimización: 0,79323659
- PC2:
  - Nivel de confianza con la optimización: 2,039863002



#### Contraste de Hipótesis
Presentar el contraste de hipótesis con un 95% de confianza sobre cuál computadora es más potente.

- **Resultado del Contraste de Hipótesis:** 
  - **Prueba z entre los datos del mismo PC**
![Prueba z entre los datos del mismo PC](https://cdn.discordapp.com/attachments/1163864826167185412/1259092182048964699/image.png?ex=668a6c79&is=66891af9&hm=cfc6f31659f06590e76ab38ecf6dab392e99d21ccad5c245fdb09266292c67cf&)
  - **Prueba z entre los datos de distintos PC**
![Prueba z entre distintos PC](https://cdn.discordapp.com/attachments/1163864826167185412/1259092499952042015/image.png?ex=668a6cc4&is=66891b44&hm=8d9ed41d00b36b1c379e7d680a5ce420902cc344ecf30d63d5ccbf5b90d13876&)

Como podemos observar el la primera imagen, al fijanos en el valor crítico de z(dos cola), vemos que nos da un 0,030492559, este número esta entre [0.00,0.05), todo esto nos indica que ha habído una mejora de tiempo al añadir índices al código.

Cuando hacemos la misma prueba con los tiempo de los dos PCs optimizados, nos da un valor de 0, esto quiere decir que al cambiar de PC a uno mejor, también optenemos una mejor del tiempo que ya habíamos mejorado.

## 5.	CONCLUSIONES



## 6.	BIBLIOGRAFÍA 

Intencionalmente en blanco.