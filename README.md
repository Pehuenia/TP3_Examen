•	¿Qué tipo de arquitectura usaron y por qué? ¿Podría mejorarla? 
MVVM Permite que la UI se mantenga "reactiva" y desacoplada de la lógica de negocio. 
Nosotros concluimos que sería mejor utilizar la arquitectura Hexagonal, ya que considera los siguientes beneficios: 
1.	Aislamiento de la lógica de negocio: La lógica central está aislada de detalles de implementación como bases de datos o interfaces de usuario.
2.	Pruebas más fáciles: Puedes probar la lógica de negocio de forma aislada, sin tener que preocuparte por las dependencias externas.
3.	Flexibilidad: Es fácil cambiar adaptadores (por ejemplo, cambiar la base de datos de SQL a NoSQL o cambiar la interfaz de usuario) sin afectar la lógica de negocio.
4.	Escalabilidad: La arquitectura hexagonal favorece la escalabilidad, ya que puedes agregar nuevas integraciones o servicios sin cambiar el núcleo de la aplicación.
5.	Manejo de dependencias explícito: Las dependencias externas se manejan explícitamente mediante adaptadores, lo que mejora la comprensión y el mantenimiento del sistema.

•	¿Tuvieron objetos stateful y stateless? ¿Cómo definen la elección de los mismos?
Sí,  por ejemplo de stateful es en:  el LoginViewModel, los estados como errorMessage y token son mutables y se actualizan conforme al cambio. 
En el caso del stateless es por ejemplo: ButtonApp, Input o IconCircular.
•	¿Qué mejoras detectan que podrían realizarle a la app? ¿Tendrían side effect si escala el volumen de datos? Comenten al menos 2 cuestiones a refactorizar y tener en cuenta. 
Una de ellas sería utilizar Paging de Jetpack que implementa una capa de repositorio para manejar la lógica de datos y desacoplarla de los ViewModels y, además, optimiza considerablemente el uso del Side effects: ya que, si el volumen de datos escalara, podría haber problemas de rendimiento y consumo de memoria. Utilizar Paging optimiza las consultas a la base de datos mitigando estos problemas. 
Consideramos:
 Refactorizar la lógica de manejo de errores para centralizarla y hacerla más manejable. Implementar una arquitectura de capas más clara, separando la lógica de negocio, la lógica de datos y la interfaz de usuario.
•	¿Qué manejo de errores harían? ¿dónde los contemplan a nivel código? Mencionen la estrategia de mapeo que más se adecúe. 
El manejo de errores se puede mejorar utilizando una clase Result que encapsule tanto los datos exitosos como los errores. Esto se puede contemplar en los ViewModel y en las capas de repositorio. La estrategia de mapeo adecuada sería mapear los errores a estados específicos de la UI, mostrando mensajes de error adecuados al usuario.
•	En el caso de uso de persistencia para Favoritos, ¿qué estrategia sugieren?
Para la persistencia del login, se sugiere utilizar SharedPreferences para almacenar el token de autenticación de manera segura. Alternativamente, se puede utilizar una base de datos local como Room para almacenar información más compleja del usuario.
•	Si la tendríamos que convertir a Español y conservar el Inglés, qué estrategia utilizaría para extenderla. Y si necesitamos agregar otros idiomas?
Para soportar múltiples idiomas, se debe utilizar el sistema de recursos de Android, creando archivos de recursos separados para cada idioma (res/values/strings.xml para el inglés y res/values-es/strings.xml para el español).
Para agregar otros idiomas, se crean archivos de recursos adicionales (res/values-<language_code>/strings.xml). Esto permite que la aplicación soporte múltiples idiomas de manera escalable. 

