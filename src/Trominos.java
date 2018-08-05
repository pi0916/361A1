public class Trominos {

    private enum Shapes {UL,UR,LL,LR}
    public final int x_pos,y_pos;
    public final int[][] tromino = new int[2][2];

    public Trominos(int x, int y, String shape)
    {
        x_pos=x;
        y_pos=y;
        init_tromino(shape);
    }

    private void init_tromino(String shape)
    {
        Shapes init = Shapes.valueOf(shape);
        switch (init){
            case LL:
                tromino[0][0]=1;
                tromino[0][1]=0;
                tromino[1][0]=1;
                tromino[1][1]=1;
                break;
            case LR:
                tromino[0][0]=0;
                tromino[0][1]=1;
                tromino[1][0]=1;
                tromino[1][1]=1;
                break;
            case UL:
                tromino[0][0]=1;
                tromino[0][1]=1;
                tromino[1][0]=1;
                tromino[1][1]=0;
                break;
            case UR:
                tromino[0][0]=1;
                tromino[0][1]=1;
                tromino[1][0]=0;
                tromino[1][1]=1;
                break;
        }
    }
}
