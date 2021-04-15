import java.util.*;

/**
 * A classe <b>LotoCard</b> representa a classe principal de todo o jogo.
 * @author Henrique Teotónio
 * @version 1.0
 */

public class LotoCard
{
    Random randNum = new Random();
    int[][] numberCard = new int[3][9];
   /**
    * Ferramenta de scanner
    */
    
    public static Scanner scanner = new Scanner(System.in);
    
   /**
    * Metodo que permite gerar o cartão
    */
    public LotoCard()
    {
    
        Random rand = new Random();
        for(int i = 0; i< numberCard.length; i++){
        for(int j = 0; j < 5; j++){
            int x = rand.nextInt(89) + 1;
            while(numberCard[i][x / 10] !=0) {
                x = rand.nextInt(89) + 1;
            }  
            numberCard[i][x / 10] = x;
        }
    }
    } 
    /**
     * Gerador de numeros random
     * @param min Numero minimo no intervalo de numeros random
     * @param max Numero maximo no intervalo de numeros random
     * @return 
     */
   private int randInt(int min, int max) 
{
    int random;
    random = randNum.nextInt(max - min) + min;
    return random;
}

   /**
    * Classe utlizada para imprimir o cartao
    * @return 
    */
   
    private String printNumCard()
{
    String string = "";
    System.out.println("             *|LOTO CARD|*");
    for(int row = 0; row < numberCard.length; row++)
    {
        for(int col = 0; col < numberCard[row].length; col++)
        {
            System.out.print(numberCard[row][col] + " | ");
        }
        System.out.println();
    }
   menu2();
    
    return string;
    
 }
    /**
     * Classe main que executa o menu
     * @param args 
     */
    public static void main(String[] args)
    {
        new LotoCard().menu();
    } 
    
   
    //Metodo exit
    private void exitMenu() {
        System.exit(0);
    }
    
    /**
     * A classe check() sorteia o numero e verifica se há linhas completas.
     */
    void check() {
       
        Random rand = new Random();
        int n = rand.nextInt(90)+1;
        System.out.println("O numero sorteado é: " + n);
        
        
        for(int i = 0; i<3; i++) {
            for(int j=0;j<9; j++) {
                if(numberCard[i][j] == n) {
                    numberCard[i][j] = -1;
                    System.out.println("O Número " + n + " encontra-se no cartao! Foi substituido por -1!");
                    
                
            } 
        }       
            
    }
        int counter = 0;
        for(int e=0;e<9; e++) {
               
                if(numberCard[0][e] == -1) {
                    counter++;
            }
        } 
        
        if (counter == 5) {
            System.out.println("Primeira linha completa!");
        }
        
        int counter1 = 0;
        for(int z=0;z<9; z++) {
               
            if(numberCard[1][z] == -1) {
                counter1++;
        }
            
        
        }
        if (counter1 == 5) {
            System.out.println("Segunda linha completa!");
            
        }
        
        int counter2 = 0;
        for(int a=0;a<9; a++) {
               
                if(numberCard[2][a] == -1) {
                    counter2++;
        }
    }
        
        if (counter2 == 5) {
            System.out.println("Terceira linha completa!");
    }
        menu2();
    } 
    
   /**
    * O metodo lotocheck() verifica se o jogador consegiu ou não terminar o jogo fazendo loto.
    */
    void lotocheck() {
        int counter = 0;
        
        for(int i = 0; i<3; i++) {
            for(int j=0;j<9; j++) {
                if(numberCard[i][j] == -1) {
                    counter++;
                    
            }       
    } 
        } 
        
        if (counter == 15){
                menuVencedor();
                    
        } else {
                System.out.println("Ainda não ganhou! Continue a jogar.");
                    menu2();
                }
        }
    /**
     * O metodo menu() cria o menu inicial do jogo
     */
    void menu() {
        System.out.println("******************************************");
        System.out.println("                LOTO");
        System.out.println("******************************************");
        System.out.println("* 1) Criar cartao de loto");
        System.out.println("* 9) Sair ");
        System.out.println("******************************************");
        System.out.println("");
        System.out.println("Selecionar uma opcao do menu: ");
    
        int choice = scanner.nextInt();

        if(choice == 1){
            printNumCard();
        }
      
        if(choice == 9){
            exitMenu();
        } else {
            System.out.println("Valor invalido");
            menu();
        }

}
    /**
     * O metodo menuVencedor() cria um menu apos o utilizador vencer o jogo.
     */
    void menuVencedor() {
        System.out.println("");
        System.out.println("Parabéns! Ganhou o jogo!");
        System.out.println("* 1) Jogar novamente");
        System.out.println("* 9) Sair");
    
         int choice = scanner.nextInt();
    
        if (choice == 1) {
            new LotoCard().menu();
            
        }
        
       
        if (choice == 9) {
            exitMenu();
        }
        
        else {
            System.out.println("Valor inválido");
            menuVencedor();
        }
    }
    
    /**
     * Metodo utlizado para criar menu apoós a criação do cartão
     */
    void menu2() {
        
        System.out.println("");
        System.out.println("* 1) Ver o cartao");
        System.out.println("* 2) Sortear numero");
        System.out.println("* 3) Verificar LOTO");
        System.out.println("* 9) Sair ");
        System.out.println("Selecionar uma opcao do menu: ");
    
    int choice = scanner.nextInt();

        if(choice == 1){
            printNumCard();
        }
        if( choice == 2){
            check();
            
        }
        if (choice == 3) {
            lotocheck();
        }
        
        if(choice == 9){
            exitMenu();
        }
        else {
            System.out.println("Valor inválido");
            menu2();
        }
    }
}
