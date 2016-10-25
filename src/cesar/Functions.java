/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cesar;

/**
 *
 * @author Josh_Andres <Josh Andres at gmail.com>
 */

/*-----------------------------------------------------------
  |                 Algoritmo de cifrado Cesar              |
  |           by Josh Andres(github.com/Josh2604)           |
  -----------------------------------------------------------*/
public class Functions {

    /*---------------------------------------------------------------
         | Creación de arreglo(alfabeto), obtención del texto a cifrar |
         | y división de texto en caracteres para su comparación.      |
         ---------------------------------------------------------------*/
    static char arreglo[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'ñ', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '-', '*', '/', '.', ' ', '!', '#', '`', '~', '@', '$', '%', '^', '&', '(', ')', '|', '_', '=', ':', ';',
        '"', '?', ',', '<', '>', '[', ']', '{', '}', '\''};

    /*--------------------------------------------
      |  Método para cifrar la cadena ingresada. |
      --------------------------------------------*/
    public String cifrarCadena(String palabra_1, int clave) {
        char palabra_2[] = new char[palabra_1.length()];
        String text_cifrado = "";

        for (int i = 0; i < palabra_1.length(); i++) {
            palabra_2[i] = palabra_1.charAt(i);
        }


        /*---------------------------------------------------------------------
        |Comparación de la cadena a cifrar con el alfabeto y el recorrido de|
        |tres caracteres sobre el afabeto para obtener la cadena cifrada.   |
        ---------------------------------------------------------------------*/
        char arr_cifrado[] = new char[palabra_2.length];
        int cont_cifrado = 0, auxiliar = 0, verify = 0;

        for (int i = 0; i < palabra_2.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (palabra_2[i] == arreglo[j]) {
                    verify = (j + (clave % 27));
                    if (verify >= arreglo.length) {
                        auxiliar = verify - arreglo.length;
                        arr_cifrado[cont_cifrado] = arreglo[auxiliar];
                        cont_cifrado++;
                    } else {
                        arr_cifrado[cont_cifrado] = arreglo[j + (clave % 96)];
                        cont_cifrado++;
                    }
                } else {
                    //only development
                }
            }
        }
        for (int i = 0; i < arr_cifrado.length; i++) {
            text_cifrado = text_cifrado + "" + arr_cifrado[i];
        }
        return text_cifrado;
    }

    /*---------------------------------------------------------------------
    |          Método para decifrar la cadena ingresada.                |
    ---------------------------------------------------------------------*/
    public String decifrarCadena(String cadenaDecifrar, int clave) {
        char cadenaDecifrar_2[] = new char[cadenaDecifrar.length()];
        String textDecifrado = "";

        for (int i = 0; i < cadenaDecifrar.length(); i++) {
            cadenaDecifrar_2[i] = cadenaDecifrar.charAt(i);
        }

        char arr_Decifrado[] = new char[cadenaDecifrar_2.length];
        int cont_cifrado = 0, auxiliar = 0, verify = 0;

        for (int i = 0; i < cadenaDecifrar_2.length; i++) {
            for (int j = 0; j < arreglo.length; j++) {
                if (cadenaDecifrar_2[i] == arreglo[j]) {
                    verify = (j - (clave % 27));
                    if (verify < 0) {;
                        auxiliar = arreglo.length - (-verify);
                        arr_Decifrado[cont_cifrado] = arreglo[auxiliar];
                        cont_cifrado++;
                    } else {
                        arr_Decifrado[cont_cifrado] = arreglo[j - (clave % 96)];
                        cont_cifrado++;
                    }
                } else {
                    //only development
                }
            }
        }
        for (int i = 0; i < arr_Decifrado.length; i++) {
            textDecifrado = textDecifrado + "" + arr_Decifrado[i];
        }
        return textDecifrado;
    }
}
