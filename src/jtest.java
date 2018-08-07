@org.testng.annotations.Test
public class jtest {

    public  void test2UL(){
            int initSize=2;
            int dx = 0;
            int dy = 1;
            Filling fillingGame = new Filling(initSize,dx,dy);
            fillingGame.init_board();
            fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
            System.out.println(fillingGame.toString());
        }

    public  void test2UR(){
        int initSize=2;
        int dx = 1;
        int dy = 1;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    }
    public void test2LL(){
        int initSize=2;
        int dx = 0;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    }
    public  void test2LR(){
        int initSize=2;
        int dx = 1;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    }

    public  void test4UL(){
        int initSize=4;
        int dx = 0;
        int dy = 3;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test4UR(){
        int initSize=4;
        int dx = 2;
        int dy = 2;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test4LL(){
        int initSize=4;
        int dx = 0;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test4LR(){
        int initSize=4;
        int dx = 3;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    }
    public  void test8UL(){
        int initSize=8;
        int dx = 0;
        int dy = 7;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test8UR(){
        int initSize=8;
        int dx = 5;
        int dy = 4;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test8LL(){
        int initSize=8;
        int dx = 0;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    } public  void test8LR(){
        int initSize=8;
        int dx = 4;
        int dy = 0;
        Filling fillingGame = new Filling(initSize,dx,dy);
        fillingGame.init_board();
        fillingGame.evaluation(fillingGame.board_size,0,0,fillingGame.dline,fillingGame.dcol);
        System.out.println(fillingGame.toString());
    }
    }







