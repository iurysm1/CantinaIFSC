package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Compra;
import model.bo.Produto;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(ItemCompra.class)
public class ItemCompra_ { 

    public static volatile SingularAttribute<ItemCompra, Compra> compra;
    public static volatile SingularAttribute<ItemCompra, Produto> produto;
    public static volatile SingularAttribute<ItemCompra, Float> qtdproduto;
    public static volatile SingularAttribute<ItemCompra, Integer> id;
    public static volatile SingularAttribute<ItemCompra, String> status;

}