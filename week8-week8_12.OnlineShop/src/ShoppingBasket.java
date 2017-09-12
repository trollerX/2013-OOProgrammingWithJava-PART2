
import java.util.HashMap;
import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Karma
 */
public class ShoppingBasket {

    private Map<String, Purchase> basket;

    public ShoppingBasket() {
        this.basket = new HashMap<String, Purchase>();
    }

    public void add(String product, int price) {
        if (basket.containsKey(product)) {
            basket.get(product).increaseAmount();
        } else {
            basket.put(product, new Purchase(product, 1, price));
        }
    }

    public int price() {
        int price = 0;
        for (String product : basket.keySet()) {
            price += basket.get(product).price();
        }
        return price;
    }

    public void print() {
        for (String product : basket.keySet()) {
            System.out.println(basket.get(product));
        }

    }

}
