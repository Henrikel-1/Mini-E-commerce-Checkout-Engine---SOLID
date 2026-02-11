package domain;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> shoppingCart = new ArrayList<>();

    public List<CartItem> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<CartItem> carrinho) {
        this.shoppingCart = carrinho;
    }

    public void addProduct(CartItem cartItem){
        shoppingCart.add(cartItem);
    }

    public void removeProduct(CartItem cartItem){
        shoppingCart.removeIf(item -> item.equals(cartItem));
    }

    public boolean update(CartItem oldCartItem, CartItem newCartItem){
        int index = shoppingCart.indexOf(oldCartItem);

        if (index != -1) {
            shoppingCart.set(index, newCartItem);
            return true;
        }

        return false;
    }
}
