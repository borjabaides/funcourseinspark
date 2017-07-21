# Programación Funcional en Spark con Scala

Este repositorio contiene el material utilizado durante el curso de programación funcional en Spark con Scala impartido por Habla Computing para la empresa Everis durante los meses de Julio y Agosto de 2017.

En este documento se recogen también las instrucciones relativas a la instalación de software, y otros aspectos necesarios para el correcto seguimiento del curso.

## Material del curso

Las explicaciones durante las sesiones del curso alternarán el uso de transparencias y ejemplos de programación "en vivo". Las transparencias estarán disponibles en los siguientes enlaces al comienzo de cada sesión en los siguientes enlaces:

* Presentación
* Sesión 1. [Introduction to Scala](module1-typeclasses/TypeClasses.pdf)
* Sesión 2. Higher-order functions & ADTs
* Sesión 3. Type classes
* Sesión 4. Functional architectures
* Sesión 5. Spark SQL
* Sesión 6. Spark Streaming

## Réplica y clonación del repositorio

Para facilitar las correcciones a los ejercicios propuestos durante el curso se recomienda hacer un [fork](https://help.github.com/articles/fork-a-repo/#fork-an-example-repository) de este repositorio en la cuenta Github del alumno, y clonar localmente vuestra propia versión del repositorio (instalando previamente [git](https://git-scm.com/)).

En este [documento](InstruccionesGithub.pdf) se explican paso a paso las actividades de configuración de vuestro repositorio, así como las operaciones de git que utilizaréis más comúnmente y el procedimiento para solicitar la corrección de ejercicios.

## Instalación de software

#### Librerías de Scala y compilador

Prerrequisitos: es necesario que tengáis instalado Java 8 en vuestra máquina.

Una vez clonado localmente el repositorio, mediante el siguiente comando se descargarán todas las dependencias necesarias para compilar los programas del curso (las librerías scalaz, cats, etc., y el propio compilador de Scala):

```bash
$ cd funcourseinspark-everis
$ ./sbt ~update
```

## Comunicación

#### Correo electrónico

El correo electrónico del coordinador del curso es: [juanmanuel.serrano@hablapps.com](mailto:juanmanuel.serrano@hablapps.com)

#### Chat del curso

Para resolver dudas y fomentar la colaboración entre los alumnos, se dispone del siguiente chat moderado por el equipo de Habla Computing:

https://gitter.im/hablapps/everis-spark-course

#### Twitter

La cuenta de Habla Computing es `@hablapps`.
El hashtag del curso es el siguiente: `#funcourseinspark`

#### Red wifi

El usuario y la constraseña de la red WIFI para su uso en el aula son las siguientes:

Red: eduroam
Usuario: hablapps
Constraseña: Dici@18. (punto final incluido)

#### Localización y fecha

El curso tendrá lugar los días 24/7, 25/7, 26/7, 27/7, 24/8 y 25/8 en horario de 9:00 a 13:30 horas, en la sala 1.1.C.08 situada en la primera planta del [Parque Tecnológico de la UC3M](https://www.google.com/maps?q=Parque+Tecnol%C3%B3gico,+Av+Gregorio+Peces+Barba,+28919+Legan%C3%A9s,+Madrid).

Siempre hay aparcamiento (gratuito) en las inmedicaciones del parque. Para aquellos que vengáis en transporte público, tenéis la opción de llegar mediante una combinación de [tren+autobús](https://www.google.com/maps/d/u/0/edit?mid=za8zleNzZrnc.kkG6K8Rm3_wA), o solo [autobús](https://www.google.com/maps/d/u/0/edit?mid=za8zleNzZrnc.kdbrfsWhyV_Q). [Aquí](http://portal.uc3m.es/portal/page/portal/investigacion/parque_cientifico/localizacion/transporte_publico) tenéis también información de cómo llegar.
