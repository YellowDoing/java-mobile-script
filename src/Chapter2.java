import java.util.Timer;
import java.util.TimerTask;

public class Chapter2 {

    /**
     * (三)场景分类：颜色对比法
     *
     * 注意：本脚本使用的手机是1920x1080分辨率。不同分辨率，不同手机，取到的坐标和色值可能都不一样。
     */
    public static void main(String[] args) {

        //定时器
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                //手机截屏保存到指定路径
                TerminalUtil.exec("adb shell screencap -p /sdcard/wechat.png");
                //把图片上传到电脑桌面
                String filePath = "C:\\Users\\syl\\Desktop\\wechat.png";
                TerminalUtil.exec("adb pull sdcard/wechat.png " + filePath);

                //特征点的色值
                String color = "7,193,96";


                if (color.equals(ScreenUtil.getColor(filePath, 128, 1817))) {
                    System.out.println("当前微信页面是:微信");
                } else if (color.equals(ScreenUtil.getColor(filePath, 403, 1839))) {
                    System.out.println("当前微信页面是:通讯录");
                } else if (color.equals(ScreenUtil.getColor(filePath, 691, 1831))) {
                    System.out.println("当前微信页面是:发现");
                } else if (color.equals(ScreenUtil.getColor(filePath, 944, 1839))) {
                    System.out.println("当前微信页面是:我");
                }

            }
        }, 0, 1000);

        //取消计时
        //timer.cancel();
    }

}
