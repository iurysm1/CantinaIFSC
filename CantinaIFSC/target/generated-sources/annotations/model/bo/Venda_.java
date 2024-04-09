package model.bo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.bo.Carteirinha;
import model.bo.Funcionario;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2024-04-01T20:12:33")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, String> obeservacao;
    public static volatile SingularAttribute<Venda, String> datahoravenda;
    public static volatile SingularAttribute<Venda, String> flagtipodesconto;
    public static volatile SingularAttribute<Venda, Integer> id;
    public static volatile SingularAttribute<Venda, Funcionario> funcionario;
    public static volatile SingularAttribute<Venda, Carteirinha> carteirinha;
    public static volatile SingularAttribute<Venda, Float> valordesconto;
    public static volatile SingularAttribute<Venda, String> status;

}