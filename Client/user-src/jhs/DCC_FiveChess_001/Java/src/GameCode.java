/**
 * 已存在的代码请不要修改,你可以调用的方法有以下几个:
 * 
 * 在横坐标为X,纵坐标为Y的位子落子
 * void Game.play(int x,int y);    
 * 
 * 得到自己的状态,1为你落子,2为等待对方落子
 * int Game.getState();
 * 
 * 得到当前棋盘,是一个数组
 * int[][] Game.getChessboard();
 * 
 * 
 * 主程序将以线程的方式启动你的代码,你需在while(true)中添加你的AI代码.
 * 你也可以在while(true)之外,run()之中添加你的代码,该代码我们成为 "初始代码".
 * 你可以不用考虑你的程序的执行时间.
 * 当然你也可以考虑执行时间.
 * 主程序将在规定的时间到达后自动停止线程.
 * 
 * 主程序将在以下几种情况调用你的代码(你的"初始代码"只有在这种情况下将被执行):
 * 1):在双方都准备后,主程序自动开始游戏
 * 2):你的一次 "游戏操作" 超过规定时间后,程序将终止你的线程.在下一次启动线程时.
 *
 * 当然,以下几种情况是允许的:
 * 1)在该类中添加不与run方法重名的方法.
 * 2)编写自己的类,在该类中引用.
 */
public class GameCode extends Thread{
    @Override
    public void run() {
        System.out.println("1");
    }
}a
