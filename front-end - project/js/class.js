class Product{
    constructor(listaPrateleiras, discountValue,iva,pvp){
        this.listaPrateleiras=listaPrateleiras;
        this.discountValue=discountValue; 
        this.iva=iva; 
        this.pvp=pvp;  
    }
}
class Shelf{
    constructor(capacity,rentPrice,productId){
        this.capacity=capacity; 
        this.rentPrice=rentPrice; 
        this.productId=productId;  
    }
}

