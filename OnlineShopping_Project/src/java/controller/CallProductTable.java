/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Products;
import model.Shoppingcart;

/**
 *
 * @author aunchisachanatipkul
 */
public class CallProductTable {

    
    public static List<Products> findAllProduct(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        List<Products> pdList = null;
        try{
            pdList = (List<Products>) em.createNamedQuery("Products.findAll").getResultList();
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }finally {
            em.close();
            emf.close();
        }
        return pdList;
    }
    
    public static int findLastestCartID(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        int lastestCartID = 0;
        List<Shoppingcart> shoppingCartList = null;
        try{
            shoppingCartList = (List<Shoppingcart>) em.createNamedQuery("Shoppingcart.findAll").getResultList();
            for(Shoppingcart spCart : shoppingCartList){
                if(spCart.getShoppingcartPK().getCartId() > lastestCartID){
                    lastestCartID = spCart.getShoppingcartPK().getCartId();
                }
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return lastestCartID;
    }

     public static Products findProductByMovie(String movie){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        Products prod = null;
        try{
            prod = (Products) em.createNamedQuery("Products.findByMovie").setParameter("movie", movie).getSingleResult();
        } catch (Exception e){
            throw new RuntimeException(e);
        } finally {
            em.close();
            emf.close();
        }
        return prod;
    }
   
     public static void insertShoppingCart(Shoppingcart shoppingCart){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("OnlineShoppingCartPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(shoppingCart);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

}
