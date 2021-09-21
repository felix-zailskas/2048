package util.view;

import java.awt.*;

public class ColorCollection {

    // 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048

    public static Color getColor(int x) {
        int idx = (int) (Math.log(x) / Math.log(2));
        return colors[idx % colors.length];
    }

    private static Color[] colors = {
            new Color(255, 0, 0),
            new Color(255, 255, 0),
            new Color(150, 200, 0),
            new Color(128, 255, 0),
            new Color(0, 225, 0),
            new Color(0, 255, 210),
            new Color(0, 102, 204),
            new Color(0, 0, 200),
            new Color(205, 0, 205),
            new Color(255, 50, 150),
            new Color(255, 51, 51),
    };
}
