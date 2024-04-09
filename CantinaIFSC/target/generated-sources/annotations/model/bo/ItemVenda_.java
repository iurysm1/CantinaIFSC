package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Produto;
import model.bo.Venda;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(ItemVenda.class)
public class ItemVenda_ { 

    public static volatile SingularAttribute<ItemVenda, Venda> venda;
    public static volatile SingularAttribute<ItemVenda, Produto> produto;
    public static volatile SingularAttribute<ItemVenda, Integer> qtdproduto;
    public static volatile SingularAttribute<ItemVenda, Integer> id;
    public static volatile SingularAttribute<ItemVenda, String> status;

}