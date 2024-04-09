package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Fornecedor;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Compra.class)
public class Compra_ { 

    public static volatile SingularAttribute<Compra, Character> flagtipodesconto;
    public static volatile SingularAttribute<Compra, String> observacao;
    public static volatile SingularAttribute<Compra, Integer> id;
    public static volatile SingularAttribute<Compra, Integer> numeronf;
    public static volatile SingularAttribute<Compra, Fornecedor> fornecedor;
    public static volatile SingularAttribute<Compra, String> datahoracompra;
    public static volatile SingularAttribute<Compra, Float> valordesconto;
    public static volatile SingularAttribute<Compra, String> status;

}