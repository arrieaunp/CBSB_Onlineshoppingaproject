package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Products;
import model.ShoppingcartPK;

@Generated(value="EclipseLink-2.7.12.v20230209-rNA", date="2023-10-27T20:05:24")
@StaticMetamodel(Shoppingcart.class)
public class Shoppingcart_ { 

    public static volatile SingularAttribute<Shoppingcart, ShoppingcartPK> shoppingcartPK;
    public static volatile SingularAttribute<Shoppingcart, Integer> quantity;
    public static volatile SingularAttribute<Shoppingcart, Products> products;

}