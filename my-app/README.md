# Currency Conversor (Proyecto de ejemplo)

Este proyecto es un conversor de monedas en Java que obtiene tipos de cambio mediante un cliente HTTP y muestra un menú interactivo en consola para convertir entre distintas monedas.

## Estructura principal

- `src/main/java/com/mycompany/api/ExchangeRateApiClient.java` — Cliente que consulta el API de tipos de cambio.
- `src/main/java/com/mycompany/app/Main.java` — Programa principal con un menú de consola para seleccionar monedas y convertir montos.

## Monedas disponibles

El menú ofrece 9 opciones (las mismas para moneda origen y destino):

1) Dólar (USD)
2) Euro (EUR)
3) Sol peruano (PEN)
4) Peso chileno (CLP)
5) Peso argentino (ARS)
6) Peso colombiano (COP)
7) Boliviano (BOB)
8) Peso uruguayo (UYU)
9) Guaraní paraguayo (PYG)

## Requisitos

- Java 11+ (o la versión que use tu `pom.xml`)
- Maven
- Conexión a Internet para que el cliente de tipo de cambio funcione

## Compilar

Desde la carpeta `my-app` ejecuta:

```bash
mvn package
```

Si prefieres ejecutar sin empaquetar dependencias, puedes usar el plugin `exec` de Maven:

```bash
mvn -q -Dexec.mainClass="com.mycompany.app.Main" -Dexec.classpathScope=runtime org.codehaus.mojo:exec-maven-plugin:3.1.0:exec
```

O ejecutar la clase principal directamente (asegúrate de incluir `target/classes` y las dependencias necesarias en el classpath):

```bash
# ejemplo genérico, ajustar según entorno
java -cp target/classes com.mycompany.app.Main
```

## Uso

1. Ejecuta la aplicación.
2. El menú mostrará las 9 monedas; ingresa el número de la moneda origen.
3. Ingresa el número de la moneda destino.
4. Ingresa el monto a convertir.
5. La aplicación consultará `ExchangeRateApiClient.getCurrencyRate(from, to)` y mostrará el resultado.

Si la API no responde, se mostrará un mensaje de error; verifica tu conexión a Internet o la configuración del servicio de tipos de cambio en `ExchangeRateApiClient`.

## Notas

- El proyecto está pensado como ejemplo educativo y depende de un servicio externo para obtener los tipos de cambio.
- Si necesitas añadir más monedas, modifica `Main.java` (arreglos `codes` y `names`) y recompila.

---

Si quieres, puedo añadir instrucciones para ejecutar con Docker o crear un script de ejecución. ¿Quieres que lo añada?
