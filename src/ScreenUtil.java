import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ScreenUtil {

    /** 取色
     * @param path 图片路径
     * @param x X坐标
     * @param y Y坐标
     * @return 色值
     */
    public static String getColor(String path, int x, int y){
        try {
            BufferedImage bufferedImage = ImageIO.read(new File(path));
            int color = bufferedImage.getRGB(x, y);
            int red = (color & 0xff0000) >> 16;
            int green = (color & 0xff00) >> 8;
            int blue = color & 0xff;
            bufferedImage.flush();
            return red + "," + green + "," + blue;
        }catch (IOException e){
            e.printStackTrace();
            return "-1,-1,-1";
        }
    }
}
