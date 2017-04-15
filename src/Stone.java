public class Stone{

	public Stone stone;

	public Stone(){
		 stone = new Stone((int) Math.random() * 7);
	}

	public Stone(int h){
		stone = new Stone(h);
	}
}