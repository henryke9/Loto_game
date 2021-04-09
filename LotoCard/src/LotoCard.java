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
   menu();
    
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
      
        menu();
    } 
    
           
    void menu() {
        System.out.println("******************************************");
        System.out.println("                LOTO");
        System.out.println("******************************************");
        System.out.println("* 1) Create a Loto card");
        System.out.println("* 2) Draw a number");
        System.out.println("* 3) Check Loto card");
        System.out.println("* 9) Exit ");
        System.out.println("******************************************");
        System.out.println("");
        System.out.println("Select a menu option: ");
    
    int choice = scanner.nextInt();

        if(choice == 1){

            printNumCard();
        }
        if( choice == 2){
            
            
        }
        if(choice == 3){
            check();
        }
        if(choice == 9){
            exitMenu();
        }

}
}
