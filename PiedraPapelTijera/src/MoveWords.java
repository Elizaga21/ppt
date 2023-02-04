import java.util.Random;

public class MoveWords{

	static String vs[][] = new String[5][5];

	static final int PIEDRA = 0;

	static final int PAPEL = 1;
	static final int TIJERAS = 2;
	static final int SPOCK = 3;
	static final int LAGARTIJA = 4;

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTIJA", "SPOCK"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }

	private static void setRules() {
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				vs[i][j] = "";
			}
		}

		vs[PIEDRA][TIJERAS] = "crushes";
		vs[PIEDRA][LAGARTIJA] = "crushes";
		vs[PAPEL][PIEDRA] = "covers";
		vs[PAPEL][SPOCK] = "disaproves";
		vs[TIJERAS][PAPEL] = "cuts";
		vs[TIJERAS][LAGARTIJA] = "decapitates";
		vs[SPOCK][PIEDRA] = "vaporizes";
		vs[SPOCK][TIJERAS] = "smashes";
		vs[LAGARTIJA][PIEDRA] = "eats";
		vs[LAGARTIJA][SPOCK] = "poisons";
	}
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    if (first_i == second_i) return EMPATE;
	    
	    return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	}
	
} 
