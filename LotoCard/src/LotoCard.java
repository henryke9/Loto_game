import java.util.*;

public class LotoCard
{
    Random randNum = new Random();
    int[][] numberCard = new int[3][9];
    public static Scanner scanner = new Scanner(System.in);
    
    
    public LotoCard()
    {
    
    for(int i = 0; i < numberCard.length; i++)
    {
    this.numberCard[i][0] = randInt(1, 9);
        
        while(this.numberCard[i][0] != numberCard[i][0])
        {  
            i++;
        }
        if(this.numberCard[i][0] == numberCard[i][0])
        {
            numberCard[i][0] = randInt(1, 9);
        }
    }
    
    for(int j = 0; j < numberCard.length; j++)
    {
        numberCard[j][1] = randInt(10, 19);
       }
 
    for(int k = 0; k < numberCard.length; k++)
    {
        numberCard[k][2] = randInt(20, 29);
        }  
     
    for(int m = 0; m < numberCard.length; m++)
    {
        numberCard[m][3] = randInt(30, 39);
       }
    
    for(int n = 0; n < numberCard.length; n++)
    {
        numberCard[n][4] = randInt(40, 49);
        }

   for(int l = 0; l < numberCard.length; l++)
    {
        numberCard[l][5] = randInt(50, 59);
        }
   
   for(int p = 0; p < numberCard.length; p++)
    {
        numberCard[p][6] = randInt(60, 69);
        }
   
   for(int r = 0; r < numberCard.length; r++)
    {
        numberCard[r][7] = randInt(70, 79);
        }
   
   for(int e = 0; e < numberCard.length; e++)
    {
        numberCard[e][8] = randInt(80,90 );
        }
    
//Cinco numeros primeira linha
        Random random0 = new Random();
        int randomLocation = 0;
        
        while (randomLocation < 5) {
            int z0 = random0.nextInt(numberCard.length);
            int b0 = random0.nextInt(numberCard[0].length);
            
            if(numberCard[z0][b0] <= 90) {
                numberCard [0][b0] = 0;
               randomLocation++;
            }
            
            
        }
        //Cinco numeros segunda linha
        Random random1 = new Random();
        int randomLocation1 = 0;
        
        while (randomLocation1 < 5) {
            int z1 = random1.nextInt(numberCard.length);
            int b1 = random1.nextInt(numberCard[0].length);
            
            if(numberCard[z1][b1] <= 90) {
                numberCard [1][b1] = 0;
               randomLocation1++;
            }
          
        }
        //Cinco numeros terceira linha
        Random random2 = new Random();
        int randomLocation2 = 0;
        
        while (randomLocation2 < 5) {
            int z2 = random2.nextInt(numberCard.length);
            int b2 = random2.nextInt(numberCard[0].length);
            
            if(numberCard[z2][b2] <= 90) {
                numberCard [2][b2] = 0;
                randomLocation2++;
            }
          
        }
       
        }
   
         
    
       
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
        
        //LotoCard bc = new LotoCard();
        //bc.printNumCard();

    } 
    
   
    
    private void exitMenu() {
        System.exit(0);
    }
    
    


        
    
    
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
