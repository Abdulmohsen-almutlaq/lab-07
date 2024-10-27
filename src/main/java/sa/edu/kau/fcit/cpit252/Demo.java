package sa.edu.kau.fcit.cpit252;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Demo {
    private static String[] elements = new String[]{"Tree", "Palm", "Cloud", "Flower"};
    private JPanel panel;
    private JFrame frame;

    public Demo() {

        // the GUI
        this.frame = new JFrame();
        this.frame.setTitle("Flyweight images");
        this.frame.setSize(800, 600);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel();
        this.frame.add(panel);
        this.frame.setVisible(true);
    }

    public void addImage(ImageIcon img, int x, int y) {
        // add Image but x and y are external we are not storing it in the flyweight
        JLabel label = new JLabel();
        label.setIcon(img);
        System.out.println("Adding image icon " + img.getDescription());
        System.out.println(String.format("Location (%d,%d)", x, y));
        label.setLocation(x, y);
        this.panel.add(label);
        this.panel.revalidate();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        ImageElementsFactory factory = new ImageElementsFactory();
        // to get the images

        // to  store IMAGE element
        List<ImageElement> elementList = new ArrayList<ImageElement>();

        System.out.println(
                "Number of flyweights: " +
                        factory.numberOfFlyweights());

        Random r = new Random();
        for (int i = 0; i < 10000; i++) {
            // randomly select images
            String name = elements[r.nextInt(elements.length)] + ".png";
            ImageElement e = factory.getFlyweight(name); // we use flyweight if dosen't exist we add it
            elementList.add(e);// here we add it to the list so we can display it

            try {
                System.out.println("Image: " + e.getImageElement().toString());
                demo.addImage(e.getImageElement(), 200 * i, 200 * i);
            } catch (FileNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        }

        int j = 0;

        for (ImageElement l : elementList) {
            System.out.println(l.myPosition(j++));
        }

        System.out.println(
                "Number of flyweights: " +
                        factory.numberOfFlyweights());
    }
}
