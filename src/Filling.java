

public class Filling {
    public int board_size;
    public int occupiedX, occupiedY;
    public int dline,dcol;
    public int startLine,startCol,endLine,endCol;
    private int[][] gameBoard;
    private enum  Pos {UL,UR,LL,LR};
    private StringBuilder sb;

    public static void main(String args[]){

        if(args.length ==3){
            int initSize=Integer.parseInt(args[0]);
            if(initSize%2 ==0){
                int dx = Integer.parseInt(args[1]);
                int dy = Integer.parseInt(args[2]);
                Filling fillingGame = new Filling(initSize,dx,dy);
                fillingGame.init_board();
                fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
                System.out.println(fillingGame.toString());
            }
        }
        else {
            System.out.println("Invalid number of arguments ");
        }
    }
    //Constructor
    public Filling(int board_size, int dx, int dy)
    {
        this.board_size = board_size;
        this.startLine=0;
        this.startCol=0;
        this.endLine=startLine+board_size-1;
        this.endCol=startCol+board_size-1;
        this.dcol= dx;
        this.dline = yLine(dy);
        sb=new StringBuilder();
    }

    public void init_board(){
        gameBoard = new int[board_size][board_size];
        for(int i = 0; i< gameBoard.length; i++){
            for(int j = 0; j< gameBoard[i].length; j++){
                gameBoard[i][j]=0;
            }
        }
        //set up the deficient square
        gameBoard[dline][dcol]=8;
        System.out.println(toString());
    }

    public void evaluation(int board_size, int ulx,int uly,int dline, int dcol)
    {
        String sector = findSector(board_size,ulx,uly,dline,dcol);
        //base case
        if (board_size == 2) {
            switch (Pos.valueOf(sector)) {
                case UL:
                    sb.append(" LR(4)    ");
                    sb.append(colX(dcol)+1).append(" ").append(yLine(dline)).append(" \n");
                    gameBoard[ulx][uly+1]=4;
                    gameBoard[ulx+1][uly]=4;
                    gameBoard[ulx+1][uly+1]=4;
                    break;
                case UR:
                    sb.append(" LL(3)    ");
                    sb.append(colX(dcol)).append(" ").append(yLine(dline)).append(" \n");
                    gameBoard[ulx][uly]=3;
                    gameBoard[ulx+1][uly]=3;
                    gameBoard[ulx+1][uly+1]=3;
                    break;
                case LL:
                    sb.append(" UR(2)    ");
                    sb.append(colX(dcol)+1).append(" ").append(yLine(dline)+1).append(" \n");
                    gameBoard[ulx][uly]=2;
                    gameBoard[ulx][uly+1]=2;
                    gameBoard[ulx+1][uly+1]=2;
                    break;
                case LR:
                    sb.append(" UL(1)    ");
                    sb.append(colX(dcol)).append(" ").append(yLine(dline)+1).append(" \n");
                    gameBoard[ulx][uly]=1;
                    gameBoard[ulx][uly+1]=1;
                    gameBoard[ulx+1][uly]=1;
                    break;
            }
        }
        else{
            int split = board_size/2;
            //place a middle tromino
            switch(Pos.valueOf(sector)){
                case UL:
                    sb.append("Place LR(4) in the middle, at:");
                    sb.append(ulx+split).append(uly+split).append("\n");
                    gameBoard[ulx+split-1][uly+split]=4;
                    gameBoard[ulx+split][uly+split-1]=4;
                    gameBoard[ulx+split][uly+split]=4;
                    System.out.println(this.toString());
                    //ul partition
                    evaluation(split,ulx,uly,dline,dcol);
                    //ur partition
                    evaluation(split,ulx,uly+split,ulx+split-1,uly+split);
                    //ll partition
                    evaluation(split,ulx+split,uly,ulx+split,uly+split-1);
                    //lr partition
                    evaluation(split,ulx+split,uly+split,ulx+split,uly+split);
                    break;
                case UR:
                    sb.append("Place LL(3) in the middle, at:");
                    sb.append(ulx+split).append(uly+split).append("\n");
                    gameBoard[ulx+split-1][uly+split-1]=3;
                    gameBoard[ulx+split][uly+split-1]=3;
                    gameBoard[ulx+split][uly+split]=3;
                    System.out.println(this.toString());
                    //ul partition
                    evaluation(split,ulx,uly,ulx+split-1,uly+split-1);
                    //ur partition
                    evaluation(split,ulx,uly+split,dline,dcol);
                    //ll partition
                    evaluation(split,ulx+split,uly,ulx+split,uly+split-1);
                    //lr partition
                    evaluation(split,ulx+split,uly+split,ulx+split,uly+split);
                    break;
                case LL:
                    sb.append("Place UR(2) in the middle, at:");
                    sb.append(ulx+split).append(ulx+split).append("\n");
                    gameBoard[ulx+split-1][uly+split-1]=2;
                    gameBoard[ulx+split-1][uly+split]=2;
                    gameBoard[ulx+split][uly+split]=2;
                    System.out.println(this.toString());
                    //ul partition
                    evaluation(split,ulx,uly,ulx+split-1,uly+split-1);
                    //ur partition
                    evaluation(split,ulx,uly+split,ulx+split-1,uly+split);
                    //ll partition
                    evaluation(split,ulx+split,uly,dline,dcol);
                    //lr partition
                    evaluation(split,ulx+split,uly+split,ulx+split,uly+split);
                    break;
                case LR:
                    sb.append("Place UL(1) in the middle, at:");
                    sb.append(ulx+split).append(ulx+split).append("\n");
                    gameBoard[ulx+split-1][uly+split-1]=1;
                    gameBoard[ulx+split-1][uly+split]=1;
                    gameBoard[ulx+split][ulx+split-1]=1;
                    System.out.println(this.toString());
                    //ul partition
                    evaluation(split,ulx,uly,ulx+split-1,uly+split-1);
                    //ur partition
                    evaluation(split,ulx,uly+split,ulx+split-1,uly+split);
                    //ll partition
                    evaluation(split,ulx+split,uly,ulx+split,uly+split-1);
                    //lr partition
                    evaluation(split,ulx+split,uly+split,dline,dcol);
                    break;
            }
        }
    }



    private int colX(int colOrX){
        return colOrX;
    }

    private int yLine(int yOrLine){
        return this.board_size-yOrLine-1;
    }

    private String findSector(int size, int startLine, int startCol,int dline,int dcol){
        int boundaryLine = startLine+size/2;
        int boundaryCol =startCol+size/2;
        String sector = null;

        if(dline<boundaryLine && dcol <boundaryCol){
            // upper left
            sector="UL";
        }
        else if(dline <boundaryLine && dcol>=boundaryCol) {
            //upper right
            sector = "UR";
        }
        else if(dline >= boundaryLine && dcol <boundaryCol){
            // lower left
            sector = "LL";
        }
        else if (dline >=boundaryLine && dcol>=boundaryCol){
            //lower right
            sector= "LR";
        }
        return sector;
    }

    @Override
    public String toString()
        {
            StringBuilder builder = new StringBuilder();
            for(int i=0;i<gameBoard.length;i++){
                for(int j=0;j<gameBoard[i].length;j++){
                    builder.append(gameBoard[i][j]);
                    builder.append(" ");
                }
                builder.append("\n");
            }
            return builder.toString()+sb.toString();
        }
    }

