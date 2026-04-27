import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<Producte,Integer> carrito = new HashMap<>();
    private static final HashMap<String, Producte> magatzem = new LinkedHashMap<>();

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Benvenido al SUPERMERCAT");
            System.out.println("Menu Principal ______________________________________________________________________________");
            System.out.println("  1. Introduir producte                                                                     |");
            System.out.println("  2. Passar por caja                                                                        |");
            System.out.println("  3. Mostrar carro de la compra                                                             |");
            System.out.println("  4. Gestionar Magatzem                                                                     |");
            System.out.println("  0. Acabar                                                                                 |");
            System.out.println("____________________________________________________________________________________________|");


            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> {
                    if (carrito.size()<100) {
                        introduirProdute();
                    }
                    else {System.out.println("El carro està ple. No es poden afegir més de 100 productes.");}
                }
                case 2 -> passarCaja();
                case 3 -> mostrarCarro();
                case 0 -> System.out.println("Saliendo");
                default -> System.out.println("Opcion NO valida");
            }

        } while (opcion != 0);
    }

    public static void introduirProdute() {
        System.out.println("___ Producte ___");
        System.out.println("____________________________________________________________________________________________");
        System.out.println("  1. Alimentacion                                                                           |");
        System.out.println("  2. Textil                                                                                 |");
        System.out.println("  3. Electronics                                                                            |");
        System.out.println("  0. Acabar                                                                                 |");
        System.out.println("____________________________________________________________________________________________|");
        int opcion = Integer.parseInt(sc.nextLine());

        switch (opcion) {
            case 1 -> anadirAlim();
            case 2 -> anadirTextil();
            case 3 -> anadirElec();
            case 0 -> System.out.println("Saliendo");
            default -> System.out.println("Opcion NO valida");
        }

    }

    public static void anadirAlim() {
        System.out.println("El producto ");
        String nom = sc.nextLine();

        System.out.println("El codigo ");
        String codi = sc.nextLine();

        System.out.println("El precio ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("La quantitat ");
        int quantitat = Integer.parseInt(sc.nextLine());

        System.out.println("Fecha de caducidad");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(sc.nextLine(), formatter);

       //exr 3
        carrito.put(new Alimentacio(nom, precio, codi, fecha) {
            @Override
            public int compare(Alimentacio o1, Alimentacio o2) {
                return 0;
            }
        }, quantitat);
        System.out.println("El producto " + nom + " añadido");
    }

    public static void anadirTextil() {
        System.out.println("El producto ");
        String nom = sc.nextLine();

        System.out.println("El codigo ");
        String codi = sc.nextLine();

        System.out.println("El precio ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("La quantitat ");
        int quantitat = Integer.parseInt(sc.nextLine());

        System.out.println("La composicion");
        String comp = sc.nextLine();

        carrito.put(new Textil(nom, precio, codi, comp),quantitat);
        System.out.println("El producto " + nom + " añadido");
    }

    public static void anadirElec() {
        System.out.println("El producto ");
        String nom = sc.nextLine();

        System.out.println("El codigo ");
        String codi = sc.nextLine();

        System.out.println("El precio ");
        double precio = Double.parseDouble(sc.nextLine());

        System.out.println("La quantitat ");
        int quantitat = Integer.parseInt(sc.nextLine());

        System.out.println("Dias de garantia");
        int dias = Integer.parseInt(sc.nextLine());

        carrito.put(new Electronics(nom, precio, codi, dias), quantitat);
        System.out.println("El producto " + nom + " añadido");
    }

    public static void passarCaja() {

        // exr 4
        if (carrito.isEmpty()){
            System.out.println("El carro esta BUID");
            return;
        }
        double[] total = {0};

        System.out.println("_______________________________");
        System.out.println("========= SUPERMERCAT =========");
        System.out.println("-------------------------------");
        System.out.println("Data : " + LocalDate.now());
        System.out.println("-------------------------------");
        System.out.println("Nom      Qnt   Preu U.   Total");

        carrito.forEach((Productes, quantitat)->{
            double totalU = quantitat * Productes.getPreuReal();
            total[0] += totalU;
            System.out.println(Productes.getNom()+"  "+quantitat+"  "+Productes.getPreuBase()+"  "+totalU);
        });
        System.out.println("______________________________");
        double totalf = total[0];
        System.out.println("Total :      " + total[0]);
        System.out.println("______________________________");
        System.out.println();
        carrito.clear();
    }


    // exr 1
    public static void mostrarCarro(){
        System.out.println("===== CARRO DE LA COMPRA ======");
        System.out.println("-------------------------------");

        carrito.forEach((Productes, quantitat)->{

        });
        System.out.println("-------------------------------");
    }

    //exr2
    // he puesto un mètode "equals" y "hash code" in la classe "Producte"

    //exr3
    // he implemntado comparable en la classe Producte con un mètode compaireTo
    // tambien un comparator in la classe Alimentacio

    //exr 5

    public static void PreuInvalidException(Producte p){

        long dies = ChronoUnit.DAYS.between(LocalDate.now(), p.getData);
        if (dies < 0) dies = 0;
        double descompte = p.getPreuBase() * (1.0 / (dies + 1));
        double preuFinal  = Math.max(p.getPreuBase()*(1-descompte),0);

        if (descompte>=100 && preuFinal<=0 ){
            System.out.println("Precio del producto");
        }
    }

    // exr 6
    // he creado un map para que podemos guardar productes de manera ordenada y accedir al producte con su codi de barres
    
}