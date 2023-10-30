package layout;


import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

public interface LayoutComponent {
    String getComponentName();
    Point getLocation();
    Dimension getSize();
}
