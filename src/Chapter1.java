public class Chapter1 {

    public static void main(String[] args) {
        //启动微信
        TerminalUtil.exec("adb shell am start com.tencent.mm/com.tencent.mm.ui.LauncherUI");
        //点击第一个好友
        TerminalUtil.exec("adb shell input tap 433 221");
        //点击输入框
        TerminalUtil.exec("adb shell input tap 537 1840");
        //输入Java
        TerminalUtil.exec("adb shell input text \"Java\"");
        //点击发送按钮
        TerminalUtil.exec("adb shell input tap 975 1048");
    }


}
