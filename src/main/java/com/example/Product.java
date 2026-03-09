//____________________________________________________________________________________________
//                              File Description: 

//          Interface for handling product data storage and retrieval operations
//____________________________________________________________________________________________

package com.example;


public class Product
{
    private final int   id;
    private String      title;
    private String      description;
    private double      price;
    private double      biddingPrice;
    private int         sellerId;  // FK to User


    public Product(int id, String title, String description,double price, double biddingPrice, int sellerId)
    {
        this.id             = id;
        this.title          = title;
        this.description    = description;
        this.price          = price;
        this.biddingPrice   = biddingPrice;
        this.sellerId       = sellerId;
    }


    public int getId()              { return id;            }
    public String getTitle()        { return title;         }
    public String getDescription()  { return description;   }
    public double getPrice()        { return price;         }
    public double getBiddingPrice() { return biddingPrice;  }
    public int getSellerId()        { return sellerId;      }


    @Override
    public String toString()
    { 
        return  "Product{id="   + id + 
                ", title='"     + title +
                '\''+
                ", price="      + price + 
                ", sellerId="   + sellerId + '}';
    }
}
