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
mvn org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass="com.mycompany.app.Main" -Dexec.classpathScope=runtime
```

O ejecutar la clase principal directamente (asegúrate de incluir `target/classes` y las dependencias necesarias en el classpath):

```bash
# ejemplo genérico, ajustar según entorno
java -cp target/classes com.mycompany.app.Main
```
