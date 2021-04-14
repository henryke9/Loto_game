import java.util.*;


public class LotoCard
{
    Random randNum = new Random();
    int[][] numberCard = new int[3][9];
    public static Scanner scanner = new Scanner(System.in);
    
   
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
    //Numeros random
   private int randInt(int min, int max) 
{
    int random;
    random = randNum.nextInt(max - min) + min;
    return random;
}

    // Imprimir cartao
    public String printNumCard()
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

    public static void main(String[] args)
    {
        new LotoCard().menu();
    } 
    
   
    //Metodo exit
    private void exitMenu() {
        System.exit(0);
    }
    
    //Metodo verificar linha completa + sorteio
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
    
    //Metodo verificar vitoria
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
        }

}
    
    void menuVencedor() {
        System.out.println("");
        System.out.println("Parabéns! Ganhou o jogo!");
        System.out.println("* 1) Continuar com o mesmo cartão");
        System.out.println("* 2) Criar novo cartão");
        System.out.println("* 9) Sair");
    
         int choice = scanner.nextInt();
    
        if (choice == 1) {
            
        }
        
        if (choice == 2) {
            printNumCard();
        }
        if (choice == 9) {
            exitMenu();
        }
    }
    
    
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
    }
}
