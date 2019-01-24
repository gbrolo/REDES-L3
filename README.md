# Java Multithreaded Webserver with Thread Pool

Compile ```Webserver.java``` and then run ```$java Webserver```. Create a Telnet request or enter ```http://localhost:2407/index.html``` in your web browser.

## Configuring thread number
Modify ```NUM_THREADS.config``` and change thread number.

## Preguntas del laboratorio
¿Qué sucede desde el punto de vista del usuario cuando se intenta abrir más conexiones que las disponibles en su webserver?

Cuando las conexiones sobrepasen el límite del pool, no se cargarán los documentos en las nueva conexiones, pero en las conexiones anteriores el contenido ya fue cargado.