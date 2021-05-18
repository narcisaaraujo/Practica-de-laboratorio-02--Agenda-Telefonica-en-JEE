# PracticaDeLaboratorio01-Servlets-JSPyJDBC
 ![alt text](/images/13.png)
TÍTULO PRÁCTICA: Desarrollo de una aplicación JEE basado en Servlets, JSP y JDBC
para el intercambio de datos en un modelo de tres capas aplicando los patrones diseño de software MVC y DAO

OBJETIVOS
•	Diseña y desarrolla modelos de software en diferentes niveles de abstracción y modelos de datos a nivel transaccional y analítico con entornos de desarrollo actuales


Se pide desarrollar una aplicación JEE que permita implementar una agenda telefónica en donde se tendrán usuarios con datos como cedula, nombres, apellidos, correo y contraseña. Y cada uno de estos usuarios podrá tener asignado uno o más teléfonos de contacto de diferente tipo y operador, por ejemplo:

•	El usuario “Juanito” tiene los teléfonos 0998121212 de tipo celular y operadora Movistar; así como también tiene asignado el teléfono 0728222111 de tipo convencional y operador CNT.

Para lo cuál, se propone el siguiente diagrama de clases:


 ![alt text](/images/1.png)
 
 Los requerimientos funcionales del sistema son:
•	Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.
•	Un usuario puede iniciar sesión usando su correo y contraseña.
•	Una vez iniciado sesión el usuario podrá:
o	Registrar, modificar, eliminar, buscar y listar sus teléfonos

o	Listar los números de teléfono de un usuario usando su número de cédula o correo electrónico
o	Podrá llamar o enviar un correo electrónico desde el sistema usando aplicaciones externas.

•	Los datos siempre deberán ser validados cuando se trabaje a través de formularios.
De igual manera, se pide manejar sesiones y filtros para que existe seguridad en el sistema de agenda telefónica. Por lo qué, debe existir una parte pública 
y una privada. La parte privada ha sido descrita en los requisitos antes planteados. Y la parte pública será una página index.html a través de la cuál podrán acceder al sistema. No obstante, se debe generar una página con la experiencia e interfaz de usuario apropiada, como la que se muestra a continuación:
 ![alt text](/images/2.png)
 Fig 3. Pagina pública index.html propuesta para el sistema de agenda telefónica
 
 
Finalmente, el sistema de agenda telefónica debe aplicar los patrones de diseño de software MVC y DAO, en donde, el modelo será clases POJOs de Java, la vista será JSP + JSTL y los controladores serán a través de DAOs y Servlets.
-------------------------------------------------------------------------------------------
                        ACTIVIDADES POR DESARROLLAR
1.	Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 01: Servlets, JSP y JDBC

 ![alt text](/images/4.png)

2.	Desarrollar una aplicación con tecnología JEE para gestionar una agenda telefónica en la web.

En este sistema se han usado patrones de diseño Modelo Vista Controlador y el patrón DAO para una mejor estructura del sistema.

•	Jerarquia del sistema:
![alt text](/images/3.png)

Explicacion:

Private: Contiene todos los controladores que se encargan de realizar las acciones de los usuarios logueados
DAO: Proporcionará los métodos necesarios para insertar, actualizar, borrar y consultar la información;
Controller: Servlets que se encargan de controlar las acciones del usuario.
JDBC: Se encarga de realizar las actualizaciones, inserciones y eliminar en la base de datos
Public: Contiene los controladores de búsqueda a los que un usuario anónimo puede acceder
Filtro: Aplicación para el control de sesiones de la parte privada.
CSS: Estilos css aplicados sobre las distintas paginas html y jsp.
JSP:consta con las paginas para la parte privada al que solo el usuario registrado tiene acceso

•	Base de datos usada: MySQL
Nombre: agenda
Tablas usuario
![alt text](/images/5.png)
![alt text](/images/6.png)


Requisitos
Los usuarios pueden registrarse en la aplicación a través de un formulario de creación de cuentas.
 ![alt text](/images/7.png)
•	Un usuario puede iniciar sesión usando su correo y contraseña
![alt text](/images/8.png)
•	Una vez iniciado sesión el usuario podrá:
o	Registrar, modificar, eliminar, buscar y listar sus teléfonos
![alt text](/images/9.png)
Listar los números de teléfono de un usuario usando su número de cédula o correo electrónico
![alt text](/images/10.png)

Podrá llamar o enviar un correo electrónico desde el sistema usando aplicaciones externas.

		Los correos y llamadas se realizarán mediante los iconos que se presentan en la interfaz 			independientemente de la aplicación externa que tenga el sistema del usuario

Los datos siempre deberán ser validados cuando se trabaje a través de formularios.

		Los formularios validan los campos requeridos como lo son el numero de cedula, correo y otros 			campos para el adecuado ingreso de la información.
3.	Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación.
![alt text](/images/11.png)
1.	Implementar el README del repositorio del proyecto con la misma información del informe de la práctica
RESULTADO(S) OBTENIDO(S):
•	Maneja diferentes formatos para el intercambio de datos entre aplicaciones.

CONCLUSIONES:

	La implementación de el sistema propuesto nos ayuda a mejorar y a complementar los conocimientos 	adquiridos en clase, como es la aplicación de patrones como MVC y DAO ya que son compatibles logrando 	una mejor estructura del sistema para el cumplimiento de los requerimientos propuestos.
 
 RECOMENDACIONES:
•	Aplicar conceptos de interacción humano máquina para el desarrollo de la GUI.
•	Estructurar correctamente el sistema.

![alt text](/images/12.png)

