class Board {
    public static final int HEIGHT = 40;
    public static final int WIDTH = 10;

    private final int width;

    final boolean[] board;

    public Board(){
        board = new boolean[HEIGHT * WIDTH];
        width = WIDTH;
    }

    public Board(int width, int height){
        if(width > 0 && height > 0){
            board = new boolean[height * width];
            this.width = width;
        }else{
            board = new boolean[HEIGHT * WIDTH];
            this.width = WIDTH;
        }
    }

    public boolean getValue(int x, int y){
        int index = index(x, y);
        if(index >= board.length || index < 0)
            throw new IndexOutOfBoundsException("Can't access this index");
        return board[index];
    }

    public void setValue(int x, int y, boolean value){
        int index = index(x, y);
        if(index >= board.length || index < 0)
            throw new IndexOutOfBoundsException("Can't access this index");
        board[index] = value;
    }

    private int index(int x, int y) {
        return y*width + x;
    }
}

