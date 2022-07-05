import java.util.Scanner;

public class PaseoDelCaballo {
    public static void main(String[]arg)
    {   heuristica();
        PaseoDelCaballo Paseo = new PaseoDelCaballo();
        Paseo.Procedimiento();
        
        
    }
    
    private static final int N = 8; // Declaro N como constante para que no pueda ser modificada
    private int tablero[][];
    
 
    public PaseoDelCaballo()
    {
        tablero = new int[N][N];
    }
    
    public static void heuristica(){ // IMPRIME LA HEURISTICA DEL PASO
        final int ACCESO[][] = {{2,3,4,4,4,4,3,2},{3,4,6,6,6,6,4,3},{4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},
        {4,6,8,8,8,8,6,4},{4,6,8,8,8,8,6,4},{3,4,6,6,6,6,4,3},{2,3,4,4,4,4,3,2}};
        System.out.print("Heurista de accesibilidad dependiendo de la posicion:\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++){
                System.out.print("  " + ACCESO[i][j]);}
            System.out.println();}
    
    }


private boolean dentro(int x, int y){ // EVALUAR QUE NO SALGA DEL RANGO DEL TABLERO {
       if (x >= 0 && x < N && y >= 0 && y < N && tablero[x][y] == -1)
        return true;
        return false; }

 
private void imprimir(){//IMPRIME EL PASEO RECORRIDO {
        for (int x = 0 ; x < N; x++) {
            for (int y = 0; y < N; y++){
                System.out.print("  " + tablero[x][y]);}
            System.out.println();}
    }
 
    private boolean Movimiento(int columnas, int filas, int mover, int moverColumna[], int moverFila[]){
       // SecureRandom termino = new SecureRandom();
      //  int casilla = termino.nextInt(7);
        int siguiente_c, siguiente_f;
        if (mover == N * N)  // 
            return true;
 
        for (int k = 0; k < N; k++){
            siguiente_c = columnas + moverColumna[k];
            siguiente_f = filas + moverFila[k];
            if (dentro(siguiente_c, siguiente_f)){
                tablero[siguiente_c][siguiente_f] = mover;
            if (Movimiento(siguiente_c, siguiente_f, mover + 1, moverColumna, moverFila))
                return true;
                else
                    tablero[siguiente_c][siguiente_f] = -1;}
        }
        return false;
    }
 
    public boolean Procedimiento() {
        int moverColumna[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int moverFila[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        Scanner sc = new Scanner(System.in);
        System.out.printf("Digite el numero de columna (0-7): ");
        int columnas = sc.nextInt();
        System.out.printf("Digite el numero de fila (0-7): ");
        int filas = sc.nextInt();
        System.out.print("\n\n");
        tablero[columnas][filas] = 0;
        Movimiento(columnas, filas, 3, moverColumna, moverFila);
        sc.close();
        
        for (int x = 0; x < N; x++){
            for (int y = 0; y < N; y++){ tablero[x][y] = -1; }
        }
        
        tablero[0][0] = 0;
        if (!Movimiento(0, 0, 1, moverColumna, moverFila)){
            System.out.println("*******E R R O R********");
            return false; }

        else{   imprimir();}
        return true; }
 
    
    
}
