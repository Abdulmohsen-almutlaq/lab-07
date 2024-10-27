package sa.edu.kau.fcit.cpit252;

import java.util.Map;
import java.util.HashMap;

public class ImageElementsFactory {

  private Map<String, ImageElement> flyweights = new HashMap<String, ImageElement>();

  public ImageElement getFlyweight(String name) {
    // return a flyweight if it already exists, otherwise, put it in the map.

    // if there is an image we get it from the hashmap
    if (flyweights.containsKey(name)){
      return flyweights.get(name);
    }
    // if not we
    ImageElement imageElement = new ImageElement(name);
    //and we put it in the hashmap
    flyweights.put(name,imageElement);
    return imageElement;
  }

  public int numberOfFlyweights() {
    // return the size of the
    return flyweights.size();
  }

}
