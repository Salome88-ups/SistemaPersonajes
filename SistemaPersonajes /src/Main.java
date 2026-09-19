import java.util.ArrayList;
import java.util.Scanner;


public class Main {


    static Scanner sc = new Scanner(System.in);

    static ArrayList<Personaje> personajes = new ArrayList<>();


    public static void main(String[] args) {


        int opcion = 0;


        do {

            System.out.println("\n========== MENÚ ==========");
            System.out.println("1. Registrar personaje");
            System.out.println("2. Mostrar personajes");
            System.out.println("3. Buscar personaje por id");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");


            try {

                opcion = sc.nextInt();


                switch(opcion){

                    case 1:
                        registrar();
                        break;

                    case 2:
                        mostrar();
                        break;

                    case 3:
                        buscar();
                        break;

                    case 4:
                        System.out.println("Programa finalizado");
                        break;

                    default:
                        System.out.println("Opción incorrecta");
                }


            } catch(Exception e){

                System.out.println("Error: Debe ingresar un número");
                sc.nextLine();

            }


        }while(opcion !=4);


    }

public static void registrar(){


    try{

        System.out.println("Tipo de personaje:");
        System.out.println("1. Guerrero");
        System.out.println("2. Mago");

        int tipo=sc.nextInt();


        System.out.print("Ingrese ID:");
        int id=sc.nextInt();


        sc.nextLine();

        System.out.print("Ingrese nombre:");
        String nombre=sc.nextLine();


        System.out.print("Ingrese nivel:");
        int nivel=sc.nextInt();



        if(id<=0 || nombre.isEmpty() || nivel<1 || nivel>100){

            System.out.println("Datos inválidos");
            return;

        }


        Personaje p;


        if(tipo==1){

            p=new Guerrero(id,nombre,nivel);

        }else if(tipo==2){

            p=new Mago(id,nombre,nivel);

        }else{

            System.out.println("Tipo incorrecto");
            return;
        }



        personajes.add(p);

        System.out.println("Personaje registrado correctamente");


    }catch(Exception e){

        System.out.println("Error en los datos ingresados");
        sc.nextLine();

    }

}

public static void mostrar(){


    if(personajes.isEmpty()){

        System.out.println("No existen personajes registrados");
        return;

    }


    for(Personaje p: personajes){

        p.mostrarInfo();

        System.out.println("Acción: " + p.realizarAccion());

        System.out.println("----------------");

    }

}

public static void buscar(){


    System.out.print("Ingrese id a buscar: ");

    int id=sc.nextInt();



    for(Personaje p: personajes){


        if(p.getId()==id){


            p.mostrarInfo();

            System.out.println("Acción: "+p.realizarAccion());

            return;

        }

    }

    System.out.println("Personaje no encontrado");
}

}