import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
public class MenuCreator {
	private int size;
	private int option;
	private String[] menu;
	private int[] states;
	public MenuCreator(int size){
		this.size = size;
		this.menu = new String[this.size];
		this.states = new int[this.size];
	}
	public void addOption(String option_name,int state_num){
		try{
			
			for(int i = 0; i <= menu.length; i++){
				if(menu[i] == null){
					menu[i] = option_name;
					states[i] = state_num;
					break;
				}
			}
		}
		catch(ArrayIndexOutOfBoundsException e){}
		
	}
	public void chooseOption(StateBasedGame sbg,Input input,int key1,int key2,int key3){
		if(input.isKeyPressed(key1)){
			option--;
			if(option < 0){
				option = states.length;
			}
		}
		if(input.isKeyPressed(key2)){
			if(option >= states.length){
				option = 0;
			}
			else{
				option++;
			}
		}
		if(input.isKeyDown(key3)){
			sbg.enterState(states[option]);
		}
		//System.out.println(states[option]);
	}
	public String getStateName(int state_num){
		try{
			return menu[state_num];
		}
		catch(ArrayIndexOutOfBoundsException e){
			return "Böyle bir menü yok.";
		}
	}
	public String currentState(){
		return menu[option];
	}
}
