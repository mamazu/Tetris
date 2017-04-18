public class FileHandler{
	private ArrayList<String> content = new ArrayList<String>();

	public FileHandler(String filename){
		try{
			BufferedReader br = new BufferedReader(new Filereader(filename));
		}catch(Execption e)
			return;
		}
		load(br)
	}

	private void load(BufferedReader br){};

	public String[] getContent(){ return content; }
	public void appendContent(String content){
		this.content.append(content);
	}

	public int getLineCount(){ return content.size(); }
}
