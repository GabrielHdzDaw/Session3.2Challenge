/*En muchos de los concursos de programación, como en el que hoy participas, cada vez que un equipo resuelve
correctamente un problema recibe un globo del color asociado a ese problema. Al final, quien más globos
consigue no solo tiene su ordenador más colorido, sino que será el ganador del concurso.

Dada la lista de los globos colocados a cada equipo, ¿eres capaz de decir quién es el ganador?

Entrada
La entrada estará compuesta de múltiples casos de prueba, cada uno de ellos simulando un concurso. Cada caso de
prueba comienza con una línea con dos números, el primero de ellos indicando el número de equipos participantes
 (entre 1 y 20) y el segundo el número de globos entregados.

A continuación aparecerá una línea por cada globo entregado, con el número del equipo que lo ha recibido (entre
1 y el número de equipos) y el color (una palabra de un máximo de 20 letras). Un equipo nunca recibirá dos
 veces el mismo color de globo.

La entrada terminará cuando se llegue a un concurso sin equipos ni globos.

        Salida
Para cada caso de prueba se debe escribir el número del equipo ganador en una línea. En caso de empate,
se escribirá EMPATE.

Entrada de ejemplo
4 3
2 Rojo
3 Amarillo
3 Azul
4 4
2 Rojo
3 Amarillo
3 Azul
2 Verde
0 0
Salida de ejemplo

3
EMPATE*/


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Session32Challenge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        byte equipos = 0, globos = 0;
        String yaCombinadas = "", entrada = " ";
        List<String> resultados = new ArrayList<String>();
        do {
            System.out.print("Introduce número de equipos (entre 1 y 20): ");
            equipos = sc.nextByte();

            int[] puntuacionEquipos = new int[equipos];
            System.out.print("Introduce número de globos: ");
            globos = sc.nextByte();

            if (equipos != 0 && globos != 0) {
                for (int i = 0; i < globos; i++) {
                    String[] entradaSplit;
                    do {
                        entrada = sc.nextLine();
                        entradaSplit = entrada.split(" ");
                        if (yaCombinadas.contains(entrada)) {
                            System.out.println("Ese equipo ya tiene ese color\n");
                        }
                    } while (yaCombinadas.contains(entrada));
                    yaCombinadas += entrada;
                    puntuacionEquipos[Integer.parseInt(entradaSplit[0]) - 1]++;
                }

                int max = 0;
                int equipoGanador = -1;

                boolean empate = false;

                for (int i = 0; i < puntuacionEquipos.length; i++) {
                    if (puntuacionEquipos[i] > max) {
                        max = puntuacionEquipos[i];
                        equipoGanador = i + 1;
                        empate = false;
                    } else if (puntuacionEquipos[i] == max && max > 0) {
                        empate = true;
                    }
                }
                if (empate) {
                    resultados.add("EMPATE");
                } else {
                    resultados.add(String.valueOf(equipoGanador));
                }

                yaCombinadas = "";
            }


        } while (equipos != 0 && globos != 0);

        for (String resultado : resultados) {
            System.out.println(resultado);
        }

    }
}