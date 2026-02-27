INSTRUCCIONES DE EJECUCIÓN - E2E DEMOBLAZE

Prerrequisitos:
1. Java Development Kit (JDK) 11 o superior instalado y configurado en las variables de entorno.
2. Apache Maven instalado y configurado.
3. Navegador Google Chrome actualizado.

Pasos para ejecutar la prueba:
1. Descomprimir el archivo .zip en la ubicación deseada.
2. Abrir una terminal (Símbolo del sistema, PowerShell o Bash) y navegar hasta la carpeta raíz del proyecto (donde se encuentra el archivo pom.xml).
3. Ejecutar el siguiente comando para limpiar, compilar y ejecutar las pruebas:
   mvn clean verify
4. Esperar a que el navegador se abra automáticamente y realice las acciones definidas en la prueba E2E.

Visualización de Reportes:
1. Una vez finalizada la ejecución, el reporte de Serenity BDD se generará automáticamente.
2. Navegar a la ruta: target/site/serenity/
3. Abrir el archivo "index.html" en cualquier navegador web para ver el reporte detallado con capturas de pantalla de cada paso.